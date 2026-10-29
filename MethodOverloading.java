class Calculator 
{
    int add() 
    {
    return 5 + 10;
    }
    int add(int a, int b) 
    {
        return a + b;
    }
    float add(float a, float b, float c) 
    {
        return a + b + c;
    }
}
public class MethodOverloading 
{
    public static void main(String[] args) 
    {
        Calculator c = new Calculator();
        System.out.println("Default sum: " + c.add());
        System.out.println("Integer sum: " + c.add(20, 30));
        System.out.println("Float sum: " + c.add(2.5f, 3.5f, 4.0f));
    }
}