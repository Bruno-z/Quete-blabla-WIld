package wildcodeschool.blablawild;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class SearchItineraryActivity extends AppCompatActivity {

    EditText editText8;
    EditText editText9;
    EditText editText10;
    Button button2;
    public final static String EXTRA_OBJET = "donne";


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        button2 = (Button) findViewById(R.id.button2);

        Intent intent = getIntent();


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText8.length() != 0 && editText9.length() != 0) {
                    String Depart = editText8.getText().toString();
                    String Destination = editText9.getText().toString();
                    String Date = editText10.getText().toString();

                    SearchRequestModel objet =new SearchRequestModel(Depart, Destination, Date);
                    Intent  Resultat = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);

                    Resultat.putExtra( EXTRA_OBJET,objet);
                    startActivity(Resultat);

                } else {

                    //display in short period of time
                    Toast.makeText(SearchItineraryActivity.this, getString(R.string.toast), Toast.LENGTH_SHORT).show();
                }
            }

            ;


        });


































    // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("SearchItinerary Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}


