package cl.uchile.dcc.finalreality.model.weapon.tests_weapons_characters;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
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
 * The {@link TestWeaponsOnBlackMage} class exists to test when a weapon is equipped on a {@link BlackMage}
 * character, setting up different types of weapons to put the {@link BlackMage} in different scenarios.
 * <p>A weapon is not equipped if the character doesn´t allow it. If this character already has a weapon
 * equipped and another weapon is equipped, it can change or the first weapon stays equipped.
 */

public class TestWeaponsOnBlackMage {
  private BlackMage magoscuro1;
  private BlackMage magoscuro2;
  private BlackMage magoscuro3;
  private NormalWeapon sword;
  private NormalWeapon hacha;
  private NormalWeapon cuchillo;
  private NormalWeapon arco;
  private MagicWeapon baston;
  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    //Creando personajes tipo Knight para darles armas
    magoscuro1=new BlackMage("Black Mage Fred",100, 100, queue,100);
    
    magoscuro2=new BlackMage("Black Mage Bull", 100, 100, queue, 100);
    
    magoscuro3=new BlackMage("Black Mage Erick", 100, 100, queue, 100);
    
    //Creando las armas que les pondremos a los caballeros, una de cada tipo
    sword=new NormalWeapon("Matadragones",10,10, WeaponType.SWORD);
    
    hacha=new NormalWeapon("Leviatan",10 ,10,WeaponType.AXE);
    
    cuchillo=new NormalWeapon("Draktarr", 10 , 10, WeaponType.KNIFE);
    
    arco=new NormalWeapon("Yumi", 10 ,10,WeaponType.BOW);
    
    baston=new MagicWeapon("Aqua Heartia", 10, 10, MagicWeaponType.STAFF,10);
    
  }
  
  @Test
  public void equipWeaponTest() {
    
    magoscuro2.equip(sword);
    assertNull(magoscuro2.getEquippedWeapon());
    
    magoscuro1.equip(cuchillo);
    assertEquals(cuchillo,magoscuro1.getEquippedWeapon());
    
    magoscuro2.equip(baston);
    assertEquals(baston,magoscuro2.getEquippedWeapon());
    
    magoscuro1.equip(sword);
    assertNotEquals(magoscuro1.getEquippedWeapon(),sword);
    
    magoscuro2.equip(hacha);
    assertNotEquals(magoscuro2.getEquippedWeapon(),hacha);
    
    magoscuro3.equip(arco);
    assertNotEquals(magoscuro3.getEquippedWeapon(),arco);
    
  }
}
