package aptech.view.semester;

import aptech.util.AppUtil;
import aptech.util.Constant;
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anhson
 */
public class EditClassOffer extends inputClassOffer {

    public EditClassOffer() throws java.lang.Exception {
        initComponentV2();
    }

    protected void initClassOfferToEdit() {

        getBtndelete().setVisible(true);
        getBtndelete().setForeground(Color.red);
        getLbltitle().setText("Edit class offer");
        if (AppUtil.UserToken.getType().shortValue() == Constant.PERMISSION_STAFF) {
            getBtndelete().setEnabled(false);
            getBtnAdd().setEnabled(false);
            getLbltitle().setText("Class Detail ");

        }
    }
}
