package com.example.varungupta.project4;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
    Thread splashTread;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartAnimations();
    }
    private void StartAnimations() {

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.slide);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    startActivity(intent);


                } catch (InterruptedException e) {
                } finally {
                    MainActivity.this.finish();
                }

            }
        };
        splashTread.start();

    }

}