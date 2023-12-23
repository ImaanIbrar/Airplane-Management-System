package out.production.airlaib.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import out.production.airlaib.connectionManager;

/**
 * Javadoc for ConnectionManagerTest class.
 *
 * JUnit test class for the {@code connectionManager} class.
 * Tests the connection to the MySQL database.
 *
 * @author Marriam Naeem
 * @version 1.0
 * @since 23-12-2023
 */
public class ConnectionManagerTest {

    /**
     * Tests the successful establishment of a database connection.
     *
     * <p>This test attempts to establish a connection to the MySQL database
     * using the {@code getConnection} method from the {@code connectionManager} class.
     * It verifies that the returned connection is not null, and then closes the connection.
     *
     * @throws SQLException If a SQL exception occurs during the test.
     */
    @Test
    public void testGetConnectionSuccess() {
        try {
            // Attempt to establish a connection
            Connection connection = connectionManager.getConnection();

            // Assert that the connection is not null
            assertNotNull("Connection should not be null", connection);

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            // Fail the test if an exception occurs
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}
