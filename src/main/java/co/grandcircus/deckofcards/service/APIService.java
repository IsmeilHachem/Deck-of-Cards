package co.grandcircus.deckofcards.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.deckofcards.entity.CardsResponse;
import co.grandcircus.deckofcards.entity.Homepage;

@Component
public class APIService {
	
private RestTemplate restTemplate = new RestTemplate();
	
	// This is an instance initialization block. It runs when a new instance of the class is created--
	// right before the constructor.
	{
	    // This configures the restTemplateWithUserAgent to include a User-Agent header with every HTTP
		// request. Some of the APIs in this demo have a bug where User-Agent is required.
		ClientHttpRequestInterceptor interceptor = (request, body, execution) -> {
	        request.getHeaders().add(HttpHeaders.USER_AGENT, "Spring");
	        return execution.execute(request, body);
	    };
	    restTemplate = new RestTemplateBuilder().additionalInterceptors(interceptor).build();
	}
	
	public Integer display() {
		String deckId = "x7wxkrutawyb";

		String url = "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1";
		
		Homepage response = restTemplate.getForObject(url, Homepage.class);
		
		return response.getRemaining();

	}
	
	public CardsResponse draw(Integer count){
		// 1) Select the API endpoint:
		String deckId = "x7wxkrutawyb";
		String url = "https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=" + count;
		System.out.println(url);
		// 2) Get entire response from API
		CardsResponse response = restTemplate.getForObject(url, CardsResponse.class);
		System.out.println(response);
		
		// 3) return response
		return response;
		
	}
	
//	public Homepage shuffle() {
//		String deckId = "x7wxkrutawyb";
//		
//		String url = "https://deckofcardsapi.com/api/deck/" + deckId + "/shuffle";
//		
//		Homepage response = restTemplate.getForObject(url, Homepage.class);
//		
//		return response;
//	}
}
