package util;

public class Validation {

    public static boolean validateInput(String input) {

        if(checkIfValidInteger(input)) {
            return Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 229;
        }else return false;
    }

    public static boolean checkIfValidInteger(String input){
        try {
            int integerFormat = Integer.parseInt(input);
            return true;

        } catch (NumberFormatException exception) {
            return false;
        }
    }


}
