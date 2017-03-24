package wildcodeschool.blablawild;


import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.database.Query;



/**
 * @author greg
 * @since 6/21/13
 *
 * This class is an example of how to use FirebaseListAdapter. It uses the <code>ItineraryModel</code> class to encapsulate the
 * data for each individual chat message
 *
 *
 */
// nom de ma class qui hérite de la firelistadapter <no
public class TripResultAdapter extends FirebaseListAdapter<ItineraryModel> {

    // The mUsername for this client. We use this to indicate which messages originated from this user
    private String mUsername;

    public TripResultAdapter(Query ref, Activity activity, int layout) {
        super(ref, ItineraryModel.class, layout, activity);
        this.mUsername = mUsername;
    }

    @Override
    protected void populateView(View v, ItineraryModel model) {
        TextView TextViewDepartureTime = (TextView)v.findViewById(R.id.TextViewDepartureTime);
        TextView TextViewFirstName = (TextView)v.findViewById(R.id.TextViewFirstName);
        TextView TextViewPrice = (TextView)v.findViewById(R.id.TextViewPrice);

        TextViewDepartureTime.setText(model.getmDeparture());
        TextViewFirstName.setText(model.getmFirstName());
        TextViewPrice.setText(Integer.toString(model.getmPrice()));

    }
}
