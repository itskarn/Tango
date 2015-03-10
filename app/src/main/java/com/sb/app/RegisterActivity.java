package com.sb.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    EditText UserName,Password,ConfirmPassword;
    Button Register;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        UserName=(EditText)findViewById(R.id.register_usernameEdit);
        Password=(EditText)findViewById(R.id.register_passwordEdit1);
        ConfirmPassword=(EditText)findViewById(R.id.register_passwordEdit2);
        Register=(Button)findViewById(R.id.register_registerButton);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((Password.getText().toString()).equals(ConfirmPassword.getText().toString()))
                {
                    insertData();
                    finish();
                }
                else
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(
                            RegisterActivity.this).create();
                    alertDialog.setTitle("Password Mismatch");
                    alertDialog.setMessage("Please enter details correctly");
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            UserName.setText("");
                            Password.setText("");
                            ConfirmPassword.setText("");
                            UserName.requestFocus();
                        }
                    });
                    alertDialog.show();
                }
            }
        });
    }

 private void insertData(){
     String un= UserName.getText().toString();
     String pw= Password.getText().toString();
     DbOperation dob=new DbOperation(context);
     dob.putInformation(dob,un,pw);
     Toast toast = Toast.makeText(context, "Registered Successfully",  Toast.LENGTH_SHORT);
     toast.show();
 }
}
