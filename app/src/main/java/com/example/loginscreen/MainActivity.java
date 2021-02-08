package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static int SPLASH_SCREEN = 5000;
    //variables
    Animation topAnim,BottomAnim ;
    ImageView image;
    TextView logo,slogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation );
        BottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation );

        //Hooks
        image = findViewById(R.id.imageView) ;
        logo = findViewById(R.id.textView) ;
        slogan = findViewById(R.id.textView2) ;

    image.setAnimation(topAnim);
    logo.setAnimation(BottomAnim);
    slogan.setAnimation(BottomAnim);

        //creating new thread just for demonstration of background tasks
        Thread t=new Thread() {
            public void run() {

                try {
                    //sleep thread for 10 seconds
                    sleep(10000);

                    //Call Main activity
                    Intent i=new Intent(MainActivity.this,Dashboard.class);
                    startActivity(i);

                    //destroying Splash activity
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        //start thread
        t.start();
  /*  new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(MainActivity.this,Dashboard.class);
            startActivity(intent);
            finish();
        }
    },SPLASH_SCREEN);*/
    }
}
