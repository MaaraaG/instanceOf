package InstanceOf;


import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import javax.sound.midi.Soundbank;

abstract class Person
{
    String name;
    String surname;

    Person (String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }
    abstract void description();
}

class Employee extends Person
{
    private double salary;
    Employee(String name, String surname, double salary)
    {
        super(name, surname);
        this.salary = salary;
    }

    @Override
    void description()
    {
        System.out.println("---------Employee---------");
        System.out.println("name: " + name );
        System.out.println("Surname: "+ surname);
        System.out.println("Salary: " + salary + " dolars");
    }
    void work ()
    {
        System.out.println("status:  working");
        System.out.println("=====================================");
    }
}

class Student extends Person
{
    Student(String name, String surname)
    {
        super(name, surname);
    }

    @Override
    void description()
    {
        System.out.println("---------Student---------");
        System.out.println("name: " + name );
        System.out.println("Surname: "+ surname);
    }

    void studies()
    {
        System.out.println("Status: Studying");
        System.out.println("=====================================");
    }
}


public class Main
{

    public static void main(String[] args)
    {

        Person[] persons = new Person[5000];
        persons[0] = new Employee("John", "Snow", 12000);
        persons[1] = new Student("Aria","Stark");
        persons[2] = new Employee("Sansa", "Stark", 11100);
        persons[3] = new Student("Tobi", "Drab");
        persons[4] = new Employee("Gregor", "Wood", 200000);
//      for (int i = 0; i < persons.length; i++)  //different loop for the same solution
//      {
//            if (persons[i] instanceof Person)  //This line checks if person[i] is an instance of Person class
//                persons[i].description();
//            else
//                break;
//      }
        for (Person emp: persons )
        {
            if (emp instanceof Employee)  //This line checks if person[i] is an instance of Person class
            {
                emp.description();  //down casting from Person to Employee
                ((Employee)emp).work();
            }
        }

        for (Person st: persons )
        {
            if (st instanceof Student)
            {
                st.description();
                ((Student)st).studies();
            }
        }




    }

}
