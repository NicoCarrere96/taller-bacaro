package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.taller.Usuario;

@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario{
	
	@Inject
	private UsuarioDao servicioUsuarioDao;

	
	@Override
	public Usuario buscarPorId(Long usuarioId) {
		return servicioUsuarioDao.findById(usuarioId);
	}

}
