package out.production.airlaib.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.toedter.calendar.JDateChooser;

import out.production.airlaib.ticket;

import static org.mockito.Mockito.doNothing;


public class TicketTest {

    private static final int DefaultComboBoxModel = 0;
	private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;
    

/**
 * Creates a mocked JComboBox with specified items for testing purposes.
 *
 * @param items The items to be added to the mocked JComboBox.
 * @return A mocked JComboBox with the specified items.
 */
    private JComboBox<String> createComboBoxMock(String... items) {
        JComboBox<String> comboBoxMock = mock(JComboBox.class);
        when(comboBoxMock.getItemCount()).thenReturn(items.length);
        for (int i = 0; i < items.length; i++) {
            when(comboBoxMock.getItemAt(i)).thenReturn(items[i]);
        }
        return comboBoxMock;
    }



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
    public void testTxtclassStateChanged() {
        // Arrange
        ticket ticket = new ticket();
        ticket.setTxtprice(new javax.swing.JLabel());
        ticket.setTxtseats(new javax.swing.JSpinner());
        ticket.setTxtclass(createComboBoxMock("Business", "Economy"));

        // Act
        ticket.txtclassStateChanged(createActionEventMock());

        // Assert
        assertEquals("15000", ticket.getTxtprice().getText()); // Assuming initial price is 100
    }

    @Test
    public void testTxtseatsStateChanged() {
        // Arrange
        ticket ticket = new ticket();
        ticket.setTxtprice(new javax.swing.JLabel());
        ticket.setTxtseats(createSpinnerMock(5));
        ticket.setTxtclass(createComboBoxMock("Business", "Economy"));

        // Assert
        assertEquals("150", ticket.getTxtprice().getText()); // Assuming initial price is 100
    }

	@Test
    public void testDisablePastDates() {
        // Arrange
        ticket ticket = new ticket();
        JDateChooser dateChooser = mock(JDateChooser.class);

        // Act
        ticket.disablePastDates(dateChooser);

        // Assert
        // Verify that propertyChangeListener is added to the dateChooser
        Mockito.verify(dateChooser).addPropertyChangeListener(any(String.class), any());
    }

    @Test
    public void testSearchBtnActionRecordFound() throws SQLException {
        // Arrange
        ticket ticket = new ticket();
        ticket.setTxtcustid(new javax.swing.JTextField());
        ticket.setTxtfirstname(new javax.swing.JLabel());
        ticket.setTxtlastname(new javax.swing.JLabel());
        ticket.setTxtpassport(new javax.swing.JLabel());
        ticket.setTxtsource(createComboBoxMock("Source1", "Source2", "Source3"));
        ticket.setTxtdepart(new javax.swing.JComboBox<>());
        ticket.setSeachBtn(new javax.swing.JButton());
        ticket.setTxtdate(new JDateChooser());

        // Mocking database interaction
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("firstname")).thenReturn("John");
        when(mockResultSet.getString("lastname")).thenReturn("Doe");
        when(mockResultSet.getString("passport")).thenReturn("AB123456");

        // Act
        ticket.searchBtnAction(createActionEventMock());

