package com.inventory.repository.custom.impl;

import com.inventory.query.DashboardQuery;
import com.inventory.repository.custom.DashboardRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static com.inventory.constants.QueryConstants.*;
import static com.inventory.utils.commons.DateUtils.utilDateToSqlDateInString;
import static com.inventory.utils.commons.QueryUtils.createQuery;

@Repository
@Transactional(readOnly = true)
public class DashboardRepositoryCustomImpl implements DashboardRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Double> findDailyRevenue() {
        Query query = createQuery.apply(entityManager, DashboardQuery.QUERY_TO_FIND_DAILY_REVENUE)
                .setParameter(CURRENT_DATE, new Date());

        return query.getSingleResult() == null ? Optional.of(0D) : Optional.of((Double) query.getSingleResult());
    }

    @Override
    public Optional<Double> findWeeklyRevenue() {

        //sets the calendar to current date and time
        Calendar date = Calendar.getInstance();
        //sets the calendar with starting day of week
        date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date fromDate = date.getTime();

        //printing of first and last day of th week
        DateFormat dateformat = new SimpleDateFormat("EEE dd/MM/yyyy");
        System.out.println(dateformat.format(date.getTime()));
        for (int i = 0; i < 6; i++) {
            date.add(Calendar.DATE, 1);
        }

        Date toDate = date.getTime();
        System.out.println(dateformat.format(date.getTime()));

        Query query = createQuery.apply(entityManager, DashboardQuery.QUERY_TO_FIND_WEEKLY_REVENUE)
                .setParameter(FROM_DATE, utilDateToSqlDateInString(fromDate))
                .setParameter(TO_DATE, utilDateToSqlDateInString(toDate));

        return query.getSingleResult() == null ? Optional.of(0D) : Optional.of((Double) query.getSingleResult());
    }

    @Override
    public Optional<Double> findMonthlyRevenue() {


        Calendar c = Calendar.getInstance();   // this takes current date
        c.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println(c.getTime());
        Date fromDate = c.getTime();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,
                cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date toDate = cal.getTime();


        Query query = createQuery.apply(entityManager, DashboardQuery.QUERY_TO_FIND_WEEKLY_REVENUE)
                .setParameter(FROM_DATE, utilDateToSqlDateInString(fromDate))
                .setParameter(TO_DATE, utilDateToSqlDateInString(toDate));

        return query.getSingleResult() == null ? Optional.of(0D) : Optional.of((Double) query.getSingleResult());
    }

    @Override
    public Optional<Double> findYearlyRevenue() {

        Calendar c = Calendar.getInstance();   // this takes current date
        c.set(Calendar.DAY_OF_YEAR, 1);
        System.out.println(c.getTime());
        Date fromDate = c.getTime();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_YEAR,
                cal.getActualMaximum(Calendar.DAY_OF_YEAR));
        Date toDate = cal.getTime();

        Query query = createQuery.apply(entityManager, DashboardQuery.QUERY_TO_FIND_WEEKLY_REVENUE)
                .setParameter(FROM_DATE, utilDateToSqlDateInString(fromDate))
                .setParameter(TO_DATE, utilDateToSqlDateInString(toDate));

        return query.getSingleResult() == null ? Optional.of(0D) : Optional.of((Double) query.getSingleResult());
    }
}
