package ica.oose.spotitube.services;

import ica.oose.spotitube.datasource.util.DatabaseProperties;
import ica.oose.spotitube.datasource.util.UserDAO;
import ica.oose.spotitube.domain.User;

import java.util.List;

/**
 * Created by Vincent on 20-5-2016.
 * @version 1.0
 */
public class UserService implements UserServiceInterface {
    private DatabaseProperties databaseProperties = new DatabaseProperties();
    private UserDAO userDAO = new UserDAO(databaseProperties);

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public void deleteUser(int userId) {
        userDAO.deleteUserById(userId);
    }

    @Override
    public void resetPassword(String userId) {
        userDAO.resetPassword(userId);
    }

    @Override
    public void manageSpotifyData(String clienId, String clientSecret) {
        //TODO: think of managing strategy and implement method
    }

    @Override
    public void addUser(String username, String password) {
        userDAO.addUser(username, password);
    }
}
