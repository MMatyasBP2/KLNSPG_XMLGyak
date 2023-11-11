import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class DOMWriteKLNSPG
{

    public static void main(String[] args)
    {
        try
        {
            File inputFile = new File("C:\\projects\\KLNSPG_XMLGyak\\XMLTaskKLNSPG\\XMLKLNSPG.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            printNode(doc.getDocumentElement(), "");
            writeDocumentToFile(doc, "XMLKLNSPG1.xml");

            System.out.println("The content has been written to the output file successfully.");
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

    private static void printNode(Node node, String indent)
    {
        System.out.print(indent + "<" + node.getNodeName());

        // Print attributes if any
        if (node.hasAttributes())
        {
            NamedNodeMap nodeMap = node.getAttributes();
            for (int i = 0; i < nodeMap.getLength(); i++)
            {
                Node attr = nodeMap.item(i);
                System.out.print(" " + attr.getNodeName() + "=\"" + attr.getNodeValue() + "\"");
            }
        }

        NodeList children = node.getChildNodes();
        if (children.getLength() > 0)
        {
            System.out.println(">");

            // Recursively handle child nodes
            String childIndent = indent + "    ";
            for (int i = 0; i < children.getLength(); i++)
            {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                    printNode(child, childIndent);
                else if (child.getNodeType() == Node.TEXT_NODE)
                {
                    String content = child.getTextContent().trim();
                    if (!content.isEmpty())
                        System.out.println(childIndent + content);
                }
            }

            System.out.println(indent + "</" + node.getNodeName() + ">");
        }
        else System.out.println("/>");
    }

    private static void writeDocumentToFile(Document doc, String filename) throws TransformerException
    {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filename));
        transformer.transform(source, result);
    }
}
