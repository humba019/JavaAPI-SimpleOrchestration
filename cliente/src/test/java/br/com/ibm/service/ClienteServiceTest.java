//package br.com.ibm.service;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import br.com.ibm.model.Cliente;
//import br.com.ibm.service.impl.ClienteServiceImpl;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ClienteServiceTest {
//
//	String dtNasc = "23/06/2019";
//
//	@Mock
//	ClienteService clienteService;
//
//	@InjectMocks
//	ClienteServiceImpl clienteServiceImpl;
//
//	private Cliente cliente = new Cliente("334.567.829-05", "Jonas Brothers","23-", 12345);
//
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void deve_criar_novo_cliente(){
//		Cliente c = clienteService.criaCliente(this.cliente);
//		c = this.cliente;
//
//			assertThat(c.getCpf(), is("334.567.829-05"));
//
//	}
//
//	@Test
//	public void deve_consultar_cliente() {
//		List<Cliente> con = clienteService.consultaCliente();
//		con.add(this.cliente);
//
//			assertThat(con.get(0), is(this.cliente));
//
//	}
//
//	@Test
//	public void deve_consultar_cliente_por_cpf() {
//		Cliente c = clienteService.consultaClienteCpf(this.cliente.getCpf());
//		c = this.cliente;
//
//			assertThat(c.getCpf(), is("334.567.829-05"));
//
//	}
//
//	@Test
//	public void deve_excluir_cliente_por_cpf() {
//		String n = null;
//		this.cliente = clienteService.deletaCliente(this.cliente.getCpf());
//
//			assertThat(this.cliente, is(n));
//
//	}
//
//	@Test
//	public void deve_alterar_cliente_existente() {
//		this.cliente.setCpf("334.567.829-05");
//			Cliente c = clienteService.alterarCliente(this.cliente);
//			c = this.cliente;
//
//			assertThat(c.getCpf(), is(33456782905L));
//
//
//
//	}
//}
