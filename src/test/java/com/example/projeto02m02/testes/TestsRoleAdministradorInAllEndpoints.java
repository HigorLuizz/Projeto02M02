package com.example.projeto02m02.testes;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestEntityManager
public class TestsRoleAdministradorInAllEndpoints {
    private URI path;
    private MockHttpServletRequest request;
    private ResultMatcher expectedResult;

    @Autowired
    private MockMvc mock;

    private String jwtToken;

    @Before
    public void setUp() throws Exception{


        String json = "{\"login\": \"higorluiz\", \"senha\": \"654321\"}";


        path = new URI("/login");


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON).content(json);

        expectedResult = MockMvcResultMatchers.status().isOk();


        String response = mock.perform(request).andExpect(expectedResult).andReturn().getResponse()
                .getContentAsString();


        JSONObject data = new JSONObject(response);


        jwtToken = data.getString("Authorization");


    }
    //TESTES COM O ENDPONT USUARIO COM A ROLE ADMINISTRADOR//
    //--------------------------------------------------------//

    @Test
    public void testGetAllUsuarioscomRoleAdministrador() throws Exception{

        path = new URI("/usuarios");


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(path)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isFound();

        mock.perform(request).andExpect(expectedResult);

    }
    @Test
    public void testPostUsuarioComRoleAdministrador() throws Exception{

        String jsonCadastro = "{\"nome\": \"Usuario Teste\", \"login\": \"usuariotest\", \"senha\": \"123456\"}";

        path = new URI("/usuarios");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .content(jsonCadastro)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isCreated();

        mock.perform(request).andExpect(expectedResult);

    }
    @Test
    public void testPUTUsuariocomRoleAdministrador() throws Exception {

        String jsonAtualiza = "{\"id\": \"1\", \"nome\": \"Usuario Atualizado\", \"login\": \"usuarioatualizado\", \"senha\": \"usuarioatualizado\"}";

        path = new URI("/usuarios");


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(path)
                .content(jsonAtualiza)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }
    @Test
    public void testDeleteUsuariocomRoleAdministrador() throws Exception {

        path = new URI("/usuarios");


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(path)
                .param("id","1")
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    //TESTES COM O ENDPONT MEDICAMENTOS COM A ROLE ADMINISTRADOR//
    //--------------------------------------------------------//

    @Test
    public void testGetAllMedicamentoscomRoleAdministrador() throws Exception{

        path = new URI("/medicamentos");


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(path)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isFound();

        mock.perform(request).andExpect(expectedResult);

    }
    @Test
    public void testPostMedicamentocomRoleAdministrador() throws Exception{

        String jsonCadastro = "{\"nome\": \"Buscopan\", " +
                "\"nomelab\": \"Clamed\", " +
                "\"dosagem\": \"100mg\"," +
                "\"descricao\": \"O remedio é usado para dor de cabeça\"," +
                "\"precounitario\": \"R$ 100,00\"," +
                "\"tipomedicamento\": \"comum\"}";

        path = new URI("/medicamentos");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .content(jsonCadastro)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isCreated();

        mock.perform(request).andExpect(expectedResult);

    }
    @Test
    public void testPUTMedicamentoscomRoleAdministrador() throws Exception {

        String jsonAtualiza = "{\"id\": \"1\", " +
                "\"nome\": \"Anador\", " +
                "\"nomelab\": \"Clamed\", " +
                "\"dosagem\": \"100mg\"," +
                "\"descricao\": \"O remedio é usado para dor de cabeça\"," +
                "\"precounitario\": \"R$ 100,00\"," +
                "\"tipomedicamento\": \"comum\"}";
        path = new URI("/medicamentos");


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(path)
                .content(jsonAtualiza)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }
    @Test
    public void testDeleteMedicamentoscomRoleAdministrador() throws Exception {

        path = new URI("/medicamentos/");


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(path)
                .param("id","1")
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }

    //TESTES COM O ENDPONT FARMACIAS COM A ROLE ADMINISTRADOR//
    //--------------------------------------------------------//


    @Test
    public void testGetAllFarmaciascomRoleAdministrador() throws Exception{

        path = new URI("/farmacias");


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(path)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isFound();

        mock.perform(request).andExpect(expectedResult);

    }
    @Test
    public void testPostFarmaciacomRoleAdministrador() throws Exception{

        String jsonCadastro = "{\"razaoSocial\": \"teste\", " +
                "\"cnpj\": \"12345678912345\", " +
                "\"dosagem\": \"teste nome\"," +
                "\"email\": \"teste email\"," +
                "\"telefone\": \"789456123\"," +
                "\"celular\": \"1235454\"," +
                "\"idEndereco\": \"{\\\"cep\\\": \\\"01001000\\\", \" +\n" +
                "                \"\\\"numero\\\": \\\"154\\\",\" +\n" +
                "                \"\\\"latitude\\\": \\\"1234\\\",\" +\n" +
                "                \"\\\"longitude\\\": \\\"1234\\\",\" +\n" +
                "                \"\\\"complemento\\\": \\\"casa\\\"}\"}";

        path = new URI("/farmacias");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(path)
                .content(jsonCadastro)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isCreated();

        mock.perform(request).andExpect(expectedResult);

    }
    @Test
    public void testPUTFarmaciacomRoleAdministrador() throws Exception {

        String jsonAtualiza = "{\"id\": \"1\", " +
                "\"razaoSocial\": \"teste\", " +
                "\"cnpj\": \"12345678912345\", " +
                "\"dosagem\": \"teste nome\"," +
                "\"email\": \"teste email\"," +
                "\"telefone\": \"789456123\"," +
                "\"celular\": \"1235454\"," +
                "\"idEndereco\": \"{\\\"cep\\\": \\\"01001000\\\", \" +\n" +
                "                \"\\\"numero\\\": \\\"154\\\",\" +\n" +
                "                \"\\\"latitude\\\": \\\"1234\\\",\" +\n" +
                "                \"\\\"longitude\\\": \\\"1234\\\",\" +\n" +
                "                \"\\\"complemento\\\": \\\"casa\\\"}\"}";
        path = new URI("/farmacias");


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put(path)
                .content(jsonAtualiza)
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }
    @Test
    public void testDeleteFarmaciacomRoleAdministrador() throws Exception {

        path = new URI("/farmacias/");


        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.delete(path)
                .param("id","1")
                .header("Content-Type", "application/json")
                .header("Authorization", jwtToken);

        expectedResult = MockMvcResultMatchers.status().isOk();

        mock.perform(request).andExpect(expectedResult);
    }


}
