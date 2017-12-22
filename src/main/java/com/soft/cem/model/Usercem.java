/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soft.cem.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoãoRabelo
 */
@Entity
@Table(name = "usercem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usercem.findAll", query = "SELECT u FROM Usercem u")
    , @NamedQuery(name = "Usercem.findByUserId", query = "SELECT u FROM Usercem u WHERE u.userId = :userId")
    , @NamedQuery(name = "Usercem.findByUserToken", query = "SELECT u FROM Usercem u WHERE u.userToken = :userToken")
    , @NamedQuery(name = "Usercem.findByUserDtCad", query = "SELECT u FROM Usercem u WHERE u.userDtCad = :userDtCad")
    , @NamedQuery(name = "Usercem.findByUserEmail", query = "SELECT u FROM Usercem u WHERE u.userEmail = :userEmail")
    , @NamedQuery(name = "Usercem.findByUserNom", query = "SELECT u FROM Usercem u WHERE u.userNom = :userNom")
    , @NamedQuery(name = "Usercem.findByUserSen", query = "SELECT u FROM Usercem u WHERE u.userSen = :userSen")})
public class Usercem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Size(max = 200)
    @Column(name = "user_token")
    private String userToken;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_dt_cad")
    @Temporal(TemporalType.DATE)
    private Date userDtCad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_email")
    private String userEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_nom")
    private String userNom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_sen")
    private String userSen;

    public Usercem() {
    }

    public Usercem(Integer userId) {
        this.userId = userId;
    }

    public Usercem(Integer userId, Date userDtCad, String userEmail, String userNom, String userSen) {
        this.userId = userId;
        this.userDtCad = userDtCad;
        this.userEmail = userEmail;
        this.userNom = userNom;
        this.userSen = userSen;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public Date getUserDtCad() {
        return userDtCad;
    }

    public void setUserDtCad(Date userDtCad) {
        this.userDtCad = userDtCad;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNom() {
        return userNom;
    }

    public void setUserNom(String userNom) {
        this.userNom = userNom;
    }

    public String getUserSen() {
        return userSen;
    }

    public void setUserSen(String userSen) {
        this.userSen = userSen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usercem)) {
            return false;
        }
        Usercem other = (Usercem) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rabelo.cemsoft.Usercem[ userId=" + userId + " ]";
    }
    
}
