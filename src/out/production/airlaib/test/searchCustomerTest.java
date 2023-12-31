package out.production.airlaib.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import out.production.airlaib.searchCustomer;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class searchCustomerTest {

    private Connection mockConnection;
    private searchCustomer searchCustomer;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    @Before
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Initialize the searchCustomer object with the mock connection
        searchCustomer = new searchCustomer();
        searchCustomer.setConnection(mockConnection);
    }

    @After
    public void tearDown() throws SQLException {
        if (mockConnection != null) {
            mockConnection.close();
        }
    }

    @Test
    public void testSearchBtnActionRecordFound() throws SQLException {
        // Arrange
        searchCustomer.getTxtCustomertId().setText("CS001");
        when(mockResultSet.next()).thenReturn(true); // Simulate record found in the database

        // Act
        searchCustomer.searchBtnAction(null);

        // Assert
        assertTrue(searchCustomer.getBrowseBtn().isEnabled());
        assertTrue(searchCustomer.getUpdateBtn().isEnabled());
        assertTrue(searchCustomer.getMaleRadioBtn().isEnabled());
        assertTrue(searchCustomer.getFemaleRadioBtn().isEnabled());
        assertTrue(searchCustomer.getTxtfirstname().isEditable());
        assertEquals("laiba", searchCustomer.getTxtfirstname().getText());
        assertEquals("atiq", searchCustomer.getTxtlastname().getText());
    }

    @Test
    public void testSearchBtnActionRecordNotFound() throws SQLException {
        // Arrange
        searchCustomer.getTxtCustomertId().setText("CS002");
        when(mockResultSet.next()).thenReturn(false); // Simulate no record found in the database

        // Act
        searchCustomer.searchBtnAction(null);

        // Assert
        assertFalse(searchCustomer.getBrowseBtn().isEnabled());
        assertFalse(searchCustomer.getUpdateBtn().isEnabled());
        assertFalse(searchCustomer.getMaleRadioBtn().isEnabled());
        assertFalse(searchCustomer.getFemaleRadioBtn().isEnabled());
        assertFalse(searchCustomer.getTxtfirstname().isEditable());

        // Additional assertions based on UI state
        assertNull(searchCustomer.getTxtfirstname().getText());
        assertNull(searchCustomer.getTxtlastname().getText());
        // Add more assertions based on your requirements
    }

    @Test
    public void testUpdateBtnActionSuccessfulUpdate() throws SQLException, ParseException {
        // Arrange
        searchCustomer.getTxtCustomertId().setText("CS001");
        when(mockResultSet.next()).thenReturn(true); // Simulate record found in the database

        // Set up the input data for the update
        searchCustomer.getTxtfirstname().setText("John");
        searchCustomer.getTxtlastname().setText("Doe");
        searchCustomer.getTxtCnic().setText("12345-6789101-1");
        searchCustomer.getTxtpassport().setText("ABCD12345");
        searchCustomer.getTxtaddress().setText("123 Main St");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("1990-01-01");
        searchCustomer.getTxtdob().setDate(date);
        searchCustomer.getMaleRadioBtn().setSelected(true);
        searchCustomer.getTxtcontact().setText("1234-5678901");

        // Act
        searchCustomer.updateBtnAction(null);

        // Assert
        assertEquals("John", searchCustomer.getTxtfirstname().getText());
        assertEquals("Doe", searchCustomer.getTxtlastname().getText());

    }

    @Test
    public void testUpdateBtnActionInvalidInput() throws SQLException {
        // Arrange
        searchCustomer.getTxtCustomertId().setText("CS001");
        when(mockResultSet.next()).thenReturn(true); // Simulate record found in the database

        // Set up invalid input data for the update
        searchCustomer.getTxtfirstname().setText("123"); // Invalid name
        searchCustomer.getTxtlastname().setText("Doe");
        searchCustomer.getTxtCnic().setText("invalid-cnic"); // Invalid CNIC format
        searchCustomer.getTxtpassport().setText("invalid-passport"); // Invalid passport format
        searchCustomer.getTxtaddress().setText("123 Main St");
        Calendar defaultDob = Calendar.getInstance();
        defaultDob.set(1990, Calendar.JANUARY, 1); // Adjust the year, month, and day as needed
        searchCustomer.getTxtdob().setDate(defaultDob.getTime());
        searchCustomer.getMaleRadioBtn().setSelected(false);
        searchCustomer.getFemaleRadioBtn().setSelected(false);
        searchCustomer.getTxtcontact().setText("invalid-contact"); // Invalid contact format

        // Act
        searchCustomer.updateBtnAction(null);

        // Assert
        assertNotEquals("123", searchCustomer.getTxtfirstname().getText());
    }

    @Test
    public void testBrowseBtnAction() throws SQLException {
        // Arrange
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        searchCustomer.getTxtCustomertId().setText("CS001");
        when(mockResultSet.next()).thenReturn(true); // Simulate record found in the database
        when(mockResultSet.getBlob("photo")).thenReturn(Mockito.mock(java.sql.Blob.class));
        when(mockResultSet.getBlob("photo").getBinaryStream()).thenReturn(inputStream);

        // Act
        searchCustomer.browseBtnAction(null);

        // Assert
        assertNotNull(searchCustomer.getUserimage()); // Ensure userimage is set
    }

}
