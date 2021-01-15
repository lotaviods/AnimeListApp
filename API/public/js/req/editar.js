export function editar(id, nome,numero, email){

    const Json = JSON.stringify({
        id : id,
        nome: nome,
        numero: numero,
        email: email,
    })
    console.log(Json);
    return fetch(`http://localhost:8080/api/contatos/${id}`, {
        method: "PUT",
        headers: {
            'Content-type': 'application/json'
        },
        body: Json
    }).then(resp => {
        return resp.json().then(json =>{
            return json;
        })
    }).catch(e=>{
        alert('Erro de conexão com o servidor.')
    })
}