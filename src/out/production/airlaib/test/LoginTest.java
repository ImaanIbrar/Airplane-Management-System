package out.production.airlaib.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import out.production.airlaib.Login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


/**
 * JUnit test class for the {@Login} class.
 * Author: Imaan Ibrar
 */
public class LoginTest {

    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    /**
     * Set up the mock database connection, statement, and result set.
     * 
     * @throws SQLException If a SQL exception occurs during setup.
     */ 
    @Before
    public void setUp() throws SQLException {
        // Mock the database connection, statement, and result set
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Set up the mock result set to return a user when queried
        when(mockResultSet.next()).thenReturn(true);
    }

    /**
     * Close the mock connection after each test.
     * 
     * @throws SQLException If a SQL exception occurs during teardown.
     */
    @After
    public void tearDown() throws SQLException {
        // Close the mock connection after each test
        if (mockConnection != null) {
            mockConnection.close();
        }
    }

    /**
     * Test the {@code loginBtnAction} method when a login is successful.
     * Verifies that the admin domain window is opened.
     * 
     * @throws SQLException If a SQL exception occurs during the test.
     */
    @Test
    public void testLoginSuccessful() throws SQLException {
        // Arrange
        Login login = new Login();
        login.con = mockConnection;
        login.getUsernameText().setText("imaan");
        login.getPaswordText().setText("123");
        // Ensure admindomainObj is not null before accessing methods
        assertNotNull(login.getAdmindomainObj());

        // Act
        login.loginBtnAction(null);

        // Assert
        // Check if the admin domain window is opened
        assertTrue(login.getAdmindomainObj().isVisible());
    }

    /**
     * Test the {@code loginBtnAction} method when a login is unsuccessful.
     * Verifies that appropriate error-handling behavior occurs.
     * 
     * @throws SQLException If a SQL exception occurs during the test.
     */
    @Test
    public void testLoginUnsuccessful() throws SQLException {
        // Arrange
        Login login = new Login();
        login.con = mockConnection;
        login.getUsernameText().setText("nonexistentUser");
        login.getPaswordText().setText("wrongPassword");

        // Act
        login.loginBtnAction(null);

        // Assert
        // Check if appropriate error-handling behavior occurs
        assertEquals("", login.getUsernameText().getText());
        assertEquals("", login.getPaswordText().getText());
        // Add more assertions based on your specific behavior
    }
}
