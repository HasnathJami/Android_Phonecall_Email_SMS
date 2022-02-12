package com.example.phonecallsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MakeACallAndSmsOnClick extends AppCompatActivity {

    ImageButton ibtn;
    EditText et, et2,et3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_acall_on_button);

        ibtn = findViewById(R.id.imageButtonId);
        et = findViewById(R.id.editTextId);
        et2 = findViewById(R.id.editText2Id);
        btn = findViewById(R.id.sendMessageId);
        et3=findViewById((R.id.editText3Id));


        ibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = et.getText().toString();
                if (number.isEmpty()) {
                    Toast.makeText(MakeACallAndSmsOnClick.this, "Please Insert Number !", Toast.LENGTH_SHORT).show();
                } else {
                    String s = "tel:" + number;
                    //Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse(s));
                    //Intent intent=new Intent(Intent.ACTION_CALL);
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));

                    // We have give phone_call permission to manifest as well as package manager
                    // For avoiding app crash when permission is not granted the following code is used
                    if (ActivityCompat.checkSelfPermission(MakeACallAndSmsOnClick.this,
                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(MakeACallAndSmsOnClick.this, "Please take permissions!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    et.setText(null);
                    startActivity(intent);



                }
            }
           ;
        });

       // USE SMS MANAGER API to send sms. That will use default phone messages
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ActivityCompat.checkSelfPermission(MakeACallAndSmsOnClick.this,
                        Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(MakeACallAndSmsOnClick.this, "Please take permissions!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String storeText = et2.getText().toString();
                String numberStore=et3.getText().toString();
                if (storeText.isEmpty()) {
                    Toast.makeText(MakeACallAndSmsOnClick.this, "Please Insert some text", Toast.LENGTH_SHORT).show();
                } else {

                    SmsManager smsManager=SmsManager.getDefault();
                    smsManager.sendTextMessage(numberStore,null,storeText,null,null);
                    et2.setText(null);
                    et3.setText(null);
                    Toast.makeText(MakeACallAndSmsOnClick.this, "Sms Sent", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}