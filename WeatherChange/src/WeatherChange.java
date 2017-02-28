import java.io.*;
import java.util.*;

public class WeatherChange {
	public char Weather(){
		Scanner input = new Scanner(new File(“C://Desktopweather.txt”));
		Double weather1 = input.nextDouble;
		Double weather2 = input.nextDouble;
		System.out.print(weather2 - weather1);
		}
}
