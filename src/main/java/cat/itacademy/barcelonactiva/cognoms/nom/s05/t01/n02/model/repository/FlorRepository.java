package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.Flor;



@Repository
public interface FlorRepository extends JpaRepository <Flor, Integer>  {

}
