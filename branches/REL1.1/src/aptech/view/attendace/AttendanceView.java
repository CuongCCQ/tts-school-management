/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.attendace;

import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.view.BaseSubContentView;
import aptech.view.MainSchool;
import aptech.view.staff.ResulPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author bo
 * @date May 13, 2011
 * @
 */
public class AttendanceView extends BaseSubContentView {

    private JButton btnUpdateAttendance;
    private JButton btnCalFine;

    @Override
    protected JPanel initStartPanel() {
        try {
            return new ResulPanel();
        } catch (Exception ex) {
            AppUtil.showErrMsg(Constant.ERROR_STRING);
            ex.printStackTrace();
        }
        return null;
    }

    public AttendanceView(MainSchool mainSchool) {
        super(mainSchool);
        initButtons();
    }

    private void initButtons() {
        btnUpdateAttendance = new JButton("Take attendace");
        this.lstButtons.add(btnUpdateAttendance);

        btnCalFine = new JButton("Calculate fine levy");
        this.lstButtons.add(btnCalFine);

        btnUpdateAttendance.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new ResulPanel());
            }
        });

        btnCalFine.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new FineMainForm());
            }
        });
    }
}
