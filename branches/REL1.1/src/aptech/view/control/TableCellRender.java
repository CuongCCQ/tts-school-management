/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

/**
 *
 * @author bo
 * @date Apr 10, 2011
 * @
 */
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import resources.images.PathUtil;

public class TableCellRender extends JLabel
        implements TableCellRenderer {

    Border unselectedBorder = null;
    Border selectedBorder = null;
    boolean isBordered = true;

    public TableCellRender(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(true); //MUST do this for background to show up.
    }

    public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {

        if (row == 0) {
            this.setIcon(new ImageIcon(PathUtil.class.getResource("tia.png")));
            if (value != null) {
                setText(value.toString());
            }
        }
        return this;
    }
}
