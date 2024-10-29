package co.icesi.hwjavafx.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassRoom {

    private static ClassRoom instance;
    private List<User> users;

    private User logged;

    public static ClassRoom getInstance(){
        if(instance == null){
            instance = new ClassRoom();
        }
        return instance;
    }

    private ClassRoom(){
        users = new ArrayList<>();
    }
    public void addUser(String code, String name, String password){
        boolean exist = users.stream().anyMatch(u -> u.getCode().equals(code));
        if(!exist){
            users.add(new User(code,name,password));
        }else {
            throw new RuntimeException("code already exist");
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean login(String code, String password){
        Optional<User> user = users.stream().filter(u -> u.getCode().equals(code)&&u.getPassword().equals(password)).findFirst();
        if(user.isPresent()){
            logged = user.get();
            return true;
        }else{
            return false;
        }
    }
}
