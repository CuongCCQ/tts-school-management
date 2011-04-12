/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.view.semester;

import java.io.IOException;

/**
 *
 * @author anhson
 */
public class EditSemester extends InputSemester{
    
     public EditSemester()throws java.lang.Exception{
        initComponentV2();
    }

    @Override
    
    protected void initSemesterToEdit() {
        getBtnDelete().setVisible(true);
    }
}
