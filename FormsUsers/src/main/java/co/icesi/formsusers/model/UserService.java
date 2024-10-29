package co.icesi.formsusers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    private static UserService instance;
    public static UserService getInstance() {
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }
    private  List<User> users;
    private User auth;

    private UserService(){
      users = new ArrayList<>();
    }

    public void addUser(String ... params)throws Exception{
        User user = new User(params[0],params[1],params[2],params[3]);
        Optional<User> u = users.stream().filter(us -> us.getCode().equals(user.getCode())).findFirst();
        if(u.isEmpty()){
            users.add(user);
        }else {
            throw new Exception("User exists");
        }
    }

    public boolean logIn(String code, String pass){
        Optional<User> user = users.stream().filter(
                u -> u.getCode().equals(code) && u.getPassword().equals(pass)
        ).findFirst();

        if(user.isPresent()){
            auth = user.get();
            return true;
        }else {
            return false;
        }
    }

}
