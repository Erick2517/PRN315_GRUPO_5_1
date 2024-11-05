/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Habilidades;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Personal
 */
@Local
public interface HabilidadesFacadeLocal {

    void create(Habilidades habilidades);

    void edit(Habilidades habilidades);

    void remove(Habilidades habilidades);

    Habilidades find(Object id);

    List<Habilidades> findAll();

    List<Habilidades> findRange(int[] range);

    int count();
    
}
