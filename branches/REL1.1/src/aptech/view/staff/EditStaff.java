/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.staff;

import api.Staff;
import aptech.view.student.InputStudent;
import java.io.IOException;

/**
 *
 * @author bo
 * @date Apr 11, 2011
 * @
 */
public class EditStaff extends InputStaff {

    public EditStaff() throws IOException {
        initComponentV2();
    }

    @Override
    protected void initStaffFromModel(Staff studentFromModel) {
        super.initStaffFromModel(studentFromModel);
        getBtnDelete().setVisible(true);
    }
}
