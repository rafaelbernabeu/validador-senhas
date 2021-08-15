package validadores;

import config.ValidaSenhaConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ValidaTamanhoMin extends AbstractValidadorSenha {

    @Inject
    ValidaSenhaConfig validaSenhaConfig;

    @Override
    public boolean isAtivo() {
        return validaSenhaConfig.getValidaTamanhoMin();
    }

    @Override
    public boolean isValido(String senha) {
        return senha.length() >= validaSenhaConfig.getTamanhoMinimo();
    }

}
