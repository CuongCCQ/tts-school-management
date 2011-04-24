package aptech.facade;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

public class test {

    public static void main(String args[]) {
        test t = new test();
        t.changeConfig("jdbc:sqlserver://bo-pc;databaseName=thian lon", "bu", "dit");
    }

    public void changeConfig(String connectionUrl, String user, String pass) throws TransformerFactoryConfigurationError, DOMException {
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
            //create string from xml tree
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);
            String xmlString = sw.toString();
            OutputStream f0;
            byte[] buf = xmlString.getBytes();
            f0 = new FileOutputStream("hibernate.cfg.xml");
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
}
