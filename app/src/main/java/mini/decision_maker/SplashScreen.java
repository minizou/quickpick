package mini.decision_maker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH_DELAY = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            SplashScreen.this.startActivity(intent);
            SplashScreen.this.finish();
            overridePendingTransition(0, R.anim.screen_splash_fade_out);
        }, SPLASH_DELAY);
    }
}