package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.character.state.State;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeapon;
import cl.uchile.dcc.finalreality.model.weapon.MagicWeaponType;
import cl.uchile.dcc.finalreality.model.weapon.NormalWeapon;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import cl.uchile.dcc.finalreality.model.weapon.WeaponType;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p>This Gamedriver class is in charge of setting everything that is neccesary to
 * start a game (battles between Enemies and PlayerCharacter), that is:</p>
 * <p>-Create characters and Weapons</p>
 * <p>-Change state when its neccesary and checking states of character</p>
 * <p>-End the game when one of the arraylists is empty</p>
 * For now, this class creates a predeterminated game with 4 playercharacters
 * (Engineer, Knight, Thief, 50% BlackMage or WhiteMage) and the number of enemies
 * that is given in the startGame method. Every single one of these characters has
 * random attributes, with certain limits.
 */
public class GameDriver {
  
  
  private final Random rng = new Random();
  private final BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
  private ArrayList<PlayerCharacter> charactersToplay = new ArrayList<PlayerCharacter>();
  private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  
  /**
   * This main method starts the game with 4 enemies.
   */
  public static void main(String[] args) throws InvalidStatValueException, InterruptedException {
    GameDriver controller = new GameDriver();
    controller.startGame(9);
  }
  
  /**
   * The createGame method creates everything a game needs to start, such as
   * enemies, player characters and their weapons. Also receives a parameter
   * (int) that determinates how many enemies will be in the game.
   */
  public void createGame(int nrEnemigos) throws InvalidStatValueException {
    cleanArrays();
    
    //Creacion de 4 personajes jugables
    System.out.println("Se crea tu caballero");
    Knight caballero = new Knight("Caballero", rng.nextInt(50, 200), rng.nextInt(100), queue);
    System.out.println("Se crea el arma del caballero");
    NormalWeapon armaCaballero = new NormalWeapon("Sword", rng.nextInt(1, 30),
          rng.nextInt(50), WeaponType.SWORD);
    caballero.equip(armaCaballero);
    charactersToplay.add(caballero);
  
  
  
    System.out.println("Se crea tu Ingeniero");
    Engineer ingeniero = new Engineer("Ingenieur", rng.nextInt(50, 200), rng.nextInt(100), queue);
    System.out.println("Se crea el arma del ingeniero");
    NormalWeapon armaIngeniero = new NormalWeapon("Arco", rng.nextInt(1, 30),
          rng.nextInt(50), WeaponType.BOW);
    ingeniero.equip(armaIngeniero);
    charactersToplay.add(ingeniero);
  
    System.out.println("Se crea tu Ladron");
    Thief ladron = new Thief("Ladron", rng.nextInt(50, 200), rng.nextInt(1, 100), queue);
    System.out.println("Se crea el arma del ladron");
    NormalWeapon armaLadron = new NormalWeapon("Cuchillo",
          rng.nextInt(1, 30), rng.nextInt(50), WeaponType.KNIFE);
    ladron.equip(armaLadron);
    charactersToplay.add(ladron);
  
    if (rng.nextInt(2) == 0) {
      System.out.println("Se crea tu Mago Oscuro");
      BlackMage magoOscuro = new BlackMage("Mago Oscuro", rng.nextInt(50, 200),
            rng.nextInt(100), queue, rng.nextInt(100, 300));
      System.out.println("Se crea el arma del Mago Oscuro");
      MagicWeapon armaMagoscuro = new MagicWeapon("Baston MO", rng.nextInt(1, 50),
            rng.nextInt(50), MagicWeaponType.STAFF, rng.nextInt(1, 80));
      magoOscuro.equip(armaMagoscuro);
      charactersToplay.add(magoOscuro);
    } else {
      System.out.println("Se crea tu Mago Blanco");
      WhiteMage magoBlanco = new WhiteMage("Mago Blanco", rng.nextInt(50, 200),
            rng.nextInt(100), queue, rng.nextInt(100, 300));
      System.out.println("Se crea el arma del Mago Blanco");
      MagicWeapon armaMagoblanco = new MagicWeapon("Baston MB", rng.nextInt(1, 50),
            rng.nextInt(50), MagicWeaponType.STAFF, rng.nextInt(1, 80));
      magoBlanco.equip(armaMagoblanco);
      charactersToplay.add(magoBlanco);
    }
    
    //Creacion de enemigos, dependiendo de la cantidad que se reciba como parametro
    if (nrEnemigos >= 9) {
      System.out.println("Solo se puede maximo 9 enemigos, se iniciara la partida con estos 9.");
      nrEnemigos = 9;
    }
    if (nrEnemigos <= 0) {
      System.out.println("Se necesita minimo 1 enemigo, se iniciara la partida con 1.");
      nrEnemigos = 1;
    }
    for (int i = 0; i < nrEnemigos; i++) {
      Enemy enemy = new Enemy(String.valueOf(i), rng.nextInt(1, 50),
            rng.nextInt(50, 100), rng.nextInt(100), queue, rng.nextInt(50));
      enemies.add(enemy);
    }
    
  }
  
