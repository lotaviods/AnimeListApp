import { adiciona } from "./req/creator.js";

let elements = document.getElementsByTagName("input");

const formCadastro = document.querySelector('[data-form]')

formCadastro.addEventListener("submit", event => {
        event.preventDefault();
        const nome = event.target.querySelector('[data-nome]');
        const email = event.target.querySelector('[data-email]');
        const num = event.target.querySelector('[data-num]');
        let resp = adiciona(nome.value, email.value, num.value);

        resp.then(response => {
            if(response.sucesso){
               alert("Cadastro Realizado com sucesso");
                limpaInput(elements);
               return;
            }
            alert(response.conteudoResposta.mensagem);
            console.log(response)
        });
    });
function limpaInput(elements){
    for (let i=0; i < elements.length; i++) {
        if (elements[i].type == "text") {
            elements[i].value = "";
        }
        else if (elements[i].type == "radio"){
            elements[i].checked = false;
        }
        else if (elements[i].type == "checkbox"){
            elements[i].checked = false;
        }
        else if (elements[i].type == "select") {
            elements[i].selectedIndex = 0;
        }
    }
}
