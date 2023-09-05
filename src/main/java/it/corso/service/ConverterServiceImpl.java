package it.corso.service;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl implements ConverterService
{
	@Override
	public double[] getConverted(String temp)
	{
		try
		{
			double celsius = Double.parseDouble(temp.replace(",", "."));
			double[] converted = {(celsius * 1.8) + 32, celsius + 273.15};
			return converted;
		} catch (Exception e)
		{
			return null;
		}
	}
}