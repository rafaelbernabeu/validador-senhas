package validadores;

import config.ValidaSenhaConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ValidaLetraMaiuscula extends AbstractValidadorSenha {

    @Inject
    ValidaSenhaConfig validaSenhaConfig;

    @Override
    public boolean isAtivo() {
        return validaSenhaConfig.getValidaLetraMaiusculaObrigatoria();
    }

    @Override
    public boolean isValido(String senha) {
        return senha.matches(".*\\p{javaUpperCase}.*");
    }

}
