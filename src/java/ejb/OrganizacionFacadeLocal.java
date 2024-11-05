/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Organizacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Personal
 */
@Local
public interface OrganizacionFacadeLocal {

    void create(Organizacion organizacion);

    void edit(Organizacion organizacion);

    void remove(Organizacion organizacion);

    Organizacion find(Object id);

    List<Organizacion> findAll();

    List<Organizacion> findRange(int[] range);

    int count();
    
}
