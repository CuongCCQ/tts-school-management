/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author bo
 * @date Apr 3, 2011
 * @
 */
public class ImageUtil {

    public static String convertImageToStr(BufferedImage img) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        String s = new String(imageInByte);
        return s;
    }
     public static byte[] convertImageToByteArray(BufferedImage img) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }
    public static BufferedImage convertStringToImg(String data) throws IOException
    {
        InputStream in = new ByteArrayInputStream(data.getBytes());
	BufferedImage img = ImageIO.read(in);
	return img;
    }
     public static BufferedImage convertByteArrayToImg(byte[] data) throws IOException
    {
        InputStream in = new ByteArrayInputStream(data);
	BufferedImage img = ImageIO.read(in);
	return img;
    }
}
