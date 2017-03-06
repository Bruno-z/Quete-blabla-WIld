package wildcodeschool.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by apprenti on 06/03/17.
 */

public class SearchRequestModel implements Parcelable {

    private String Depart;
    private String Destination;
    private String Date;


    public SearchRequestModel(String Depart, String Destination, String Date) {
        this.Depart = Depart;
        this.Destination = Destination;
        this.Date = Date;

    }

    protected SearchRequestModel(Parcel in) {
        Depart = in.readString();
        Destination = in.readString();
        Date = in.readString();
    }

    public static final Creator<SearchRequestModel> CREATOR = new Creator<SearchRequestModel>() {
        @Override
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };

    public String getDepart() {
        return this.Depart;}

    public String getDestination() {
        return  this.Destination;}

    public String getDate() {
        return this.Date;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Depart);
        dest.writeString(Destination);
        dest.writeString(Date);
    }
}


