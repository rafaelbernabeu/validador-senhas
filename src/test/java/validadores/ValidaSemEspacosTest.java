package validadores;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class ValidaSemEspacosTest {

    @Inject
    ValidaSemEspacos validaSemEspacos;

    @ParameterizedTest
    @ValueSource(strings = {
            "0","a1","abc4","AbTp9!fok","aBtP0@FOK","kof#1pTbA","KOF$2PtBa"
    })
    public void isValidoTest(String senha) {
        assertTrue(validaSemEspacos.isValido(senha));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            " ", "Aa bC", " AbTpdfokA", "aBtPasFBK ", "ko fTgpf bA"
    })
    public void isNaoValidoTest(String senha) {
        assertFalse(validaSemEspacos.isValido(senha));
    }

}
