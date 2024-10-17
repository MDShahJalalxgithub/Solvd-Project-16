package org.example.jaxb;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "students")
public class Students {

    private List<Student> list;

    public List<Student> getList() {
        return list;
    }

    @XmlElement(name = "student")
    public void setList(List<Student> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Students{" +
                "list=" + list +
                '}';
    }
}