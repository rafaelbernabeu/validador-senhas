package builder;

import validadores.IValidadorSenha;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@ApplicationScoped
public class ValidadorSenhaBuilder {

    @Inject
    Instance<IValidadorSenha> validadoresSenha;

    private IValidadorSenha validadorSenha;

    public IValidadorSenha getValidadorSenha() {
        if (validadorSenha == null) {
            synchronized (ValidadorSenhaBuilder.class) {
                if (validadorSenha == null) {
                    validadorSenha = criaValidador();
                }
            }
        }
        return validadorSenha;
    }

    private IValidadorSenha criaValidador() {
        IValidadorSenha validadorInicial = null;
        IValidadorSenha validadorAnterior = null;
        for (IValidadorSenha iValidador : validadoresSenha) {
            if (validadorInicial == null) {
                validadorInicial = iValidador;
            }
            if (validadorAnterior != null) {
                validadorAnterior.setProximaValidacao(iValidador);
            }
            validadorAnterior = iValidador;
        }
        return validadorInicial;
    }
}
