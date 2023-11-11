import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DOMQueryKLNSPG
{
    public static void main(String argv[]) throws SAXException, IOException, ParserConfigurationException
    {
        File xmlFile = new File("C:\\projects\\KLNSPG_XMLGyak\\XMLTaskKLNSPG\\XMLKLNSPG.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        // Lekérdezés a férfi Employee-kre
        NodeList employeeList = doc.getElementsByTagName("Employee");
        System.out.println("\nEmployees:");
        for (int i = 0; i < employeeList.getLength(); i++)
        {
            Node node = employeeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                String sex = element.getElementsByTagName("sex").item(0).getTextContent();
                if (sex.equals("M"))
                {
                    String empId = element.getAttribute("emp_id");
                    String firstName = element.getElementsByTagName("first_name").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("last_name").item(0).getTextContent();
                    String birthDate = element.getElementsByTagName("birth_date").item(0).getTextContent();
                    System.out.println("ID: " + empId + ", Name: " + firstName + " " + lastName + ", Birth Date: " + birthDate + ", Sex: " + sex);
                }
            }
        }

        // Lekérdezés a legnagyobb m^3-rű Site-ra
        NodeList siteList = doc.getElementsByTagName("Site");
        int maxArea = 0;
        String maxAreaSiteId = null;
        String maxAreaSiteName = null;
        for (int i = 0; i < siteList.getLength(); i++)
        {
            Node node = siteList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                String siteId = element.getAttribute("site_id");
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String area = element.getElementsByTagName("area").item(0).getTextContent();
                int currentArea = Integer.parseInt(area);
                if (currentArea > maxArea)
                {
                    maxArea = currentArea;
                    maxAreaSiteId = siteId;
                    maxAreaSiteName = name;
                }
            }
        }
        System.out.println("\nSite with the largest area:");
        System.out.println("Site ID: " + maxAreaSiteId + ", Name: " + maxAreaSiteName + ", Area: " + maxArea);

        // Lekérdezés az 1999 után született Employee-kre
        employeeList = doc.getElementsByTagName("Employee");
        System.out.println("\nEmployees born after 1999:");
        for (int i = 0; i < employeeList.getLength(); i++)
        {
            Node node = employeeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                String birthDate = element.getElementsByTagName("birth_date").item(0).getTextContent();
                String[] birthDateParts = birthDate.split("-");
                int birthYear = Integer.parseInt(birthDateParts[0]);
                if (birthYear > 1999)
                {
                    String empId = element.getAttribute("emp_id");
                    String firstName = element.getElementsByTagName("first_name").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("last_name").item(0).getTextContent();
                    System.out.println("ID: " + empId + ", Name: " + firstName + " " + lastName + ", Birth Date: " + birthDate);
                }
            }
        }

        // Lekérdezés a "Medve park" nevű Habitat description-jére
        NodeList habitatList = doc.getElementsByTagName("Habitat");
        System.out.println("\nDescription of \"Medve Park\":");
        for (int i = 0; i < habitatList.getLength(); i++)
        {
            Node node = habitatList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                if (name.equals("Medve park"))
                {
                    String description = element.getElementsByTagName("description").item(0).getTextContent();
                    System.out.println("Habitat description: " + description);
                }
            }
        }

        // Lekérdezés a 3. id-jú User lakcímére
        NodeList userList = doc.getElementsByTagName("User");
        System.out.println("\nAddress of user_id 3:");
        for (int i = 0; i < userList.getLength(); i++)
        {
            Node node = userList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;
                String userId = element.getAttribute("user_id");
                if (Integer.parseInt(userId) == 3)
                {
                    String postCode = element.getElementsByTagName("post_code").item(0).getTextContent();
                    String city = element.getElementsByTagName("city").item(0).getTextContent();
                    String street = element.getElementsByTagName("street").item(0).getTextContent();
                    String number = element.getElementsByTagName("number").item(0).getTextContent();
                    System.out.println("User address: " + postCode + " " + city + " " + street + " " + number);
                }
            }
        }
    }
}