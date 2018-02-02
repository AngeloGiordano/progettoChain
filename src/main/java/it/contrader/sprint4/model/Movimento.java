package it.contrader.sprint4.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="movimento")
public class Movimento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    @Column

    private String data;

    @Column

    private String causale;

    @Column

    private double importo;

    @Column

    private String mittente;

    @Column

    private String beneficiario;

    @Column

    private String valuta;

    @Column

    private int idDispositivo;

    @Column

    private String username;

    public Movimento(){}

    public Movimento(String data, String causale, double importo, String mittente, String beneficiario, String valuta, int idDispositivo, String username){
        this.data=data;
        this.causale=causale;
        this.importo=importo;
        this.mittente=mittente;
        this.beneficiario=beneficiario;
        this.valuta=valuta;
        this.idDispositivo=idDispositivo;
        this.username=username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimento movimento = (Movimento) o;
        return id == movimento.id &&
                Double.compare(movimento.importo, importo) == 0 &&
                Objects.equals(data, movimento.data) &&
                Objects.equals(causale, movimento.causale) &&
                Objects.equals(mittente, movimento.mittente) &&
                Objects.equals(beneficiario, movimento.beneficiario) &&
                Objects.equals(valuta, movimento.valuta)&&
                Objects.equals(idDispositivo, movimento.idDispositivo)&&
                Objects.equals(username, movimento.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, data, causale, importo, mittente, beneficiario, valuta, idDispositivo, username);
    }

    @Override
    public String toString() {
        return "Movimento{" +
                "Data='" + data+ '\'' +
                ", Causale='" + causale + '\'' +
                ", Importo='" + importo+ '\'' +
                ", Mittente='" + mittente + '\'' +
                ", Beneficiario='" + beneficiario + '\'' +
                ", Valuta='"+ valuta+'\''+
                ", IdDispositivo='"+ idDispositivo+'\''+
                ", Username='"+ username+'\''+
                '}';
    }
}
