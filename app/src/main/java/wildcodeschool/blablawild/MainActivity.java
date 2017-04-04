package wildcodeschool.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


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
        Button button = (Button) findViewById(R.id.button);
        Button Trajet = (Button) findViewById(R.id.Trajet);
        Button buttonAuth = (Button)findViewById(R.id.buttonAuth);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent page2 = new Intent(MainActivity.this,SearchItineraryActivity.class);
                startActivity(page2);




            }

        });
        Trajet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent trajet = new Intent(MainActivity.this, SubmitItineraryActivity.class);
                startActivity(trajet);
            }
        });

        buttonAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent auth = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(auth);

            }
        });
        };
}