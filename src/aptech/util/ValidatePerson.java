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
        private static Integer personId;
	private static Date dateOfBirth;
	private static String personCode;
	private static String address;
	private static String phoneNumber;
	private static String email;
	private static String name;
	private static ValidateUtil validate= new ValidateUtil();
        private static String messeage= null;
        public static String chekDOB(){
            Date date= new Date();
            if(dateOfBirth.after(date)){
                messeage="Date of birth can not after curent time";
            }
            
            return messeage;
        }
    @SuppressWarnings("static-access")
        public static String isPhoneNumber(){            
            if(!validate.isNumber(phoneNumber)){
                messeage="Invalid phone number";
            }
            return messeage;
        }
    @SuppressWarnings("static-access")
    public static  String isEmail(){

        if(!validate.isEmail(email)){
            messeage="Invalid Email";
        }
                return  messeage;
    }


}
