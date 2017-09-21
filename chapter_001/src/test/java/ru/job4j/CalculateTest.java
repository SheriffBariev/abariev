package ru.job4j;

import org.junit.Test;
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
*Test.
*
*@author Ayup Bariev (mailto:abdullaiman06@gmail.com)
*@version $id$
*@since 20.09.2017
*/
public class CalculateTest {
	/**
	*Test echo.
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
		String input = "Ayup Bariev";
		String expect = "Echo, echo, echo : Ayup Bariev";
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}