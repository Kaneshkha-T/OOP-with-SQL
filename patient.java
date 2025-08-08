package Hospitalmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class patient{
    private Connection connection;
    private Scanner scn;

    public patient(Connection connection, Scanner scn){
                this.connection = connection;
                this.scn = scn;
    }

    public void addpatient() {
        System.out.println("Enter patient Name");
        String Name = scn.nextLine();  // Read the full name
        
        System.out.println("Enter patient age");
        while (!scn.hasNextInt()) {  // Ensure correct input
            System.out.println("Invalid input! Enter a valid age:");
            scn.next();
        }
        int age = scn.nextInt();
        scn.nextLine();  // 🔹 Consume the leftover newline  
    
        System.out.println("Enter patient gender");
        String gender = scn.nextLine();
    
        try {
            String query = "INSERT INTO patients(name,age,gender) VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) 
                System.out.println("Patient added successfully!");
            else 
                System.out.println("Patient addition failed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void viewpatient(){
        String query = "SELECT * from patients";
        try{
            PreparedStatement ps =connection.prepareStatement(query);
            ResultSet r = ps.executeQuery();
            System.out.println("patients");
            while (r.next()){
                int id = r.getInt("id");
                String name = r.getString("name");
                int age = r.getInt("age");
                String gender = r.getString("gender");
                System.out.printf ("|%-12s|%-8s|%-8s|%-10s|\n",id,name,age,gender);
            }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        public boolean getdoctorid(int id){
            try {
            String query = "SELECT * FROM doctor where id=?";
            PreparedStatement p = connection.prepareStatement(query);
                p.setInt(1,id);
            ResultSet r = p.executeQuery();
            if(r.next()){
                return true;
            }
            else{
                return false;
            }
            
        }
        catch(Exception e){
                e.printStackTrace();
        }
        return false;
    }  
    
}