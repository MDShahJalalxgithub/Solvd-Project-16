package org.example.jaxb;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.Date;

@XmlType(propOrder = {"car", "name", "age", "date"})
public class Student {

    private String name;
    private int age;
    private int id;
    private Car car;
    private Date date;

    public Student() {
    }

    public Student(String name, int age, int id, Car car, Date date) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.car = car;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    @XmlElement
    public void setCar(Car car) {
        this.car = car;
    }

    public Date getDate() {
        return date;
    }

    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", car=" + car +
                ", date=" + date +
                '}';
    }
}