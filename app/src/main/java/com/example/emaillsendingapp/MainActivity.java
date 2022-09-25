package com.example.emaillsendingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextTo=findViewById(R.id.edittextTo);
        EditText editTextSubj=findViewById(R.id.EditTextSubject);
        EditText editTextMsg=findViewById(R.id.editTextMessage);

        Button sendbutton=findViewById(R.id.sendbutton);
        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String receipentList=editTextTo.getText().toString();
                String[] receipents=receipentList.split(",");

                String Subject=editTextSubj.getText().toString();
                String Message=editTextMsg.getText().toString();

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,receipents);
                intent.putExtra(Intent.EXTRA_SUBJECT,Subject);
                intent.putExtra(Intent.EXTRA_TEXT,Message);


                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose an Email Client:"));

            }
        });

    }

}