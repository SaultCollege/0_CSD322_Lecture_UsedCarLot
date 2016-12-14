/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfacades;

import java.util.List;
import org.csd322.sessionbeans.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public List<Car> findByModel(String model) {
        TypedQuery<Car> query
                = em.createNamedQuery("Car.findByModel", Car.class).setParameter("model", model);
        List<Car> results = query.getResultList();
        return results;
    }

    public List<Car> findByYear(int year) {
        Query query = em.createQuery("Select e " + "from Car e " + "where e.year LIKE '"+year+"%'");

        List<Car> results = query.getResultList();
        return results;
    }
    public List<Car> findByMileage(int from, int to) {
        Query query = em.createQuery("Select e " + "from Car e " + "where e.odometerKm " + "Between "+from+" and "+to);
     
        List<Car> results = query.getResultList();
        return results;
    }
    public List<Car> findBySellingPrice(int from, int to) {
        Query query = em.createQuery("Select e " + "from Car e " + "where e.selllingPrice " + "Between "+from+" and "+to);
     
        List<Car> results = query.getResultList();
        return results;
    }

}
