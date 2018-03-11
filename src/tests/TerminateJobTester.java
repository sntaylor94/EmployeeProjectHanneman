package tests;

import java.time.LocalDate;

import controller.JobHelper;

public class TerminateJobTester {
	public static void main(String[] args) {
		JobHelper jHelp = new JobHelper();
		
		//ID can be reused, just updates the termination date
		jHelp.terminateJob(3, LocalDate.of(2018, 1, 17));
	}
}
