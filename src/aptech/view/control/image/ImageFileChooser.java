/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control.image;

import aptech.view.control.ImageFilter;
import javax.swing.JFileChooser;

/**
 *
 * @author bo
 * @date Apr 10, 2011
 * @
 */
public class ImageFileChooser extends JFileChooser {

    public ImageFileChooser() {
        super();
        addChoosableFileFilter(new ImageFilter());
        setAcceptAllFileFilterUsed(false);

        //Add custom icons for file types.
        setFileView(new ImageFileView());

        //Add the preview pane.
        setAccessory(new ImagePreview(this));
    }
}
