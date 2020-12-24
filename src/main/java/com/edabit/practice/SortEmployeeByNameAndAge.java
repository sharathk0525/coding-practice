package com.edabit.practice;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class SortEmployeeByNameAndAge {
    public static void main(String[] args) {
        Employee employee1 = new Employee(12, "BBB");
        Employee employee2 = new Employee(90, "AAA");
        Employee employee3 = new Employee(44, "EEE");
        Employee employee4 = new Employee(5, "ZZZ");

        List<Employee> employeeList = Arrays.asList(employee1,employee2,employee3,employee4);
        Optional<Employee> max      = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
        //System.out.println(max.get().age);
        Comparator<Employee> employeeAgeComparator =
                Comparator.comparing(Employee::getName).thenComparingInt(Employee::getAge);
        Collections.sort(employeeList, employeeAgeComparator);
        //System.out.println(employeeList);

        Format formatter = new SimpleDateFormat("YYYY-MM-dd hh-mm-ss aa");
        DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("YYYY-MM-dd_hh-mm-ss");
        //System.out.println(timeStampPattern.format(java.time.LocalDateTime.now()) );

        DateFormat dateFormat2 = new SimpleDateFormat("MMMM-dd-yyyy hh.mm aa");
        String     dateString2 = dateFormat2.format(new Date()).toString();
        System.out.println(dateString2);

    }

    static class Employee {
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Employee(int age,
                        String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Employee{" +
                   "age=" + age +
                   ", name='" + name + '\'' +
                   '}';
        }
    }
}


