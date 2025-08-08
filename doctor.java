package Hospitalmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class doctor {
     private Connection connection;
     public doctor(Connection connection){
                this.connection = connection;
    }
    public void viewdoctor(){
        String query = "SELECT * from doctor";
        try{
            PreparedStatement ps =connection.prepareStatement(query);
            ResultSet r = ps.executeQuery();
            System.out.println("doctors");
            while (r.next()){
                int id = r.getInt("id");
                String name = r.getString("name");
                String department = r.getString("dep");
                System.out.printf ("| %-10s | %-7s | %-14s|\n",id,name,department);
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
