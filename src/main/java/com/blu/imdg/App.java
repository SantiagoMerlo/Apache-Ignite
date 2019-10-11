package com.blu.imdg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

public class App {    

    static final int DATOS = 10;

    public static void main(String[] args) throws Exception
    {
        long TInicio, TFin, tiempo;
    
        Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

        IgniteConfiguration conf = new IgniteConfiguration();
        conf.setClientMode(false);
        Ignite ignite = Ignition.start(conf);
               
        Connection igniteConnection = DriverManager.getConnection("jdbc:ignite:thin://127.0.0.1:10800/","root","root");
        
        Statement sql = igniteConnection.createStatement();
        
        //Tiempo de consulta
        TInicio = System.currentTimeMillis();
        
        sql.executeUpdate("DROP TABLE IF EXISTS Aleatorio");
 
        sql.executeUpdate("CREATE TABLE IF NOT EXISTS Aleatorio(" +
        "id INT PRIMARY KEY," +
        "name VARCHAR(30)," +
        "country VARCHAR(30)," +
        "DNI INT," +
        "freeDay INT)");
 
        for(int i = 0; i < DATOS ; i++){
            PreparedStatement pst = igniteConnection.prepareStatement("INSERT INTO Aleatorio("+
            "id, name, country, DNI, freeDay) VALUES (?, ?, ?, ?, ?)");
            pst.setInt(1, i);
            pst.setString(2, "name "+i);
            pst.setString(3, "Country "+i);
            pst.setInt(4,i);
            pst.setInt(5, i%7);
            pst.executeUpdate();
        }

        ResultSet rs = sql.executeQuery("SELECT id, name FROM Aleatorio");
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        
        System.out.println("|\t\tid\t\t|\t\tnombre\t\t|");
        while(rs.next()){
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            System.out.println("|\t\t"+id+"\t\t|\t\t"+name+"\t\t|");
        }

        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
        igniteConnection.close();
        rs.close();
        sql.close();
        ignite.close();
        
    }
}
