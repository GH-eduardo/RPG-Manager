## Aplicação feita com java 17, springboot e banco de dados h2

### É possível testar as rotas pelo swagger disponível na url:

```
http://localhost:8080/swagger-ui/index.html#/
```

### E conferir o banco de dados na url:
```
localhost:8080/h2-console/
```

### Inserir no campo 'JDBC URL:' o seguinte:
```
jdbc:h2:mem:testdb
```

### o nome de usuário é:
```
sa
```

### e não tem senha

### OBS: Quando a aplicação é iniciada são adicionados alguns registros diretamente no banco de dados através do arquivo import.sql para facilitar os testes das rotas 