package edu.phoenixforce.scouting.mobile.layouts;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.VIBRATE;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
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
import edu.phoenixforce.scouting.mobile.database.entities.GameData;
import eu.livotov.labs.android.camview.ScannerLiveView;
import eu.livotov.labs.android.camview.scanner.decoder.zxing.ZXDecoder;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;

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
        Button copy;
        Button download;
        Button clear;
        public int numberOfMatches = 0;
        public int currentNumberOfMatches = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.qr_code_scanner);
            copy = findViewById(R.id.copy);
            download = findViewById(R.id.download);
            clear = findViewById(R.id.clear);
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
            clearDatabase();
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
                }
            });
            Context context = this;
            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*
                }
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setCancelable(true);
                    builder.setTitle("Are you sure?");
                    builder.setMessage("This action will delete the stored data on this device");
                    builder.setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {*/

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setCancelable(true);
                    builder.setTitle("Are you sure?");
                    builder.setMessage("This action will clear the database");
                    builder.setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    clearDatabase();
                                }
                            });
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    AlertDialog dialog = builder.create();

                    dialog.show();
                                /*}
                            });
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    AlertDialog dialog = builder.create();

                    dialog.show();
                    */
                }


            });

            copy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setCancelable(true);
                    builder.setTitle("Are you sure?");
                    builder.setMessage("This action will delete the stored data on this device");
                    builder.setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) { */
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setCancelable(true);
                    builder.setTitle("Are you sure?");
                    builder.setMessage("This action will copy the database");
                    builder.setPositiveButton("Confirm",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    copyDatabase();
                                }
                            });
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    AlertDialog dialog = builder.create();

                    dialog.show();

                                /*}
                            });
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    AlertDialog dialog = builder.create();

                    dialog.show();
*/
                }


            });

            download.setOnClickListener(new View.OnClickListener() {
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
                        /*AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                        builder.setCancelable(true);
                        builder.setTitle("Are you sure?");
                        builder.setMessage("This action will delete the stored data on this device");
                        builder.setPositiveButton("Confirm",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) { */
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setCancelable(true);
                        builder.setTitle("Are you sure?");
                        builder.setMessage("This action will download the database");
                        builder.setPositiveButton("Confirm",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        downloadDatabase();
                                    }
                                });
                        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        AlertDialog dialog = builder.create();

                        dialog.show();
                                    /*}
                                });
                        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        AlertDialog dialog = builder.create();

                        dialog.show();
                           */
                    }


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

        public ArrayList<ArrayList<String>> parseData(String data) {
            ArrayList<String> finalData = new ArrayList<String>();

            //stores the unparsed data gathered from the QR code.

            //Makes the data into a list of strings
            String[] dataSets = data.split("]");
            //Counter is an arbitrary int
            int counter = 1;
            String numEntries = "Shouldn't matter";
            //for loop repeats for the number of entries in the list above
            for (String i : dataSets) {
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
            ArrayList<ArrayList<String>> arrays = new ArrayList<ArrayList<String>>();
            //converts the number of matches being tracked into an ninteger.
            int numMatchesTracked = Integer.valueOf(numEntries);
            numberOfMatches = numberOfMatches + Integer.valueOf(numEntries);
            currentNumberOfMatches = Integer.valueOf(numEntries);

            //fullSize = Repeats a number of times equal to the total size of data
            //finalData = an arraylist of strings including the data devoid of commas etc.
            //int r Repeats for each Match that is tracked
            //lots of logs for debugging, nto necissary.
            int g = finalData.size();
            Log.d("test", Integer.toString(g));

            for (int i = 0; i < numMatchesTracked; i++) {
                arrays.add(new ArrayList<String>());
            }
            Log.d("here", "test1");

                /*essentially this loop sorts each individual piece of data into an arraylist of arraylists
                where the list is the match number the data is from*/
            for (int fullSize = 0; fullSize < finalData.size(); fullSize++) {
                String sortedData = finalData.get(fullSize);

                //fullSize % numMatchesTracked gives what array the current sorted data should be put in
                for (int i = 0; i < numMatchesTracked; i++) {
                    if ((fullSize % numMatchesTracked) == i) {
                        arrays.get(i).add(sortedData);
                    }
                }
            }

            Log.d("here", "testing");

                /*repeats for each mach then converts the respective arraylist into an array which is what
                the csv writer takes*/

            return arrays;
        }

        private void copyDatabase() {
            ScoreDataBase SDB = ScoreDataBase.getDatabase(this);
            String data = scannedTV.getText().toString();
            ArrayList<ArrayList<String>> arrays = parseData(data);

            for (int i = 0; i < currentNumberOfMatches; i++) {
                GameData gameData = new GameData(arrays.get(i).get(0), arrays.get(i).get(1), arrays.get(i).get(2), arrays.get(i).get(3),
                        arrays.get(i).get(4), arrays.get(i).get(5), arrays.get(i).get(6), arrays.get(i).get(7), arrays.get(i).get(8),
                        arrays.get(i).get(9), arrays.get(i).get(10), arrays.get(i).get(11), arrays.get(i).get(12), arrays.get(i).get(13),
                        arrays.get(i).get(14), arrays.get(i).get(15), arrays.get(i).get(16), arrays.get(i).get(17), arrays.get(i).get(18),
                        arrays.get(i).get(19), arrays.get(i).get(20), arrays.get(i).get(21), arrays.get(i).get(22), arrays.get(i).get(23),
                        arrays.get(i).get(24), arrays.get(i).get(25), arrays.get(i).get(26), arrays.get(i).get(27), arrays.get(i).get(28),
                        arrays.get(i).get(29), arrays.get(i).get(30), arrays.get(i).get(31), arrays.get(i).get(32), arrays.get(i).get(33),
                        arrays.get(i).get(34), arrays.get(i).get(35), arrays.get(i).get(36), arrays.get(i).get(37), arrays.get(i).get(38),
                        arrays.get(i).get(39), arrays.get(i).get(40), arrays.get(i).get(41), arrays.get(i).get(42), arrays.get(i).get(43),
                        arrays.get(i).get(44), arrays.get(i).get(45), arrays.get(i).get(46));
                SDB.gameDao().insertAll(gameData);
            }


        }

        private void clearDatabase() {
            ScoreDataBase SDB = ScoreDataBase.getDatabase(this);
            numberOfMatches = 0;

            SDB.gameDao().nukeTable();

            Toast.makeText(this, "Table cleared", Toast.LENGTH_LONG).show();
            Log.v("ActivityMain", "Table Cleared");

        }

        private void downloadDatabase() {
                ScoreDataBase Base = ScoreDataBase.getDatabase(this);
                String scouts = Base.gameDao().getScout().toString();
                String devNums = Base.gameDao().getDevNum().toString();
                String matchNums = Base.gameDao().getMatchNum().toString();
                String teams = Base.gameDao().getTeamNum().toString();
                String autoMoved = Base.gameDao().getAutoMoved().toString();
                String teleMoved = Base.gameDao().getTeleMoved().toString();
                String teleTopCones = Base.gameDao().getTeleTopCones().toString();
                String teleMidCones = Base.gameDao().getTeleMidCones().toString();
                String teleBottomCones = Base.gameDao().getTeleBottomCones().toString();
                String teleTopCubes = Base.gameDao().getTeleTopCubes().toString();
                String teleMidCubes = Base.gameDao().getTeleMidCubes().toString();
                String teleBottomCubes = Base.gameDao().getTeleBottomCubes().toString();
                String defence = Base.gameDao().getDefence().toString();
                String autoLeftCommunity = Base.gameDao().getAutoLeftCommunity().toString();
                String autoOnStation = Base.gameDao().getAutoOnStation().toString();
                String autoLevelOnStation = Base.gameDao().getAutoLevelOnStation().toString();
                String teleOnStation = Base.gameDao().getTeleOnStation().toString();
                String teleLevelOnStation = Base.gameDao().getTeleLevelOnStation().toString();
                String teleBroke = Base.gameDao().getTeleBroke().toString();
                String teleNoShow = Base.gameDao().getTeleNoShow().toString();
                String TBox1 = Base.gameDao().getTBoxOne().toString();
                String TBox2 = Base.gameDao().getTBoxTwo().toString();
                String TBox3 = Base.gameDao().getTBoxThree().toString();
                String TBox4 = Base.gameDao().getTBoxFour().toString();
                String TBox5 = Base.gameDao().getTBoxFive().toString();
                String TBox6 = Base.gameDao().getTBoxSix().toString();
                String TBox7 = Base.gameDao().getTBoxSeven().toString();
                String TBox8 = Base.gameDao().getTBoxEight().toString();
                String TBox9 = Base.gameDao().getTBoxNine().toString();
                String MBox1 = Base.gameDao().getMBoxOne().toString();
                String MBox2 = Base.gameDao().getMBoxTwo().toString();
                String MBox3 = Base.gameDao().getMBoxThree().toString();
                String MBox4 = Base.gameDao().getMBoxFour().toString();
                String MBox5 = Base.gameDao().getMBoxFive().toString();
                String MBox6 = Base.gameDao().getMBoxSix().toString();
                String MBox7 = Base.gameDao().getMBoxSeven().toString();
                String MBox8 = Base.gameDao().getMBoxEight().toString();
                String MBox9 = Base.gameDao().getMBoxNine().toString();
                String BBox1 = Base.gameDao().getBBoxOne().toString();
                String BBox2 = Base.gameDao().getBBoxTwo().toString();
                String BBox3 = Base.gameDao().getBBoxThree().toString();
                String BBox4 = Base.gameDao().getBBoxFour().toString();
                String BBox5 = Base.gameDao().getBBoxFive().toString();
                String BBox6 = Base.gameDao().getBBoxSix().toString();
                String BBox7 = Base.gameDao().getBBoxSeven().toString();
                String BBox8 = Base.gameDao().getBBoxEight().toString();
                String BBox9 = Base.gameDao().getBBoxNine().toString();
                String qrCodeData = scouts + "," + devNums + "," + matchNums + "," + teams + "," + autoMoved + "," + teleMoved + ","
                        + "," + teleTopCones + "," + teleMidCones + "," + teleBottomCones + "," + teleTopCubes + ","
                        + teleMidCubes + "," + teleBottomCubes + "," + defence + "," + autoLeftCommunity + "," + autoOnStation + ","
                        + autoLevelOnStation + "," + teleOnStation + "," + teleLevelOnStation + "," + teleBroke + "," + teleNoShow +
                        "," + TBox1 + "," + TBox2 + "," + TBox3 + "," + TBox4 + "," + TBox5 + "," + TBox6 + "," + TBox7 + "," + TBox8 +
                        "," + TBox9 + "," + MBox1 + "," + MBox2 + "," + MBox3 + "," + MBox4 + "," + MBox5 + "," + MBox6 + "," + MBox7 +
                        "," + MBox8 + "," + MBox9 + "," + BBox1 + "," + BBox2 + "," + BBox3 + "," + BBox4 + "," + BBox5 + "," + BBox6 +
                        "," + BBox7 + "," + BBox8 + "," + BBox9;
                Log.d("Raw data", qrCodeData);
                try {
                    ArrayList<String> finalData = new ArrayList<String>();


                    String[] dataSets = qrCodeData.split("]");
                    int counter = 1;

                    for (String i : dataSets) {


                        String[] individualNums = i.split(" ");
                        for (String u : individualNums) {
                            u = u.replace("[", "");
                            u = u.replace(",", "");
                            u = u.replace(" ", "");
                            finalData.add(u);

                        }
                    }

                    ArrayList<ArrayList<String>> arrays = new ArrayList<ArrayList<String>>();


                    //fullSize = Repeats a number of times equal to the total size of data
                    //numMatchesTracked =
                    //finalData = an arraylist of strings including the data devoid of commas etc.

                    //int r Repeats for each Match that is tracked
                    int g = finalData.size();
                    List<String[]> finalList = new ArrayList<String[]>();
                    Log.d("test", Integer.toString(g));
                    for (int i = 0; i < numberOfMatches; i++) {
                        arrays.add(new ArrayList<String>());
                    }
                    Log.d("here", "test1");

                    for (int fullSize = 0; fullSize < finalData.size(); fullSize++) {
                        String sortedData = finalData.get(fullSize);

                        //fullSize % numMatchesTracked gives what array the current sorted data should be put in
                        for (int i = 0; i < numberOfMatches; i++) {
                            if ((fullSize % numberOfMatches) == i) {
                                arrays.get(i).add(sortedData);
                            }
                        }
                    }
                    Log.d("here", "test2");
                    //Log.d("here", array1.get(1));



                    for (int i = 0; i < numberOfMatches; i++) {

                        String[] coolCacheThingyMajig = new String[arrays.get(i).size()];
                        for (int j = 0; j < arrays.get(i).size(); j++) {
                            coolCacheThingyMajig[j] = arrays.get(i).get(j);
                        }
                        finalList.add(coolCacheThingyMajig);

                    }
                    Log.d("here", "test3");
                    String[] names = {"Scout", "DevId", "matchNum", "TeamNum", "TeleTopCone", "TeleMidCone", "TeleBottomCone", "TeleTopCube", "TeleMidCube",
                            "TeleBottomCube", "DefenceRating", "AutoMoved", "AutoLeftCommunity", "AutoUnengaged", "AutoEngaged", "TeleUnengaged", "TeleEngaged",
                            "Drove", "Broke", "NoShow", "TBox1", "TBox2", "TBox3", "TBoxFour", "TBoxFive", "TBoxSix", "TBoxSeven",
                            "TBoxEight", "TBoxNine", "MBoxOne", "MBoxTwo", "MBoxThree", "MBoxFour", "MBoxFive", "MBoxSix", "MBoxSeven", "MBoxEight", "MBoxNine",
                            "BBoxOne", "BBoxTwo", "BBoxThree", "BBoxFour", "BBoxFive", "BBoxSix", "BBoxSeven", "BBoxEight", "BBoxNine"};
                    finalList.add(0, names);
                    Log.d("counter", finalData.toString());


                    //String csv = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
                    String csv = "/data/data/com.phoenixforce.scouting/data.csv";
                    Log.d("test", csv);
                    CSVWriter writer = new CSVWriter(new FileWriter(csv));

                    writer.writeAll(finalList);

                    writer.close();


                }
                catch (Exception e) {
                    Snackbar.make(findViewById(R.id.idTVscanned), "Exception copying data " + e.getMessage(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Log.d("exception", e.getMessage());
                }
            }
    }

