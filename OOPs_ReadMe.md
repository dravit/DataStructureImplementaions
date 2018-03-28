# OOPs Principles / Design Principles

#### Encapsulation

- Encapsulation means that the internal representation of an object is generally hidden from outside of object's definition.
- Typically the object's own methods can directly inspect or manipulate its fields

#### DRY (Don't Repeat Yourself) 
- avoid duplication in code.

#### Encapsulate what changes 
- hides the implementation details, helps in maintenance

#### Open Closed Design Principle 
- Open for Extension but closed for Modification

#### SRP (Single Responsibility Principle) 
- One class should do only one and do it well
- There should not be more than one reason for a class to change.

#### DIP (Dependency Inversion Principle) 
- Don't ask, let framework give you
- E.g is Spring framework
- Easy to test using mock objects
- Easy to maintain as object creation code is centralized in framework and client code is not littered with that.

#### Favour composition over inheritance 
- Code reuse without cost of inflexibility
- Composition allows changing behaviour of a class at runtime

#### LSP (Liskov Substitution Principle) 
- Sub type must be substitutable for super type
- E.g If a mthod is expecting List you can also pass ArrayList or LinkedList

#### ISP (Interface Segregation Principle) 
- Avoid monolithic(asking to do many things) interface, reduce pain on client side.
- One interface should contain one functionality
- Client should not have to implement an interface if it doesn't use it.

#### Programming for Interface 
- Helps in maintenance, improves flexibility
- Always program for the interface and not to implementation.
- This will lead to flexible code which can work with any new implementation of the interface.
- Use interface type on variables, return types of method or argument type of methods in Java

#### Delegation Principle 
- Don't do all thing by yourself, delegate it to respective class.
- Classic example of delegation Design principle is equals() and hashcode() method in java. 
- In order to compare two objects for equality, we ask class itself to do comparison instead of Client class doing that.
- Key benefir of this design principle is no duplication of code and pretty easy to modify behaviour.

#### Method Hiding
- Since static methods are cannot be overridden, but if you declare same static method in subclass that would hide the method from superclass.
- If you call method from Superclass reference superclass method will be called.
