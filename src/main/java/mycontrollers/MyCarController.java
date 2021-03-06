/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycontrollers;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.servlet.http.Part;
import myfacades.MyCarFacade;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.csd322.entities.Car;
import org.csd322.sessionbeans.CarFacade;

/**
 *
 * @author fred
 */
@Named(value = "myCarController")
@SessionScoped
public class MyCarController implements Serializable {

    @EJB
    private CarFacade facade;
    @EJB
    private MyCarFacade myFacade;

    private Car current;
    private Filter filter;
    private Part file;
    private String filename;
    private String extension;
    private String namedQuery;
    private Integer year;
    // See https://www.mkyong.com/jsf2/jsf-2-dropdown-box-example/
    private static Map<String, Object> types;

    static {
        types = new LinkedHashMap<>();
        types.put("Sedan", "Sedan"); //label, value
        types.put("Coupe", "Coupe");
        types.put("Cargo Van", "Cargo Van");
        types.put("Hatchback", "Hatchback");
        types.put("Passenger Van", "Passenger Van");
        types.put("Pickup", "Pickup");
        types.put("SUV", "SUV");
    }

    public Map getTypes() {
        return types;
    }

    /**
     * Creates a new instance of MyCarController
     */
    public MyCarController() {
    }

    public void setQuery() {

    }

    public String getAudioFile() {
        return "<audio src='mi.mp3' controls=''/>";//    autoplay='off'/>";
    }

    public String submit() {
//        setCurrent(new Car());
//        getFacade().create(getCurrent());

        final String fileName = getFile().getName();
        InputStream filecontent;
        byte[] bytes = null;
        try {
            filecontent = getFile().getInputStream();
            int read = 0;

            // IOUtils.toByteArray(filecontent); // Apache commons IO.
            getCurrent().setImage(IOUtils.toByteArray(filecontent));

            //while ((read = filecontent.read(current.getImage())) != -1) {
//            }
            getFacade().edit(getCurrent());
        } catch (IOException ex) {
            Logger.getLogger(MyCarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setFilename(FilenameUtils.getBaseName(getFile().getSubmittedFileName()));
        setExtension(FilenameUtils.getExtension(getFile().getSubmittedFileName()));
        return "jsfUpload";
    }

    public byte[] getBytes() {
        byte[] b = new byte[0];
        if (getCurrent() != null) {
            Car i = facade.find(getCurrent().getId());
            byte[] img = i.getImage();
            if (img == null) {
                return b;
            }
            return img;
        } else {
            return b;
        }
    }

    public List<Car> getCars() {
        if (getNamedQuery() != null && getNamedQuery().equals("Car.findByMake")) {
            return myFacade.findByMake(filter.getMake());
        }
        if (getNamedQuery() != null && getNamedQuery().equals("Car.findByModel")) {
            return myFacade.findByModel(filter.getModel());
        }
        if (getNamedQuery() != null && getNamedQuery().equals("Car.findByYear")) {
            return myFacade.findByYear(filter.getYear());
        }
        if (getNamedQuery() != null && getNamedQuery().equals("Car.findByMileage")) {
            return myFacade.findByMileage(filter.getMileageFrom(), filter.getMileageTo());
        }
        if (getNamedQuery() != null && getNamedQuery().equals("Car.findBySellingPrice")) {
            return myFacade.findBySellingPrice(filter.getSellingPriceFrom(), filter.getSellingPriceTo());
        }

        List<Car> list = null;
        list = getFacade().findAll();
        return list;
    }

    public String edit(Car car) {
        setCurrent(car);
        return "Edit";
    }

    public String create() {
        Car c = new Car();
        facade.create(c);
        return edit(c);
    }

    public String update() {
        getFacade().edit(getCurrent());
        return "Main";
    }

    public String delete(Car car) {
        getFacade().remove(car);
        return "Main";
    }

    /**
     * @return the facade
     */
    public CarFacade getFacade() {
        return facade;
    }

    /**
     * @param facade the facade to set
     */
    public void setFacade(CarFacade facade) {
        this.facade = facade;
    }

    /**
     * @return the current
     */
    public Car getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(Car current) {
        this.current = current;
    }

    /**
     * @return the file
     */
    public Part getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(Part file) {
        this.file = file;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * @return the namedQuery
     */
    public String getNamedQuery() {
        return namedQuery;
    }

    /**
     * @param namedQuery the namedQuery to set
     */
    public void setNamedQuery(String namedQuery) {
        if (namedQuery.isEmpty()) {
            filter = new Filter();
        }
        this.namedQuery = namedQuery;
    }

    /**
     * @return the filter
     */
    public Filter getFilter() {
        if (filter == null) {
            filter = new Filter();
        }
        return filter;
    }

    /**
     * @param filter the filter to set
     */
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    /**
     * @return the year
     */
    public Integer getYear() {
        Date yr = current.getYear();
        if (yr == null) {
            return null;
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(yr);
        year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(Integer year) {
        this.year = year;
        Date yr = current.getYear();
        if (yr == null) {
            yr = new Date();
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(yr);
        calendar.set(Calendar.YEAR, year);
        current.setYear(calendar.getTime());
//        yr.setYear(year);
    }
    /*
        Date yr = current.getYear();
        if(yr==null)
            yr=new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(yr);
        calendar.set(Calendar.YEAR, year);
        yr.setYear(year);
     */

}
