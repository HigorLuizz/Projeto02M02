# Projeto02M02
O projeto consiste em uma API, que salva e pega dados de um banco de dados.<br /><br />

Para salvar dados,entre no postman, no método post e siga o exemplo abaixo:<br /><br />

Salvar um novo usuário, no path http://localhost:8000/usuarios:<br />
    {<br />
      "login":"email@exemplo.com",<br />
      "senha":"senhaexemplo123"<br />
    }<br />
    Para atualizar um usuário, no método put no postman, basta colocar um novo campo nos dados acima, com: "id": númeroId, por exemplo:<br />
    { <br />
      "id":1,
      "login":"email@exemplo.com",<br />
      "senha":"senhaexemplo123"<br />
    }<br />
Salvar um novo medicamento, no path http://localhost:8000/medicamentos:<br />
    {   <br />
        "nome": "Buscopan",<br />
        "nomelab":"Clamed",<br />
        "dosagem" : "100mg",<br />
        "descricao":"O remedio é usado para dor de cabeça",<br />
        "precounitario":"R$ 100,00",<br />
        "tipomedicamento":"Comum"<br />
    }<br />
    Para atualizar um medicamento, no método put no postman, basta colocar um novo campo nos dados acima, com: "id": númeroId, por exemplo:<br />
    {<br />    
        "id":1,
        "nome": "Buscopan",<br />
        "nomelab":"Clamed",<br />
        "dosagem" : "100mg",<br />
        "descricao":"O remedio é usado para dor de cabeça",<br />
        "precounitario":"R$ 100,00",<br />
        "tipomedicamento":"Comum"<br />
    }<br />

Salvar uma farmácia(junto com um novo endereço), no path http://localhost:8000/farmacias:<br />
    { <br />
        "razaoSocial":"teste",<br />
        "cnpj":"12345678912345",<br />
        "nome":"teste nome",<br />
        "email":"teste email",<br />
        "telefone":"789456123",<br />
        "celular":"1235454",<br />
        "idEndereco":{<br />
            "cep":"01001000",<br />
            "numero":"154",<br />
            "latitude":"1234",<br />
            "longitude":"4321",<br />
            "complemento":"casa"<br />
        }<br />
    }<br />
    Para atualizar uma farmácia, no método put no postman, basta colocar um novo campo nos dados acima, com: "id": númeroId, por exemplo:<br />
    { <br />  
        "id":1,<br />
        "razaoSocial":"teste",<br />
        "cnpj":"12345678912345",<br />
        "nome":"teste nome",<br />
        "email":"teste email",<br />
        "telefone":"789456123",<br />
        "celular":"1235454",<br />
        "idEndereco":{<br />
            "cep":"01001000",<br />
            "numero":"154",<br />
            "latitude":"1234",<br />
            "longitude":"4321",<br />
            "complemento":"casa"<br />
        }<br />
    }<br /><br />
    
    Para obter dados, basta acesssar o método get no postman acessar com os seguintes caminhos(path):<br /><br />
    
    http://localhost:8000/farmacias  --> para obter todas as farmácias cadastradas<br />
    http://localhost:8000/farmacias/idQueQuerObter  --> para obter a farmácia com o Id desejado, exemplo: http://localhost:8080/farmacias/1<br />
    http://localhost:8000/usuario/login  --> para obter todos os usuários cadastrados<br />
    http://localhost:8000/usuario/login/idQueQuerObter  --> para obter o usuário com o Id desejado, exemplo: http://localhost:8080/usuario/login/1<br />
    http://localhost:8000/medicamentos  --> para obter todos os medicamentos cadastrados<br />
    http://localhost:8000/medicamentos/idQueQuerObter  --> para obter o medicamento com o Id desejado, exemplo: http://localhost:8080/medicamentos/1<br /><br />
    
    *Todos as informações desejadas são retornadas em JSON.
