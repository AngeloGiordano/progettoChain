package it.contrader.sprint4.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    private String username;
    @Column
    private String password ;
    @Column
    private String nomeUser ;
    @Column
    private String cognomeUser;
    @Column
    private String dataDiNascita;
    @Column
    private String indirizzo ;
    @Column
    private String citta;
    @Column
    private String provincia ;
    @Column
    private String cap ;
    @Column
    private String email;
    @Column
    private String telefono ;
    @Column
    private  String ruolo ;
    @Column
    private  String stato ;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Column
    private Date dataIscrizione ;

    public User(){}

    public User(String username, String password, String nomeUser, String cognomeUser, String dataDiNascita, String indirizzo, String citta, String provincia, String cap, String email, String telefono, String ruolo, String stato, Date dataIscrizione) {
        this.username = username;
        this.password = password;
        this.nomeUser = nomeUser;
        this.cognomeUser = cognomeUser;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.citta= citta;
        this.provincia = provincia;
        this.cap = cap;
        this.email=email;
        this.telefono=telefono;
        this.ruolo =ruolo;
        this.stato =stato;
        this.dataIscrizione =dataIscrizione;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getCognomeUser() {
        return cognomeUser;
    }

    public void setCognomeUser(String cognomeUser) {
        this.cognomeUser = cognomeUser;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getStato() { return stato; }

    public void setStato(String stato) { this.stato = stato; }

    public Date getDataIscrizione() { return dataIscrizione; }

    public void setDataIscrizione(Date dataIscrizione) { this.dataIscrizione = dataIscrizione; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(nomeUser, user.nomeUser) &&
                Objects.equals(cognomeUser, user.cognomeUser) &&
                Objects.equals(dataDiNascita, user.dataDiNascita) &&
                Objects.equals(indirizzo, user.indirizzo) &&
                Objects.equals(citta, user.citta) &&
                Objects.equals(provincia, user.provincia) &&
                Objects.equals(cap, user.cap) &&
                Objects.equals(email, user.email) &&
                Objects.equals(telefono, user.telefono) &&
                Objects.equals(ruolo, user.ruolo) &&
                Objects.equals(stato, user.stato) &&
                Objects.equals(dataIscrizione, user.dataIscrizione);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password, nomeUser, cognomeUser, dataDiNascita, indirizzo, citta, provincia, cap, email, telefono, ruolo, stato, dataIscrizione);
    }

    @Override
    public String toString() {
        return "User: " + "\n username: " + username + "\n password: " + password + "\n Nome: " + nomeUser + "\n Cognome: " + cognomeUser + "\n Data di nascita: " + dataDiNascita + "\n Indirizzo: " + indirizzo + "\n Citta: " + citta + "\n Provincia: " + provincia + "\n CAP: " + cap + "\n Email: " + email + "\n Telefono: " + telefono + "\n  Ruolo: " + ruolo+ "\n  Stato: " + stato + "\n DataIscrizione: " +dataIscrizione;
    }


}
