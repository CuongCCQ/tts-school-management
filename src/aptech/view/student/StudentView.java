/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.student;

import aptech.view.BaseSubContentView;
import aptech.view.MainSchool;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author bo
 * @date Apr 2, 2011
 * @
 */
public class StudentView extends BaseSubContentView {

    private JButton btnNewStudent;
    private JButton btnStudentDetail;

    public StudentView(MainSchool ms) {
        super(ms);
        initButtons();
    }

    private void initButtons() {
        btnNewStudent = new JButton("Create new Student");
        this.lstButtons.add(btnNewStudent);
        btnNewStudent.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainSchool, "raise");
            }
        });

        btnStudentDetail = new JButton("Show Student Detail");
        this.lstButtons.add(btnStudentDetail);
        btnStudentDetail.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
            }
        });

    }

    @Override
    protected JPanel initStartPanel() {
        try {
            return new InputStudent();
        } catch (Exception ex) {
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
