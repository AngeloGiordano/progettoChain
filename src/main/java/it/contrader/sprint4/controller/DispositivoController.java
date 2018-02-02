package it.contrader.sprint4.controller;

import it.contrader.sprint4.GenericResponse;
import it.contrader.sprint4.converter.DispositivoConverter;
import it.contrader.sprint4.converter.UserConverter;
import it.contrader.sprint4.dto.DispositivoDTO;
import it.contrader.sprint4.dto.UserDTO;
import it.contrader.sprint4.model.Dispositivo;
import it.contrader.sprint4.model.User;
import it.contrader.sprint4.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value="*")
@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

    private DispositivoService dispositivoService;
    private DispositivoConverter dispositivoConverter;
    private UserConverter userConverter;



    @Autowired
    public DispositivoController(DispositivoService dispositivoService, DispositivoConverter dispositivoConverter,UserConverter userConverter)
    {
        this.dispositivoService = dispositivoService;
        this.dispositivoConverter = dispositivoConverter;
        this.userConverter=userConverter;
    }

    @RequestMapping(value="/newDispositivo", method = RequestMethod.POST)
    public GenericResponse<DispositivoDTO> insertDisp(@RequestBody DispositivoDTO dispositivoDTO)
    {
        //Dispositivo dispositivo=dispositivoConverter.convertToEntity(dispositivoDTO);
        String username = dispositivoDTO.getUsername();
        String nomeDispositivo = dispositivoDTO.getNomeDispositivo();
        Dispositivo trovato=dispositivoService.findByNomeDispositivoAndUsername(nomeDispositivo,username);
        if (trovato!=null){
            return new GenericResponse<>(0,null); //dispositivo già presente
        }
        else{

            Dispositivo newDispositivo=dispositivoConverter.convertToEntity(dispositivoDTO);
            newDispositivo.setStato("Registrato");
            Dispositivo dispAgg=dispositivoService.insert(newDispositivo);
            DispositivoDTO dispAggDTO=dispositivoConverter.convertToDTO(dispAgg);
            return new GenericResponse<>(1,dispAggDTO); // dispositivo aggiunto
        }

    }

    @RequestMapping(value="/getDispositivo", method = RequestMethod.POST)
    public GenericResponse<List<DispositivoDTO>> getDispositivi (@RequestBody UserDTO userDTO) {
        List<DispositivoDTO> dispositivi = new ArrayList<>();
        User user=userConverter.convertToEntity(userDTO);
        String username=user.getUsername();
        List<Dispositivo> disp= dispositivoService.findByUsername(username);
        for (Dispositivo dispositivo: disp)
        {
            dispositivi.add(dispositivoConverter.convertToDTO(dispositivo));
        }

        if (dispositivi.size() == 0) {return  new GenericResponse<>(1,null);}//*lista dispositivi vuota
        else{ return new GenericResponse<>(0,dispositivi);}//*lista dispositivi
    }

    @RequestMapping(value="/deleteDispositivo",method= RequestMethod.GET)
    public GenericResponse<Boolean> deleteDisp(@RequestParam("nomeDispositivo") String nomeDispositivo, @RequestParam("username") String username){
        Dispositivo trovato=dispositivoService.findByNomeDispositivoAndUsername(nomeDispositivo,username);
        boolean conferma=true;
        if (trovato!=null){
            trovato.setStato("ELIMINATO");
            Dispositivo dispele=dispositivoService.insert(trovato);
            return new GenericResponse<>(0,conferma); // dispositivo eliminato
        }
        else {
            conferma=false;
            return new GenericResponse<>(1,conferma); //dispositivo non eliminato
        }
    }

    @RequestMapping(value="/deactivateDisp",method= RequestMethod.GET)
    public GenericResponse<Boolean> deactivateDisp(@RequestParam("nomeDispositivo") String nomeDispositivo, @RequestParam("username") String username){
        Dispositivo found=dispositivoService.findByNomeDispositivoAndUsername(nomeDispositivo,username);
        boolean confirm=true;
        if (found!=null){
            found.setStato("DISATTIVATO");
            Dispositivo dispdeact=dispositivoService.insert(found);
            return new GenericResponse<>(0,confirm); // dispositivo disattivato
        }
        else {
            confirm=false;
            return new GenericResponse<>(1,confirm); //dispositivo non disattivato (attivo)
        }
    }
}