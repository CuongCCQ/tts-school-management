/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.staff;

import aptech.view.BaseSubContentView;
import aptech.view.MainSchool;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author bo
 * @date Apr 2, 2011
 * @
 */
public class StaffView extends BaseSubContentView {

    private JButton btnNewStaff;
    private JButton btnStaffDetail;
    

    public StaffView(MainSchool ms) {
        super(ms);
        initButtons();
    }

    private void initButtons() {
        btnNewStaff = new JButton("Create new Staff");
        this.lstButtons.add(btnNewStaff);
        btnStaffDetail = new JButton("Show Staff Detail");
        this.lstButtons.add(btnStaffDetail);
        btnNewStaff.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new ResulPanel() );
            }
        });

    }
    @Override
    protected JPanel initStartPanel() {
        try {
            return new InputStaff();
        } catch (Exception ex) {
            Logger.getLogger(StaffView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
