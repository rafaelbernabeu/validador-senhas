package validadores;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class ValidaLetraMinusculaTest {

    @Inject
    ValidaLetraMinuscula validaLetraMinuscula;

    @ParameterizedTest
    @ValueSource(strings = {
            "a","a1","0000000a","ABCDe4","AbTp9!fok","aBtP0@FOK","kof#1pTbA","KOF$2PtBa"
    })
    public void isValidoTest(String senha) {
        assertTrue(validaLetraMinuscula.isValido(senha));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "ABCDE","0000000","12345","!@#$%&*","KOFBTPTBA"
    })
    public void isNaoValidoTest(String senha) {
        assertFalse(validaLetraMinuscula.isValido(senha));
    }

}
