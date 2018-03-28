# Abstract Factory (Creational Pattern)

A factory of factories; a factory that groups the individual but related/dependent factories together without specifying their concrete classes.

#### Real World Example

> To create a kingdom we need objects with common theme. Elven kingdom needs an Elven king, Elven castle and Elven army whereas Orcish kingdom needs an Orcish king, Orcish castle and Orcish army. There is a dependency between the objects in the kingdom.

#### Applicability

> - You need to supply one or more parameters only known at run-time before you can resolve a dependency
> - You want to decide which product to call from a family at run time.

#### Consequences

> Dependency injection in java hides the service class dependency that can ead to runtime errors that would have been caught at compile time.

#### Project Use Case

> - Confirmation of Trade can happen over different mediums (SWIFT, EMAIL, FAX, OPTS). 
> - Which medium will be picked is decided at runtime and that ConfirmationMediumFactory provides object of particular confirmation Method.
