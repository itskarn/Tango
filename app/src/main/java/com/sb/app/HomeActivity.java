package com.sb.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {
    TextView us;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        us=(TextView)findViewById(R.id.name);
         Intent intent = getIntent();
        String un = intent.getStringExtra("USER");
         us.setText(un);
        Toast toast = Toast.makeText(context, "Hello "+un+"!!!",  Toast.LENGTH_SHORT);
        toast.show();
}
}
