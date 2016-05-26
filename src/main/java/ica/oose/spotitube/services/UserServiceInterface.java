package ica.oose.spotitube.services;

import ica.oose.spotitube.domain.User;

import java.util.List;

/**
 * Created by Vincent on 20-5-2016.
 */
public interface UserServiceInterface {
    List<User> getAllUsers();
    void addUser(String username, String password);
    void deleteUser(int userId);
    void resetPassword(String userId);
    void manageSpotifyData(String client_id, String client_secret);
}
