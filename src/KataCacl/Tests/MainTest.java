package KataCacl.Tests;

import KataCacl.MyExeption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static KataCacl.Main.calc;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Correct Roman examples")
    void main() throws MyExeption {
        String[][] testDataRoman = {{
                "I+I", "II", "Correct Roman example",
        }, {
                "I+II", "III", "Correct Roman example",
        }, {
                "II+II", "IV", "Correct Roman example",
        }, {
                "III+II", "V", "Correct Roman example",
        }, {
                "X+IX", "XIX", "Correct Roman example",
        }, {
                "X\\II", "V", "Correct Roman example",
        }, {
                "X*X", "C", "Correct Roman example",
        }, {
                "X*V", "L", "Correct Roman example",
        }
        };
        for (String[] data : testDataRoman) {
            assertEquals(data[1], calc(data[0]), data[2]);
        }
    }

    @Test
    @DisplayName("Incorrect Roman examples")
    void exceptionTesting() {
        Throwable exception =
                assertThrows(MyExeption.class, () ->
                        calc("IIII+I"));
        assertEquals("Incorrect Roman string!", exception.getMessage());

        exception = assertThrows(MyExeption.class, () ->
                calc("XI+I"));
        assertEquals("Incorrect Roman string!", exception.getMessage());

        exception = assertThrows(MyExeption.class, () ->
                calc("II\\X"));
        assertEquals("Roman nums cannot be less than I", exception.getMessage());

        exception = assertThrows(MyExeption.class, () ->
                calc("I-IV"));
        assertEquals("Roman nums cannot be less than I", exception.getMessage());
    }
}

