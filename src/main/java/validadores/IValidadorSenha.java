package validadores;

public interface IValidadorSenha {

    default boolean validar(String senha) {
        if (senha == null) {
            return false;
        }
        if (isAtivo()) {
            return getProximaValidacao() != null ? isValido(senha) && getProximaValidacao().validar(senha) : isValido(senha);
        }
        return getProximaValidacao() == null || getProximaValidacao().validar(senha);
    }

    boolean isAtivo();

    boolean isValido(String senha);

    void setProximaValidacao(IValidadorSenha validador);

    IValidadorSenha getProximaValidacao();

}
