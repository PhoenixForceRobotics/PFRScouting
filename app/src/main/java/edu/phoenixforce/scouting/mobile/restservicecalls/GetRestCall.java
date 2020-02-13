package edu.phoenixforce.scouting.mobile.restservicecalls;

import java.util.HashMap;
import java.util.Map;

import edu.phoenixforce.scouting.mobile.bluealliance.TbaApiConstants;
import edu.phoenixforce.scouting.mobile.layouts.Configuration;

public abstract class GetRestCall<T> {

    private IResponseHandler<T> handler;

    GetRestCall(IResponseHandler<T> handler) {
        this.handler = handler;
    }

    public void invokeCall() {
        invokeCall(false);
    }

    public void invokeCall(boolean sinceLastModified) {

        final Map<String, String> headers = new HashMap<String, String>();
        headers.put(TbaApiConstants.X_TBA_AUTH_KEY_HEADER, TbaApiConstants.X_TBA_AUTH_KEY);

        if (sinceLastModified) {
            String lastMod = Configuration.getInstance().getTbaLastModified();
            if (lastMod != null && !lastMod.isEmpty()) {
                headers.put(TbaApiConstants.LAST_MODIFIED_HEADER, lastMod);
            }
        }

        final VolleyResponseHandler<String> responseHandler = new VolleyResponseHandler<String>(getRestCallHandler(getTemplateClass(), this.handler));

        Utf8StringRequest req = new Utf8StringRequest(this.getUrl(), headers, responseHandler, responseHandler) {
            @Override
            public Map<String, String> getHeaders() {
                return headers;
            }
        };

        Configuration.getInstance().getRequestQueue().add(req);
    }

    protected abstract Class<T> getTemplateClass();
    protected abstract String getUrl();

    protected abstract RestCallResponseHandler<T> getRestCallHandler(Class<T> templateClass, IResponseHandler<T> handler);


}
