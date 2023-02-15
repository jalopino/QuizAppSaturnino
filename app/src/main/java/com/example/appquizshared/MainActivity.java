package com.example.appquizshared;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText empID, name, basicSal;
        Button save, retrieve;
        TextView outEmpID, outName, outBasicSal;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empID = findViewById(R.id.EmpID);
        name = findViewById(R.id.Name);
        basicSal = findViewById(R.id.BasicSal);
        save = findViewById(R.id.save);
        retrieve = findViewById(R.id.retrieve);
        outEmpID = findViewById(R.id.OutEmpID);
        outName = findViewById(R.id.OutName);
        outBasicSal = findViewById(R.id.OutBasicSal);
        //Save Data
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData("empID", empID.getText().toString());
                saveData("name", name.getText().toString());
                saveData("basicSal", basicSal.getText().toString());
            }
        });
        //Load Data
        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sEmp = loadData("empID");
                String sName = loadData("name");
                String sBasic = loadData("basicSal");

                outEmpID.setText(sEmp);
                outName.setText(sName);
                outBasicSal.setText(sBasic);
            }
        });
    }

    private void saveData(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private String loadData(String key) {
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }
}