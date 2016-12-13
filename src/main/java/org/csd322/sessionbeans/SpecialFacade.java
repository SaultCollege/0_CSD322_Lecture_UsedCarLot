/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.csd322.sessionbeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.csd322.entities.Special;

/**
 *
 * @author fred
 */
@Stateless
public class SpecialFacade extends AbstractFacade<Special> {

    @PersistenceContext(unitName = "ca.saultcollege_0_UsedCarLot_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SpecialFacade() {
        super(Special.class);
    }
    
}
