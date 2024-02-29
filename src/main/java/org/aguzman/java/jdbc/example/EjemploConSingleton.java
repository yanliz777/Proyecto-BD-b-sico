package org.aguzman.java.jdbc.example;

import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImplementacion;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBD;
import java.sql.*;

public class EjemploConSingleton
{
    public static void main(String[] args) {
        /*
        lo que está dentro de los argumentos del try es para
        crear y cerrar la conexión automáticamente
         */
        try(Connection conexion = ConexionBD.getInstance())
        {
            /*
            Sé instancia un objeto Repositorio para hacer uso del CRUD
            que sé implementa en la clase ProductoRepositorioImplementacion:
             */
            Repositorio<Producto> repositorio = new ProductoRepositorioImplementacion();
            /*
            se llama al método listar que está en la clase ProductoRepositorioImplementacion
            y se le envía el objeto p para que nos imprima el toString de esa clase:
             */
            for (Producto p: repositorio.listar()) {
                System.out.println(p);
            }

            //repositorio.listar().forEach(p -> System.out.println(p));

            /*
            se llama al método porId que está en ProductoRepositorioImplementacion
            y le enviamos el índice del objeto que queremos ver:
             */
            System.out.println(repositorio.porId(1L));
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
