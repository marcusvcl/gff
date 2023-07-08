# **GFF**

Sistema de Genrenciamento de Fast Food.


## **Objetivo**: 
O sistema de gerenciamento de Fast Food tem como objetivo sanar a necessidade de um melhor gerenciamento dos pedidos de um estabelecimento, trazendo uma melhor eficiência com a organização dos pedidos.


## **Tecnologias utilizadas:**
- [Git](https://git-scm.com/downloads)
- [Java - Versão 17](https://www.oracle.com/java/)
- [Maven](https://maven.apache.org/)
- [Docker](https://docs.docker.com/)
- [MongoDB](https://www.mongodb.com/)
- [Swagger](https://swagger.io/docs/specification/about/)
- [Composer](https://getcomposer.org/)

<br>

## **Buildando a Aplicação:**

Para buildar a aplicação atarvés do download do programa via git é necessário seguir alguns passos:
<br>
- 1° - Baixe o diretório para uma pasta local de sua máquina.
- 2° - Abra o terminal no diretório na qual você fez o download da pasta do programa.
- 3° - Utilize o comando a seguir para subir a aplicação via docker compose:
<br>

```bash
    docker compose -f compose.yaml up
```
Desta forma a aplicação estará funcionando.

Para acessar o Swagger da aplicação acesse em um browser de sua preferência o link:
<br>

[http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

No swagger você encontrará as rotas de utilização que a API proporciona.
