package edu.phoenixforce.scouting.mobile.restservicecalls;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class RestObjectCallResponseHandler<T> extends RestCallResponseHandler<T> implements IObjectResponseHandler<String> {

    public RestObjectCallResponseHandler(Class<T> theClass, IObjectResponseHandler<T> responder) {
        super(theClass, responder);
    }


    @Override
    protected T getResponseObject(String restStringResponse, Class<T> theClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(restStringResponse, theClass);
    }
}
