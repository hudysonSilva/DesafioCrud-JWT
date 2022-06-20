package br.com.crud.desafiocrud.repositories;

import br.com.crud.desafiocrud.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}