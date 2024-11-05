/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.OportunidadVolun;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Personal
 */
@Local
public interface OportunidadVolunFacadeLocal {

    void create(OportunidadVolun oportunidadVolun);

    void edit(OportunidadVolun oportunidadVolun);

    void remove(OportunidadVolun oportunidadVolun);

    OportunidadVolun find(Object id);

    List<OportunidadVolun> findAll();

    List<OportunidadVolun> findRange(int[] range);

    int count();
    
}
