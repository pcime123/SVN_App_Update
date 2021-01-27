package app_update.sscctv.com.app_update;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


//import com.sscctv.seeeyesupdate.models.Channel;
//import com.sscctv.seeeyesupdate.models.Package;
//import com.sscctv.seeeyesupdate.models.Release;
//import com.sscctv.seeeyesupdate.services.UpdateService;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Update_1903281900";
    private final int ip_version = 1;
//    private final int viewer_version = 2;
//    private final int tdrc_version = 3;
//    private final int tdru_version = 4;
//    private final int launcher_version = 5;
//    private final int manual_version = 6;
//    private final int update_version = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Start UpdateApp");
            setContentView(R.layout.activity_main);

        Button bt_ip = findViewById(R.id.bt_ip);
        Button bt_viewer = findViewById(R.id.bt_viewer);
        Button bt_tdrc = findViewById(R.id.bt_tdrc);
        Button bt_tdru = findViewById(R.id.bt_tdru);
        Button bt_launcher = findViewById(R.id.bt_launcher);
        Button bt_network = findViewById(R.id.bt_network);
        Button bt_packet = findViewById(R.id.bt_packet);
        Button bt_manual = findViewById(R.id.bt_manual);
        Button bt_update = findViewById(R.id.bt_update);

        bt_ip.setOnClickListener(this);
        bt_viewer.setOnClickListener(this);
        bt_tdrc.setOnClickListener(this);
        bt_tdru.setOnClickListener(this);
        bt_launcher.setOnClickListener(this);
        bt_network.setOnClickListener(this);
        bt_packet.setOnClickListener(this);
        bt_manual.setOnClickListener(this);
        bt_update.setOnClickListener(this);

        callFragment(ip_version);

//        updateInstalledAppsInfo();

    }

    @Override
    protected void onResume() {
        buildTimeStamp();
        super.onResume();
    }

    private void buildTimeStamp() {
        Date buildDate = new Date(BuildConfig.TIMESTAMP);
        SimpleDateFormat clsFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        Log.w(TAG, "Build Date: " + clsFormat.format(buildDate));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ip:
                callFragment(ip_version);
                break;
            case R.id.bt_viewer:
                callFragment(2);
                break;
            case R.id.bt_tdrc:
                callFragment(3);
                break;
            case R.id.bt_tdru:
                callFragment(4);
                break;
            case R.id.bt_launcher:
                callFragment(5);
                break;
            case R.id.bt_network:
                callFragment(6);
                break;
            case R.id.bt_packet:
                callFragment(7);
                break;
            case R.id.bt_manual:
                callFragment(8);
                break;
            case R.id.bt_update:
                callFragment(9);
                break;
        }

    }

    private void callFragment(int fragment_no) {

         FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

         switch (fragment_no) {
             case 1:
                 Ip_activity ip_activity = new Ip_activity();
                 transaction.replace(R.id.fragment_container, ip_activity);
                 transaction.commit();
                 break;
             case 2:
                 Viewer_activity viewer_activity = new Viewer_activity();
                 transaction.replace(R.id.fragment_container, viewer_activity);
                 transaction.commit();
                 break;
             case 3:
                 TDRC_acitvity tdrc_acitvity = new TDRC_acitvity();
                 transaction.replace(R.id.fragment_container, tdrc_acitvity);
                 transaction.commit();
                 break;
             case 4:
                 TDRU_activity tdru_activity = new TDRU_activity();
                 transaction.replace(R.id.fragment_container, tdru_activity);
                 transaction.commit();
                 break;
             case 5:
                 Launcher_activity launcher_activity = new Launcher_activity();
                 transaction.replace(R.id.fragment_container, launcher_activity);
                 transaction.commit();
                 break;
             case 6:
                 Network_acitvity network_activity = new Network_acitvity();
                 transaction.replace(R.id.fragment_container, network_activity);
                 transaction.commit();
                 break;
             case 7:
                 Packet_activity packet_activity = new Packet_activity();
                 transaction.replace(R.id.fragment_container, packet_activity);
                 transaction.commit();
                 break;
             case 8:
                 Manual_acitvity manual_activity = new Manual_acitvity();
                 transaction.replace(R.id.fragment_container, manual_activity);
                 transaction.commit();
                 break;
             case 9:
                 Update_activity update_activity = new Update_activity();
                 transaction.replace(R.id.fragment_container, update_activity);
                 transaction.commit();
                 break;

         }

    }


}
