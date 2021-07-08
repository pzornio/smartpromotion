package ar.com.learsoft.smartpromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.learsoft.smartpromotion.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
