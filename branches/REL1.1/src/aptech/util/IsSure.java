/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.util;

import javax.swing.JOptionPane;

/**
 *
 * @author thinp
 */
public class IsSure
{
    public static boolean confirm(){
        boolean flag=false;
		
        int a=JOptionPane.showConfirmDialog(null, "Are you sure??");
        if (a==0){
            flag= true;
        }
        return  flag;
    }
    public static boolean confirm(String messString){
        boolean flag=false;
        int a=JOptionPane.showConfirmDialog(null,messString);
        if (a==0){
            flag= true;
        }
        return  flag;
    }
    public void static get()
	{
	}

}
