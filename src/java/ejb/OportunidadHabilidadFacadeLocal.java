/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.OportunidadHabilidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Personal
 */
@Local
public interface OportunidadHabilidadFacadeLocal {

    void create(OportunidadHabilidad oportunidadHabilidad);

    void edit(OportunidadHabilidad oportunidadHabilidad);

    void remove(OportunidadHabilidad oportunidadHabilidad);

    OportunidadHabilidad find(Object id);

    List<OportunidadHabilidad> findAll();

    List<OportunidadHabilidad> findRange(int[] range);

    int count();
    
}
