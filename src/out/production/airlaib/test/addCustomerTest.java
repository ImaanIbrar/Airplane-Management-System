package out.production.airlaib.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import out.production.airlaib.addCustomer;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/** 
  JUnit test class for the {@code addCustomer} class.
 * Author: Laiba Atiq
 * 
 * Testing strategy for addCustomerTest class:
 *
 * The primary goal of the addCustomerTest is to verify the functionality of the addCustomer class,
 * focusing on methods like autoID, browseBtnAction, addCustomerBtnAction, cancelBtnAction, and keyReleased methods.
 *
 * Test cases:
 *
 * 1. **testAutoID:**
 *    - Description: Test for the autoID method.
 *    - Steps:
 *        - Call the autoID method.
 *    - Expected Result: The autoID method should generate a non-null auto-generated ID for the customer.
 *
 * 2. **testBrowseBtnAction:**
 *    - Description: Test for the browseBtnAction method.
 *    - Steps:
 *        - Call the browseBtnAction method with a mock ActionEvent.
 *    - Expected Result: The browseBtnAction method should set the user image to a non-null value after the action.
 *
 * 3. **testAddCustomerBtnAction_Successful:**
 *    - Description: Test for the addCustomerBtnAction method with successful execution.
 *    - Steps:
 *        - Set initial values for the customer fields.
 *        - Call the addCustomerBtnAction method.
 *    - Expected Result: The addCustomerBtnAction method should disable the button after successful execution.
 *
 * 4. **testAddCustomerBtnAction_Unsuccessful:**
 *    - Description: Test for the addCustomerBtnAction method with unsuccessful execution.
 *    - Steps:
 *        - Set initial values for the customer fields that would cause validation errors.
 *        - Call the addCustomerBtnAction method.
 *    - Expected Result: The addCustomerBtnAction method should not disable the button after unsuccessful execution.
 *
 * 5. **testCancelBtnAction:**
 *    - Description: Test for the cancelBtnAction method.
 *    - Steps:
 *        - Call the cancelBtnAction method with a mock ActionEvent.
 *    - Expected Result: The cancelBtnAction method should make the cusDomainObj window visible after the action.
 *
 * 6. **testTxtfirstnameKeyReleased_Valid:**
 *    - Description: Test for the txtfirstnameKeyReleased method with valid input.
 *    - Steps:
 *        - Set a valid first name.
 *        - Call the txtfirstnameKeyReleased method with a mock KeyEvent.
 *    - Expected Result: The warning label for the first name should be null after the action.
 *
 * 7. **testTxtfirstnameKeyReleased_Invalid:**
 *    - Description: Test for the txtfirstnameKeyReleased method with invalid input.
 *    - Steps:
 *        - Set an invalid first name.
 *        - Call the txtfirstnameKeyReleased method with a mock KeyEvent.
 *    - Expected Result: The warning label for an invalid first name should not be null after the action.
 *
 * 8. **testTxtLastNameKeyReleased_Valid:**
 *    - Description: Test for the txtLastNameKeyReleased method with valid input.
 *    - Steps:
 *        - Set a valid last name.
 *        - Call the txtLastNameKeyReleased method with a mock KeyEvent.
 *    - Expected Result: The warning label for the last name should be null after the action.
 *
 * 9. **testTxtLastNameKeyReleased_Invalid:**
 *    - Description: Test for the txtLastNameKeyReleased method with invalid input.
 *    - Steps:
 *        - Set an invalid last name.
 *        - Call the txtLastNameKeyReleased method with a mock KeyEvent.
 *    - Expected Result: The warning label for an invalid last name should not be null after the action.
 *
 * 10. **testTxtpassportKeyReleased_Valid:**
 *    - Description: Test for the txtpassportKeyReleased method with valid input.
 *    - Steps:
 *        - Set a valid passport ID.
 *        - Call the txtpassportKeyReleased method with a mock KeyEvent.
 *    - Expected Result: The warning label for the passport should be null after the action.
 *
 * 11. **testTxtpassportKeyReleased_Invalid:**
 *    - Description: Test for the txtpassportKeyReleased method with invalid input.
 *    - Steps:
 *        - Set an invalid passport ID.
 *        - Call the txtpassportKeyReleased method with a mock KeyEvent.
 *    - Expected Result: The warning label for an invalid passport should not be null after the action.
 *
 * 12. **testTxtCnicKeyReleased_Valid:**
 *    - Description: Test for the txtCnicKeyReleased method with valid input.
 *    - Steps:
 *        - Set a valid CNIC.
 *        - Call the txtCnicKeyReleased method with a mock KeyEvent.
 *    - Expected Result: The warning label for the CNIC should be null after the action.
 *
 * 13. **testTxtCnicKeyReleased_Invalid:**
 *    - Description: Test for the txtCnicKeyReleased method with invalid input.
 *    - Steps:
 *        - Set an invalid CNIC.
 *        - Call the txtCnicKeyReleased method with a mock KeyEvent.
 *    - Expected Result: The warning label for an invalid CNIC should not be null after the action.
 *
 * 14. **testTxtcontactKeyReleased_Valid:**
 *    - Description: Test for the txtcontactKeyReleased method with valid input.
 *    - Steps:
 *        - Set a valid contact number.
 *        - Call the txtcontactKeyReleased method with a mock KeyEvent.
 *    - Expected Result: The warning label for the contact should be null after the action.
 *
 * 15. **testTxtcontactKeyReleased_Invalid:**
 *    - Description: Test for the txtcontactKeyReleased method with invalid input.
 *    - Steps:
 *        - Set an invalid contact number.
 *        - Call the txtcontactKeyReleased method with a mock KeyEvent.
 *    - Expected Result: The warning label for an invalid contact should not be null after the action.
 */

