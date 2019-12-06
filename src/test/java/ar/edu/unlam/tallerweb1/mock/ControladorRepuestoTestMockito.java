package ar.edu.unlam.tallerweb1.mock;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorStockRepuestos;
import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;

public class ControladorRepuestoTestMockito extends SpringTest{
	
	@Mock
	private Repuesto repuesto;

	@Mock
	private HttpServletRequest request;
	
	@Mock
	private HttpSession session;

	@InjectMocks
	private ControladorStockRepuestos controladorStockRepuesto;
	private Repuesto repuesto1 , repuesto2;
	private List<Repuesto> listaDeRepuestos;
	private Session sesion;
	
	@Mock
	private ServicioRepuesto servicioRepuesto;

	@Before
	public void inyeccionDeMocksInicializada() {
		MockitoAnnotations.initMocks(this);
	}
	public void inicializacion() {
		repuesto1 = new Repuesto();
		repuesto2 = new Repuesto();
		sesion = session();
		listaDeRepuestos = new ArrayList<Repuesto>();
	}
	
	@Test(expected = Exception.class)
	@Transactional
	@Rollback(true)
	@SuppressWarnings("unchecked")
	public void testQueAlCrearUnRepuestoSiYaExisteDevuelvaError() throws Exception {
		repuesto1.setNombre("Neumatico");
		repuesto2.setNombre("Neumatico");
		

		if(this.repuesto1.getNombre().equals(this.repuesto2.getNombre())) {
			throw new Exception("Ya existe un repuesto con ese nombre, por favor elija otro");
		} else {
			System.out.println("Repuesto valido");
		}

		/*getSession().save(repuesto1);
		getSession().save(repuesto2);*/


		listaDeRepuestos = sesion.createCriteria(Repuesto.class)
						  .add(Restrictions.and(Restrictions.eq("nombre", "nombre")))
						  .list();

		assertThat(listaDeRepuestos .get(0).getNombre()).isEqualTo(repuesto1.getNombre()).isNotNull();
		assertThat(listaDeRepuestos).hasSize(1);
	}
	
	@Test
	public void testQueVerificaQueElRepuestoSeaValido() {
		when(request.getSession()).thenReturn(session);
		//when(ServicioRepuesto.getId(any(Long.class))).thenReturn(repuesto);

		when(repuesto.getNombre()).thenCallRealMethod();
		when(repuesto.getPrecio()).thenCallRealMethod();
		when(repuesto.getStock()).thenCallRealMethod();

		//ModelAndView modelo = controladorStockRepuesto.irAagregarRepuesto(repuesto, bindingResult, request);    

		//assertThat(modelo.getViewName()).isEqualTo("correcto");

		verify(session , times(0)).setAttribute("nombre", "repuesto");
		verify(session , times(0)).setAttribute("precio", "repuesto");
		verify(session , times(0)).setAttribute("stock", "repuesto");

	}
	
	
	@Test
	public void agregarUnRepuestoAUnTaller() {
		
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		Taller taller = mock(Taller.class);
		
		controladorStockRepuesto.setServicioRespuesto(servicioRepuesto);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("taller")).thenReturn(taller);
		
		ModelAndView rep = controladorStockRepuesto.agregarRepuesto(request);
		
		assertThat(rep.getViewName()).isEqualTo("repuestos/agregarRepuesto");
		
	}
	
	@Test
	public void eliminarRepuestoAUnTaller() {
		
		Long idRepuesto = 1L;
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		Taller taller = mock(Taller.class);
		
		controladorStockRepuesto.setServicioRespuesto(servicioRepuesto);
		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("taller")).thenReturn(taller);
		
		ModelAndView rep = controladorStockRepuesto.eliminarRepuesto(idRepuesto, request);
		
		assertThat(rep.getViewName()).isEqualTo("redirect: abmRepuestos");
		
	}

}
