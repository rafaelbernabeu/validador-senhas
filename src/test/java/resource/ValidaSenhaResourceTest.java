package resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ValidaSenhaResourceTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "AbTp9!fok", "aBtP9@FOK", "kof#9pTbA", "KOF$9PtBa"
    })
    public void validarSucessoTest(String senha) {
        given()
                .body(senha)
                .when()
                .post("/senhas/validar")
                .then()
                .statusCode(200)
                .body(is("true"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "","aa","ab","AAAbbbCc","AbTp9!foo","AbTp9!foA","AbTp9 fok"
    })
    public void validarErroTest(String senha) {
        given()
                .body(senha)
                .when()
                .post("/senhas/validar")
                .then()
                .statusCode(200)
                .body(is("false"));
    }

}