# Projeto: Inovação e Tecnologia na Saúde

## Integrante do Projeto
### -Leonardo Paganini RM96562
### -Matheus Leite RM96893 
### -Jhonn Brandon RM97305 
### -Regina Pompeo RM97032 

## Descrição do Projeto
A nossa proposta inovadora visa revolucionar o acesso à saúde, proporcionando aos pacientes uma experiência simplificada e eficiente no momento da consulta. Através do nosso aplicativo intuitivo, os beneficiários podem agendar consultas, acompanhar o status da consulta e verificar os exames realizados. Eliminamos barreiras ao oferecer automação no processo de marcação, conectando os pacientes aos profissionais de saúde de forma rápida e precisa. Além disso, ao consolidar informações e resultados de exames em um só lugar, proporcionamos uma jornada de cuidados de entrada no paciente quando o mesmo comparece na consulta. Nosso foco em prevenção, automação e precisão não apenas otimiza o sistema hospitalar, mas também capacita os beneficiários a gerenciar proativamente sua saúde.

## Problema Solucionado
A solução propõe resolver a complexidade na gestão de saúde, facilitando o processo de agendamento e prevenção para beneficiários. A aplicação automatiza o acompanhamento de exames e consultas agendadas com base na avaliação de nossos profissionais, garantindo que os beneficiários não esqueçam seus compromissos de saúde.

## Escopo do Projeto
- Cadastro e armazenamento de dados de beneficiários, consultas, funcionários, exames, planos e médicos.
- Agendamento de exames de acordo com a avaliação da consulta marcada na especialidade com médicos na equipe dando suporte à avaliação prévia.
- Realização de exames específicos prescritos previamente pela nossa equipe médica conforme a necessidade perante a consulta agendada.

## Tecnologias Utilizadas e Versão
- Java 17 (JPA)
- Spring Boot
- Maven 
- SQL BD (SQL Developer)
- Swagger para documentação da API
- React Native (Expo Snacks)
- Figma (UI/UX)
- Metodoligia Ágil (Trello, Diagramas, etc.)
- Metologias de QA para realização de testes unitários, integração e sistemicos (JUnit)

## Referências

Para o ReactNative: https://www.youtube.com/watch?v=FWwKjxSgLl8&list=PLQWFhX-gwJbmtZY4mcRE-k7hL9DigcGS-&ab_channel=PradipDebnath

## Diagrama de classe

![EnterpriseApplicationV2](https://github.com/jhonnbr4ndon/GS_ENTERPRISE/assets/112666523/954a14d8-eb86-4ea5-ba70-4bfab7f8d973)

## Modelo Lógico

![image](https://github.com/jhonnbr4ndon/GS_ENTERPRISE/assets/112666523/0c52a7c2-3c34-40c0-8ab0-74e7dfd8d36c)

## Modelo Relational

![image](https://github.com/jhonnbr4ndon/GS_ENTERPRISE/assets/112666523/ba6a4924-60f9-4ffc-897c-c6611f6d72d6)

# GS_ENTERPRISEAPI

## Instruções para Rodar a Aplicação

### Requisitos
- **Java Development Kit (JDK)**: Este projeto requer Java 17. Você pode baixar a versão mais recente do JDK no [site oficial do OpenJDK](https://adoptopenjdk.net/).
- **IntelliJ IDEA**: Certifique-se de ter o IntelliJ IDEA instalado e configurado no seu computador. Se ainda não tiver, você pode baixá-lo no [site oficial da JetBrains](https://www.jetbrains.com/idea/).

### Configuração do Ambiente
1. **Banco de Dados**: Configure as propriedades do banco de dados no arquivo `src/main/resources/application.properties`. Certifique-se de criar o esquema do banco de dados antes de executar o aplicativo.

   Exemplo `application.properties`:
   ```properties
   # Configurações do banco de dados
   spring.datasource.url=jdbc:oracle:thin:@localhost:1521:seuBanco
   spring.datasource.username=seuUsuario
   spring.datasource.password=suaSenha
   spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

   # Configurações do Hibernate
   spring.jpa.show-sql=true
   spring.jpa.hibernate.ddl-auto=update

### Testes da Aplicação 

1. Inicializar o projeto no **Main.java**
2. **Abrir esse site no seu Browser** http://localhost:8080/swagger-ui/index.html#/
3. Começar a implementar dados no seu banco de dados com **Swagger**
