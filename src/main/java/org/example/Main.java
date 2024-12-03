package org.example;


import org.example.entity.Employee;


import java.util.*;

public class Main {

    private Map<Integer, Employee> employeeMap;
    private List<Employee> dublicatedEmployees;

    public static void main(String[] args) {

        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1,"name1","surname1"));
        employees.add(new Employee(2,"name2","surname2"));
        employees.add(new Employee(2,"name2","surname2"));
        employees.add(new Employee(3,"name3","surname3"));
        employees.add(new Employee(3,"name3","surname3"));
        employees.add(new Employee(4,"name4","surname4"));

        System.out.println(employees);
        System.out.println("*****************************");
        System.out.println(findDuplicates(employees).size());
        System.out.println(findUniques(employees).size());
        System.out.println(removeDuplicates(employees).size());

        System.out.println("*****************************");

        System.out.println(WordCounter.calculatedWord());


    }



    public static List<Employee> findDuplicates(List<Employee> employees){
        Map<Integer,Employee> employeeMap = new HashMap<>();
        List<Employee> dublicatedEmployees= new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee== null){
                System.out.println("null record");
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
                dublicatedEmployees.add(employee);
            }
            else{
                employeeMap.put(employee.getId(),employee);
            }

        }
        return dublicatedEmployees;
    }

    public static Map<Integer,Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> dublicates = findDuplicates(employees);
        List<Employee> onlyUniques = new LinkedList<>(uniques.values());
        onlyUniques.removeAll(dublicates);
        return onlyUniques;

    }


}