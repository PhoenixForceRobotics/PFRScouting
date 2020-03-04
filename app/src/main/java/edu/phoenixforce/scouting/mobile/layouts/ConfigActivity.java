package edu.phoenixforce.scouting.mobile.layouts;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;
import com.example.fyrebirdscout11.R;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import edu.phoenixforce.scouting.mobile.bluealliance.GetTeam;
import edu.phoenixforce.scouting.mobile.bluealliance.GetTeamMedia;
import edu.phoenixforce.scouting.mobile.bluealliance.TbaApiConstants;
import edu.phoenixforce.scouting.mobile.bluealliance.resources.Team;
import edu.phoenixforce.scouting.mobile.bluealliance.resources.TeamMedia;
import edu.phoenixforce.scouting.mobile.restservicecalls.ICollectionResponseHandler;
import edu.phoenixforce.scouting.mobile.restservicecalls.IObjectResponseHandler;

public class ConfigActivity extends AppCompatActivity {
    public static int deviceId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // Set the layout.
        setContentView(R.layout.activity_config);


        // The TbaTeamId editor has the team ID in it and we need to look up the team details
        // when it changes. The following code attaches listeners to the editor.
        EditText editTbaTeamId = (EditText) findViewById(R.id.editTbaTeamId);

        // This listener makes sure we fetch the team details when the user presses enter.
        editTbaTeamId.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    fetchTeamDetails();
                }
                return true;
            }
        });

        // This listener fetches the team details if focus moves from the TBA Team Id.
        editTbaTeamId.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                fetchTeamDetails();
            }
        });

        // Set the screen values to the values from the config file.
        setScreenValues();

        // Get the team information from The Blue Alliance API's
        fetchTeamDetails();



    }

    // Set the values of the editTexts to match the configuration values.
    private void setScreenValues() {
        Configuration config = Configuration.getInstance();
        setEditTextValue(R.id.editDeviceId, String.valueOf(config.getDeviceId()));
        setEditTextValue(R.id.editTbaTeamId, String.valueOf(config.getTbaTeamId()));
    }

    // Given an editText resource id, set the string value in that text.
    private void setEditTextValue(int resourceId, String value) {
        EditText editText = (EditText) findViewById(resourceId);
        editText.setText(value);
    }

    // Get the text in an editText given the resource id.
    private String getEditTextValue(int resourceId) {
        EditText editText = (EditText) findViewById(resourceId);
        return editText.getText().toString();
    }

    // Save the config information to the preferences.
    public void saveConfig(View view) {

        // Get a reference to the config
        Configuration config = Configuration.getInstance();

        // Get a number for the device id and save it.
        deviceId = Integer.parseInt(getEditTextValue(R.id.editDeviceId));
        config.setDeviceId(deviceId);

        // Get a number for he team ID and save it.
        int tbaTeamId = Integer.parseInt(getEditTextValue(R.id.editTbaTeamId));
        config.setTbaTeamId(tbaTeamId);

        // Reset the screen values. Note that this will fetch the values of the
        // config from the config parameters, and redisplay them. That guarantees
        // that what you see on the screen matches what is stored.
        setScreenValues();
    }

    // Fetches team information from the Blue Alliance services.
    public void fetchTeamDetails() {
        // Get the team Id from the editText.
        int teamId = Integer.parseInt(getEditTextValue(R.id.editTbaTeamId));

        //If the team ID is zero, clear the textTeamInfo block, and set the image to the
        //default.
        if (teamId == 0) {
            TextView txt = (TextView) findViewById(R.id.textTeamInfo);
            txt.setText(new String());
            ImageView img = (ImageView) findViewById(R.id.imgTeamLogo);
            img.setImageResource(R.drawable.ic_launcher_background);
            return;
        }

        // Get the team data for this team. call will get a JSONObject back.
        GetTeam teamRestCall = new GetTeam(teamId, new IObjectResponseHandler<Team>() {
            @Override
            public void onResponse(Map<String, String> headers, Team response) {
                StringBuffer text = new StringBuffer();
                text.append("School: " + response.getSchoolName() + "\n");
                text.append("Team: " + response.getNickname() + "\n");
                text.append("Key: " + response.getKey() + "\n");
                text.append("TeamId : " + response.getTeamNumber() + "\n");
                text.append(response.getCity() + ", " + response.getStateProv() + "\n");
                if (headers.containsKey(TbaApiConstants.LAST_MODIFIED_HEADER)) {
                    text.append(TbaApiConstants.LAST_MODIFIED_HEADER + ": " + headers.get(TbaApiConstants.LAST_MODIFIED_HEADER) + "\n");
                }
                TextView txt = (TextView) findViewById(R.id.textTeamInfo);
                txt.setText(text.toString());
            }

            @Override
            public void onError(VolleyError error) {
                TextView txt = (TextView) findViewById(R.id.textTeamInfo);
                if (error != null) {
                    txt.setText(txt.getText() + "\nError fetching data on GetTeam: " + error.getMessage() + "\n");
                    if (error.networkResponse != null) {
                        txt.setText(txt.getText() + "\nNetwork Response: " + error.networkResponse.statusCode + " " + (error.networkResponse.headers != null ? error.networkResponse.headers : ""));
                    }
                } else {
                    txt.setText("Unexpected error");
                }

            }
        });
        teamRestCall.invokeCall();

        final int year = 2019;
        // Get the team media for this team. There is nothing in the current year yet, so
        // fetch it for 2019 instead.
        GetTeamMedia teamMediaRestCall = new GetTeamMedia(teamId, year, new ICollectionResponseHandler<TeamMedia>() {

            @Override
            public void onResponse(Map<String, String> headers, List<TeamMedia> response) {
                Bitmap decodedImage = null;
                TextView txt = (TextView) findViewById(R.id.textTeamInfo);
                StringBuffer text = new StringBuffer();
                text.append(txt.getText());

                TeamMedia textImage = null;
                for (TeamMedia t : response) {
                    if (t.getType().equalsIgnoreCase("avatar")) {
                        textImage = t;
                        break;
                    }
                }
                if (textImage == null) {
                    text.append("No avatar in media");
                } else {
                    text.append("Foreign Key: " + textImage.getForeignKey());
                    text.append("Type: " + textImage.getType());
                    Map<String, String> details = textImage.getDetails();
                    if(details.containsKey("base64Image")) {
                        String b64Image = details.get("base64Image");
                        if (b64Image != null) {
                            byte[] decodedString = Base64.decode(b64Image, Base64.DEFAULT);
                            decodedImage = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                        }
                    }
                }

                if(decodedImage != null) {
                    ImageView img = (ImageView) findViewById(R.id.imgTeamLogo);
                    img.setImageBitmap(decodedImage);
                } else {
                    ImageView img = (ImageView) findViewById(R.id.imgTeamLogo);
                    img.setImageResource(R.drawable.ic_launcher_background);
                }
            }

            @Override
            public void onResponse(Map<String, String> headers, TeamMedia response) {
                return;
            }

            @Override
            public void onError(VolleyError error) {
                StringBuffer text = new StringBuffer();
                TextView txt = (TextView) findViewById(R.id.textTeamInfo);
                if (error != null) {
                    text.append("Url: " + MessageFormat.format(TeamMedia.TBA_TEAM_MEDIA_URL, Team.getTeamKeyFromTeamId(teamId), year));
                    text.append("\nError fetching data on GetTeamMedia: " + error.getCause().getMessage());
                    if (error.networkResponse != null) {
                        text.append("\nNetwork Response: " + error.networkResponse.statusCode + " " + (error.networkResponse.headers != null ? error.networkResponse.headers : ""));
                    }
                } else {
                    text.append("Unexpected error");
                }
                txt.setText(text.toString());
              }
        });

        teamMediaRestCall.invokeCall();

    }
}
