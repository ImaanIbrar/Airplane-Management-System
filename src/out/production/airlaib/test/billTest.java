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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import out.production.airlaib.bill;

public class billTest {

    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @Before
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        when(mockResultSet.next()).thenReturn(true);
    }

    @After
    public void tearDown() throws SQLException {
        if (mockConnection != null) {
            mockConnection.close();
        }
    }

    @Test
    public void testBillPrintRecordFound() throws SQLException, ClassNotFoundException {
        // Arrange
        bill billInstance = new bill("customerId", "ticketId");
        billInstance.setConnection(mockConnection);

        // Mock customer query result
        when(mockResultSet.getString("firstname")).thenReturn("John");
        when(mockResultSet.getString("lastname")).thenReturn("Doe");
        // ... (mock other customer details)

        // Mock ticket query result
        when(mockResultSet.getString("flightid")).thenReturn("FL001");
        when(mockResultSet.getString("flightname")).thenReturn("Example Airlines");
        // ... (mock other ticket details)

        // Act
        billInstance.billprint("customerId", "ticketId");

        // Assert
        assertEquals("FL001", ((JLabel) billInstance.getFlightNoText()).getText());
        assertEquals("Example Airlines", ((JLabel) billInstance.getFlightNameText()).getText());
        // Add more assertions based on your GUI components and the expected values
    }


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
