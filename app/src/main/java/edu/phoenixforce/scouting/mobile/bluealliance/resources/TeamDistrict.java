package edu.phoenixforce.scouting.mobile.bluealliance.resources;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import edu.phoenixforce.scouting.mobile.bluealliance.TbaApiConstants;

public class TeamDistrict {
    public static final String TBA_TEAM_DISTRICTS_URL = TbaApiConstants.TBA_ROOT_URL + "team/{0}/districts";

    public static String getFormattedUrl(int teamId) {
        return getFormattedUrl(Team.getTeamKeyFromTeamId(teamId));

    }

    public static String getFormattedUrl(String teamKey) {
        return MessageFormat.format(Team.TBA_TEAM_URL, teamKey);
    }

    @JsonProperty("abbreviation")
    private String abbreviation;

    @JsonProperty("display_name")
    private String display_name;

    @JsonProperty("key")
    private String districtKey;

    @JsonProperty("year")
    private int year;

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getDistrictKey() {
        return districtKey;
    }

    public int getYear() {
        return year;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
