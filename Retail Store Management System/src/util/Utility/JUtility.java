package util.Utility;
import java.text.DecimalFormat;

public class JUtility {
    public static String addPrefix(String prefix, String id) {
        return prefix + id;
    }

    public static int seperateID(String strID) {
        String[] part = strID.split("(?<=\\D)(?=\\d)");
        //part[0] gives Prefix, part [1] gives numeric part
        //System.out.println(part[0]);
        //System.out.println(part[1]);
        return Integer.parseInt(part[1]);
    }
    public static String numberDisplayWithCommasAndDecimalPlaces(Double number){
        String stringNumber = null;
        if(number.equals(0.0)){
            stringNumber = "0.00";
        }else{
            stringNumber = new DecimalFormat("#,###.00").format(number);
        }

        return stringNumber;
    }
    

  

}
