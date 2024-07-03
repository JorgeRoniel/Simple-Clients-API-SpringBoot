package shr.company.api_client_cep.services;

import shr.company.api_client_cep.models.User;

public interface UserServices {
    
    public void insertUser(User user);
    public void updateUser(Long id, User user);
    public void deleteUser(Long id);
    public User findOneUser(Long id);
    public Iterable<User> listAllUsers();

}
