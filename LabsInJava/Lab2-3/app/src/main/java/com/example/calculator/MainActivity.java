package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String expression = "";
    String answer = "";
    TextView text;
    PostFix pc;
    Calculator calc;
    ArrayList<String> list = new ArrayList<>();
    boolean pause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.tv_1);
    }
    public void onClick(View view) {
        try {

            switch ((String) ((Button) view).getText()){
                case "0":
                    text += "0";
                    break;

            }

        }
        catch (Exception e){
            text.setText("Wrong operation");

        }

    }

}
