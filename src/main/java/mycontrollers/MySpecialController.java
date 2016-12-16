/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycontrollers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import myfacades.MySpecialFacade;
import org.csd322.entities.Car;
import org.csd322.entities.Special;

/**
 *
 * @author fred
 */
@Named(value = "mySpecialController")
@SessionScoped
public class MySpecialController implements Serializable {

    @EJB
    MySpecialFacade facade;
    
    private Special current;
    private Car currentCar;
    
    public MySpecialController() {
    }
        public String edit(Special special) {
        setCurrent(special);
        return "Edit";
    }

    public String create() {
        Special c = new Special();
        facade.create(c);
        return edit(c);
    }

    public String update() {
        facade.edit(getCurrent());
        return "Main";
    }

    public String delete(Special special) {
        facade.remove(special);
        return "Main";
    }


    public List<Special> getSpecials(){
        return facade.findAll();
    }
    public List<Special> getSpecialsForSpecial(Car c){
        return facade.findSpecialsForCar(c);
    }

    /**
     * @return the current
     */
    public Special getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(Special current) {
        this.current = current;
    }

    /**
     * @return the currentCar
     */
    public Car getCurrentCar() {
        return currentCar;
    }

    /**
     * @param currentCar the currentCar to set
     */
    public void setCurrentCar(Car currentCar) {
        this.currentCar = currentCar;
    }
}