  /**
   * The startGame method calls createGame in a 'while' loop, aks if the game has
   * ended, if not, calls makeCharacterswait, to make the characters wait for their
   * turn, and enters another 'while' loop that ends when the queue is empty, and so on.
   */
  public void startGame(int cuantosEnemigos)
        throws InvalidStatValueException, InterruptedException {
    
    createGame(cuantosEnemigos);
    Scanner myobj = new Scanner(System.in);
    while (endedGame() == 0) { //Juego continua
      System.out.println("Hacer personajes esperar? (Responde lo que sea)\n");
      String respuesta = myobj.nextLine();
      System.out.printf("Respondiste = %s\n", respuesta); //Breakpoint
      
      makeCharacterswait();
      while (!queue.isEmpty()) {
        GameCharacter unknownCharacter = queue.poll();
        System.out.printf("Se saco a %s de la cola y su vida actual es de %d\n",
              unknownCharacter.toString(), unknownCharacter.getCurrentHp());
        System.out.println("Seguir con su ataque? (Responde lo que sea) \n");
        String seguir = myobj.nextLine();
        System.out.printf("Respuesta= %s\n", seguir);
        
        State characterState = unknownCharacter.getState();
        if (characterState.paralized()) {
          System.out.printf("El %s no se puede mover, pierde un turno\n", unknownCharacter);
          continue;
        }
        
        if (unknownCharacter.toString().contains("Enemy")) {
          Enemy enemy = (Enemy) unknownCharacter;
          if (characterState.dead()) {
            enemies.remove(enemy);
            continue;
          }
          if (charactersToplay.isEmpty()) {
            break;
          }
          enemy_isattacking(enemy); //Elige personaje random a atacar
        } else {
          if (characterState.dead()) {
            charactersToplay.remove(unknownCharacter);
            continue;
          }
          if (enemies.isEmpty()) {
            break;
          }
          if (unknownCharacter.toString().contains("BlackMage")) {
            BlackMage blackMage = (BlackMage) unknownCharacter;
            chooseBlackMageSpellorAttack(blackMage);
            
          } else if (unknownCharacter.toString().contains("WhiteMage")) {
            WhiteMage whiteMage = (WhiteMage) unknownCharacter;
            chooseWhiteMageSpellorAttack(whiteMage);
            
          } else {
            PlayerCharacter character = (PlayerCharacter) unknownCharacter;
            playercharacter_isattacking(character);
          }
  
        }
      }
      
    }
    finishGame();
  }
  
  /**
   * The makeCharacterswait method makes the characters in the arrayslist of
   * this GameDriver wait for their turn.
   */
  public void makeCharacterswait() throws InterruptedException {
    for (PlayerCharacter personaje : charactersToplay) {
      personaje.waitTurn();
    }
    for (Enemy enemigo : enemies) {
      enemigo.waitTurn();
    }
    Thread.sleep(5000);
  }
  
  /**
   * The enemy_isattacking makes an enemy to attack a player character
   * in the arraylist charactersToplay randomly.
   */
  public void enemy_isattacking(Enemy enemy) throws InvalidStatValueException {
    PlayerCharacter quienAtaca = charactersToplay.get(rng.nextInt(0, charactersToplay.size()));
    System.out.printf("El enemigo %s atacara a el personaje %s\n",
          enemy.toString(), quienAtaca.toString());
    enemy.attack(quienAtaca);
    //Attacks random player character
  }
  
