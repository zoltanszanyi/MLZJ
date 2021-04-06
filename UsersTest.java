import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(PER_CLASS)

class UsersTest {

    private Users user = null;

    @BeforeEach
    void setUp() {
        user = new Users(1,"email@gmail.com","Jelsz@1999");
    }

    @Test
    void checkPasswordTest() {
        boolean result = user.checkPassword(user.getPassword());
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource
    void checkPasswordTest2(String psw, boolean exp){
        Assertions.assertEquals(user.checkPassword(psw), exp);
    }

    private List<Arguments> checkPasswordTest2(){

        String p1 = "Jelszo2020";
        boolean exp1 = false;
        String p2 = "jelszo&@2020";
        boolean exp2 = false;
        String p3 = "Jelszo@2020";
        boolean exp3 = true;
        String p4 = "Je#20";
        boolean exp4 = false;
        String p5 = "JeLSZO#2021";
        boolean exp5 = true;
        String p6 = "hj";
        boolean exp6 = false;
        String p7 = "jelszo,.2021";
        boolean exp7 = false;

        return Arrays.asList(
                Arguments.of(p1,exp1),
                Arguments.of(p2,exp2),
                Arguments.of(p3,exp3),
                Arguments.of(p4,exp4),
                Arguments.of(p5,exp5),
                Arguments.of(p6,exp6),
                Arguments.of(p7,exp7)
        );

    }
}