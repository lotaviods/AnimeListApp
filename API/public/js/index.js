import { listarContatos } from './req/fetcher.js';
import {conteudo, createElement, createText, addId, addNoElement, addClasse, tbody} from "./req/conteudoIndex.js";

listarContatos().then(paginacao =>{

        let totalPage = Math.ceil(paginacao.quandidaDeContatos / paginacao.itensPorPagina )
        conteudo(1);
        for (let i=1; i<= totalPage;i++) {
            let pagination = document.querySelector('.pagination')

            let li = createElement('li');
            addClasse(li, ['page-item']);
            addId(li, i);

            let a = createElement('a')
            addClasse(a, ['page-link']);
            a.appendChild(createText(i));

            addNoElement(li, a);
            addNoElement(pagination, li);

            let idLi = document.getElementById(i);
            idLi.addEventListener("click", function (){

                conteudo(i);
                tbody.innerHTML = '';
            });

        }
});