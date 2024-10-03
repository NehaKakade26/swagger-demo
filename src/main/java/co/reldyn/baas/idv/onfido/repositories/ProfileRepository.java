package co.reldyn.baas.idv.onfido.repositories;

import co.reldyn.baas.idv.onfido.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {}
