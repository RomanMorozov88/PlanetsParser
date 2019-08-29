package planetsparser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlanetsWriteInXML {

    @XmlRootElement
    public static class Planet {

        @XmlElement(name = "NAME")
        private String name;
        @XmlElement(name = "MASS")
        private String mass;
        @XmlAttribute
        private String massUnits = "(Earth = 1)";
        @XmlElement(name = "DAY")
        private String day;
        @XmlAttribute(name = "UNITS")
        private String dayUnits = "days";
        @XmlElement(name = "RADIUS")
        private String radius;
        @XmlAttribute(name = "UNITS")
        private String radiusUnits = "miles";
        @XmlElement(name = "DENSITY")
        private String density;
        @XmlAttribute(name = "UNITS")
        private String densityUnits = "(Earth = 1)";
        @XmlElement(name = "DISTANCE", required = true)
        private String distance;
        @XmlAttribute(name = "UNITS")
        private String distanceUnits = "million miles";

        public Planet() {
        }

        public Planet(String name, String mass, String day, String radius, String density, String distance) {
            this.name = name;
            this.mass = mass;
            this.day = day;
            this.radius = radius;
            this.density = density;
            this.distance = distance;
        }
    }

    @XmlRootElement(name = "PLANETS")
    private static class PlanetsList {
        private List<Planet> list = new ArrayList<>();

        @XmlAnyElement(lax = true)
        public List<Planet> getValues() {
            return this.list;
        }

        public void setValue(Planet planet) {
            this.list.add(planet);
        }
    }

    public static void mainMetgod(String targetPath, PlanetsList list) throws JAXBException {
        File target = new File(targetPath);

        JAXBContext context = JAXBContext.newInstance(PlanetsList.class, Planet.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(list, target);
    }

    public static void main(String[] args) throws JAXBException {
        Planet earth = new Planet(
                "Earth", "1", "1", "2107", "1", "128.4");
        Planet mercury = new Planet(
                "Mercury", ".0553", "58.65", "1516", ".983", "43.4");
        Planet venus = new Planet(
                "Venus", ".815", "116.75", "3716", ".943", "66.8");

        PlanetsList list = new PlanetsList();
        list.setValue(mercury);
        list.setValue(venus);
        list.setValue(earth);

        try {
            PlanetsWriteInXML.mainMetgod(
                    PathsGiver.getPathFromPropertise("GeneralPath") + "Planets.xml",
                    list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}