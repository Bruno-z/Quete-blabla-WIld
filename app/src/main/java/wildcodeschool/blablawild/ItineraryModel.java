package wildcodeschool.blablawild;

import java.util.Date;

/**
 * Created by apprenti on 13/03/17.
 */

public class ItineraryModel {
    private int mID;
    private String mLastName;
    private String mFirstName;
    private Date mDate;
    private int mPrice;
    private String mDeparture;
    private String mDestination;

    private ItineraryModel() {

    }

    public ItineraryModel ( Date date, int price, String departure, String destination){

        mID = 0;
        mLastName = "DuGrenier";
        mFirstName = "Joeur";
        mDate = date;
        mPrice = price;
        mDeparture = departure;
        mDestination = destination;

    }

    public int getmID() {

        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmDeparture() {
        return mDeparture;
    }

    public void setmDeparture(String mDeparture) {
        this.mDeparture = mDeparture;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public String getmDestination() {
        return mDestination;
    }

    public void setmDestination(String mDestination) {
        this.mDestination = mDestination;
    }


}



