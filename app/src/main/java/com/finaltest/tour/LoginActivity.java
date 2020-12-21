package com.finaltest.tour;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnlog;
    EditText eun, epwd;

    int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eun = (EditText) findViewById(R.id.edtuname);
        epwd = (EditText) findViewById(R.id.edtpwd);
        btnlog = (Button) findViewById(R.id.btnlogin);

        btnlog.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v == btnlog) {

            String strun = eun.getText().toString();
            String strpwd = epwd.getText().toString();

            boolean blun = strun.equals("user1");
            boolean blpwd = strpwd.equals("password1");


            if (TextUtils.isEmpty(strun) || TextUtils.isEmpty(strpwd)) {


                eun.setError("Enter Username");
                epwd.setError("Enter Password");

                eun.setText(" ");
                epwd.setText("");

                eun.requestFocus();
                return;

            }

            else if (blun == false)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Invalid Username")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //do things
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

                eun.setText("");

            }

            else if (blpwd == false)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Invalid Password")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //do things
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

                epwd.setText("");

            }

            else if (blun && blpwd)
            {
                Intent inlog = new Intent(getApplicationContext(), MainActivity.class);
                //inlog.putExtra("name", struname);
                //cnt = 0;
                startActivity(inlog);
            }
            else
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Please Enter Credentials")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //do things
                            }
                        });
            }

        }
    }

}