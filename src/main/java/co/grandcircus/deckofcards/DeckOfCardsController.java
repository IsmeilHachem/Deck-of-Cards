package co.grandcircus.deckofcards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.deckofcards.entity.CardsResponse;
import co.grandcircus.deckofcards.entity.DrawCards;
import co.grandcircus.deckofcards.service.APIService;

@Controller
public class DeckOfCardsController {
	
	@Autowired
	private APIService apiService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		Integer cards = apiService.display();
		mv.addObject("list", cards);
		return mv;
	}
	
	@RequestMapping("/draw")
	public ModelAndView details(@RequestParam(name="draw") Integer draw) {
		ModelAndView mv = new ModelAndView("draw");
		
		CardsResponse detail = apiService.draw(draw);
		List<DrawCards> cards = detail.getCards();
		System.out.println(detail);
		mv.addObject("draw", cards);
		return mv;
		
	}
	
	@RequestMapping("/reshuffle")
	public ModelAndView shuffle(@RequestParam(value="deckId", required=false) String id) {
		return new ModelAndView("/reshuffled");
	}
//	@RequestMapping("/reshuffle")
//	public ModelAndView shuffle(@RequestParam("deckId") String id) {
//		Homepage cards = apiService.display();
//		return new ModelAndView("redirect:/");
//	}
}
