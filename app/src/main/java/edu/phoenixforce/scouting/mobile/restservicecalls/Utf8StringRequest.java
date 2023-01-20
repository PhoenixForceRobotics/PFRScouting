package edu.phoenixforce.scouting.mobile.restservicecalls;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Utf8StringRequest extends Request<String> implements IRequest {
    private final Response.Listener<String> listener;
    private final Map<String, String> params;
    private NetworkResponse networkResponse = null;

    public Utf8StringRequest(String url, Map<String, String> params,
                             Response.Listener<String> responseListener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.listener = responseListener;
        this.params = params;
        if (responseListener instanceof VolleyResponseHandler) {
            ((VolleyResponseHandler<String>) responseListener).setRequestObject(this);
        }

    }

    public Utf8StringRequest(int method, String url, Map<String, String> params,
                             Response.Listener<String> responseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = responseListener;
        this.params = params;
        if (responseListener instanceof VolleyResponseHandler) {
            ((VolleyResponseHandler<String>) responseListener).setRequestObject(this);
        }

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        this.networkResponse = response;
        String jsonString = new String(response.data, StandardCharsets.UTF_8);
        return Response.success(jsonString,
                HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(String response) {
        listener.onResponse(response);

    }

    @Override
    public NetworkResponse getNetworkResponse() {
        return this.networkResponse;
    }
}
