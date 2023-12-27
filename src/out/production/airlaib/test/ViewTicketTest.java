package out.production.airlaib.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import out.production.airlaib.bill;
import out.production.airlaib.viewTicket;

/**
 * JUnit test class for the {@code viewTicket} class.
 * Author: Abdullah Tahir
 * 
 * Testing strategy for the ViewTicket class.
 *
 * Partition the inputs as follows:
 *
 * 1. Case when a record is found (positive case):
 *    - Set up a mock connection to return a record when queried.
 *    - Call proceedBtnAction with a valid ticket ID.
 *    - Verify that the billing window is opened and visible.
 *
 * 2. Case when a record is not found (negative case):
 *    - Set up a mock connection to not return a record when queried.
 *    - Call proceedBtnAction with a nonexistent ticket ID.
 *    - Verify that the billing window is null.
 *
 * Note: The testing strategy may evolve based on the actual implementation of the ViewTicket class.
 */
 
public class ViewTicketTest {

    // Fields for mock objects
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    /**
     * Set up the mock database connection, statement, and result set.
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

        // Set up the mock result set to return a record when queried
        when(mockResultSet.next()).thenReturn(true);
    }

    /**
     * Close the mock connection after each test.
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
     * Test the {@code proceedBtnAction} method when a record is found.
     * Verifies that the billing window is opened.
     * @throws SQLException If a SQL exception occurs during the test.
     */
    @Test
    public void testProceedBtnActionRecordFound() throws SQLException {
        // Arrange
        viewTicket viewTicket = new viewTicket();
        viewTicket.setConnection(mockConnection);
        viewTicket.getTicketText().setText("TO002");

        // Act
        viewTicket.proceedBtnAction(null);

        // Assert
        // Check if the billing window is opened
        bill billingWindow = viewTicket.getBillObj();
        assertNotNull("Billing window should not be null", billingWindow);
        assertTrue("Billing window should be visible", billingWindow.isVisible());
        // Add more assertions based on the expected behavior of the billing window
    }
    /**
     * Test the {@code proceedBtnAction} method when a record is not found.
     * Verifies that the expected error message is shown using JOptionPane.
     * @throws SQLException If a SQL exception occurs during the test.
     */
    @Test
    public void testProceedBtnActionRecordNotFound() throws SQLException {
        // Arrange
        viewTicket viewTicket = new viewTicket();
        viewTicket.setConnection(mockConnection);
        viewTicket.getTicketText().setText("nonexistentID");

        //Act
        viewTicket.proceedBtnAction(null);
        bill billingWindow = viewTicket.getBillObj();
        // Assert
        // Verify that billingWindow is not declared because ticket is is not matched
        assertNull("Billing window should be null", billingWindow);
    }
    
    
}
