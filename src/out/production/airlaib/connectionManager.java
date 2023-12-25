package out.production.airlaib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The {@code ConnectionManager} class provides a method to establish a
 * connection to the MySQL database.
 * It uses the JDBC driver to connect to the specified database URL with the
 * given credentials.
 * This class is designed to be used as a utility class for obtaining database
 * connections.
 *
 * @author Marriam Naeem
 * @version 1.0
 * @since 2023-12-19
 */
public class connectionManager {

  /** The URL of the MySQL database. */
  public static final String URL = "jdbc:mysql://localhost/airline";

  /** The username for connecting to the database. */
  private static final String USER = "root";

  /** The password for connecting to the database. */
  private static final String PASSWORD = "1234";

  /**
   * Establishes a connection to the MySQL database using the specified URL,
   * username, and password.
   *
   * @return A {@code Connection} object representing the established database
   *         connection.
   * @throws SQLException If a SQL exception occurs during the connection process.
   */
  public static Connection getConnection() throws SQLException {
    try {
      // Load the JDBC driver class
      Class.forName("com.mysql.cj.jdbc.Driver");

      // Establish and return the database connection
      return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException ex) {
      // If the JDBC driver class is not found, throw a SQLException with a
      // descriptive message
      throw new SQLException("Database driver not found", ex);
    }
  }

  /**
   * @return the url
   */
  public static String getUrl() {
    return URL;
  }
}
