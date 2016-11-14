package recyclerviewloader.test.com.recyclerviewloader.communication;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import recyclerviewloader.test.com.recyclerviewloader.NewsListApplication;


public class NetworkManager implements NetworkOptions, Response.ErrorListener {

    /**
     * Static declarations
     */
    private static final int MY_SOCKET_TIMEOUT_MS = 60000;
    private static NetworkManager mNetworkManager = null;

    private OnNetWorkListener mNetWorkListener = null;

    private boolean mIsProgressEnabled = false;
    private ProgressDialog mDialog = null;
    private JsonObjectRequest mRequest;
    private RequestQueue mRequestQueue;
    private Context context;

    /**
     * Limiting the constructor for accessing public
     */
    private NetworkManager(Context mContext) {
        this.context = mContext;
        getRequestQueue(context);
    }


    /**
     * Singleton managed class
     *
     * @return It will return the Singleton instance of a {@link NetworkManager}
     */
    public static NetworkManager getInstance(Context context) {
        if (mNetworkManager == null)
            mNetworkManager = new NetworkManager(context);

        return mNetworkManager;
    }

    /**
     * Creating {@link ProgressDialog}
     *
     * @param context            {@link Context} of the {@link android.app.Activity}
     * @param message            {@link ProgressDialog#setMessage(CharSequence)}
     * @param cancelTouchOutSide {@link ProgressDialog#setCanceledOnTouchOutside(boolean)}
     */
    public void setProgressDialog(Context context, String message, boolean cancelTouchOutSide) {
        mDialog = new ProgressDialog(context);
        mDialog.setMessage(message);
        mDialog.setCanceledOnTouchOutside(cancelTouchOutSide);
        mIsProgressEnabled = true;
        mDialog.show();

    }

    /**
     * This method sending {@link JSONObject} to server
     *
     * @param requestType Type of the mRequest <font color=black>eg: {@link NetworkOptions#POST_REQUEST}, {@link NetworkOptions#GET_REQUEST}</font>
     * @param url         Server URL
     * @param requestId   Request id for identifying the requested method
     */
    public void getJsonRequestWithHeaders(int requestType, String url, final int requestId) {
        Log.d("SEND REQUEST", url);


        mRequest = new JsonObjectRequest(requestType, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                NetworkManager.this.mNetWorkListener.onResponse(response, JSON_OBJECT_REQUEST, requestId);
                Log.d("SERVER RESPONSE", response.toString());

                if (mIsProgressEnabled) {
                    mDialog.dismiss();
                    mIsProgressEnabled = false;
                }
            }

        }, this);
        mRequest.setRetryPolicy(new DefaultRetryPolicy(50000000,
                0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        addToRequestQueue(mRequest, requestId + "");
    }
    /**
     * Adding {@link Request} to queue
     *
     * @param request add request to Queue.
     * @param <T>     Type of a {@link Request}
     */
    private <T> void addToRequestQueue(Request<T> request, String tag) {
        if (mRequestQueue != null) {
            if (tag.length() > 0)
                mRequest.setTag(tag);
            mRequestQueue.add(request);
        }
    }

    private void getRequestQueue(Context context) {

        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }
    }

    private void setRequestTimeout(Request request) {
        request.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    /**
     * Cancel the mRequest
     */
    public void cancelRequest() {
        if (mRequest != null && !mRequest.isCanceled()) {
            mRequest.cancel();
            NewsListApplication.getInstance().getRequestQueue().cancelAll(mRequest.getTag());
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        NetworkManager.this.mNetWorkListener.onErrorResponse(error);
        if (mIsProgressEnabled)
            mDialog.dismiss();
    }

    /**
     * Setup {@link com.android.volley.toolbox.Volley} network callback
     */
    public void setOnNetworkListener(OnNetWorkListener onNetworkListener) {
        this.mNetWorkListener = onNetworkListener;
    }

    /**
     * This callback for {@link com.android.volley.toolbox.Volley} Network management
     */
    public interface OnNetWorkListener {

        /**
         * This method will return the throwed excepption details from {@link com.android.volley.toolbox.Volley}
         *
         * @param error returns {@link VolleyError}
         */
        void onErrorResponse(VolleyError error);

        /**
         * This listener for listening {@link com.android.volley.toolbox.Volley} network response
         *
         * @param object    object From server its an instance of {@link JSONObject}
         * @param type      Type of the mRequest <font color=black>eg: {@link NetworkOptions#POST_REQUEST}, {@link NetworkOptions#GET_REQUEST}</font>
         * @param requestId Request id for identifying the requested method
         */
        void onResponse(Object object, int type, int requestId);
    }



}
