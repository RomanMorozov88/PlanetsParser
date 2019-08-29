package planetsparser;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

/**
 * преобразующая данные из planets.xml в таблицу HTML в Planets.html используя схему Planets.xsl
 */
public class TransformerByPlanetXSL {

    public static void convert(File source, File dest, File scheme) {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(scheme));
            transformer.transform(new StreamSource(source), new StreamResult(dest));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        File source = null;
        File scheme = null;
        File dest = null;
        try {
            source = new File(PathsGiver.getPathFromPropertise("GeneralPath") + "Planets.xml");
            scheme = new File(PathsGiver.getPathFromPropertise("GeneralPath") + "Planets.xsl");
            dest = new File(PathsGiver.getPathFromPropertise("GeneralPath") + "Planets.html");
        } catch (IOException e) {
            e.printStackTrace();
        }

        TransformerByPlanetXSL.convert(source, dest, scheme);
    }

}