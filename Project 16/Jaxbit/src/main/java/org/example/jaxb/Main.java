package org.example.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException, ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
        Date date = simpleDateFormat.parse("22-1-2024");

        Date date1 = new Date();
        String abs = simpleDateFormat.format(date1);


        // Uncomment to test unmarshalling
        // Students students = unmarshal();
        // System.out.println(students);

        marshal();
    }

    public static Students unmarshal() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Students.class);
        InputStream inputStream = Main.class.getResourceAsStream("/students.xml");
        return (Students) context.createUnmarshaller()
                .unmarshal(new InputStreamReader(inputStream));
    }

    public static void marshal() throws JAXBException {
        Student ivan = new Student("Ivan", 30, 1, new Car("GLEE"), new Date());
        Student palka = new Student("Palka", 20, 2, new Car("Subaru"), new Date());

        Students students = new Students();
        List<Student> list = new ArrayList<>();
        list.add(ivan);
        list.add(palka);
        students.setList(list);

        JAXBContext context = JAXBContext.newInstance(Students.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(students, new File("students1.xml"));
    }
}