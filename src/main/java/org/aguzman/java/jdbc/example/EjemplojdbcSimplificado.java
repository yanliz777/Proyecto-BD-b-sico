package org.aguzman.java.jdbc.example;

import java.sql.*;

public class EjemplojdbcSimplificado {
    public static void main(String[] args) {
         /*
        Primero creamos un objeto de conexión:
         */
        String url = "jdbc:mysql://localhost:3306/java_curso";
        String userName = "root";
        String password = "yan2412";
        /*
        De esta forma no hay necesidad de cerrar las conexiones y
        por ende queda el código más simple
         */
        try(Connection conexion = DriverManager.getConnection(url,userName,password);
            Statement stmt = conexion.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");)
        {
            while (resultado.next())
            {
                //De esta manera obtenemos los valores de nuestra tabla en la BD:
                System.out.print(resultado.getInt("id"));
                System.out.print(" | ");
                System.out.print(resultado.getString("nombre"));
                System.out.print(" | ");
                System.out.print(resultado.getInt("precio"));
                System.out.print(" | ");
                System.out.print(resultado.getDate("fecha_registro"));
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}