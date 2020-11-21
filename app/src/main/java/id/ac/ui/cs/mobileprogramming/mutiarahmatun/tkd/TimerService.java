package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;

public class TimerService extends Service {
    public static final String TIMER_BR =
            "id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.timer";

    private Intent broadcastIntent = new Intent(TIMER_BR);
    private CountDownTimer countdownTimer = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        countdownTimer.cancel();
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        countdownTimer = new CountDownTimer(intent.getExtras()
                .getInt("quizTime"), 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                broadcastIntent.putExtra("countdown", (int)millisUntilFinished / 1000);
                sendBroadcast(broadcastIntent);
            }

            @Override
            public void onFinish() {
                broadcastIntent.putExtra("countdown", 0);
                sendBroadcast(broadcastIntent);
                stopSelf();
            }
        };

        countdownTimer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}
