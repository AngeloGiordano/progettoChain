package it.contrader.sprint4.dto;

public class DispositivoDTO {



    private String nomeDispositivo;
    private String cpu;
    private double frequenza;
    private double ram;
    private double hardDisk;
    private String stato;
    private String username;

    public DispositivoDTO(){}

    public DispositivoDTO(String nomeDispositivo, String cpu, double ram, double hardDisk, String stato, String username) {
        this.nomeDispositivo = nomeDispositivo;
        this.cpu = cpu;
        this.frequenza = frequenza;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.stato = stato;
        this.username=username;
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

    public double getFrequenza() { return frequenza; }

    public void setFrequenza(double frequenza) { this.frequenza = frequenza; }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

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
}