# Observer Pattern (Behavioral Pattern)

- Defines a one-to-many dependency between between the object so that when one object changes state, all its dependents
are notified and updated accordingly.


#### Real world examples:

> - java.util.Observer
> - java.util.EventListener
> - javax.servlet.http.HttpSessionBindingListener

#### Applicability

> - When a change to one object requires changing others, and you don't know how many objects need to be changed
> - When and object should be able to notify other objects without making assumptions about who these objects are. In other words you don't want these objects tightly coupled.

#### Java world Examples

> - javax.servlet.http.HttpSessionBindingListener

#### Project Use Case

> - Whenever a trade state gets changed due to some external system Event (Like a matching event is received from counterparty) a notification has to send to upstream system regarding state of that trade.
> - For this we have different notifiers which are called based on type of trade. 
