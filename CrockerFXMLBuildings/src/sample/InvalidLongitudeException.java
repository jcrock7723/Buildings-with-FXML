package sample;


public class InvalidLongitudeException extends Exception {

    //Override Message
    @Override
    public String getMessage() {
        return "Invalid Longitude! Please enter a different value...";
    }
}
