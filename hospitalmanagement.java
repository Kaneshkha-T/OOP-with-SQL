package Hospitalmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class hospitalmanagement {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/hospitalmanagement";
    private static final String user = "root";
    private static final String password = "Kaneshkha@123";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        Scanner scn = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("connected to db");
            patient patient = new patient(connection, scn);
            doctor doctor = new doctor(connection);
            while(true){
                System.out.println("weclcome to hospital management system");
                System.out.println("1 add patient");
                System.out.println("2 view patient");
                System.out.println("3 view doctors");
                System.out.println("4 book appointments");
                System.out.println("5 exit");
                System.out.println("enter choice: ");
                int choice = scn.nextInt();
                switch (choice) {
                    case 1: patient.addpatient();
                    break;
                    case 2: patient.viewpatient();
                    break;
                    case 3: doctor.viewdoctor();
                    break;
                
                    default:
                        break;
                }
            }
        }
        catch(Exception e){e.printStackTrace();}

    }

}
