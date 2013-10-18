
import java.util.Date;
import java.text.DateFormat;

import javax.swing.JOptionPane;

public class taxCalculatingSystem {
  public static void main(String[] args) {
	
    int status;
    IncomeProcessor p = new IncomeProcessor();
    //Income incomes; // Array?
    
 // prompt input box again unless the input is 3
    while (true) {
    	String statusStr = JOptionPane.showInputDialog(null, "��ѡ�����:\n 1. ¼��һ������;\n 2. ��ʾ��������;\n 3. �˳�;");
    	try {
    		status = Integer.parseInt(statusStr);
    	}
    	catch (NumberFormatException e){
    		status = 4;
    	}
    	// prompt input box, let user choose functions:
    	// 1. record an income
    	// 2. print all incomes
    	// 3. exit
    	switch (status) {
    	case 1: 
    		/* JOptionPane.showMessageDialog(null, "Record An Income!", "Display Status", JOptionPane.INFORMATION_MESSAGE); */
    		p.addIncome();
    		break;
    	case 2: 
    		/* JOptionPane.showMessageDialog(null, "Print All Incomes!", "Display Status", JOptionPane.INFORMATION_MESSAGE); */
    		p.printAllIncomes();
    		break;
    	case 3: JOptionPane.showMessageDialog(null, "���ѳɹ��˳�!!!"); System.exit(0);
    	default: JOptionPane.showMessageDialog(null, "������ 1, 2 �� 3"); break;
    	}
    }
  }
}

class Income {
	double initialIncome;
    double tax;
	Date date;
	
	/** Constructor **/
	Income(double income) {
		initialIncome = income;
		date = new Date();
		double taxableIncome = initialIncome - 3500;
		
		if (taxableIncome <= 0) 			{ tax = 0; }
		else if (taxableIncome <= 1500) 	{ tax = taxableIncome * 0.03; }
		else if (taxableIncome <= 4500) 	{ tax = taxableIncome * 0.1 - 105; }
		else if (taxableIncome <= 9000) 	{ tax = taxableIncome * 0.2 - 555; }
		else if (taxableIncome <= 35000) 	{ tax = taxableIncome * 0.25 - 1005; }
		else if (taxableIncome <= 55000)	{ tax = taxableIncome * 0.3 - 2755; }
		else if (taxableIncome <= 80000)    { tax = taxableIncome * 0.35 - 5505; }
		else 								{ tax = taxableIncome * 0.45 - 13505; }
	}
}

class IncomeProcessor {

	int count; // store the count of incomes
	Income[] incomes;
	
	IncomeProcessor() {
		count = 0;
		incomes = new Income[100];
	}
	public void addIncome() {
		double income_num = inputIncome();
		Income income = new Income(income_num);
		incomes[count++] = income; // ADD!!
	}
	public void printAllIncomes() {
		String output = "";
		for(int i = 0; i < count; i++) {
			Income income = incomes[i];
			output = output + "����: " 			+ DateFormat.getDateInstance(DateFormat.FULL).format(income.date) + "; "
							+ "����: " 			+ income.initialIncome 					+ "; " 
							+ "Ӧ��˰��: "        + income.tax 							+ "; "
							+ "ʵ������: "        + (income.initialIncome - income.tax) 	+ "; ";
			output = output + "\n";
		}
		JOptionPane.showMessageDialog(null, output);
	}
	private static double inputIncome() {
		double income = -1;	  
		String incomeStr;
		while (income <= 0){
			incomeStr= JOptionPane.showInputDialog(null,"���������������� (�����0):");
			try {
				income = Double.parseDouble(incomeStr);
			}
			catch (NumberFormatException e){
				income = -1;
			}
		}
		return income;
	}
}