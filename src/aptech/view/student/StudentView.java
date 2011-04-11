/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.student;

import api.Student;
import api.StudentDAO;
import api.StudentV2;
import aptech.view.BaseSubContentView;
import aptech.view.MainSchool;
import aptech.view.control.TtsTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author bo
 * @date Apr 2, 2011
 * @
 */
public class StudentView extends BaseSubContentView {

    private JButton btnNewStudent;
    private JButton btnStudentDetail;
    private JButton btnStudentCourseReg;

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
        btnStudentCourseReg = new JButton("RegCourse");
        this.lstButtons.add(btnStudentCourseReg);
        btnStudentCourseReg.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new RegCourse());
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

    @Override
    protected void initStartBottomTableModel() {
        StudentDAO dao = new StudentDAO();
        List lstStudent = dao.findAllStudentV2();
        bottomModel = new StudentTableModel(lstStudent);
        bottomTable = new TtsTable((StudentTableModel)bottomModel);
        bottomTable.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {

            public void editingStopped(ChangeEvent e) {
                filter();
            }

            public void editingCanceled(ChangeEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        bottomTable.getDefaultEditor(Boolean.class).addCellEditorListener(new CellEditorListener() {

            public void editingStopped(ChangeEvent e) {
                filter();
            }

            public void editingCanceled(ChangeEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        bottomTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (bottomTable.getSelectedRow() > 0) {
                    doTableSelectionChange();
                }
            }
        });

    }

    protected void filter() {
        StudentDAO dao = new StudentDAO();
        StudentV2 objSearch =((StudentTableModel) this.bottomModel).getLstData().get(0);
        List<StudentV2> lstStudent = dao.filterByObject(objSearch);
        ((StudentTableModel)bottomModel).setLstData(lstStudent, objSearch);
        bottomModel.fireTableDataChanged();
    }

    private void doTableSelectionChange() {
        try {
            EditStudent editStudent = new EditStudent();
            int studentId =((StudentTableModel) this.bottomModel).getLstData().get(bottomTable.getSelectedRow()).getStudentId();
            StudentDAO dao = new StudentDAO();
            Student student = dao.findById(studentId);
            editStudent.initStudentFromModel(student);
            createNewSubView(editStudent);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(btnNewStudent, ex);
        }
    }
}
