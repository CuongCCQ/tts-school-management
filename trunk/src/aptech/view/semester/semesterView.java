/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.semester;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import api.ClassOffer;
import api.ClassOfferDAO;
import aptech.view.BaseSubContentView;
import aptech.view.MainSchool;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import api.Semester;
import api.SemesterDAO;
import aptech.view.control.TtsTable;
import aptech.view.staff.ResulPanel;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
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
public class semesterView extends BaseSubContentView {

    private JButton btnNewSemester;
    private JButton btnNewClassOffer;
    private JButton btnNewCource;
    private JButton btnNewSubject;
    private JButton btnNewAssinment;

    public semesterView(MainSchool ms) {
        super(ms);
        initButtons();
        //initStartBottomTableClassOffer();
    }

    private void initButtons() {
        btnNewSemester = new JButton("Add new semester");
        this.lstButtons.add(btnNewSemester);
        btnNewSemester.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    createNewSubView(new InputSemester());
                    initStartBottomTableModelSemester();
                } catch (Exception ex) {
                    Logger.getLogger(semesterView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Action of class offer
        btnNewClassOffer = new JButton("Add new input Class Offer");
        this.lstButtons.add(btnNewClassOffer);
        btnNewClassOffer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new inputClassOffer());
                initStartBottomTableClassOffer();
            }
        });

        btnNewCource = new JButton("Input new Cource");
        this.lstButtons.add(btnNewCource);

        btnNewCource.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new InputCource());
            }
        });

        btnNewSubject = new JButton("Add new Subject");
        btnNewSubject.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new InputSubject());
            }
        });
        this.lstButtons.add(btnNewSubject);

        btnNewAssinment = new JButton("Add new Assinment");
        this.lstButtons.add(btnNewAssinment);
        btnNewAssinment.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new InputAssignment());
            }
        });

    }

    @Override
    protected JPanel initStartPanel() {
        try {
            return new InputSemester();
        } catch (Exception ex) {
            Logger.getLogger(semesterView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void initStartBottomTableModel() {
        SemesterDAO dao = new SemesterDAO();
        List lstSemester = dao.findAll();
        bottomModel = new semesterTableModel(lstSemester);
        bottomTable = new TtsTable((semesterTableModel) bottomModel);
        bottomTable.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {

            public void editingStopped(ChangeEvent e) {
                filterSemester();
            }

            public void editingCanceled(ChangeEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        bottomTable.getDefaultEditor(Boolean.class).addCellEditorListener(new CellEditorListener() {

            public void editingStopped(ChangeEvent e) {
                filterSemester();
            }

            public void editingCanceled(ChangeEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        bottomTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (bottomTable.getSelectedRow() > 0) {
                    try {
                        doTableSelectionChange();
                    } catch (Exception ex) {
                        Logger.getLogger(semesterView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

    }

    protected void filterSemester() {
        SemesterDAO dao = new SemesterDAO();
        Semester objSearch = ((semesterTableModel) this.bottomModel).getLstData().get(0);
        List<Semester> lstSemester = dao.filterByObject(objSearch);
        ((semesterTableModel) bottomModel).setLstData(lstSemester, objSearch);
        bottomModel.fireTableDataChanged();
    }

    private void doTableSelectionChange() throws Exception {
        try {
            EditSemester editSemester = new EditSemester();
            int semesterId = ((semesterTableModel) this.bottomModel).getLstData().get(bottomTable.getSelectedRow()).getSemesterId();
            SemesterDAO seDao = new SemesterDAO();
            Semester semester = seDao.findById(semesterId);
            editSemester.initSemesterFromModel(semester);
            createNewSubView(editSemester);
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(btnNewStudent, ex);
        }
    }

    protected void initStartBottomTableModelSemester() {
        SemesterDAO dao = new SemesterDAO();
        List lstSemester = dao.findAll();
        bottomModel = new semesterTableModel(lstSemester);
        bottomTable = new TtsTable((semesterTableModel) bottomModel);
        bottomTable.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {

            public void editingStopped(ChangeEvent e) {
                filterSemester();
            }

            public void editingCanceled(ChangeEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        bottomTable.getDefaultEditor(Boolean.class).addCellEditorListener(new CellEditorListener() {

            public void editingStopped(ChangeEvent e) {
                filterSemester();
            }

            public void editingCanceled(ChangeEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        bottomTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (bottomTable.getSelectedRow() > 0) {
                    try {
                        doTableSelectionChange();
                    } catch (Exception ex) {
                        Logger.getLogger(semesterView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        reloadBottomView();
    }
    //Class - offer

    protected void initStartBottomTableClassOffer() {
        ClassOfferDAO dao = new ClassOfferDAO();
        List lstClasOff = dao.findAll();
        bottomModel = new ClassOfferTableModel(lstClasOff);
        bottomTable = new TtsTable((ClassOfferTableModel) bottomModel);
        bottomTable.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {

            public void editingStopped(ChangeEvent e) {
                filterSemester();
            }

            public void editingCanceled(ChangeEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        bottomTable.getDefaultEditor(Boolean.class).addCellEditorListener(new CellEditorListener() {

            public void editingStopped(ChangeEvent e) {
                filterClassOff();
            }

            public void editingCanceled(ChangeEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        bottomTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (bottomTable.getSelectedRow() > 0) {
                    try {
                        doTableSelectionChangeClassOffer();
                    } catch (Exception ex) {
                        Logger.getLogger(semesterView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        reloadBottomView();
    }

    protected void filterClassOff() {
        ClassOfferDAO dao = new ClassOfferDAO();
        ClassOffer objSearch = ((ClassOfferTableModel) this.bottomModel).getLstData().get(0);
        List<ClassOffer> lstClassOffer = dao.filterByObject(objSearch);
        ((ClassOfferTableModel) bottomModel).setLstData(lstClassOffer, objSearch);
        bottomModel.fireTableDataChanged();
    }

    private void doTableSelectionChangeClassOffer() throws Exception {
        try {
            EditSemester editSemester = new EditSemester();
            int semesterId = ((semesterTableModel) this.bottomModel).getLstData().get(bottomTable.getSelectedRow()).getSemesterId();
            SemesterDAO seDao = new SemesterDAO();
            Semester semester = seDao.findById(semesterId);
            editSemester.initSemesterFromModel(semester);
            createNewSubView(editSemester);
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(btnNewStudent, ex);
        }
    }
}
