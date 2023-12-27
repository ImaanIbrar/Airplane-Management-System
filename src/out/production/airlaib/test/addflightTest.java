package out.production.airlaib.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.event.KeyEvent;


import out.production.airlaib.addflight;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * JUnit test class for the addflight class.
 * Author: Imaan Ibrar
 *
 * Testing strategy:
 * - Partition the inputs for testSuccessfulFlightAddition:
 *   - Set valid values for all input fields.
 *   - Verify that the "Add" button is disabled after the action.
 *
 * - Partition the inputs for testUnsuccessfulFlightAddition:
 *   - Set invalid values for one or more input fields (e.g., non-numeric charge).
 *   - Verify that the "Add" button remains enabled after the action.
 *
 * - Test the back button action:
 *   - Call the back button action.
 *   - Verify that the adminDomainObj window is visible after the action.
 *
 * - Test key released events:
 *   - Test the key released event for departure time:
 *     - Set a valid departure time.
 *     - Verify that the warning label for departure time is null after the action.
 *   - Test the key released event for arrival time:
 *     - Set a valid arrival time.
 *     - Verify that the warning label for arrival time is null after the action.
 *   - Test the key released event for flight charge:
 *     - Set a valid flight charge.
 *     - Verify that the warning label for flight charge is null after the action.
 *
 * - Additional considerations:
 *   - Mock the behavior of the database connection, statement, and result set for various scenarios.
 *   - Test with SQL exceptions to ensure proper exception handling.
 */
public class addflightTest {

    private Connection mockConnection;
    private addflight addFlight;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;
 /**
     * Setup method to initialize mocks and set up the class for testing.
     *
     * @throws SQLException if a SQL exception occurs
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

        // Set up the class
        addFlight = new addflight();
        addFlight.setConnection(mockConnection);
    }
/**
     * Tear down method to close the mock connection after each test.
     *
     * @throws SQLException if a SQL exception occurs
     */
    @After
    public void tearDown() throws SQLException {
        // Close the mock connection after each test
        if (mockConnection != null) {
            mockConnection.close();
        }
    }

 /**
     * Test for successful flight addition.
     *
     * @throws SQLException if a SQL exception occurs
     */
    @Test
    public void testSuccessfulFlightAddition() throws SQLException {
    	addFlight.setConnection(mockConnection);

        // Set initial values using setText method
        addFlight.getFlightIdText().setText("FO037");
        addFlight.getFlightNameText().setText("Test Flight");
        addFlight.getSourceText().setSelectedItem("Pakistan");
        addFlight.getDepartureText().setSelectedItem("Uk");
        addFlight.getDepartureTimeText().setText("12:00");
        addFlight.getArrivalTimeText().setText("14:00");
        addFlight.getFlightChargeText().setText("50000");
        

        // Action
        addFlight.AddBtnAction(null);

        // After the action, the button should be disabled
        System.out.println("After Action: Is Button Enabled: " + addFlight.getAddBtn().isEnabled());
        
        // Check the state after the action
        assertFalse("Button should be disabled after action", addFlight.getAddBtn().isEnabled());
    }
 /**
     * Test for unsuccessful flight addition.
     *
     * @throws SQLException if a SQL exception occurs
     */
    @Test
    public void testUnsuccessfulFlightAddition() throws SQLException {
    	addFlight.setConnection(mockConnection);
    	 // Set initial values using setText method
        addFlight.getFlightIdText().setText("FO038");
        addFlight.getFlightNameText().setText("Test Flight");
        addFlight.getSourceText().setSelectedItem("Pakistan");
        addFlight.getDepartureText().setSelectedItem("Uk");
        addFlight.getDepartureTimeText().setText("12:00");
        addFlight.getArrivalTimeText().setText("14:00");
        addFlight.getFlightChargeText().setText("abc");

        addFlight.AddBtnAction(null);

        assertTrue(addFlight.getAddBtn().isEnabled());
    }
    /**
     * Test for back button action.
     */
    @Test
    public void testBackBtnAction() {
        // Action: Call the back button action
        addFlight.backBtnAction(null);

        // After the action, check if the adminDomainObj window is visible
        assertTrue("Admin Domain window should be visible after back button action", addFlight.getAdminDomainObj().isVisible());
    }
 /**
     * Test for departure time key released.
     */

    @Test
    public void testTxtdtimeKeyReleased() {
        // Set initial values
        addFlight.getDepartureTimeText().setText("12:00");

        // Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addFlight.txtdtimeKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNull(addFlight.getWarningDepartureTime().getText()); // Assuming you have a method to get the warning label
    }
/**
     * Test for arrival time key released.
     */
    @Test
    public void testTxtarrtimeKeyReleased() {
        // Set initial values using setText method
        addFlight.getArrivalTimeText().setText("14:00");

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addFlight.txtarrtimeKeyReleased(mockKeyEvent);

        // After the action, check the state
        assertNull("Warning label for arrival time should be null after action", addFlight.getWarningArrivalTime().getText());
    }

    /**
     * Test for flight charge key released.
     */
    @Test
    public void testTxtflightchargeKeyReleased() {
        // Set initial values using setText method
        addFlight.getFlightChargeText().setText("50000");

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addFlight.txtflightchargeKeyReleased(mockKeyEvent);

        // After the action, check the state
        assertNull("Warning label for flight charge should be null after action", addFlight.getWarningFlightCharge().getText());
    }

}
