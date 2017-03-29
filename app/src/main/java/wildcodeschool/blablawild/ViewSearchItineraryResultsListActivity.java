package wildcodeschool.blablawild;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
    public ListView maListe;

    TripResultAdapter adapter;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



       /*
        Intent Resultat = getIntent();
        ItineraryModel objet = Resultat.getParcelableExtra(SearchItineraryActivity.EXTRA_OBJET);
      */
        mDatabase = FirebaseDatabase.getInstance().getReference("itineraries");
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        maListe = (ListView) findViewById(R.id.MaListe);

        adapter = new TripResultAdapter(mDatabase,ViewSearchItineraryResultsListActivity.this,R.layout.trip_item);

        maListe.setAdapter(adapter);

        // Listview test //




    }
        @Override
    public void onStart() {
        super.onStart();
        // Setup our view and list adapter. Ensure it scrolls to the bottom as data changes
        //final ListView listView = getListView();
        // Tell our list adapter that we only want 50 messages at a time


        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                maListe.setSelection(adapter.getCount() - 1);
            }
        });
   }
}





