package edu.phoenixforce.scouting.mobile.bluealliance;

import edu.phoenixforce.scouting.mobile.bluealliance.resources.Team;
import edu.phoenixforce.scouting.mobile.bluealliance.resources.TeamDistrict;
import edu.phoenixforce.scouting.mobile.restservicecalls.GetRestCollectionCall;
import edu.phoenixforce.scouting.mobile.restservicecalls.ICollectionResponseHandler;

public class GetTeamDistricts extends GetRestCollectionCall<TeamDistrict> {

    private final int teamId;

    public GetTeamDistricts(int teamId, ICollectionResponseHandler<TeamDistrict> handler) {
        super(handler);
        this.teamId = teamId;
    }

    public GetTeamDistricts(String teamKey, ICollectionResponseHandler<TeamDistrict> handler) {
        super(handler);
        this.teamId= Team.getTeamIdFromTeamKey(teamKey);
    }

    @Override
    protected Class<TeamDistrict> getTemplateClass() {
        return TeamDistrict.class;
    }

    @Override
    protected String getUrl() {
        return TeamDistrict.getFormattedUrl(teamId);
    }

    public int getTeamId() {
        return teamId;
    }
}
