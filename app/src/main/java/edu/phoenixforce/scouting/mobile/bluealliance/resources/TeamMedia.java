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
public class TeamMedia {
    public static final String TBA_TEAM_MEDIA_URL = TbaApiConstants.TBA_ROOT_URL + "team/{0}/media/{1,number,####}";

    public static String getFormattedUrl(int teamId, int year) {
        return getFormattedUrl(Team.getTeamKeyFromTeamId(teamId), year);
    }

    public static String getFormattedUrl(String teamKey, int year) {
        return MessageFormat.format(TeamMedia.TBA_TEAM_MEDIA_URL, teamKey, year);
    }

    @JsonProperty("type")
    private String type;

    @JsonProperty("foreign_key")
    private String foreignKey;

    @JsonProperty("details")
    private Map<String, String> details;

    @JsonProperty("preferred")
    private boolean preferred;

    @JsonProperty("direct_url")
    private String directUrl;

    @JsonProperty("view_url")
    private  String viewUrl;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getType() {
        return type;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public String getDirectUrl() {
        return directUrl;
    }

    public String getViewUrl() {
        return viewUrl;
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
