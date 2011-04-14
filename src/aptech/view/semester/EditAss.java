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
public class EditAss extends InputAssignment{
      public EditAss() throws IOException {
        initComponentV2();
     }

    protected void initAssToEdit() {
        getBtnDelete().setVisible(true);
        this.confirmSaveMessage=Constant.SURE_TO_UPDATE_ASS;
    }
}
