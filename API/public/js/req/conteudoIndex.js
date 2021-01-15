import {listarContatos} from "./fetcher.js";
import {excluir} from "./remove.js";

const  tbody = document.querySelector("#lista_contatos");
const mensagem_erro = document.querySelector('#erro');
let naoTemNada = document.querySelector("#naoTemNada");

export {conteudo,createElement,createText,addId,addNoElement,addClasse, removeClasse,tbody}
function conteudo(pagina){
    listarContatos(pagina).then(conteudo => {

        existeConteudo(conteudo);
        conteudo.conteudoResposta.forEach(i => {

            let tr = createElement('tr')
            addId(tr, `id_contato_${i.id}`);
            addClasse(tr, ['contatos']);

            let td = createElement('td');
            let td2 = createElement('td');
            let td3 = createElement('td');

            let buttonExcluir = createElement('button');
            addId(buttonExcluir, "botaoExcluir");
            addClasse(buttonExcluir, ['btn', 'btn-danger']);

            let buttonEditar = createElement('button');
            addId(buttonEditar, "botaoEditar");
            addClasse(buttonEditar, ['btn', 'btn-primary']);

            buttonExcluir.addEventListener("click", f => {
                let retornoConfirmacao = confirmacao()
                console.log(retornoConfirmacao);
                if (retornoConfirmacao) {
                    excluir(i.id).then(suc => {
                        let removido = document.querySelector(`#id_contato_${i.id}`)

                        addClasse(removido, ['apaga']);
                        console.log(removido);
                        setTimeout(function () {
                            removido.remove();
                        }, 500)
                    });
                }
            });

            td.appendChild(createText(i.nome));
            td2.appendChild(createText(i.email));
            td3.appendChild(createText(i.numero));
            buttonExcluir.appendChild(createText("X"));
            buttonEditar.appendChild(createText("Edit"))


            addNoElement(tr, td);
            addNoElement(tr, td2);
            addNoElement(tr, td3);
            addNoElement(tr, buttonExcluir);
            addNoElement(tr, buttonEditar);
            console.log(tr);
            addNoElement(tbody, tr)
        });
    });
}

function confirmacao() {
    if (confirm('Excluir esse contato?')) {
        return true;
    }else{
        return false;
    }
}

function createElement(elemento){
    return document.createElement(elemento);
}

function createText(text){
    return document.createTextNode(text);
}

function addClasse(text,classe){
    text.classList.add(...classe);
}
function removeClasse(text,classe){
    text.classList.remove(...classe);
}
function addId(element,nomeId){
    element.id = nomeId
}
function addNoElement(element,add){
    element.appendChild(add);
}
function existeConteudo(conteudo) {
    if (!conteudo.sucesso) {
        mensagem_erro.innerHTML = `Ocorreu um erro ${conteudo.conteudoResposta.mensagem}`;
        addClasse(mensagem_erro, ['fade-in'])
        removeClasse(mensagem_erro,['invisible']);

        setTimeout(function () {
            removeClasse(mensagem_erro,['fade-in'])
            addClasse(mensagem_erro, ['fade-out'])

            setTimeout(function () {
                addClasse(mensagem_erro,['invisible']);
            }, 500);
        }, 500);
    } else {
        if (!conteudo.conteudoResposta.length) {
            naoTemNada.remove();
            mensagem_erro.innerHTML = `Não existe nenhum contato`
            mensagem_erro.classList.add('fade-in');

            removeClasse(mensagem_erro, ['invisible']);

            setTimeout(function () {
                removeClasse(mensagem_erro, ['fade-in']);
                addClasse(mensagem_erro, ['fade-out']);
                setTimeout(function () {
                    addClasse(mensagem_erro, ['invisible']);
                }, 5000);
            }, 5000);
        }
    }
}
