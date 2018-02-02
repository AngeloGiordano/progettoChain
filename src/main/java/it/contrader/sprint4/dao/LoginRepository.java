package it.contrader.sprint4.dao;

import it.contrader.sprint4.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface LoginRepository extends CrudRepository <User, Long> {
    User findUserByUsernameAndPassword(String username, String password);
}
