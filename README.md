# Projeto02M02
O projeto consiste em uma API, que salva e pega dados de um banco de dados.<br /><br />

Para salvar dados,entre no postman, no método post e siga o exemplo abaixo:<br /><br />

Salvar um novo usuário, no path http://localhost:8080/usuario/cadastro:<br />
    {<br />
      "email":"email@exemplo.com",<br />
      "senha":"senhaexemplo123"<br />
    }<br />
    Para atualizar um usuário, no método put no postman, basta colocar um novo campo nos dados acima, com: "id": númeroId, por exemplo:<br />
    { <br />
      "id":1,
      "email":"email@exemplo.com",<br />
      "senha":"senhaexemplo123"<br />
    }<br />
Salvar um novo medicamento, no path http://localhost:8080/medicamentos/cadastro:<br />
    {   <br />
        "nome": "Buscopan",<br />
        "nomelab:":"Clamed",<br />
        "dosagem" : "100mg",<br />
        "descricao":"O remedio é usado para dor de cabeça",<br />
        "precounitario":"R$ 100,00",<br />
        "tipomedicamento":"Comum"<br />
    }<br />
    Para atualizar um medicamento, no método put no postman, basta colocar um novo campo nos dados acima, com: "id": númeroId, por exemplo:<br />
    {<br />    
        "id":1,
        "nome": "Buscopan",<br />
        "nomelab:":"Clamed",<br />
        "dosagem" : "100mg",<br />
        "descricao":"O remedio é usado para dor de cabeça",<br />
        "precounitario":"R$ 100,00",<br />
        "tipomedicamento":"Comum"<br />
    }<br />

Salvar uma farmácia(junto com um novo endereço), no path http://localhost:8080/farmacias/cadastro:<br />
    { <br />
        "razaoSocial":"teste",
        "cnpj":"12345678912345",
        "nome":"teste nome",
        "email":"teste email",
        "telefone":"789456123",
        "celular":"1235454",
        "idEndereco":{
            "cep":"01001000"
            "numero":"154",
            "latitude":"1234",
            "longitude":"4321",
            "complemento":"casa"
        }
    }
    Para atualizar uma farmácia, no método put no postman, basta colocar um novo campo nos dados acima, com: "id": númeroId, por exemplo:
    {   
        "id":1,
        "razaoSocial":"teste",
        "cnpj":"12345678912345",
        "nome":"teste nome",
        "email":"teste email",
        "telefone":"789456123",
        "celular":"1235454",
        "idEndereco":{
            "cep":"01001000"
            "numero":"154",
            "latitude":"1234",
            "longitude":"4321",
            "complemento":"casa"
        }
    }
    
    Para obter dados, basta acesssar o método get no postman acessar com os seguintes caminhos(path):
    
    http://localhost:8080/farmacias  --> para obter todas as farmácias cadastradas
    http://localhost:8080/farmacias/idQueQuerObter  --> para obter a farmácia com o Id desejado, exemplo: http://localhost:8080/farmacias/1
    http://localhost:8080/usuario/login  --> para obter todos os usuários cadastrados
    http://localhost:8080/usuario/login/idQueQuerObter  --> para obter o usuário com o Id desejado, exemplo: http://localhost:8080/usuario/login/1
    http://localhost:8080/medicamentos  --> para obter todos os medicamentos cadastrados
    http://localhost:8080/medicamentos/idQueQuerObter  --> para obter o medicamento com o Id desejado, exemplo: http://localhost:8080/medicamentos/1
    
    *Todos as informações desejadas são retornadas em JSON.
