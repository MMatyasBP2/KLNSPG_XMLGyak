import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMModifyKLNSPG
{
    public static void main(String argv[]) throws ParserConfigurationException, TransformerException, IOException
    {
        try
        {
            File inputFile = new File("C:\\projects\\KLNSPG_XMLGyak\\XMLTaskKLNSPG\\XMLKLNSPG.xml");

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.parse(inputFile);

            NodeList employeeList = doc.getElementsByTagName("Employee");
            for (int i = 0; i < employeeList.getLength(); i++)
            {
                Node employee = employeeList.item(i);
                Element eElement = (Element) employee;
                String empId = eElement.getAttribute("emp_id");

                eElement.setAttribute("emp_id", "EMP_" + empId);
            }

            NodeList siteList = doc.getElementsByTagName("Site");
            for (int i = 0; i < siteList.getLength(); i++)
            {
                Node site = siteList.item(i);
                Element eElement = (Element) site;
                eElement.setAttribute("visitor_capacity", "5000");
            }

            NodeList animalList = doc.getElementsByTagName("Animal");
            for (int i = 0; i < animalList.getLength(); i++)
            {
                Node animal = animalList.item(i);
                Element eElement = (Element) animal;
                if ("Medve".equals(eElement.getElementsByTagName("racial").item(0).getTextContent()))
                    eElement.getElementsByTagName("description").item(0).setTextContent("A medve erős és bátor");
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            System.out.println("--Results--");
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
