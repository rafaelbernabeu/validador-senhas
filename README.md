# Desafio validador-senhas

Este projeto é uma implementação do [desafio](https://github.com/itidigital/backend-challenge) do [iti](https://iti.itau/).

Foi utilizado o framework [Quarkus](https://quarkus.io/) (A Kubernetes Native Java stack tailored for OpenJDK HotSpot and GraalVM, crafted from the best of breed Java libraries and standards). 

## Funcionalidade

Verifica se uma senha é válida a partir das seguintes condições:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
- Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Input: Uma senha (string). \
Output: Um boolean indicando se a senha é válida.

## Para executar a aplicação:

```shell script
./mvn compile quarkus:dev
```
ou
```shell script
docker run --rm -p 8080:8080 rbbernabeu/validador-senhas
```

## Para executar os testes:

```shell script
./mvn test
```

## Uso da API:

```
POST http://localhost:8080/senhas/validar
Content-Type: text/plain

AbCdE1@34
```

## Notas de segurança

Projeto feito somente para estudos. \
Caso queira utilizar em algum projeto em produçao, ative o protocolo HTTPS. \
Guias: https://github.com/rafaelbernabeu/cotador \
https://quarkus.io/guides/http-reference#ssl

## Notas de implementação

É possivel alterar o comportamento das seguintes validaçoes:
- Quantidade minima de caracteres
- Lista de caracteres especiais

Ex:
```
senha.tamanhoMin=9
senha.caracteresEspeciais=!,@,#,$,%,^,&,*,(,),-,+
```

Cada uma das funcionalidades podem ser ativadas/desativadas via arquivo application.properties ou variavel de ambiente.
Ex:
```
senha.validaTamanhoMin=true
senha.validaDigitos=true
senha.validaLetraMinusculaObrigatoria=true
senha.validaLetraMaiusculaObrigatoria=true
senha.validaCaracteresEspeciais=true
senha.validaCaracteresRepetidos=true
senha.validaSemEspacos=true
```
Guia:https://quarkus.io/guides/config-reference

Para criar novas validaçoes, extenda a classe AbstractValidadorSenha. O sistema automaticamente ira detectar a nova instancia e inclui-la na cadeia de validacao. \
Para a validacao ser opcional, adicione uma propriedade em ValidaSenhaConfig e application.properties.

## Tomadas de decisões
- Nao foi especificado se a validaçao "Não possuir caracteres repetidos dentro do conjunto" era case-sensitive. Decidi que sim.
- Nao foi solicitado retorno de mensagem de erro informando qual validacao falhou, caso necessario, alterar as implementacoes do metodo "boolean isValido(String senha)".


## Idéias de novas funcionalidades
- Validacao adicional -> receber uma regex via arquivo de configuracao.
- Validacao de tamanho maximo.
- Range de caracteres validos.
- Validacoes em batch -> paralelizar a execuçao
- Habilitar GZIP para os endpoints: https://quarkus.io/guides/rest-json#gzip-support
