package org.example.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XMLParser {
    public static void main(String[] args) {
        try {
            // Create JAXB context
            JAXBContext context = JAXBContext.newInstance(Students.class);

            // Create Unmarshaller
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Unmarshal XML
            Students students = (Students) unmarshaller.unmarshal(new File("students.xml"));
            System.out.println(students);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}