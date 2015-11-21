/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author p3a_ruk
 */
@Entity
@Table(name = "registers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registers.findAll", query = "SELECT r FROM Registers r"),
    @NamedQuery(name = "Registers.findByRegid", query = "SELECT r FROM Registers r WHERE r.regid = :regid"),
    @NamedQuery(name = "Registers.findByCredittotal", query = "SELECT r FROM Registers r WHERE r.credittotal = :credittotal")})
public class Registers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Reg_id")
    private Integer regid;
    @Column(name = "Credit_total")
    private Integer credittotal;
    @JoinColumn(name = "Off_id", referencedColumnName = "Off_id")
    @ManyToOne
    private Officer offid;
    @JoinColumn(name = "Std_id", referencedColumnName = "Std_id")
    @ManyToOne
    private Student stdid;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "registers")
    private RegisterDetails registerDetails;

    public Registers() {
    }

    public Registers(Integer regid) {
        this.regid = regid;
    }

    public Integer getRegid() {
        return regid;
    }

    public void setRegid(Integer regid) {
        this.regid = regid;
    }

    public Integer getCredittotal() {
        return credittotal;
    }

    public void setCredittotal(Integer credittotal) {
        this.credittotal = credittotal;
    }

    public Officer getOffid() {
        return offid;
    }

    public void setOffid(Officer offid) {
        this.offid = offid;
    }

    public Student getStdid() {
        return stdid;
    }

    public void setStdid(Student stdid) {
        this.stdid = stdid;
    }

    public RegisterDetails getRegisterDetails() {
        return registerDetails;
    }

    public void setRegisterDetails(RegisterDetails registerDetails) {
        this.registerDetails = registerDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regid != null ? regid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registers)) {
            return false;
        }
        Registers other = (Registers) object;
        if ((this.regid == null && other.regid != null) || (this.regid != null && !this.regid.equals(other.regid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Registers[ regid=" + regid + " ]";
    }
    
}
