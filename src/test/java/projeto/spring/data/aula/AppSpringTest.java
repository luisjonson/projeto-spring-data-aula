package projeto.spring.data.aula;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring-config.xml" })
public class AppSpringTest {

	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;

	@Test
	public void testeIsert() {
		
		UsuarioSpringData usuarioSpringData = new  UsuarioSpringData();
		usuarioSpringData.setNome("Spring");
		usuarioSpringData.setEmail("spring@yahoo.com.br");
		usuarioSpringData.setIdade(30);
		usuarioSpringData.setLogin("teste123");
		usuarioSpringData.setSenha("12345");
		
		interfaceSpringDataUser.save(usuarioSpringData);

		System.out.println("Usuario no banco " + interfaceSpringDataUser.count());

	}
	
	@Test
	public void testeConsulta() {
		
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(2L);		
		System.out.println("Usuario é: " + usuarioSpringData.get().getNome());
		System.out.println("Idade: " + usuarioSpringData.get().getIdade());
		System.out.println("Email: " + usuarioSpringData.get().getEmail());
	}
	@Test
	public void testeConsultaTodos() {
		
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData usuarioSpringData : lista) {
			
			System.out.println("Nome: " + usuarioSpringData.getNome());
			System.out.println("Idade: " + usuarioSpringData.getIdade());
			System.out.println("Email: " +usuarioSpringData.getEmail());
			System.out.println("Senha: " + usuarioSpringData.getSenha());
			System.out.println("--------------------------------------------");
			
		}
	}

}
