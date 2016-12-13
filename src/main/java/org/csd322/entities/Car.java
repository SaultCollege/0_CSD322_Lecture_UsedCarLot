/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.csd322.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fred
 */
@Entity
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id = :id"),
    @NamedQuery(name = "Car.findByMake", query = "SELECT c FROM Car c WHERE c.make = :make"),
    @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model"),
    @NamedQuery(name = "Car.findByYear", query = "SELECT c FROM Car c WHERE c.year = :year"),
    @NamedQuery(name = "Car.findByUsed", query = "SELECT c FROM Car c WHERE c.used = :used"),
    @NamedQuery(name = "Car.findByType", query = "SELECT c FROM Car c WHERE c.type = :type"),
    @NamedQuery(name = "Car.findByBoughtFor", query = "SELECT c FROM Car c WHERE c.boughtFor = :boughtFor"),
    @NamedQuery(name = "Car.findBySoldFor", query = "SELECT c FROM Car c WHERE c.soldFor = :soldFor"),
    @NamedQuery(name = "Car.findBySellingPrice", query = "SELECT c FROM Car c WHERE c.sellingPrice = :sellingPrice"),
    @NamedQuery(name = "Car.findByOdometerKm", query = "SELECT c FROM Car c WHERE c.odometerKm = :odometerKm"),
    @NamedQuery(name = "Car.findByDateReceived", query = "SELECT c FROM Car c WHERE c.dateReceived = :dateReceived"),
    @NamedQuery(name = "Car.findByDateSold", query = "SELECT c FROM Car c WHERE c.dateSold = :dateSold")})
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "make")
    private String make;
    @Size(max = 45)
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Column(name = "used")
    private Boolean used;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "boughtFor")
    private Double boughtFor;
    @Column(name = "soldFor")
    private Double soldFor;
    @Column(name = "sellingPrice")
    private Double sellingPrice;
    @Column(name = "odometerKm")
    private Double odometerKm;
    @Column(name = "dateReceived")
    @Temporal(TemporalType.DATE)
    private Date dateReceived;
    @Column(name = "dateSold")
    @Temporal(TemporalType.DATE)
    private Date dateSold;
    @JoinTable(name = "special_has_car", joinColumns = {
        @JoinColumn(name = "car_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "special_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Special> specialList;
    @JoinColumn(name = "soldTo", referencedColumnName = "id")
    @ManyToOne
    private Person soldTo;

    public Car() {
    }

    public Car(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public byte[] getImage() {
        if(image==null)
            image=new byte[0];
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBoughtFor() {
        return boughtFor;
    }

    public void setBoughtFor(Double boughtFor) {
        this.boughtFor = boughtFor;
    }

    public Double getSoldFor() {
        return soldFor;
    }

    public void setSoldFor(Double soldFor) {
        this.soldFor = soldFor;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getOdometerKm() {
        return odometerKm;
    }

    public void setOdometerKm(Double odometerKm) {
        this.odometerKm = odometerKm;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getDateSold() {
        return dateSold;
    }

    public void setDateSold(Date dateSold) {
        this.dateSold = dateSold;
    }

    @XmlTransient
    public List<Special> getSpecialList() {
        return specialList;
    }

    public void setSpecialList(List<Special> specialList) {
        this.specialList = specialList;
    }

    public Person getSoldTo() {
        return soldTo;
    }

    public void setSoldTo(Person soldTo) {
        this.soldTo = soldTo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.csd322.entities.Car[ id=" + id + " ]";
    }
    
}
