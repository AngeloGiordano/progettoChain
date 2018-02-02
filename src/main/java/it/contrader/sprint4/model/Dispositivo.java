package it.contrader.sprint4.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="dispositivo")
public class Dispositivo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long idDispositivo;
    @Column

    private String nomeDispositivo;
    @Column

    private String cpu;

    @Column

    private double frequenza;
    @Column

    private double ram;
    @Column

    private double hardDisk;
    @Column

    private String stato;
    @Column
    private String username;


    public Dispositivo(){ }


    public Dispositivo(String nomeDispositivo, String cpu, double frequenza, double ram, double hardDisk, String stato, String username){
        this.nomeDispositivo=nomeDispositivo;
        this.cpu=cpu;
        this.frequenza=frequenza;
        this.ram=ram;
        this.hardDisk=hardDisk;
        this.stato=stato;
        this.username=username;
    }

    public long getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(long idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getNomeDispositivo() {
        return nomeDispositivo;
    }

    public void setNomeDispositivo(String nomeDispositivo) {
        this.nomeDispositivo = nomeDispositivo;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public double getFrequenza() {
        return frequenza;
    }

    public void setFrequenza(double frequenza) {
        this.frequenza = frequenza;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public double getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(double hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dispositivo that = (Dispositivo) o;
        return idDispositivo == that.idDispositivo &&
                Double.compare(that.frequenza, frequenza) == 0 &&
                Double.compare(that.ram, ram) == 0 &&
                Double.compare(that.hardDisk, hardDisk) == 0 &&
                Objects.equals(nomeDispositivo, that.nomeDispositivo) &&
                Objects.equals(cpu, that.cpu) &&
                Objects.equals(stato, that.stato) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDispositivo, nomeDispositivo, cpu, frequenza, ram, hardDisk, stato, username);
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "nomeDispositivo='" + nomeDispositivo+ '\'' +
                ", Frequenza='" + frequenza + '\'' +
                ", CPU='" + cpu + '\'' +
                ", RAM='" + ram + '\'' +
                ", HardDisk='" + hardDisk + '\'' +
                ", Stato='" + stato + '\'' +
                ", Username='"+ username+'\''+
                '}';
    }


}