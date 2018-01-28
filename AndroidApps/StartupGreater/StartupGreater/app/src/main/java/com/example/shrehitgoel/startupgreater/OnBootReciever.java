package com.example.shrehitgoel.startupgreater;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;

/**
 * Created by Shrehit Goel on 1/27/2018.
 */

public class OnBootReciever extends BroadcastReceiver //implements TextToSpeech.OnInitListener {
{
    private final String UserInput = "user input";
    TextToSpeech tts;
    @Override
    public void onReceive(Context context, Intent intent) {
        String s = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).getString(UserInput, "Hello");
        //Toast.makeText(context.getApplicationContext(),s, Toast.LENGTH_LONG).show();
        Intent speechIntent = new Intent();
        speechIntent.setClass(context.getApplicationContext(), ReadTheMessage.class);
        context.startActivity(speechIntent);
    }
}
