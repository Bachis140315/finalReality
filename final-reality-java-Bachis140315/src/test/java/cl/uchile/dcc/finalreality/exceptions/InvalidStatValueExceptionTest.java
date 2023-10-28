package cl.uchile.dcc.finalreality.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The {@link InvalidStatValueExceptionTest} class was created to test the excepcion
 * created on {@link InvalidStatValueException}.
 */

public class InvalidStatValueExceptionTest {
  private final String message = "The provided value is not a valid stat value. ";
  
  @BeforeEach
  void setUp() {
  }
  
  @Test
  void constructorTest() {
    String expectedMessage = "Expected Message";
    InvalidStatValueException exception = assertThrows(InvalidStatValueException.class, () -> {
      throw new InvalidStatValueException(expectedMessage);
    });
    assertEquals(message + expectedMessage, exception.getMessage());
  }
}