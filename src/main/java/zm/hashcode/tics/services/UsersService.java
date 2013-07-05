/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.services;

import org.springframework.stereotype.Service;

/**
 *
 * @author boniface
 */
@Service
public class UsersService {
//    private final UsersRepository usersRepository;
//
//    @Autowired
//    public UsersService(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }
//    
//    public void persist (Users user){
//        usersRepository.save(user);
//    }
//    
    
    private String hello;
    
    public String getTheValue(String name){
        
        return "THIS FREAKING STRING WAS CALLED "+name;
    }
}
