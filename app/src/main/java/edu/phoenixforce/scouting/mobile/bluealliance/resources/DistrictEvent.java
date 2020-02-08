package edu.phoenixforce.scouting.mobile.bluealliance.resources;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.text.MessageFormat;

import edu.phoenixforce.scouting.mobile.bluealliance.TbaApiConstants;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistrictEvent {
    // URL for the list of events for the district
    public static final String TBA_DISTRICT_EVENTS_URL = TbaApiConstants.TBA_ROOT_URL + "district/{0}/events";

    public static String getFormattedUrl(String districtKey) {
        return MessageFormat.format(DistrictEvent.TBA_DISTRICT_EVENTS_URL, districtKey);
    }



}
