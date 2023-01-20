package edu.phoenixforce.scouting.mobile.bluealliance;

import java.text.MessageFormat;

import edu.phoenixforce.scouting.mobile.restservicecalls.GetRestCollectionCall;
import edu.phoenixforce.scouting.mobile.restservicecalls.ICollectionResponseHandler;

public class GetDistrictTeamsKeys extends GetRestCollectionCall<String> {

    private final String districtKey;

    public GetDistrictTeamsKeys(String districtKey, ICollectionResponseHandler<String> handler) {
        super(handler);
        this.districtKey = districtKey;
    }

    @Override
    protected Class<String> getTemplateClass() {
        return String.class;
    }

    @Override
    protected String getUrl() {
        return MessageFormat.format(TbaApiConstants.TBA_DISTRICT_TEAMS_KEYS_URL, this.districtKey);
    }

    public String getDistrictKey() {
        return districtKey;
    }
}
