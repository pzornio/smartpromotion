package ar.com.learsoft.javaws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.learsoft.javaws.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