public class addCustomerTest {

    private Connection mockConnection;
    private addCustomer addCustomer;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    /**
     * Set up the test environment.
     *
     * @throws SQLException if there is an issue with the database connection.
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
        addCustomer = new addCustomer();
        addCustomer.setConnection(mockConnection);
    }

    /**
     * Tear down the test environment.
     *
     * @throws SQLException if there is an issue closing the database connection.
     */
    @After
    public void tearDown() throws SQLException {
        // Close the mock connection after each test
        if (mockConnection != null) {
            mockConnection.close();
        }
    }

    /**
     * Test for the autoID method.
     *
     * @throws SQLException if there is an issue with the database interaction.
     */
    @Test
    public void testAutoID() throws SQLException {
        // Your test for the autoID method
        addCustomer.autoID();

        // Assert any relevant behavior or state changes
        assertNotNull("Auto-generated ID should not be null", addCustomer.getIdText().getText());
    }

    /**
     * Test for the browseBtnAction method.
     */
    @Test
    public void testBrowseBtnAction() {
        // Action: Call the browse button action
        ActionEvent mockActionEvent = Mockito.mock(ActionEvent.class);
        addCustomer.browseBtnAction(mockActionEvent);

        // Assert any relevant behavior or state changes
        assertNotNull("User image should not be null after browse button action", addCustomer.getUserImage());
    }

    /**
     * Test for the addCustomerBtnAction method with successful execution.
     *
     * @throws SQLException if there is an issue with the database interaction.
     */
    @Test
    public void testAddCustomerBtnAction_Successful() throws SQLException {
        // Set initial values using setText method
        addCustomer.getIdText().setText("CS001");
        addCustomer.getFirstNameText().setText("John");
        addCustomer.getLastNameText().setText("Doe");
        addCustomer.getCnicText().setText("12345-6789012-3");
        addCustomer.getPassportText().setText("AB1234567");
        addCustomer.getAddressText().setText("123 Main St");
        addCustomer.getContactText().setText("1234-5678901");
        addCustomer.getDateOfBirthText().setDate(new java.util.Date());
        addCustomer.getMaleRadioBtn().setSelected(true);

        // Action
        addCustomer.addCustomerBtnAction(null);

        // After the action, check the state
        assertFalse("Button should be disabled after successful action", addCustomer.getAddBtn().isEnabled());
    }

    /**
     * Test for the addCustomerBtnAction method with unsuccessful execution.
     *
     * @throws SQLException if there is an issue with the database interaction.
     */
    @Test
    public void testAddCustomerBtnAction_Unsuccessful() throws SQLException {
        // Set initial values using setText method
        addCustomer.getIdText().setText("CS002");
        addCustomer.getFirstNameText().setText("John");
        addCustomer.getLastNameText().setText("Doe");
        addCustomer.getCnicText().setText("12345-6789012-3");
        addCustomer.getPassportText().setText("InvalidPassport"); // Causing validation error
        addCustomer.getAddressText().setText("123 Main St");
        addCustomer.getContactText().setText("InvalidContact"); // Causing validation error
        addCustomer.getDateOfBirthText().setDate(new java.util.Date());
        addCustomer.getMaleRadioBtn().setSelected(true);

        // Action
        addCustomer.addCustomerBtnAction(null);

        // After the action, check the state
        assertFalse("Button should be enabled after unsuccessful action", addCustomer.getAddBtn().isEnabled());
    }

