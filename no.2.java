//U10416031

import java.util.Scanner;

public class PrintCalender {
//main method
	public static void main(String[] args){

/*prompt the user to enter the year and the month
and if the user enter more than two numbers will 
let the user enter again*/
  	if (args.length!=2){
			System.out.println("Error!!  You should enter two number eg: 5 2016");
			System.exit(0);
		}

// 
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);
		
		Test t= new Test();
		t.printMonth(year, month);
	}
	
}
class Test{

//print the calendar for a month in a year
	public void printMonth(int year, int month){
		
//print the headings of the calendar		
		printMonthTitle(year, month);

//print the body of the calendar		
		printMonthBody(year, month);
	}

//print the month title 	
	public void printMonthTitle(int year, int month){
		System.out.println("         "+getMonthName(month)+" "+year);
		System.out.println("-----------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

//get the englishname for the month
	public String getMonthName(int month){
		String monthName = "";
		
		switch (month){
			case 1 :monthName = "January";break; 
			case 2 :monthName = "February";break; 
			case 3 :monthName = "March";break; 
			case 4 :monthName = "April";break; 
			case 5 :monthName = "May";break; 
			case 6 :monthName = "June";break; 
			case 7 :monthName = "July";break; 
			case 8 :monthName = "August";break; 
			case 9 :monthName = "September";break; 
			case 10 :monthName = "October";break; 
			case 11 :monthName = "November";break; 
			case 12 :monthName = "December";break; 
		}
		return monthName;	
	}

//print month body
	public void printMonthBody(int year, int month){

//get start dayof the week for the first date in the month 		
		int startDay = getStartDay(year, month);

//get number of days in the month
		int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);


//pad space before the first day of the month				
		int i =0;
		for(i=0;i < startDay;i++){
			System.out.print("    ");
		}
		for (i=1;i<=numberOfDaysInMonth;i++){
			System.out.printf("%4d", i);

			if((i + startDay) % 7 ==0)
				System.out.println();
						
		}
		System.out.println();
	}

//get the start day of month/1/year 
	public int getStartDay(int year, int month){

		final int START_DAY_FOR_JAN_1_1800 = 3;

//get total number of days from 1/1/1800 to month/1/year		
		int totalNumberofDays = getTotalNumberOfDays(year, month);

//return thhe start day for month/1/year		
		return (totalNumberofDays + START_DAY_FOR_JAN_1_1800)%7;
	}

//get the total number of days since January 1 , 1800
	public int getTotalNumberOfDays(int year, int month){
		int total = 0;

//get the total days from 1800 to	1/1/Year	
		for(int i =1800;i<year;i++){
			if (isLeapYear(i))
				total = total + 366;
			else
				total = total + 365;
		}

//add days from Jan to the month prior to the calendar month
		for (int i =1;i<month;i++){
			total = total + getNumberOfDaysInMonth(year, i);
		}
		return total;
	}

//get the number of days in a month
	public int getNumberOfDaysInMonth(int year, int month){
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			return 31;
		if(month==4||month==6||month==9||month==11)
			return 30;
		if(month==2) return isLeapYear(year)?29:28;
		return 0;
	}

//determine if it is a leap year
	public boolean isLeapYear(int year){
		return year % 400==0||(year % 4==0&& year % 100 != 0);
	}
}
