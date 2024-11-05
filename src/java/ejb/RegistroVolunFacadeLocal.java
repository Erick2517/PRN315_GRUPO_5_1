/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.RegistroVolun;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Personal
 */
@Local
public interface RegistroVolunFacadeLocal {

    void create(RegistroVolun registroVolun);

    void edit(RegistroVolun registroVolun);

    void remove(RegistroVolun registroVolun);

    RegistroVolun find(Object id);

    List<RegistroVolun> findAll();

    List<RegistroVolun> findRange(int[] range);

    int count();
    
}
