/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.UsuariosHabilidades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Personal
 */
@Local
public interface UsuariosHabilidadesFacadeLocal {

    void create(UsuariosHabilidades usuariosHabilidades);

    void edit(UsuariosHabilidades usuariosHabilidades);

    void remove(UsuariosHabilidades usuariosHabilidades);

    UsuariosHabilidades find(Object id);

    List<UsuariosHabilidades> findAll();

    List<UsuariosHabilidades> findRange(int[] range);

    int count();
    
}
