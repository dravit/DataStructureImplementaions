package customAnnotations.sharingData;

/**
 * This is a perfect example how @Autowired is implemented in Spring
 */
public class CustomAnnotationUsages {

    @CustomAnnotation("Welcome to annotation world!")
    private String annotatedField;

    private String methodAnnotation;

    public static void main(String[] args) {
        CustomAnnotationUsages object = new CustomAnnotationUsages();
        AnnotationInterceptor.inject(CustomAnnotationUsages.class, object);
        System.out.println(object.annotatedField);
        System.out.println(object.methodAnnotation);
    }

    @CustomAnnotation("This is used on method")
    public void setMethodAnnotation(String methodAnnotationVal) {
        this.methodAnnotation = methodAnnotationVal;
    }
}
