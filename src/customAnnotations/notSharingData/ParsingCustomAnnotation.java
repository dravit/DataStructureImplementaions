package customAnnotations.notSharingData;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParsingCustomAnnotation {

    public static void main(String[] args) {
        try {
            for(Method method : ParsingCustomAnnotation.class.getClassLoader()
                    .loadClass("customAnnotations.notSharingData.AnnotationUsages").getMethods()) {
                if(method.isAnnotationPresent(MethodInfo.class)) {
                    for(Annotation annotation : method.getDeclaredAnnotations()) {
                        System.out.println("Annotation In method : " + method + " : " + annotation);
                    }
                    MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                    if(methodInfo.revision() == 1) {
                        System.out.println("Method with revision no 1 : " + method);
                    }
                }
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
    }
}
