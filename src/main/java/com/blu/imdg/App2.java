package com.blu.imdg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class App2 {

    static final int DATOS = 10;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PRUEBA","root","root");
        Statement sql = c.createStatement();

        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();

        sql.executeUpdate("DROP TABLE IF EXISTS Employee");

        sql.executeUpdate("CREATE TABLE IF NOT EXISTS Employee(" +
        "id INT PRIMARY KEY," +
        "name VARCHAR(30)," +
        "country VARCHAR(30)," +
        "DNI INT," +
        "freeDay INT)");

        for(int i = 0; i < DATOS ; i++){
            PreparedStatement pst = c.prepareStatement("INSERT INTO Employee("+
            "id, name, country, DNI, freeDay) VALUES (?, ?, ?, ?, ?)");
            pst.setInt(1, i);
            pst.setString(2, "name "+i);
            pst.setString(3, "Country "+i);
            pst.setInt(4, i);
            pst.setInt(5, i%7);
            pst.executeUpdate();
        }

        ResultSet rs = sql.executeQuery("SELECT id, name FROM Employee");
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        
        System.out.println("|\t\tid\t\t|\t\tnombre\t\t|");
        while(rs.next()){
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            System.out.println("|\t\t"+id+"\t\t|\t\t"+name+"\t\t|");
        }
        
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
        
    }
}