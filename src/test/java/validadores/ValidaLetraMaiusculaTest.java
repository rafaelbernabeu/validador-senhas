package validadores;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class ValidaLetraMaiusculaTest {

    @Inject
    ValidaLetraMaiuscula validaLetraMaiuscula;

    @ParameterizedTest
    @ValueSource(strings = {
            "00000000A","abcDefg","A0000000","AbTp9!fok","aBtP0@FOK","kof#1pTbA","KOF$2PtBa"
    })
    public void isValidoTest(String senha) {
        assertTrue(validaLetraMaiuscula.isValido(senha));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "abcdefg","!@#$%*&","0000000","123456","kofbtptba"
    })
    public void isNaoValidoTest(String senha) {
        assertFalse(validaLetraMaiuscula.isValido(senha));
    }

}
