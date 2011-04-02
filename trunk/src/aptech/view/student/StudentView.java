/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.student;

import aptech.view.MainSchool;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author bo
 * @date Apr 2, 2011
 * @
 */
public class StudentView {

    JList lstAction;
    JPanel pnContent;
    MainSchool mainSchool;

    public StudentView(MainSchool ms) {
        String[] data = {"input new student", "search a student", "report"};
        DefaultListModel model = new DefaultListModel();
        this.mainSchool = ms;
        lstAction = new JList(data);
        lstAction.setSize(new Dimension(200,300));
        lstAction.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstAction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(pnContent, lstAction.getSelectedValue());
                changeGui(e);

            }
        });

    }

    public JPanel getPnContent() {
        return pnContent;
    }

    public void setPnContent(JPanel pnContent) {
        this.pnContent = pnContent;
    }

    public JList getLstAction() {
        return lstAction;
    }

    public void setLstAction(JList lstAction) {
        this.lstAction = lstAction;
    }

    private void changeGui(MouseEvent e) {
        pnContent = new InputStudent();
        mainSchool.getRightPanel().removeAll();
        mainSchool.getRightPanel().add(pnContent);
    }
}
