class Person 
{
    String name;
    int age;
}
class Student extends Person 
{
    String course;
    int rollNumber;
}
class GraduateStudent extends Student 
{
        int graduationYear;
        void display() 
        {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Course: " + course);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Graduation Year: " + graduationYear);
    }
}
    public class MultilevelInheritance 
    {
        public static void main(String[] args) 
        {
            GraduateStudent g = new GraduateStudent();
            g.name = "Parth Jadhav";
            g.age = 22;
            g.course = "MCA";
            g.rollNumber = 101;
            g.graduationYear = 2027;
            g.display();
    }
}