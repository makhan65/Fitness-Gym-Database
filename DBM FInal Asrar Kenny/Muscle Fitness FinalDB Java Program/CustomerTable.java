import java.util.Scanner; 

import java.sql.*;

public class CustomerTable
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
      
      String first, last, phone, address, city, zipcode, email, joinDate;
      
      System.out.print("Please Customer ID: ");
      int customerID = input.nextInt();
        
      System.out.print("Please Enter First name: ");
      first = input.next();
      
      System.out.print("Please Enter Last name: ");
      last = input.next();
      
      System.out.print("Please Enter Phone Number: ");
      phone = input.next();
      
      System.out.print("Please Enter Address: ");
      address = input.next();
      
      System.out.print("Please Enter City: ");
      city = input.next();
      
      System.out.print("Please Enter Zipcode: ");
      zipcode = input.next();
      
      System.out.print("Please Enter Email: ");
      email = input.next();
      
      System.out.print("Please Enter Join Date: ");
      email = input.next();
      
      System.out.println();
      
      String result = customerID+", '"+first+"','"+last+"','"+phone+"','"+address+"','"+city+"',"+zipcode+",'"+email+"'";
      
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

      String sql = "SELECT * FROM Customer";
                 ResultSet rs = stmt.executeQuery(sql);
            
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                  System.out.printf("%10s %10s %10s %20s %30s %15s %10s %25s", "Customer ID", "First", "Last", "Phone","Address", "City", "Zipcode","Email");
                  System.out.println();
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                  while(rs.next())
                  {
                     int customerID = rs.getInt("CustomerId");
                     String first = rs.getString("Fname");
                     String last = rs.getString("Lname");
                     String phone = rs.getString("PhoneNo");
                     String address = rs.getString("Address");
                     String city = rs.getString("City");
                     int zipcode = rs.getInt("Zipcode");
                     String  email = rs.getString("Email");
                     
               
                     System.out.format("%10d %10s %10s %20s %30s %15s %10d %25s", customerID, first, last, phone, address, city, zipcode, email);
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