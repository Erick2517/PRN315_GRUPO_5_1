/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.OportunidadHabilidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Personal
 */
@Stateless
public class OportunidadHabilidadFacade extends AbstractFacade<OportunidadHabilidad> implements OportunidadHabilidadFacadeLocal {

    @PersistenceContext(unitName = "PRN315_GRUPO_5_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OportunidadHabilidadFacade() {
        super(OportunidadHabilidad.class);
    }
    
}