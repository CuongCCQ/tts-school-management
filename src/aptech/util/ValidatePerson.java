/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.util;

import java.util.Date;

/**
 *
 * @author thinp
 */
public class ValidatePerson
{
        
	private static ValidateUtil validate= new ValidateUtil();
        private static String messeage= null;
        public static String chekDOB(Date dateOfBirth){
            Date date= new Date();
            if(dateOfBirth.after(date)){
                messeage="Date of birth can not after curent time";
            }
            
            return messeage;
        }
    @SuppressWarnings("static-access")
        public static String isPhoneNumber(String phoneNumber){
            if(!validate.isNumber(phoneNumber)){
                messeage="Invalid phone number";
            }
            return messeage;
        }
    @SuppressWarnings("static-access")
    public static  String isEmail(String email){

        if(!validate.isEmail(email)){
            messeage="Invalid Email";
        }
                return  messeage;
    }


}
