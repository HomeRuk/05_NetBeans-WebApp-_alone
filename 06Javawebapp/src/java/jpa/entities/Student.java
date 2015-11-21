/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author p3a_ruk
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStdid", query = "SELECT s FROM Student s WHERE s.stdid = :stdid"),
    @NamedQuery(name = "Student.findByStdpass", query = "SELECT s FROM Student s WHERE s.stdpass = :stdpass"),
    @NamedQuery(name = "Student.findByStdage", query = "SELECT s FROM Student s WHERE s.stdage = :stdage"),
    @NamedQuery(name = "Student.findByStdaddress", query = "SELECT s FROM Student s WHERE s.stdaddress = :stdaddress")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Std_id")
    private Integer stdid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Std_pass")
    private String stdpass;
    @Size(max = 40)
    @Column(name = "Std_age")
    private String stdage;
    @Size(max = 200)
    @Column(name = "Std_address")
    private String stdaddress;
    @OneToMany(mappedBy = "stdid")
    private Collection<Registers> registersCollection;

    public Student() {
    }

    public Student(Integer stdid) {
        this.stdid = stdid;
    }

    public Student(Integer stdid, String stdpass) {
        this.stdid = stdid;
        this.stdpass = stdpass;
    }

    public Integer getStdid() {
        return stdid;
    }

    public void setStdid(Integer stdid) {
        this.stdid = stdid;
    }

    public String getStdpass() {
        return stdpass;
    }

    public void setStdpass(String stdpass) {
        this.stdpass = stdpass;
    }

    public String getStdage() {
        return stdage;
    }

    public void setStdage(String stdage) {
        this.stdage = stdage;
    }

    public String getStdaddress() {
        return stdaddress;
    }

    public void setStdaddress(String stdaddress) {
        this.stdaddress = stdaddress;
    }

    @XmlTransient
    public Collection<Registers> getRegistersCollection() {
        return registersCollection;
    }

    public void setRegistersCollection(Collection<Registers> registersCollection) {
        this.registersCollection = registersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdid != null ? stdid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.stdid == null && other.stdid != null) || (this.stdid != null && !this.stdid.equals(other.stdid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Student[ stdid=" + stdid + " ]";
    }
    
}
