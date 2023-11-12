import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

public class DOMModifyKLNSPG {
    public static void main(String argv[])
    {
        try
        {
            File inputFile = new File("C:\\projects\\KLNSPG_XMLGyak\\XMLTaskKLNSPG\\XMLKLNSPG.xml");

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);

            System.out.println("--Results--");

            modifyAndPrintEmployees(doc);
            modifyAndPrintSites(doc);
            modifyAndPrintAnimals(doc);
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void modifyAndPrintEmployees(Document doc)
    {
        NodeList employeeList = doc.getElementsByTagName("Employee");
        for (int i = 0; i < employeeList.getLength(); i++)
        {
            Node employee = employeeList.item(i);
            Element eElement = (Element) employee;
            String empId = eElement.getAttribute("emp_id");
            eElement.setAttribute("emp_id", "EMP_" + empId);
            System.out.println("    Employee {emp_id=" + eElement.getAttribute("emp_id") + "} start");
            printElement("first_name", eElement.getElementsByTagName("first_name").item(0).getTextContent());
            printElement("last_name", eElement.getElementsByTagName("last_name").item(0).getTextContent());
            System.out.println("    Employee end");
        }
    }

    private static void modifyAndPrintSites(Document doc)
    {
        NodeList siteList = doc.getElementsByTagName("Site");
        for (int i = 0; i < siteList.getLength(); i++)
        {
            Node site = siteList.item(i);
            Element eElement = (Element) site;
            eElement.setAttribute("visitor_capacity", "5000");
            System.out.println("    Site {visitor_capacity=" + eElement.getAttribute("visitor_capacity") + "} start");
            printElement("name", eElement.getElementsByTagName("name").item(0).getTextContent());
            System.out.println("    Site end");
        }
    }

    private static void modifyAndPrintAnimals(Document doc)
    {
        NodeList animalList = doc.getElementsByTagName("Animal");
        for (int i = 0; i < animalList.getLength(); i++)
        {
            Node animal = animalList.item(i);
            Element eElement = (Element) animal;
            if ("Medve".equals(eElement.getElementsByTagName("racial").item(0).getTextContent()))
                eElement.getElementsByTagName("description").item(0).setTextContent("A medve eros es bator");

            System.out.println("    Animal start");
            printElement("name", eElement.getElementsByTagName("name").item(0).getTextContent());
            printElement("racial", eElement.getElementsByTagName("racial").item(0).getTextContent());
            printElement("description", eElement.getElementsByTagName("description").item(0).getTextContent());
            System.out.println("    Animal end");
        }
    }

    private static void printElement(String elementName, String content)
    {
        System.out.println("        " + elementName + " start");
        System.out.println("            " + content);
        System.out.println("        " + elementName + " end");
    }
}