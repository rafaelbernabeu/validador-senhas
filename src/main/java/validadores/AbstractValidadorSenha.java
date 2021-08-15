package validadores;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractValidadorSenha implements IValidadorSenha  {

    private IValidadorSenha proximaValidacao;

}
