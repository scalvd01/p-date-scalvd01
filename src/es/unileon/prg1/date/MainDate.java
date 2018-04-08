  package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		try {
			Date today, tomorrow;

				today = new Date(20, 3, 2018);
				tomorrow = new Date(21, 3, 2018);
				System.out.println(today.toString());
			
			
			System.out.println(today + " isSameYear " + tomorrow + "? " + today.isSameYear(tomorrow));
			System.out.println(today + " isSameMonth " + tomorrow + "? " + today.isSameMonth(tomorrow));
			System.out.println(today + " isSameDay " + tomorrow + "? " + today.isSameDay(tomorrow));
			System.out.println(today + " isSame " + tomorrow + "? " + today.isSame(tomorrow));
			System.out.println("El mes " + today.getMonth() + " es " + today.getMonthName());
			System.out.println("El dia es válido? " + today.isDayRight());
			System.out.println("La estación es: " + today.getSeasonName());
			System.out.println("Los meses restantes son: "+today.getMonthsLeft());
			System.out.println(today.toString());
			System.out.println(today.getDaysLeftOfMonth());
			System.out.println("Los meses con el mismo nº de dias que "+today.getMonthName()+" son: "+today.getMonthsSameDays());
			System.out.println("Han pasado "+today.daysPast()+" dias.");
			System.out.println("Intentos: "+today.numRandomTriesEqualDate1());
			System.out.println("Intentos: "+today.numRandomTriesEqualDate2());
			System.out.println("La fecha "+today.toString()+" es: "+today.dayOfWeek());
		}  
		catch (DateException e) {
				System.out.println(e.getMessage());
			}
	}

}
