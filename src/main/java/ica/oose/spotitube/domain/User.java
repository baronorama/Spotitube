package ica.oose.spotitube.domain;

/**
 * Created by Vincent on 24-4-2016.
 * @version 1.0
 */
public class User {
    private final int userId;
    private String username;
    private String password;
    private boolean isPaidAccount;
    private boolean isAdmin;

    /**
     * User -- standard constructor for User object.
     * @param userId unique identifier for user object
     * @param username username in email-address form
     * @param password password of user
     * @param isPaidAccount 0 for free account, 1 for paid account
     * @param isAdmin 0 for normal user, 1 for administrator
     */
    public User(final int userId, final String username,
                final String password, final boolean isPaidAccount,
                final boolean isAdmin) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.isPaidAccount = isPaidAccount;
        this.isAdmin = isAdmin;
    }

    /**
     * getUserId -- returns userId of user.
     * @return int userId
     */
    public final int getUserId() {
        return userId;
    }

    /**
     * getUsername -- return username.
     * @return String username
     */
    public final String getUsername() {
        return username;
    }

    /**
     * getPassword -- returns a hashed version of the password.
     * @return String password
     */
    public final String getPassword() {
        //TODO:hash the password
        return password;
    }

    public final boolean getIsPaidAccount() {
        return isPaidAccount;
    }

    public final boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * setUsername -- sets username of User object.
     * @param newName the new name of the User object
     */
    public final void setUsername(final String newName) {
        this.username = newName;
    }

    /**
     * setPassword -- sets password of User object.
     * @param password the new password
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public final String toString() {
        return "User {"
                + "userId='" + userId
                + '\''
                + "username='"
                + username
                + '\''
                + ", password='"
                + password
                + '\''
                + ", isPaidAccount='"
                + isPaidAccount
                + '\''
                + ", isAdmin='"
                + isAdmin
                + '\''
                + '}';
    }
}
