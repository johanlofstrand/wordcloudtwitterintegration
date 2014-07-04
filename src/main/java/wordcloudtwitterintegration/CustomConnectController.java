package wordcloudtwitterintegration;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.stereotype.Controller;

/*
 * This controller is just for redirecting direct to result page instead of having a "twitterConnected" page as a man in the middle... 
 * 
 */


@Controller
public class CustomConnectController extends ConnectController{

    @Inject
    public CustomConnectController(
            ConnectionFactoryLocator connectionFactoryLocator,
            ConnectionRepository connectionRepository) {
        super(connectionFactoryLocator, connectionRepository);
    }


    @Override
    protected String connectedView(String providerId){
         return "redirect:/";
    }

}