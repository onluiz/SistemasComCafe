package br.com.scc.SistemasComCafe_RESTCliente;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class App{
	
	public static final String SERVER_URI = "http://localhost:8080/scc/cars";
    
	public static void main( String[] args ){
		testGetCars();
    }
	
	public static void testGetCars() {
		RestTemplate restTemplate = new RestTemplate();
		String carJson = restTemplate.getForObject("http://localhost:8080/scc/cars", String.class);
		
		Gson gson = new Gson();
		Car car = gson.fromJson(carJson, Car.class);
		System.out.println("finished");
	}
}
