/* This is for the Data Access Layer */
/* This uses a MySQL JDBC driver */
package ica.oose.spotitube.datasource.util;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import ica.oose.spotitube.domain.Track;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Vincent on 16-11-2015.
 */
@Singleton
public class TrackDAO {
    private Logger logger = Logger.getLogger(TrackDAO.class.getName());
    protected final DatabaseProperties databaseProperties;

    @Inject
    public TrackDAO(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
        tryLoadJdbcDriver();
    }

    private void tryLoadJdbcDriver() {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
        }
    }

    public List<Track> findAll() {
        List<Track> tracks = new ArrayList<>();
        tryFindAll(tracks);
        return tracks;
    }

    protected void tryFindAll(List<Track> tracks) {
        String GET_QUERY = "SELECT * FROM track";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            PreparedStatement preparedStatement = connection.prepareStatement(GET_QUERY);
            addNewItemsFromDatabase(tracks, preparedStatement);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "TrackDAO.tryFindAll() crashed!", e);
        }
    }

    public List<Track> findAllByBandname(String bandname) {
        List<Track> tracks = new ArrayList<>();
        tryFindAllByBandname(tracks, bandname);
        return tracks;
    }

    private void tryFindAllByBandname(List<Track> tracks, String bandname) {
        String GET_QUERY = "SELECT * FROM track WHERE performer LIKE ?";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_QUERY);
            preparedStatement.setString(1, "%" + bandname + "%");
            addNewItemsFromDatabase(tracks, preparedStatement);
            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "TrackDAO.tryFindAllByBandname crashed!", e);
        }
    }

    protected void tryFindAllById(List<Track> tracks, int trackId) {
        String GET_QUERY = "SELECT * FROM track WHERE trackId = ?";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(GET_QUERY);
            preparedStatement.setInt(1, trackId);
            addNewItemsFromDatabase(tracks, preparedStatement);
            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "TrackDAO.tryFindAllById crashed!", e);
        }
    }

    protected void addNewItemsFromDatabase(List<Track> tracks, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            addNewItemFromDatabase(tracks, resultSet);
        }
    }

    private void addNewItemFromDatabase(List<Track> tracks, ResultSet resultSet) throws SQLException {
        Track track = new Track(
                resultSet.getInt("trackId"), resultSet.getString("performer"), resultSet.getString("title"), resultSet.getString("url"), resultSet.getDouble("duration")
        );
        tracks.add(track);
    }

    public void create(String performer, String title, String url, Double duration) {
        insert(performer, title, url, duration);
    }

    public void insert(String performer, String title, String url, Double duration) {
        String INSERT_QUERY = "INSERT INTO track(performer, title, url, duration) VALUES(?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatementInsert = connection.prepareStatement(INSERT_QUERY);
            preparedStatementInsert.setString(1, performer);
            preparedStatementInsert.setString(2, title);
            preparedStatementInsert.setString(3, url);
            preparedStatementInsert.setDouble(4, duration);
            preparedStatementInsert.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "TrackDAO.insert() crashed!", e);
        }
    }

    public void update(Integer trackId, String performer, String title, String url, Double duration) {
        String UPDATE_QUERY = "UPDATE track SET performer = ?, title = ?, url = ?, duration = ? WHERE trackId = ?";
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(UPDATE_QUERY);
            preparedStatementUpdate.setString(1, performer);
            preparedStatementUpdate.setString(2, title);
            preparedStatementUpdate.setString(3, url);
            preparedStatementUpdate.setDouble(4, duration);
            preparedStatementUpdate.setInt(5, trackId);
            preparedStatementUpdate.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
           logger.log(Level.SEVERE, "TrackDAO.update() crashed!", e);
        }
    }

    public List<Track> select(int trackId) {
        List<Track> tracks = new ArrayList<>();
        tryFindAllById(tracks, trackId);
        return tracks;
    }

    public void delete(Integer trackId) {
        String DELETE_QUERY = "DELETE FROM track WHERE trackId = ?";

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionString());
            connection.setAutoCommit(false);
            PreparedStatement preparedStatementDelete = connection.prepareStatement(DELETE_QUERY);
            preparedStatementDelete.setInt(1, trackId);
            preparedStatementDelete.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "TrackDAO.delete() crashed!", e);
        }
    }

}
