import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import ru.geekbrains.Calculation;

import static org.slf4j.LoggerFactory.getLogger;

public class CalculationTest {

    static final Logger log = getLogger(CalculationTest.class);

    @BeforeAll
    static void setUp(){
        log.info("\t START TESTING =>");
    }

    @AfterAll
    static void tearDown(){
        log.info("\t END TESTING =>");
    }

    @BeforeEach
    void setUpEach(){
        log.info("\t\t TEST RUN =>");
    }

    @AfterEach
    void tearDownEach(){
        log.info("\t\t TEST FINISH =>");
    }

    @DisplayName("Расчет площади триугольника по трем сторонам с заданными значениями.")
    @Test
    void testCalculatingArea(){
        log.info("\t\t\tSTART SIMPLE TEST");

        double actResult = Calculation.calculatingArea(3, 4, 5);
        double expResult = 6;

        Assertions.assertEquals(expResult, actResult);

        log.info("\t\t\tEND SIMPLE TEST");
    }
//    @Disabled("проверка работы аннотации \"Disabled\"")
//    @Test
//    void testCalculatingAreaNew(){
//        log.info("\t\t\tSTART SIMPLE TEST");
//
//        double actResult = Calculation.calculatingArea(3, 4, 5);
//        double expResult = 6;
//
//        Assertions.assertEquals(expResult, actResult);
//
//        log.info("\t\t\tEND SIMPLE TEST");
//    }

    @DisplayName("Тест повторяющийся 5 раз")
    @RepeatedTest(5)
//    @Test
    void testCalculatingRepeated(){
        log.info("\t\t\tSTART REPEATING TEST");

        int a = (int) Math.abs(Math.random() * 100);
        int b = (int) Math.abs(Math.random() * 100);
        int c = (int) Math.abs(Math.random() * 100);

        double actResult = Calculation.calculatingArea(a, b, c);
        int p = (a + b + c) / 2;
        double expResult = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        Assertions.assertEquals(expResult, actResult);

        log.info("\t\t\tEND REPEATING TEST");
    }

    @DisplayName("Параметризированый тест \"CsvSource\"")
    @ParameterizedTest(name="#{index}- Test with Argument={arguments}")
    @CsvSource({
            "1, 2, 9",
            "3, 4, 5",
            "6, 7, 8"
    })
    void testCalculatingRepeatedPar(int a, int b, int c){
        log.info("\t\t\tSTART Parameterized TEST");

        double actResult = Calculation.calculatingArea(a, b, c);
        int p = (a + b + c) / 2;
        double expResult = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        Assertions.assertEquals(expResult, actResult);

        log.info("\t\t\tEND Parameterized TEST");
    }
}
