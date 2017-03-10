package wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class SearchItineraryActivity extends AppCompatActivity {

    EditText editText8;
    EditText editText9;
    EditText editText10;
    Button button2;
    public final static String EXTRA_OBJET = "donne";
    Calendar myCalendar;



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @RequiresApi(api = Build.VERSION_CODES.N)
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
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                if (editText8.length() != 0 && editText9.length() != 0) {
                    String Depart = editText8.getText().toString();
                    String Destination = editText9.getText().toString();
                    String Date = editText10.getText().toString();

                    SearchRequestModel objet = new SearchRequestModel(Depart, Destination, Date);
                    Intent Resultat = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);

                    Resultat.putExtra(EXTRA_OBJET, objet);
                    startActivity(Resultat);

                } else {

                    //display in short period of time
                    Toast.makeText(SearchItineraryActivity.this, getString(R.string.toast), Toast.LENGTH_SHORT).show();
                }

            }

        });

        // Test du calendar,

        myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        editText10.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(SearchItineraryActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editText10.setText(sdf.format(myCalendar.getTime()));
    }
}

