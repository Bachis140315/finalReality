package cl.uchile.dcc.finalreality.exceptions;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertThrows;

/**
 * The {@link RequireTest} class was created to test different scenarios when creating a weapon or
 * a character, using the {@link InvalidStatValueException} expection to have a least and most value
 * for different attributes of a weapon or a character.
 */

class RequireTest {
  private Engineer engineer;
  private Knight knight;
  private Thief thief;
  private BlackMage blackmage;
  private WhiteMage whitemage;
  
  @BeforeEach
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    knight=new Knight("KNIGHT",11,11,queue);
    engineer=new Engineer("ENGINEER",22,22,queue);
    thief=new Thief("THIEF",33,33, queue);
    blackmage=new BlackMage("BLACKMAGE",44,44,queue,44);
    whitemage=new WhiteMage("WHITEMAGE",55,55,queue,55);
  }
  
  @Test
  public void statValueAtLeastANDAtMost() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue= new LinkedBlockingQueue<>();
    
    assertThrows(InvalidStatValueException.class,()->knight.setCurrentHp(12));
    assertThrows(InvalidStatValueException.class,()->engineer.setCurrentHp(-22));
    assertThrows(InvalidStatValueException.class,()->thief.setCurrentHp(59));
    assertThrows(InvalidStatValueException.class,()->new Thief("THIEF",-1,33, queue));
    assertThrows(InvalidStatValueException.class,()->blackmage.setCurrentMp(-44));
    assertThrows(InvalidStatValueException.class,()->whitemage.setCurrentMp(56));
    

  }
  
}