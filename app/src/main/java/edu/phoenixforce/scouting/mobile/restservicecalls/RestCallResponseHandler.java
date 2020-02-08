package edu.phoenixforce.scouting.mobile.restservicecalls;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class RestCallResponseHandler<T> implements IResponseHandler<String> {

    private final Class<T> theClass;
    private T responseObject;
    private List<T> collectionResponseObject;
    private IResponseHandler<T> responder;

    public RestCallResponseHandler(Class<T> theClass, IResponseHandler<T> responder) {
        this.theClass = theClass;
        this.responder = responder;
    }


    @Override
    public void onResponse(Map<String, String> headers, String response) {
        try {

            if (this instanceof ICollectionCall) {
                ICollectionResponseHandler hndlr = (ICollectionResponseHandler) responder;
                this.collectionResponseObject = getCollectionResponseObject(response, theClass);
                hndlr.onResponse(headers, collectionResponseObject);
            } else {
                this.responseObject = getResponseObject(response, theClass);
                responder.onResponse(headers, responseObject);
            }
        } catch (Exception e) {
            VolleyError error = new VolleyError();
            error.initCause(e);
            responder.onError(error);
        }
    }

    @Override
    public void onError(VolleyError error) {
        responder.onError(error);
    }

    protected List<T> getCollectionResponseObject(String restStringResponse, Class<T> theClass) throws Exception {
        return new ArrayList<T>();
    };

    protected T getResponseObject(String restStringResponse, Class<T> theClass) throws Exception {
        return theClass.newInstance();
    };

}
