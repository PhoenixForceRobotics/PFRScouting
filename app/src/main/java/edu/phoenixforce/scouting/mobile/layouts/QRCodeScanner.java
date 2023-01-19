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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

    public class QRCodeScanner extends AppCompatActivity {
        private ScannerLiveView camera;
        private TextView scannedTV;
        private FloatingActionButton fab;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.qr_code_scanner);
            FloatingActionButton fab = findViewById(R.id.fab);
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
                            } else {
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

                File sourceDb = new File(getApplicationContext().getDatabasePath(ScoreDataBase.DBNAME).getAbsolutePath());
                File targetDb = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/"
                        + ScoreDataBase.DBNAME + "_" + Configuration.getInstance().getTbaTeamId() + "_"
                        + Configuration.getInstance().getDeviceId() + ".db");

                FileInputStream fis = new FileInputStream(sourceDb);
                FileOutputStream fos = new FileOutputStream(targetDb);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer))>0){
                    fos.write(buffer, 0, length);
                }

                // Close the streams
                fos.flush();
                fos.close();
                fis.close();

                Snackbar.make(this.findViewById(R.id.fab), "Copy complete.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
            catch (Exception e) {
                Snackbar.make(findViewById(R.id.fab), "Exception copying data " + e.getMessage(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }


        }
    }

