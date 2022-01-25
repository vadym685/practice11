package org.example.api;

import org.example.model.Student;
import org.example.model.Subject;
import org.w3c.dom.*;
import org.xml.sax.*;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class XML {

    public static boolean validate(String xmlInputFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new InputSource(xmlInputFile));
            return true;
        } catch (Exception se) {
            return false;
        }
    }

    public static void parseXML(String xmlInputFile, String xmlOutFile) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            // parse XML file
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new InputSource(xmlInputFile));
            document.getDocumentElement().normalize();

            // get <group>
            NodeList list = document.getElementsByTagName("student");
            ArrayList<Student> studentList = new ArrayList<Student>();
            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get students attribute
                    String lastname = element.getAttribute("lastname");
                    String groupnumber = element.getAttribute("groupnumber");
                    String firstname = element.getAttribute("firstname");

                    NodeList subjectList = element.getElementsByTagName("subject");
                    ArrayList<Subject> subjects = new ArrayList<Subject>();
                    if (subjectList.getLength() > 0) {
                        for (int subjectListTemp = 0; subjectListTemp < subjectList.getLength(); subjectListTemp++) {
                            Node subjectListNode = subjectList.item(subjectListTemp);
                            if (subjectListNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element subjectElement = (Element) subjectListNode;

                                String title = subjectElement.getAttribute("title");
                                String mark = subjectElement.getAttribute("mark");
                                Subject subject = new Subject(title, Integer.parseInt(mark));
                                subjects.add(subject);
                            }
                        }
                    }

                    String average = element.getElementsByTagName("average").item(0).getTextContent();

                    Student student = new Student(lastname, groupnumber, firstname, Double.parseDouble(average), subjects);
                    studentList.add(student);
                }
            }
            if (studentList.size() > 0) {
                System.out.println("Start fix average");
                fixAverage(studentList);
                System.out.println("Start creating fixed XML File");
                createFixFile(studentList,xmlOutFile);
            }
            System.out.println("App finished");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void fixAverage(ArrayList<Student> studentArrayList) {

        for (Student student : studentArrayList) {

            double sumAverage = 0;
            double tempFixAverage = 0;
            ArrayList<Subject> subjectList = student.getSubjectList();
            for (Subject subject : subjectList) {
                sumAverage = sumAverage + subject.getMark();
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            String stringTempFixAverage = decimalFormat.format(sumAverage / subjectList.size());
            tempFixAverage = Double.parseDouble(stringTempFixAverage.replace(",", "."));
            if (tempFixAverage != 0 && student.getAverage() != tempFixAverage) {
                student.setFixAverage(tempFixAverage);
            }
            System.out.println("Fixing the average student " + student.getFirstname() + " " + student.getLastname() + ", group " + student.getGroupnumber() +
                    ", from " + student.getAverage() + " to " + tempFixAverage);
        }
    }

    private static void createFixFile(ArrayList<Student> studentArrayList, String xmlOutFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();

            Element root = document.createElement("group");
            document.appendChild(root);

            for (Student student: studentArrayList) {

                Element studentElement = document.createElement("student");
                root.appendChild(studentElement);

                Attr firstname = document.createAttribute("firstname");
                firstname.setValue(student.getFirstname());
                studentElement.setAttributeNode(firstname);

                Attr lastname = document.createAttribute("lastname");
                lastname.setValue(student.getLastname());
                studentElement.setAttributeNode(lastname);

                Attr groupnumber = document.createAttribute("groupnumber");
                groupnumber.setValue(student.getGroupnumber());
                studentElement.setAttributeNode(groupnumber);

                for (Subject subject : student.getSubjectList()){
                    Element subjectElement = document.createElement("subject");
                    studentElement.appendChild(subjectElement);

                    Attr title = document.createAttribute("title");
                    title.setValue(subject.getTitle());
                    subjectElement.setAttributeNode(title);

                    Attr mark = document.createAttribute("mark");
                    mark.setValue(String.valueOf(subject.getMark()));
                    subjectElement.setAttributeNode(mark);
                }

                Element average = document.createElement("average");
                average.appendChild(document.createTextNode(String.valueOf(student.getFixAverage())));
                studentElement.appendChild(average);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMImplementation domImpl = document.getImplementation();
            DocumentType doctype = domImpl.createDocumentType("DOCTYPE","group"                    ,
                    "group.dtd");

            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlOutFile));

            transformer.transform(domSource, streamResult);
            System.out.println("Done creating fixed XML File: " + xmlOutFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
