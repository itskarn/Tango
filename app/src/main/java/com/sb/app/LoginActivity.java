package com.sb.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    EditText UserName,Password;
    TextView Register;
    Button Login;
    Context context=this;
    boolean loginstatus=false;
    String Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        UserName=(EditText)findViewById(R.id.usernameEdit);
        Password=(EditText)findViewById(R.id.passwordEdit);
        Register=(TextView)findViewById(R.id.login_register);
        Login=(Button)findViewById(R.id.loginButton);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchandlogin();
            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerView =new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registerView);
            }
        });


}
    private  void fetchandlogin()
    {
       String un=UserName.getText().toString();
        String pw=Password.getText().toString();
       DbOperation dop=new DbOperation(context);
        Cursor cr=dop.getInformation(dop);
        cr.moveToFirst();
        do{
            if(un.equals(cr.getString(0))&&(pw.equals(cr.getString(1))))
            {
               loginstatus=true;
                Name=cr.getString(0);
                Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
               intent.putExtra("USER",Name);
                startActivity(intent);
                //finish();
                //Toast toast = Toast.makeText(context, "Hello "+Name+"!!!",  Toast.LENGTH_SHORT);
               // toast.show();
            }
        }while(cr.moveToNext());

    }
}
