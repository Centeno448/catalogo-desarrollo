/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.servicio;

import ec.com.catalogo.modelo.Instancia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author diego
 */
@Local
public interface InstanciaFacadeLocal {

    void create(Instancia instancia);

    void edit(Instancia instancia);

    void remove(Instancia instancia);

    Instancia find(Object id);

    List<Instancia> findAll();

    List<Instancia> findRange(int[] range);

    int count();
    
}
