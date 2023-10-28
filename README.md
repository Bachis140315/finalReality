Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---
## New Adds
The main changes made in this branch of the original project are:
1. There is a new class called MagicWeapon, that inherited from the class NormalWeapon (originally, called
Weapon) and the difference between both is that a MagicWeapon has magicDamage as an attribute. 
Also, another enumeration was made for this kind of weapon, called MagicWeaponType, where it can be added
a lot more types of weapon that have magic, like wands a so on. An AbstractWeapon class was added too, to
make posible to add new kind of weapons that have new attributes and methods.


2. Every getter and setter was setted as a public method, otherwise it couldn't be prooved in the main 
function.


3. The AbstractMagicalPlayerCharacter class inherites from the AbstractPlayerCharacter class, and it was 
made for the characters that have Mp (Magic Points), including their respects getters and setter for the 
Mp. This way more classes of characters that have magic can be implemented, like a Wizard or Fairy class
and many others.

----
## How to use

Be careful when creating a NormalWeapon, this class has two constructors, one for the NormalWeapon and the
other for the MagicWeapon. The MagicWeapon constructor is protected and needs a MagicWeaponType in the 'type' parameter,
so when a NormalWeapon is created, it is not allowed to give a type from the MagicWeaponType enum., only 
from the NormalWeapon enumeration. 

In the case that a playable character is made, that has Mp, it will require a number greater than 0, otherwise
in the game, a playable character that has 0 Mp, is like a normal character that hasn't the abbiity to use
Mp for spells, for example. 

For last advice but not least, if two objects were made (from every class), and those two objects have the
same attributes, same numbers, name and so on, they will be the same character, otherwise they will not be 
the same.

---

## Tests

Each class made in this project has another related class that tests its methods. Those tests guarantee that 
those methods will work in different scenarios, scenarios that can break at some point the game that this
project was made for. Every test class has a coverage of at least 90% of the methods tested and shows in depht
how these methods work, what kind of scenarios they accept or not and how they react against things that were
not supposed to be there.
