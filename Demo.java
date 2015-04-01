package com.company;

import java.io.*;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Demo {

    public static double rand(int min, int max) {
        double range = Math.abs(max - min);
        return (Math.random() * range) + (min <= max ? min : max);
    }

    public static void save(MyPet pet) {
        try {
            FileOutputStream fileOut = new FileOutputStream("Save");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pet);
            out.close();
            fileOut.close();
            System.out.println("Saved.");
        } catch (IOException i) {
            System.out.println("Cannot save.");
            i.printStackTrace();
        }
    }

    public static void load(MyPet pet) {
        try {
            FileInputStream fileIn = new FileInputStream("Save");
            ObjectInputStream input = new ObjectInputStream(fileIn);
            pet = (MyPet) input.readObject();
            input.close();
            fileIn.close();
            System.out.println("Loaded succefully");
        } catch (IOException i) {
            System.out.println("Error, cannot load");
            i.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error, cannot load");
        } finally {
            System.out.println(pet.energy);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyDate md = new MyDate();
        String strDate = md.getStrDate();
        String name = "";
        String DOB = strDate;
        Scanner in = new Scanner(System.in);
        System.out.println("Hi, This is your pet simulator\nPlease enter the name of your pet");
        name += in.next();
        MyPet pet = new MyPet(name, DOB);


        // XML
//            try {
//
//                File file = new File("data.txt"); //Default location //C:\Users\msi-pc\IdeaProjects\data.txt
//                System.out.println(file.getAbsolutePath());
//                JAXBContext jaxbContext = JAXBContext.newInstance(MyPet.class);
//                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//                // output pretty printed
//                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//                jaxbMarshaller.marshal(pet, file);
//                jaxbMarshaller.marshal(pet, System.out);
//
//            } catch (JAXBException e) {
//                e.printStackTrace();
//            }

//            try {
//
//                File file = new File("data.txt");
//                JAXBContext jaxbContext = JAXBContext.newInstance(MyPet.class);
//
//                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//                MyPet pet1 = (MyPet) jaxbUnmarshaller.unmarshal(file);
//                System.out.println(pet);
//
//            } catch (JAXBException e) {
//                e.printStackTrace();
//            }


    }

}
