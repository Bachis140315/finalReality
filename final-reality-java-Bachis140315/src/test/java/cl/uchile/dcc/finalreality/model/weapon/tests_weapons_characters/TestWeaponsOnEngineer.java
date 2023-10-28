package cl.uchile.dcc.finalreality.model.weapon.tests_weapons_characters;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
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
 * The {@link TestWeaponsOnEngineer} class exists to test when a weapon is equipped on a {@link Engineer}
 * character, setting up different types of weapons to put the {@link Engineer} in different scenarios.
 * <p>A weapon is not equipped if the character doesn´t allow it. If this character already has a weapon
 * equipped and another weapon is equipped, it can change or the first weapon stays equipped.
 */

public class TestWeaponsOnEngineer {
  private Engineer ingeniero1;
  private Engineer ingeniero2;
  private Engineer ingeniero3;
  private NormalWeapon sword;
  private NormalWeapon hacha;
  private NormalWeapon cuchillo;
  private NormalWeapon arco;
  private MagicWeapon baston;
  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    //Creando personajes tipo Knight para darles armas
    ingeniero1=new Engineer("Engineer Fred",100, 100, queue);
    
    ingeniero2=new Engineer("Engineer Bull", 100, 100, queue);
    
    ingeniero3=new Engineer("Engineer Erick", 100, 100, queue);
    
    //Creando las armas que les pondremos a los caballeros, una de cada tipo
    sword=new NormalWeapon("Matadragones",10,10, WeaponType.SWORD);
    
    hacha=new NormalWeapon("Leviatan",10 ,10,WeaponType.AXE);
    
    cuchillo=new NormalWeapon("Draktarr", 10 , 10, WeaponType.KNIFE);
    
    arco=new NormalWeapon("Yumi", 10 ,10,WeaponType.BOW);
    
    baston=new MagicWeapon("Aqua Heartia", 10, 10, MagicWeaponType.STAFF,10);
    
  }
  
  @Test
  public void equipWeaponTest() {
    
    ingeniero2.equip(hacha);
    assertEquals(hacha,ingeniero2.getEquippedWeapon());
  
    ingeniero3.equip(arco);
    assertEquals(arco,ingeniero3.getEquippedWeapon());
  
    ingeniero1.equip(sword);
    assertNull(ingeniero1.getEquippedWeapon());
    
    ingeniero1.equip(cuchillo);
    assertNull(ingeniero1.getEquippedWeapon());
  
    ingeniero2.equip(baston);
    assertNotEquals(ingeniero2.getEquippedWeapon(),baston);
  }
}
