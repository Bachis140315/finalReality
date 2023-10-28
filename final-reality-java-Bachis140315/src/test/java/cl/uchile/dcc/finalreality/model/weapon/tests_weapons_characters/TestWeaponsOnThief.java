package cl.uchile.dcc.finalreality.model.weapon.tests_weapons_characters;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeaponType;
import cl.uchile.dcc.finalreality.model.weapon.NormalWeapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The {@link TestWeaponsOnThief} class exists to test when a weapon is equipped on a {@link Thief}
 * character, setting up different types of weapons to put the {@link Thief} in different scenarios.
 * <p>A weapon is not equipped if the character doesn´t allow it. If this character already has a weapon
 * equipped and another weapon is equipped, it can change or the first weapon stays equipped.
 */

public class TestWeaponsOnThief {
  private Thief ladron1;
  private Thief ladron2;
  private Thief ladron3;
  private NormalWeapon sword;
  private NormalWeapon hacha;
  private NormalWeapon cuchillo;
  private NormalWeapon arco;
  private MagicWeapon baston;
  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    //Creando personajes tipo Knight para darles armas
    ladron1=new Thief("Thief Fred",100, 100, queue);
    
    ladron2=new Thief("Thief Bull", 100, 100, queue);
    
    ladron3=new Thief("Thief Erick", 100, 100, queue);
    
    //Creando las armas que les pondremos a los caballeros, una de cada tipo
    sword=new NormalWeapon("Matadragones",10,10, WeaponType.SWORD);
    
    hacha=new NormalWeapon("Leviatan",10 ,10,WeaponType.AXE);
    
    cuchillo=new NormalWeapon("Draktarr", 10 , 10, WeaponType.KNIFE);
    
    arco=new NormalWeapon("Yumi", 10 ,10,WeaponType.BOW);
    
    baston=new MagicWeapon("Aqua Heartia", 10, 10, MagicWeaponType.STAFF,10);
    
  }
  
  @Test
  public void equipWeaponTest() {
    ladron1.equip(hacha);
    assertNull(ladron1.getEquippedWeapon());
    
    ladron1.equip(sword);
    assertEquals(sword,ladron1.getEquippedWeapon());
    
    ladron2.equip(cuchillo);
    assertEquals(cuchillo,ladron2.getEquippedWeapon());
    
    ladron3.equip(arco);
    assertEquals(arco,ladron3.getEquippedWeapon());
    
    ladron1.equip(hacha);
    assertEquals(ladron1.getEquippedWeapon(),sword);
    
    ladron2.equip(baston);
    assertEquals(ladron2.getEquippedWeapon(),cuchillo);
    
  }
}
