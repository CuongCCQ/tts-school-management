/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoadAllClass.java
 *
 * Created on 22-04-2011, 16:00:35
 */

package aptech.view.semester;

import api.ClassOffer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author thinp
 */
public class LoadAllClass extends javax.swing.JFrame {

    /** Creates new form LoadAllClass */
    public LoadAllClass(List<ClassOffer> lstClassOffers) {
        initComponents();
        initTable(lstClassOffers);
    }
    private  void initTable(List<ClassOffer> lstClassOffers){
        JTable table= new JTable();
        LoadClassModel model= new LoadClassModel(lstClassOffers);
        table.setModel(model);
        table.setForeground(Color.BLUE);
        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(300, 300));
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(pane,BorderLayout.CENTER);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
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
                //new LoadAllClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
