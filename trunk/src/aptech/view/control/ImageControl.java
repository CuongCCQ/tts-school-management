/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.control;

import aptech.util.AppUtil;
import aptech.util.Constant;
import aptech.util.ImageUtil;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
    private Image imageThumb;
    byte[] imgData;

    public byte[] getImgData() {
        return imgData;
    }

    public void setImgData(byte[] imgData) {
        this.imgData = imgData;
    }

    public ImageControl(String filePath) throws IOException {
        image = ImageIO.read(new File(filePath));
        setSize(Constant.IMAGE_SIZE_WIDTH, Constant.IMAGE_SIZE_HEIGHT);
        imgData = ImageUtil.convertImageToByteArray(image);
        image = ImageUtil.convertByteArrayToImg(imgData);
        this.imageThumb=image.getScaledInstance(Constant.IMAGE_SIZE_WIDTH, Constant.IMAGE_SIZE_HEIGHT,
                image.SCALE_SMOOTH);
        this.validate();
        this.repaint();
    }

    public ImageControl(byte[] data) throws IOException {
        image = ImageUtil.convertByteArrayToImg(data);
        setSize(Constant.IMAGE_SIZE_WIDTH, Constant.IMAGE_SIZE_HEIGHT);
        imgData = ImageUtil.convertImageToByteArray(image);
        this.imageThumb=image.getScaledInstance(Constant.IMAGE_SIZE_WIDTH, Constant.IMAGE_SIZE_HEIGHT,
                image.SCALE_SMOOTH);
        this.validate();
        this.repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.imageThumb != null) {
            g.drawImage(this.imageThumb, 0, 0, this);
        }

    }
}
