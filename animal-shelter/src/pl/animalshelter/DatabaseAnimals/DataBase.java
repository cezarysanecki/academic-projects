package pl.animalshelter.DatabaseAnimals;

import pl.animalshelter.Units.Animal;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    private static final String DataBase_Driver = "com.mysql.cj.jdbc.Driver";
    private static final String DataBase_URL = "jdbc:mysql://localhost:3306/MYSHELTER";
    private static final String USER = "root";
    private static final String PASS = "root";
    private Statement stmt = null;
    private Connection conn = null;

    public void connection() {
        try {
            Class.forName(DataBase_Driver);
            System.out.println("Connection to database...");
            conn = DriverManager.getConnection(DataBase_URL, USER, PASS);
            stmt = conn.createStatement();
            System.out.println("Connected database successfully...");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Animal> getDatabase() {
        ArrayList<Animal> animals = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("Select * from MYSHELTER.ANIMALS ORDER BY ID_ANIMAL");
            while (rs.next()) {
                animals.add(new Animal(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4)));
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return animals;
    }

    public void add(Animal animal) {
        try {
            stmt.executeUpdate("INSERT INTO ANIMALS " + "VALUES (" + animal.getId_animal() + ", '" + animal.getName() + "', '" + animal.getKindOfAnimal()
                    + "', " + animal.getAge() + ")");
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void delete(Animal animal) {
        try {
            stmt.executeUpdate("DELETE FROM ANIMALS " + "WHERE ID_ANIMAL = " + animal.getId_animal() + " AND NAME = '" + animal.getName() + "' AND KIND = '" + animal.getKindOfAnimal()
                    + "' AND AGE = " + animal.getAge());
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void updateID(int id) {
        try {
            int oldId = id + 1;
            stmt.executeUpdate("UPDATE ANIMALS " + "SET ID_ANIMAL = " + id + " WHERE ID_ANIMAL = " + oldId);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void disconnect() {
            try {
                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        System.out.println("Goodbay!");
        }
}
