/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author bo
 * @date Apr 15, 2011
 * @
 */
public class TtsCmbModel extends AbstractListModel implements ComboBoxModel {

    List<CmbObject> lstData;
    CmbObject selectedObj;

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
}
