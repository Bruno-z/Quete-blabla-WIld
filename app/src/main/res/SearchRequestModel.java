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
    public String getDepart() {
        return, depart;}
    public String getDestination() {
        return, Destination;}
    public String getDate() {
        return, Date;}

}
