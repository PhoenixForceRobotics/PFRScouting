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
                //Arraylist for unparsed data to be added to.
                ArrayList<String> finalData = new ArrayList<String>();

                //stores the unparsed data gathered from the QR code.
                String data = scannedTV.getText().toString();

                //Makes the data into a list of strings
                String[] dataSets = data.split("]");
                //Counter is an arbitrary int
                int counter = 1;
                String numEntries = "Shouldn't matter";
                //for loop repeats for the number of entries in the list above
                for(String i: dataSets) {
                    /*makes sure that the loop stops at the first entry to pull the number of matches for
                    later parsing, also is and if statement so the value doesn't get added to the data list*/
                    if (counter == 1) {
                        numEntries = i;
                    } else {

                        String[] individualNums = i.split(" ");
                        //for each string thiis loop just removes all the extraneous characters not necissary for parsing.
                        for (String u : individualNums) {
                            u = u.replace("[", "");
                            u = u.replace(",", "");
                            u = u.replace(" ", "");
                            finalData.add(u);

                        }
                    }
                    counter++;
                }
                //parses the numer of entries data
                numEntries = numEntries.replace(" ", "");
                numEntries = numEntries.replace("[", "");
                numEntries = numEntries.replace(",", "");

                //arraylist to add the data
                ArrayList<ArrayList<String>> arrays =  new ArrayList<ArrayList<String>>();
                //converts the number of matches being tracked into an ninteger.
                int numMatchesTracked = Integer.valueOf(numEntries);

                //fullSize = Repeats a number of times equal to the total size of data
                //finalData = an arraylist of strings including the data devoid of commas etc.
                //int r Repeats for each Match that is tracked
                //lots of logs for debugging, nto necissary.
                int g = finalData.size();
                List<String[]> finalList = new ArrayList<String[]>();
                Log.d("test", Integer.toString(g));

                for(int i = 0; i < numMatchesTracked; i++){
                    arrays.add(new ArrayList<String>());
                }
                Log.d("here", "test1");

                /*essentially this loop sorts each individual piece of data into an arraylist of arraylists
                where the list is the match number the data is from*/
                for(int fullSize = 0; fullSize < finalData.size(); fullSize++){
                   String sortedData = finalData.get(fullSize);
                    Log.d("here", "test2");
                    //fullSize % numMatchesTracked gives what array the current sorted data should be put in
                    for(int i = 0; i < numMatchesTracked; i++){
                        if ((fullSize % numMatchesTracked) == i){
                            arrays.get(i).add(sortedData);
                        }
                    }
                }

                Log.d("here", "testing");

                /*repeats for each mach then converts the respective arraylist into an array which is what
                the csv writer takes*/
                for(int i = 0; i < numMatchesTracked; i++){

                    String[] coolCacheThingyMajig = new String[arrays.get(i).size()];
                    for(int j = 0; j < arrays.get(i).size(); j++){
                        coolCacheThingyMajig[j] = arrays.get(i).get(j);
                    }
                    finalList.add(coolCacheThingyMajig);

                }
                //column names for the csv file so that the data is readable in excel, (added at position 0)
                String[] names = {"Scout", "DevId", "matchNum", "TeamNum", "TeleTopCone", "TeleMidCone", "TeleBottomCone", "TeleTopCube", "TeleMidCube",
                        "TeleBottomCube", "DefenceRating", "AutoMoved", "AutoLeftCommunity", "AutoUnengaged", "AutoEngaged", "TeleUnengaged", "TeleEngaged",
                        "Drove", "Broke", "NoShow", "TBox1", "TBox2", "TBox3", "TBoxFour", "TBoxFive" , "TBoxSix",  "TBoxSeven",
                        "TBoxEight", "TBoxNine", "MBoxOne", "MBoxTwo", "MBoxThree", "MBoxFour", "MBoxFive", "MBoxSix", "MBoxSeven", "MBoxEight", "MBoxNine",
                        "BBoxOne", "BBoxTwo", "BBoxThree", "BBoxFour", "BBoxFive", "BBoxSix", "BBoxSeven", "BBoxEight", "BBoxNine"};
                finalList.add(0, names);
                Log.d("num", numEntries);
                Log.d("counter", finalData.toString());



                //magic library that does conversion from list to csv file for us.
                //path on "Device File Explorer"
                String csv ="/data/data/com.phoenixforce.scouting/data.csv";
                Log.d("test", csv);

                CSVWriter writer = new CSVWriter(new FileWriter(csv));
                //Writes the list of arrays to a file.
                writer.writeAll(finalList);

                writer.close();


            }
            //obvious exception code.
            catch (Exception e) {
                Snackbar.make(findViewById(R.id.idTVscanned), "Exception copying data " + e.getMessage(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Log.d("exception", e.getMessage());
            }


        }
    }

