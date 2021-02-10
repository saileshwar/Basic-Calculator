package com.saileshorg.mycapcalcy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstNumber , secondNumber;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        answer = findViewById(R.id.answer);
    }

    public void calculation(View view) {
        String firstvaluestring = firstNumber.getText().toString();
        String secondvaluestring = secondNumber.getText().toString();

        if (firstvaluestring.isEmpty() || secondvaluestring.isEmpty())
        {
            Toast.makeText(this, "Input Some value", Toast.LENGTH_SHORT).show();
        }
        else {
            try {
                int firstvalueint = Integer.parseInt(firstvaluestring);
                int secondvalueint = Integer.parseInt(secondvaluestring);
                int answerint = 0;
                String answerstring;
                switch (view.getId()){
                    case R.id.addition : answerint = firstvalueint + secondvalueint;
                         answerstring = String.valueOf(answerint);
                        answer.setText("Ans = " + answerstring);
                        break;
                    case R.id.substraction : answerint = firstvalueint - secondvalueint;
                         answerstring = String.valueOf(answerint);
                        answer.setText("Ans = " + answerstring);
                        break;
                    default : try{answerint = firstvalueint /secondvalueint;
                         answerstring = String.valueOf(answerint);
                        answer.setText("Ans = " + answerstring);}
                                catch (Exception e ){
                                   answer.setText("you can not divide by zero");
                                }
                                break;
                }
            }catch (Exception e){
                Toast.makeText(this, "  Give a valid input", Toast.LENGTH_SHORT).show();
            }
        }
    }
}