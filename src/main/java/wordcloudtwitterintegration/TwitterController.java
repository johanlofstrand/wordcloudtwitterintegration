package wordcloudtwitterintegration;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class TwitterController {
	
	private Twitter twitter;
	private ConnectionRepository connectionRepository;
	
	@Inject
	public TwitterController(Twitter twitter, ConnectionRepository connectionRepository) {
		this.twitter = twitter;
		this.connectionRepository = connectionRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String fetchTwitterData(Model model) {
		if(connectionRepository.findPrimaryConnection(Twitter.class) == null) {
			return "redirect:/connect/twitter";
		}
		
		SearchResults result = twitter.searchOperations().search("#svt");
		List<Tweet> tweets = result.getTweets();
		
		model.addAttribute("tweets",tweets);
		return "searchresult";
		
	}
	
}
