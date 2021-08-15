package validadores;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class ValidaCaracteresEspeciaisTest{

    @Inject
    ValidaCaracteresEspeciais validaCaracteresEspeciais;

    @ParameterizedTest
    @ValueSource(strings = {
            "AbTp9!fok","aBtP9@FOK","kof#9pTbA","KOF$9PtBa"
    })
    public void isValidoTest(String senha) {
        assertTrue(validaCaracteresEspeciais.isValido(senha));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "AbTp90fok","aBtP91FOK","kof29pTbA","KOF39PtBa"
    })
    public void isNaoValidoTest(String senha) {
        assertFalse(validaCaracteresEspeciais.isValido(senha));
    }

}
