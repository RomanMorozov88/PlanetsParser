package planetsparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Читаем из xml файла с помощью SAX.
 */
public class PlanetsReaderSAX {

    private class CustomDefHandler extends DefaultHandler {

        private String thisElement;

        public String name, mass, day, radius, dencity, distance;

        @Override
        public void startDocument() {
            System.out.println("Start parse XML...\n");
        }

        @Override
        public void endDocument() {
            System.out.println("\nEnd parse XML.\n");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("PLANET")) {
            }
            thisElement = qName;
        }

        @Override
        public void endElement(String namespaceURI, String localName, String qName) {
            if (qName.equals("PLANET")) {
                System.out.printf(" * * *\n"
                                + "Name: %s \n"
                                + "Mass: %s \n"
                                + "Day: %s \n"
                                + "Radius: %s \n"
                                + "Dencity: %s \n"
                                + "Distance: %s \n",
                        name, mass, day, radius, dencity, distance);
            }
            thisElement = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (thisElement.equals("NAME")) {
                this.name = new String(ch, start, length);
            }
            if (thisElement.equals("MASS")) {
                this.mass = new String(ch, start, length);
            }
            if (thisElement.equals("DAY")) {
                this.day = new String(ch, start, length);
            }
            if (thisElement.equals("RADIUS")) {
                this.radius = new String(ch, start, length);
            }
            if (thisElement.equals("DENSITY")) {
                this.dencity = new String(ch, start, length);
            }
            if (thisElement.equals("DISTANCE")) {
                this.distance = new String(ch, start, length);
            }
        }
    }

    public void mainMethod(String xmlPath) {
        File file = new File(xmlPath);
        CustomDefHandler handler = new CustomDefHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            try {
                parser.parse(file, handler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PlanetsReaderSAX planetsReader = new PlanetsReaderSAX();
        try {
            planetsReader.mainMethod(
                    PathsGiver.getPathFromPropertise("GeneralPath") + "Planets.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}