package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.opengl.OpenGLView;

public class SplashScreenActivity extends AppCompatActivity {

    private OpenGLView openGL;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash_screen);
        openGL = findViewById(R.id.openGL);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        openGL.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        openGL.onPause();
    }

}
