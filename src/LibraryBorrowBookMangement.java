import java.util.Scanner;
public class LibraryBorrowBookMangement {
    public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     System.out.println("----------Welcome to Central Library-------- ");
     System.out.println("How many citizen borrow books today?");
     int n=sc.nextInt();

     String[] names=new String[n];
     int[] code_number= new int[n];
     String[] book_Title=new String[n];
     String [] return_status=new String[n];

     int return_count=0;
     int no_return_count=0;

     for(int i =0; i<n; i++){
         System.out.println("Citizen :"+(i+1));

         sc.nextLine();
         System.out.println("names :");
         names[i]=sc.nextLine();
         System.out.println(" code number :");
         code_number[i]=sc.nextInt();
         System.out.println("Book title :");
         book_Title[i]=sc.nextLine();
         sc.nextLine();


         while(true){
             System.out.println("Has the book?(returned/not returned):");
             String  books_return=sc.nextLine();
             if(books_return.equalsIgnoreCase("returned")){
                 return_status[i]="returned";
                 return_count++;
                 break;
             }else if(books_return.equalsIgnoreCase("not return")){
                 return_status[i]="not return";
                 no_return_count++;
                 break;

             }else{
                 System.out.println("Invalid.Must be 'return' or 'no return' :");
             }

         }
     }
        // display total result
        System.out.println("Total borrowed books : " +n);
        System.out.println("Books returned : "+return_count);
        System.out.println("books are  still pending : "+no_return_count);
      //total citizen not returned books ;
        for(int i =0; i<n;i++){
            System.out.println("Name"+names[i]+"| code number"+code_number[i]);
        }
     // display as a tabular form
        for(int i =0; i<n; i++){
            System.out.println("Names"+names[i]+" | code number "+code_number[i]+" | return status"+return_status[i]);
        }
        sc.close();

    }
}
