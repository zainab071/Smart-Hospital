import java.util.Scanner;
public class CalculatorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("First number ");
            int num1=sc.nextInt();
            System.out.println("Second number ");
            int num2=sc.nextInt();
            System.out.println("\n choose option(+,-,*,/): ");
            char opt=sc.next().charAt(0);
            double result  =0;
            switch(opt){
                case'+':
                    result=num1+num2;
                    System.out.println(result);
                    break;
                case'-':
                    result=num1-num2;
                    System.out.println(result);
                    break;
                case'*':
                    result=num1*num2;
                    System.out.println(result);
                    break;
                case'/' :
                    if(num2!=0){
                        result=num1/num2;
                        System.out.println("Result :"+result);

                    }else{
                        System.out.println("Error:it cannot be divide ");
                    }
                    break;

                default:
                    System.out.println("invalid .Try again ");
            }
            System.out.println("Do you want to continue? (y/n): ");
            char option=sc.next().charAt(0);
            if (option=='y'|| option=='n') {
                System.out.println("Calculator closed.");
                break;
            }
        }
            sc.close();
            }




    }

