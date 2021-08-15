package config;

import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@Getter
@ApplicationScoped
public class ValidaSenhaConfig {

    @ConfigProperty(name = "senha.tamanhoMin", defaultValue = "0")
    Integer tamanhoMinimo;

    @ConfigProperty(name = "senha.caracteresEspeciais", defaultValue = "!,@,#,$,%,^,&,*,(,),-,+")
    List<String> caracteresEspeciais;


    @ConfigProperty(name = "senha.validaTamanhoMin", defaultValue = "false")
    Boolean validaTamanhoMin;

    @ConfigProperty(name = "senha.validaDigitos", defaultValue = "false")
    Boolean validaDigitos;

    @ConfigProperty(name = "senha.validaLetraMinusculaObrigatoria", defaultValue = "false")
    Boolean validaLetraMinusculaObrigatoria;

    @ConfigProperty(name = "senha.validaLetraMaiusculaObrigatoria", defaultValue = "false")
    Boolean validaLetraMaiusculaObrigatoria;

    @ConfigProperty(name = "senha.validaCaracteresEspeciais", defaultValue = "false")
    Boolean validaCaracteresEspeciais;

    @ConfigProperty(name = "senha.validaCaracteresRepetidos", defaultValue = "false")
    Boolean validaCaracteresRepetidos;

    @ConfigProperty(name = "senha.validaSemEspacos", defaultValue = "false")
    Boolean validaSemEspacos;

}
