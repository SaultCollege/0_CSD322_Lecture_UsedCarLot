/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycontrollers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import org.csd322.entities.Person;
import org.csd322.sessionbeans.PersonFacade;

/**
 *
 * @author fred
 */
@Named(value = "myPersonController")
@SessionScoped
public class MyPersonController implements Serializable {
    Person current;
    @EJB
    private PersonFacade facade;
    
    /**
     * Creates a new instance of MyPersonController
     */
    public MyPersonController() {
    }
    
}
