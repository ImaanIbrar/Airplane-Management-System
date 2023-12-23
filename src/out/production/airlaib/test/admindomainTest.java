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

import static org.mockito.Mockito.*;

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

    @After
    public void tearDown() {
        reset(mockFrame, mockAddFlight, mockSearchCustomer, mockTicketReport, mockUserCreation, mockWelcome);
    }

    @Test
    public void testAddFlightBtnAction() {
        SwingUtilities.invokeLater(() -> {
            admindomain.setAddFlightObj(mockAddFlight);
            admindomain.addFlightBtnAction(mock(ActionEvent.class));
            verify(mockFrame).setVisible(false);
            verify(mockAddFlight).setVisible(true);
        });
    }

    @Test
    public void testSearchCustomerBtnAction() {
        SwingUtilities.invokeLater(() -> {
            admindomain.setSearchCustomerObj(mockSearchCustomer);
            admindomain.searchCustomerBtnAction(mock(ActionEvent.class));
            verify(mockFrame).setVisible(false);
            verify(mockSearchCustomer).setVisible(true);
        });
    }

    @Test
    public void testGenerateTicketBtnAction() {
        SwingUtilities.invokeLater(() -> {
            admindomain.setTicketReportObj(mockTicketReport);
            admindomain.generateTicketBtnAction(mock(ActionEvent.class));
            verify(mockFrame).setVisible(false);
            verify(mockTicketReport).setVisible(true);
        });
    }

    @Test
    public void testLogoutBtnAction() {
        SwingUtilities.invokeLater(() -> {
            admindomain.setWelcomeObj(mockWelcome);
            admindomain.logoutBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockWelcome).setVisible(true);
        });
    }

    @Test
    public void testCreateUserBtnAction() {
        SwingUtilities.invokeLater(() -> {
            admindomain.setUserCreationObj(mockUserCreation);
            admindomain.createUserBtnAction(mock(ActionEvent.class));
            verify(mockFrame).dispose();
            verify(mockUserCreation).setVisible(true);
        });
    }
}
