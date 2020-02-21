import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class APIBaseClass {
    protected static Properties pro;
    @BeforeAll
    public void setUp() throws IOException
    {
        System.out.println("in BeforeClass");
        /**
         * Load the Property File
         */
        // Create  FileInputStream object
        FileInputStream fis=new FileInputStream(new File("config.properties"));

        // Create Properties class object to read properties file
        pro=new Properties();

        // Load file so we can use into our script
        pro.load(fis);



    }

}