/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package infonodetest;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import net.infonode.docking.RootWindow;
import net.infonode.docking.SplitWindow;
import net.infonode.docking.View;
import net.infonode.docking.properties.RootWindowProperties;
import net.infonode.docking.theme.DockingWindowsTheme;
import net.infonode.docking.theme.ShapedGradientDockingTheme;
import net.infonode.docking.util.DockingUtil;
import net.infonode.docking.util.PropertiesUtil;
import net.infonode.docking.util.ViewMap;
import net.infonode.util.Direction;

/**
 *
 * @author bo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View view0 = new View("view 0 ", null, null);
        View rightPanel = new View("view 1", null, null);
        View leftPanel = new View("view 2                                                 ", null, null);

        ViewMap viewMap = new ViewMap();
        //viewMap.addView(0, view0);
        RootWindow rootWindow = DockingUtil.createRootWindow(viewMap, true);
        JFrame frame = new JFrame("test");
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.add(rootWindow);
        frame.setVisible(true);
        //view1.getViewProperties().setTitle("toi la tu");
        //view1.getViewProperties().getViewTitleBarProperties().setVisible(true);
        SplitWindow spl1 = new SplitWindow(true, 0.2f, leftPanel, view0);
        DockingWindowsTheme xxTheme=new ShapedGradientDockingTheme();
        rootWindow.getRootWindowProperties().addSuperObject(xxTheme.getRootWindowProperties());
        //rootWindow.getWindowProperties().setCloseEnabled(false);
        rootWindow.getRootWindowProperties().getDockingWindowProperties().setCloseEnabled(false);
        rootWindow.getRootWindowProperties().getDockingWindowProperties().setUndockEnabled(false);
        rootWindow.getRootWindowProperties().getDockingWindowProperties().setMinimizeEnabled(false);
        leftPanel.getWindowProperties().setUndockEnabled(false);
        leftPanel.getWindowProperties().setMaximizeEnabled(false);
        leftPanel.getWindowProperties().setDockEnabled(false);
        //rootWindow.getRootWindowProperties().
        rightPanel.getWindowProperties().setMinimizeEnabled(true);
        rootWindow.getWindowBar(Direction.DOWN).setEnabled(true);
        spl1.getWindowProperties().setMaximizeEnabled(false);
        spl1.getWindowProperties().setMinimizeEnabled(false);

        spl1.getWindowProperties().setDockEnabled(false);
        //spl1.getWindowProperties().set

        SplitWindow spl0 = new SplitWindow(false,0.8f, spl1, rightPanel);
        JMenuBar menuBar=new JMenuBar();
        JMenu fileMenu=new JMenu("File");
        JMenuItem exitMenuItem=new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        //rootWindow.getRootWindowProperties().DOCKING_WINDOW_PROPERTIES.set
        //rootWindow.getRootWindowProperties().getViewProperties().getViewTitleBarProperties().setVisible(true);
        
        //view2.getViewProperties().
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //view0.getViewProperties().getViewTitleBarProperties().s
        rootWindow.setWindow(spl0);
    }
}
