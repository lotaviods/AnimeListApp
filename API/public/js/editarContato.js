import { editar } from "./req/editar.js";

let elements = document.getElementsByTagName("input");

const formEditar = document.querySelector('#telaEditar')


    formEditar.addEventListener("submit", event => {
        event.preventDefault();

        let id = window.location.href;
        id = id.split('/');
        id = id[3]

        const nome = event.target.querySelector('[data-nome]');
        console.log(nome.value)
        const email = event.target.querySelector('[data-email]');
        const num = event.target.querySelector('[data-num]');
        let resp = editar(id, nome.value, num.value,email.value);

        console.log(resp)

        resp.then(response => {
            if(response.sucesso){
                alert("Edição Realizada com sucesso");
                limpaInput(elements);
                window.location.replace("/");
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