/* This is for the Data Access Layer */
/* This uses a MySQL JDBC driver */
package ica.oose.spotitube.datasource.util;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import ica.oose.spotitube.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Vincent on 02-05-2016.
 */

@Singleton
public class UserDAO {
    private Logger logger = Logger.getLogger(UserDAO.class.getName());
    private DatabaseProperties databaseProperties;

    @Inject
    public UserDAO(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
        TryLoadJdbcDriver(databaseProperties);
    }

    private void TryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC driver" + databaseProperties.driver(), e);
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        tryFindAll(users);
        System.out.println(users);
        return users;
    }

    private void tryFindAll(List<User> users) {
        String GET_QUERY = "SELECT * FROM users2";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement preparedStatement = connection.prepareStatement(GET_QUERY);
            addNewItemsFromDatabase(users, preparedStatement);
        }
        catch (SQLException e){
            logger.log(Level.SEVERE, "UserDAO tryFindAll() crashed!", e);
        }
    }

    private void addNewItemsFromDatabase(List<User> users, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            addNewItemFromDatabase(users, resultSet);
        }
        System.out.println(users);
    }

    private void addNewItemFromDatabase(List<User> users, ResultSet resultSet) throws SQLException {
        User user = new User(
                resultSet.getInt("userId"), resultSet.getString("username"),
                resultSet.getString("password"), resultSet.getBoolean("isPaidAccount"),
                resultSet.getBoolean("isAdmin")
        );
        users.add(user);
    }

    public List<User> findUserByName(String username) {
        List<User> users = new ArrayList<>();
        tryFindUserByName(users, username);
        return users;
    }

    private void tryFindUserByName(List<User> users, String username) {
        String SELECT_QUERY = "SELECT * FROM users2 WHERE username is ?";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, "%" + username + "%");
            addNewItemsFromDatabase(users, preparedStatement);
            connection.commit();
        } catch (SQLException e){
            logger.log(Level.SEVERE, "UserDAO tryFindUserName crashed!", e);
        }
    }

    public void deleteUserByName(String username) {
        String DELETE_QUERY = "DELETE FROM users2 WHERE username = ?";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e){
            logger.log(Level.SEVERE, "UserDAO.deleteUserById() crashed!", e);
        }
    }

    public List<User> findUserById(String userId) {
        List<User> users = new ArrayList<>();
        tryFindUserById(users, userId);
        return users;
    }

    private void tryFindUserById(List<User> users, String userId) {
        String SELECT_QUERY = "SELECT * FROM users2 WHERE userId is ?";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, "%" + userId + "%");
            addNewItemsFromDatabase(users, preparedStatement);
            connection.commit();
        } catch (SQLException e){
            logger.log(Level.SEVERE, "UserDAO tryFindUserId crashed!", e);
        }
    }

    public void resetPassword(String userId) {
        String RESET_QUERY = "UPDATE users2 SET password='' WHERE userId = ?";
        try {
            Connection connection = DriverManager.getConnection((databaseProperties.connectionString()));
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(RESET_QUERY);
            preparedStatement.setString(1, userId);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "UserDAO resetPassword crashed!", e);
        }
    }

    public void addUser(String username, String password, boolean isPaidAccount, boolean isAdmin) {
        String CREATE_QUERY = "INSERT INTO users2(username, password, isPaidAccount, isAdmin) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setBoolean(3, isPaidAccount);
            preparedStatement.setBoolean(4, isAdmin);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "userDAO.addUser crashed!", e);
        }
    }
}