# ListaDeContatos


## Instalação do projeto:

-
        cd .\API\
-
        composer install
-       
        cd .\HTML\
-
        npm install

### Iniciando o projeto:

-
        php -S localhost:8080 -t .\API\public\
-
        cd .\HTML\
-
        gulp css
-
        gulp js
-       
        npm start

### Documentação Api:
        Métodos:  

        GET:
            localhost:8080/api/contatos
                - Busca todos os contatos.
            localhost:8080/api/contatos/{id}
                - Busca um contato específico.

        POST:
            localhost:8080/api/contatos
                - Cria um contato específico.
        
        PUT:
            localhost:8080/api/contatos/{id}
                - Edita um contato específico.  

        DELETE:
            localhost:8080/api/contatos/{id}
                - Deleta um contato específico.

