package it.contrader.sprint4.converter;


import it.contrader.sprint4.dto.UserDTO;
import it.contrader.sprint4.model.User;
import org.springframework.stereotype.Component;
import java.util.Date;

import java.util.Calendar;
import java.util.GregorianCalendar;


@Component
public class UserConverter implements Converter<User, UserDTO>{
    GregorianCalendar c = new GregorianCalendar();


    @Override
    public User convertToEntity(UserDTO userDTO) {

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setNomeUser(userDTO.getNomeUser());
        user.setCognomeUser(userDTO.getCognomeUser());
        user.setDataDiNascita(userDTO.getDataDiNascita());
        user.setIndirizzo(userDTO.getIndirizzo());
        user.setCitta(userDTO.getCitta());
        user.setProvincia(userDTO.getProvincia());
        user.setCap(userDTO.getCap());
        user.setEmail(userDTO.getEmail());
        user.setTelefono(userDTO.getTelefono());
        user.setRuolo("user");
        user.setStato("Sbloccato");
        user.setDataIscrizione(c.getTime());
        return user;
    }


    @Override
    public UserDTO convertToDTO(User user) {
        return new UserDTO(user.getUsername(), user.getPassword(),user.getNomeUser(),
                user.getCognomeUser(),user.getDataDiNascita(), user.getIndirizzo(),
                user.getCitta(), user.getProvincia(), user.getCap(),
                user.getEmail(), user.getTelefono(), user.getRuolo(), user.getStato(), user.getDataIscrizione());
    }
}

