package cl.uchile.dcc.finalreality.model.weapon.tests_weapons_characters;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeaponType;
import cl.uchile.dcc.finalreality.model.weapon.NormalWeapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.*;

/**
 * The {@link TestWeaponsOnWhiteMage} class exists to test when a weapon is equipped on a {@link WhiteMage}
 * character, setting up different types of weapons to put the {@link WhiteMage} in different scenarios.
 * <p>A weapon is not equipped if the character doesn´t allow it. If this character already has a weapon
 * equipped and another weapon is equipped, it can change or the first weapon stays equipped.
 */

public class TestWeaponsOnWhiteMage {
  private WhiteMage magoclaro1;
  private WhiteMage magoclaro2;
  private WhiteMage magoclaro3;
  private NormalWeapon sword;
  private NormalWeapon hacha;
  private NormalWeapon cuchillo;
  private NormalWeapon arco;
  private MagicWeapon baston;
  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    //Creando personajes tipo Knight para darles armas
    magoclaro1=new WhiteMage("White Mage Fred",100, 100, queue,100);
    
    magoclaro2=new WhiteMage("White Mage Bull", 100, 100, queue, 100);
    
    magoclaro3=new WhiteMage("White Mage Erick", 100, 100, queue, 100);
    
    //Creando las armas que les pondremos a los caballeros, una de cada tipo
    sword=new NormalWeapon("Matadragones",10,10, WeaponType.SWORD);
    
    hacha=new NormalWeapon("Leviatan",10 ,10,WeaponType.AXE);
    
    cuchillo=new NormalWeapon("Draktarr", 10 , 10, WeaponType.KNIFE);
    
    arco=new NormalWeapon("Yumi", 10 ,10,WeaponType.BOW);
    
    baston=new MagicWeapon("Aqua Heartia", 10, 10, MagicWeaponType.STAFF,10);
    
  }
  
  @Test
  public void equipWeaponTest() {
    
    magoclaro2.equip(cuchillo);
    assertNull(magoclaro2.getEquippedWeapon());
    
    magoclaro1.equip(baston);
    assertEquals(baston,magoclaro1.getEquippedWeapon());
    
    magoclaro1.equip(sword);
    assertNotEquals(magoclaro1.getEquippedWeapon(),sword);
    
    magoclaro2.equip(hacha);
    assertNotEquals(magoclaro2.getEquippedWeapon(),hacha);
    
    magoclaro3.equip(cuchillo);
    assertNotEquals(magoclaro3.getEquippedWeapon(),cuchillo);
    
    magoclaro1.equip(arco);
    assertNotEquals(magoclaro1.getEquippedWeapon(),arco);
    
  }
}
