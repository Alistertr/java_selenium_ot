package Testlink;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Prop {
    public static String getProperty(String namePropery) {

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/test/resources/config.properties");
            property.load(fis);

            return property.getProperty(namePropery);


        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        return namePropery;
    }
}
