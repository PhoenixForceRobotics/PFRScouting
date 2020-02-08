package edu.phoenixforce.scouting.mobile.bluealliance;

import edu.phoenixforce.scouting.mobile.bluealliance.resources.Team;
import edu.phoenixforce.scouting.mobile.bluealliance.resources.TeamRobot;
import edu.phoenixforce.scouting.mobile.restservicecalls.GetRestCollectionCall;
import edu.phoenixforce.scouting.mobile.restservicecalls.ICollectionResponseHandler;

public class GetTeamRobots extends GetRestCollectionCall<TeamRobot> {

    private int teamId;

    public GetTeamRobots(int teamId, ICollectionResponseHandler<TeamRobot> handler) {
        super(handler);
        this.teamId = teamId;
    }

    public GetTeamRobots(String teamKey, ICollectionResponseHandler<TeamRobot> handler) {
        super(handler);
        this.teamId = Team.getTeamIdFromTeamKey(teamKey);
    }

    @Override
    protected Class<TeamRobot> getTemplateClass() {
        return TeamRobot.class;
    }

    @Override
    protected String getUrl() {
        return TeamRobot.getFormattedUrl(teamId);
    }

    public int getTeamId() {
        return teamId;
    }
}
