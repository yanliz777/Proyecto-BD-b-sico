package org.aguzman.java.jdbc.repositorio;

import java.util.List;
/*
Inteface generica para hacer CRUDS de
cualquier objeto:
 */
public interface Repositorio<T> {
    List<T> listar();

    T porId(long id);

    void guardar(T t);

    void eliminar(long id);
}
