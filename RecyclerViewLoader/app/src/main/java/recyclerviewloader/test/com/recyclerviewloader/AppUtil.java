package recyclerviewloader.test.com.recyclerviewloader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class AppUtil {

    public static boolean hasDataConnectivity(Context context) {
        if (context != null) {
            boolean result = true;
            ConnectivityManager connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager
                    .getActiveNetworkInfo();
            if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
                result = false;
            }
            return result;
        } else {
            return false;
        }
    }
}
