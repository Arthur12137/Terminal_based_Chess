package chess;


public class CheckInput {

    //This method requires your input
    public boolean checkCoordinateValidity(String input) {
        if (input == null || input.length() != 2)
            return false;
        if (input.charAt(0) < '1' || input.charAt(0) > '8')
            return false;
        if (input.charAt(1) < 'a' || input.charAt(1) > 'h')
            return false;
        return true;
    }
}
