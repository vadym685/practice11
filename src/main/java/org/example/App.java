package org.example;

import org.example.api.XML;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class App 
{
    private static final String DATA_FOLDER = "src/main/java/org/example/data/";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        System.out.println("App started");
        System.out.println("Start validate file " + args[0]);
        if (XML.validate(DATA_FOLDER + args[0])) {
            System.out.println("Validate success");
            XML.parseXML(DATA_FOLDER + args[0], DATA_FOLDER + args[1]);
        }else {
            System.out.println("Validate fail");
        }
    }
}
