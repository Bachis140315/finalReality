package cl.uchile.dcc.finalreality.model.weapon.tests_weapons_characters;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
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
 * The {@link TestWeaponsOnKnight} class exists to test when a weapon is equipped on a {@link Knight}
 * character, setting up different types of weapons to put the {@link Knight} in different scenarios.
 * <p>A weapon is not equipped if the character doesn´t allow it. If this character already has a weapon
 * equipped and another weapon is equipped, it can change or the first weapon stays equipped.
 */

public class TestWeaponsOnKnight {
  private Knight caballero1;
  private Knight caballero2;
  private Knight caballero3;
  private NormalWeapon sword;
  private NormalWeapon hacha;
  private NormalWeapon cuchillo;
  private NormalWeapon arco;
  private MagicWeapon baston;
  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    //Creando personajes tipo Knight para darles armas
    caballero1=new Knight("Sir Fred",100, 100, queue);
    
    caballero2=new Knight("Sir Bull", 100, 100, queue);
    
    caballero3=new Knight("Sir Erick", 100, 100, queue);
    
    //Creando las armas que les pondremos a los caballeros, una de cada tipo
    sword=new NormalWeapon("Matadragones",10,10, WeaponType.SWORD);
    
    hacha=new NormalWeapon("Leviatan",10 ,10,WeaponType.AXE);
    
    cuchillo=new NormalWeapon("Draktarr", 10 , 10, WeaponType.KNIFE);
    
    arco=new NormalWeapon("Yumi", 10 ,10,WeaponType.BOW);
    
    baston=new MagicWeapon("Aqua Heartia", 10, 10, MagicWeaponType.STAFF,10);
    
  }
  
  
  @Test
  public void equipWeaponTest() { //se probara equipar distintas armas a un Knight
    caballero3.equip(arco);
    assertNull(caballero3.getEquippedWeapon());
    
    caballero1.equip(sword);
    assertEquals(sword,caballero1.getEquippedWeapon());
    
    caballero2.equip(hacha);
    assertEquals(hacha,caballero2.getEquippedWeapon());
    
    caballero3.equip(cuchillo);
    assertEquals(cuchillo,caballero3.getEquippedWeapon());
  
  
    caballero1.equip(arco);
    assertEquals(caballero1.getEquippedWeapon(),sword);
  
    caballero2.equip(baston);
    assertEquals(caballero2.getEquippedWeapon(),hacha);
    
    
  }
  
}
