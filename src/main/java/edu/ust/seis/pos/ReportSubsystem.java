package edu.ust.seis.pos;

import java.util.List;

public abstract class ReportSubsystem {

	public abstract List<List<String>> generateReport();

	private String stringFormatUnit = "%n%-15s %s ";

	public void printReport(List<List<String>> reportList) {
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < reportList.size(); x++) {

			if (x == (reportList.size() - 1)) {
				sb.append(reportList.get(x));
			}
			sb.append(reportList.get(x) + ",");
			System.out.println(String.format(
					getStringFormat(reportList.size()), sb.toString()));
		}
		// return String.format(getStringFormat(reportList.size()),
		// sb.toString());

	}

	private String getStringFormat(int numberOfCells) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfCells; i++) {
			// sb.append(new StringBuilder(acct.get(i).toString()));
			sb.append(stringFormatUnit);
		}

		return sb.toString();
	}

}
