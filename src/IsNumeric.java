public class IsNumeric {


    public static boolean isNumeric(String str)  // a method that tests if a string is numeric
    {
        try
        {
            Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
