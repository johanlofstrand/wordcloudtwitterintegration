package wordcloudtwitterintegration;

import java.util.List;

import org.springframework.social.twitter.api.Tweet;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Use RestController (instead of Controller) in order to return with automatic JSON conversion of provided objects... 
public class TwitterRestController {

	  @RequestMapping("/t")
	    public Tweet greeting(Model model) {
	        
		 List<Tweet> tweets= (List<Tweet>) model.asMap().get("tweets"); 
		  
		  
		 
		 return tweets.get(0);
		 
		}
}
