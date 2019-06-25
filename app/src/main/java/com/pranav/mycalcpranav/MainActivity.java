package com.pranav.mycalcpranav;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText operandOne;
    private EditText operandTwo, ResultEd;
    private Spinner operator;
    private Button calcBtn;
    String res = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operator = (Spinner) findViewById(R.id.spinner);
        operandOne = (EditText) findViewById(R.id.opOneView);
        operandTwo = (EditText) findViewById(R.id.opTwoView);
        ResultEd = (EditText) findViewById(R.id.resultEdView);

        operator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Double opOne = Double.parseDouble((operandOne.getText().toString()));
                Double opTwo = Double.parseDouble((operandTwo.getText().toString()));
                switch (position) {

                    case 0:
                        Toast.makeText(MainActivity.this, "Choose from the List", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        res = String.valueOf(opOne + opTwo);

                        break;
                    case 2:
                        res = String.valueOf(opOne - opTwo);

                        break;

                    case 3:
                        res = String.valueOf(opOne * opTwo);

                        break;
                    case 4:

                        res = String.valueOf(opOne / opTwo);

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Choose from the List", Toast.LENGTH_SHORT).show();
            }
        });

        calcBtn = findViewById(R.id.calcBtnView);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Double.parseDouble(res) < 0) {
                    ResultEd.setTextColor(Color.RED);
                } else if (Double.parseDouble(res) == 0) {
                    ResultEd.setTextColor(Color.BLUE);
                } else if (Double.parseDouble(res) > 0) {
                    ResultEd.setTextColor(Color.GREEN);
                }

                ResultEd.setText(res);
            }
        });

    }


}
