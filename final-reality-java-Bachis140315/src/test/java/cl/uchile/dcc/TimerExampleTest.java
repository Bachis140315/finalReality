package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.weapon.NormalWeapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The {@link TimerExampleTest} class was created to test when adding character to a queue
 * and make them wait for their turns.
 */
class TimerExampleTest {
  
  
  @Test
  public void testTimermain() throws InterruptedException, InvalidStatValueException {
  
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  
    NormalWeapon weapon0= new NormalWeapon("", 10, 55, WeaponType.KNIFE);
    Thief character0 = new Thief("0", 10, 10, queue);
    character0.equip(weapon0);
    character0.waitTurn();
  
    NormalWeapon weapon1 = new NormalWeapon("", 10, 73, WeaponType.KNIFE);
    Thief character1 = new Thief("1", 10, 10, queue);
    character1.equip(weapon1);
    character1.waitTurn();
  
    NormalWeapon weapon2 = new NormalWeapon("", 10, 35, WeaponType.KNIFE);
    Thief character2 = new Thief("2", 10, 10, queue);
    character2.equip(weapon2);
    character2.waitTurn();
  
    NormalWeapon weapon3 = new NormalWeapon("", 10, 1, WeaponType.KNIFE);
    Thief character3 = new Thief("3", 10, 10, queue);
    character3.equip(weapon3);
    character3.waitTurn();
  
    NormalWeapon weapon4 = new NormalWeapon("", 10, 10, WeaponType.KNIFE);
    Thief character4 = new Thief("4", 10, 10, queue);
    character4.equip(weapon4);
    character4.waitTurn();
  
    NormalWeapon weapon5 = new NormalWeapon("", 10, 83, WeaponType.KNIFE);
    Thief character5 = new Thief("5", 10, 10, queue);
    character5.equip(weapon5);
    character5.waitTurn();
  
    NormalWeapon weapon6 = new NormalWeapon("", 10, 94, WeaponType.KNIFE);
    Thief character6 = new Thief("6", 10, 10, queue);
    character6.equip(weapon6);
    character6.waitTurn();
  
    NormalWeapon weapon7 = new NormalWeapon("", 10, 45, WeaponType.KNIFE);
    Thief character7 = new Thief("7", 10, 10, queue);
    character7.equip(weapon7);
    character7.waitTurn();
  
    NormalWeapon weapon8 = new NormalWeapon("", 10,25, WeaponType.KNIFE);
    Thief character8 = new Thief("8", 10, 10, queue);
    character8.equip(weapon8);
    character8.waitTurn();
  
    NormalWeapon weapon9 = new NormalWeapon("", 10, 65, WeaponType.KNIFE);
    Thief character9 = new Thief("9", 10, 10, queue);
    character9.equip(weapon9);
    character9.waitTurn();
  
    Enemy character10 = new Enemy("9", 103, 10,10, queue, 1);
    character10.waitTurn();
  
    Enemy character11 = new Enemy("9", 109, 10,10, queue, 1);
    character11.waitTurn();
    
    
    
    
  
    
    
    Thread.sleep(11000);
    
    String message0=queue.poll().toString();
    System.out.println(message0);
    String message1=queue.poll().toString();
    System.out.println(message1);
    String message2=queue.poll().toString();
    System.out.println(message2);
    String message3=queue.poll().toString();
    System.out.println(message3);
    String message4=queue.poll().toString();
    System.out.println(message4);
    String message5=queue.poll().toString();
    System.out.println(message5);
    String message6=queue.poll().toString();
    System.out.println(message6);
    String message7=queue.poll().toString();
    System.out.println(message7);
    String message8=queue.poll().toString();
    System.out.println(message8);
    String message9=queue.poll().toString();
    System.out.println(message9);
    
    //Este es el orden
    
    Assertions.assertEquals("Thief{maxHp=10, defense=10, name='3'}", message0);
  
    Assertions.assertEquals("Thief{maxHp=10, defense=10, name='4'}", message1);
  
    Assertions.assertEquals("Thief{maxHp=10, defense=10, name='8'}", message2);
  
    Assertions.assertEquals("Thief{maxHp=10, defense=10, name='2'}", message3);
  
    Assertions.assertEquals("Thief{maxHp=10, defense=10, name='7'}", message4);
  
    Assertions.assertEquals("Thief{maxHp=10, defense=10, name='0'}", message5);
  
    Assertions.assertEquals("Thief{maxHp=10, defense=10, name='9'}", message6);
  
    Assertions.assertEquals("Thief{maxHp=10, defense=10, name='1'}", message7);
  
    Assertions.assertEquals("Thief{maxHp=10, defense=10, name='5'}", message8);
  
    Assertions.assertEquals("Thief{maxHp=10, defense=10, name='6'}", message9);
    
  }
  
}