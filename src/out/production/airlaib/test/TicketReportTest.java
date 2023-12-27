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
 *  * Javadoc for TicketReportTest class.
 *
 * JUnit test class for the {@code ticketreport} class.
 *
 * @author Abdullah Tahir
 * @version 1.0
 * @since 2023-11-21
 * Testing strategy for TicketReportTest class:
 *
 * The primary goal of TicketReportTest is to verify the functionality of the ticketreport class,
 * specifically focusing on the LoadData, confirmButtonActionPerformed, and backBtnAction methods.
 *
 * Test cases:
 *
 * 1. **testLoadData:**
 *    - Description: Tests the LoadData method of the ticketreport class.
 *    - Steps:
 *        - Create an instance of the ticketreport class.
 *        - Call the LoadData method.
 *        - Verify that the table has data (rows and columns) after the method call.
 *    - Expected Result: The table should have data after calling the LoadData method.
 *
 * 2. **testConfirmButtonActionPerformed:**
 *    - Description: Tests the confirmButtonActionPerformed method of the ticketreport class.
 *    - Steps:
 *        - Create an instance of the ticketreport class and set a mock connection.
 *        - Set up mock objects for PreparedStatement and ResultSet to simulate a successful update.
 *        - Select a row in the table.
 *        - Call the confirmButtonActionPerformed method.
 *        - Verify that the confirmation status is "Successful."
 *    - Expected Result: The confirmation status should be "Successful" after confirming a ticket.
 *
 * 3. **testBackBtnAction:**
 *    - Description: Tests the backBtnAction method of the ticketreport class.
 *    - Steps:
 *        - Create an instance of the ticketreport class.
 *        - Set up a mock admin domain window.
 *        - Call the backBtnAction method.
 *        - Verify that the current window is closed, and the admin domain window is opened.
 *    - Expected Result: The admin domain window should be opened after clicking the back button.
 *
 * 4. **Edge cases and Error scenarios:**
 *    - Currently, there are no specific edge cases or error scenarios considered in the provided test.
 *    - Depending on the implementation of the ticketreport class, additional tests could be added for:
 *        - Handling scenarios where LoadData is called with no data in the database.
 *        - Verifying the behavior when confirmButtonActionPerformed is called with no selected row.
 *        - Testing the behavior when the back button is clicked with different states of the UI.
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
