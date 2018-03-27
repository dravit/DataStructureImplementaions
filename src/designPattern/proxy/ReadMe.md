# Proxy Pattern (Structural Pattern)

Basically it wraps an object(**_IvoryTower_**) and act as a proxy(**_WizardTowerProxy_**) between the calls to 
object(_b/w IvoryTower and Wizard_).

### Type of Proxies
There are multiple cases where proxy pattern can be used:

- **Protection proxy** limits access to the real Object(**_IvoryTower_**). 
Based on some conditions proxy(**_WizardTowerProxy_**) filters the calls and some of them are let through to 
the real Object(**_IvoryTower_**)

- **Virtual proxy** 
Virtual proxies are used when object is expensive to instantiate. In the implementation proxy manages the lifetime of object. It decides when the instance creation is needed and when it can be reused. Virtual proxies are used to optimize performance.

- **Caching proxies** are used to cache expensive calls to real Object. There are multiple caching techniques that proxy can use. Some examples are read-through, write-through, cache-aside and time-based. The caching proxies are uses to enhance performance.

- **Remote proxies** are used in distributed object communication. Invoking a local object method on the remote proxy causes execution on the remote object.

- **Smart proxies** are used to implement reference counting and log calls to the object.