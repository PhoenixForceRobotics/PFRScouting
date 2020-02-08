package edu.phoenixforce.scouting.mobile.bluealliance;

import edu.phoenixforce.scouting.mobile.bluealliance.resources.Team;
import edu.phoenixforce.scouting.mobile.restservicecalls.GetRestObjectCall;
import edu.phoenixforce.scouting.mobile.restservicecalls.IObjectResponseHandler;

public class GetTeam extends GetRestObjectCall<Team> {

    private int teamId;
    public GetTeam(int teamId, IObjectResponseHandler<Team> handler) {
        super(handler);
        this.teamId = teamId;
    }

    public GetTeam(String teamKey, IObjectResponseHandler<Team> handler) {
        super(handler);
        this.teamId = Team.getTeamIdFromTeamKey(teamKey);
    }

    @Override
    protected Class<Team> getTemplateClass() {
        return Team.class;
    }

    @Override
    protected String getUrl() {
        return Team.getFormattedUrl(teamId);
    }

    public int getTeamId() {
        return teamId;
    }
}
