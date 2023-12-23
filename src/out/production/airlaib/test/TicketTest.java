/**
 * This class contains JUnit test cases for the 'ticket' class functionalities.
 * It utilizes Mockito for mocking database interactions and covers various scenarios.
 * The test cases include booking tickets, updating destination dropdown, and handling date selection.
 *
 * @author Marriam Naeem
 * @version 1.0
 * @since 2023-12-23
 */

package out.production.airlaib.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import out.production.airlaib.ticket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JComboBox;

public class TicketTest {

    private Connection mockConnection;
    private ticket ticket;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    /**
     * Set up before each test case.
     *
     * @throws SQLException If a SQL-related error occurs.
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

        // declare object
        ticket = new ticket();
        ticket.setConnection(mockConnection);

    }

    /**
     * Tear down after each test case.
     *
     * @throws SQLException If a SQL-related error occurs.
     */
    @After
    public void tearDown() throws SQLException {
        // Close the mock connection after each test
        if (mockConnection != null) {
            mockConnection.close();
        }
    }

    /**
     * Tests the successful booking of a ticket.
     *
     * @throws SQLException           If a SQL-related error occurs.
     * @throws ClassNotFoundException If the required class is not found.
     * @throws ParseException         If a parsing error occurs.
     */
    @Test
    public void testBookSuccessful() throws SQLException, ClassNotFoundException, ParseException {
        // Arrange
        ticket ticket = new ticket();
        ticket.setConnection(mockConnection);
        ticket.getTxtticketno().setText("TO004");
        ticket.getFlightno().setText("FO035");
        ticket.setFlightname("Melanka");
        ticket.getTxtcustid().setText("CS002");
        ticket.getTxtfirstname().setText("Maryam");
        ticket.getTxtlastname().setText("Naeem");
        ticket.getTxtpassport().setText("123456789");
        ticket.getTxtclass().setSelectedItem("Business");
        ticket.getTxtseats().setValue(1);
        ticket.setPrice(9000);
        ticket.getTxtprice().setText("13500");
        ticket.setDepartTime("9.00AM");
        ticket.setArrivaltime("10.00AM");
        ticket.setSourceCity("Srilanka");
        ticket.setDepartCity("Canada");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2024-12-13";
        java.util.Date utilDate = dateFormat.parse(dateString);
        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        ticket.getTxtdate().setDate(sqlDate);

        // Act
        ticket.bookBtnAction(null);

        // Assert
        // Check if the admin domain window is opened
        assertEquals(false, ticket.getBookBtn().isEnabled());
        assertTrue(ticket.getBillObj().isVisible());
    }

    /**
     * Tests the unsuccessful booking of a ticket.
     *
     * @throws SQLException           If a SQL-related error occurs.
     * @throws ClassNotFoundException If the required class is not found.
     * @throws ParseException         If a parsing error occurs.
     */
    @Test
    public void testBookUnSuccessful() throws SQLException, ClassNotFoundException, ParseException {
        // Arrange
        ticket ticket = new ticket();
        ticket.setConnection(mockConnection);
        ticket.getTxtticketno().setText("mockID");
        ticket.getFlightno().setText("MockFlightId");
        ticket.setFlightname("MockFlightName");
        ticket.getTxtcustid().setText("MockCusID");
        ticket.getTxtfirstname().setText("MockName");
        ticket.getTxtlastname().setText("MockName");
        ticket.getTxtpassport().setText("MockID");
        ticket.getTxtclass().setSelectedItem("MockClass");
        ticket.getTxtseats().setValue(0);
        ticket.setPrice(0);
        ticket.getTxtprice().setText("mockPrice");
        ticket.setDepartTime("MockTime");
        ticket.setArrivaltime("MockTime");
        ticket.setSourceCity("mockCity");
        ticket.setDepartCity("mockCity");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2024-12-13";
        java.util.Date utilDate = dateFormat.parse(dateString);
        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        ticket.getTxtdate().setDate(sqlDate);

        // Act
        ticket.bookBtnAction(null);

        // Assert
        // Check if the admin domain window is opened
        assertFalse(ticket.getBillObj().isVisible());
    }

    /**
     * Tests the update of the destination dropdown based on the selected source.
     */
    @Test
    public void testupdateDestinationDropdown() {
        ticket ticket = new ticket();
        ticket.getTxtsource().setSelectedItem("Pakistan");

        // act
        ticket.updateDestinationDropdown();

        // assert
        assertEquals(5, ((ticket.getTxtdepart()).getItemCount()));
        assertFalse(itemExistsInComboBox(ticket.getTxtdepart(), "Pakistan"));

        // Check if the non-selected sources are present in the destination dropdown
        assertTrue(itemExistsInComboBox(ticket.getTxtdepart(), "Srilanka"));
        assertTrue(itemExistsInComboBox(ticket.getTxtdepart(), "Uk"));
        assertTrue(itemExistsInComboBox(ticket.getTxtdepart(), "Usa"));
        assertTrue(itemExistsInComboBox(ticket.getTxtdepart(), "Canada"));
        assertTrue(itemExistsInComboBox(ticket.getTxtdepart(), "China"));
    }

    /**
     * Helper method to check if an item exists in a JComboBox.
     *
     * @param comboBox The JComboBox to check.
     * @param item     The item to search for.
     * @return True if the item exists, false otherwise.
     */
    private boolean itemExistsInComboBox(JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tests the method to disable past dates in the date chooser component.
     *
     * @throws ParseException If a parsing error occurs.
     */
    @Test
    public void testDisablePastDates() throws ParseException {

        ticket ticket = new ticket();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2023-12-13";
        java.util.Date utilDate = dateFormat.parse(dateString);
        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        ticket.getTxtdate().setDate(sqlDate);

        // Call the method to be tested
        ticket.disablePastDates(ticket.getTxtdate());
        LocalDate currentDate = LocalDate.now();
        LocalDate ticketDate = ticket.getTxtdate().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Verify that the date was reset to the current date
        assertEquals(currentDate, ticketDate);
    }

    /**
     * Tests the back button action.
     */
    @Test
    public void testBackBtnAction() {
        // Action: Call the back button action
        ticket.backBtnAction(null);

        // After the action, check if the adminDomainObj window is visible
        assertTrue(ticket.getCusDomainObj().isVisible());
    }

}