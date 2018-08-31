package InstanceOf;

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
    double salary;
    Employee(String name, String surname, double salary)
    {
        super(name, surname);
        this.salary = salary;
    }

    @Override
    void description()
    {
        System.out.println("I am employee, my name is " + name + " " + surname + " and my salary is: " + salary + " dolars");

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
        System.out.println("I am Student, my name is " + name + " "  + surname );
    }
}

public class Main
{

    public static void main(String[] args)
    {
        Person[] persons = new Person[5000];
        persons[0] = new Employee("John", "Snow", 12000);
        persons[1] = new Student("Aria","Stark");

//      for (int i = 0; i < persons.length; i++)
//      {
//            if (persons[i] instanceof Person)  //This line checks if person[i] is an instance of Person class
//                persons[i].description();
//            else
//                break;
//      }
        for (Person ifNull: persons )
        {
            if (ifNull instanceof Person)  //This line checks if person[i] is an instance of Person class
            ifNull.description();
            else
                break;
        }



    }

}
