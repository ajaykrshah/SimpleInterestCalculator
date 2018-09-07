package com.example.aksh.simpleinterestcalculator;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Aksh on 26-06-2016.
 */
public class SettingsActivity extends PreferenceActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }

}
