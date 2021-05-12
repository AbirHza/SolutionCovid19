package tn.esprit.pfe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pfe.entities.Utilisateur;
@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {

	Utilisateur findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	public Optional<Utilisateur> findByEmail(String email);
	public Optional<Utilisateur> findByResetToken(String token);
	
	
}
