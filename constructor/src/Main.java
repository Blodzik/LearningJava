//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Customer
         Customer customer = new Customer("Tim", 10920.99, "asd@gmail.com");
         System.out.println(customer.getName());

         Customer secondCustomer = new Customer();
         System.out.println(secondCustomer.getName());
         System.out.println(secondCustomer.getCreaditLimit());
         System.out.println(secondCustomer.getCreaditLimit());


        //ComplexNumber
         ComplexNumber number1 = new ComplexNumber(1, 2);
         ComplexNumber number2 = new ComplexNumber(3, 1);

         number1.add(number2);

         System.out.println(number1.getReal() + " " + number1.getImaginary() + "i");

         number1.subtract(4, 3);

         System.out.println(number1.getReal() + " " + number1.getImaginary() + "i");

         //Point
        Point point = new Point(1, 2);
        Point secondPoint = new Point(3, 1);

        System.out.println(point.distance(secondPoint));
        System.out.println(secondPoint.distance(point));
        System.out.println(point.distance(0, 0));
        System.out.println(secondPoint.distance());
    }
}