package recyclerviewloader.test.com.recyclerviewloader.communication;

import com.android.volley.Request;

public interface NetworkOptions {
    /**
     * Request type
     */
    int POST_REQUEST = Request.Method.POST;
    int GET_REQUEST = Request.Method.GET;

    /**
     * Request methods
     */
    int JSON_OBJECT_REQUEST = 3;
    int STRING_REQUEST = 4;
}

