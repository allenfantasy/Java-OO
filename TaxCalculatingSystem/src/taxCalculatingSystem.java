
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
    	String statusStr = JOptionPane.showInputDialog(null, "请选择操作:\n 1. 录入一条收入;\n 2. 显示所有收入;\n 3. 退出;");
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
    	case 3: JOptionPane.showMessageDialog(null, "您已成功退出!!!"); System.exit(0);
    	default: JOptionPane.showMessageDialog(null, "请输入 1, 2 或 3"); break;
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
			output = output + "日期: " 			+ DateFormat.getDateInstance(DateFormat.FULL).format(income.date) + "; "
							+ "收入: " 			+ income.initialIncome 					+ "; " 
							+ "应交税款: "        + income.tax 							+ "; "
							+ "实际收入: "        + (income.initialIncome - income.tax) 	+ "; ";
			output = output + "\n";
		}
		JOptionPane.showMessageDialog(null, output);
	}
	private static double inputIncome() {
		double income = -1;	  
		String incomeStr;
		while (income <= 0){
			incomeStr= JOptionPane.showInputDialog(null,"请输入您的收入金额 (需大于0):");
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