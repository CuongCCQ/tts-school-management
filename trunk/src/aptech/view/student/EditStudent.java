/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.student;

import java.io.IOException;

/**
 *
 * @author bo
 * @date Apr 11, 2011
 * @
 */
public class EditStudent extends InputStudent {

    public EditStudent() throws IOException {
        initComponentV2();
    }

    @Override
    protected void initStudentToEdit() {
        getBtnDelete().setVisible(true);
    }
    
}
