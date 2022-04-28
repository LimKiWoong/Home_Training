package com.woongs.home_training;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.BaseAdapter;

import androidx.annotation.Nullable;

public class SettingPreferenceFragment extends PreferenceFragment {

    SharedPreferences prefs;

    ListPreference breaktime_preference;
    ListPreference readytime_preference;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.setting_preference);

        breaktime_preference = (ListPreference) findPreference("breaktime_value");
        breaktime_preference.setSummary(breaktime_preference.getEntry());

        readytime_preference = (ListPreference) findPreference("ready_value");
        readytime_preference.setSummary(readytime_preference.getEntry());

        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

    }

    SharedPreferences.OnSharedPreferenceChangeListener preListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if(key.equals("breaktime_value")){
                breaktime_preference.setSummary(breaktime_preference.getEntry());
            }
            if(key.equals("ready_value")){
                readytime_preference.setSummary(readytime_preference.getEntry());
            }
            ((BaseAdapter)getPreferenceScreen().getRootAdapter()).notifyDataSetChanged();
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(preListener);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(preListener);
    }
}
