/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author bo
 * @date Apr 11, 2011
 * @
 */
public abstract class BaseTableModel<E> extends AbstractTableModel {

    protected  List<E> lstData;
    String[] label;


    public abstract  String[] initLabel();
    
    public BaseTableModel() {
        this.label=initLabel();
    }

    public List<E> getLstData() {
        return lstData;
    }
    
    public void setLstData(List<E> lstData) {
        this.lstData = new ArrayList<E>();
        this.lstData.addAll(lstData);
        this.lstData = lstData;
    }

    public void setLstData(List<E> lstData, E st) {
        this.lstData = new ArrayList<E>();
        this.lstData.add(st);
        this.lstData.addAll(lstData);
    }

    public int getColumnCount() {
        return this.label.length;
    }

    public int getRowCount() {
        return lstData.size();
    }

    @Override
    public String getColumnName(int column) {
        return this.label[column];
    }

    @Override
    public Class getColumnClass(int c) {
        if (lstData.size() > 1) {
            return getValueAt(1, c).getClass();
        }
        return String.class;
    }

      @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
          TtsTable ttsTable = new TtsTable(this);
        if (rowIndex < 1) {
            return true;
        }
        return false;
    }


}
class ImageRenderer extends DefaultTableCellRenderer {
    JLabel lbl = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {
        lbl.setText((String) value);
        lbl.setIcon(new ImageIcon("/resources/images/home.png"));
        return lbl;
    }
}

