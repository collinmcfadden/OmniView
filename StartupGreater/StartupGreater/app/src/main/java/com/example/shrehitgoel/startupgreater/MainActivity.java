package com.example.shrehitgoel.startupgreater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity  {


    private final String UserInput = "user input";
    EditText ed;
    TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ed = findViewById(R.id.texttodisplay);
        ed.setHint(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString(UserInput, ""));
    }

    public void save(View v) {
        String userString = ed.getText().toString();
        PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().putString(UserInput, userString).apply();
        Toast.makeText(getApplicationContext(), "Saved!!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
