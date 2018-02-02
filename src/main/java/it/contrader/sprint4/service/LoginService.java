package it.contrader.sprint4.service;


import it.contrader.sprint4.dao.LoginRepository;
import it.contrader.sprint4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService
{
    private LoginRepository loginRepository;

    @Autowired
    public LoginService (LoginRepository loginRepository) { this.loginRepository = loginRepository; }
    public User login (String username, String password)
    {
        return loginRepository.findUserByUsernameAndPassword(username, password);
    }
}
