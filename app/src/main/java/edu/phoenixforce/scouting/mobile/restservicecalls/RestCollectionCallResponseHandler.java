package edu.phoenixforce.scouting.mobile.restservicecalls;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class RestCollectionCallResponseHandler<T> extends RestCallResponseHandler<T> implements IObjectResponseHandler<String>, ICollectionCall {

    public RestCollectionCallResponseHandler(Class<T> theClass, ICollectionResponseHandler<T> responder) {
        super(theClass, responder);
    }

    @Override
    protected List<T> getCollectionResponseObject(String restStringResponse, Class<T> theClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(restStringResponse, mapper.getTypeFactory().constructCollectionType(List.class, theClass));
    }

}
