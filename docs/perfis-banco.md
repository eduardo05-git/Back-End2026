# Perfis de conexão com o banco

A aplicação mantém o Somee como conexão padrão e permite usar um SQL Server local
sem alterar o código-fonte.

## Somee (padrão)

```powershell
$env:SPRING_PROFILES_ACTIVE="somee"
.\mvnw.cmd spring-boot:run
```

Também é possível executar normalmente, sem informar `SPRING_PROFILES_ACTIVE`,
pois o profile padrão é `somee`.

## Banco local

O profile local usa a porta TCP `1433` da instância `SQLEXPRESS`, banco `ZeroUm3a` e usuário
`sa` por padrão. A senha deve ser informada somente no ambiente da máquina:

```powershell
$env:LOCAL_DB_USERNAME="sa"
$env:LOCAL_DB_PASSWORD="<senha-do-banco-local>"
$env:SPRING_PROFILES_ACTIVE="local"
.\mvnw.cmd spring-boot:run
```

Se o SQL Server usar outra instância, informe a URL completa:

```powershell
$env:LOCAL_DB_URL="jdbc:sqlserver://localhost\SQLEXPRESS;databaseName=ZeroUm3a;encrypt=false;trustServerCertificate=true"
```

Na IDE, use `-Dspring.profiles.active=local` nas opções da JVM. Para voltar ao
Somee, selecione `somee` ou remova a variável `SPRING_PROFILES_ACTIVE`.

As credenciais não devem ser adicionadas a arquivos versionados.
