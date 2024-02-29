package org.aguzman.java.jdbc.example;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        /*
        Primero creamos un objeto de conexión:
         */
        String url = "jdbc:mysql://localhost:3306/java_curso";
        String userName = "root";
        String password = "yan2412";
        Connection conexion = null;
        Statement stmt = null;
        ResultSet resultado = null;
        try
        {
            //creamos la conexión a la BD:
            conexion = DriverManager.getConnection(url,userName,password);
            stmt = conexion.createStatement();
            //realizamos consulta:
            resultado = stmt.executeQuery("SELECT * FROM productos");

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
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally {
            /**
             * cerramos las conexiones en este finally porque
             * en caso de haber una excepción no quede ninguna conexión abierta y pase
             * a este sector del código para cerrar las conexiones
             */
            try {
                resultado.close();
                stmt.close();
                conexion.close();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}