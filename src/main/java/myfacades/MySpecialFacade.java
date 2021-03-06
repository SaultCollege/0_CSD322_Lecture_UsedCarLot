/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfacades;

import java.util.List;
import org.csd322.sessionbeans.*;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.csd322.entities.Car;
import org.csd322.entities.Special;

/**
 *
 * @author fred
 */
@Stateless
public class MySpecialFacade extends AbstractFacade<Special> {

    @PersistenceContext(unitName = "ca.saultcollege_0_UsedCarLot_war_1.0PU")
    private EntityManager em;
    @Inject MyCarFacade carFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MySpecialFacade() {
        super(Special.class);
    }
    
    public List<Special> findSpecialsForCar(Car c){
        Car car = carFacade.find(c.getId());
        return car.getSpecialList();
    }
}
