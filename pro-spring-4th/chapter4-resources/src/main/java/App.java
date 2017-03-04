import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

/**
 * @author Andrii Sysoiev
 */
public class App {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();

        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();

        Resource res1 = ctx.getResource("file://" + file.getPath());
        printResourceInformation(res1);
        Resource res2 = ctx.getResource("classpath:test.txt");
        printResourceInformation(res2);
        Resource res3 = ctx.getResource("www.google.com");
        printResourceInformation(res3);
    }

    private static void printResourceInformation(Resource res) throws IOException {
        System.out.println(res.getClass());
//        System.out.println(res.getURL().getContent());
        System.out.println("");
    }

}
