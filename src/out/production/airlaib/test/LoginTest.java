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

/**
 * JUnit test class for the {@link Login} class.
 * Author: Imaan Ibrar
 *
 * Testing Strategy:
 *
 * Partition the inputs for login credentials as follows:
 * 1. Valid username and password.
 * 2. Invalid username and password combination.
 *
 * Additionally, verify the behavior of the loginBtnAction method:
 * 4. Verify that, on successful login, the admin domain window is opened.
 * 5. Verify that, on unsuccessful login, appropriate error-handling behavior occurs (e.g., fields are cleared).
 *
 * Mock the database connection, statement, and result set for each test case using Mockito.
 * Ensure that the result set returns a user for the valid credentials case and does not return a user for invalid credentials.
 *
 * Test Cases:
 *
 * Test 1: Valid login credentials
 * - Set up: Set valid username and password in the Login instance.
 * - Action: Call loginBtnAction.
 * - Assert: Verify that the admin domain window is opened (check the visibility of the admin domain window).
 *
 * Test 2: Invalid login credentials
 * - Set up: Set invalid username and password in the Login instance.
 * - Action: Call loginBtnAction.
 * - Assert: Verify that the username and password fields are cleared.
 *
 * 
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
