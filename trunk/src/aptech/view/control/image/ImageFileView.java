/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aptech.view.control.image;


import aptech.util.FileExtensionUtil;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileView;

/**
 *
 * @author bo
 * @date Apr 10, 2011
 * @
 */

public class ImageFileView extends FileView {
    ImageIcon jpgIcon = FileExtensionUtil.createImageIcon("jpgIcon.gif");
    ImageIcon gifIcon = FileExtensionUtil.createImageIcon("gifIcon.gif");
    ImageIcon tiffIcon = FileExtensionUtil.createImageIcon("tiffIcon.gif");
    ImageIcon pngIcon = FileExtensionUtil.createImageIcon("pngIcon.png");

    public String getName(File f) {
        return null; //let the L&F FileView figure this out
    }

    public String getDescription(File f) {
        return null; //let the L&F FileView figure this out
    }

    public Boolean isTraversable(File f) {
        return null; //let the L&F FileView figure this out
    }

    public String getTypeDescription(File f) {
        String extension = FileExtensionUtil.getExtension(f);
        String type = null;

        if (extension != null) {
            if (extension.equals(FileExtensionUtil.jpeg) ||
                extension.equals(FileExtensionUtil.jpg)) {
                type = "JPEG Image";
            } else if (extension.equals(FileExtensionUtil.gif)){
                type = "GIF Image";
            } else if (extension.equals(FileExtensionUtil.tiff) ||
                       extension.equals(FileExtensionUtil.tif)) {
                type = "TIFF Image";
            } else if (extension.equals(FileExtensionUtil.png)){
                type = "PNG Image";
            }
        }
        return type;
    }

    public Icon getIcon(File f) {
        String extension = FileExtensionUtil.getExtension(f);
        Icon icon = null;

        if (extension != null) {
            if (extension.equals(FileExtensionUtil.jpeg) ||
                extension.equals(FileExtensionUtil.jpg)) {
                icon = jpgIcon;
            } else if (extension.equals(FileExtensionUtil.gif)) {
                icon = gifIcon;
            } else if (extension.equals(FileExtensionUtil.tiff) ||
                       extension.equals(FileExtensionUtil.tif)) {
                icon = tiffIcon;
            } else if (extension.equals(FileExtensionUtil.png)) {
                icon = pngIcon;
            }
        }
        return icon;
    }
}
