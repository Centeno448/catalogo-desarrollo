/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.servicio;

import ec.com.catalogo.modelo.Motor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author diego
 */
@Stateless
public class MotorFacade extends AbstractFacade<Motor> implements MotorFacadeLocal {

    @PersistenceContext(unitName = "catalogoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MotorFacade() {
        super(Motor.class);
    }
    
}
