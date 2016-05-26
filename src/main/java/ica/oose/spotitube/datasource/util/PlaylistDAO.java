/* This is for the JDBC */
/* Should this be static? / Singleton? */
package ica.oose.spotitube.datasource.util;

import ica.oose.spotitube.domain.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Vincent on 4-12-2015.
 */
public class PlaylistDAO {
    private Logger logger = Logger.getLogger(PlaylistDAO.class.getName());
    private DatabaseProperties databaseProperties;

    public PlaylistDAO(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
        tryLoadJdbcDriver(databaseProperties);
    }

    private void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC driver " + databaseProperties.driver(), e);
        }
    }

    public List<Playlist> findByOwner(String owner) {
        List<Playlist> playlists = new ArrayList<>();
        tryFindByOwner(playlists, owner);
        return playlists;
    }

    public void tryFindByOwner(List<Playlist> playlists, String owner) {
        String SELECT_QUERY = "SELECT * FROM playlist WHERE owner LIKE ?";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, "%"+ owner + "%");
            addNewItemsFromDatabase(playlists, preparedStatement);
            preparedStatement.close();
            connection.close();
        } catch (SQLException e){
            logger.log(Level.SEVERE, "PlaylistDAO.findByOwner crashed {0} ", e);
        }
    }

    private void addNewItemsFromDatabase(List<Playlist> playlists, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            addNewItemFromDatabase(playlists, resultSet);
        }
    }

    private void addNewItemFromDatabase(List<Playlist> playlists, ResultSet resultSet) throws SQLException {
        Playlist playlist = new Playlist(
                resultSet.getInt("playlistId"), resultSet.getString("owner"), resultSet.getString("name")
        );
        playlists.add(playlist);
    }

    public void create(String owner, String name) {
        insert(owner, name);
    }

    public void insert(String owner, String name) {
        String INSERT_QUERY = "INSERT INTO playlist(owner, name) VALUES(?, ?)";

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatementInsert = connection.prepareStatement(INSERT_QUERY);
            preparedStatementInsert.setString(1, owner);
            preparedStatementInsert.setString(2, name);
            preparedStatementInsert.executeUpdate();
            preparedStatementInsert.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "PlaylistDAO.insert() crashed: {0} ", e);
        }
    }

    public void update(Integer playlistId, String name) {
        String UPDATE_QUERY = "UPDATE playlist SET name = ? WHERE playlistId = ?";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(UPDATE_QUERY);
            preparedStatementUpdate.setString(1, name);
            preparedStatementUpdate.setInt(2, playlistId);
            preparedStatementUpdate.executeUpdate();
            preparedStatementUpdate.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "PlaylistDAO.update() crashed {0} ", e);
        }
    }

    @SuppressWarnings("Duplicates")
    public void select(Integer playlistId) {
        String SELECT_QUERY = "SELECT * FROM playlist WHERE playlistId = ?";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatementSelect = connection.prepareStatement(SELECT_QUERY);
            preparedStatementSelect.setInt(1, playlistId);
            preparedStatementSelect.executeQuery();
            preparedStatementSelect.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "PlaylistDAO.select() crashed {0} ", e);
        }
    }

    @SuppressWarnings("Duplicates")
    public void delete(Integer playlistId) {
        String DELETE_QUERY = "DELETE FROM playlist WHERE playlistId = ?";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatementDelete = connection.prepareStatement(DELETE_QUERY);
            preparedStatementDelete.setInt(1, playlistId);
            preparedStatementDelete.executeQuery();
            preparedStatementDelete.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "PlaylistDAO.delete() crashed {0} ", e);
        }
    }

}
