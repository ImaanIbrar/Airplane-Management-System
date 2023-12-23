package out.production.airlaib.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
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

import out.production.airlaib.bill;

/**
 * JUnit test class for the {@code bill} class.
 * Author: Laiba Atiq
 */
public class billTest {

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
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        when(mockResultSet.next()).thenReturn(true);
    }

    /**
     * Close the mock connection after each test.
     * 
     * @throws SQLException If a SQL exception occurs during teardown.
     */
    @After
    public void tearDown() throws SQLException {
        if (mockConnection != null) {
            mockConnection.close();
        }
    }

    /**
     * Test the {@code billprint} method when a record is found.
     * Verifies that the expected customer and ticket details are set.
     * 
     * @throws SQLException           If a SQL exception occurs during the test.
     * @throws ClassNotFoundException If a class is not found during the test.
     */
    @Test
    public void testBillPrintRecordFound() throws SQLException, ClassNotFoundException {
        // Arrange
        bill billInstance = new bill("CS003", "TO002");
        billInstance.setConnection(mockConnection);

        // Mock customer query result
        when(mockResultSet.getString("firstname")).thenReturn("Ahsan");
        when(mockResultSet.getString("lastname")).thenReturn("Sadaat");
        when(mockResultSet.getString("cnic")).thenReturn("17801-1234556-9");
        when(mockResultSet.getString("passport")).thenReturn("PK7890987");
        when(mockResultSet.getString("gender")).thenReturn("Male");

        // Mock ticket query result
        when(mockResultSet.getString("flightid")).thenReturn("FO008");
        when(mockResultSet.getString("flightname")).thenReturn("Melanka");
        when(mockResultSet.getString("departure_time")).thenReturn("9.00AM");
        when(mockResultSet.getString("seat_class")).thenReturn("Business");
        when(mockResultSet.getString("seat_count")).thenReturn("2");
        when(mockResultSet.getString("bill_amount")).thenReturn("45000");
        when(mockResultSet.getString("source_location")).thenReturn("Pakistan");
        when(mockResultSet.getString("destination_location")).thenReturn("Srilanka");

        // Act
        billInstance.billprint("CS003", "TO002");

        // Assert
        assertEquals("Ahsan", billInstance.getFNameTxt());
        assertEquals("Sadaat", billInstance.getLastNameText());
        assertEquals("CS003", billInstance.getCusIDLabel());
        assertEquals("FO008", billInstance.getFlightNoText());
        assertEquals("Melanka", billInstance.getFlightNameText());
        assertEquals("17801-1234556-9", billInstance.getCnic());
        assertEquals("PK7890987", billInstance.getPassport());
        assertEquals("Male", billInstance.getGen());
        assertEquals("9.00AM", billInstance.getDeparts());
        assertEquals("Business", billInstance.getSeatClass());
        assertEquals("45000", billInstance.getBill());
        assertEquals("2", billInstance.getSeatss());
        assertEquals("Pakistan", billInstance.getSources());
        assertEquals("Srilanka", billInstance.getDepartss());

    }

    /**
     * Test the {@code billprint} method when a record is not found.
     * Verifies that the expected error message is shown using JOptionPane.
     * 
     * @throws SQLException           If a SQL exception occurs during the test.
     * @throws ClassNotFoundException If a class is not found during the test.
     */
    @Test
    public void testBillPrintRecordNotFound() throws SQLException, ClassNotFoundException {
        // Arrange
        bill billInstance = new bill("nonexistentID", "nonexistentTicket");
        billInstance.setConnection(mockConnection);

        // Mock customer query result
        when(mockResultSet.next()).thenReturn(false);

        // Mock JOptionPane.showMessageDialog
        ArgumentCaptor<Object> messageCaptor = ArgumentCaptor.forClass(Object.class);
        Mockito.mockStatic(JOptionPane.class);
        doNothing().when(JOptionPane.class);
        JOptionPane.showMessageDialog(any(), messageCaptor.capture());

        // Act
        billInstance.billprint("nonexistentID", "nonexistentTicket");

        // Assert
        assertEquals("Record not Found", messageCaptor.getValue());
    }
}
