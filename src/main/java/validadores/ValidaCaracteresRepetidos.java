package validadores;

import config.ValidaSenhaConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static java.lang.String.valueOf;

@ApplicationScoped
public class ValidaCaracteresRepetidos extends AbstractValidadorSenha {

    @Inject
    ValidaSenhaConfig validaSenhaConfig;

    @Override
    public boolean isAtivo() {
        return validaSenhaConfig.getValidaCaracteresRepetidos();
    }

    @Override
    public boolean isValido(String senha) {
        return senha.chars().mapToObj(Character::toString).noneMatch(c -> senha.indexOf(valueOf(c)) != senha.lastIndexOf(valueOf(c)));
    }

}
