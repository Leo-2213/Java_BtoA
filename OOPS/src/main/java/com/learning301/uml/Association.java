package com.learning301.uml;

import java.util.List;

// Main class to demonstrate the Association between Hospital and Doctor
public class Association {
    public static void main(String[] args) {

        // Creating individual Doctor objects
        Doctor doctor1 = new Doctor("Abhijeet", 25, 10);
        Doctor doctor2 = new Doctor("Abhijeet2", 30, 8);
        Doctor doctor3 = new Doctor("Abhijeet3", 28, 5);

        // Creating a Hospital object that has a list of Doctors
        Hospital hospital = new Hospital("Apollo", "Delhi", List.of(doctor1, doctor2, doctor3));

        // Display hospital and doctor information
        System.out.println("🏥 Hospital: " + hospital.getName() + ", 📍 Address: " + hospital.getAddress());
        System.out.println("👨‍⚕️ Doctors:");
        hospital.getDoctors().forEach(System.out::println);
    }
    // Represents a Doctor (can exist independently of a Hospital)
    public static class Doctor {
        private String name;
        private int age;
        private int yearOfExp;

        // Constructor
        Doctor(String name, int age, int yearOfExp) {
            this.name = name;
            this.age = age;
            this.yearOfExp = yearOfExp;
        }

        // Getter methods
        public String getName() { return name; }
        public int getYearOfExp() { return yearOfExp; }

        // toString method to print doctor details
        @Override
        public String toString() {
            return "Dr. " + name + " (Age: " + age + ", Exp: " + yearOfExp + " yrs)";
        }
    }

    // Represents a Hospital that "has-a" list of Doctors (association)
    public static class Hospital {
        private String name;
        private String address;
        private List<Doctor> doctors;

        // Constructor
        Hospital(String name, String address, List<Doctor> doctors) {
            this.name = name;
            this.address = address;
            this.doctors = doctors;
        }

        // Getter methods
        public String getName() { return name; }
        public String getAddress() { return address; }
        public List<Doctor> getDoctors() { return doctors; }
    }
}


