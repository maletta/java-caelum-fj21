package br.com.jf21.jdbc.test;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestaData {
	public static void main(String args[]) {
		LocalDateTime myDateObj = LocalDateTime.now();
		System.out.println("Antes de formatar " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String formattedDate = myDateObj.format(myFormatObj);
		System.out.println("Depois de formatar " + formattedDate);
	}
}
