package edu.phoenixforce.scouting.mobile.restservicecalls;

import java.util.List;
import java.util.Map;

public interface ICollectionResponseHandler<T> extends IResponseHandler<T> {
    void onResponse(Map<String, String> headers, List<T> response);

}
