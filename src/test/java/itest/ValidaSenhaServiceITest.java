package itest;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import service.ValidaSenhaService;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class ValidaSenhaServiceITest {

    @Inject
    ValidaSenhaService validaSenhaService;

    @ParameterizedTest
    @ValueSource(strings = {
            "AbTp9!fok","aBtP9@FOK","kof#9pTbA","KOF$9PtBa"
    })
    public void isValidoTest(String senha) {
        assertTrue(validaSenhaService.isSenhaValida(senha));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "","aa","ab","AAAbbbCc","AbTp9!foo","AbTp9!foA","AbTp9 fok"
    })
    public void isNaoValidoTest(String senha) {
        assertFalse(validaSenhaService.isSenhaValida(senha));
    }

}
