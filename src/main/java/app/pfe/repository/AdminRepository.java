package app.pfe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.pfe.entity.Admin;

@Repository
public interface  AdminRepository extends JpaRepository<Admin,Integer>{

    Optional<Admin> findByEmailAdmin(String emailAdmin);

}
