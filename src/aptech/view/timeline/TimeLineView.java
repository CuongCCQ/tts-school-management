/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.timeline;

import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.view.BaseSubContentView;
import aptech.view.MainSchool;
import aptech.view.staff.ClassSchedule;
import aptech.view.student.InputStudent;
import aptech.view.student.StudentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author bo
 * @date Apr 27, 2011
 * @
 */
public class TimeLineView extends BaseSubContentView {

    private JButton btnViewTimeLine;
    private JButton btnUpdateTimeTable;

    public TimeLineView(MainSchool mainSchool) {
        super(mainSchool);
        initButtons();
    }

    private void initButtons() {
        btnViewTimeLine = new JButton("View time line");
        this.lstButtons.add(btnViewTimeLine);

        btnUpdateTimeTable = new JButton("Update class schedule");
        this.lstButtons.add(btnUpdateTimeTable);

        btnViewTimeLine.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new MainTimeForm());
            }
        });

        btnUpdateTimeTable.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new ClassSchedule(AppUtil.UserToken.getStaffId()));
            }
        });
    }

    @Override
    protected JPanel initStartPanel() {
        try {
            return new MainTimeForm();
        } catch (Exception ex) {
            AppUtil.showErrMsg(Constant.ERROR_STRING);
            ex.printStackTrace();
        }
        return null;
    }
}
