/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.servicio;

import ec.com.catalogo.modelo.Base;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diego
 */
@Stateless
public class BaseFacade extends AbstractFacade<Base> implements BaseFacadeLocal {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BaseFacade() {
        super(Base.class);
    }
    
}
