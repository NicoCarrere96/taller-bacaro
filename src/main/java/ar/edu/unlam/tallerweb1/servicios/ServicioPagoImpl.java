package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.Address;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Identification;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import com.mercadopago.resources.datastructures.preference.Phone;

import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Service("ServicioPago")
public class ServicioPagoImpl implements ServicioPago {
	@Autowired
	private Preference preference;
	private static String token="TEST-2418432562629612-110104-478e9fdf0282b2e53f214c425d215a4b-485180789";
	
	public Preference realizarPago(Cliente cliente, Taller taller, Double total) {
		//Preference preference = new Preference();
		try {
			MercadoPago.SDK.setAccessToken(token);

			// Crea un objeto de preferencia
			Payer payer = new Payer();
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date today = Calendar.getInstance().getTime();        
			payer.setName(cliente.getNombre()).setSurname("").setEmail(cliente.getMail())
					.setDateCreated(df.format(today))
					.setPhone(new Phone().setAreaCode("").setNumber("1164545784"))
					.setIdentification(new Identification().setType("DNI").setNumber("12345678"))
					.setAddress(new Address().setStreetName("Calle").setStreetNumber(1004)
							.setZipCode("11020"));
			preference.setPayer(payer);
			// Crea un ítem en la preferencia
			Item item = new Item();
				item.setId(taller.getId().toString())
					.setTitle("#"+String.valueOf(taller.getNumero()))
					.setQuantity(1)
					.setCurrencyId("ARS")
					.setUnitPrice(total.floatValue());
			BackUrls backUrls = new BackUrls
					("http://localhost:8080/taller-bacaro/", 
					"http://localhost:8080/taller-bacaro/",
					"http://localhost:8080/taller-bacaro/");
			preference.setBackUrls(backUrls);
			preference.appendItem(item);
			preference.save();	
			
		}
		catch (MPException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		return preference;
	}

}

