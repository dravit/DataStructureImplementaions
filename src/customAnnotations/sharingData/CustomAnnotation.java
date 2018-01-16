package customAnnotations.sharingData;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
public @interface CustomAnnotation {
    String value();     //This should always be value in single annotation case otherwise it will give error at
    // the place where it is used. Or if changes we have to use it parameterName = "{value}"
}
