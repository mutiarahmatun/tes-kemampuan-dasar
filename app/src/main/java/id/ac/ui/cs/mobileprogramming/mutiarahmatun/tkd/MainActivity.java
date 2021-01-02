package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.util.NetworkChangeReceiver;

public class MainActivity extends AppCompatActivity {

    private NetworkChangeReceiver networkChangeReceiver;
    
    static {
        System.loadLibrary("native-lib");
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);

        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activityMain, HomeFragment.newInstance(), null)
                    .commit();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }
}