/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.staff;

import aptech.view.BaseSubContentView;
import aptech.view.MainSchool;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class StaffView extends BaseSubContentView {

    private JButton btnNewStaff;
    private JButton btnStaffDetail;

    public StaffView(MainSchool ms) {
        super(ms);
        initButtons();
    }

    private void initButtons() {
        btnNewStaff = new JButton("Create new Staff");
        this.lstButtons.add(btnNewStaff);
        btnNewStaff.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                btnNewStaff.setForeground(Color.red);
                btnStaffDetail.setForeground(Color.black);
            }
        });
        btnStaffDetail= new JButton("Staff Detail");
        this.lstButtons.add(btnStaffDetail);
       
        btnStaffDetail.addMouseListener(new MouseAdapter() {
             boolean isPress= true;


            @Override
            public void mouseEntered(MouseEvent e) {
                if(btnStaffDetail.getForeground()==Color.black){isPress=true;}
                if(isPress){btnStaffDetail.setForeground(Color.BLUE);}
                
            }

            @Override
            public void mouseClicked(MouseEvent e) {

                 btnStaffDetail.setForeground(Color.red);
                 isPress=false;

            }


          

            @Override
            public void mouseExited(MouseEvent e) {
              if(isPress){btnStaffDetail.setForeground(Color.BLACK);}

            }

        });

//        btnStaffDetail = new JButton("Show Staff Detail");
//        this.lstButtons.add(btnStaffDetail);

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
}
