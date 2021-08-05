package Services;

import Dao.ManageUser;
import Models.User;

import java.util.ArrayList;

public class UserService {
    public ArrayList<User> listUser = new ArrayList<>();

    public UserService() {
        try {
            listUser = ManageUser.showUser();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(User user) {
        try {
            ManageUser.saveUser(user);
            listUser = ManageUser.showUser();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            ManageUser.deleteUser(id);
            listUser = ManageUser.showUser();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
