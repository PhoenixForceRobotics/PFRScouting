package edu.phoenixforce.scouting.mobile.restservicecalls;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class VolleyResponseHandler<T> implements Response.Listener<T>, Response.ErrorListener {

    private IResponseHandler<T> handler;
    private IRequest request;

    public VolleyResponseHandler(IResponseHandler<T> handler) {
        this.handler = handler;
    }

    @Override
    public void onResponse(T response) {
        handler.onResponse((request != null ? request.getNetworkResponse().headers : null), response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        handler.onError(error);
    }

    void setRequestObject(IRequest request) {
        this.request =request;
    }
}
