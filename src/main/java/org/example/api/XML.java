package org.example.api;

import org.example.model.Sources;
import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;
import java.io.IOException;
import java.util.ArrayList;


public class XML {

    public static ArrayList<Sources> parseXML(String xmlInputFile) {
        ArrayList<Sources> sourcesList = new ArrayList<Sources>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            // parse XML file
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new InputSource(xmlInputFile));
            document.getDocumentElement().normalize();


            NodeList list = document.getElementsByTagName("datasources");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                Element element = (Element) node;
                String sourceName = element.getElementsByTagName("source-name").item(0).getTextContent();
                String connectionUrl = element.getElementsByTagName("connection-url").item(0).getTextContent();
                String driverClass = element.getElementsByTagName("driver-class").item(0).getTextContent();
                String userName = element.getElementsByTagName("user-name").item(0).getTextContent();
                String password = element.getElementsByTagName("password").item(0).getTextContent();


                Sources source = new Sources(sourceName, connectionUrl, driverClass, userName, password);
                sourcesList.add(source);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return sourcesList;
    }

}
