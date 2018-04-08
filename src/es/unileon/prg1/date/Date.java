package es.unileon.prg1.date;

import java.util.Random;//para el numero aleatorio




public class Date {
	private int day;
	private int month;
	private int year;
	
	//constructor con excepciones 
	public Date(int day, int month, int year) throws DateException{
		this.year = year;
		if (month<1 || month>12){
				throw new DateException("Mes "+month+" no válido. Valores posibles entre 1 y 12");
		}else{
			this.month=month;
		}
		switch(this.month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
					if(day<1 || day>31){
							throw new DateException("Dia "+day+" no válido en el mes "+month);
					}else{
						this.day = day;
					}
					break;
			case 4:
			case 6:
			case 9:
			case 11:
					if(day<1 || day>30){
							throw new DateException("Dia "+day+" no válido en el mes "+month);
					}else{
						this.day = day;
					}
					break;
			case 2:if(day<1 || day>28){
							throw new DateException("Dia "+day+" no válido en el mes "+month);
					}else{
						this.day = day;
					}
					break;
		}
	}




	public void setYear(int year){
		this.year=year;
	}
	public int getYear(){
		return this.year;
	}
	public void setMonth(int month){
		this.month=month;
	}
	public int getMonth(){
		return this.month;
	}
	public void setDay(int day){
		this.day=day;
	}
	public int getDay(){
		return this.day;
	}
	



		//para comprobar si  dia mes y año son iguales en ambas fechas
	boolean isSameYear(Date another){
		if ( this.year == another.getYear() ){
			return true;
		}
		return false;
	}
		

	boolean isSameMonth(Date another){
		if ( this.month == another.getMonth() ){
			return true;
		}
		return false;
	}


	boolean isSameDay(Date another){
		if ( this.day == another.getDay() ){
			return true;
		}
		return false;
	}
	//si todo es igual a la vez
	boolean isSame(Date another){
		if( this.year == another.getYear() && this.month == another.getMonth() && this.day == another.getDay()){
			return true;
		}
		return false;
	}






	//para el nombre del mes

	public String getMonthName(){

		String monthName=null;

		switch (this.month){

			case 1: monthName = "Enero";
					break;
			case 2: monthName = "Febrero";
					break;
			case 3: monthName = "Marzo";
					break;
			case 4: monthName = "Abril";
					break;
			case 5: monthName = "Mayo";
					break;
			case 6: monthName = "Junio";
					break;
			case 7: monthName = "Julio";
					break;
			case 8: monthName = "Agosto";
					break;
			case 9: monthName = "Septiembre";
					break;
			case 10: monthName = "Octubre";
					break;
			case 11: monthName = "Noviembre";
					break;
			case 12: monthName = "Diciembre";
					break;
			default: monthName = "Mes inválido";
					break;
		}
		return monthName;
	}






	//para si el dia del mes esta bien

	public boolean isDayRight(){
		if (((this.month==1) || (this.month==3) || (this.month==5) || (this.month==7) || (this.month==8) || (this.month==10) || (this.month==12)) && ((this.day<=31) && (this.day>0))){
			return true;
		}
		else if((this.month==4) || (this.month==6) || (this.month==9) || (this.month==11) && ((this.day<=30) && (this.day>0))){
			return true;
		}
		else if ((this.month==2) && ((this.day<=28) && (this.day>0))){
			return true;
		}
		else{
			return false;
		}
	}





	//para obtener las estaciones

	public String getSeasonName(){
		String seasonName=null;

		switch(this.month){
			case 1: seasonName = "Invierno";
					break;
			case 2: seasonName = "Invierno";
					break;
			case 3: if(this.day<21){
						seasonName = "Invierno";
					}
					else{
						seasonName = "Primavera";
					}
					break;
			case 4: seasonName = "Primavera";
					break;
			case 5: seasonName = "Primavera";
					break;
			case 6: if(this.day<20){
						seasonName = "Primavera";
					}
					else{
						seasonName = "Verano";
					}
					break;
			case 7: seasonName = "Verano";
					break;
			case 8: seasonName = "Verano";
					break;
			case 9: if(this.day<21){
						seasonName = "Verano";
					}
					else{
						seasonName = "Otoño";
					}
					break;
			case 10:seasonName = "Otoño";
					break;
			case 11:seasonName = "Otoño";
					break;
			case 12:if(this.day<20){
						seasonName = "Otoño";
					}
					else{
						seasonName = "Invierno";
					}
					break;
		}
		return seasonName;
	}






	//para imprimir los meses restantes hasta final de año

	public String getMonthsLeft(){
		StringBuilder months = new StringBuilder();
		int a = getMonth();
		for (int i = a+1; i<=12; i++){

			a = a + 1;
			months.append(this.getMonthName()+" ");
		}
		return months.toString();
	}
	




