package com.example.shrehitgoel.startupgreater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.widget.EditText;

/**
 * Created by Shrehit Goel on 1/28/2018.
 */
public class ReadTheMessage extends Activity implements TextToSpeech.OnInitListener {

    private final String UserInput = "user input";
    EditText ed;
    TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tts = new TextToSpeech(getApplicationContext(), this);
    }



    @Override
    public void onInit(int status) {
        String toSpeak = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString(UserInput, "Hello");
        tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null,null);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}