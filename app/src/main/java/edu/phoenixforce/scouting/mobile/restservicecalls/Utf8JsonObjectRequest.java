package edu.phoenixforce.scouting.mobile.restservicecalls;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * This class works around some issues associated with getting UTF-8 JSON payloads
 * from webservices that set the character set as none when it needs to be UTF-8
 */

public class Utf8JsonObjectRequest extends Request<JSONObject> implements IRequest {

    private final Response.Listener<JSONObject> listener;
    private final Map<String, String> params;
    private NetworkResponse networkResponse = null;

    public Utf8JsonObjectRequest(String url, Map<String, String> params,
                                 Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.listener = responseListener;
        this.params = params;
        if (responseListener instanceof VolleyResponseHandler) {
            ((VolleyResponseHandler<JSONObject>) responseListener).setRequestObject(this);
        }
    }

    public Utf8JsonObjectRequest(int method, String url, Map<String, String> params,
                                 Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = responseListener;
        this.params = params;
        if (responseListener instanceof VolleyResponseHandler) {
            ((VolleyResponseHandler<JSONObject>) responseListener).setRequestObject(this);
        }
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        this.networkResponse = response;
        try {
            String jsonString = new String(response.data, StandardCharsets.UTF_8);
//                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }

    @Override
    protected void deliverResponse(JSONObject response) {
        // TODO Auto-generated method stub
        listener.onResponse(response);
    }

    public NetworkResponse getNetworkResponse() {
        return this.networkResponse;
    }

}
