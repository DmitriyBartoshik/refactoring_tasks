package com.epam.engx.cleancode.dry.task1;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InterestCalculator {

    private static final int AGE = 60;
    private static final double INTEREST_PERCENT = 4.5d;
    private static final double SENIOR_PERCENT = 5.5d;
    private static final int BONUS_AGE = 13;


    public BigDecimal calculateInterest(AccountDetails accountDetails) {
        if (isAccountStartedAfterBonusAge(accountDetails)) {
            return interest(accountDetails);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private boolean isAccountStartedAfterBonusAge(AccountDetails accountDetails) {
        return countDurationBetweenDatesInYears(accountDetails.getBirth(), accountDetails.getStartDate()) > BONUS_AGE;
    }

    private int countDurationBetweenDatesInYears(Date from, Date to) {
        Calendar startCalendar = createStartCalendar(from);
        Calendar endCalendar = createEndCalendar(to);
        return countDiffYear(startCalendar,endCalendar);
    }

    private BigDecimal interest(AccountDetails accountDetails) {
        double interest = 0;
        if (isAccountStartedAfterBonusAge(accountDetails)) {
            if (AGE <= accountDetails.getAge()) {
                //interest = (PrincipalAmount * DurationInYears * AnnualInterestRate) / 100
                interest = countInterest(accountDetails) * SENIOR_PERCENT / 100;
            } else {
                interest = countInterest(accountDetails) * INTEREST_PERCENT / 100;
            }
        }
        return BigDecimal.valueOf(interest);
    }

    private int countDurationSinceStartDateInYears(Date startDate) {
        Calendar startCalendar = createStartCalendar(startDate);
        Calendar endCalendar = createEndCalendar();
        return countDiffYear(startCalendar, endCalendar);
    }

    public int countDiffYear(Calendar startCalendar, Calendar endCalendar) {
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        if (endCalendar.get(Calendar.DAY_OF_YEAR) < startCalendar.get(Calendar.DAY_OF_YEAR))
            return diffYear - 1;
        return diffYear;
    }

    public Calendar createStartCalendar(Date startDate) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(startDate);
        return startCalendar;
    }

    public Calendar createEndCalendar(Date endDate) {
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);
        return endCalendar;
    }

    public Calendar createEndCalendar() {
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(new Date());
        return endCalendar;
    }
    public double countInterest(AccountDetails accountDetails){
        return accountDetails.getBalance().doubleValue()
                * countDurationSinceStartDateInYears(accountDetails.getStartDate());
    }
}
