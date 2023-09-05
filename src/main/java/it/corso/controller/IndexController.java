package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.service.ConverterService;

@Controller
@RequestMapping("/index")
public class IndexController
{
	@Autowired
  private ConverterService service;
	
	@GetMapping
	public String getPage(
			@RequestParam(name = "temp", required = false) String temp,
			Model model)
	{
		double[] converted = service.getConverted(temp);
		int parameter = 0;
		if(temp == null)
			parameter = 1;
		if(temp != null && converted == null)
			parameter = 2;
		model.addAttribute("converted", converted);
		model.addAttribute("parameter", parameter);
		return "index";
	}
}