        // Assert
        assertEquals("John", ticket.getTxtfirstname().getText());
        assertEquals("Doe", ticket.getTxtlastname().getText());
        assertEquals("AB123456", ticket.getTxtpassport().getText());
    }

    @Test
    public void testSearchBtnActionRecordNotFound() throws SQLException {
        // Arrange
        ticket ticket = new ticket();
        ticket.setTxtcustid(new javax.swing.JTextField());
        ticket.setSeachBtn(new javax.swing.JButton());

        // Mocking database interaction
        when(mockResultSet.next()).thenReturn(false);

        // Mocking JOptionPane.showMessageDialog
        ArgumentCaptor<Object> messageCaptor = ArgumentCaptor.forClass(Object.class);
        Mockito.mockStatic(JOptionPane.class);
        doNothing().when(JOptionPane.class);
        JOptionPane.showMessageDialog(any(), messageCaptor.capture());

        // Act
        ticket.searchBtnAction(createActionEventMock());

        // Assert
        assertEquals("Record not Found", messageCaptor.getValue());
    }

    @Test
    public void testCheckAvailableFlightBtnAction() throws SQLException {
        // Arrange
        ticket ticket = new ticket();
        ticket.setTxtsource(createComboBoxMock("Source1", "Source2", "Source3"));
        ticket.setTxtdepart(createComboBoxMock("Source1", "Source2", "Source3"));
        ticket.setTicketTable(new javax.swing.JTable());

        // Mocking database interaction
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("arrtime")).thenReturn("10:00 AM");
        when(mockResultSet.getString("flightname")).thenReturn("Flight1");
        when(mockResultSet.getString("deptime")).thenReturn("08:00 AM");
        when(mockResultSet.getString("source")).thenReturn("Source1");
        when(mockResultSet.getString("depart")).thenReturn("Source2");
        when(mockResultSet.getString("flightcharge")).thenReturn("100");

        // Act
        ticket.checkAvailableFlightBtnAction(createActionEventMock());

        // Assert
        assertEquals(1, ticket.getTicketTable().getRowCount());
    }

    @Test
    public void testFlightsTableMouseClicked() throws SQLException {
        // Arrange
        ticket ticket = new ticket();
        ticket.setTicketTable(new javax.swing.JTable());
        ticket.setFlightno(new javax.swing.JLabel());
        ticket.setFlightnamelabel(new javax.swing.JLabel());
        ticket.setTxtdept(new javax.swing.JLabel());
        ticket.setTxtprice(new javax.swing.JLabel());
        ticket.setTxtseats(new javax.swing.JSpinner());
        ticket.setTxtclass(createComboBoxMock("Business", "Economy"));
        ticket.setBookBtn(new javax.swing.JButton());

        // Mocking table selection
        when(mockResultSet.getString("id")).thenReturn("1");
        when(mockResultSet.getString("flightname")).thenReturn("Flight1");
        when(mockResultSet.getString("deptime")).thenReturn("08:00 AM");
        when(mockResultSet.getString("flightcharge")).thenReturn("100");

        // Act
        ticket.flightsTableMouseClicked(createMouseEventMock());

        // Assert
        assertEquals("1", ticket.getFlightno().getText());
        assertEquals("Flight1", ticket.getFlightnamelabel().getText());
        assertEquals("08:00 AM", ticket.getTxtdept().getText());
        assertEquals("100", ticket.getTxtprice().getText());
        assertEquals(true, ticket.getTxtseats().isEnabled());
        assertEquals(true, ticket.getTxtclass().isEnabled());
        assertEquals(true, ticket.getTxtclass().isEnabled());
        assertEquals(true, ticket.getTxtseats().isEnabled());
        assertEquals(true, ticket.getTxtclass().isEnabled());
        assertEquals(true, ticket.getBookBtn().isEnabled());
    }
    @Test
    public void testBookBtnAction() throws SQLException, ClassNotFoundException {
        // Arrange
        ticket ticket = new ticket();
        ticket.setTxtticketno(new javax.swing.JLabel());
        ticket.setFlightno(new javax.swing.JLabel());
        ticket.setTxtcustid(new javax.swing.JTextField());
        ticket.setTxtfirstname(new javax.swing.JLabel());
        ticket.setTxtlastname(new javax.swing.JLabel());
        ticket.setTxtpassport(new javax.swing.JLabel());
        ticket.setTxtclass(createComboBoxMock("Business", "Economy"));
        ticket.setTxtprice(new javax.swing.JLabel());
        ticket.setTxtseats(createSpinnerMock(3));
        ticket.setTxtdate(new JDateChooser());
        ticket.setConnection(mockConnection);

        // Mocking database interaction
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("MAX(id)")).thenReturn("TO002");

        // Mocking JOptionPane.showMessageDialog
        ArgumentCaptor<Object> messageCaptor = ArgumentCaptor.forClass(Object.class);
        Mockito.mockStatic(JOptionPane.class);
        doNothing().when(JOptionPane.class);
        JOptionPane.showMessageDialog(any(), messageCaptor.capture());

        // Act
        ticket.autoID();
        ticket.bookBtnAction(createActionEventMock());

        // Assert
        assertEquals("TO003", ticket.getTxtticketno().getText()); // Assuming initial ticket ID is TO002
        assertEquals("Ticket Booked", messageCaptor.getValue());
    }

    // Add more test cases for other methods as needed

    // Helper methods for creating mocks

    private JComboBox<String> createComboBoxMock1(String... items) {
        JComboBox<String> comboBoxMock = mock(JComboBox.class);
        when(comboBoxMock.getItemCount()).thenReturn(items.length);
        for (int i = 0; i < items.length; i++) {
            when(comboBoxMock.getItemAt(i)).thenReturn(items[i]);
        }
        return comboBoxMock;
    }

    private ActionEvent createActionEventMock() {
        return mock(ActionEvent.class);
    }

    private PropertyChangeEvent createChangeEventMock() {
        return mock(PropertyChangeEvent.class);
    }

    private MouseEvent createMouseEventMock() {
        return mock(MouseEvent.class);
    }

    private JSpinner createSpinnerMock(int value) {
        JSpinner spinnerMock = mock(JSpinner.class);
        when(spinnerMock.getValue()).thenReturn(value);
        return spinnerMock;
    }
}
