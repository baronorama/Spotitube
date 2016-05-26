package ica.oose.spotitube.domain;

/**
 * Created by Vincent on 24-4-2016.
 */
public class User {
    private int userId;
    private String username;
    private String password;

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public int getUserId() { return userId; }
    public String getUserName() { return username; }
    public String getPassword() { return password; }
    //TODO:hash the password

    public void setUsername(String newName) {
        this.username = newName;
    }

    @Override
    public String toString() {
        return "User {" +
                "userId='" + userId + '\'' +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
