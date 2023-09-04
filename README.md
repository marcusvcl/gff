# **GFF**

Sistema de Genrenciamento de Fast Food.


## **Objetivo**
O sistema de gerenciamento de Fast Food tem como objetivo sanar a necessidade de um melhor gerenciamento dos pedidos de um estabelecimento, trazendo uma melhor eficiência com a organização dos pedidos.


## **Tecnologias utilizadas**
- [Git](https://git-scm.com/downloads)
- [Java - Versão 17](https://www.oracle.com/java/)
- [Maven](https://maven.apache.org/)
- [Docker](https://docs.docker.com/)
- [MongoDB](https://www.mongodb.com/)
- [Swagger](https://swagger.io/docs/specification/about/)
- [Kubernetes](https://kubernetes.io/docs/tasks/tools/#kubectl)

<br>

## **Subindo a Aplicação**

Para buildar a aplicação atarvés do download do programa via git é necessário ter as tecnologias Git, Java (versão 17 - sdk 17), Docker e Docker Composer instalados.
Após instalar as tecnologias segua os seguintes passos:
<br>
- 1° - Baixe o diretório para uma pasta local de sua máquina.
- 2° - Abra o terminal no diretório na qual você fez o download da pasta do programa.
- 3° - Utilize o comando a seguir para subir a aplicação via kubernetes:
<br>

```bash
    kubectl apply -f k8s/.
```
Desta forma a aplicação estará rodando no cluster, caso esteja utilizando o minikube usar o seguinte comando para conseguir acessar a aplicação:

```bash
    minikube service gff-service
```

O swagger da aplicação pode ser acessado pela seguinte url: 

<br>

http://IP:Port/swagger-ui/index.html
No swagger você encontrará as rotas de utilização que a API proporciona.

O Ip e porta pode variar de acordo com a feramenta local de kubernetes.
Caso esteja utilizando o minikube e queira saber o ip, basta executar o comando:

```bash
minikube ip
```

