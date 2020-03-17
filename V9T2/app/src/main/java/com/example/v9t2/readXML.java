package com.example.v9t2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class readXML {
    private static readXML read = new readXML();

    public static readXML getInstance() {
        return read;
    }

    private ArrayList<Theatre> theatres = new ArrayList<Theatre>();

    public ArrayList<Theatre> XML () {
        String ID;
        String name;

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String url = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document doc = builder.parse(url);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                Theatre t = new Theatre();

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    ID = element.getElementsByTagName("ID").item(0).getTextContent();
                    name = element.getElementsByTagName("Name").item(0).getTextContent();

                    t.theatreInfo(ID, name);
                    theatres.add(t);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            System.out.println("###########DONE###########");
        }
        return theatres;
    }
}
