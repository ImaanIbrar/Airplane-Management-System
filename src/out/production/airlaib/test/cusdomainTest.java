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
 * JUnit test class for the {@code cusdomain} class.
 * Author: Marriam and Laiba
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
