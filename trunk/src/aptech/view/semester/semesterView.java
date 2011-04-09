/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.view.semester;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
*/
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
public class semesterView extends BaseSubContentView {

    private JButton btnNewStudent;
    private JButton btnStudentDetail;

    public semesterView(MainSchool ms) {
        super(ms);
        initButtons();
    }

    private void initButtons() {
        btnNewStudent = new JButton("Add new semester");
        this.lstButtons.add(btnNewStudent);
        btnNewStudent.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               
            }
        });

        btnStudentDetail = new JButton("Show semester detail");
        this.lstButtons.add(btnStudentDetail);

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
}
