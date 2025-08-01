package com.tss.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentBuddy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> students = new ArrayList<>();

        students.add("Hemanshi");
        students.add("Deep");
        students.add("Harsh");
        students.add("Dharmi");
        students.add("Anup");
        
        System.out.println(students);
        System.out.println("Enter name for whose buddy you want to find: ");
        String name = scanner.nextLine();

        boolean found = false;
        Iterator<String> iterator = students.iterator();
        int index = 0;

        while (iterator.hasNext()) {
            String student = iterator.next();
            if (student.equalsIgnoreCase(name)) {
                found = true;
                break;
            }
            index++;
        }

        if (found) {
            int buddyIndex = (index + 1) % students.size();
            String buddy = students.get(buddyIndex);

            for (int i = buddyIndex; i < students.size(); i++) {
                System.out.println(students.get(i));
            }
        } else {
            System.out.println(name + " not found in the list.");
        }

        scanner.close();
    }
}
