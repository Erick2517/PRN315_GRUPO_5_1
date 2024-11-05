/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.OportunidadVolun;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Personal
 */
@Stateless
public class OportunidadVolunFacade extends AbstractFacade<OportunidadVolun> implements OportunidadVolunFacadeLocal {

    @PersistenceContext(unitName = "PRN315_GRUPO_5_1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OportunidadVolunFacade() {
        super(OportunidadVolun.class);
    }
    
}
