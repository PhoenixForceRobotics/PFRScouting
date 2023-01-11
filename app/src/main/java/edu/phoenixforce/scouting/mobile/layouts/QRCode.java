package edu.phoenixforce.scouting.mobile.layouts;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.zxing.WriterException;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import edu.phoenixforce.scouting.mobile.database.ScoreDataBase;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fyrebirdscout11.R;
import java.util.List;

public class QRCode extends AppCompatActivity {

    // variables for imageview, edittext,
    // button, bitmap and qrencoder.
    private ImageView qrCodeIV;
    Button generateQrBtn;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_code);


        qrCodeIV = findViewById(R.id.idIVQrcode);
        //where the user enters the data, dataEdt is a parameter for qrg encoder later.

        ScoreDataBase Base = ScoreDataBase.getDatabase(this);

        //database1 = (List) Base.gameDao().getAllScores();

        //Casted to list might not get whole Table
        //COME BACK TO THIS.
        //At the time of writing this queen Elizabeth died 3 minuets ago.

                                        //Scouts
        String scouts = Base.gameDao().getScout().toString();
        String devNums = Base.gameDao().getDevNum().toString();
        String matchNums = Base.gameDao().getMatchNum().toString();
        String teams = Base.gameDao().getTeamNum().toString();
        String autoMoved = Base.gameDao().getAutoMoved().toString();
        String teleMoved = Base.gameDao().getTeleMoved().toString();
        String autoTopCones = Base.gameDao().getAutoTopCones().toString();
        String autoMidCones = Base.gameDao().getAutoMidCones().toString();
        String autoBottomCones = Base.gameDao().getAutoBottomCones().toString();
        String autoTopCubes = Base.gameDao().getAutoTopCubes().toString();
        String autoMidCubes = Base.gameDao().getAutoMidCubes().toString();
        String autoBottomCubes = Base.gameDao().getAutoBottomCubes().toString();
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

        String qrCodeData = scouts + "," + devNums + "," + matchNums + "," + teams + "," + autoMoved + "," + teleMoved + ","
                + autoTopCones + "," + autoMidCones + "," + autoBottomCones + "," + autoTopCubes + "," + autoMidCubes + ","
                + autoBottomCubes + "," + teleTopCones + "," + teleMidCones + "," + teleBottomCones + "," + teleTopCubes + ","
                + teleMidCubes + "," + teleBottomCubes + "," + defence + "," + autoLeftCommunity + "," + autoOnStation + ","
                + autoLevelOnStation + "," + teleOnStation + "," +  teleLevelOnStation + "," + teleBroke + "," + teleNoShow;


        generateQrBtn = findViewById(R.id.idBtnGenerateQR);


        // initializing onclick listener for button.
        //Works if this section is commented out
        Log.d("QRCodeButton", "Got here");
        generateQrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    // below line is for getting
                    // the windowmanager service.

                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                            
                    // initializing a variable for default display.
                    Display display = manager.getDefaultDisplay();

                    // creating a variable for point which
                    // is to be displayed in QR Code.
                    Point point = new Point();
                    Log.d("point", "got this far");
                    display.getSize(point);

                    // getting width and
                    // height of a point
                    int width = point.x;
                    int height = point.y;

                    // generating dimension from width and height.
                    int dimen = width < height ? width : height;
                    dimen = dimen * 3 / 4;



                    // setting this dimensions inside our qr code
                    // encoder to generate our qr code.
                    // ADD DATABASE INTEGRATION TO GET NUMBER OF ROWS TO USE FOR I $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

                    qrgEncoder = new QRGEncoder(qrCodeData, null, QRGContents.Type.TEXT, 400);
                    //try normal list as well.
                    try {
                        // getting our qrcode in the form of bitmap.
                        bitmap = qrgEncoder.encodeAsBitmap();
                        // the bitmap is set inside our image
                        // view using .setimagebitmap method.
                        qrCodeIV.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        // this method is called for
                        // exception handling.
                        Log.e("Tag", e.toString());
                    }





            }
        });

    }

   /* public String listToString(List list, int number){

        StringBuilder strbul1 = new StringBuilder();
        for (String data : list) {
            strbul1.append(data);
            //for adding comma between elements
            strbul1.append(",");
        }
        //just for removing last comma
        strbul1.setLength(strbul1.length() - 1);
        String data = strbul1.toString();

        return data;
    }*/
}
