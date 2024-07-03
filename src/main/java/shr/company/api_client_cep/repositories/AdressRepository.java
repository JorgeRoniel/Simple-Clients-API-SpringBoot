package shr.company.api_client_cep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shr.company.api_client_cep.models.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, String>{
    
}
