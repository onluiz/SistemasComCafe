package br.com.scc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.scc.entity.Car;

@Controller
public class CarController {

	@RequestMapping(value = "/cars", method = { RequestMethod.GET })
	public @ResponseBody Car cars() {
		Car car = new Car();
		car.setIdCar(new Long(1));
		car.setNome("Celta");
		car.setMarca("Chevrolet");
		car.setValor(16.500);
		return car;
	}
	
}
