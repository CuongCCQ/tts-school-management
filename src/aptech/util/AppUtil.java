/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.util;

import aptech.view.MainSchool;
import javax.swing.JOptionPane;

/**
 *
 * @author bo
 * @date Apr 4, 2011
 * @
 */
public class AppUtil {

    public static String getAppPath() {
        return MainSchool.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    }
    public static void showErrMsg(String errorMsg)
    {
        JOptionPane.showMessageDialog(null, errorMsg, "error", JOptionPane.WARNING_MESSAGE);
    }
}
