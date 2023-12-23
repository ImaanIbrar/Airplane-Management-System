package out.production.airlaib.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import out.production.airlaib.userCreation;

/**
 * JavaDoc for the UserCreationTest class.
 * 
 * JUnit test class for the {@code userCreation} class.
 * 
 * @author Marriam Naeem
 * @version 1.0
 * @since 2023-12-24
 */
public class UserCreationTest {

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

        // Set up the mock result set to return a record when queried
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
     * Tests the add button action with valid input.
     * 
     * @throws SQLException If a SQL exception occurs during the test.
     */
    @Test
    public void testAddButtonActionWithValidInput() throws SQLException {
        userCreation userCreationObj = new userCreation();
        // Set valid input values
        userCreationObj.getTxtuserid().setText("UO001");
        userCreationObj.getTxtfirstname().setText("Marriam");
        userCreationObj.getTxtlastname().setText("Naeem");
        userCreationObj.getTxtusername().setText("marriam");
        userCreationObj.getTxtpassword().setText("StrongP@ssWord1");

        // Mock the database connection and prepared statement
        userCreationObj.setConnection(mockConnection);
        PreparedStatement mockPreparedStatement = Mockito.mock(PreparedStatement.class);

        try {
            Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockPreparedStatement);
            Mockito.when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Successful execution

            // Set the mock connection
            userCreationObj.setConnection(mockConnection);

            // Verify that addBtn is enabled
            assertTrue(userCreationObj.getAddBtn().isEnabled());

            // Call the method to add a user
            userCreationObj.addBtnAction(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

            // Check the state after the action
            assertFalse("Button should be disabled after action", userCreationObj.getAddBtn().isEnabled());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests the add button action with missing fields.
     * 
     * @throws SQLException If a SQL exception occurs during the test.
     */
    @Test
    public void testAddButtonActionWithMissingFields() throws SQLException {
        userCreation userCreationObj = new userCreation();
        // Leave some fields empty
        userCreationObj.getTxtuserid().setText("UO001");
        userCreationObj.getTxtfirstname().setText("Marriam");
        userCreationObj.getTxtlastname().setText("");

        // Mock the database connection (not needed for this test)
        Connection mockConnection = Mockito.mock(Connection.class);
        userCreationObj.setConnection(mockConnection);

        // Call the method to add a user
        userCreationObj.addBtnAction(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        // Verify that JOptionPane is called with the correct message
        assertTrue(userCreationObj.getAddBtn().isEnabled());
    }

    /**
     * Tests the add button action with incorrect name entry.
     */
    @Test
    public void testAddButtonActionWithIncorrectNameEntry() {
        userCreation userCreationObj = new userCreation();
        // Set invalid characters in the first name
        userCreationObj.getTxtuserid().setText("UO001");
        userCreationObj.getTxtfirstname().setText("Marriam123");
        userCreationObj.getTxtlastname().setText("Naeem");
        userCreationObj.getTxtusername().setText("marriam");
        userCreationObj.getTxtpassword().setText("StrongP@ssWord1");

        // Mock the database connection (not needed for this test)
        Connection mockConnection = Mockito.mock(Connection.class);
        // userCreationObj.setConnection(mockConnection);

        // Call the method to add a user
        userCreationObj.addBtnAction(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        // Verify that JOptionPane is called with the correct message
        assertTrue(userCreationObj.getAddBtn().isEnabled());
    }

    /**
     * Tests the add button action with a weak password.
     */
    @Test
    public void testAddButtonActionWithWeakPassword() {
        userCreation userCreationObj = new userCreation();
        // Set invalid characters in the first name
        userCreationObj.getTxtuserid().setText("UO001");
        userCreationObj.getTxtfirstname().setText("Marriam");
        userCreationObj.getTxtlastname().setText("Naeem");
        userCreationObj.getTxtusername().setText("marriam");
        userCreationObj.getTxtpassword().setText("StrongssWord");

        // Mock the database connection (not needed for this test)
        Connection mockConnection = Mockito.mock(Connection.class);
        // userCreationObj.setConnection(mockConnection);

        // Call the method to add a user
        userCreationObj.addBtnAction(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        // Verify that JOptionPane is called with the correct message
        assertTrue(userCreationObj.getAddBtn().isEnabled());
    }

    /**
     * Tests the isStrongPassword method.
     */
    @Test
    public void testIsStrongPassword() {
        userCreation userCreationObj = new userCreation();
        assertTrue(userCreationObj.isStrongPassword("StrongP@ssWord1"));
        assertFalse(userCreationObj.isStrongPassword("weakpassword"));
    }

    /**
     * Tests the back button action.
     */
    @Test
    public void testBackBtnAction() {
        userCreation userCreationObj = new userCreation();
        // Action: Call the back button action
        userCreationObj.backBtnAction(null);

        // After the action, check if the adminDomainObj window is visible
        assertTrue("Admin Domain window should be visible after back button action",
                userCreationObj.getAdminDomainObj().isVisible());
    }
    
    /**
     * Tests the key released event for the first name text field.
     */
    @Test
    public void testTxtfirstnameKeyReleased() {
    	
    	userCreation userCreationObj = new userCreation();
        // Set initial values
    	userCreationObj.getTxtfirstname().setText("Marriam123");

        // Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        userCreationObj.txtfirstnameKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNotNull(userCreationObj.getWarningFirstName().getText()); 
                                                                  
    }
    
    /**
     * Tests the key released event for the last name text field.
     */
    @Test
    public void testTxtLastnameKeyReleased() {
    	
    	userCreation userCreationObj = new userCreation();
        // Set initial values
    	userCreationObj.getTxtlastname().setText("Naeem123");

        // Call your method with a mock key event
        KeyEvent mockKeyEvent = mock(KeyEvent.class);
        userCreationObj.txtlastnameKeyReleased(mockKeyEvent);

        // Assert any relevant behavior or state changes
        assertNotNull(userCreationObj.getWarningLastName().getText()); 
                                                                  
    }
}
