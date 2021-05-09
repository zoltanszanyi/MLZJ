package hu.unideb.inf;

import java.util.List;

public interface UsersDAO extends AutoCloseable {
    public void saveUser(Users u);
    public void deleteUser(Users u);
    public void updateteUser(Users u);
    public List<Users> getUsers();
}
