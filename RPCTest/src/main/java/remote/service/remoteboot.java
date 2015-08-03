package remote.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class remoteboot {
	
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "redirect:http://www.baidu.com";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(remoteboot.class, args);
	}

}
