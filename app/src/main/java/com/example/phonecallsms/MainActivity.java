package com.example.phonecallsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.textViewId);
        btn=findViewById(R.id.buttonId);
        String str=tv.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                  //Share Text
                  /*
                  // Intent intent=new Intent();
                  intent.setAction(Intent.ACTION_SEND);
                  intent.setType("text/plain");

                  Bundle bundle =new Bundle();
                  bundle.putString(Intent.EXTRA_TEXT,str);
                   intent.putExtras(bundle);
                //intent.putExtra(Intent.EXTRA_TEXT,str);
                  */


                /*
                 //Send Sms





                */

                  Intent intent = new Intent();

                  startActivity(intent);
            }
        });


    }
}