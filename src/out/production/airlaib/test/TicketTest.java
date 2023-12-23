package out.production.airlaib.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import out.production.airlaib.ticket;

import static org.junit.Assert.assertEquals;
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

public class TicketTest {

    private Connection mockConnection;
    private ticket ticket;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;
   

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
        
        //declare object
        ticket = new ticket();
        ticket.setConnection(mockConnection);
        
    }

    @After
    public void tearDown() throws SQLException {
        // Close the mock connection after each test
        if (mockConnection != null) {
            mockConnection.close();
        }
    }
    
    @Test
    public void testAddSuccessful() throws SQLException, ClassNotFoundException, ParseException {
    	//Arrange 
        ticket ticket = new ticket();
        ticket.setConnection(mockConnection);
        ticket.getTxtticketno().setText("TO004");
        ticket.getFlightno().setText("FO035");
        ticket.setFlightname("Melanka");
        ticket.getTxtcustid().setText("CS002");
        ticket.getTxtfirstname().setText("Maryam");
        ticket.getTxtlastname().setText("Naeem");
        ticket.getTxtpassport().setText("123456789");
        ticket.getTxtclass().setToolTipText("Business");
        ticket.getTxtprice().setText("13500");
        ticket.getTxtseats().setValue(1);
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
        System.out.println(sqlDate);
        
        // Print information for debugging
        System.out.println("Before calling bookBtnAction - billObj visibility: " + ticket.getBillObj().isVisible());
      
     
        // Act
        ticket.bookBtnAction(null);
        
         // Print information for debugging
        System.out.println("After calling bookBtnAction - billObj visibility: " + ticket.getBillObj().isVisible());

        // Assert
        // Check if the admin domain window is opened
        assertEquals(false, ticket.getBookBtn().isEnabled());
        assertTrue(ticket.getBillObj().isVisible());
    }
}