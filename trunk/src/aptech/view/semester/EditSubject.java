/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.view.semester;

import aptech.util.Constant;
import java.io.IOException;

/**
 *
 * @author anhson
 */
public class EditSubject extends InputSubject{
      public EditSubject() throws IOException {
        initComponentV2();
     }

    protected void initSubjectToEdit() {
        getBtnDelete().setVisible(true);
        getLbtltitle().setText("Edit subject");
        this.confirmSaveMessage=Constant.SURE_TO_UPDATE_Subject;
    }
}
