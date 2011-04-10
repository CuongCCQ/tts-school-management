/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.util;

import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bo
 * @date Apr 10, 2011
 * @
 */
public class ValidateUtil {

    private static String regx;

    public static boolean isEmail(String email) {
        //regx = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern p = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Matcher m = p.matcher(email);
        boolean matchFound = m.matches();
        return matchFound;
    }

    public static boolean isPhoneNumber(String phoneNumber) {
        //regx = "";
        Pattern p = Pattern.compile("\\d{10}");
        Matcher m = p.matcher(phoneNumber);
        boolean matchFound = m.matches();
        return matchFound;
    }

    public static boolean isEmpty(String input) {
        return true;
    }

    public static boolean checkDate(Date dateFirst, Date dateSecond) {
        if (dateFirst.after(dateSecond)) {
            return false;
        }
        return true;

    }
}
