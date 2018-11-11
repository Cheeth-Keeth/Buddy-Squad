package ca.hack.boston.buddysquad;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class myGroup extends AppCompatActivity {

    String getName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_group);
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

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            getName = (String) bd.get("username");

        }


        HttpUtils.get("findUser/" + getName, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                super.onSuccess(statusCode, headers, responseString);
            }

            String id = "";
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                try {
                    String id = String.valueOf(response.getString("id"));
                    TextView groupID = (TextView) findViewById(R.id.groupid);
                    groupID.setText(id);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
               System.out.print("fail");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }


        });

    }

    public void refresh(View v) {

        final TextView IDText = (TextView) findViewById(R.id.groupid);
        final String id = IDText.getText().toString();

        HttpUtils.get("findGroupData/" + id, new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);

                int count = 0;
                int people = 0;

                for (int i = 0; i < response.length(); i++) {

                    JSONObject obj = null;

                    if (i == 0) {

                        people++;

                        try {
                            obj = response.getJSONObject(i);

                            String user1 = obj.getString("username");
                            TextView username = (TextView) findViewById(R.id.User1);
                            username.setText(user1);

                            boolean fitness = obj.getBoolean("fitnessComplete");
                            boolean learning = obj.getBoolean("learningComplete");
                            boolean miscellaneous = obj.getBoolean("miscellaneousComplete");

                            if (fitness) {

                                count++;
                                Button btn = (Button) findViewById(R.id.L1);
                                btn.setBackgroundColor(Color.YELLOW);

                            }

                            if (learning) {

                                count++;
                                Button btn = (Button) findViewById(R.id.M1);
                                btn.setBackgroundColor(Color.YELLOW);

                            }

                            if (miscellaneous) {

                                count++;
                                Button btn = (Button) findViewById(R.id.R1);
                                btn.setBackgroundColor(Color.YELLOW);

                            }

                        } catch (JSONException e) {

                        }


                    } if (i == 1) {

                        people++;

                        try {

                            obj = response.getJSONObject(i);

                            String user2 = obj.getString("username");
                            TextView username = (TextView) findViewById(R.id.User2);
                            username.setText(user2);

                            boolean fitness = obj.getBoolean("fitnessComplete");
                            boolean learning = obj.getBoolean("learningComplete");
                            boolean miscellaneous = obj.getBoolean("miscellaneousComplete");

                            if (fitness) {

                                count++;
                                Button btn = (Button) findViewById(R.id.L2);
                                btn.setBackgroundColor(Color.YELLOW);

                            }

                            if (learning) {

                                count++;
                                Button btn = (Button) findViewById(R.id.M2);
                                btn.setBackgroundColor(Color.YELLOW);

                            }

                            if (miscellaneous) {

                                count++;
                                Button btn = (Button) findViewById(R.id.R2);
                                btn.setBackgroundColor(Color.YELLOW);

                            }

                        } catch (JSONException e) {

                        }

                    } if (i == 2) {

                        people++;

                        try {
                            obj = response.getJSONObject(i);

                            String user3 = obj.getString("username");
                            TextView username = (TextView) findViewById(R.id.User3);
                            username.setText(user3);

                            boolean fitness = obj.getBoolean("fitnessComplete");
                            boolean learning = obj.getBoolean("learningComplete");
                            boolean miscellaneous = obj.getBoolean("miscellaneousComplete");

                            if (fitness) {

                                count++;
                                Button btn = (Button) findViewById(R.id.L3);
                                btn.setBackgroundColor(Color.YELLOW);

                            }

                            if (learning) {

                                count++;
                                Button btn = (Button) findViewById(R.id.M3);
                                btn.setBackgroundColor(Color.YELLOW);

                            }

                            if (miscellaneous) {

                                count++;
                                Button btn = (Button) findViewById(R.id.R3);
                                btn.setBackgroundColor(Color.YELLOW);

                            }

                        } catch (JSONException e) {

                        }

                    }

                }

                if (count/people == 3) {

                    TextView message = (TextView) findViewById(R.id.congrats);
                    message.setText("Congrats you all completed your tasks!!!");

                }

            }
        });

    }

    public void reset(View v) {

        final TextView IDText = (TextView) findViewById(R.id.groupid);
        final String id = IDText.getText().toString();

        HttpUtils.get("clearActivities/" + id, new RequestParams(), new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
            }
        });

        Button btn1 = (Button) findViewById(R.id.L1);
        btn1.setBackgroundColor(Color.GRAY);

        Button btn2 = (Button) findViewById(R.id.M1);
        btn2.setBackgroundColor(Color.GRAY);

        Button btn3 = (Button) findViewById(R.id.R1);
        btn3.setBackgroundColor(Color.GRAY);

        Button btn4 = (Button) findViewById(R.id.L2);
        btn4.setBackgroundColor(Color.GRAY);

        Button btn5 = (Button) findViewById(R.id.M2);
        btn5.setBackgroundColor(Color.GRAY);

        Button btn6 = (Button) findViewById(R.id.R2);
        btn6.setBackgroundColor(Color.GRAY);

        Button btn7 = (Button) findViewById(R.id.L3);
        btn7.setBackgroundColor(Color.GRAY);

        Button btn8 = (Button) findViewById(R.id.M3);
        btn8.setBackgroundColor(Color.GRAY);

        Button btn9 = (Button) findViewById(R.id.R3);
        btn9.setBackgroundColor(Color.GRAY);

    }

    public void ComL1(View v) {

        final TextView IDText = (TextView) findViewById(R.id.User1);
        final String user1 = IDText.getText().toString();

        if (getName.equals(user1)) {

            HttpUtils.post("completeFitness/" + getName, new RequestParams(), new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                }
            });

            Button btn = (Button) findViewById(R.id.L1);
            btn.setBackgroundColor(Color.YELLOW);


        }

    }

    public void ComM1(View v) {

        final TextView IDText = (TextView) findViewById(R.id.User1);
        final String user1 = IDText.getText().toString();

        if (getName.equals(user1)) {


            HttpUtils.post("completeLearning/" + getName, new RequestParams(), new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                }
            });

            Button btn = (Button) findViewById(R.id.M1);
            btn.setBackgroundColor(Color.YELLOW);

        }

    }

    public void ComR1(View v) {

        final TextView IDText = (TextView) findViewById(R.id.User1);
        final String user1 = IDText.getText().toString();

        if (getName.equals(user1)) {


            HttpUtils.post("completeMiscellaneous/" + getName, new RequestParams(), new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                }
            });

            Button btn = (Button) findViewById(R.id.R1);
            btn.setBackgroundColor(Color.YELLOW);

        }

    }

    public void ComL2(View v) {

        final TextView IDText = (TextView) findViewById(R.id.User2);
        final String user2 = IDText.getText().toString();

        if (getName.equals(user2)) {

            HttpUtils.post("completeFitness/" + getName, new RequestParams(), new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                }
            });

            Button btn = (Button) findViewById(R.id.L2);
            btn.setBackgroundColor(Color.YELLOW);


        }

    }

    public void ComM2(View v) {

        final TextView IDText = (TextView) findViewById(R.id.User2);
        final String user2 = IDText.getText().toString();

        if (getName.equals(user2)) {

            HttpUtils.post("completeLearning/" + getName, new RequestParams(), new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                }
            });

            Button btn = (Button) findViewById(R.id.M2);
            btn.setBackgroundColor(Color.YELLOW);


        }

    }

    public void ComR2(View v) {

        final TextView IDText = (TextView) findViewById(R.id.User2);
        final String user2 = IDText.getText().toString();

        if (getName.equals(user2)) {

            HttpUtils.post("completeMiscellaneous/" + getName, new RequestParams(), new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                }
            });

            Button btn = (Button) findViewById(R.id.R2);
            btn.setBackgroundColor(Color.YELLOW);


        }

    }

    public void ComL3(View v) {

        final TextView IDText = (TextView) findViewById(R.id.User3);
        final String user3 = IDText.getText().toString();

        if (getName.equals(user3)) {

            HttpUtils.post("completeFitness/" + getName, new RequestParams(), new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                }
            });

            Button btn = (Button) findViewById(R.id.L3);
            btn.setBackgroundColor(Color.YELLOW);


        }

    }

    public void ComM3(View v) {

        final TextView IDText = (TextView) findViewById(R.id.User3);
        final String user3 = IDText.getText().toString();

        if (getName.equals(user3)) {

            HttpUtils.post("completeLearning/" + getName, new RequestParams(), new JsonHttpResponseHandler() {

                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                    super.onSuccess(statusCode, headers, response);
                }
            });

            Button btn = (Button) findViewById(R.id.M3);
            btn.setBackgroundColor(Color.YELLOW);


        }

    }

    public void ComR3(View v) {

            final TextView IDText = (TextView) findViewById(R.id.User3);
            final String user3 = IDText.getText().toString();

            if (getName.equals(user3)) {

                HttpUtils.post("completeMiscellaneous/" + getName, new RequestParams(), new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        super.onSuccess(statusCode, headers, response);
                    }
                });

                Button btn = (Button) findViewById(R.id.R3);
                btn.setBackgroundColor(Color.YELLOW);
            }


        }


}
