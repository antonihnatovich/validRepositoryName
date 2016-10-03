package com.nothingwrotehere.validprojectname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btnAct2;
    TextView textViewSavedState;
    EditText editTextEditState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAct2 = (Button)findViewById(R.id.btnAct2);
        btnAct2.setOnClickListener(this);

        textViewSavedState = (TextView) findViewById(R.id.textView);
        editTextEditState = (EditText) findViewById(R.id.editText);
    }
    @Override
    public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, ActivityToNext.class);
                startActivity(intent);

        }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String save = savedInstanceState.getString("saved_state");

        if(save == null){
            Toast.makeText(MainActivity.this, "onRestoreInstanceState:\nNo state saved",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "OnRestoreInstanceState : \nSaved state "+save,
                    Toast.LENGTH_LONG).show();
            textViewSavedState.setText(save);
            editTextEditState.setText(save);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String stateToSave = editTextEditState.getText().toString();
        outState.putString("saved_state", stateToSave);

        Toast.makeText(MainActivity.this, "onSaveInstanceState : \nsaved state "+stateToSave,
                Toast.LENGTH_LONG).show();
    }
}
