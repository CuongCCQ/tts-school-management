/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputCource.java
 *
 * Created on Apr 10, 2011, 10:37:08 AM
 */

package aptech.view.semester;

/**
 *
 * @author anhson
 */
import aptech.util.ValidateUtil;
import javax.swing.JOptionPane;
import api.CourseDAO;
import api.Course;
public class InputCource extends javax.swing.JPanel {

    /** Creates new form InputCource */
    public InputCource() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblCourceName = new javax.swing.JLabel();
        lblCourceName1 = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        txtCourceName = new javax.swing.JTextField();
        txtCourceCode = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setText("Cource Manager");

        lblCourceName.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCourceName.setText("Cource Name :");

        lblCourceName1.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblCourceName1.setText("Cource code :");

        lblDesc.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblDesc.setText("Description :");

        btnAdd.setText("Add new");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCourceName)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDesc)
                                    .addComponent(lblCourceName1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtCourceName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                                        .addComponent(txtCourceCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(86, 86, 86)
                                            .addComponent(lblTitle)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(btnAdd)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCourceName1)
                            .addComponent(txtCourceCode, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCourceName)
                        .addComponent(txtCourceName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        ValidateUtil validate = new ValidateUtil();
        if(!validate.isEmpty(txtCourceName.getText()))
        {
            txtCourceName.requestFocus();
        }
        else if(!validate.isEmpty(txtCourceCode.getText()))
        {
            txtCourceCode.requestFocus();
        }else if(!validate.isEmpty(txtDescription.getText()))
        {
            txtDescription.requestFocus();
        }else
        {
            try{
            CourseDAO courseDAO = new CourseDAO();
            Course course = new Course();
            String couName = txtCourceName.getText();
            String couCOde= txtCourceCode.getText();
            String couDesc = txtDescription.getText();
            
          if(courseDAO.findByCourseCode(couCOde).size()>0)
          {
              JOptionPane.showMessageDialog(null,"Code early exits database !","System saying",JOptionPane.WARNING_MESSAGE);
              txtCourceCode.requestFocus();
          }else{
            courseDAO.getSession().beginTransaction();
            course.setCourseName(couName);
            course.setCourseCode(couCOde);
            course.setDescription(couDesc);
            courseDAO.save(course);
            courseDAO.getSession().getTransaction().commit();
            JOptionPane.showMessageDialog(null,"Insert data succesffuly");
            }
         }catch(Exception ex)
            {
           JOptionPane.showMessageDialog(null,"Error !","System saying",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCourceName;
    private javax.swing.JLabel lblCourceName1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtCourceCode;
    private javax.swing.JTextField txtCourceName;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables

}
