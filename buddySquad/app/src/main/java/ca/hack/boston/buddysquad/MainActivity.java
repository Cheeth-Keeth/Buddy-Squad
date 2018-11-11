package ca.hack.boston.buddysquad;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.MotionEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.PopupWindow;


import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void signUp(View v) {
        final TextView usernameTextView = (TextView) findViewById(R.id.usernameEditText);
        final TextView passwordTextView = (TextView) findViewById(R.id.passwordEditText);
        String username = usernameTextView.getText().toString();
        String password = passwordTextView.getText().toString();

        HttpUtils.post("createUser/" + username + "/" + password, new RequestParams(), new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
            }
        });

            Intent startIntent = new Intent(getApplicationContext(), Preferences.class);
            startIntent.putExtra("username", username);
            startActivity(startIntent);
        }

    public void signIn(View v) {




        final TextView usernameTextView = (TextView) findViewById(R.id.usernameEditText);
        final TextView passwordTextView = (TextView) findViewById(R.id.passwordEditText);
        String username = usernameTextView.getText().toString();
        String password = passwordTextView.getText().toString();

        HttpUtils.get("findUser/" + username + "/" + password, new RequestParams(), new JsonHttpResponseHandler() {


                @Override
                public void onSuccess(int statusCode, Header[] headers , JSONObject response){
                    super.onSuccess(statusCode, headers, response);

                }

        });

        Intent startIntent = new Intent(getApplicationContext(), myGroup.class);
        startIntent.putExtra("username", username);
        startActivity(startIntent);


    }
}







