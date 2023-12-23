package out.production.airlaib.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import out.production.airlaib.admindomain;
import out.production.airlaib.ticketreport;

/**
 * Javadoc for TicketReportTest class.
 *
 * JUnit test class for the {@code ticketreport} class.
 *
 * @author Abdullah Tahir
 * @version 1.0
 * @since 2023-11-21
 */
public class TicketReportTest {

    // Fields for mock objects
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
     * Javadoc for the testLoadData method.
     * <p>
     * Test case for the LoadData method of the ticketreport class.
     * Verifies that the table has data after calling the LoadData method.
     */
    @Test
    public void testLoadData() {
        ticketreport report = new ticketreport();

        // Call the method to load data
        report.LoadData();

        // Verify that the table has data
        DefaultTableModel model = (DefaultTableModel) report.ticketsTable.getModel();
        assertTrue(model.getRowCount() > 0);
        assertTrue(model.getColumnCount() > 0);
    }

    /**
     * Javadoc for the testConfirmButtonActionPerformed method.
     * <p>
     * Test case for the confirmButtonActionPerformed method of the ticketreport class.
     * Verifies that the confirmation status is updated successfully when a row is selected.
     *
     * @throws SQLException If a SQL exception occurs during the test.
     */
    @Test
    public void testConfirmButtonActionPerformed() throws SQLException {
        ticketreport report = new ticketreport();
        report.setConnection(mockConnection);

        // Create a mock PreparedStatement
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);

        // Create a mock ResultSet
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Update successful

        // Set a selected row in the table
        report.ticketsTable.addRowSelectionInterval(0, 0);

        // Call the method to confirm the ticket
        String result = report.confirmButtonActionPerformed(null);

        // Verify that the confirmation status is updated successfully
        assertEquals("Successful", result);
    }

    /**
     * Javadoc for the testBackBtnAction method.
     * <p>
     * Test case for the backBtnAction method of the ticketreport class.
     * Verifies that the current window is closed, and the admin domain window is opened when the back button is clicked.
     */
    @Test
    public void testBackBtnAction() {
        ticketreport report = new ticketreport();

        // Create a mock admin domain window
        admindomain mockAdminDomain = mock(admindomain.class);
        report.setAdminDomainObj(mockAdminDomain);

        // Call the method to go back
        report.backBtnAction(null);

        // Verify that the current window is closed, and the admin domain window is opened
        assertTrue(report.getAdminDomainObj().isVisible());
    }
}
