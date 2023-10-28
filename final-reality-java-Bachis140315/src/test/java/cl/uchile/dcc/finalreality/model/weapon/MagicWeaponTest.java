package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * The {@link MagicWeaponTest} class exists to test every method created in the {@link MagicWeapon} class,
 * setting up different scenarios where a {@link MagicWeapon} can be.
 */
public class MagicWeaponTest {
  private MagicWeapon baculo;
  private MagicWeapon baculo_2;
  private MagicWeapon big_baculo;
  private MagicWeapon baculo_chiquito;
  

  
  
  @Before
  public void setUp() throws InvalidStatValueException {
    
    baculo= new MagicWeapon("Baculo Test",10,1,
          MagicWeaponType.STAFF,100);
    big_baculo= new MagicWeapon("BIG Baculo Test",2, 3,
          MagicWeaponType.STAFF,100);
    baculo_chiquito= new MagicWeapon("Baculo Test",10,1,
          MagicWeaponType.STAFF,10);
    baculo_2= new MagicWeapon("Baculo Test",10,1,
          MagicWeaponType.STAFF,100);
  
  }
  
  @Test
  public void testgetMagicDamage() {
    assertEquals(baculo.getMagicDamage(),100);
    assertEquals(big_baculo.getMagicDamage(),baculo.getMagicDamage());
    assertNotEquals("No tienen el mismo MD",
          baculo_chiquito.getMagicDamage(),baculo.getMagicDamage());
  }
  
  @Test
  public void testEquals() {
    assertEquals("Son iguales", baculo, baculo_2);
    assertNotEquals("No son iguales", baculo_2, big_baculo);
  }
  
  @Test
  public void testHashCode() {
    assertEquals(baculo.hashCode(),baculo_2.hashCode());
    assertNotEquals(baculo_2.hashCode(),big_baculo.hashCode());
  }
  
  @Test
  public void testToString() {
    assertEquals("MagicWeapon{name='Baculo Test', damage=10, weight=1, type=STAFF, MagicDamage=100}",
          baculo.toString());
    assertNotEquals(baculo_chiquito.toString(),baculo.toString());
  }
}