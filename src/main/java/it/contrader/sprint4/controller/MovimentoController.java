package it.contrader.sprint4.controller;

import it.contrader.sprint4.GenericResponse;
import it.contrader.sprint4.converter.MovimentoConverter;
import it.contrader.sprint4.converter.UserConverter;
import it.contrader.sprint4.dto.MovimentoDTO;
import it.contrader.sprint4.dto.UserDTO;
import it.contrader.sprint4.model.Movimento;
import it.contrader.sprint4.model.User;
import it.contrader.sprint4.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value="*")
@RestController
@RequestMapping("/movimento")
public class MovimentoController {

    private MovimentoService movimentoService;
    private MovimentoConverter movimentoConverter;
    private UserConverter userConverter;



    @Autowired
    public MovimentoController(MovimentoService movimentoService, MovimentoConverter movimentoConverter, UserConverter userConverter)
    {
        this.movimentoService = movimentoService;
        this.movimentoConverter = movimentoConverter;
        this.userConverter=userConverter;
    }

    @RequestMapping(value="/getMovimento", method = RequestMethod.POST)
    public GenericResponse<List<MovimentoDTO>> getMovimenti(@RequestBody UserDTO userDTO) {
        List<MovimentoDTO> movimenti = new ArrayList<>();
        User user=userConverter.convertToEntity(userDTO);
        String username=user.getUsername();
        List<Movimento> mov= movimentoService.findByUsername(username);
        for (Movimento movimento: mov)
        {
            movimenti.add(movimentoConverter.convertToDTO(movimento));
        }

        if (movimenti.size() == 0) {return  new GenericResponse<>(1,null);}//*lista movimenti vuota
        else{ return new GenericResponse<>(0,movimenti);}//*lista movimenti
    }
}