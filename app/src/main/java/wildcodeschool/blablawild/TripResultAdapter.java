package wildcodeschool.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by apprenti on 07/03/17.
 */

public class TripResultAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<TripResultModel> items; //data of the list adapter
    private TextView TextViewFirstName;

    //public consructor
    public TripResultAdapter(Context context, ArrayList<TripResultModel> items){
        this.context = context;
        this.items =items;

    }

    @Override
    public int getCount() {
        return this.items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate layout for each list row
        if(convertView == null){
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.trip_item, parent, false);
        }

        // get current item to be displayed
        TripResultModel currentItem = (TripResultModel) getItem(position);

        // get the TextView for item name and item description
        TextView textViewItemName = (TextView)
                convertView.findViewById(R.id.TextViewFirstName);
        TextView textViewDepartureTime = (TextView)
                convertView.findViewById(R.id.TextViewDepartureTime);
        TextView textViewPrice = (TextView)
                convertView.findViewById(R.id.TextViewPrice);

        //sets the text for item name and item description from the current item object
        textViewDepartureTime.setText(currentItem.getDepartureTime().toString());
        textViewItemName.setText(currentItem.getFirstname());
        textViewPrice.setText(Integer.toString(currentItem.getPrice()));

        // returns the view for the current row
        return convertView;
    }
}

