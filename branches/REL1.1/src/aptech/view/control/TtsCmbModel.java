/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.MutableComboBoxModel;

/**
 *
 * @author bo
 * @date Apr 15, 2011
 * @
 */
public class TtsCmbModel extends AbstractListModel implements MutableComboBoxModel {

    List<CmbObject> lstData;
    CmbObject selectedObj;

    public List<CmbObject> getLstData() {
        return lstData;
    }

    public void setLstData(List<CmbObject> lstData) {
        this.lstData = lstData;
    }

    public TtsCmbModel() {
        lstData = new ArrayList<CmbObject>();
    }

    public TtsCmbModel(List<CmbObject> lstData) {
        this.lstData = lstData;
    }

    public void setFirstItemLabel(String label) {
        CmbObject item = new CmbObject(label, "-1");
        this.lstData.add(0, item);
    }

    public Object getElementAt(int index) {
        return lstData.get(index);
    }

    public int getSize() {
        return lstData.size();
    }

    public Object getSelectedItem() {
        return selectedObj;
    }

    public void setSelectedItem(Object anItem) {
        selectedObj = (CmbObject) anItem;
    }

    public void addElement(Object obj) {
        lstData.add((CmbObject) obj);
    }

    public void removeElement(Object obj) {
        for (CmbObject cmbObject : lstData) {
            if (cmbObject.equals(obj)) {
                lstData.remove(cmbObject);
                break;
            }
            
        }
    }

    public void insertElementAt(Object obj, int index) {
        if (obj instanceof CmbObject) {
            lstData.add(index, (CmbObject) obj);
        }
    }

    public void removeElementAt(int index) {
        lstData.remove(index);
    }
}
