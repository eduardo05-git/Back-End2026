# Testes

Os testes automatizados usam o perfil `test`, com H2 em memória. Assim, `mvn test`
não acessa o SQL Server local nem o Somee e pode ser executado em CI.

```powershell
mvn test
```

O wrapper incluído no projeto precisa do arquivo `.mvn/wrapper/maven-wrapper.properties`.
Se ele estiver presente, o comando equivalente é `./mvnw test` (ou `./mvnw.cmd test` no Windows).

Os testes de unidade isolam os serviços com Mockito; os testes de integração validam
o mapeamento JPA e consultas reais contra H2; o teste de contexto valida a inicialização
com todas as entidades e configurações Spring.

Para validar uma conexão real, execute a aplicação separadamente com `local` ou `somee`,
usando as variáveis de ambiente documentadas em `docs/perfis-banco.md`. Esses testes não
devem usar o banco compartilhado automaticamente, pois operações de escrita poderiam
alterar dados reais.
