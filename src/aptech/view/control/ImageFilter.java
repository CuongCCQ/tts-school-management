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
import aptech.util.FileExtensionUtil;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

/* ImageFilter.java is used by FileChooserDemo2.java. */
public class ImageFilter extends FileFilter {

    //Accept all directories and all gif, jpg, tiff, or png files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = FileExtensionUtil.getExtension(f);
        if (extension != null) {
            if (extension.equals(FileExtensionUtil.tiff)
                    || extension.equals(FileExtensionUtil.tif)
                    || extension.equals(FileExtensionUtil.gif)
                    || extension.equals(FileExtensionUtil.jpeg)
                    || extension.equals(FileExtensionUtil.jpg)
                    || extension.equals(FileExtensionUtil.png)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Just Images";
    }
}
