package com.saran.DesignPatterns;

import java.io.IOException;
import java.util.Scanner;

//as much as Provider like comcast, verizon, (widening your families)
//one vending machine has drinks,chips,water,cookies,candys (coke pepsi ) facotry pattern
//multiple vending machine has each vending machine has drinks, cookies, water candys//


//abstract factory isolates the clients from concrete impl. classes
// from which bank you are getting the Loan and what type of loan are you getting


interface Bank {
	String getBankName();
}

class BOA implements Bank {
	private final String bname;

	BOA() {
		bname = "BOA ";
	}

	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return bname;
	}

}

class WellsFargo implements Bank {
	private final String bname;

	WellsFargo() {
		bname = "Wells Fargo ";
	}

	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return bname;
	}

}

class PNC implements Bank {
	private final String bname;

	PNC() {
		bname = "PNC ";
	}

	@Override
	public String getBankName() {
		// TODO Auto-generated method stub
		return bname;
	}

}

abstract class Loan {
	protected double rate;

	abstract void getInterestRate(double rate);

	public void calculateLoanPayment(double loanamt, int years) {
		double mortage;
		int n;
		n = years * 12;
		rate = rate / 1200;
		mortage = ((rate * Math.pow((1 + rate), n)) / ((Math.pow((1 + rate), n)) - 1)) * loanamt;
		System.out.println("your mortage is " + mortage + "for the amount" + loanamt);

	}
}

class HomeLoan extends Loan {
	public void getInterestRate(double r) {
		rate = r;
	}
}// End of the HomeLoan class.

class BussinessLoan extends Loan {
	public void getInterestRate(double r) {
		rate = r;
	}

}// End of the BusssinessLoan class.

class PersonalLoan extends Loan {
	public void getInterestRate(double r) {
		rate = r;
	}
}// End of the EducationLoan class.

public abstract class AbstractFactory {

	public abstract Bank getBank(String bank);

	public abstract Loan getLoan(String loan);

}

class BankFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bank) {
		if (bank == null) {
			return null;
		} else if (bank.equals("BOA")) {
			return new BOA();
		} else if (bank.equals("WellsFargo")) {
			return new WellsFargo();
		}

		else if (bank.equals("PNC")) {
			return new PNC();
		}
		return null;
	}

	@Override
	public Loan getLoan(String loan) {

		return null;
	}

}

class LoanFactory extends AbstractFactory {

	@Override
	public Bank getBank(String bank) {

		return null;
	}

	@Override
	public Loan getLoan(String loan) {

		{
			if (loan == null) {
				return null;
			} else if (loan.equals("Home")) {
				return new HomeLoan();
			} else if (loan.equals("Business")) {
				return new BussinessLoan();
			}

			else if (loan.equals("Personal")) {
				return new PersonalLoan();
			}
			return null;
		}

	}

}

class FactoryCreator {
	public static AbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("Bank")) {
			return new BankFactory();
		} else if (choice.equalsIgnoreCase("Loan")) {
			return new LoanFactory();
		}
		return null;
	}
}

class AbstractFactoryPatternExample {
	public static void main(String args[]) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of Bank from where you want to take loan amount: ");
		String bankName = sc.next();

		System.out.print("\n");
		System.out.print("Enter the type of loan e.g. home loan or business loan or personal loan : ");

		String loanName = sc.next();
		AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");
		Bank b = bankFactory.getBank(bankName);

		System.out.print("\n");
		System.out.print("Enter the interest rate for " + b.getBankName() + ": ");

		double rate = Double.parseDouble(sc.next());
		System.out.print("\n");
		System.out.print("Enter the loan amount you want to take: ");

		double loanAmount = Double.parseDouble(sc.next());
		System.out.print("\n");
		System.out.print("Enter the number of years to pay your entire loan amount: ");
		int years = Integer.parseInt(sc.next());

		System.out.print("\n");
		System.out.println("you are taking the loan from " + b.getBankName());

		AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");
		Loan l = loanFactory.getLoan(loanName);
		l.getInterestRate(rate);
		l.calculateLoanPayment(loanAmount, years);
	}
}