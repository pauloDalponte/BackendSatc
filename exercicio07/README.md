## Exercício 07

Crie uma REST API usando Spring Boot e adicione os seguintes modelos:

````java
public class Cliente {
  private String nome;
  private Double saldo;
  private String senha;
}
````

````java
public class Transacao {
  private String recebedor;
  private String pagador;
  private Double quantidade;
}
````

---

Crie dois endpoints para a API:

* `GET /cliente/{nome}` - retorna um cliente pelo nome, mas não mostra sua senha;
* `POST /transacao` - insere uma nova transação. O corpo da mensagem de ida deve conter o nome do `pagador` e do `recebedor`, como também a `quantidade` de dinheiro a ser debitada e creditada. A resposta deverá ser as mesmas informações enviadas em caso de sucesso.

Implemente todas as respostas usando DTOs e seus respectivos mappers. Adicione alguma validação a todos os atributos especificados nos DTOs.

> Dica: Utilize uma estrutura de Hashmap para armazenar os clientes e inicie alguns clientes no construtor do service.