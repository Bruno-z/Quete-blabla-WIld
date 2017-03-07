package wildcodeschool.blablawild;

import java.util.Date;

/**
 * Created by apprenti on 07/03/17.
 */


public class TripResultModel {
    //  attribut
    private Date departureTime;
    private String firstname;
    private int price;

    // constructor

    public TripResultModel( String firstname, Date departureTime, int price) {
        this.firstname = firstname;
        this.departureTime = departureTime;
        this.price = price;

    }

 // getter et setters

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}

