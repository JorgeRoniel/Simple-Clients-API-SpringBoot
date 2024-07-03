package shr.company.api_client_cep.services.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shr.company.api_client_cep.models.Adress;
import shr.company.api_client_cep.models.User;
import shr.company.api_client_cep.repositories.AdressRepository;
import shr.company.api_client_cep.repositories.UserRepository;
import shr.company.api_client_cep.services.UserServices;
import shr.company.api_client_cep.services.viaCEPService;

@Service
public class UserServiceImplents implements UserServices{

    @Autowired
    private UserRepository repository;

    @Autowired
    private AdressRepository adressRepository;

    @Autowired 
    private viaCEPService viaCEPService;

    @Override
    public void insertUser(User user) {
        saveUserWithCEP(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        Optional<User> u = repository.findById(id);
        if(u.isPresent()){
            saveUserWithCEP(user);
        }
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User findOneUser(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    @Override
    public Iterable<User> listAllUsers() {
        return repository.findAll();
    }

    private void saveUserWithCEP(User user){
        String cep = user.getAdress().getCep();
        Adress adress = adressRepository.findById(cep).orElseGet(() -> {

            Adress newAdress = viaCEPService.getCEP(cep);
            adressRepository.save(newAdress);
            return newAdress;
        });
        user.setAdress(adress);
        repository.save(user);  
    }
    
}
