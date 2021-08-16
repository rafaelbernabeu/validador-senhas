package validadores;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class ValidaDigitosTest {

    @Inject
    ValidaDigitos validaDigitos;

    @ParameterizedTest
    @ValueSource(strings = {
            "0","a1","abc4","AbTp9!fok","aBtP0@FOK","kof#1pTbA","KOF$2PtBa"
    })
    public void isValidoTest(String senha) {
        assertTrue(validaDigitos.isValido(senha));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "AabC","AbTpdfokA","aBtPasFBK","kofTgpfbA","KOFbTPtBa"
    })
    public void isNaoValidoTest(String senha) {
        assertFalse(validaDigitos.isValido(senha));
    }

}
