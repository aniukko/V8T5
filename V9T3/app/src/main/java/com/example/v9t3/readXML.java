package com.example.v9t3;

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

    public ArrayList<Theatre> theatreXML () {
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

    private String time = "";
    private String time2 = "";
    private String id = "";

    public ArrayList find (String chosenT, String chosenD) {
        ArrayList info = new ArrayList();
        String result;

        for (int i = 0; i < theatres.size(); i++) {
            if (theatres.get(i).getName().equals(chosenT)) {
                id = theatres.get(i).getID();
            }
        }

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String url = "https://www.finnkino.fi/xml/Schedule/?area=" + id + "&dt" + chosenD;
            Document doc2 = builder.parse(url);
            doc2.getDocumentElement().normalize();

            NodeList nList = doc2.getDocumentElement().getElementsByTagName("Show");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String theater = element.getElementsByTagName("TheatreAndAuditorium").item(0).getTextContent();
                    String title = element.getElementsByTagName("Title").item(0).getTextContent();
                    String showStart = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();

                    String[] separated = showStart.split("T");
                    time = separated[1];
                    String[] separated2 = time.split(":");
                    time2 = separated2[0] + ":" + separated2[1];

                    result = "Theater: " + theater + " - Title: " + title + " - Show starts: " + time2;
                    info.add(result);
                    System.out.println(result);
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
        return info;
    }
}
