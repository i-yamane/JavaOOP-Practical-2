# TP2: OOP like a boss
> After [Samuel toubon](http://wikisamuel.github.io/java/#/)'s modification of [Olivier Levitt](https://formations.levitt.fr/poo-java/#/)'s job.

* Use of advanced OOP concepts
* New various features for the application 
* Creation and comparison of simple AIs


## WARNING
This is the version for students working online on [repl.it](https://www.repl.it) platform. If you want to work with Eclipse on school's virtual machines, take a look at [corresponding guidelines](guidelines_for_practical_session_on_virtual_machine.md).


## Starting point

* For this practical work, we will start from where we ended last week
* You can either use your code from last week or start a new [repl.it](https://www.repl.it) project from [github.com/gaudel/java_PS2](https://github.com/gaudel/java_PS2) GitHub's repository.
* Take some time to make sure you understand the code and what it is doing. Feel obviously free to ask questions about it



## 1. Cleanup

* During practical session 1, all attributes where defined as `public`. What issues do you think this choice may lead to ?

Using as much IDE's power as we can,
<br />we are going to refactor the code to respect encapsulation,
<br />i.e. for all classes:

* Make the relevant attributes `private`
* Write getters and setters
* Define useful constructors (if needed)
* Change the `Main` class accordingly



## 2. Items
  
* Pokemons will now be able to use various kinds of items. All items have a name and a price (the price it costs at the pokeshop) and a usage type (either permanent, one use or unusable)  
	* By default, all items have the following `String` representation: `"name (price pokedollars)"`
* Sweets are items 
* Pokeballs also are items. A pokeball has a base efficiency (an integer between 0 and 100) and an efficiency multiplier which depends on its type. 
	* Simple pokeballs do not exist. A pokeball is always special. 2 types of pokeballs currently exist: `Ultraball` (with a multiplier of 2) and `Greatball` (with a multiplier of 3)  
	* For all pokeballs, we need to know the real efficiency which is calculated as follows: `base efficiency * multiplier`



## 3. Inventory and a unique player
  
The player now has access to an inventory    

* Create an empty `Inventory` class. Inventory will soon contain the list of all items the player currently have.
* Create a player class with an `Inventory` attribute. In this game, there will always be only one player. This player should be accessible from anywhere in the application. The player won't change during gameplay.  



## 4. Lot of stuff
  
To implement the inventory, we need the appropriate data structure 

* Take a look at List interface: [https://docs.oracle.com/javase/8/docs/api/java/util/List.html](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)  
* Take a look at ArrayList class (implementation): [https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)  
* Add a list of items to the `Inventory` class
* Within the `main()` method, add some items to the player's inventory 
* Add a `totalPrice()` method to this inventory. It returns the total price of all items contained in the inventory
* Inside main, once it's filled, display the total price of the inventory

> Sidequest: rewrite `Inventory`'s [`toString()`](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#toString--) method to display the list of all item owned

<!-- -->
> Sidequest: notice there are other List implementations:[https://docs.oracle.com/javase/tutorial/collections/implementations/list.html](https://docs.oracle.com/javase/tutorial/collections/implementations/list.html)



## (bonus) 5. More action
  
Before writing AIs, we need to add more depth to fights

* Pokemons can now defend. Add a defense score (between 0 and 90). This will be the percentage of damage that will be mitigated on each attack  
* Write a defend() method that increases the defense score by 10 (up to a maximum of 90)
* The logic for damage dealt change slightly. It is now: attacker's strength * (1 - target's defense score / 100). Every attack deals at least 1 damage.  
* Simulate a fight in which one of the pokemon defends for 3 turns



## (bonus) 6. AI may be the future  
Let's write some very basic AI that will be able to decide the best move each time

* Create an AI implementation wich acts as follow: the "brute" one constantly attacks
* Test your AI creating a Pokemon fight
* Create a second AI implementation: the "vicious" one that defends until it reachs 90 defense and then attacks
* Make the 2 AI fight using the pokemons you want
* What do both AI implementations have in common ? Define the signature of an AI method
* Create the corresponding AI interface and make both AI implement it
* Create a third implementation using your own algorithm

> Sidequest: write an AI tournament. They compete against each other. Each won fight (using generated pokemon data) scores 1 point for the winning AI



## Going deeper
 
 
* Checkout the code from Olivier Levitt's repository [https://bitbucket.org/olevitt/formations/src/master/poo-java/TPs/TP2/](https://bitbucket.org/olevitt/formations/src/master/poo-java/TPs/TP2/). You will find a correction for current practical session. Copy the `IAGeniale` class and make it fight your own AI. Improve your own AI until it beats `IAGeniale` (which, in reality, is not that *geniale*)
* Make your AI compete against other AI in the room
* (Going a whole lot deeper) generate a large amount of data `(state of pokemon1, state of pokemon2, action) => fight's result`. Using deep learning on this data, create an AI. Make it compete with other AIs