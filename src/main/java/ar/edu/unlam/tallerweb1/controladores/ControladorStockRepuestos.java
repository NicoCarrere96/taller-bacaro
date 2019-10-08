package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.taller.Repuesto;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;
import ar.edu.unlam.tallerweb1.modelo.taller.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRepuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioTaller;
import ar.edu.unlam.tallerweb1.utils.Especialidad;

@Controller
@RequestMapping(path = "/stockRepuestos" , method = RequestMethod.GET)
public class ControladorStockRepuestos {
	
	@Inject
	private ServicioRepuesto servicioRepuesto;
	
	/*@RequestMapping(path = "crearRepuesto" , method = RequestMethod.POST)
	public ModelAndView crearRepuesto(@ModelAttribute("repuesto") Repuesto repuesto , HttpServletRequest request) 
	{
		if(request.getSession().getAttribute("id") == null)
		{
			return new ModelAndView("redirect:/");

	    }
		
	
	@RequestMapping (path  = " / editarRepuesto / {idRepuesto} " , method  =  RequestMethod . GET )
	public  ModelAndView  irAeditarRepuesto (HttpServletRequest request, @PathVariable  long  idRepuesto ) {
		
		ModelMap modelo =  new  ModelMap ();
		Repuesto repuesto = new  Repuesto ();
		modelo . put ( " idRepuesto " , repuesto);
		
		if(servicioRepuesto.consultarRepuesto(repuesto) == null) {

			servicioRepuesto.guardarRepuesto(repuesto);
			modelo.put("aviso", "Se creo correctamente");

		} else {
			modelo.put("aviso", "No se pudo crear correctamente");
			Repuesto repuesto=new Repuesto();
		   modelo.put("repuesto", servicioRepuesto.getIdRepuesto(idRepuesto));
		   modelo.put("idRepuesto", repuesto);

		}
		
		Repuesto repuestoNuevo= new Repuesto();
		modelo.put("repuesto", repuestoNuevo);


		List<Repuesto>repuestos = servicioRepuesto.listarTodosLosRepuestos();
		modelo.put("repuestos", repuestos);

		return new ModelAndView("stockRepuesto",modelo);
		return  new  ModelAndView ( " editarRepuesto " , modelo);
	}*/
	
	@RequestMapping ( path  = " / validarRepuesto / " , method  =  RequestMethod . POST )
	public  ModelAndView  validarRepuesto ( @ModelAttribute ( " repuesto " ) Repuesto  repuesto) {
		
		ModelMap modelo =  new  ModelMap ();
		modelo . put ( " repuesto " , modelo);
		modelo . put ( " nombre " , modelo);
		modelo . put ( " precio " , modelo);
		servicioRepuesto . guardarRepuesto (repuesto);
		modelo . put ( " aviso " , " Se CREO exitosamente " );

		return  new  ModelAndView ( " editarRepuesto " , modelo);
	}
	@RequestMapping ( " / formRepuesto " )
	public  ModelAndView  ingresarRepuesto ( ) {

		 ModelMap modelo = new  ModelMap ();
		 Repuesto repuesto = new  Repuesto ();
		modelo . put ( " repuesto " , repuesto);	
		return  new  ModelAndView ( " formRepuesto " , modelo);
	}
	
	
	/*
	 
	  @RequestMapping(path="/agregarRepuesto " , method  =  RequestMethod . GET)
	public ModelAndView agregarRepuesto(HttpServletRequest request)
	{
		Long idRepuesto = (Long) request.getSession().getAttribute("idRepuesto");
		ModelMap model = new ModelMap();
		//Long idRepuesto = (Long) request.getSession().getAttribute("idRepuesto");
		ModelMap model = new ModelMap();
		if (idRepuesto != null) 
		{
		  Repuesto repuesto = new Repuesto();
		  model.put("repuesto", repuesto);
		  return new ModelAndView("/agregarRepuesto", model);
		} 
		else
		{
			return new ModelAndView("redirect:/login");
		}
	}
	@RequestMapping(path = "/guardarRepuesto", method = RequestMethod.POST)
	public ModelAndView guardarRepuesto(@RequestParam("Repuesto") Long idRepuesto,
			@ModelAttribute("Repuesto") Repuesto repuesto, HttpServletRequest request)
	{
		//Long idRepuesto = (Long) request.getSession().getAttribute("idRepuesto");
		ModelMap model = new ModelMap();
		
		if (idRepuesto != null) {
			if (servicioRepuesto.buscarPorId(idRepuesto)) {
				repuesto.setIdRepuesto(servicioRepuesto.getId(IdRepuesto));
				servicioRepuesto.guardarRepuesto(Repuesto);

				model.put("aviso", "Creacion Exitosa");
				model.put("mensaje",String.format("Se ha guardado con el id %d de manera exitosa", vehiculo.getId()));
			} else {
				model.put("avisoError", "Creacion Fallida");
				model.put("mensajeError", String.format("No se ha podido crear el vehiculo"));
			}
			return new ModelAndView("/mensaje", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}
	
	@RequestMapping(path = "/guardarRepuesto", method = RequestMethod.POST)
	public ModelAndView guardarRepuesto(@ModelAttribute("Repuesto") Repuesto repuesto, HttpServletRequest request)
	{
		Long idRepuesto = (Long) request.getSession().getAttribute("idRepuesto");
		ModelMap model = new ModelMap();
		if (idRepuesto != null) 
		{
			if (servicioRepuesto.buscarRepuestoPorId(idRepuesto))
			{
				if (servicioRepuesto.consultarRepuesto(repuesto) == null) 
				{
					servicioRepuesto.nuevoRepuesto(repuesto);
					model.put("repuesto", repuesto);
					model.put("aviso", "Creacion Exitosa");
					model.put("mensaje",String.format("Se ha creado el repuesto con el id %d de manera exitosa", repuesto.getId()));
				} 
			 }
			else 
			{
				model.put("avisoError", "El repuesto no se guardo");
				model.put("mensajeError", String.format("El repuesto no se guardo correctamente : %s", repuesto.getId()));
			}
	    }
     }*/	
}