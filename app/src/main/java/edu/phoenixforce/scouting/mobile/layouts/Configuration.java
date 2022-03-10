package edu.phoenixforce.scouting.mobile.layouts;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import edu.phoenixforce.scouting.mobile.bluealliance.resources.Team;
import edu.phoenixforce.scouting.mobile.common.Constants;
import edu.phoenixforce.scouting.mobile.exceptions.InvalidStateException;

public class Configuration {
    Constants constants = new Constants();
    private static volatile Configuration config;
    private static final String CONFIG_FILE_NAME = "edu.phoenixforce.scouting.mobile";
    private static final String KEY_DEVICE_ID = CONFIG_FILE_NAME + ".DeviceId";
    private static final String KEY_TBA_TEAM_ID = CONFIG_FILE_NAME + ".TbaTeamId";
    private static final String KEY_TBA_LAST_MODIFIED = CONFIG_FILE_NAME + ".TbaLastModified";

    public static Configuration getInstance(@NonNull Context context) {
        if(config == null) {
            synchronized(Configuration.class) {
                if (config == null) {
                    config = new Configuration(context);
                }
            }
        }
        return config;
    }

    public static Configuration getInstance() {
        if (config == null)
            throw new InvalidStateException("Configuration not yet initialized.");
        return config;
    }

    private volatile boolean configLoaded = false;
    private int deviceId = 0;
    private int tbaTeamId = 0;
    private Context context;
    private String tbaLastModified;
    private SharedPreferences prefs;
    private RequestQueue requestQueue;

    private Configuration(@NonNull Context context) {
        this.context = context;
        this.prefs = this.context.getSharedPreferences(CONFIG_FILE_NAME, Context.MODE_PRIVATE);
        this.loadConfiguration();
    }

    public boolean isConfigured() {
        if (!configLoaded) {
            loadConfiguration();
        }
        return deviceId != 0 && tbaTeamId != 0;
    }

    private void loadConfiguration() {
        if (!configLoaded) {
            synchronized (this) {
                if (!configLoaded) {
                    this.deviceId = prefs.getInt(KEY_DEVICE_ID, deviceId);
                    this.tbaTeamId = prefs.getInt(KEY_TBA_TEAM_ID, tbaTeamId);
                    this.tbaLastModified = prefs.getString(KEY_TBA_LAST_MODIFIED, null);
                }
                configLoaded = true;
            }
        }
    }

    public Context getContext() {
        return context;
    }

    public int getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(int deviceId) {
        SharedPreferences.Editor editor = prefs.edit();
        Log.d("constants", String.valueOf(deviceId));
        editor.putInt(KEY_DEVICE_ID, deviceId);
        editor.apply();
        this.deviceId = prefs.getInt(KEY_DEVICE_ID, this.deviceId);
    }

    public int getTbaTeamId() {
        return this.tbaTeamId;
    }

    public void setTbaTeamId(int tbaTeamId) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_TBA_TEAM_ID, tbaTeamId);
        editor.apply();
        this.tbaTeamId = prefs.getInt(KEY_TBA_TEAM_ID, this.tbaTeamId);




    }

    public String getTbaLastModified() {
        return tbaLastModified;
    }

    public String getTbaTeamKey() {
        return Team.getTeamKeyFromTeamId(this.tbaTeamId);
    }

    public RequestQueue getRequestQueue() {
        if (this.requestQueue == null) {
            synchronized (this) {
                if (this.requestQueue == null) {
                    this.requestQueue = Volley.newRequestQueue(this.getContext());
                }
            }
        }
        return this.requestQueue;
    }



}
