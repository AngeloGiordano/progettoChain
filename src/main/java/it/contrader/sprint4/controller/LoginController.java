package it.contrader.sprint4.controller;


import it.contrader.sprint4.GenericResponse;
import it.contrader.sprint4.converter.UserConverter;
import it.contrader.sprint4.dto.UserDTO;
import it.contrader.sprint4.model.User;
import it.contrader.sprint4.service.LoginService;
import it.contrader.sprint4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(value="*")
@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;
    private UserConverter userConverter;
    private UserService userService;

    @Autowired
    public LoginController(LoginService loginService, UserService userService, UserConverter userConverter)
    {
        this.loginService = loginService;
        this.userConverter=userConverter;
        this.userService=userService;
    }

    @RequestMapping(value="/page")
    public String loginPage()
    {
        return "loginPage";
    }

    @RequestMapping(value="/menu", method = RequestMethod.POST)
    public GenericResponse<UserDTO> menu (@RequestBody UserDTO userDTO)
    {
        User u=userConverter.convertToEntity(userDTO);
        User user = loginService.login(u.getUsername(),u.getPassword());

        if (user == null)
            return new GenericResponse<>(1, null);


        UserDTO duser=userConverter.convertToDTO(user);

        if(user.getRuolo().equalsIgnoreCase("admin"))
            return new GenericResponse<>(2,duser);//per il menuAdmin
        else
            return new GenericResponse<>(3,duser);//per il menuUser
    }


    @RequestMapping(value="/regControl", method = RequestMethod.POST)
    public GenericResponse<UserDTO> control (@RequestBody UserDTO userDTO)
    {
        User user=userConverter.convertToEntity(userDTO);
        String username = user.getUsername();
        String password = user.getPassword();
        User u = loginService.login(username, password);

        if (u != null)
            return new GenericResponse<>(0,null);//username già in uso
        else
        {
            User userEntity = userService.insert(user);

            UserDTO duser=userConverter.convertToDTO(userEntity);

            return new GenericResponse<>(1,duser); //inserisce nuovo utente
        }
    }

}