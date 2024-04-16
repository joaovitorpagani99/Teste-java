# Guia de Execução do Projeto

Este guia fornece instruções sobre como executar o projeto JSF com PrimeFaces usando MySQL como banco de dados. Ele inclui uma breve descrição do projeto e os passos necessários para configurar e executar o projeto em seu ambiente local.

## Descrição do Projeto

O projeto consiste em uma aplicação web desenvolvida em Java Server Faces (JSF) com o framework PrimeFaces, integrada a um banco de dados MySQL. A aplicação permite o cadastro e busca de unidades de saúde com base no seu Cadastro Nacional de Estabelecimentos de Saúde (CNES) e faixa de CEP.

## Pré-requisitos

Antes de prosseguir, certifique-se de ter os seguintes pré-requisitos instalados em seu sistema:

- Java Development Kit (JDK) versão 11 ou superior
- Apache Maven
- MySQL Server
- Um servidor de aplicação compatível com JSF (como Apache Tomcat ou WildFly)

## Configuração do Projeto

1. Clone o repositório do projeto.
2. Abra o projeto em sua IDE Java de preferência.
3. Certifique-se de configurar as dependências necessárias no arquivo `pom.xml`.

## Pré-requisitos adicionais

Além dos pré-requisitos mencionados anteriormente, você também precisará baixar e configurar o Apache Tomcat e o MySQL.

### Apache Tomcat

1. Baixe o Apache Tomcat a partir do [site oficial de downloads](https://tomcat.apache.org/download-90.cgi). Escolha a versão mais recente do Tomcat 9, preferencialmente o arquivo "Core" do formato ".zip" ou ".tar.gz".
2. Descompacte o arquivo baixado em um diretório de sua escolha. Este diretório será referenciado como `$CATALINA_HOME`.
3. Adicione a variável de ambiente `CATALINA_HOME` apontando para o diretório onde você descompactou o Apache Tomcat.

### MySQL

1. Baixe e instale o MySQL a partir do [site oficial de downloads](https://dev.mysql.com/downloads/mysql/), pode ser utilizado o xampp.
2. Durante a instalação, defina uma senha para o usuário "root" do MySQL.
3. Após a instalação, inicie o servidor MySQL e verifique se ele está em execução corretamente.

## Executando o Projeto

1. Compile o projeto usando o Maven: `mvn clean install`.
2. Implante o arquivo WAR gerado em seu servidor de aplicação.
3. Inicie o servidor de aplicação.
4. Acesse a aplicação em seu navegador utilizando a URL fornecida pelo servidor de aplicação. `http://localhost:8080/projeto/cadastroUS.xhtml`

## Uso da Aplicação

- Na aplicação, você pode cadastrar novas unidades de saúde informando o CNES, nome da unidade de saúde e faixa de CEP.
- Também é possível buscar unidades de saúde existentes informando um CEP específico.
- Tem restrição de CNES que deve ser único e tambem não irá ter mais de unidade de saúde em uma faixa de CEP.
