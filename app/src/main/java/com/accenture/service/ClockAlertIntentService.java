package com.accenture.service;


import android.app.Service;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.IBinder;
//import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


public class ClockAlertIntentService extends Service {
//    private Vibrator vibrator;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("ClockAlertIntentService","onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("ClockAlertIntentService","onStartCommand()");
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        if(min == 0){
//            vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//            long [] pattern = {100,400,100,400};
//            vibrator.vibrate(pattern,2);

            Toast.makeText(getBaseContext(),"现在是"+hour+"点整",Toast.LENGTH_SHORT).show();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ClockAlertIntentService","onDestroy()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("ClockAlertIntentService","onBind()");
        return null;
    }
}
