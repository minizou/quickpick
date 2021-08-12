package mini.decision_maker;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Random;

public class DecisionService extends Service {
    private Random randomBoolean;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        randomBoolean = new Random();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}