package br.gov.tcu.bbt.web.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasKey;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UsuarioControllerTest {

	@Test
	public void listarUsuarios__deve_trazer_200_ok() throws Exception {
		criarMockMvc().perform(get("/usuario"))
            	 .andDo(print())
            	 .andExpect(status().isOk())
            	 .andExpect(view().name("usuario/all"));
	}

	private MockMvc criarMockMvc() {
		return MockMvcBuilders.standaloneSetup(new UsuarioController()).build();
	}

	@Test
	public void novoUsuario__deve_trazer_200_ok() throws Exception {
		criarMockMvc().perform(get("/usuario/novo"))
    			 .andExpect(status().isOk())
            	 .andExpect(view().name("usuario/novo"));
	}

	@Test
	public void criarUsuario__deve_trazer_fazer_redirect() throws Exception {
		criarMockMvc().perform(post("/usuario").param("nome", "bob"))
        		 .andDo(print())
        		 .andExpect(status().isMovedTemporarily())
        		 .andExpect(redirectedUrl("/usuario"));
	}
	
	@Test
	public void variavelString__deve_trazer_200_ok() throws Exception {
		criarMockMvc().perform(get("/usuario/string"))
		         .andDo(print())
		    	 .andExpect(status().isOk())
		    	 .andExpect(view().name("usuario/string"))
		    	 .andExpect(model().attributeExists("variavelString"));
	}
	
	@Test
	public void variavelMap__deve_trazer_200_ok() throws Exception {
		criarMockMvc().perform(get("/usuario/map"))
			     .andDo(print())
			     .andExpect(status().isOk())
			     .andExpect(view().name("usuario/map"))
			     .andExpect(model().attribute("variavelMap", hasKey("um")))
			     .andExpect(model().attribute("variavelMap", hasKey("dois")));
	}

}