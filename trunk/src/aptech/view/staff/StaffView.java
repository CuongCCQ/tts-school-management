/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.staff;

import api.Staff;
import api.StaffDAO;
import api.StaffV2;
import aptech.view.BaseSubContentView;
import aptech.view.MainSchool;
import aptech.view.control.TtsTable;
import aptech.view.student.EditStudent;
import aptech.view.student.StudentTableModel;
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
public class StaffView extends BaseSubContentView {

    private JButton btnStaffManeger;
    private JButton btnStudentAttend;
    

    public StaffView(MainSchool ms) {
        super(ms);
        initButtons();
    }

    private void initButtons() {
        btnStaffManeger = new JButton("Maneger Staff");
        this.lstButtons.add(btnStaffManeger);
        btnStudentAttend = new JButton("Student Attend");
        this.lstButtons.add(btnStudentAttend);

        btnStaffManeger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    createNewSubView(new InputStaff());
                } catch (IOException ex) {
                    Logger.getLogger(StaffView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btnStudentAttend.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new ResulPanel());
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
        @Override
    protected void initStartBottomTableModel() {
        StaffDAO dao = new StaffDAO();
        List lstStudent = dao.findAllStaffV2();
        bottomModel = new StaffTableModel(lstStudent);
        bottomTable = new TtsTable((StaffTableModel)bottomModel);
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
        StaffDAO dao = new StaffDAO();
        StaffV2 objSearch =((StaffTableModel) this.bottomModel).getLstData().get(0);
        List<StaffV2> lstStaffV2 = dao.filterByObject(objSearch);
       ((StaffTableModel)bottomModel).setLstData(lstStaffV2, objSearch);
        bottomModel.fireTableDataChanged();
    }

    private void doTableSelectionChange() {
        try {
            EditStaff editStaff = new EditStaff();
            int staffId =((StaffTableModel) this.bottomModel).getLstData().get(bottomTable.getSelectedRow()).getStaffId();
            StaffDAO dao = new StaffDAO();
            Staff staff = dao.findById(staffId);
            editStaff.initStaffFromModel(staff);
            createNewSubView(editStaff);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(btnStaffManeger, ex);
        }
    }
}
