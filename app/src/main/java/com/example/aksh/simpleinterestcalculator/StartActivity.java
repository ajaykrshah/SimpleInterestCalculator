package com.example.aksh.simpleinterestcalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by Aksh on 26-06-2016.
 */
public class StartActivity extends Activity {

    MediaPlayer sound;
    //long timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);
        

         SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        // Startup sound settings...
              boolean music = preferences.getBoolean("switchBox", true);
        String musicSetting = preferences.getString("SoundList","2");
    
                    //Initial Sound...
                    sound = MediaPlayer.create(getApplication(),R.raw.sound1);
            
                    if (musicSetting.equals("2"))
                        sound = MediaPlayer.create(getApplication(), R.raw.sound2);
    
                    if (music == true) 
                        sound.start();
                       

        // Startup delay settings...

           final int delay;
        boolean StartScreen = preferences.getBoolean("checkBox",true);
        if (StartScreen == true)
            delay = 5000;
        else delay =0;
            Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {

                            sleep(delay);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            Intent mainIntent = new Intent("MAIN_SIC");
                            startActivity(mainIntent);
                        }

                    }
                };
                thread.start();




    }

    @Override
    protected void onPause() {
        super.onPause();
        sound.release();
        finish();
    }
}
