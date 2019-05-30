import java.util.Scanner;

import java.sql.*;

public class StaffTable
{
      
   public static int delete()
   {
      Scanner input = new Scanner(System.in);
      
      int staffId; 
      
      
      System.out.print("Please Enter the Staff ID Number: ");
      int staffID = input.nextInt();
          
      System.out.println();
          
      return staffID;   
   }
   public static String insert()
   {
      Scanner input = new Scanner(System.in);
      input.useDelimiter("\n");
      
      String first, last, phone, email, address, city, state, zipcode;
      
      System.out.print("Please Enter Staff ID: ");
      int staffID = input.nextInt();
        
      System.out.print("Please Enter your First name: ");
      first = input.next();
      
      System.out.print("Please Enter your Last name: ");
      last = input.next();
      
      System.out.print("Please Enter your Phone Number: ");
      phone = input.next();
      
      System.out.print("Please Enter your Email: ");
      email = input.next();
      
      System.out.print("Please Enter your Address: ");
      address = input.next();
      
      System.out.print("Please Enter your City: ");
      city = input.next();
      
      System.out.print("Please Enter your Zipcode: ");
      zipcode = input.next();
      
      System.out.println();
      
      String result = staffID+", '"+first+"','"+last+"','"+phone+"','"+email+"','"+address+"','"+city+"',"+zipcode;
      
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

      String sql = "SELECT * FROM Staff ORDER BY StaffID ASC";
                 ResultSet rs = stmt.executeQuery(sql);
            
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                  System.out.printf("%10s %10s %10s %20s %30s %30s %15s %6s", "staff ID", "First", "Last", "Phone", "email", "Address", "City", "Zipcode");
                  System.out.println();
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                  while(rs.next())
                  {
                     int staffID = rs.getInt("staffId");
                     String first = rs.getString("Fname");
                     String last = rs.getString("Lname");
                     String phone = rs.getString("PhoneNo");
                     String email = rs.getString("Email");
                     String address = rs.getString("Address");
                     String city = rs.getString("City");
                     int zipcode = rs.getInt("Zipcode");
                     
               
                     System.out.format("%10d %10s %10s %20s %30s %30s %15s %6d", staffID, first, last, phone, email, address, city, zipcode);
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