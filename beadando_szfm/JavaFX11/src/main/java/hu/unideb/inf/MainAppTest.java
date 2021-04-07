package hu.unideb.inf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MainAppTest {

    private MainApp app = null;

    @BeforeEach
    void setUp() {
        app = new MainApp();
    }

    @ParameterizedTest
    @MethodSource
    void registerPwTest(String pwd1, String pwd2, boolean exp){

        Assertions.assertEquals(app.registerPw(pwd1,pwd2), exp);

    }
    private static Stream<Arguments> registerPwTest(){
        return Stream.of(
                arguments("jelszo123","jelszo123", true),
                arguments("jelszo2021","jelszo123", false),
                arguments("JELszo","jelszo", false),
                arguments("j3lsz02o2I","Jelszo1999", false),
                arguments("&@Jelszo2021","&@Jelszo2021", true)
        );
    }
}