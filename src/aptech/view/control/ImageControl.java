/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.util.ImageUtil;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author bo
 * @date Apr 4, 2011
 * @
 */
public class ImageControl extends JPanel {

    BufferedImage image;
    byte[] imgData;

    public byte[] getImgData() {
        return imgData;
    }

    public void setImgData(byte[] imgData) {
        this.imgData = imgData;
    }

    public ImageControl(String filePath) throws IOException {
        image = ImageIO.read(new File(filePath));
        setSize(image.getWidth(), image.getHeight());
        imgData = ImageUtil.convertImageToByteArray(image);
        image = ImageUtil.convertByteArrayToImg(imgData);
    }

    public ImageControl(byte[] data) throws IOException {
        image = ImageUtil.convertByteArrayToImg(data);
        setSize(image.getWidth(), image.getHeight());
        imgData = ImageUtil.convertImageToByteArray(image);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }

    }
}
