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
public class EditCource extends InputCource{
    public EditCource() throws IOException
    {
         initComponentV2();
    }
    protected void initCourceToEdit() {
        getBtnDelete().setVisible(true);
        getLbltitle().setText("Edit cource");
        this.confirmSaveMessage=Constant.SURE_TO_UPDATE_STUDENT;
    }
}
