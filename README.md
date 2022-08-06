# Class Project
Author: Nuwapa Promchotichai (Prim) U45776029, pnuwapa@bu.edu
Class: MET CS665 Spring 2022

## Application Description

The concept of this project is to create a weapon shop system for a game. The whole application is split into two main parts. First part encapsulates the method for the user to place a weapon customization order by picking weapon type, material, and the enhancement. The user will first pick a weapon type (sword, dagger, or spear) and the main material (wood, aluminum, gold, iridium) of the weapon. The system will then check if there is enough material inside the inventory. If there is enough material, the user will proceed to pick enhancement for the weapon (Magic Damage, Damage Boost, Critical Hit, or No enhancement). If there is not enough material in the inventory, the user will be asked to pick the new material for the weapon. After picking enhancement, the system will calculate the price of the weapon customization and list all the ability values of the weapon to the user.  Every weapon type and material has base ability values and the enhancements are just an upgrade to those ability values.
  
  The second part is the weapon shop order processing system which is done by notifying all their blacksmiths to complete the weapon customization order. After the user finishes picking a weapon customization order, the order request is sent to all blacksmiths available in the shop. Blacksmith will get to work on the order request on a first come, first served basis (implemented using Java queue). Blacksmiths which are done crafting orders will be placed back on the queue.
  
  The project is designed so that it requires no command line input. All the systems described above are implemented via Java class/methods which you need to call and provide the parameter yourselves to demo the application. I have provided a basic demonstration inside Main.java and provided this [file](https://github.com/metcs/met-cs665-assignment-project-primnp/blob/master/for_readme/main_log.txt) as an example response from the application. The 4 patterns used in this project are **Bridge, Abstract Factory, Singleton, and Observer.**

## What are the design goals in your project?
  Two main design goals for my project are understandability and maintainability. Understandability means that the application should be easily understandable and have modularity. To achieve this, I aim to split my design into smaller parts then use these parts to perform different functions. Essentially, I aim to subdivide my system into smaller classes, not just have everything in one big class.  The usage of patterns like bridge and abstract factory helps with modularity of the application. 
  
  As for maintainability, I want to ensure that my software design is easily amenable, so that future modifications can be done with ease. I aim to incorporate abstraction/ interface into my application to reduce complexity. Higher levels of abstraction will cover a range of basic methods required to execute a feature,  and more detailed methods  for the feature will be given at a lower level of abstraction. This creates efficiency when modifying the code. The abstraction/ interface will allow users to add new subclasses to the system without having to modify the whole program. 
  
## How is the flexibility of your implementation, e.g., how you add or remove in future new types? 
  I implemented the **abstract factory pattern** to create a weapon based on the specified weapon type of sword, dagger, or spear. Abstract factory pattern provides an interface for creating families of related/dependent objects without specifying their concrete class. WeaponFactory is the concrete factory implementation which is used to create a sword, dagger, or spear based on the input from the user. Concrete product class implementations in the project are Sword, Dagger, and Spear class. The concrete product  implementation consists of methods to ```getWeaponType()``` and ```getWeaponPrice()``` and also other methods to get ability values of the weapon (e.g. ```damageDealtVal()```, ```agilityVal()```). The implementation of an abstract factory allows for flexibility. If developers want to add more weapon types to the project, they can do so by adding more subclasses to the weapon class, and specify creation methods inside WeaponFactory.
  
  In addition to using the abstract factory pattern, I also implemented the **bridge pattern** for the creation of the weapon process. WeaponFactory has Material composition. Material also has its subclasses of Wood, Aluminum, Gold, and Iridium. The ```createWeapon(String, Material)``` method inside the WeaponFactory class has parameters of weapon type and material object. Bridge pattern allows for creation of an object without the need to create many duplicated subclasses. Now when you call ```createWeapon(String, Material)```, you will create the specified weapon with the specified material. The bridge pattern allows for flexibility and modularity for the Material class. Developers can add more material type by adding subclasses to Material class instead of creating more inheritance from Weapon.
  
  Bridge pattern also gets applied to the ‘adding enhancement to weapon order’ process. WeaponOrderWithEnhancement class has an Enhancement composition. The Enhancement class has subclasses of MagicDamage, DamageBoost, CriticalHit, and NoEnhancement. ```WeaponOrderWithEnhancement(Weapon, Enhancement)``` constructor has parameters of weapon object and enhancement object. ```createFinalOrderWithEnhancement(Enhancement)``` method inside WeaponOrder class will invoke the WeaponOrderWithEnhancement constructor. The final order of specified weapon type and specified enhancement is created using the bridge pattern to avoid duplicated inheritance. Note that there are two bridge patterns instead of one because the user will be checked for material inventory before he/she is allowed to pick enhancement for the weapon.
  
  The next pattern I implemented for the project is the **singleton pattern**. I implemented a singleton pattern for the MaterialInventory class because I only want one instance of the inventory.  MaterialInventory class acts as a database to store all material (wood, aluminum, gold, iridium) inventory. I only need one database for the project and singleton ensures that only one instance will be created. MaterialInventory is a ```HashMap<String, Integer>```. Users can easily modify the hashmap according to the available weapon type. A future improvement for this would be to directly create a HashMap of a Weapon object for greater flexibility.
  
  The last pattern I implemented is the **observer pattern**. This pattern was implemented specifically for the **order processing** part of the application. The three other patterns mentioned earlier were used for the **weapon customization** part of the application. A shop receives the order of WeaponOrderWithEnhancement. When a shop receives a new order, all blacksmiths available will be broadcasted with a new order request. The Shop class is a concrete subject implementation. The Shop class has an ```ArrayList<WeaponOrderWithEnhancement>``` to keep track of orders coming in and has a ```notifyRequest(Object)``` method to broadcast new order requests to all available blacksmiths. The Blacksmith class is the concrete observer implementation which gets notified of order requests from Shop class and observes the Shop. The Shop class also has OrderRequest composition so users can assign an order request to the blacksmith inside the Shop class via ```assignBlacksmith(WeaponOrderWithEnhancement)```. The OrderRequest class has a method to keep track of all assigned blacksmiths in the system.  Overall, the implementation makes the process of adding more drivers and orders quite flexible. In addition, the implementation also helps automates the notification process. Once the orders get updated via shop class, all blacksmiths will be notified of the order request. The blacksmiths are assigned order requests on a first come, first served basis. 
  
## How is the simplicity and understandability of your implementation?
  The implementation for the **weapon customization** part is quite straightforward. Inside the WeaponOrder class, we have 3 main methods: ```createWeaponOrder(String, Material)```, ```processOrder()```, and ```createFinalOrderWithEnhancement(Enhancement)```. ```createWeaponOrder(String, Material)``` method invokes the createWeapon method from WeaponFactory class to create a specified weapon of specified type. ```processOrder()``` method checks the inventory from MaterialInventory and tells the user whether the specified material is available or not. ```createFinalOrderWithEnhancement(Enhancement)``` method creates a new WeaponOrderWithEnhancement object with a bridge pattern. It takes in the weapon object (consists of weapon type and material) and the enhancement object.  WeaponOrderWithEnhancment class consists of method to get all the ability values of the final weapon object (e.g. ```magicPierceFinalVal()```, ```accuracyFinalVal()```). It also has the method ```getTotalPrice()``` to get the total price of the weapon with enhancement and ```getFinalOrderType()``` to get the final weapon customization order detail (e.g. Wood Sword with Damage Boost).
  
  For the **order processing** part, the implementation is also straightforward. The main features of the application are: notify all blacksmiths of the new order request and assign a blacksmith to an order request. Inside the Shop class, we have 3 main methods for observer pattern: ```attach```, ```detach```, and ```notifyRequest```. Attach method is used for when a user wants to add more blacksmiths to the system. The Shop class also has 3 other methods: ```addOrder```, ```assignBlacksmith```, and ```doneOrder```. ```addOrder``` class invokes ```notifyRequest```. So whenever a user adds a new order, all blacksmiths in the system will be notified of the update. Via Shop class we can also assign a blacksmith to an order (assignBlacksmith) with a method from the OrderRequest class. ```doneOrder``` is similar, it uses a method from the OrderRequest class to update the number of available blacksmiths and put the blacksmith which has finished the order back into the queue. To further elaborate on the assigning order to the blacksmith, all the blacksmiths added to the system are added to a Java queue. They get assigned orders on the first come, first served basis. Once the blacksmith is assigned an order, he/she is removed from the queue. When a blacksmith is finished crafting the order, he/she gets put back into the queue.

## How did you avoid duplicated code?
  For the **weapon customization** part of the application, I implemented inheritance for the AbstractFactory interface and Weapon interface to avoid duplicating methods when creating a new weapon subclass. I also make sure that methods or fields which perform the exact same function are located at the highest level of abstraction/ inheritance. I also create an AbilityVal interface containing methods for getting ability values to which Weapon and Enhancement classes inherit from. This was done to avoid duplication of methods since weapon and enhancement both have base fields of ability values. WeaponOrderWithEnhancement also has an Enhancement composition (bridge pattern). Similarly, the WeaponFactory also has Material composition. The usage of bridge pattern decouples abstraction from implementation and helps avoid the need to create subclasses repeatedly. It also extends classes in orthogonal (independent) dimensions.
  
  For the **order processing** part of the application, I implemented a composition and aggregation for OrderRequest and WeaponOrderWithEnhancement class respectively. Aggregation allows for reuse of the WeaponOrderWithEnhancement variable inside Shop class. While composition allows the system to manage OrderRequest via Shop class. 


## UML Class Diagram
(click the image for bigger picture)
![UML diagram](https://github.com/metcs/met-cs665-assignment-project-primnp/blob/master/for_readme/UML_project.png)

---

# Project Template

This is a Java Maven Project Template


# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

# Run all the unit test classes.


```bash
mvn clean compile test checkstyle:check  spotbugs:check
```

# Using Spotbugs to find bugs in your project 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn spotbugs:gui 
```

or 


```bash
mvn spotbugs:spotbugs
```


```bash
mvn spotbugs:check 
```

check goal runs analysis like spotbugs goal, and make the build failed if it found any bugs. 


For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html


SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```




