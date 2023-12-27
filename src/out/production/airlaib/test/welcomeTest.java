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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
/**
 * JUnit test class for the {@code welcome} class.
 * Author: Laiba Atiq
 * 
 * Testing strategy for WelcomeTest class:
 *
 * The primary goal of WelcomeTest is to verify the functionality of the welcome class,
 * focusing on the adminButtonActionPerformed, passengerButtonActionPerformed, and
 * exitButtonActionPerformed methods.
 *
 * Test cases:
 *
 * 1. **testAdminButtonActionPerformed:**
 *    - Description: Tests the adminButtonActionPerformed method of the welcome class.
 *    - Steps:
 *        - Set up the mock login window.
 *        - Call the adminButtonActionPerformed method.
 *        - Verify that the frame is disposed, login window is shown, and the window is visible.
 *    - Expected Result: The login window should be visible after calling the adminButtonActionPerformed method.
 *
 * 2. **testPassengerButtonActionPerformed:**
 *    - Description: Tests the passengerButtonActionPerformed method of the welcome class.
 *    - Steps:
 *        - Set up the mock cusdomain window.
 *        - Call the passengerButtonActionPerformed method.
 *        - Verify that the frame is disposed, cusdomain window is shown, and the window is visible.
 *    - Expected Result: The cusdomain window should be visible after calling the passengerButtonActionPerformed method.
 *
 * 3. **testExitButtonActionPerformed:**
 *    - Description: Tests the exitButtonActionPerformed method of the welcome class.
 *    - Steps:
 *        - Set up the mock login and cusdomain windows.
 *        - Mock the static JOptionPane method to simulate a user clicking the "Yes" button in the confirmation dialog.
 *        - Call the exitButtonActionPerformed method.
 *        - Verify that the frame is disposed, login and cusdomain windows are not visible.
 *    - Expected Result: The login and cusdomain windows should not be visible after calling the exitButtonActionPerformed method.
 */
@RunWith(MockitoJUnitRunner.class)
public class welcomeTest {

    @Mock
    private JFrame mockFrame;
    @Mock
    private Login mockLogin;
    @Mock
    private cusdomain mockCusdomain;
    private welcome welcome;

    /**
     * Set up the mock frame, login, and cusdomain objects before each test.
     */
    @Before
    public void setUp() {
        mockFrame = mock(JFrame.class);
        mockLogin = mock(Login.class);
        mockCusdomain = mock(cusdomain.class);

        welcome = new welcome();
        welcome.setExtendedState(JFrame.MAXIMIZED_BOTH);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Reset the mock objects after each test.
     */
    @After
    public void tearDown() {
        reset(mockFrame, mockLogin, mockCusdomain);
    }

    /**
     * Test the {@code adminButtonActionPerformed} method.
     * Verifies that the frame is disposed, login is set visible, and login is
     * visible.
     */
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
            assertTrue(welcome.getLogin().isVisible());
        });
    }

    /**
     * Test the {@code passengerButtonActionPerformed} method.
     * Verifies that the frame is disposed, cusdomain is set visible, and cusdomain
     * is visible.
     */
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
            assertTrue(welcome.getCusdomain().isVisible());
        });
    }

    /**
     * Test the {@code exitButtonActionPerformed} method.
     * Verifies that the frame is disposed, login and cusdomain are not visible
     * after confirmation.
     */
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
            assertFalse(welcome.getLogin().isVisible());
            assertFalse(welcome.getCusdomain().isVisible());
        });
    }

}
