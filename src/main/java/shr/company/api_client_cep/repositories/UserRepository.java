package shr.company.api_client_cep.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shr.company.api_client_cep.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
