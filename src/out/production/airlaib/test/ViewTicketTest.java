package out.production.airlaib.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import out.production.airlaib.viewTicket;

/**
 * Javadoc for ViewTicketTest class.
 *
 * JUnit test class for the {@code viewTicket} class.
 * Author: Abdullah Tahir
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
        viewTicket.getTicketText().setText("TO001");

        // Act
        viewTicket.proceedBtnAction(null);

        // Assert
        // TODO: Add assertions based on the expected behavior
        // For example, check if the billing window is opened
        // You may need to add a method in viewTicket to retrieve the billing window instance for validation
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

        // Mock JOptionPane.showMessageDialog
        ArgumentCaptor<Object> messageCaptor = ArgumentCaptor.forClass(Object.class);
        Mockito.mockStatic(JOptionPane.class);
        // Capture the argument passed to showMessageDialog
        doNothing().when(JOptionPane.class);
        JOptionPane.showMessageDialog(eq(null), messageCaptor.capture());
        // Act
        viewTicket.proceedBtnAction(null);

        // Assert
        // Verify that showMessageDialog was called
        assertEquals("Record not Found", viewTicket.getShowMessageDialogMessage());
    }
}
