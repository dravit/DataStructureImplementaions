package customAnnotations.sharingData;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationInterceptor {

    public static <T> void inject(Class<T> resolveClass, T resolveInstance) {
        Field[] fields = resolveClass.getDeclaredFields();

        if(fields != null) {
            for(Field field : fields) {
                CustomAnnotation annotation = field.getAnnotation(CustomAnnotation.class);
                if(annotation != null) {
                    try {
                        field.setAccessible(true);                      //Here we are setting it as true to make field accessible.
                        field.set(resolveInstance, annotation.value());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Annotation is not present on field "+ field.getName());
                }
            }
        } else {
            System.out.println("Fields array is null !");
        }

        Method[] declaredMethods = resolveClass.getDeclaredMethods();
        if(declaredMethods != null) {
            for(Method method : declaredMethods) {
                CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);
                if(annotation != null) {
                    try {
                        method.invoke(resolveInstance, annotation.value());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    /*Parameter[] parameters = method.getParameters();
                    if(parameters != null) {
                        for(Parameter parameter : parameters) {
                            parameter.
                        }
                    }*/

                }
            }
        }
    }
}
