package edu.phoenixforce.scouting.mobile.restservicecalls;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class Utf8JsonArrayRequest extends Request<JSONArray> implements IRequest {
    private Response.Listener<JSONArray> listener;
    private Map<String, String> params;
    private NetworkResponse networkResponse = null;

    public Utf8JsonArrayRequest(String url, Map<String, String> params,
                                 Response.Listener<JSONArray> responseListener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.listener = responseListener;
        this.params = params;
        if (responseListener instanceof VolleyResponseHandler) {
            ((VolleyResponseHandler<JSONArray>) responseListener).setRequestObject(this);
        }
    }

    public Utf8JsonArrayRequest(int method, String url, Map<String, String> params,
                                 Response.Listener<JSONArray> responseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = responseListener;
        this.params = params;
        if (responseListener instanceof VolleyResponseHandler) {
            ((VolleyResponseHandler<JSONArray>) responseListener).setRequestObject(this);
        }
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    };

    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
        this.networkResponse = response;
        try {
            String jsonString = new String(response.data, "UTF-8");
//                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONArray(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }

    @Override
    protected void deliverResponse(JSONArray response) {
        // TODO Auto-generated method stub
        listener.onResponse(response);
    }

    public NetworkResponse getNetworkResponse() {
        return this.networkResponse;
    }

}