	//para imprimir la fecha

	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}





	//para imprimir todas las fechas hasta el final del mes

	public String getDaysLeftOfMonth(){
		StringBuilder daysLeft = new StringBuilder();
		
		switch(this.month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
					for(int dias = this.day; dias<=31; dias++){
						daysLeft.append(dias+"/"+this.month+"/"+this.year+" ");
					}
					break;
			case 4:
			case 6:
			case 9:
			case 11:
					for(int dias = this.day; dias<=30; dias++){
						daysLeft.append(dias+"/"+this.month+"/"+this.year+" ");
					}
					break;
			case 2: for(int dias = this.day; dias<=28; dias++){
						daysLeft.append(dias+"/"+this.month+"/"+this.year+" ");
					}
					break;
		}
		
		return daysLeft.toString();
	}






	//para mostrar los meses con el mismo numero de dias que una fecha

	public String getMonthsSameDays(){
		String monthsSameDays=null;
		switch(this.month){

			case 1: monthsSameDays = "Marzo, Mayo, Julio, Agosto, Octubre y Diciembre";
					break;
			case 2: monthsSameDays = "(ningún otro)";
					break;
			case 3: monthsSameDays = "Enero, Mayo, Julio, Agosto, Octubre y Diciembre";
					break;
			case 4: monthsSameDays = "Junio, Septiembre y Noviembre";
					break;
			case 5: monthsSameDays = "Enero, Marzo, Julio, Agosto, Octubre y Diciembre";
					break;
			case 6: monthsSameDays = "Abril, Septiembre y Noviembre";
					break;
			case 7: monthsSameDays = "Enero, Marzo, Mayo, Agosto, Octubre y Diciembre";
					break;
			case 8: monthsSameDays = "Enero, Marzo, Mayo, Julio, Octubre y Diciembre";
					break;
			case 9: monthsSameDays = "Abril, Junio y Noviembre";
					break;
			case 10: monthsSameDays = "Enero, Marzo, Mayo, Julio, Agosto y Diciembre";
					break;
			case 11: monthsSameDays = "Abril, Junio y Septiembre";
					break;
			case 12: monthsSameDays = "Enero, Marzo, Mayo, Julio, Agosto y Octubre";
					break;
			
		}
		return monthsSameDays;
	}






	//para contar el num de dias que han pasado en una fecha

	public int daysPast(){
		int days=0;


		switch(this.month){
			case 1: days=days+getDay();
					break; 
			case 2: days=31+getDay();
					break; 
			case 3: days=59+getDay();
					break;
			case 4: days=90+getDay();
					break;
			case 5: days=120+getDay();
					break;
			case 6: days=151+getDay();
					break;
			case 7: days=181+getDay();
					break;
			case 8: days=212+getDay();
					break;
			case 9: days=243+getDay();
					break;
			case 10: days=273+getDay();
					break;
			case 11: days=304+getDay();
					break;
			case 12: days=334+getDay();
					break;
			
		}
		return days;
	}





	//para el numero de intentos que tarda en acertar una fecha aleatoria

	public int numRandomTriesEqualDate1(){
		int count=0;
		Random random=new Random();
		int randomDay=0;
		int randomMonth=0;


		while((this.day!=randomDay) || (this.month!=randomMonth)){
			if((this.month==1) || (this.month==3) || (this.month==5) || (this.month==7) || (this.month==8) || (this.month==10) || (this.month==12)){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(32)+1;
				count=count+1;
			}
			else if((this.month==4) || (this.month==6) || (this.month==9) || (this.month==11)){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(31)+1;
				count=count+1;
			}
			else if (this.month==2){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(29)+1;
				count=count+1;
			}
		}
		return count;

	}

	//lo mismo pero con do while

	public int numRandomTriesEqualDate2(){
		int count=0;
		Random random=new Random();
		int randomDay=0;
		int randomMonth=0;
		do{
			if((this.month==1) || (this.month==3) || (this.month==5) || (this.month==7) || (this.month==8) || (this.month==10) || (this.month==12)){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(32)+1;
				count=count+1;
			}
			else if((this.month==4) || (this.month==6) || (this.month==9) || (this.month==11)){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(31)+1;
				count=count+1;
			}
			else if (this.month==2){
				randomMonth=random.nextInt(13)+1;
				randomDay=random.nextInt(29)+1;
				count=count+1;
			}
		}while((this.day!=randomDay) || (this.month!=randomMonth));

		return count;
	}





	//para decir el dia de la semana de una fecha
	
	public String dayOfWeek(){
		String dia=null;
		int resto = daysPast()%7;
		
		
			switch(resto){
				case 1: dia="Lunes";
						break; 
				case 2: dia="Martes";
						break; 
				case 3: dia="Miércoles";
						break;
				case 4: dia="Jueves";
						break;
				case 5: dia="Viernes";
						break;
				case 6: dia="Sábado";
						break;
				case 0: dia="Domingo";
						break;
			}
		return dia;
	}

}

