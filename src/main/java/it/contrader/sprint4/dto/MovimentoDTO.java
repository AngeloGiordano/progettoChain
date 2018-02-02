package it.contrader.sprint4.dto;
import java.util.Date;

public class MovimentoDTO {

    private long id;

    private String  data;

    private String causale;

    private double importo;

    private String mittente;

    private String beneficiario;

    private String valuta;

    private int idDispositivo;

    private String username;

    public MovimentoDTO(long id, String data, String causale, double importo, String mittente, String beneficiario, String valuta, int idDispositivo, String username) {
        this.id = id;
        this.data = data;
        this.causale = causale;
        this.importo = importo;
        this.mittente = mittente;
        this.beneficiario = beneficiario;
        this.valuta = valuta;
        this.idDispositivo=idDispositivo;
        this.username=username;
    }

    public MovimentoDTO(){}

    public long getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCausale() {
        return causale;
    }

    public void setCausale(String causale) {
        this.causale = causale;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public String getMittente() {
        return mittente;
    }

    public void setMittente(String mittente) {
        this.mittente = mittente;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public int getIdDispositivo() { return idDispositivo; }

    public void setIdDispositivo(int idDispositivo) { this.idDispositivo = idDispositivo; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }
}
