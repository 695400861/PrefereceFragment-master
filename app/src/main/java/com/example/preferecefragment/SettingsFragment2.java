package com.example.preferecefragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class SettingsFragment2 extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.screenpreference);
    }
}
