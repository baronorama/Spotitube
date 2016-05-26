/* this is for JDBC */
package ica.oose.spotitube.datasource.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * Created by Vincent on 12-11-2015.
 */
public class WriteProperties {

    public static void main(String[] args) {

        Properties prop = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream("src/main/resources/database.properties");

            // set the properties value
            prop.setProperty("user", "vincent");
            prop.setProperty("password", "vincent");
            prop.setProperty("driver", "com.mysql.jdbc.Driver");
            prop.setProperty("connectionString", "jdbc:mysql://localhost:3306/spotitube?user="+prop.getProperty("user")+"&password="+prop.getProperty("password"));

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}




