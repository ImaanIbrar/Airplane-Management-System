package out.production.airlaib.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import out.production.airlaib.addflight;
import out.production.airlaib.searchCustomer;
import out.production.airlaib.ticketreport;
import out.production.airlaib.userCreation;
import out.production.airlaib.welcome;
import out.production.airlaib.admindomain;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
/**
 * Testing strategy for AdminDomainTest class:
 *
 * The primary goal of AdminDomainTest is to verify the functionality of the admindomain class,
 * specifically focusing on the addFlightBtnAction, searchCustomerBtnAction, generateTicketBtnAction,
 * logoutBtnAction, and createUserBtnAction methods.
 *
 * Test cases:
 *
 * 1. **testAddFlightBtnAction:**
 *    - Description: Tests the addFlightBtnAction method of the admindomain class.
 *    - Steps:
 *        - Set up the mock addFlight window.
 *        - Call the addFlightBtnAction method.
 *        - Verify that the frame is hidden, addFlight window is shown, and the window is visible.
 *    - Expected Result: The addFlight window should be visible after calling the addFlightBtnAction method.
 *
 * 2. **testSearchCustomerBtnAction:**
 *    - Description: Tests the searchCustomerBtnAction method of the admindomain class.
 *    - Steps:
 *        - Set up the mock searchCustomer window.
 *        - Call the searchCustomerBtnAction method.
 *        - Verify that the frame is hidden, searchCustomer window is shown, and the window is visible.
 *    - Expected Result: The searchCustomer window should be visible after calling the searchCustomerBtnAction method.
 *
 * 3. **testGenerateTicketBtnAction:**
 *    - Description: Tests the generateTicketBtnAction method of the admindomain class.
 *    - Steps:
 *        - Set up the mock ticketReport window.
 *        - Call the generateTicketBtnAction method.
 *        - Verify that the frame is hidden, ticketReport window is shown, and the window is visible.
 *    - Expected Result: The ticketReport window should be visible after calling the generateTicketBtnAction method.
 *
 * 4. **testLogoutBtnAction:**
 *    - Description: Tests the logoutBtnAction method of the admindomain class.
 *    - Steps:
 *        - Set up the mock welcome window.
 *        - Call the logoutBtnAction method.
 *        - Verify that the frame is disposed, welcome window is shown, and the window is visible.
 *    - Expected Result: The welcome window should be visible after calling the logoutBtnAction method.
 *
 * 5. **testCreateUserBtnAction:**
 *    - Description: Tests the createUserBtnAction method of the admindomain class.
 *    - Steps:
 *        - Set up the mock userCreation window.
 *        - Call the createUserBtnAction method.
 *        - Verify that the frame is disposed, userCreation window is shown, and the window is visible.
 *    - Expected Result: The userCreation window should be visible after calling the createUserBtnAction method.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class admindomainTest {

    @Mock
    private JFrame mockFrame;
    @Mock
    private addflight mockAddFlight;
    @Mock
    private searchCustomer mockSearchCustomer;
    @Mock
    private ticketreport mockTicketReport;
    @Mock
    private userCreation mockUserCreation;
    @Mock
    private welcome mockWelcome;
    private admindomain admindomain;
    
    /**
     * Set up mocks and initialize the {@code admindomain} object before each test.
     */
    @Before
    public void setUp() {
        mockFrame = mock(JFrame.class);
        mockAddFlight = mock(addflight.class);
        mockSearchCustomer = mock(searchCustomer.class);
        mockTicketReport = mock(ticketreport.class);
        mockUserCreation = mock(userCreation.class);
        mockWelcome = mock(welcome.class);
        admindomain = new admindomain();
        admindomain.setExtendedState(JFrame.MAXIMIZED_BOTH);
        admindomain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Reset mocks after each test.
     */
    @After
    public void tearDown() {
        reset(mockFrame, mockAddFlight, mockSearchCustomer, mockTicketReport, mockUserCreation, mockWelcome);
    }

    /**
     * Test the {@code addFlightBtnAction} method.
     * Verifies that the frame is hidden, addFlight window is shown, and the window is visible.
     */
    @Test
    public void testAddFlightBtnAction() {
        SwingUtilities.invokeLater(() -> {
            admindomain.setAddFlightObj(mockAddFlight);
            admindomain.addFlightBtnAction(mock(ActionEvent.class));
            verify(mockFrame).setVisible(false);
            verify(mockAddFlight).setVisible(true);
            assertTrue(admindomain.getAddFlightObj().isVisible());
        });
    }

    /**
     * Test the {@code searchCustomerBtnAction} method.
     * Verifies that the frame is hidden, searchCustomer window is shown, and the window is visible.
     */
    @Test
    public void testSearchCustomerBtnAction() {
        SwingUtilities.invokeLater(() -> {
            admindomain.setSearchCustomerObj(mockSearchCustomer);
            admindomain.searchCustomerBtnAction(mock(ActionEvent.class));
            verify(mockFrame).setVisible(false);
            verify(mockSearchCustomer).setVisible(true);
            assertTrue(admindomain.getSearchCustomerObj().isVisible());
        });
    }
    /**
     * Test the {@code generateTicketBtnAction} method.
     * Verifies that the frame is hidden, ticketReport window is shown, and the window is visible.
     */
    @Test
    public void testGenerateTicketBtnAction() {
        SwingUtilities.invokeLater(() -> {
            admindomain.setTicketReportObj(mockTicketReport);
            admindomain.generateTicketBtnAction(mock(ActionEvent.class));
            verify(mockFrame).setVisible(false);
            verify(mockTicketReport).setVisible(true);
            assertTrue(admindomain.getTicketReportObj().isVisible());
        });
    }

    /**
     * Test the {@code logoutBtnAction} method.
     * Verifies that the frame is disposed, welcome window is shown, and the window is visible.
     */
    @Test
    public void testLogoutBtnAction() {
        SwingUtilities.invokeLater(() -> {
            admindomain.setWelcomeObj(mockWelcome);
            admindomain.logoutBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockWelcome).setVisible(true);
            assertTrue(admindomain.getWelcomeObj().isVisible());
        });
    }

    /**
     * Test the {@code createUserBtnAction} method.
     * Verifies that the frame is disposed, userCreation window is shown, and the window is visible.
     */
    @Test
    public void testCreateUserBtnAction() {
        SwingUtilities.invokeLater(() -> {
            admindomain.setUserCreationObj(mockUserCreation);
            admindomain.createUserBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockUserCreation).setVisible(true);
            assertTrue(admindomain.getUserCreationObj().isVisible());
        });
    }
}
