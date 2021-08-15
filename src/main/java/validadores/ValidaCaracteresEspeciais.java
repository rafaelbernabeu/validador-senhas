package validadores;

import config.ValidaSenhaConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ValidaCaracteresEspeciais extends AbstractValidadorSenha {

    @Inject
    ValidaSenhaConfig validaSenhaConfig;

    @Override
    public boolean isAtivo() {
        return validaSenhaConfig.getValidaCaracteresEspeciais();
    }

    @Override
    public boolean isValido(String senha) {
        return validaSenhaConfig.getCaracteresEspeciais().stream().anyMatch(s -> senha.contains(s));
    }

}
