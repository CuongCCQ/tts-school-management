/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view;

import aptech.view.control.TtsTable;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import resources.images.PathUtil;

/**
 *
 * @author bo
 * @date Apr 3, 2011
 * @
 */
public abstract class BaseSubContentView {

    protected MainSchool mainSchool;
    protected JPanel subContentPanel;
    protected List<JButton> lstButtons;
    protected TtsTable bottomTable;
    protected AbstractTableModel bottomModel;

    public BaseSubContentView(MainSchool mainSchool) {
        lstButtons = new ArrayList<JButton>();
        this.mainSchool = mainSchool;
    }

    // init left menus
    private void initLeftPanelButton() {
        for (JButton btn : this.lstButtons) {
            btn.setBorder(null);
            btn.setHorizontalAlignment(SwingConstants.LEFT);
            btn.setRolloverEnabled(true);
            btn.setIconTextGap(10);
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(false);
            ImageIcon icon = new ImageIcon(PathUtil.class.getResource("setting.png"));
            btn.setIcon(icon);
            btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            mainSchool.getLeftPanel().add(btn);
        }

    }

    // send sub view to main schools
    public void initSubView() {
        GridLayout layout = new GridLayout(mainSchool.getHeight() / 30, 1);
        this.mainSchool.getLeftPanel().removeAll();
        this.mainSchool.getLeftPanel().setLayout(layout);
        this.mainSchool.getBottomPanel().removeAll();
        initLeftPanelButton();
        initSubPanelView();
        initStartBottomTableModel();
        initBottomView();
        mainSchool.validate();
        mainSchool.repaint();
    }

    // send subPanel view to main schools
    private void initSubPanelView() {
        this.subContentPanel = initStartPanel();
        mainSchool.getRightPanel().removeAll();
        if (this.subContentPanel != null) {
            mainSchool.getRightPanel().add(this.subContentPanel, BorderLayout.CENTER);
        }
    }

    // create bottom model
    private void initBottomView() {
        if (bottomModel != null && bottomTable != null) {
            JScrollPane pane = new JScrollPane(bottomTable);
            bottomTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            pane.setPreferredSize(mainSchool.getBottomPanel().getSize());
            bottomTable.setFillsViewportHeight(true);
            mainSchool.getBottomPanel().add(pane);

        }
    }
    // reload bottom view

    protected void reloadBottomView() {
        if (bottomModel != null && bottomTable != null) {
            JScrollPane pane = new JScrollPane(bottomTable);
            bottomTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            pane.setPreferredSize(mainSchool.getBottomPanel().getSize());
            bottomTable.setFillsViewportHeight(true);
            this.mainSchool.getBottomPanel().removeAll();
            mainSchool.getBottomPanel().add(pane);
            mainSchool.validate();
            mainSchool.repaint();
        }
    }

    protected void createNewSubView(JPanel subViewPanel) {
        mainSchool.getRightPanel().removeAll();
        mainSchool.getRightPanel().add(subViewPanel, BorderLayout.CENTER);
        mainSchool.validate();
        mainSchool.repaint();
    }

    protected abstract JPanel initStartPanel();

    // init table and model here
    protected void initStartBottomTableModel() {
        return;
    }
}
