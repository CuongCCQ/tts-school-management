/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.view.timeline;

import aptech.util.Constant;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import resources.images.PathUtil;

/**
 *
 * @author bo
 * @date Apr 16, 2011
 * @
 */
public class PanelImage extends JPanel {

    private Image image;

    public PanelImage() throws IOException {
        InputStream resourceAsStream = PathUtil.class.getResourceAsStream(Constant.DEFAULT_PNIMG_NAME);
        image = ImageIO.read(resourceAsStream);
        setPreferredSize(new Dimension(Constant.SCHEDULE_IMAGE_SIZE_WIDTH, Constant.SCHEDULE_IMAGE_SIZE_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.image != null) {
            g.drawImage(this.image, 0, 0, this);
        }

    }
}
