package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.dao.TallerDao;
import ar.edu.unlam.tallerweb1.modelo.taller.Localidad;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

public class TallerTest extends SpringTest{
	
	@Autowired
	private TallerDao dao;
	
	@SuppressWarnings("unchecked")
	@Test
	@Transactional
	@Rollback
	
	public void TestQueCreaUnTaller() {
		Localidad loc = new Localidad();
		loc.setNombre("Flores");
		Localidad loc2 = new Localidad();
		loc2.setNombre("Floresta");
		session().save(loc);
		session().save(loc2);
		
		
		Taller nuevoTaller = new Taller();
		nuevoTaller.setNombreDelTaller("Taller Cacho");
		nuevoTaller.setNombreDelDuenio("Cacho");
		nuevoTaller.setTelefono("44873333");
		nuevoTaller.setCalle("Rivadavia");
		nuevoTaller.setNumero(4500);
		nuevoTaller.setLocalidad(loc);
		dao.crearTaller(nuevoTaller);
		Taller nuevoTaller2 = new Taller();
		nuevoTaller2.setNombreDelTaller("Gomeria Enzo");
		nuevoTaller2.setNombreDelDuenio("Enzo");
		nuevoTaller2.setTelefono("44541199");
		nuevoTaller2.setCalle("Laprida");
		nuevoTaller2.setNumero(200);
		nuevoTaller2.setLocalidad(loc2);
		dao.crearTaller(nuevoTaller2);
		List<Taller> talleres = session().createCriteria(Taller.class)
				.add(Restrictions.eq("calle","Rivadavia"))
				.list();
		
		assertThat(talleres.size()).isEqualTo(1);
	}

}
