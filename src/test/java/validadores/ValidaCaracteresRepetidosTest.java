package validadores;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class ValidaCaracteresRepetidosTest {

    @Inject
    ValidaCaracteresRepetidos validaCaracteresRepetidos;

    @ParameterizedTest
    @ValueSource(strings = {
            "AaBbCcDd","1234567","abcdefg","!@#$%*&"
    })
    public void isValidoTest(String senha) {
        assertTrue(validaCaracteresRepetidos.isValido(senha));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "AA", "11", "!3!", "AbTp90fokA","aBtP91FBK","kof29pfbA","KOF33PtBa"
    })
    public void isNaoValidoTest(String senha) {
        assertFalse(validaCaracteresRepetidos.isValido(senha));
    }

}
