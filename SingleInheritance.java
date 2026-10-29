class Person 
{
    String name;
    int age;
    void displayPerson() 
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Student extends Person 
{
    String course;
    int rollNumber;
    void displayStudent() 
    {
        displayPerson();
        System.out.println("Course: " + course);
        System.out.println("Roll Number: " + rollNumber);
    }
}
public class SingleInheritance 
{
    public static void main(String[] args) 
    {
        Student s = new Student();
        s.name = "Parth Jadhav";
        s.age = 20;
        s.course = "AIDS";
        s.rollNumber = 101;
        s.displayStudent();
    }
}