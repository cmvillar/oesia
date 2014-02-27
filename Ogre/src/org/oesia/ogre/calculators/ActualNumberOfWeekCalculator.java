package org.oesia.ogre.calculators;

import java.util.*;

import org.openxava.calculators.*;

public class ActualNumberOfWeekCalculator implements ICalculator{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int weekNumber;

	public Object calculate() throws Exception {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DATE, 0); //new Date(System.currentTimeMillis())
		weekNumber = calendar.get(Calendar.WEEK_OF_YEAR);
		return weekNumber;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}
	
	
}
