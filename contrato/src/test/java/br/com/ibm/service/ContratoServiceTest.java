//package br.com.ibm.service;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import br.com.ibm.model.Contrato;
//
//public class ContratoServiceTest {
//
//	@Mock
//	private ContratoService contratoService;
//
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void deve_inserir_novo_contrato() {
//
//		Data data = new Data();
//		String dataIni = "23/06/2019";
//		String dataFim = "15/07/2019";
//		LocalDate inicio = data.converteDataBarra(dataIni);
//		LocalDate fim = data.converteDataBarra(dataFim);
//
//		Contrato contrato = new Contrato(1010, 5000.0,"ativo");
//			contratoService.criarContrato(contrato);
//				assertThat(inicio.getDayOfMonth(), is(23));assertThat(inicio.getMonthValue(), is(6));assertThat(inicio.getYear(), is(2019));
//				assertThat(fim.getDayOfMonth(), is(15));assertThat(fim.getMonthValue(), is(7));assertThat(fim.getYear(), is(2019));
//				assertThat(contrato.getNumContrato(), is(1010));
//				assertThat(contrato.getCpfCliente(), is("462.877.438-24"));
//				assertThat(contrato.getStatus(), is("ativo"));
//				assertThat(contrato.getDtIni(), is(dataIni));
//				assertThat(contrato.getDtFim(), is(dataFim));
//	}
//
//	@Test
//	public void deve_consultar_contratos() {
//
//		Contrato contrato = new Contrato(1010, 5000.0,"ativo");
//		Contrato contrato2 = new Contrato(1020, 5000.0,"inativo");
//			contrato.equals(contratoService.criarContrato(contrato));
//			contratoService.criarContrato(contrato2);
//			List<Contrato> c  = contratoService.consultarContrato();
//				assertThat(c.add(contrato), is(true));
//				assertThat(c.add(contrato2), is(true));
//				assertThat(c.get(0), is(contrato));
//				assertThat(c.get(1), is(contrato2));
//
//	}
//
//	@Test
//	public void deve_excluir_contratos_por_numero() {
//		Long n = null;
//
//		Contrato contrato = new Contrato(1010, 5000.0,"ativo");
//			contrato.equals(contratoService.criarContrato(contrato));
//			List<Contrato> c = contratoService.consultarContrato();
//				assertThat(c.add(contrato), is(true));
//				assertThat(contratoService.deletarContrato(c.get(0).getNumContrato()), is(n));
//	}
//
//	@Test
//	public void deve_consultar_contratos_por_numero() {
//
//		Contrato contrato = new Contrato(1010, 5000.0,"ativo");
//			contrato.equals(contratoService.criarContrato(contrato));
//			contrato.equals(contratoService.consultarContratoNum(contrato.getNumContrato()));
//				assertThat(contrato.getNumContrato(), is(1010));
//	}
//
//	@Test
//	public void deve_consultar_contratos_por_cpf_do_cliente() {
//
//		Contrato contrato = new Contrato(1010, 5000.0,"ativo");
//		contrato.equals(contratoService.criarContrato(contrato));
//			List<Contrato> c = contratoService.consultarContratoCpfCliente(contrato.getCpfCliente());
//				assertThat(c.add(contrato), is(true));
//				assertThat(c.get(0).getCpfCliente(), is("462.877.438-24"));
//	}
//
//	@Test
//	public void deve_consultar_contratos_por_numero_e_cpf_do_cliente() {
//
//		Contrato contrato = new Contrato(1010, 5000.0,"ativo");
//		contrato.equals(contratoService.criarContrato(contrato));
//			List<Contrato> c = contratoService.consultarContratoNumContratoAndCpfCliente(contrato.getNumContrato(), contrato.getCpfCliente());
//				assertThat(c.add(contrato), is(true));
//				assertThat(c.get(0).getCpfCliente(), is("462.877.438-24"));
//				assertThat(c.get(0).getNumContrato(), is(1010));
//				assertThat(c.get(0).concatCpfAndNumero(), is("462.877.438-24_1010"));
//
//	}
//
//	@Test
//	public void deve_alterar_contrato_existente() {
//
//		Contrato contrato = new Contrato(1010, 5000.0,"ativo");
//		contrato.equals(contratoService.criarContrato(contrato));
//			List<Contrato> c = contratoService.consultarContrato();
//				assertThat(c.add(contrato), is(true));
//				c.get(0).setCpfCliente("");
//				c.get(0).setStatus("inativo");
//			contratoService.alterarContrato(contrato);
//				assertThat(c.add(contrato), is(true));
//				assertThat(c.get(0).getCpfCliente(), is(""));
//				assertThat(c.get(0).getStatus(), is("inativo"));
//
//	}
//}
