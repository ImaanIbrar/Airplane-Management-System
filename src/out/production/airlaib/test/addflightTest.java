/**
 * JUnit test class for the addflight class.
 * Author: Imaan Ibrar
 */
package out.production.airlaib.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.event.KeyEvent;

import out.production.airlaib.addflight;

import static org.mockito.Mockito.mock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Test class for the addflight class.
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
        // ... (unchanged code)
    }

    /**
     * Test for unsuccessful flight addition.
     *
     * @throws SQLException if a SQL exception occurs
     */
    @Test
    public void testUnsuccessfulFlightAddition() throws SQLException {
        // ... (unchanged code)
    }

    /**
     * Test for back button action.
     */
    @Test
    public void testBackBtnAction() {
        // ... (unchanged code)
    }

    /**
     * Test for departure time key released.
     */
    @Test
    public void testTxtdtimeKeyReleased() {
        // ... (unchanged code)
    }

    /**
     * Test for arrival time key released.
     */
    @Test
    public void testTxtarrtimeKeyReleased() {
        // ... (unchanged code)
    }

    /**
     * Test for flight charge key released.
     */
    @Test
    public void testTxtflightchargeKeyReleased() {
        // ... (unchanged code)
    }

}
