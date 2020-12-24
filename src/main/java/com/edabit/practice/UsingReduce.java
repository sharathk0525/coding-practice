package com.edabit.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsingReduce {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee((float) 23.0),
                                                    new Employee((float) 9.0),
                                                    new Employee((float) 45.0));

        Optional<Employee> reduce = employeeList.stream()
                                                .reduce((employee1, employee2) -> employee1.getSalary() > employee2.getSalary()
                                                        ? employee1: employee2);

        Optional<Float> reduce1 = employeeList.stream().map(employee -> employee.getSalary())
                                              .reduce((aFloat, aFloat2) -> aFloat > aFloat2? aFloat: aFloat2);

        Optional<Float> reduce2 = employeeList.stream().map(employee -> employee.getSalary())
                                              .reduce((aFloat, aFloat2) -> aFloat > aFloat2 ? aFloat : aFloat2);

        Optional<Employee> min = employeeList.stream().min((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));
        Optional<Employee> max = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        Optional<Float> max1 =
                employeeList.stream().map(employee -> employee.getSalary()).max(Comparator.comparingDouble(Float::floatValue));

        //System.out.println(max.get().getSalary());
      ///  System.out.println(max1.get());

        Optional<String> passOpt = Optional.of("password");
        passOpt
                .map(String::trim)
                .filter(pass -> pass.equals("password"))
                .isPresent();

        Optional<String> opt = Optional.ofNullable(null);
        String name = opt.orElse("hi");
        //System.out.println(name);

        Optional<Employee> max2 = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
        //System.out.println(max2.get().getSalary());

        Optional<Employee> collect = employeeList.stream()
                                                 .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        //System.out.println(collect.get().getSalary());
        Optional<Employee> reduce3 = employeeList.stream()
                                                 .reduce((employee, employee2) -> employee.getSalary() > employee.getSalary()
                                                         ? employee:
                                                         employee2);
       // System.out.println(reduce3.get().getSalary());
        Float reduce4 = employeeList.stream().map(Employee::getSalary).reduce(0f, (sal1, sal2) -> sal1 + sal2);
        System.out.println(reduce4);
    }
}

class Employee {
    private float salary;

    public Employee(float salary) {
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "salary=" + salary +
               '}';
    }
}
