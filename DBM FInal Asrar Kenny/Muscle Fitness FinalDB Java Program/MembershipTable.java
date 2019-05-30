import java.util.Scanner; 

import java.sql.*;

public class MembershipTable
{
   public static int delete()
   {
      Scanner input = new Scanner(System.in);
      
      int membershipID; 
      
      
      System.out.print("Please Enter the Membership ID Number: ");
      membershipID = input.nextInt();
          
      System.out.println();
          
      return membershipID;   
   }
   public static String insert()
   {
      Scanner input = new Scanner(System.in);
      input.useDelimiter("\n");
      
      String amount, membershipType;
      
      System.out.print("Please Customer ID: ");
      int membershipID = input.nextInt();
        
      System.out.print("Please Enter Amount: ");
      amount = input.next();
      
      System.out.print("Please Enter Membership Type: ");
      membershipType = input.next();
      
      
      
      System.out.println();
      
      String result = membershipID+", '"+amount+"','"+membershipType+"'";
      
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

      
                 System.out.print("Would you like to Join membership and payment info? yes or no?");
                 String decide = input.next();
                 
                 
                 
                 if(decide.contentEquals("yes"))
                 {
                  
                  String sql = "Select e.MembershipID, Amount, MembershipType, LastPayment, NextPayment, PaymentInfo FROM Membership e, Payment d WHERE e.MembershipID=d.MembershipID";
                  ResultSet rs = stmt.executeQuery(sql);
                  System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                  System.out.printf("%10s %10s %10s %10s %10s %30s", "Membership ID", "Amount","Membership Type", "Last Payment", "Next Payment","Payment Info");
                  System.out.println();
                  System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                  while(rs.next())
                  {
                     int membershipID = rs.getInt("MembershipId");
                     String amount = rs.getString("Amount");
                     String membershipType = rs.getString("MembershipType");
                     String lastPayment = rs.getString("LastPayment");
                     String nextPayment = rs.getString("NextPayment");
                     String paymentInfo = rs.getString("PaymentInfo");
                    
                     
               
                     System.out.format("%10d %13s %13s %13s %13s %30s", membershipID, amount, membershipType ,lastPayment, nextPayment, paymentInfo);
                     System.out.println();             
                  }
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                  rs.close();
                  System.out.println();
                 }
                 else
                 {
                  
                 
                  String sql = "SELECT * FROM Membership";
                  ResultSet rs = stmt.executeQuery(sql);
                  
                  System.out.println("----------------------------------------------------------");
                  System.out.printf("%10s %10s %10s", "Membership ID", "Amount","Membership Type");
                  System.out.println();
                  System.out.println("----------------------------------------------------------");
                  while(rs.next())
                  {
                     int membershipID = rs.getInt("MembershipId");
                     String amount = rs.getString("Amount");
                     String membershipType = rs.getString("MembershipType");
                    
                     
               
                     System.out.format("%10d %13s %13s ", membershipID, amount, membershipType);
                     System.out.println();             
                  }
                  System.out.println("-----------------------------------------------------------");
                  rs.close();
                  System.out.println();
                 } 
         }         
         catch(SQLException ex){
         System.out.println("SQLException: "+ ex.getMessage());
         System.out.println("SQLState: "+ex.getSQLState());
         System.out.println("VendorError: "+ex.getErrorCode());
         }         
   }

}