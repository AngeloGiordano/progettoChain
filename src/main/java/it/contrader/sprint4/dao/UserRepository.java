package it.contrader.sprint4.dao;


import it.contrader.sprint4.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface  UserRepository extends CrudRepository<User, Long> {

    List<User> findByRuolo(String ruolo);

    User findByUsername(String username);
}
