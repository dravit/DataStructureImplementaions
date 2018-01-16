# Annotations

- Java introduced annotations in JAVA 5
- This is also called as declarative style of programming
- An annotation indicates that the declared element should be processed in some way by a 
compiler development tool, deployment tool or during runtime.
- Annotation types can store values in its members. (@interface declaration is used for annotation types)
- Values are passed from the place where annotations are defined i.e the place where annotation is used.

#### Annotation types
- Marker Annotation : An annotation with no element and parenthesis can be removed.
- Single member Annotation : Annotation with single element. Name of the element is "value" (this is must).
- Normal full Annotation : Have more than one element and elements can have default values.
    -   Values are assigned using name value pair and name value pair are separated by comma.
    
> @Target and @Retention is not mandatory but if not provided default values will be picked
- @Target is used to specify place where this annotation is applicable. Default value is Class.
- @Retention is used to specify the place till where this annotation will be applied. 
    - SOURCE - Discarded by compiler.
    - CLASS - Stored in class file but ignored by VM. This is Default value if not provided.
    - RUNTIME - Stored in class file and read by VM
    



> Note if @Override is used on a method which is not present in any of the superclasses it will show compile time error.