package edu.phoenixforce.scouting.mobile.bluealliance;

public class TbaApiConstants {

    // Header constants that are used in the call.

    // Auth key has to passed on all calls, otherwise we get a 401
    public static final String X_TBA_AUTH_KEY_HEADER = "X-TBA-Auth-Key";
    public static final String X_TBA_AUTH_KEY = "n1vqWHCy220CJBDIcX9p8TOurCPbBsIJh9YbhPODFtesjM4N8oQ6guVDlrer5wrx";

    // The last modified date can be received, indicating the last time the data was changed at the Blue Alliance,
    // or passed in, indicating that we want any data modified since that date.
    public static final String LAST_MODIFIED_HEADER = "Last-Modified";

    // URL's for all the services we want to call. ROOT_URL is the base. The rest add to it.
    public static final String TBA_ROOT_URL = "https://www.thebluealliance.com/api/v3/";

    // URL for the status call
    public static final String TBA_STATUS_URL = TBA_ROOT_URL + "status";

    // I'm not sure we need this. The URL fetches a team resource, but it is not a complete resource
    // like you get from the /teams url.
    // I'm leaving this here in case we decide to use it later.
    public static final String TBA_DISTRICT_TEAMS_URL = TBA_ROOT_URL + "district/{0}/teams";

    // This is just a list of all the team keys in the district. Does not need a helper class as it's just an array
    // of strings. We call this, then call /teams for each key returned.
    public static final String TBA_DISTRICT_TEAMS_KEYS_URL = TBA_ROOT_URL + "district/{0}/teams/keys";




}
