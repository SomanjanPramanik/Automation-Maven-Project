package com.creatio.crm.language.basics;

public class StudentConstructorClaude {
//	Fields: name, age, course, feesPaid, feesTotal
//	Constructor to initialize all fields
//	getRemainingFees() → returns feesTotal - feesPaid
//	isPassed(float avgScore) → returns true if avgScore > 40
//	printProfile() → prints all student info
	String name=""; 
	int age =0; 
	String course =""; 
	float feesPaid = 0.f;
	float feesTotal = 50000.0f;
	float avgScore = 0.f;
	StudentConstructorClaude(String givenname, int givenage, String givencourse, float givenfees, float givenavgscore) {
		name = givenname;
		age = givenage;
		course = givencourse;
		feesPaid = givenfees;
		avgScore = givenavgscore;
	}
//	getRemainingFees() → returns feesTotal - feesPaid
	public float getRemainingFees() {
		if (feesPaid == feesTotal) {
			System.out.println("You've Paid Full Amount");
			System.out.print("Fees Remaining:$");
			return 0;
		}
		float feesRemaining = feesTotal - feesPaid;
		System.out.print("Fees Remaining:$");
		return feesRemaining;

	}
//	isPassed(float avgScore) → returns true if avgScore > 40
	public boolean isPassed() {
		System.out.print("Passed:");
		if(avgScore > 40) {
			return true;
		}
		return false;
	}
//	printProfile() → prints all student info
	public void printProfile() {
		System.out.println("[Name:"+name+ "][Age:"+age+ "][Course Name:"+course+"][Amount paid for fees:"+feesPaid+"]");
	}
}