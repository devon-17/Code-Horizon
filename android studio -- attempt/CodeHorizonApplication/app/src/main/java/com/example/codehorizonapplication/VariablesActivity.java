package com.example.codehorizonapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class VariablesActivity extends AppCompatActivity {

    // title
    public TextView question_txt;

    // question one info
    public String question_one = "What is a variable in programming?";
    public String question_one_opt_one = "A way to store information with a label";
    public String question_one_opt_two = "Name for something";
    public String question_one_opt_three = "Conversion of data";

    // question two info
    public String question_two = "What are the different types of Variables in Java?";
    public String question_two_opt_one = "number, text, char, object";
    public String question_two_opt_two = "char, float, int, String";
    public String question_two_opt_three = "boolean, text, object, var";

    // radio group and selection
    public RadioGroup radioGroup;
    int selected;
    String value = "";
    RadioButton opt_1;
    RadioButton opt_2;
    RadioButton opt_3;

    // score and button's
    public int score = 0;
    public Button submitBtn;
    public Button backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variables);

        question_txt = (TextView)findViewById(R.id.question_text);
        radioGroup = (RadioGroup)findViewById(R.id.RadioGroup);
        opt_1 = (RadioButton)findViewById(R.id.radio_btn_1);
        opt_2 = (RadioButton)findViewById(R.id.radio_btn_2);
        opt_3 = (RadioButton)findViewById(R.id.radio_btn_3);
        submitBtn = (Button) findViewById(R.id.submit_btn);
        backBtn = (Button)findViewById(R.id.var_back_btn);

        selected = radioGroup.getCheckedRadioButtonId();
        if(selected != -1) {
            value = ((RadioButton) findViewById(selected)).getText().toString();
        }

        // setting beginning text
        question_txt.setText(question_one);
        opt_1.setText(question_one_opt_one);
        opt_2.setText(question_one_opt_two);
        opt_3.setText(question_one_opt_three);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(selected == -1){

                }

                // question one loop
                if(question_txt.getText() == question_one){
                    if(opt_1.isChecked()){

                        Toast.makeText(VariablesActivity.this, "< Correct Answer />", Toast.LENGTH_SHORT).show();
                        score = score + 1;

                        // setting color for right and wrong answers
                        opt_1.setTextColor(getResources().getColor(R.color.rightAnswerGreen));
                        opt_2.setTextColor(getResources().getColor(R.color.wrongAnswerRed));
                        opt_3.setTextColor(getResources().getColor(R.color.wrongAnswerRed));

                        submitBtn.setEnabled(false);

                        Handler text_color_handler = new Handler();
                        text_color_handler.postDelayed(() ->
                        {
                            submitBtn.setEnabled(true);
                            opt_1.setTextColor(getResources().getColor(R.color.black));
                            opt_2.setTextColor(getResources().getColor(R.color.black));
                            opt_3.setTextColor(getResources().getColor(R.color.black));
                        }, 2000);   // 2 seconds

                        // delay for next question
                        Handler right_answer_delay_handler = new Handler();
                        right_answer_delay_handler.postDelayed(() ->
                        {
                            question_txt.setText(question_two);
                            opt_1.setText(question_two_opt_one);
                            opt_2.setText(question_two_opt_two);
                            opt_3.setText(question_two_opt_three);
                        }, 2000);   // 2 seconds
                    }else{ wrongAnswer(); }
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VariablesActivity.this, HomeActivity.class);
                intent.putExtra("state", "enable");
                startActivity(intent);
            }
        });
    }

    void wrongAnswer(){
        Toast.makeText(VariablesActivity.this, "< Wrong Answer />", Toast.LENGTH_SHORT).show();

        // setting color for wrong answers
        opt_1.setTextColor(getResources().getColor(R.color.wrongAnswerRed));
        opt_2.setTextColor(getResources().getColor(R.color.wrongAnswerRed));
        opt_3.setTextColor(getResources().getColor(R.color.wrongAnswerRed));

        submitBtn.setEnabled(false);

        Handler handler = new Handler();
        handler.postDelayed(() ->
        {
            submitBtn.setEnabled(true);
            opt_1.setTextColor(getResources().getColor(R.color.black));
            opt_2.setTextColor(getResources().getColor(R.color.black));
            opt_3.setTextColor(getResources().getColor(R.color.black));
        }, 2000);   // 2 seconds
    }
}