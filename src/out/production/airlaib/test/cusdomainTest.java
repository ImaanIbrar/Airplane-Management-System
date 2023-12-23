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

import static org.mockito.Mockito.*;

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

    @After
    public void tearDown() {
        reset(mockFrame, mockTicket, mockAddCustomer, mockWelcome, mockUpdate, mockCancels, mockViewTicket);
    }

    @Test
    public void testMakeBookingBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setTicket(mockTicket);
            cusdomain.makeBookingBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockTicket).setVisible(true);
        });
    }

    @Test
    public void testRegisterBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setAddCustomer(mockAddCustomer);
            cusdomain.registerBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockAddCustomer).setVisible(true);
        });
    }

    @Test
    public void testMainMenuBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setWelcome(mockWelcome);
            cusdomain.mainMenuBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockWelcome).setVisible(true);
        });
    }

    @Test
    public void testUpdateBookingBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setUpdate(mockUpdate);
            cusdomain.updateBookingBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockUpdate).setSize(1150, 900);
            verify(mockUpdate).setVisible(true);
        });
    }

    @Test
    public void testCancelBookingBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setCancels(mockCancels);
            cusdomain.cancelBookingBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockCancels).setVisible(true);
        });
    }

    @Test
    public void testViewTicketBtnAction() {
        SwingUtilities.invokeLater(() -> {
            cusdomain.setViewTicket(mockViewTicket);
            cusdomain.viewTicketBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockViewTicket).setVisible(true);
        });
    }
}
