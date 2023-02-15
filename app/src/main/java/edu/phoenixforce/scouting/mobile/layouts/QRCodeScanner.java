package edu.phoenixforce.scouting.mobile.layouts;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.VIBRATE;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import edu.phoenixforce.scouting.mobile.common.Constants;
import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import eu.livotov.labs.android.camview.ScannerLiveView;
import eu.livotov.labs.android.camview.scanner.decoder.zxing.ZXDecoder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.fyrebirdscout11.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

    public class QRCodeScanner extends AppCompatActivity {
        private ScannerLiveView camera;
        private TextView scannedTV;
        private FloatingActionButton fab;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.qr_code_scanner);
            FloatingActionButton fab = findViewById(R.id.floatingActionButton2);
            final QRCodeScanner thisActivity = this;
            // check permission method is to check that the
            // camera permission is granted by user or not.
            // request permission method is to request the
            // camera permission if not given.
            Log.v("Test1", "Test1");
            if (checkPermission()) {
                // if permission is already granted display a toast message
                Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show();
            } else {
                requestPermission();
            }

            // initialize scannerLiveview and textview.
            scannedTV = findViewById(R.id.idTVscanned);
            camera = (ScannerLiveView) findViewById(R.id.camview);

            camera.setScannerViewEventListener(new ScannerLiveView.ScannerViewEventListener() {
                @Override
                public void onScannerStarted(ScannerLiveView scanner) {
                    // method is called when scanner is started
                    Toast.makeText(QRCodeScanner.this, "Scanner Started", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onScannerStopped(ScannerLiveView scanner) {
                    // method is called when scanner is stopped.
                    Toast.makeText(QRCodeScanner.this, "Scanner Stopped", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onScannerError(Throwable err) {
                    // method is called when scanner gives some error.
                    Toast.makeText(QRCodeScanner.this, "Scanner Error: " + err.getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCodeScanned(String data) {
                    // method is called when camera scans the
                    // qr code and the data from qr code is
                    // stored in data in string format.
                    scannedTV.setText(data);

                    fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            if (ContextCompat.checkSelfPermission(thisActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                                    != PackageManager.PERMISSION_GRANTED) {

                                if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                                    Snackbar.make(fab, "We can't copy the database without permission to store it to your external storage.",
                                            Snackbar.LENGTH_INDEFINITE).setAction("Action", null).show();
                                    // No explanation needed; request the permission
                                    String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                                    ActivityCompat.requestPermissions(thisActivity, permissions, Constants.EXTERNAL_FILE_STORAGE_PERMISSION);

                                } else {
                                    // No explanation needed; request the permission
                                    String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                                    ActivityCompat.requestPermissions(thisActivity, permissions, Constants.EXTERNAL_FILE_STORAGE_PERMISSION);
                                }
                            }
                            else {
                                copyDatabase();
                            }


                        }
                    });

                    }
                    });
                }


        @Override
        protected void onResume() {
            super.onResume();
            ZXDecoder decoder = new ZXDecoder();
            // 0.5 is the area where we have
            // to place red marker for scanning.
            decoder.setScanAreaPercent(0.8);
            // below method will set decoder to camera.
            camera.setDecoder(decoder);
            camera.startScanner();
        }

        @Override
        protected void onPause() {
            // on app pause the
            // camera will stop scanning.
            camera.stopScanner();
            super.onPause();
        }

        private boolean checkPermission() {
            // here we are checking two permission that is vibrate
            // and camera which is granted by user and not.
            // if permission is granted then we are returning
            // true otherwise false.
            int camera_permission = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
            int vibrate_permission = ContextCompat.checkSelfPermission(getApplicationContext(), VIBRATE);
            return camera_permission == PackageManager.PERMISSION_GRANTED && vibrate_permission == PackageManager.PERMISSION_GRANTED;
        }


        private void requestPermission() {
            // this method is to request
            // the runtime permission.
            int PERMISSION_REQUEST_CODE = 200;
            ActivityCompat.requestPermissions(this, new String[]{CAMERA, VIBRATE}, PERMISSION_REQUEST_CODE);
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
            // this method is called when user
            // allows the permission to use camera.
            if (grantResults.length > 0) {
                boolean cameraaccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean vibrateaccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                if (cameraaccepted && vibrateaccepted) {
                    Toast.makeText(this, "Permission granted..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Denied \n You cannot use app without providing permission", Toast.LENGTH_SHORT).show();
                }
            }
        }
        private void copyDatabase() {
            try
            {
                ArrayList<String> finalData = new ArrayList<String>();
                String data = scannedTV.getText().toString();

                String[] dataSets = data.split("]");
                int counter = 1;
                String numEntries = "Skill issue";
                for(String i: dataSets) {
                    if (counter == 1) {
                        numEntries = i;
                    } else {


                        String[] individualNums = i.split(" ");
                        for (String u : individualNums) {
                            u = u.replace("[", "");
                            u = u.replace(",", "");
                            u = u.replace(" ", "");
                            finalData.add(u);

                        }
                    }
                    counter++;
                }
                numEntries = numEntries.replace(" ", "");
                numEntries = numEntries.replace("[", "");
                numEntries = numEntries.replace(",", "");

                ArrayList<String> array1 = new ArrayList<String>();
                ArrayList<String> array2 = new ArrayList<String>();
                ArrayList<String> array3 = new ArrayList<String>();
                ArrayList<String> array4 = new ArrayList<String>();
                ArrayList<String> array5 = new ArrayList<String>();
                ArrayList<String> array6 = new ArrayList<String>();
                ArrayList<String> array7 = new ArrayList<String>();
                ArrayList<String> array8 = new ArrayList<String>();
                ArrayList<String> array9 = new ArrayList<String>();
                ArrayList<String> array10 = new ArrayList<String>();
                ArrayList<ArrayList> finalList = new ArrayList<ArrayList>();



                int e = Integer.valueOf(numEntries);

                for(int i = 0; i < finalData.size(); i++){
                    for(int r = 0; r < e; r++) {
                        if ((i % e) == r) {

                            String sortedData = finalData.get(i);
                            if(r == 1){ array1.add(sortedData); }
                            if(r == 2){ array2.add(sortedData); }
                            if(r == 3){ array3.add(sortedData); }
                            if(r == 4){ array4.add(sortedData); }
                            if(r == 5){ array5.add(sortedData); }
                            if(r == 6){ array6.add(sortedData); }
                            if(r == 7){ array7.add(sortedData); }
                            if(r == 8){ array8.add(sortedData); }
                            if(r == 9){ array9.add(sortedData); }
                            if(r == 10){ array10.add(sortedData); }

                        }
                    }

                }
                Log.d("num", numEntries);
                Log.d("counter", finalData.toString());
                finalList.add(array1);
                finalList.add(array2);
                finalList.add(array3);
                finalList.add(array4);
                finalList.add(array5);
                finalList.add(array6);
                finalList.add(array7);
                finalList.add(array8);
                finalList.add(array9);
                finalList.add(array10);

                String csv = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
                CSVWriter writer = new CSVWriter(new FileWriter(csv));

                writer.writeAll(finalList.get(1));

                writer.close();


            }
            catch (Exception e) {
                Snackbar.make(findViewById(R.id.idTVscanned), "Exception copying data " + e.getMessage(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }


        }
    }

