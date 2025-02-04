package allos.prenotazionePJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import allos.prenotazionePJ.model.Prenotazione;

@Repository
public interface IRepoPrenotazione extends JpaRepository<Prenotazione, Integer> {

//	@Query("From Prenotazione p where p.nome=?1")
}
