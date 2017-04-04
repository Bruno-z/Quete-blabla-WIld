package wildcodeschool.blablawild;

import java.util.Date;

/**
 * Created by apprenti on 13/03/17.
 */

public class ItineraryModel {
    private String muserID;
    private String mLastName;
    private String mFirstName;
    private Date mDate;
    private int mPrice;
    private String mDeparture;
    private String mDestination;
    private String mDisplayName;


    private ItineraryModel() {

    }

    public ItineraryModel ( String userID, Date date, int price, String departure, String destination, String displayname ){

        muserID = userID;
        mLastName = "DuGrenier";
        mFirstName = "Joeur";
        mDate = date;
        mPrice = price;
        mDeparture = departure;
        mDestination = destination;
        mDisplayName = displayname;

    }


    public String getmDisplayName() {
        return mDisplayName;
    }

    public void setmDisplayName(String mDisplayName) {
        this.mDisplayName = mDisplayName;
    }

    public String getMuserID() {
        return muserID;
    }

    public void setMuserID(String muserID) {
        this.muserID = muserID;
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

    public static int getcount() {
        return getcount();
    }

}



