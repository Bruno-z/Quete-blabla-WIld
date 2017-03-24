package wildcodeschool.blablawild;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
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
        ListView MaListe = (ListView) findViewById(R.id.MaListe);
        adapter = new TripResultAdapter(mDatabase,ViewSearchItineraryResultsListActivity.this,R.layout.trip_item);

        MaListe.setAdapter(adapter);

        // Listview test //




    }
   /*Override
    public void onStart() {
        super.onStart();
        // Setup our view and list adapter. Ensure it scrolls to the bottom as data changes
        final ListView listView = getListView();
        // Tell our list adapter that we only want 50 messages at a time
        mChatListAdapter = new ChatListAdapter(mFirebaseRef.limit(50), this, R.layout.chat_message, mUsername);
        listView.setAdapter(mChatListAdapter);
        mChatListAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(mChatListAdapter.getCount() - 1); */
            }




