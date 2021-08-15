package service;

import builder.ValidadorSenhaBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ValidaSenhaService {

    @Inject
    ValidadorSenhaBuilder validadorSenhaBuilder;

    public boolean isSenhaValida(String senha) {
        return validadorSenhaBuilder.getValidadorSenha().validar(senha);
    }

}
