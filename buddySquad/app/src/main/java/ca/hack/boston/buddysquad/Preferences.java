package ca.hack.boston.buddysquad;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class Preferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
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

        final Spinner fitnessSpinner = (Spinner) findViewById(R.id.FitnessSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.fitness_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fitnessSpinner.setAdapter(adapter);

        final Spinner learningSpinner = (Spinner) findViewById(R.id.LearningSpinner);
        ArrayAdapter<CharSequence> adapterTwo = ArrayAdapter.createFromResource(this,
                R.array.learning_array, android.R.layout.simple_spinner_item);
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        learningSpinner.setAdapter(adapterTwo);

        final Spinner miscellaneousSpinner = (Spinner) findViewById(R.id.MiscellaneousSpinner);
        ArrayAdapter<CharSequence> adapterThree = ArrayAdapter.createFromResource(this,
                R.array.miscellaneous_array, android.R.layout.simple_spinner_item);
        adapterThree.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        miscellaneousSpinner.setAdapter(adapterThree);


        TextView username = (TextView) findViewById(R.id.UsernametextView);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            String getName = (String) bd.get("username");
            username.setText(getName);
        }
    }

    public void findSquad(View v) {

       final TextView usernameText = (TextView) findViewById(R.id.UsernametextView);
       final String username = usernameText.getText().toString();

        final Spinner fitnessSpinner = (Spinner) findViewById(R.id.FitnessSpinner);
        String fitnessString = fitnessSpinner.getSelectedItem().toString();
        final Spinner learningSpinner = (Spinner) findViewById(R.id.LearningSpinner);
        String learningString = learningSpinner.getSelectedItem().toString();
        final Spinner miscellaneousSpinner = (Spinner) findViewById(R.id.MiscellaneousSpinner);
        String miscellaneousString = miscellaneousSpinner.getSelectedItem().toString();


        Intent startIntent = new Intent(getApplicationContext(), Groups.class);
        startIntent.putExtra("username", username);
        startIntent.putExtra("fitness", fitnessString);
        startIntent.putExtra("learning", learningString);
        startIntent.putExtra("miscellaneous", miscellaneousString);
        startActivity(startIntent);
    }

}




