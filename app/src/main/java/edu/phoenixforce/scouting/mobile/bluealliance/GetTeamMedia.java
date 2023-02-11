package edu.phoenixforce.scouting.mobile.bluealliance;

import edu.phoenixforce.scouting.mobile.bluealliance.resources.Team;
import edu.phoenixforce.scouting.mobile.bluealliance.resources.TeamMedia;
import edu.phoenixforce.scouting.mobile.restservicecalls.GetRestCollectionCall;
import edu.phoenixforce.scouting.mobile.restservicecalls.ICollectionResponseHandler;

public class GetTeamMedia extends GetRestCollectionCall<TeamMedia> {

    private final int teamId;
    private final int year;

    public GetTeamMedia(int teamId, int year, ICollectionResponseHandler<TeamMedia> handler) {
        super(handler);
        this.teamId = teamId;
        this.year = year;
    }

    public GetTeamMedia(String teamKey, int year, ICollectionResponseHandler<TeamMedia> handler) {
        super(handler);
        this.teamId = Team.getTeamIdFromTeamKey(teamKey);
        this.year = year;
    }


    @Override
    protected Class<TeamMedia> getTemplateClass() {
        return TeamMedia.class;
    }

    @Override
    protected String getUrl() {
        return TeamMedia.getFormattedUrl(teamId, year);
    }

    public int getTeamId() {
        return teamId;
    }

    public int getYear() {
        return year;
    }
}
