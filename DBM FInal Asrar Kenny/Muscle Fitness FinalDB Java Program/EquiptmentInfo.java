import java.util.Scanner; 

import java.sql.*;

public class EquiptmentInfo
{
   public static int delete()
   {
      Scanner input = new Scanner(System.in);
      
      int staffId; 
      
      
      System.out.print("Please Enter the EIC Number: ");
      int staffID = input.nextInt();
          
      System.out.println();
          
      return staffID;   
   }
   public static String insert()
   {
      Scanner input = new Scanner(System.in);
      input.useDelimiter("\n");
      
      String name, condition, lastInspection, purchased;
      
      System.out.print("Please Customer ID: ");
      int EID = input.nextInt();
      
      System.out.print("Please Enter Equiptment Name: ");
      name = input.next();
      
      System.out.print("Enter Condition: ");
      condition = input.next();
      
      System.out.print("Enter Inspection: ");
      lastInspection = input.next();
      
      System.out.print("Purchase Date: ");
      purchased = input.next();
      
      System.out.println();
      
      String result = EID+", '"+name+"','"+condition+"','"+lastInspection+"','"+purchased+"'";
      
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

      String sql = "SELECT * FROM Equiptment";
                 ResultSet rs = stmt.executeQuery(sql);
            
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                  System.out.printf("%15s %25s %20s %20s %30s", "EquiptmentID", "Equpitment Name", "Condition", "Last Inspection", "Purchased On");
                  System.out.println();
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                  while(rs.next())
                  {
                     int EID = rs.getInt("EID");
                     String name = rs.getString("Ename");
                     String condition = rs.getString("Econdition");
                     String lastInspection = rs.getString("LastInspection");
                     String purchased = rs.getString("PurchaseDate");
                    
                     
               
                     System.out.format("%15d %25s %20s %20s %30s", EID, name, condition, lastInspection, purchased);
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