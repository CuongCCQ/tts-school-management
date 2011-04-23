/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

import api.FineObject;

/**
 *
 * @author bo
 * @date May 13, 2011
 * @
 */
public class FineTableModel extends BaseTableModel<FineObject> {

    @Override
    public String[] initLabel() {
        return new String[]{"Subject", "Number of conduct", "numberAttendace"};
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return lstData.get(rowIndex).getSubjectName();
        }
        if (columnIndex == 1) {
            return lstData.get(rowIndex).getNumberConduct();
        }
        if (columnIndex == 2) {
            return lstData.get(rowIndex).getNumberOfAttendace();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {


        return false;
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
