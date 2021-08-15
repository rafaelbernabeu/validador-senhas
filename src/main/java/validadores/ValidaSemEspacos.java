package validadores;

import config.ValidaSenhaConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ValidaSemEspacos extends AbstractValidadorSenha {

    @Inject
    ValidaSenhaConfig validaSenhaConfig;

    @Override
    public boolean isAtivo() {
        return validaSenhaConfig.getValidaSemEspacos();
    }

    @Override
    public boolean isValido(String senha) {
        return !senha.contains(" ");
    }

}
