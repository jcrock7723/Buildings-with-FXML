package sample;

public class InvalidLatitudeException extends Exception {

    //Override Message
    @Override
    public String getMessage() {
//        return super.getMessage();
        return "Invalid Latitude! Please enter a different value...";
    }
}