    /**
     * Test for the cancelBtnAction method.
     */
    @Test
    public void testCancelBtnAction() {
        // Action: Call the cancel button action
        ActionEvent mockActionEvent = Mockito.mock(ActionEvent.class);
        addCustomer.cancelBtnAction(mockActionEvent);

        // After the action, check if the cusDomainObj window is visible
        assertTrue("cusDomainObj window should be visible after cancel button action", addCustomer.getCusDomainObj().isVisible());
    }

    /**
     * Test for the txtfirstnameKeyReleased method with valid input.
     */
    @Test
    public void testTxtfirstnameKeyReleased_Valid() {
        // Set initial values using setText method
        addCustomer.getFirstNameText().setText("John");

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addCustomer.txtfirstnameKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNull("Warning label for first name should be null after action", addCustomer.getWarningFirstName().getText());
    }

    /**
     * Test for the txtfirstnameKeyReleased method with invalid input.
     */
    @Test
    public void testTxtfirstnameKeyReleased_Invalid() {
        // Set initial values using setText method
        addCustomer.getFirstNameText().setText("123"); // Invalid first name

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addCustomer.txtfirstnameKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNotNull("Warning label for invalid first name should not be null after action", addCustomer.getWarningFirstName().getText());
    }

    /**
     * Test for the txtLastNameKeyReleased method with valid input.
     */
    @Test
    public void testTxtLastNameKeyReleased_Valid() {
        // Set initial values using setText method
        addCustomer.getLastNameText().setText("Doe");

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addCustomer.txtLastNameKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNull("Warning label for last name should be null after action", addCustomer.getWarningLastName().getText());
    }

    /**
     * Test for the txtLastNameKeyReleased method with invalid input.
     */
    @Test
    public void testTxtLastNameKeyReleased_Invalid() {
        // Set initial values using setText method
        addCustomer.getLastNameText().setText("123"); // Invalid last name

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addCustomer.txtLastNameKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNotNull("Warning label for invalid last name should not be null after action", addCustomer.getWarningLastName().getText());
    }

    /**
     * Test for the txtpassportKeyReleased method with valid input.
     */
    @Test
    public void testTxtpassportKeyReleased_Valid() {
        // Set initial values using setText method
        addCustomer.getPassportText().setText("AB1234567");

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addCustomer.txtpassportKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNull("Warning label for passport should be null after action", addCustomer.getWarningPassportId().getText());
    }

    /**
     * Test for the txtpassportKeyReleased method with invalid input.
     */
    @Test
    public void testTxtpassportKeyReleased_Invalid() {
        // Set initial values using setText method
        addCustomer.getPassportText().setText("InvalidPassport");

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addCustomer.txtpassportKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNotNull("Warning label for invalid passport should not be null after action", addCustomer.getWarningPassportId().getText());
    }

    /**
     * Test for the txtCnicKeyReleased method with valid input.
     */
    @Test
    public void testTxtCnicKeyReleased_Valid() {
        // Set initial values using setText method
        addCustomer.getCnicText().setText("12345-6789012-3");

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addCustomer.txtCnicKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNull("Warning label for CNIC should be null after action", addCustomer.getWarningCNIC().getText());
    }

    /**
     * Test for the txtCnicKeyReleased method with invalid input.
     */
    @Test
    public void testTxtCnicKeyReleased_Invalid() {
        // Set initial values using setText method
        addCustomer.getCnicText().setText("InvalidCNIC");

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addCustomer.txtCnicKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNotNull("Warning label for invalid CNIC should not be null after action", addCustomer.getWarningCNIC().getText());
    }

    /**
     * Test for the txtcontactKeyReleased method with valid input.
     */
    @Test
    public void testTxtcontactKeyReleased_Valid() {
        // Set initial values using setText method
        addCustomer.getContactText().setText("1234-5678901");

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addCustomer.txtcontactKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNull("Warning label for contact should be null after action", addCustomer.getWarningContact().getText());
    }

    /**
     * Test for the txtcontactKeyReleased method with invalid input.
     */
    @Test
    public void testTxtcontactKeyReleased_Invalid() {
        // Set initial values using setText method
        addCustomer.getContactText().setText("InvalidContact");

        // Action: Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        addCustomer.txtcontactKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNotNull("Warning label for invalid contact should not be null after action", addCustomer.getWarningContact().getText());
    }
}
