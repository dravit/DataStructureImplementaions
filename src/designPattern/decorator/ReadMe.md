# Decorator Pattern (Structural Pattern)

- It is also known as Wrapper
- It Attaches additional responsibilities to an object dynamically. Decorator provide a flexible alternative to 
subclassing or extending functionality.

#### Real world example

> There is an angry toll living in the near by hills. Usually it goes bare handed but sometimes it has a weapon.
> To arm the troll it is not necessary new troll but to decorate it dynamically with a suitable weapon.

#### In Plain words

> Decorator pattern lets you dynamically change the behaviour of an object at run time by wrapping them in an object of a decorator class.

#### Applicability

> - To add responsibility to individual objects dynamically and transparently, that is, without affecting other objects.
> - For responsibility that can be withdrawn.
> - When extension by subclassing is impractical. Sometimes a large number of independent extensions are possible and would produce an
explosion of subclasses to support every combination. Or a class definition may be hidden or unavailable for subclassing.

#### Java world Examples

> java.io.InputStream, java.io.OutStream, java.io.Reader & java.io.writer

#### Project Use Case

> - A Structure trade contains different type of components (Vanilla, Exotic etc.). Based on component type different enrichment data is provided to that structure object apart from basic enrichment data.
> - To perform that a Decorated Structure Class is in place, which contains different enrichment methods for different type of components.