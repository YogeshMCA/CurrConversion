package com.example.microservice.oAuthExample.Controller;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OAuthController {
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	

}
