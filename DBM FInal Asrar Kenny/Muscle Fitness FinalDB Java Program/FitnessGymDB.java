import java.util.Scanner;

import java.sql.*;

public class FitnessGymDB 
{
   public static void main(String[] args)
   {   
      
      Scanner input = new Scanner(System.in);
      Connection conn = null;
      
      String over = "";
      
      
      
      do{
      
      try
      {
         conn = 
            DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Fall18_ksantiag?serverTimezone=UTC&" +
                                        "user=ksantiag&password=ksantiag");                                        
            Statement stmt = conn.createStatement(); 
         String sel = "";
         String request = "";
         int tableChoice;
         int count = 0; 
         String kg = "";
         String TC = "";
         
System.out.println("                   _                                       _");
System.out.println("    _  _ | |                                     | | _  _");
System.out.println("   | || || |                                     | || || |");
System.out.println("=H| || || |========nnnn=============nnnn========| || || |H=");
System.out.println("   |_||_|| |        |  |             |  |        | ||_||_|");
System.out.println("         |_|        /  |             |  \\        |_|");
System.out.println("                   |   |             |   |");
System.out.println("                   \\   (_   /~~~\\   _)   /");
System.out.println("                    \\    \\ ( '_' ) /    /");
System.out.println("                     \\    )\\  =  /(    /");
System.out.println("                      \\   (_)   (_)   /");
System.out.println("                       \\ /   ~~~   \\ /");
System.out.println("                       (             )\\");
System.out.println("                        \\           /");
System.out.println("                         \\         /");
System.out.println("                          )==(O)==(");
System.out.println("                         /         \\");
System.out.println("                        /____/ \\____\\");
System.out.println("                        /   /   \\   \\");
System.out.println("                       /   /     \\   \\");
System.out.println("                      (   )      (   )");
System.out.println("                      |   |      |   |");
System.out.println("                      |   |      |   |");
System.out.println("                      |___|      |___|");
System.out.println("                      (___)      (___)");
             
         do
         {
            System.out.println("            Welcome To The Muscle Fitness Database");
            System.out.println();
            System.out.println("Please Enter Desired Table Number: ");
            System.out.print("Enter 1 for Staff Table \nEnter 2 for Customer Table \nEnter 3 for Membership Table \nEnter 4 for Payment Info \nEnter 5 for Equiptment Tabel: ");
            tableChoice = input.nextInt();
            TC = tableChoice+"";
            System.out.println();
         }while(TC.matches("[^1-5]"));  
         
         if(tableChoice == 1)
         {
            do
            {
               System.out.println("What would you like to do?");
               System.out.println(); 
               System.out.print("Please select: Insert, Delete, Select or End: ");  
               request = input.next();
               System.out.println();
             }while(!(request.contentEquals("insert") || request.contentEquals("Insert")) && !(request.contentEquals("delete") || request.contentEquals("Delete")) && !(request.contentEquals("select") || request.contentEquals("select")) && !(request.contentEquals("end") || request.contentEquals("End")));
         
            if(request.contentEquals("insert") || request.contentEquals("Insert"))
            {
               
               
               while(!(kg.contentEquals("no"))){
               String result = StaffTable.insert();
               System.out.println("Inserting records into table...");
               String sql = "INSERT into Staff VALUES("+result+")";
               stmt.executeUpdate(sql);
               System.out.print("Would you like to continue? ");
               
               kg = input.next();
               }
            }   
            else if(request.contentEquals("delete") || request.contentEquals("Delete"))
            {
               while(!(kg.contentEquals("no")))
               {
                  int result = StaffTable.delete();
                  System.out.println("Deleting records from table...");
                  String sql = "DELETE FROM Staff WHERE StaffID = '"+result+"'";
                  stmt.executeUpdate(sql);
                  System.out.print("Would you like to continue? ");
                  kg = input.next();
               }
               System.out.println();
            }   
            else if(request.contentEquals("select") || request.contentEquals("select"))
            {
                StaffTable.select();
                System.out.print("Would you like to continue? Yes or No? ");
                over = input.next();
  
            }  
       
         }
         else if(tableChoice == 2)
         {
            do
            {
               System.out.println("What would you like to do?");
               System.out.println(); 
               System.out.print("Please select: Insert, Delete, Select or End: ");  
               request = input.next();
               System.out.println();
             }while(!(request.contentEquals("insert") || request.contentEquals("Insert")) && !(request.contentEquals("delete") || request.contentEquals("Delete")) && !(request.contentEquals("select") || request.contentEquals("select")) && !(request.contentEquals("end") || request.contentEquals("End")));
         
            if(request.contentEquals("insert") || request.contentEquals("Insert"))
            {
               
               
               while(!(kg.contentEquals("no"))){
               String result = CustomerTable.insert();
               System.out.println("Inserting records into table...");
               String sql = "INSERT into Customer VALUES("+result+")";
               stmt.executeUpdate(sql);
               System.out.print("Would you like to continue? ");
               
               kg = input.next();
               }
            }   
            else if(request.contentEquals("delete") || request.contentEquals("Delete"))
            {
               while(!(kg.contentEquals("no")))
               {
                  int result = CustomerTable.delete();
                  System.out.println("Deleting records from table...");
                  String sql = "DELETE FROM Customer WHERE CustomerID = '"+result+"'";
                  stmt.executeUpdate(sql);
                  System.out.print("Would you like to continue? ");
                  kg = input.next();
               }
               System.out.println();
            }   
            else if(request.contentEquals("select") || request.contentEquals("select"))
            {
                CustomerTable.select();
                System.out.print("Would you like to continue? Yes or No? ");
                over = input.next();
  
            }  
       
         }
         else if(tableChoice == 3)
         {
            do
            {
               System.out.println("What would you like to do?");
               System.out.println(); 
               System.out.print("Please select: Insert, Delete, Select or End: ");  
               request = input.next();
               System.out.println();
             }while(!(request.contentEquals("insert") || request.contentEquals("Insert")) && !(request.contentEquals("delete") || request.contentEquals("Delete")) && !(request.contentEquals("select") || request.contentEquals("select")) && !(request.contentEquals("end") || request.contentEquals("End")));
         
            if(request.contentEquals("insert") || request.contentEquals("Insert"))
            {
               
               
               while(!(kg.contentEquals("no"))){
               String result = MembershipTable.insert();
               System.out.println("Inserting records into table...");
               String sql = "INSERT into Staff VALUES("+result+")";
               stmt.executeUpdate(sql);
               System.out.print("Would you like to continue? ");
               
               kg = input.next();
               }
            }   
            else if(request.contentEquals("delete") || request.contentEquals("Delete"))
            {
               while(!(kg.contentEquals("no")))
               {
                  int result = MembershipTable.delete();
                  System.out.println("Deleting records from table...");
                  String sql = "DELETE FROM Staff WHERE StaffID = '"+result+"'";
                  stmt.executeUpdate(sql);
                  System.out.print("Would you like to continue? ");
                  kg = input.next();
               }
               System.out.println();
            }   
            else if(request.contentEquals("select") || request.contentEquals("select"))
            {
                MembershipTable.select();
                System.out.print("Would you like to continue? Yes or No? ");
                over = input.next();
  
            }  
       
         }
         else if(tableChoice == 4)
         {
            do
            {
               System.out.println("What would you like to do?");
               System.out.println(); 
               System.out.print("Please select: Insert, Delete, Select or End: ");  
               request = input.next();
               System.out.println();
             }while(!(request.contentEquals("insert") || request.contentEquals("Insert")) && !(request.contentEquals("delete") || request.contentEquals("Delete")) && !(request.contentEquals("select") || request.contentEquals("select")) && !(request.contentEquals("end") || request.contentEquals("End")));
         
            if(request.contentEquals("insert") || request.contentEquals("Insert"))
            {
               
               
               while(!(kg.contentEquals("no"))){
               String result = paymentInfo.insert();
               System.out.println("Inserting records into table...");
               String sql = "INSERT into Staff VALUES("+result+")";
               stmt.executeUpdate(sql);
               System.out.print("Would you like to continue? ");
               
               kg = input.next();
               }
            }   
            else if(request.contentEquals("delete") || request.contentEquals("Delete"))
            {
               while(!(kg.contentEquals("no")))
               {
                  int result = paymentInfo.delete();
                  System.out.println("Deleting records from table...");
                  String sql = "DELETE FROM Payment WHERE CusID = '"+result+"'";
                  stmt.executeUpdate(sql);
                  System.out.print("Would you like to continue? ");
                  kg = input.next();
               }
               System.out.println();
            }   
            else if(request.contentEquals("select") || request.contentEquals("select"))
            {
                paymentInfo.select();
                System.out.print("Would you like to continue? Yes or No? ");
                over = input.next();
  
            }  
       
         }
         if(tableChoice == 5)
         {
            
            do
            {
               System.out.println("What would you like to do?");
               System.out.println(); 
               System.out.print("Please select: Insert, Delete, Select or End: ");  
               request = input.next();
               System.out.println();
             }while(!(request.contentEquals("insert") || request.contentEquals("Insert")) && !(request.contentEquals("delete") || request.contentEquals("Delete")) && !(request.contentEquals("select") || request.contentEquals("select")) && !(request.contentEquals("end") || request.contentEquals("End")));
         
            if(request.contentEquals("insert") || request.contentEquals("Insert"))
            {
               
               
               while(!(kg.contentEquals("no"))){
               String result = EquiptmentInfo.insert();
               System.out.println("Inserting records into table...");
               String sql = "INSERT into Equiptment VALUES("+result+")";
               stmt.executeUpdate(sql);
               System.out.print("Would you like to continue? ");
               
               kg = input.next();
               }
            }   
            else if(request.contentEquals("delete") || request.contentEquals("Delete"))
            {
               while(!(kg.contentEquals("no")))
               {
                  int result = EquiptmentInfo.delete();
                  System.out.println("Deleting records from table...");
                  String sql = "DELETE FROM Equiptment WHERE EID = '"+result+"'";
                  stmt.executeUpdate(sql);
                  System.out.print("Would you like to continue? ");
                  kg = input.next();
               }
               System.out.println();
            }   
            else if(request.contentEquals("select") || request.contentEquals("select"))
            {
                EquiptmentInfo.select();
                System.out.print("Would you like to continue? Yes or No? ");
                over = input.next();
  
            }  
       
         }
       }
       catch(SQLException ex)
       {
         System.out.println("SQLException: "+ ex.getMessage());
         System.out.println("SQLState: "+ex.getSQLState());
         System.out.println("VendorError: "+ex.getErrorCode());
       }
       System.out.print("would you like to exit the database? yes or no: ");
       over = input.next();
      }while(!(over.contentEquals("yes") || over.contentEquals("YES") || over.contentEquals("Yes"))); 
    }
                               
}   