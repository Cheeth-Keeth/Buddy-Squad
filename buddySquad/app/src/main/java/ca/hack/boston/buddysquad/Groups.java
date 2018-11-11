package ca.hack.boston.buddysquad;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import cz.msebera.android.httpclient.Header;

public class Groups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
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

        TextView username = (TextView) findViewById(R.id.Usernametext);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            String getName = (String) bd.get("username");
            username.setText(getName);
            String fitness = (String) bd.get("fitness");
            String learning = (String) bd.get("learning");
            String miscellaneous = (String) bd.get("miscellaneous");

            HttpUtils.get("findGroup/" + fitness + "/" + learning + "/" + miscellaneous, new RequestParams(), new JsonHttpResponseHandler(){
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);

                    String availablespots= "";
                    String name = "";
                    String list = "";
                    for (int i =0 ; i< response.length(); i++){

                        JSONObject obj = null;

                        try{
                            obj = response.getJSONObject(i);
                            availablespots = obj.getString("availableSeats");
                            name = obj.getString("name");

                        }
                        catch (JSONException e) {

                        }
                        list += "Available Spots: " + availablespots + " Name: " + name + "\n\n";
                    }
                    TextView listText = (TextView) findViewById(R.id.Squadtextview);
                    listText.setText(list);

                }
            });

        }



    }


    public void joinSquad(View v) {

        final EditText squadedittext = (EditText) findViewById(R.id.SquadeditText);
        String squad = squadedittext.getText().toString();
        final TextView usernameTextView = (TextView) findViewById(R.id.Usernametext);
        String username = usernameTextView.getText().toString();


        HttpUtils.get("joinGroup/" + username + "/" + squad, new RequestParams(), new JsonHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers , JSONObject response){
                super.onSuccess(statusCode, headers, response);

                try {
                    String hello = response.getString("name");
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                super.onSuccess(statusCode, headers, responseString);
            }

        });

        Intent startIntent = new Intent(getApplicationContext(), myGroup.class);
        startIntent.putExtra("username", username);
        startActivity(startIntent);
    }


}

