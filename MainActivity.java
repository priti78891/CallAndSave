package com.example.call;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText=(EditText)findViewById(R.id.editText);
        Button buttonNine = findViewById(R.id.buttonNine);
        Button buttonEight = findViewById(R.id.buttonEight);
        Button buttonSeven = findViewById(R.id.buttonSeven);
        Button buttonSix = findViewById(R.id.buttonSix);
        Button buttonFive = findViewById(R.id.buttonFive);
        Button buttonFour = findViewById(R.id.buttonFour);
        Button buttonThree = findViewById(R.id.buttonThree);
        Button buttonTwo = findViewById(R.id.buttonTwo);
        Button buttonOne = findViewById(R.id.buttonOne);
        Button buttonZero = findViewById(R.id.buttonZero);
        Button buttondel = findViewById(R.id.buttondel);
        Button buttonCall = findViewById(R.id.buttoncall);
        Button buttonsave = findViewById(R.id.buttonsave);
        Button buttonStar = findViewById(R.id.buttonstar);
        Button buttonHash = findViewById(R.id.buttonhash);

        //EditText text = (EditText) findViewById(R.id.editText);
        PhoneNumberUtils.formatNumber(editText.getText().toString());

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "0");
            }
        });
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "1");
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "2");
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "3");
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "4");
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "5");
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "6");
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "7");
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "8");
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "9");
            }
        });
        buttonStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "*");
            }
        });
        buttonHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "#");
            }
        });

        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().length() > 0) {
                    String phStr = "tel:" +editText.getText().toString();
                    makePhoneCall(phStr);
                }else{
                    Toast.makeText(MainActivity.this, "Unable to call",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().length() > 0) {
                    CharSequence currentText = editText.getText();
                    editText.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    editText.setText("");
                }
            }
        });
        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editText.getText().toString().isEmpty()){
                    String phoneNumber=editText.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
                    intent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNumber);
                    if(intent.resolveActivity(getPackageManager())!=null){
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),"No app to support", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void makePhoneCall(String PhStr){
        Intent callIntent = new Intent(Intent.ACTION_CALL,Uri.parse(PhStr));
        //callIntent.setData(Uri.parse(PhStr));
        startActivity(callIntent);
    }

}