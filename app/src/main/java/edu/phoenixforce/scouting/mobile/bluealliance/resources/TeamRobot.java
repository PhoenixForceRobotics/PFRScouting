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
public class TeamRobot {
    // URL for the list of Robots on a team.
    public static final String TBA_TEAM_ROBOTS_URL = TbaApiConstants.TBA_ROOT_URL + "team/{0}/robots";

    public static String getFormattedUrl(int teamId) {
        return getFormattedUrl(Team.getTeamKeyFromTeamId(teamId));
    }

    public static String getFormattedUrl(String teamKey) {
        return MessageFormat.format(TeamRobot.TBA_TEAM_ROBOTS_URL, teamKey);
    }

    @JsonProperty("year")
    private int year;

    @JsonProperty("robot_name")
    private String robotName;

    @JsonProperty("key")
    private String robotKey;

    @JsonProperty("team_key")
    private String teamKey;

    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public int getYear() {
        return year;
    }

    public String getRobotName() {
        return robotName;
    }

    public String getRobotKey() {
        return robotKey;
    }

    public String getTeamKey() {
        return teamKey;
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
