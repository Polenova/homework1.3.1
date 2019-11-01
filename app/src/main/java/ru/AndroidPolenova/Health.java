package ru.AndroidPolenova;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormatSymbols;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Health extends AppCompatActivity {
    private static String TAG = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        final EditText editW = (EditText) findViewById(R.id.editW);
        final EditText editSt = (EditText) findViewById(R.id.editSt);
        final TextView result = (TextView) findViewById(R.id.textUsrH);
        Button btnSaveHealth = (Button) findViewById(R.id.buttonSaveW);
        btnSaveHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    try {
                        double weight = Double.parseDouble(editW.getText().toString());
                        int steps = Integer.parseInt(editSt.getText().toString());
                        UserHealth healthInfo = new UserHealth(weight, steps);
                        result.setText(healthInfo.toString());
                    } catch (Exception e) {
                        Toast.makeText(Health.this, "ошибка ввода", Toast.LENGTH_LONG).show();
                        Log.d(TAG, "ошибка");
                    }
                }
        });
    }
}
