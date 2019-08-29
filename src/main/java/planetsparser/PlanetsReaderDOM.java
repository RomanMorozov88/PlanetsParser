package planetsparser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Читаем из xml файла с помощью DOM.
 */
public class PlanetsReaderDOM {

    public static void readFrom(String xmlPath) throws ParserConfigurationException, IOException, SAXException {

        File file = new File(xmlPath);
        String name, mass, day, radius, dencity, distance;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);

        doc.getDocumentElement().normalize();

        // Получаем все узлы с именем "someObject"
        NodeList nodeList = doc.getElementsByTagName("PLANET");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            name = element.getElementsByTagName("NAME").item(0).getTextContent();
            mass = element.getElementsByTagName("MASS").item(0).getTextContent();
            day = element.getElementsByTagName("DAY").item(0).getTextContent();
            radius = element.getElementsByTagName("RADIUS").item(0).getTextContent();
            dencity = element.getElementsByTagName("DENSITY").item(0).getTextContent();
            distance = element.getElementsByTagName("DISTANCE").item(0).getTextContent();
            System.out.printf(" * * *\n"
                            + "Name: %s \n"
                            + "Mass: %s \n"
                            + "Day: %s \n"
                            + "Radius: %s \n"
                            + "Dencity: %s \n"
                            + "Distance: %s \n",
                    name, mass, day, radius, dencity, distance);
        }
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        PlanetsReaderDOM.readFrom(
                PathsGiver.getPathFromPropertise("GeneralPath") + "Planets.xml");
    }
}