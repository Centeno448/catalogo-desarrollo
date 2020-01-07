/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.servicio;

import ec.com.catalogo.modelo.Base;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface BaseFacadeLocal {

    void create(Base base);

    void edit(Base base);

    void remove(Base base);

    Base find(Object id);

    List<Base> findAll();

    List<Base> findRange(int[] range);

    int count();
    
}
