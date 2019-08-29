package planetsparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Парсим таблицу из Planets.html.
 * Выводим на консоль.
 */
public class PlanetParserFromHTML {

    public static void mainMethod() throws IOException {
        File file = new File(PathsGiver.getPathFromPropertise("GeneralPath") + "Planets.html");
        Document document = Jsoup.parse(file, "UTF-8");

        //находим первую таблицу в документе
        //если надо вторую, третью или т.д. используем .get(номер)
        Element table = document.select("table").first();
        // разбиваем нашу таблицу на строки по тегу
        Elements rows = table.select("TR");

        //Здесь получаем строку имён столбцов.
        Elements titleRow = rows.get(0).select("TD");

        //Начинаем с i = 1 т.к. при i = 0 выведутся "Name Mass Radius ...etc."
        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i); //по номеру индекса получает строку
            Elements cols = row.select("TD"); // разбиваем полученную строку по тегу  на столбы
            int count = 0;
            System.out.println(" * * *");
            for (Element e : cols) {
                System.out.println(titleRow.get(count++).text() + ": "
                        + e.text());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        PlanetParserFromHTML.mainMethod();
    }
}