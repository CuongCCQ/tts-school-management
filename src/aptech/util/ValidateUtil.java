/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.util;

import java.util.Date;

/**
 *
 * @author bo
 * @date Apr 10, 2011
 * @
 */
public class ValidateUtil {
    public static boolean isEmail(String email)
    {
        return true;
    }

    public static boolean isNumber(String number)
    {
        return true;
    }
    public static boolean isEmpty(String input)
    {
        return true;
    }
    public static boolean checkDate(Date dateFirst, Date dateSecond){
        if(dateFirst.after(dateSecond)){
        return  false;}
        return true;
    }
}
