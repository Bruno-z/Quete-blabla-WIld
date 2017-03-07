package wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Date;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);



        Intent Resultat = getIntent();
        SearchRequestModel objet= Resultat.getParcelableExtra(SearchItineraryActivity.EXTRA_OBJET);

        Toast.makeText(this, objet.getDate(), Toast.LENGTH_SHORT).show();
        this.setTitle(objet.getDepart()+" "+getString(R.string.fleche1)+" "+objet.getDestination());



    }
}
