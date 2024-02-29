package org.aguzman.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
Para conectarnos a una base de datos y no tener que
estar creado muchas conexiones y dejar más desacoplada la aplicación
nos conectamos a esta utilizando el patron de diseño singleton:
 */
public class ConexionBD {
    /*
        Primero creamos un objeto de conexión:
         */
    private static String url = "jdbc:mysql://localhost:3306/java_curso";
    private static String userName = "root";
    private static String password = "yan2412";
    private static Connection conexion;
    //Utilizamos el patron singleton:
    public static Connection getInstance() throws SQLException
    {
        if(conexion == null){
            conexion = DriverManager.getConnection(url,userName,password);
        }
        return conexion;
    }
}
