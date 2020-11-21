package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    private Toast toast;

    @Override
    public void onReceive(final Context context, final Intent intent) {

        if (this.toast != null) {
            toast.cancel();
        }

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                toast = Toast.makeText(context, "Wifi available", Toast.LENGTH_SHORT);
                toast.show();
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                toast = Toast.makeText(context, "Mobile data available", Toast.LENGTH_SHORT);
                toast.show();
            }
        } else {
            toast = Toast.makeText(context, "No internet available", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
