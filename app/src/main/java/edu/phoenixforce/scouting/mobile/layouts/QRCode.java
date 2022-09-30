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
        List<String> database1 = Base.gameDao().getTeamNum();
        StringBuilder strbul=new StringBuilder();
        for(String str : database1)
        {
            strbul.append(str);
            //for adding comma between elements
            strbul.append(",");
        }
        //just for removing last comma
        strbul.setLength(strbul.length()-1);
        String str =strbul.toString();

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

                    qrgEncoder = new QRGEncoder(/*dataEdt.getText().toString()*/str, null, QRGContents.Type.TEXT, 400);
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

}
