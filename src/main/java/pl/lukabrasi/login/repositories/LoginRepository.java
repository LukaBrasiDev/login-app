package pl.lukabrasi.login.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lukabrasi.login.entities.LoginEntity;

import java.util.Optional;

@Repository
public interface LoginRepository extends CrudRepository<LoginEntity, Integer> {



    boolean existsByLogin(String login);

}
