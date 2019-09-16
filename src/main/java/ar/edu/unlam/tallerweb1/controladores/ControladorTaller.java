package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Controller
public class ControladorTaller {

	@RequestMapping("/registrarse")
	public ModelAndView registro() {
		ModelMap modelo = new ModelMap();
		Taller taller = new Taller();
		modelo.put("taller", taller);
		return new ModelAndView("formularios/registrarse", modelo);

	}

	@RequestMapping(method = RequestMethod.POST)
	public String initForm(ModelMap model) {

		Taller list = new Taller();
		list.setLista("Hibernate");
		model.addAttribute("taller", list);
		return "TallerForm";
	}

	@ModelAttribute("ListaEspecialidades")
	public List<String> especialidades() {
		List<String> lista = new ArrayList<String>();
		lista.add("Mecanica General");
		lista.add("Chapa y Pintura");
		lista.add("Alineacion y Balanceo");
		lista.add("Electricidad");
		lista.add("Suspension");
		lista.add("Lubricentro");
		lista.add("Gomeria");

		return lista;

	}

}
