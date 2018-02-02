package it.contrader.sprint4.dto;

import java.util.Date;

public class UserDTO {


    private String username;
    private String password ;
    private String nomeUser ;
    private String cognomeUser;
    private String dataDiNascita;
    private String indirizzo ;
    private String citta;
    private String provincia ;
    private String cap ;
    private String email;
    private String telefono ;
    private String ruolo ;
    private String stato ;
    private Date dataIscrizione;

    public UserDTO(){}

    public UserDTO(String username, String password, String nomeUser, String cognomeUser, String dataDiNascita, String indirizzo, String citta, String provincia, String cap, String email, String telefono, String ruolo, String stato, Date dataIscrizione) {
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
        this.dataIscrizione = dataIscrizione;

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

    public void setRuolo(String ruolo) { this.ruolo = ruolo; }

    public String getStato() { return stato; }

    public void setStato(String stato) { this.stato = stato; }

    public Date getDataIscrizione() { return dataIscrizione; }

    public void setDataIscrizione(Date dataIscrizione) { this.dataIscrizione = dataIscrizione; }
}
