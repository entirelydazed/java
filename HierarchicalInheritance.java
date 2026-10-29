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
    int rollNumber;
    void display()
    {
        displayPerson();
        System.out.println("Roll Number: " + rollNumber);
    }
}

class Teacher extends Person 
{
    String subject;
    void display() 
    {
        displayPerson();
        System.out.println("Subject: " + subject);
    }
}
class Administrator extends Person {
    String role;
    void display() {
        displayPerson();
        System.out.println("Role: " + role);
    }
}
public class HierarchicalInheritance {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Amit";
        s.age = 20;
        s.rollNumber = 101;
        Teacher t = new Teacher();
        t.name = "Priya";
        t.age = 35;
        t.subject = "Java";
        Administrator a = new Administrator();
        a.name = "Rahul";
        a.age = 40;
        a.role = "Office Administrator";
        System.out.println("--- Student ---");
        s.display();
        System.out.println("\n--- Teacher ---");
        t.display();
        System.out.println("\n--- Administrator ---");
        a.display();
    }
}