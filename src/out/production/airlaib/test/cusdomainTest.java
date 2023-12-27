package out.production.airlaib.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import out.production.airlaib.addCustomer;
import out.production.airlaib.cusdomain;
import out.production.airlaib.cancels;
import out.production.airlaib.ticket;
import out.production.airlaib.update;
import out.production.airlaib.viewTicket;
import out.production.airlaib.welcome;
import javax.swing.*;
import java.awt.event.ActionEvent;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
/**
 * 
 * * JUnit test class for the {@code cusdomain} class.
 * Author: Imaan
 * 
 * Testing strategy for CusDomainTest class:
 *
 * The primary goal of CusDomainTest is to verify the functionality of the cusdomain class,
 * specifically focusing on the makeBookingBtnAction, registerBtnAction, mainMenuBtnAction,
 * updateBookingBtnAction, cancelBookingBtnAction, and viewTicketBtnAction methods.
 *
 * Test cases:
 *
 * 1. **testMakeBookingBtnAction:**
 *    - Description: Tests the makeBookingBtnAction method of the cusdomain class.
 *    - Steps:
 *        - Set up the mock ticket window.
 *        - Call the makeBookingBtnAction method.
 *        - Verify that the frame is disposed, ticket window is shown, and the window is visible.
 *    - Expected Result: The ticket window should be visible after calling the makeBookingBtnAction method.
 *
 * 2. **testRegisterBtnAction:**
 *    - Description: Tests the registerBtnAction method of the cusdomain class.
 *    - Steps:
 *        - Set up the mock addCustomer window.
 *        - Call the registerBtnAction method.
 *        - Verify that the frame is disposed, addCustomer window is shown, and the window is visible.
 *    - Expected Result: The addCustomer window should be visible after calling the registerBtnAction method.
 *
 * 3. **testMainMenuBtnAction:**
 *    - Description: Tests the mainMenuBtnAction method of the cusdomain class.
 *    - Steps:
 *        - Set up the mock welcome window.
 *        - Call the mainMenuBtnAction method.
 *        - Verify that the frame is disposed, welcome window is shown, and the window is visible.
 *    - Expected Result: The welcome window should be visible after calling the mainMenuBtnAction method.
 *
 * 4. **testUpdateBookingBtnAction:**
 *    - Description: Tests the updateBookingBtnAction method of the cusdomain class.
 *    - Steps:
 *        - Set up the mock update window.
 *        - Call the updateBookingBtnAction method.
 *        - Verify that the frame is disposed, update window is sized and shown, and the window is visible.
 *    - Expected Result: The update window should be visible after calling the updateBookingBtnAction method.
 *
 * 5. **testCancelBookingBtnAction:**
 *    - Description: Tests the cancelBookingBtnAction method of the cusdomain class.
 *    - Steps:
 *        - Set up the mock cancels window.
 *        - Call the cancelBookingBtnAction method.
 *        - Verify that the frame is disposed, cancels window is shown, and the window is visible.
 *    - Expected Result: The cancels window should be visible after calling the cancelBookingBtnAction method.
 *
 * 6. **testViewTicketBtnAction:**
 *    - Description: Tests the viewTicketBtnAction method of the cusdomain class.
 *    - Steps:
 *        - Set up the mock viewTicket window.
 *        - Call the viewTicketBtnAction method.
 *        - Verify that the frame is disposed, viewTicket window is shown, and the window is visible.
 *    - Expected Result: The viewTicket window should be visible after calling the viewTicketBtnAction method.
 */

@RunWith(MockitoJUnitRunner.class)
public class cusdomainTest {

    @Mock
    private JFrame mockFrame;
    @Mock
    private ticket mockTicket;
    @Mock
    private addCustomer mockAddCustomer;
    @Mock
    private welcome mockWelcome;
    @Mock
    private update mockUpdate;
    @Mock
    private cancels mockCancels;
    @Mock
    private viewTicket mockViewTicket;
    private cusdomain cusdomain;
    /**
     * Set up the test environment by creating mock objects and initializing the {@code cusdomain} object.
     */
    @Before
    public void setUp() {
    	  mockFrame = mock(JFrame.class);
          mockTicket = mock(ticket.class);
          mockAddCustomer = mock(addCustomer.class);
          mockUpdate=mock(update.class);
          mockCancels=mock(cancels.class);
          mockViewTicket=mock(viewTicket.class);
          mockWelcome=mock(welcome.class);
          cusdomain = new cusdomain();
        cusdomain.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cusdomain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Reset mock objects after each test to ensure a clean state for subsequent tests.
     */
    @After
    public void tearDown() {
        reset(mockFrame, mockTicket, mockAddCustomer, mockWelcome, mockUpdate, mockCancels, mockViewTicket);
    }
    /**
     * Test the {@code makeBookingBtnAction} method.
     * Verifies that the frame is disposed, the ticket object is set to visible, and the ticket object is visible.
     */
    @Test
    public void testMakeBookingBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setTicketObj(mockTicket);
            cusdomain.makeBookingBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockTicket).setVisible(true);
            assertTrue(cusdomain.getTicketObj().isVisible());
        });
    }
    /**
     * Test the {@code registerBtnAction} method.
     * Verifies that the frame is disposed, the addCustomer object is set to visible, and the addCustomer object is visible.
     */
    @Test
    public void testRegisterBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setAddCustomerObj(mockAddCustomer);
            cusdomain.registerBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockAddCustomer).setVisible(true);
            assertTrue(cusdomain.getAddCustomerObj().isVisible());
        });
    }
    /**
     * Test the {@code mainMenuBtnAction} method.
     * Verifies that the frame is disposed, the welcome object is set to visible, and the welcome object is visible.
     */
    @Test
    public void testMainMenuBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setWelcomeObj(mockWelcome);
            cusdomain.mainMenuBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockWelcome).setVisible(true);
            assertTrue(cusdomain.getWelcomeObj().isVisible());
            
        });
    }
    /**
     * Test the {@code updateBookingBtnAction} method.
     * Verifies that the frame is disposed, the update object is sized and set to visible, and the update object is visible.
     */
    @Test
    public void testUpdateBookingBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setUpdateObj(mockUpdate);
            cusdomain.updateBookingBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockUpdate).setSize(1150, 900);
            verify(mockUpdate).setVisible(true);
            assertTrue(cusdomain.getUpdateObj().isVisible());
        });
    }
    /**
     * Test the {@code cancelBookingBtnAction} method.
     * Verifies that the frame is disposed, the cancels object is set to visible, and the cancels object is visible.
     */
    @Test
    public void testCancelBookingBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setCancelsObj(mockCancels);
            cusdomain.cancelBookingBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockCancels).setVisible(true);
            assertTrue(cusdomain.getCancelsObj().isVisible());
        });
    }
    /**
     * Test the {@code viewTicketBtnAction} method.
     * Verifies that the frame is disposed, the viewTicket object is set to visible, and the viewTicket object is visible.
     */
    @Test
    public void testViewTicketBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setVT(mockViewTicket);
            cusdomain.viewTicketBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockViewTicket).setVisible(true);
            assertTrue(cusdomain.getVT().isVisible());
        });
    }
}
