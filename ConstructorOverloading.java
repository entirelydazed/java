class Calculator 
{
    Calculator() 
    {
        System.out.println("Welcome to Calculator!");
    }
        Calculator(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }
}
public class ConstructorOverloading 
{
    public static void main(String[] args) 
    {
        Calculator c1 = new Calculator();
        Calculator c2 = new Calculator(10, 20);
    }
}