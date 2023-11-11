import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import java.io.*;

public class DOMReadKLNSPG
{

    public static void main(String[] args)
    {

        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\projects\\KLNSPG_XMLGyak\\XMLTaskKLNSPG\\XMLKLNSPG.xml"));

            document.getDocumentElement().normalize();
            readEmployees(document);
            readSites(document);
            readHabitats(document);
            readAnimals(document);
            readFoods(document);
            readEats(document);
            readUsers(document);

        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void readEmployees(Document document)
    {
        NodeList employeeList = document.getElementsByTagName("Employee");
        for (int temp = 0; temp < employeeList.getLength(); temp++)
        {
            Node node = employeeList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                String empId = eElement.getAttribute("emp_id");
                String firstName = eElement.getElementsByTagName("first_name").item(0).getTextContent();
                String lastName = eElement.getElementsByTagName("last_name").item(0).getTextContent();
                String birthDate = eElement.getElementsByTagName("birth_date").item(0).getTextContent();
                String sex = eElement.getElementsByTagName("sex").item(0).getTextContent();
    
                System.out.println("    <Employee emp_id=\"" + empId + "\">");
                System.out.println("        <first_name>" + firstName + "</first_name>");
                System.out.println("        <last_name>" + lastName + "</last_name>");
                System.out.println("        <birth_date>" + birthDate + "</birth_date>");
                System.out.println("        <sex>" + sex + "</sex>");
                System.out.println("    </Employee>");
            }
        }
    }    

    private static void readSites(Document document)
    {
        NodeList siteList = document.getElementsByTagName("Site");
        for (int temp = 0; temp < siteList.getLength(); temp++)
        {
            Node node = siteList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                String siteId = eElement.getAttribute("site_id");
                String works = eElement.getAttribute("Works");
                String manage = eElement.getAttribute("Manage");
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String area = eElement.getElementsByTagName("area").item(0).getTextContent();
                String openingHours = eElement.getElementsByTagName("opening_hours").item(0).getTextContent();
    
                // XML formátumban való kiírás
                System.out.println("    <Site site_id=\"" + siteId + "\" Works=\"" + works + "\" Manage=\"" + manage + "\">");
                System.out.println("        <name>" + name + "</name>");
                System.out.println("        <area>" + area + "</area>");
                System.out.println("        <opening_hours>" + openingHours + "</opening_hours>");
                System.out.println("    </Site>");
            }
        }
    }    

    private static void readHabitats(Document document)
    {
        NodeList habitatList = document.getElementsByTagName("Habitat");
        for (int temp = 0; temp < habitatList.getLength(); temp++)
        {
            Node node = habitatList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                String habitatId = eElement.getAttribute("habitat_id");
                String occupy = eElement.getAttribute("Occupy");
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String location = eElement.getElementsByTagName("location").item(0).getTextContent();
                String description = eElement.getElementsByTagName("description").item(0).getTextContent();

                // XML formátumban való kiírás
                System.out.println("    <Habitat habitat_id=\"" + habitatId + "\" Occupy=\"" + occupy + "\">");
                System.out.println("        <name>" + name + "</name>");
                System.out.println("        <location>" + location + "</location>");
                System.out.println("        <description>" + description + "</description>");
                System.out.println("    </Habitat>");
            }
        }
    }    

    private static void readAnimals(Document document)
    {
        NodeList animalList = document.getElementsByTagName("Animal");
        for (int temp = 0; temp < animalList.getLength(); temp++)
        {
            Node node = animalList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                String animalId = eElement.getAttribute("animal_id");
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String racial = eElement.getElementsByTagName("racial").item(0).getTextContent();
                String description = eElement.getElementsByTagName("description").item(0).getTextContent();
    
                // XML formátumban való kiírás
                System.out.println("    <Animal animal_id=\"" + animalId + "\">");
                System.out.println("        <name>" + name + "</name>");
                System.out.println("        <racial>" + racial + "</racial>");
                System.out.println("        <description>" + description + "</description>");
                System.out.println("    </Animal>");
            }
        }
    }
    
    private static void readFoods(Document document)
    {
        NodeList foodList = document.getElementsByTagName("Food");
        for (int temp = 0; temp < foodList.getLength(); temp++)
        {
            Node node = foodList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                String foodId = eElement.getAttribute("food_id");
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String isDelicious = eElement.getElementsByTagName("is_delicious").item(0).getTextContent();
                String company = eElement.getElementsByTagName("company").item(0).getTextContent();
    
                // XML formátumban való kiírás
                System.out.println("    <Food food_id=\"" + foodId + "\">");
                System.out.println("        <name>" + name + "</name>");
                System.out.println("        <is_delicious>" + isDelicious + "</is_delicious>");
                System.out.println("        <company>" + company + "</company>");
                System.out.println("    </Food>");
            }
        }
    }    

    private static void readEats(Document document)
    {
        NodeList eatList = document.getElementsByTagName("Eat");
        for (int temp = 0; temp < eatList.getLength(); temp++)
        {
            Node node = eatList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                // Az attribútumok és elemek kiolvasása
                String eatId = eElement.getAttribute("eat_id");
                String foodEat = eElement.getAttribute("FoodEat");
                String animalEat = eElement.getAttribute("AnimalEat");
                String feedingTime = eElement.getElementsByTagName("feeding_time").item(0).getTextContent();
    
                // XML formátumban való kiírás
                System.out.println("    <Eat eat_id=\"" + eatId + "\" FoodEat=\"" + foodEat + "\" AnimalEat=\"" + animalEat + "\">");
                System.out.println("        <feeding_time>" + feedingTime + "</feeding_time>");
                System.out.println("    </Eat>");
            }
        }
    }    

    private static void readUsers(Document document)
    {
        NodeList userList = document.getElementsByTagName("User");
        for (int temp = 0; temp < userList.getLength(); temp++)
        {
            Node node = userList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                String userId = eElement.getAttribute("user_id");
                String favor = eElement.getAttribute("Favor");
                String username = eElement.getElementsByTagName("username").item(0).getTextContent();
                String password = eElement.getElementsByTagName("password").item(0).getTextContent();
                String sex = eElement.getElementsByTagName("sex").item(0).getTextContent();
                String firstName = eElement.getElementsByTagName("first_name").item(0).getTextContent();
                String lastName = eElement.getElementsByTagName("last_name").item(0).getTextContent();
                String postCode = eElement.getElementsByTagName("post_code").item(0).getTextContent();
                String city = eElement.getElementsByTagName("city").item(0).getTextContent();
                String street = eElement.getElementsByTagName("street").item(0).getTextContent();
                String number = eElement.getElementsByTagName("number").item(0).getTextContent();
    
                // XML formátumban való kiírás
                System.out.println("    <User user_id=\"" + userId + "\" Favor=\"" + favor + "\">");
                System.out.println("        <username>" + username + "</username>");
                System.out.println("        <password>" + password + "</password>");
                System.out.println("        <sex>" + sex + "</sex>");
                System.out.println("        <first_name>" + firstName + "</first_name>");
                System.out.println("        <last_name>" + lastName + "</last_name>");
                System.out.println("        <post_code>" + postCode + "</post_code>");
                System.out.println("        <city>" + city + "</city>");
                System.out.println("        <street>" + street + "</street>");
                System.out.println("        <number>" + number + "</number>");
                System.out.println("    </User>");
            }
        }
    }    
}
