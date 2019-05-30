import java.util.Scanner; 

import java.sql.*;

public class paymentInfo
{
   public static int delete()
   {
      Scanner input = new Scanner(System.in);
      
      int staffId; 
      
      
      System.out.print("Please Enter the Customer ID Number: ");
      int staffID = input.nextInt();
          
      System.out.println();
          
      return staffID;   
   }
   public static String insert()
   {
      Scanner input = new Scanner(System.in);
      input.useDelimiter("\n");
      
      String lastPayment, nextPayment, paymentInfo;
      
      System.out.print("Please Customer ID: ");
      int customerID = input.nextInt();
        
      System.out.print("Please Enter Membership ID: ");
      int membershipID = input.nextInt();
      
      System.out.print("Please Enter Last Payment Date: ");
      lastPayment = input.next();
      
      System.out.print("Next Payment Date: ");
      nextPayment = input.next();
      
      System.out.print("Payment Info: ");
      paymentInfo = input.next();
      
      System.out.println();
      
      String result = customerID+", "+membershipID+",'"+lastPayment+"','"+nextPayment+"','"+paymentInfo+"'";
      
      return result;     
   }
   public static void select()
   {
     Scanner input = new Scanner(System.in);
      Connection conn = null;
     try
      {
         conn = 
            DriverManager.getConnection("jdbc:mysql://cs.neiu.edu:3306/db_Fall18_ksantiag?serverTimezone=UTC&" +
                                        "user=ksantiag&password=ksantiag");                                        
            Statement stmt = conn.createStatement(); 

      String sql = "SELECT * FROM Payment";
                 ResultSet rs = stmt.executeQuery(sql);
            
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                  System.out.printf("%10s %10s %10s %20s %30s", "Customer ID", "Membership ID", "LastPayment", "NextPayment","PaymentInfo");
                  System.out.println();
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                  while(rs.next())
                  {
                     int customerID = rs.getInt("CustomerId");
                     int membershipID = rs.getInt("MembershipID");
                     String lastPayment = rs.getString("LastPayment");
                     String nextPayment = rs.getString("NextPayment");
                     String paymentInfo = rs.getString("PaymentInfo");
                    
                     
               
                     System.out.format("%10d %10s %10s %20s %30s", customerID, membershipID, lastPayment, nextPayment, paymentInfo);
                     System.out.println();             
                  }
                  System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                  rs.close();
                  System.out.println();
         }         
         catch(SQLException ex){
         System.out.println("SQLException: "+ ex.getMessage());
         System.out.println("SQLState: "+ex.getSQLState());
         System.out.println("VendorError: "+ex.getErrorCode());
         }         
   }

}