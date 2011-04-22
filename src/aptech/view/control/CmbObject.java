/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

/**
 *
 * @author bo
 * @date Apr 15, 2011
 * @
 */
public class CmbObject {

    private String key;
    private String value;

    public CmbObject(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getKey();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CmbObject) {
            CmbObject obj1 = (CmbObject) obj;
            if (this.key.equals(obj1.getKey()) && this.value.equals(obj1.getValue())) {
                return true;
            }
        }
        return false;
    }
}
