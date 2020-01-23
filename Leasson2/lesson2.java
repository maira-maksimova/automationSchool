
// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HikerTest {

    @Test
    void testComplexitySingleWordWithSyllablesAndR() {
        double actual = Hiker.getWordComplexity("Rita");
        assertEquals(2, actual);
    }
    
    @Test
    void testComplexityAllLoweCase() {
        double actual = Hiker.getWordComplexity("margarīns");
        assertEquals(3.5, actual);
    }
    
    @Test
    void testComplexityAllUpperCase() {
        double actual = Hiker.getWordComplexity("MARGARĪNS");
        assertEquals(3.5, actual);
    }
    
    @Test
    void testComplexityWithoutR() {
        double actual = Hiker.getWordComplexity("Maija");
        assertEquals(1.5, actual);
    }
    
    @Test
    void testComplexityWithoutSyllablesWithR() { 
        double actual = Hiker.getWordComplexity("Strbck");
        assertEquals(1, actual);
    }
    
    @Test
    void testComplexityWithoutSyllablesAndR() { 
        double actual = Hiker.getWordComplexity("Stbck");
        assertEquals(0, actual);
    }
    
    @Test
    void testComplexityWithEmptyString() { 
        double actual = Hiker.getWordComplexity("");
        assertEquals(0, actual);
    }
    
    @Test
    void testComplexityOnlySyllables() { 
        double actual = Hiker.getWordComplexity("aāeēiīouū");
        assertEquals(4.5, actual);
    }
    
    @Test
    void testComplexitySingleSyllable() { 
        double actual = Hiker.getWordComplexity("a");
        assertEquals(0.5, actual);
    }
    
    @Test
    void testComplexitySingleR() { 
        double actual = Hiker.getWordComplexity("R");
        assertEquals(1, actual);
    }
    
    @Test
    void testComplexityOnlyMultipleR() { 
        double actual = Hiker.getWordComplexity("rRr");
        assertEquals(3, actual);
    }
    
    @Test
    void testComplexityMultipleWords() { 
        double actual = Hiker.getWordComplexity("Name Surname");
        assertEquals(3.5, actual);
    }
    
    @Test
    void testComplexitRussian() { 
        double actual = Hiker.getWordComplexity("текст");
        assertEquals(0, actual);
    }
   
    
}
