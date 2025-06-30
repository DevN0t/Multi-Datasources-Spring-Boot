# Exemplo: Múltiplas Conexões de Banco de Dados em Java (Spring Boot)

Este projeto demonstra como configurar **mais de uma conexão com bancos de dados diferentes** no mesmo sistema Java usando Spring Boot.

---

## 🎯 Para que serve

Sistemas mais complexos às vezes precisam acessar múltiplos bancos ao mesmo tempo. Exemplos:

- Microserviço que acessa dois bancos legados diferentes
- Módulo de relatórios que lê dados de fontes externas
- Aplicação que separa leitura e escrita em bancos distintos (ex: replicação)

---

## ✅ O que esse projeto faz

- Configura duas conexões independentes com bancos diferentes
- Usa dois `DataSource`, dois `EntityManager` e dois `TransactionManager`
- Separa os repositórios por banco
- Suporta qualquer banco compatível com JPA (MySQL, PostgreSQL, etc)

---

## 🧱 Estrutura

src/main/java
├── com.exemplo.multidb
│ ├── config
│ │ ├── PrimaryDBConfig.java
│ │ └── SecondaryDBConfig.java
│ ├── primary
│ │ └── entidades e repositórios do banco 1
│ └── secondary
│ └── entidades e repositórios do banco 2
