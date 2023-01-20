package edu.phoenixforce.scouting.mobile.restservicecalls;

import com.android.volley.VolleyError;

import java.util.Map;

public interface IResponseHandler<T> {
    void onResponse(Map<String, String> headers, T response);
    void onError(VolleyError error);

}
