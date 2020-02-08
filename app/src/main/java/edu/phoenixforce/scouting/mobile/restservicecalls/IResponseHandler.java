package edu.phoenixforce.scouting.mobile.restservicecalls;

import com.android.volley.VolleyError;

import java.util.Map;

public interface IResponseHandler<T> {
    public void onResponse(Map<String, String> headers, T response);
    public void onError(VolleyError error);

}
