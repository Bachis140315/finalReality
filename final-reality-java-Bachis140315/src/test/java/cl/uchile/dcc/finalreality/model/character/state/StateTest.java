package cl.uchile.dcc.finalreality.model.character.state;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StateTest {
  private GameCharacter character_one;
  
  private GameCharacter character_two;
  
  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue <GameCharacter> queue= new LinkedBlockingQueue<>();
    
    character_one = new Knight("character 1 ", 10 ,10 ,queue);
    character_two = new Enemy("character 2", 10 ,10 ,10, queue, 10);
    
    
    
  }
  
  @Test
  public void normal() {
    assertTrue((character_one.getState()).normal());
    assertTrue((character_two.getState()).normal());
  }
  
  @Test
  public void infire() {
    
    InFireState fire= new InFireState(0);
    
    character_one.setState(fire);
    
    assertTrue((character_one.getState()).infire());
    
    
    character_two.setState(fire);
    
    assertTrue((character_two.getState()).infire());
  
  }
  
  @Test
  public void paralized() throws InvalidStatValueException {
    
    character_one.setState(new ParalizedState());
    
    assertTrue((character_one.getState()).paralized());
  
    
    character_two.setState(new ParalizedState());
    
    assertTrue((character_two.getState()).paralized());
    
  }
  
  @Test
  public void poisoned() throws InvalidStatValueException {
    PoisonedState poison = new PoisonedState(0);
    
    character_one.setState(poison);
    assertTrue((character_one.getState()).poisoned());
    
  
    character_two.setState(poison);
    assertTrue((character_two.getState()).poisoned());
    
  }
  
  
  
  @Test
  public void setinFire() {
    (character_one.getState()).setinFire(0);
    assertTrue((character_one.getState()).infire());
  
    (character_two.getState()).setinFire(0);
    assertTrue((character_two.getState()).infire());
  
  }
  
  @Test
  public void getParalized() {
    (character_one.getState()).getParalized();
    assertTrue((character_one.getState()).paralized());
  
    (character_two.getState()).getParalized();
    assertTrue((character_two.getState()).paralized());
  }
  
  @Test
  public void getPoisoned() {
    (character_one.getState()).getPoisoned(0);
    assertTrue((character_one.getState()).poisoned());
  
    (character_two.getState()).getPoisoned(0);
    assertTrue((character_two.getState()).poisoned());
  }
  
  @Test
  public void gobacktoNormal() {
    character_one.setState(new PoisonedState(0));
    character_two.setState(new InFireState(0));
    
    assertFalse((character_one.getState()).normal());
    assertFalse((character_two.getState()).normal());
  
    (character_one.getState()).gobacktoNormal();
    (character_two.getState()).gobacktoNormal();
  
    assertTrue((character_one.getState()).normal());
    assertTrue((character_two.getState()).normal());
  }
  
  
  @Test
  public void makeEffect() throws InvalidStatValueException {
    character_one.setState(new ParalizedState());
    assertEquals("No me puedo mover!!!",(character_one.getState()).makeEffect());
  
    PoisonedState poison = new PoisonedState(0);
    poison.setDamage_to_deal(7);
    character_one.setState(poison);
    poison.makeEffect();
    assertEquals(3,character_one.getCurrentHp());
    
  
    InFireState fire= new InFireState(0);
    fire.setDamage_to_deal(5);
    character_two.setState(fire);
    fire.makeEffect();
    assertEquals(5,character_two.getCurrentHp());
  }
}