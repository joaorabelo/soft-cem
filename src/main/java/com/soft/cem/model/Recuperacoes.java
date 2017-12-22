/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soft.cem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoãoRabelo
 */
@Entity
@Table(name = "recuperacoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recuperacoes.findAll", query = "SELECT r FROM Recuperacoes r")
    , @NamedQuery(name = "Recuperacoes.findByIdRec", query = "SELECT r FROM Recuperacoes r WHERE r.idRec = :idRec")
    , @NamedQuery(name = "Recuperacoes.findByRecSem", query = "SELECT r FROM Recuperacoes r WHERE r.recSem = :recSem")
    , @NamedQuery(name = "Recuperacoes.findByRecSem2", query = "SELECT r FROM Recuperacoes r WHERE r.recSem2 = :recSem2")
    , @NamedQuery(name = "Recuperacoes.findByRecFim", query = "SELECT r FROM Recuperacoes r WHERE r.recFim = :recFim")
    , @NamedQuery(name = "Recuperacoes.findByAnoRec", query = "SELECT r FROM Recuperacoes r WHERE r.anoRec = :anoRec")})
public class Recuperacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rec")
    private Integer idRec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rec_sem")
    private BigDecimal recSem;
    @Column(name = "rec_sem2")
    private BigDecimal recSem2;
    @Column(name = "rec_fim")
    private BigDecimal recFim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano_rec")
    private int anoRec;
    @JoinColumn(name = "mat_alu", referencedColumnName = "mat_alu")
    @ManyToOne(optional = false)
    private Alunos matAlu;
    @JoinColumn(name = "id_disc", referencedColumnName = "id_disc")
    @ManyToOne(optional = false)
    private Disciplinas idDisc;
    @JoinColumn(name = "id_tur", referencedColumnName = "id_tur")
    @ManyToOne(optional = false)
    private Turmas idTur;

    public Recuperacoes() {
    }

    public Recuperacoes(Integer idRec) {
        this.idRec = idRec;
    }

    public Recuperacoes(Integer idRec, int anoRec) {
        this.idRec = idRec;
        this.anoRec = anoRec;
    }

    public Integer getIdRec() {
        return idRec;
    }

    public void setIdRec(Integer idRec) {
        this.idRec = idRec;
    }

    public BigDecimal getRecSem() {
        return recSem;
    }

    public void setRecSem(BigDecimal recSem) {
        this.recSem = recSem;
    }

    public BigDecimal getRecSem2() {
        return recSem2;
    }

    public void setRecSem2(BigDecimal recSem2) {
        this.recSem2 = recSem2;
    }

    public BigDecimal getRecFim() {
        return recFim;
    }

    public void setRecFim(BigDecimal recFim) {
        this.recFim = recFim;
    }

    public int getAnoRec() {
        return anoRec;
    }

    public void setAnoRec(int anoRec) {
        this.anoRec = anoRec;
    }

    public Alunos getMatAlu() {
        return matAlu;
    }

    public void setMatAlu(Alunos matAlu) {
        this.matAlu = matAlu;
    }

    public Disciplinas getIdDisc() {
        return idDisc;
    }

    public void setIdDisc(Disciplinas idDisc) {
        this.idDisc = idDisc;
    }

    public Turmas getIdTur() {
        return idTur;
    }

    public void setIdTur(Turmas idTur) {
        this.idTur = idTur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRec != null ? idRec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recuperacoes)) {
            return false;
        }
        Recuperacoes other = (Recuperacoes) object;
        if ((this.idRec == null && other.idRec != null) || (this.idRec != null && !this.idRec.equals(other.idRec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rabelo.cemsoft.Recuperacoes[ idRec=" + idRec + " ]";
    }
    
}
