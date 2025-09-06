import java.util.Scanner;
public class BankTransactionSystem {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("-------Welcome to UBL bank System------------");
        System.out.println("how many user want to create account?");
        int n = sc.nextInt();

        String[]name=new String[n];
        int[] account_number=new int[n];
        int[] deposit_amount=new int[n];

        for(int i =0; i<n;i++){
            System.out.println("User_account : " +(i+1));
            sc.nextLine();

            System.out.println("Name:");
            name[i]=sc.nextLine();
            System.out.println("Account_number:");
             account_number[i]=sc.nextInt();
             System.out.println("Deposit amount: ");
             deposit_amount[i]=sc.nextInt();

             while(true){
                 System.out.println("-----See operation Menu---------");
                 System.out.print("would you like to ");
                 System.out.println("1. deposit Money.");
                 System.out.println("2. withdraw  money ");
                 System.out.println("3. Check current balance ");
                 System.out.println("4. Exit ");
                 System.out.println("Choose option ");
                 int opt=sc.nextInt();

                 if(opt==1){
                     System.out.println("Enter deposit amount ." );
                     int deposit=sc.nextInt();
                     deposit_amount[i]+=deposit;
                     System.out.println("Amount deposit successsfully ." );

                 }else if(opt==2){
                     System.out.println("withdraw  Amount");
                     int withdraw=sc.nextInt();
                     if(withdraw<=deposit_amount[i]){
                         deposit_amount[i]-=withdraw;
                         System.out.println("Withdraw amount : " +withdraw);
                     }else{
                         System.out.println("Insufficient balance");

                     }

                 }else if(opt==3){
                     System.out.println("Current balance :" +deposit_amount[i]);
                 }else if(opt==4){
                     System.out.println("Exiting transcation successfully");
                     break;
                 }else{
                     System.out.println("Invalid option.Please try again ");
                 }


             }
        }
        System.out.println("\n Thanks for visiting us .");
            sc.close();
    }

}
