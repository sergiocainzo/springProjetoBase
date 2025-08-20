## Cadastro de Clientes com Design Patterns - Spring Boot

Este projeto é uma API REST desenvolvida em **Spring Boot** que realiza o **cadastro de clientes** com integração automática ao serviço **ViaCEP** para busca de endereço pelo CEP.  

O objetivo do projeto é demonstrar o uso prático de **Padrões de Projeto (Design Patterns)** em um contexto real.

Este projeto foi desenvolvido como parte de um desafio proposto pela Digital Innovation One (DIO), com o objetivo de aplicar conceitos de arquitetura de software utilizando Spring Boot.

---

## Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Cloud OpenFeign** (integração com ViaCEP)
- **H2 Database** (banco em memória para testes)
- **Lombok**
- **Maven**

---

## Padrões de Projeto Aplicados
- **Repository Pattern**  
  Usado nas interfaces `ClienteRepository` e `EnderecoRepository` para abstrair o acesso a dados.  

- **Facade Pattern**  
  Implementado em `ClienteServiceImp`, que atua como uma fachada para:  
  - Verificar se o endereço já existe no banco.  
  - Consultar o ViaCEP caso necessário.  
  - Persistir cliente e endereço de forma transparente para o Controller.  

- **Singleton Pattern**  
  Todos os beans gerenciados pelo Spring (`@Service`, `@Repository`, `@Controller`) são instâncias únicas (*singleton scope*) por padrão.  
  > Opcionalmente, um **LoggerSingleton** pode ser adicionado para reforçar o conceito.  

---

## Funcionalidades
- ✅ Cadastrar cliente com busca automática de endereço pelo CEP.  
- ✅ Atualizar cliente existente.  
- ✅ Listar todos os clientes.  
- ✅ Buscar cliente por **ID**.  
- ✅ Deletar cliente por **ID**.  

---

# Licença

Este projeto foi desenvolvido para fins educacionais e faz parte do Desafio de Design Patterns em Java.
Sinta-se à vontade para usar, modificar e compartilhar.

---

# Desenvolvido por **Sergio Cainzo**
