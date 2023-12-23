package out.production.airlaib.test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import out.production.airlaib.Login;
import out.production.airlaib.cusdomain;
import out.production.airlaib.welcome;

import javax.swing.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class welcomeTest {

    @Mock
    private JFrame mockFrame;
    @Mock
    private Login mockLogin;
    @Mock
    private cusdomain mockCusdomain;
    private welcome welcome;

    @Before
    public void setUp() {
        mockFrame = mock(JFrame.class);
        mockLogin = mock(Login.class);
        mockCusdomain = mock(cusdomain.class);

        welcome = new welcome();
        welcome.setExtendedState(JFrame.MAXIMIZED_BOTH);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @After
    public void tearDown() {
        reset(mockFrame, mockLogin, mockCusdomain);
    }

    @Test
    public void testAdminButtonActionPerformed() {
        SwingUtilities.invokeLater(() -> {
            // Arrange
            welcome.setLogin(mockLogin);

            // Act
            welcome.adminButton.doClick();

            // Assert
            verify(mockFrame).dispose();
            verify(mockLogin).setVisible(true);
        });
    }

    @Test
    public void testPassengerButtonActionPerformed() {
        SwingUtilities.invokeLater(() -> {
            // Arrange
            welcome.setCusdomain(mockCusdomain);

            // Act
            welcome.passengerButton.doClick();

            // Assert
            verify(mockFrame).dispose();
            verify(mockCusdomain).setVisible(true);
        });
    }

    @Test
    public void testExitButtonActionPerformed() {
        SwingUtilities.invokeLater(() -> {
            // Arrange
            Mockito.mockStatic(JOptionPane.class);
            // Capture the argument passed to showConfirmDialog
            when(JOptionPane.showConfirmDialog(eq(null), any(), any(), eq(JOptionPane.YES_NO_OPTION)))
                    .thenReturn(JOptionPane.YES_OPTION);

            // Act
            welcome.exitButton.doClick();

            // Assert
            verify(mockFrame).dispose();
        });
    }

    // Add more tests for other methods in the Welcome class
}
