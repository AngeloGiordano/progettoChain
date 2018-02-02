package it.contrader.sprint4.converter;


import it.contrader.sprint4.dto.DispositivoDTO;
import it.contrader.sprint4.model.Dispositivo;
import org.springframework.stereotype.Component;

@Component
public class DispositivoConverter implements Converter<Dispositivo, DispositivoDTO>{

    @Override
    public Dispositivo convertToEntity(DispositivoDTO dispositivoDTO) {

        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setNomeDispositivo(dispositivoDTO.getNomeDispositivo());
        dispositivo.setCpu(dispositivoDTO.getCpu());
        dispositivo.setFrequenza(dispositivoDTO.getFrequenza());
        dispositivo.setRam(dispositivoDTO.getRam());
        dispositivo.setHardDisk(dispositivoDTO.getHardDisk());
        dispositivo.setStato(dispositivoDTO.getStato()); // registrato-disattivato-attivo
        dispositivo.setUsername(dispositivoDTO.getUsername());
        return dispositivo;
    }


    @Override
    public DispositivoDTO convertToDTO(Dispositivo dispositivo) {
        return new DispositivoDTO(dispositivo.getNomeDispositivo(), dispositivo.getCpu(), dispositivo.getFrequenza(),dispositivo.getRam(),
                dispositivo.getHardDisk(),dispositivo.getStato(),dispositivo.getUsername());
    }
}
