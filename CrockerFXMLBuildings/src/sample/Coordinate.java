package sample;
import sample.InvalidLatitudeException;
import java.io.Serializable;

public class Coordinate implements Serializable {

    //private attributes
    private double latitude;
    private double longitude;

    //Constructor throws Exceptions
    public Coordinate(double latitude, double longitude) throws InvalidLatitudeException, InvalidLongitudeException {

        //Try and catch but use the setter methods with limitations to actually throw the exceptions
        try {
            setLatitude(latitude);
        } catch (InvalidLatitudeException e) {
            throw e;
        }

        //Try catch
        try {
            setLongitude(longitude);
        } catch (InvalidLongitudeException e) {
            throw e;
        }
    }


    // Getters and Setters
    public void setLatitude(double latitude) throws InvalidLatitudeException{

        //Try Catch - with limitations to throw exceptions
        if (latitude <= 34 || latitude >= 37) {
            throw new InvalidLatitudeException();
        } this.latitude = latitude;
    }

    public void setLongitude(double longitude) throws InvalidLongitudeException{
        if (longitude <= -80 && longitude >= -78) {
            throw new InvalidLongitudeException();
        } this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    @Override
    public String toString() {
        return "Coordinates: "
                + "\n\t\tLatitude: " + latitude
                + "\n\t\tLongitude: " + longitude;
    }
}