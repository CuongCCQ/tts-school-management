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
import javax.swing.JPanel;

/**
 *
 * @author bo
 * @date Apr 2, 2011
 * @
 */
public class semesterView extends BaseSubContentView {

    private JButton btnNewSemester;
    private JButton btnStudentDetail;
    private JButton btnNewClassOffer;
    private JButton btnViewClassDetail;
    private JButton btnNewCource;
    private JButton btnViewCource;
    private JButton btnNewSubject;
    private JButton btnViewSubject;
    private JButton btnNewAssinment;

    public semesterView(MainSchool ms) {
        super(ms);
        initButtons();
    }

    private void initButtons() {
        btnNewSemester = new JButton("Add new semester");
        this.lstButtons.add(btnNewSemester);
        btnNewSemester.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    createNewSubView(new InputSemester());
                } catch (Exception ex) {
                    Logger.getLogger(semesterView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnStudentDetail = new JButton("Show semester detail");
        this.lstButtons.add(btnStudentDetail);
         //Action of class offer
        btnNewClassOffer = new JButton("Add new input Class Offer");
        this.lstButtons.add(btnNewClassOffer);
        btnNewClassOffer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               createNewSubView(new inputClassOffer());
            }
        });
        btnViewClassDetail = new JButton("Show class offer details");
        this.lstButtons.add(btnViewClassDetail);
        btnNewCource = new JButton("Input new Cource");
        this.lstButtons.add(btnNewCource);

        btnNewCource.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                createNewSubView(new InputCource());
            }
        });
        btnViewCource = new JButton("Show cource details");
        this.lstButtons.add(btnViewCource);


        btnNewSubject = new JButton("Add new Subject");
        btnNewSubject.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                    createNewSubView(new InputSubject());
            }
        });
        this.lstButtons.add(btnNewSubject);
        btnViewSubject = new JButton("Show subject details");
        this.lstButtons.add(btnViewSubject);

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
}
