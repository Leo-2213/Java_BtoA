package com.learning301.uml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Demonstrates Aggregation in UML: College "has" Professors, but their lifecycles are independent
public class Aggregation {
    public static void main(String[] args) {

        // Creating a College object
        College college = new College("IIT", "Mumbai");

        // Creating Professor objects and associating them with the College
        Professor professor = new Professor("Abhijeet", "Delhi", college);
        Professor professor2 = new Professor("Abhijeet2", "Delhi", college);

        // Setting the list of professors in the College (Aggregation)
        college.setProfessors(Arrays.asList(professor, professor2));

        // Output individual professor details
        System.out.println(professor);
        System.out.println(professor2);

        // Output college details including associated professors
        System.out.println(college);
    }

    // Represents the "whole" in the Aggregation relationship
    public static class College {
        private String name;
        private String address;
        private List<Professor> professors;

        // Constructor without professors; professors added later via setter
        College(String name, String address) {
            this.name = name;
            this.address = address;
            this.professors = new ArrayList<>();
        }

        // Getter methods
        public String getName() { return name; }
        public String getAddress() { return address; }
        public List<Professor> getProfessors() { return professors; }

        // Setter method for assigning professors list
        public void setProfessors(List<Professor> professors) {
            this.professors = professors;
        }

        // Custom toString method to avoid infinite loop; prints professor names only
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("College{name='").append(name)
                    .append("', address='").append(address)
                    .append("', professors=[");

            for (Professor p : professors) {
                sb.append(p.getName()).append(", ");
            }

            if (!professors.isEmpty()) {
                sb.setLength(sb.length() - 2); // remove last comma and space
            }

            sb.append("]}");
            return sb.toString();
        }
    }

    // Represents the "part" in the Aggregation relationship
    public static class Professor {
        private String name;
        private String address;
        private College college; // Reference to the College (part of Aggregation)

        // Constructor: College is passed as a reference (not created inside)
        Professor(String name, String address, College college) {
            this.name = name;
            this.address = address;
            this.college = college;
        }

        // Getter methods
        public String getName() { return name; }
        public String getAddress() { return address; }
        public College getCollege() { return college; }

        // toString prints professor info including college name only (not full object)
        @Override
        public String toString() {
            return "Professor{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", college=" + college.getName() + // Avoid printing full college object
                    '}';
        }
    }
}