  /**
   * The playercharacter_isattacking method makes a player character to attack
   * a random enemy in the arraylist enemies of the GameDriver.
   */
  public void playercharacter_isattacking(PlayerCharacter player) throws InvalidStatValueException {
    Enemy enemigo = enemies.get(rng.nextInt(0, enemies.size()));
    System.out.printf("El personaje %s atacara a el enemigo %s\n",
          player.toString(), enemigo.toString());
    player.attack(enemigo);
  }
  
  /**
   * The chooseBlackMageSpellorAttack method makes the decision of a BlackMage
   * to attack an enemy randomly or make a spell on this enemy.
   */
  public void chooseBlackMageSpellorAttack(BlackMage mage) throws InvalidStatValueException {
    Enemy enemigo = enemies.get(rng.nextInt(0, enemies.size()));
    int decision = rng.nextInt(3);
    if (decision == 0) {
      System.out.printf("El %s hara un hechizo de trueno a %s\n",
            mage.toString(), enemigo.toString());
      mage.makeThunderSpell(enemigo);
      
    } else if (decision == 1) {
      System.out.printf("El %s hara un hechizo de fuego a %s\n",
            mage.toString(), enemigo.toString());
      mage.makeFireSpell(enemigo);
    } else {
      System.out.printf("El %s atacara a %s\n", mage.toString(), enemigo.toString());
      mage.attack(enemigo);
    }
  }
  
  /**
   * The chooseWhiteMageSpellorAttack method makes the decision of a WhiteMage
   *  to attack an enemy randomly, make a spell on this enemy or cure an ally.
   */
  public void chooseWhiteMageSpellorAttack(WhiteMage mage) throws InvalidStatValueException {
    Enemy enemigo = enemies.get(rng.nextInt(0, enemies.size()));
    PlayerCharacter amigo = charactersToplay.get(rng.nextInt(0, charactersToplay.size()));
    int decision = rng.nextInt(4);
    if (decision == 0) {
      System.out.printf("El %s hara una curacion a %s\n", mage.toString(), amigo.toString());
      mage.makeCureSpell(amigo);
    
    } else if (decision == 1) {
      System.out.printf("El %s hara un hechizo de paralizacion a %s\n",
            mage.toString(), enemigo.toString());
      mage.makeParalizeSpell(enemigo);
      
    } else if (decision == 2) {
      System.out.printf("El %s hara un hechizo de envenenamiento a %s\n",
            mage.toString(), enemigo.toString());
      mage.makePoisonSpell(enemigo);
      
    } else {
      System.out.printf("El %s atacara a %s\n", mage.toString(), enemigo.toString());
      mage.attack(enemigo);
    }
  }
  
  /**
   * The changeWeapon method makes a player character change his current
   * weapon for another one. This new weapon can be accepted by the class
   * of the player character or not.
   */
  public void changeWeapon(PlayerCharacter character, Weapon arma) {
    Weapon previousWeapon = character.getEquippedWeapon();
    System.out.printf("Esta es la arma que se tenia equipada = %s\n", previousWeapon.toString());
    character.equip(arma);
    if (arma != previousWeapon) {
      System.out.printf("Se cambio la arma a la pedida = %s\n", arma.toString());
    }
  }
  
  /**
   * The cleanArrays method create new empty arraylists for the GameDriver.
   * This method is used to make new characters and start new games.
   */
  public void cleanArrays() {
    this.charactersToplay = new ArrayList<PlayerCharacter>();
    this.enemies = new ArrayList<Enemy>();
  }
  
  /**
   * The game ends when one of the two arrays in this class is empty, because when
   * a {@code GameCharacter} dies, it will be taken out of his array.
   */
  public int endedGame() {
    if ((this.charactersToplay).size() == 0 && (this.enemies).size() != 0) {
      return -1; // Los buenos perdieron
    } else if ((this.enemies).size() == 0 && (this.charactersToplay).size() != 0) {
      return 1;
    } else {
      return 0;
    }
  }
  
  /**
   * The finishGame method checks who won the game and sends a message
   * for every case.
   */
  public void finishGame() {
    int end = endedGame();
    if (end == 1) {
      System.out.println("FELICIDADES, has ganado esta batalla contra los malos.");
    } else if (end == -1) {
      System.out.println("Lamentablemente, perdiste esta batalla :(");
      
    }
  }
  
}
