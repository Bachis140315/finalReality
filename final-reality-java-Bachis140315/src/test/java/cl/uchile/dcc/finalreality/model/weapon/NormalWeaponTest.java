package cl.uchile.dcc.finalreality.model.weapon;


import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * The {@link NormalWeaponTest} class exists to test every method created in the {@link NormalWeapon} class,
 * setting up different scenarios where a {@link NormalWeapon} can be.
 */
public class NormalWeaponTest {
  private NormalWeapon arco;
  private NormalWeapon arco_2;
  private NormalWeapon arco_3;
  private NormalWeapon espada;
  private NormalWeapon espada_2;
  private NormalWeapon cuchillo;
  private NormalWeapon cuchillo_2;
  private NormalWeapon hacha;
  
  
  
  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    arco= new NormalWeapon("Fenix",1000,10,WeaponType.BOW);
    arco_2= new NormalWeapon("Fenix",1000,10,WeaponType.BOW);
    arco_3= new NormalWeapon("Fenix ",100,10,WeaponType.BOW);
    
    espada= new NormalWeapon("Demacia",100,10,WeaponType.SWORD);
    espada_2= new NormalWeapon("Fenix", 1000, 1000, WeaponType.SWORD);
    
    cuchillo= new NormalWeapon("Draktarr",10,1,WeaponType.KNIFE);
    cuchillo_2= new NormalWeapon("Fenix ",100,10,WeaponType.KNIFE);
    hacha= new NormalWeapon("Leviatan",1,1,WeaponType.AXE);
  
  }
  
  @Test
  public void testTestGetName() {
    assertEquals(arco.getName(),arco_2.getName());
    assertNotEquals(arco_3.getName(),arco.getName());
    assertNotEquals(espada.getName(),arco_2.getName());
    assertEquals(arco.getName(), espada_2.getName());
    
  }
  
  @Test
  public void testGetDamage() {
    assertEquals(arco.getDamage(),arco_2.getDamage());
    assertNotEquals(arco_3.getDamage(),arco.getDamage());
    assertNotEquals(espada_2.getDamage(),hacha.getDamage());
    assertEquals(arco.getDamage(), espada_2.getDamage());
    
  }
  
  @Test
  public void testGetWeight() {
    assertEquals(arco.getWeight(),arco_2.getWeight());
    assertNotEquals(espada.getWeight(),espada_2.getWeight());
    assertNotEquals(espada.getWeight(),cuchillo.getWeight());
    assertEquals(cuchillo.getWeight(),hacha.getWeight());
    
  }
  
  @Test
  public void testGetType() {
    assertEquals(arco.getType(),arco_2.getType());
    assertEquals(arco_2.getType(),arco_3.getType());
    assertEquals(espada.getType(),espada_2.getType());
    assertNotEquals(hacha.getType(),cuchillo.getType());
    assertNotEquals(espada.getType(),arco_3.getType());
  }
  
  @Test
  public void testTestEquals() {
    assertTrue("Son iguales",arco.equals(arco_2));
    assertFalse("No son iguales, no tienen mismos atributos",espada.equals(espada_2));
    assertFalse("No son iguales, no son el mismo tipo de arma",cuchillo_2.equals(arco_3));
    assertFalse("No son iguales, tienen nombre distino",arco_3.equals(arco));
    
  }
  
  @Test
  public void testTestHashCode() {
    assertEquals(arco.hashCode(),arco_2.hashCode());
    assertNotEquals(espada.hashCode(),espada_2.hashCode());
    assertNotEquals(cuchillo_2.hashCode(),arco_3.hashCode());
  }
  
  @Test
  public void testTestToString() {
    assertEquals("NormalWeapon{name='Fenix', damage=1000, weight=10, type=BOW}",arco.toString());
    assertEquals(arco_2.toString(),arco.toString());
    assertNotEquals(arco_3.toString(),espada_2.toString());
  }
}