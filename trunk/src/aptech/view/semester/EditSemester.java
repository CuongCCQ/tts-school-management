/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.view.semester;

/**
 *
 * @author anhson
 */
public class EditSemester extends InputSemester{
    
     public EditSemester()throws java.lang.Exception{
        initComponentV2();
    }


    protected void initSemesterToEdit() {
       getLbltitle().setText("Edit semester");
    }
}
