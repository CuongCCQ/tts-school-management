/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aptech.util;

import api.Account;
import aptech.view.MainSchool;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;
import project.Main;

/**
 *
 * @author bo
 * @date Apr 4, 2011
 * @
 */
public class AppUtil {

    public static void changeConfig(String connectionUrl, String user, String pass) throws TransformerFactoryConfigurationError, DOMException {
        try {
		
            File file = new File("hibernate.cfg.xml");

            //Create instance of DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //Get the DocumentBuilder
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            //Using existing XML Document
            Document doc = docBuilder.parse(file);
            //create the root element
            Element root = doc.getDocumentElement();

            NodeList lstNode = doc.getElementsByTagName("property");

            // edit connection url
            Node connectionUrlParentNode = lstNode.item(1);
            Node itemConn = connectionUrlParentNode.getChildNodes().item(0);
            itemConn.setNodeValue(connectionUrl);
            // edit user
            Node connectionUser = lstNode.item(3);
            Node itemUser = connectionUser.getChildNodes().item(0);
            itemUser.setNodeValue(user);
            // edit password
            Node connectionPass = lstNode.item(4);
            Node itemPass = connectionPass.getChildNodes().item(0);
            itemPass.setNodeValue(pass);


            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//Hibernate/Hibernate Configuration DTD 3.0//EN");
            trans.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd");
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            String xmlString = sw.toString();
            OutputStream f0;
            byte[] buf = xmlString.getBytes();
            File f = new File("hibernate.cfg.xml");
            f0 = new FileOutputStream(f);
            for (int i = 0; i < buf.length; i++) {
                f0.write(buf[i]);
            }
            f0.close();
            buf = null;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static String getAppPath() {
        String tempPath = Main.class.getResource("").getPath();
        if (!tempPath.startsWith("file")) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder(tempPath.substring(6, tempPath.length() - 1));
            int idx = builder.lastIndexOf("/");
            builder.delete(idx, builder.length());
            int idx1 = builder.lastIndexOf("/") + 1;
            builder.delete(idx1, builder.length());
            return builder.toString();
        }
    }

    public static void showErrMsg(String errorMsg) {
        JOptionPane.showMessageDialog(null, errorMsg, "error", JOptionPane.WARNING_MESSAGE);
    }

    public static void showNoticeMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg, "notice", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        t.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
    public static Account UserToken;
}
