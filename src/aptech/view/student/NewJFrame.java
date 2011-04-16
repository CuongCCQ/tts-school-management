/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on Apr 10, 2011, 5:01:24 PM
 */
package aptech.view.student;

import api.Student;
import api.StudentDAO;
import api.StudentV2;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author bo
 */
public class NewJFrame extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    public NewJFrame() {
        initComponents();
        initTable();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    private void initTable() {
        JTable jTable = new JTable();
        StudentDAO dao = new StudentDAO();
        List<StudentV2> lstStudent = (List<StudentV2>) dao.findAllStudentV2();
        StudentTableModel model = new StudentTableModel(lstStudent);
        jTable.setModel(model);

//        jTable.setCellEditor(getDefaultEditor)
        
        //jTable.setFillsViewportHeight(true);
        jTable.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {

            public void editingStopped(ChangeEvent e) {
                System.out.println("change");
            }

            public void editingCanceled(ChangeEvent e) {
                System.out.println("change1");
            }
        });
        jTable.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("key pro");
            }

        });
        JScrollPane pane = new JScrollPane(jTable);
        pane.setPreferredSize(new Dimension(300, 300));
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(pane,BorderLayout.CENTER);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}