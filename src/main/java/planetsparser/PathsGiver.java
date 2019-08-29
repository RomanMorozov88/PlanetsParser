package planetsparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Возвращает путь.
 */
public class PathsGiver {

    public static String getPathFromPropertise(String key) throws IOException {
        Properties prs = new Properties();
        ClassLoader loader = PathsGiver.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream(
                "paths/app.properties")) {
            prs.load(in);
        }
        return prs.getProperty(key);
    }

}