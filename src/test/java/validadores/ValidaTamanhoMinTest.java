package validadores;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class ValidaTamanhoMinTest {

    @Inject
    ValidaTamanhoMin validaTamanhoMin;

    @ParameterizedTest
    @ValueSource(strings = {
            "123456789","ABCDEFGHI","abcdefghi","000000000"
    })
    public void isValidoTest(String senha) {
        assertTrue(validaTamanhoMin.isValido(senha));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "AabC","AbTpdfkA","aBtPsFBK","kfTgpfbA","KObTPtBa"
    })
    public void isNaoValidoTest(String senha) {
        assertFalse(validaTamanhoMin.isValido(senha));
    }

}
