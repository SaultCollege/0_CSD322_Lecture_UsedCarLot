/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfacades;

import java.util.List;
import org.csd322.sessionbeans.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.csd322.entities.Car;

/**
 *
 * @author fred
 */
@Stateless
public class MyCarFacade extends AbstractFacade<Car> {

    @PersistenceContext(unitName = "ca.saultcollege_0_UsedCarLot_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyCarFacade() {
        super(Car.class);
    }

    public List<Car> findByMake(String make) {
        TypedQuery<Car> query
                = em.createNamedQuery("Car.findByMake", Car.class).setParameter("make", make);
        List<Car> results = query.getResultList();
        return results;
    }

}
