export function listarContatos(num = 1){
    return fetch(`http://localhost:8080/api/contatos/?page=${num}`,{
        method: 'GET'
    })
    .then(resp=> {
        return resp.json()
    }).then(json=>{
        return json;
    })
}



