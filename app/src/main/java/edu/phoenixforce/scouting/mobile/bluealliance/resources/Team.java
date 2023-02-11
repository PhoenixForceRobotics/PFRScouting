package edu.phoenixforce.scouting.mobile.bluealliance.resources;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import edu.phoenixforce.scouting.mobile.bluealliance.TbaApiConstants;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Team {
    public static final String TBA_TEAM_URL = TbaApiConstants.TBA_ROOT_URL + "team/{0}";

    // Prefix for the team key.
    public static final String TBA_TEAM_KEY_PREFIX = "frc";

    public static String getTeamKeyFromTeamId(int teamId) {
        return TBA_TEAM_KEY_PREFIX + teamId;
    }

    public static int getTeamIdFromTeamKey(String teamKey) {
        if (teamKey != null && !teamKey.isEmpty() & teamKey.startsWith("frc")) {
            return Integer.parseInt(teamKey.substring(3));
        } else {
            return 0;
        }
    }

    public static String getFormattedUrl(int teamId) {
        return getFormattedUrl(getTeamKeyFromTeamId(teamId));

    }

    public static String getFormattedUrl(String teamKey) {
        return MessageFormat.format(Team.TBA_TEAM_URL, teamKey);
    }


    @JsonProperty("key")
    private String key;

    @JsonProperty("team_number")
    private int teamNumber;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("name")
    private String name;

    @JsonProperty("school_name")
    private String schoolName;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state_prov")
    private String stateProv;

    @JsonProperty("country")
    private String country;

    @JsonProperty("address")
    private String address;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("gmaps_place_id")
    private String gmapsPlaceId;

    @JsonProperty("gmaps_url")
    private String gmapsUrl;

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lng")
    private double lng;

    @JsonProperty("location_name")
    private String locationName;

    @JsonProperty("website")
    private String website;

    @JsonProperty("rookie_year")
    private int rookieYear;

    @JsonProperty("motto")
    private String motto;

    @JsonProperty("home_championship")
    private final Map<String, String> homeChampionship = new HashMap<String, String>();

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public String getKey() {
        return key;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getCity() {
        return city;
    }

    public String getStateProv() {
        return stateProv;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getGmapsPlaceId() {
        return gmapsPlaceId;
    }

    public String getGmapsUrl() {
        return gmapsUrl;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getWebsite() {
        return website;
    }

    public int getRookieYear() {
        return rookieYear;
    }

    public String getMotto() {
        return motto;
    }

    public Map<String, String> getHomeChampionship() {
        return homeChampionship;
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
