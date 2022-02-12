package com.example.phonecallsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class ComposeCallSmsEmail extends AppCompatActivity {

    Button btn1,btn2;
    Button btn3;
    EditText et1,et2;
    AutoCompleteTextView atv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_and_smsin_dial);

        btn1=findViewById(R.id.callId);
        btn2=findViewById(R.id.smsId);
        btn3=findViewById(R.id.composeButtonId);
        et1=findViewById(R.id.recipientId);
        et2=findViewById(R.id.subjectId);
        atv=findViewById(R.id.messageBodyId);

        //DIAL A NUMBER ON THE DIALPAD
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01712397942"));
                startActivity(intent);


            }
        });

        //Use built In Sms application
        //WRITE A SMS TO A NUMBER IN THE MESSAGE PAD
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:01712397942"));
                intent.putExtra("sms_body","hello world");
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // String r=et1.getText().toString();
                 String r[]={et1.getText().toString()};
                 String s=et2.getText().toString();
                 String b=atv.getText().toString();
                 Intent intent=new Intent(Intent.ACTION_SEND,Uri.parse("mailto:"));
                 intent.setType("text/plain");
                 intent.putExtra(Intent.EXTRA_EMAIL,r);
                 intent.putExtra(Intent.EXTRA_SUBJECT,s);
                 intent.putExtra(Intent.EXTRA_TEXT,b);


                 startActivity(intent);
            }
        });








    }
}