package org.aguzman.java.jdbc.repositorio;

import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
Implementación de la interfase generica<T> Repositorio
con el objeto Producto para realizar CRUD implementando
los métodos de esta interfase;
 */
public class ProductoRepositorioImplementacion implements Repositorio<Producto>
{
    /*
    Método para obtener/retornar la conexión a la BD:
     */
    private Connection getConnection() throws SQLException
    {
        return ConexionBD.getInstance();
    }

    //Listamos Productos:
    @Override
    public List<Producto> listar()
    {
        List<Producto> listaProductos = new ArrayList<>();

        try(Statement stmt = getConnection().createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM productos"))//con Resulset ejecutamos
        // la consulta y traemos los datos
        {
            while (resultado.next())
            {
                Producto p = crearProducto(resultado);//le enviamos los datos de la ejecución de la consulta
                listaProductos.add(p);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProductos;
    }

    /*
    Método para traer un registro de la tabla en la BD
    por medio del ID/llave primaria:
     */

    @Override
    public Producto porId(long id)
    {
        Producto producto = null;

        try(    PreparedStatement stmt = getConnection().
                prepareStatement("SELECT * FROM productos WHERE id = ?"))
        {
            //indicamos donde se encuentra la llave primaria enviándole el índice y el valor:
            stmt.setLong(1,id);
            ResultSet resultado = stmt.executeQuery();//Para ejecuta la consulta

            if(resultado.next()){
                producto = crearProducto(resultado);
            }
            resultado.close();//cerramos la ejecución de la consulta
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(long id) {

    }

    /**
     *Método que crea un objeto producto. Recibe por parámetros un objeto
     * Resulset que viene con los datos de la consulta y se los setiamos
     * al objeto producto.
     */
    private static Producto crearProducto(ResultSet resultado) throws SQLException {
        Producto p = new Producto();
        p.setId(resultado.getLong("id"));
        p.setNombre(resultado.getString("nombre"));
        p.setPrecio(resultado.getInt("precio"));
        p.setFechaRegistro(resultado.getDate("fecha_registro"));
        return p;
    }
}
