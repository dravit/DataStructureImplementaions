package customAnnotations;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class AnnotationUsages {

    public static void main(String[] args) {

    }

    @Override
    @MethodInfo(author = "custom Annotation", date = "15 Jan 2018", comments = "No Comments", revision = 1)
    public String toString() {
        return "Overridden toString Method.";
    }

    @Deprecated
    @MethodInfo(comments = "Deprecated Method", date = "14 Jan 2018")
    public void oldMethod() {
        System.out.println("This is old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "depreciation"})
    @MethodInfo(comments = "Main Method", date = "16 Jan 2018")
    public void genericsTest() throws FileNotFoundException {
        List list = new ArrayList();
        list.add("abc");
        oldMethod();
    }
}
