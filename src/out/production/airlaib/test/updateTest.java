package out.production.airlaib.test;
import out.production.airlaib.cusdomain;
import out.production.airlaib.ticket;
import out.production.airlaib.update;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.swing.JComboBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 *  JUnit test class for the {@link update} class.
 *
 * @author Marriam Naeem
 * @author Imaan Ibrar
 * @version 1.0
 * @since 2023-25-12
 *
 * Testing Strategy:
 *
 * - searchExistingTicketButtonActionPerformed:
 *   - Provide a valid ticket ID.
 *   - Ensure that the displayed ticket details match the expected values.
 *
 * - updateButtonActionPerformed (Successful Update):
 *   - Provide valid data for updating a ticket.
 *   - Verify that the update is successful.
 *   - Ensure that the billing window is opened.
 *
 * - updateButtonActionPerformed (Unsuccessful Update):
 *   - Provide invalid or incomplete data for updating a ticket.
 *   - Verify that the update fails.
 *   - Ensure that the billing window is not opened.
 *
 * - backButtonActionPerformed:
 *   - Test the action of the "Back" button.
 *   - Verify that the update window is closed, and the customer domain window is visible.
 *
 * - updateDestinationDropdown:
 *   - Test the update of the destination dropdown based on the selected source.
 *   - Ensure that the destination dropdown is updated correctly for different source selections.
 *
 * - disablePastDates:
 *   - Test the method to disable past dates in the date chooser component.
 *   - Provide a past date and verify that it is disabled.
 *   - Provide a current or future date and ensure it remains enabled.
 *
 * - Additional considerations:
 *   - Mock the behavior of the database connection, statement, and result set for various scenarios.
 *   - Test with SQL exceptions to ensure proper exception handling.
 *   - Check boundary cases for the ticket data, such as maximum and minimum values.
 *   - Ensure proper handling of edge cases, such as empty or null values.
 *   - Verify that appropriate warning messages are displayed for invalid inputs.
 *   - Test the behavior when the ticket ID provided for updating does not exist.
 */

public class updateTest {

    private Connection mockConnection;
    private update update;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    /**
     * Set up the test environment before each test method.
     *
     * @throws SQLException If a SQL exception occurs.
     */
    @Before
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);

        
    }
    
    /**
     * Tear down the test environment after each test method.
     *
     * @throws SQLException If a SQL exception occurs.
     */
    @After
    public void tearDown() throws SQLException {
        if (mockConnection != null) {
            mockConnection.close();
        }
    }
    
    /**
     * Test case for the {@code searchExistingTicketButtonActionPerformed} method.
     *
     * @throws SQLException           If a SQL exception occurs.
     * @throws ClassNotFoundException If the specified class cannot be found.
     */
    @Test
    public void testsearchExistingTicketButtonActionPerformed() throws SQLException, ClassNotFoundException {
    	
    	update update = new update();
        update.setConnection(mockConnection);
        // Arrange
        update.getTxtticketid().setText("TO003");

        // Act
        update.searchExistingTicketActionPerformed(null);

        // Verify that the ticket details are correctly displayed on the UI
        assertEquals("Maryam", update.getTxtfirstname().getText());
        assertEquals("Naeem", update.getTxtlastname().getText());
        assertEquals("123456789", update.getTxtpassport().getText());
    }

    /**
     * Test case for the {@code updateButtonActionPerformed} method.
     *
     * @throws SQLException           If a SQL exception occurs.
     * @throws ClassNotFoundException If the specified class cannot be found.
     * @throws ParseException         If a parsing exception occurs.
     */
    @Test
    public void testupdateSuccesssful() throws SQLException, ClassNotFoundException, ParseException {
    	
    	update update = new update();
        update.setConnection(mockConnection);
        // Arrange
        update.getTxtticketid().setText("TO004");

        // Act
        update.searchExistingTicketActionPerformed(null);
        // Arrange
        update.getTxtfirstname().setText("Imaan");
        update.getTxtlastname().setText("Ibrar");
        update.getTxtpassport().setText("123456987");

        update.getTxtclass().setSelectedItem("Economy");
        
        update.getTxtseats().setValue(2);
        update.setPrice(50000);
        update.txtclassStateChanged(null);
        update.txtseatsStateChanged(null);
        update.setDepartTime("8.00AM");
        update.setArrivaltime("10.00PM");
        update.setSourceCity("Pakistan");
        update.setDepartCity("Uk");
        update.getFlightno().setText("FO004");
        update.setFlightname("JetLine");
        update.setCustid("CS002");
        

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2024-12-15";
        java.util.Date utilDate = dateFormat.parse(dateString);
        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        update.getTxtdate().setDate(sqlDate);

        // Act
        update.updateButtenActionPerformed(null);


        // Verify that the ticket is updated and a confirmation message is shown
        // Verify that the billing window is opened
        assertTrue(update.getB1().isVisible());
    }
    
    /**
     * Test case for the {@code updateButtenActionPerfomed} method.
     *
     * @throws SQLException           If a SQL exception occurs.
     * @throws ClassNotFoundException If the specified class cannot be found.
     * @throws ParseException         If a parsing exception occurs.
     */
    @Test
    public void testupdateButtenUnsuccessful() throws SQLException, ClassNotFoundException, ParseException {
    	
    	update update = new update();
        update.setConnection(mockConnection);
        // Arrange
        update.getTxtticketid().setText("mockID");

        // Act
        update.searchExistingTicketActionPerformed(null);
        // Arrange
        update.getTxtfirstname().setText("MockName");
        update.getTxtlastname().setText("MockName");
        update.getTxtpassport().setText("MockID");

        update.getTxtclass().setSelectedItem("MockClass");
        
        update.getTxtseats().setValue(0);
        update.setPrice(0);
        
        update.setDepartTime("MockTime");
        update.setArrivaltime("MockTime");
        update.setSourceCity("mockCity");
        update.setDepartCity("mockCity");
        
        update.getFlightno().setText("FO004");
        update.setFlightname("JetLine");
        update.setCustid("CS002");
        

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2024-12-15";
        java.util.Date utilDate = dateFormat.parse(dateString);
        // Convert java.util.Date to java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        update.getTxtdate().setDate(sqlDate);

        // Act
        update.updateButtenActionPerformed(null);


        
        // Verify that the billing window is Null
        assertNull(update.getB1());
    }
    
    /**
     * Test case for the {@code backButtonActionPerformed} method.
     */
    @Test
    public void testBackButtonActionPerformed() {
	update = new update();
    
    	cusdomain mockCusDomain = new cusdomain();
        update.setC1(mockCusDomain);

        update.backButtonActionPerformed(null);

        assertTrue(update.getC1().isVisible());
    
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
}