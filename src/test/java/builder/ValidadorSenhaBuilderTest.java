package builder;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import validadores.IValidadorSenha;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ValidadorSenhaBuilderTest {

    @Inject
    ValidadorSenhaBuilder validadorSenhaBuilder;

    @Inject
    Instance<IValidadorSenha> validadoresSenha;

    @Test
    public void getValidadorSenhaTest() {
        IValidadorSenha iValidador = validadorSenhaBuilder.getValidadorSenha();

        int contador = 1;
        IValidadorSenha validadorAtual = iValidador;
        while (validadorAtual.getProximaValidacao() != null) {
            contador++;
            validadorAtual = validadorAtual.getProximaValidacao();
        }

        assertEquals(7, contador);
        assertEquals(validadoresSenha.stream().count(), contador);
    }

}
