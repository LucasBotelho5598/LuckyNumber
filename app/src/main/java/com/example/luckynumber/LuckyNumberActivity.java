package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckyNumberActivity extends AppCompatActivity {

    TextView lucky_number_txt, welcomeTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_number);

        welcomeTxt = findViewById(R.id.textView2);
        lucky_number_txt = findViewById(R.id.lucky_number_txt);
        share_btn = findViewById(R.id.share_number_btn);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");
        int random_Num = generateRandomNumber();

        lucky_number_txt.setText(""+random_Num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName,random_Num);

            }
        });


    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit=1000;

        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }

    public void shareData(String username,int randomNum){

        Intent i = new Intent(Intent.ACTION_SEND);

        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,username);
        i.putExtra(Intent.EXTRA_TEXT,randomNum);

        startActivity(Intent.createChooser(i,"Choose a platform"));

    }
}