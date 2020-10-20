# Read-me

O Sistema de compras baseado na arquiterura de micro service, o sistema tem conexão com 2 bancos de dados, um relacional, e um não relacional, e, tambem conta com um sistema externo de mensagerias que garante que nada seja perdido cado haja alguma interrupção e algum micro serviço

**O sistema ´composto por:**

 - 4 micro serviços
 - comunicação com 2 bancos (MySql e Redis)
 - 1 Sistema de Mensageria (RabbiMq)
 - 1 Gatway para fazer gestão de comunicação Cliente/Microservices

# MicroServices

## bank

MicroService responsável por fazer toda a gestão do cartão, o memso valida numero do cartão, código de segurança e saldo do cartão

**Obs.:** Este micro serviço possiu acesso ao banco de dados MySql



## buytrip

MicroService responsável por resgistar as compras e inserir no sistema de mensageria **RabbitMq**

**Obs.:** Este micro serviço não possui comunicação com nenhum banco de dados.

## buyprocess

MicroService responsável por observar se na fila **fila-compras-aguardando** no **RabbitMq** existe alguma compra, o mesmo recupera esta compra, e chama o micro service **bank** que irá registrar a contra e debitar do cartão no banco de dados.

**Obs.:** Este micro serviço não possui comunicação com nenhum banco de dados, e não atende os padrões Rest, é apenas um serviço que funciona "por de trás dos bastidores =)".

## buyfeedback

MicroService responsável por observar se na fila **fila-compras-finalizado** no **RabbitMq** existe alguma compra, caso existe o mesmo retira desta fila e salva a informação no banco de dados, neste micro service  existe 2 end point:  

 1. /{chave} -> para verificar o status da compra salva no banco de dados
 2. /meunome -> Apenas para testo do microService

**Obs.:** Este micro serviço possui comunicação com o banco de dados Redis, e com o sistema de mensageria RabbitMq


## gateway

MicroService responsável apensa por intermediar a comunicação entre o Client/MicroService

**Obs.:** Veja o arquivo **application.yml** deste MicroService




## Estrutura do projeto

![enter image description here](https://i.imgur.com/LRUnMLk.png)


# Preparando o ambiente

É muito importante vocês terem o docker instalado na sua maquina.

dentro da pasta da aplicação existe uma pasta chamanda docker com alguns arquivos.yml, caso vocês não tenham alguma dessas aplicações, instalem usando o script do docker abaixo:

Informações referente a configurações da aplicação esta nos arquivos.yml

 - [ ] **Redis** -> docker-compose -f docker-redis.yml up
 - [ ] **Mysql** -> docker-compose -f docker-mysql.yml up
 - [ ] **RabbitMq** -> docker-compose -f docker-rabbitmq.yml up
 - [ ] **Conul** -> docker-compose -f docker-consul.yml up



### Espero que vocês tenham gostado até a próxima...
