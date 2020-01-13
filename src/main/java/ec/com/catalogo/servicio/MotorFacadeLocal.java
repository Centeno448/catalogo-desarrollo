/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.servicio;

import ec.com.catalogo.modelo.Motor;
import java.util.List;
import javax.ejb.Local;


@Local
public interface MotorFacadeLocal {

    void create(Motor motor);

    void edit(Motor motor);

    void remove(Motor motor);

    Motor find(Object id);

    List<Motor> findAll();

    List<Motor> findRange(int[] range);

    int count();
    
}
