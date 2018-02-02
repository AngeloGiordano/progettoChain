package it.contrader.sprint4.controller;

import it.contrader.sprint4.GenericResponse;
import it.contrader.sprint4.converter.UserConverter;
import it.contrader.sprint4.dto.UserDTO;
import it.contrader.sprint4.model.User;
import it.contrader.sprint4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value="*")
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserConverter userConverter;

    @Autowired
    public UserController(UserService userService, UserConverter userConverter)
    {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @RequestMapping(value="/getUsers", method = RequestMethod.GET)
    public GenericResponse<List<UserDTO>> users () {
        List<UserDTO> users = new ArrayList<>();
        for (User userEntity: userService.findByRuolo("user"))
        {
            users.add(userConverter.convertToDTO(userEntity));
        }

        if (users.size() == 0) return  new GenericResponse<>(1,null);
        else return new GenericResponse<>(0,users);
    }



    @RequestMapping(value="/updateUser", method =RequestMethod.POST)
    public GenericResponse<UserDTO> newUser(@RequestBody UserDTO userDTO){

        User user=   userConverter.convertToEntity(userDTO);
        if (user != null)
        {
            User userTrovato= userService.findByUsername(user.getUsername());
            userTrovato.setPassword(user.getPassword());
            userTrovato.setNomeUser(user.getNomeUser());
            userTrovato.setCognomeUser(user.getCognomeUser());
            userTrovato.setDataDiNascita(user.getDataDiNascita());
            userTrovato.setIndirizzo(user.getIndirizzo());
            userTrovato.setCitta(user.getCitta());
            userTrovato.setProvincia(user.getProvincia());
            userTrovato.setCap(user.getCap());
            userTrovato.setEmail(user.getEmail());
            userTrovato.setTelefono(user.getTelefono());
            User userAgg=userService.insert(userTrovato);
            UserDTO userAggDTO=userConverter.convertToDTO(userAgg);

            return new GenericResponse<>(0, userAggDTO); //aggiorna Utente
        }
        else return new GenericResponse<>(1, null); // non aggiorna Utente
    }

    @RequestMapping(value="/bloccaUtente",method = RequestMethod.GET)
    public GenericResponse<UserDTO> blockUtente(@RequestParam("username") String username) {
        User userTrovato = userService.findByUsername(username);

        // if (userTrovato != null) {
        if (userTrovato.getStato().equalsIgnoreCase("Sbloccato")) {

            userTrovato.setStato("Bloccato");
            User userAgg = userService.insert(userTrovato);
            UserDTO userAggDTO = userConverter.convertToDTO(userAgg);
            return new GenericResponse<>(0, userAggDTO);
        } else if (userTrovato.getStato().equalsIgnoreCase("Bloccato")) {

            userTrovato.setStato("Sbloccato");
            User userAgg = userService.insert(userTrovato);
            UserDTO userAggDTO = userConverter.convertToDTO(userAgg);
            return new GenericResponse<>(1, userAggDTO);
        } else {
            return null;
        }
    }








}