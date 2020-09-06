package com.inventory.query;

public class DashboardQuery {


    public static final String QUERY_TO_FIND_DAILY_REVENUE =
            " SELECT" +
                    " SUM(s.totalAmount) as dailyRevenue" +
                    " FROM Sale s " +
                    " WHERE s.saleDate=:currentDate";


    public static final String QUERY_TO_FIND_WEEKLY_REVENUE =
            " SELECT" +
                    " SUM(s.totalAmount) as dailyRevenue" +
                    " FROM Sale s " +
                    " WHERE " +
                    " (DATE_FORMAT(s.saleDate,'%Y-%m-%d') BETWEEN :fromDate AND :toDate)";

    public static final String QUERY_TO_FIND_YEARLY_REVENUE =
            " SELECT" +
                    " SUM(s.totalAmount) as yearlyRevenue" +
                    " FROM Sale s " +
                    " WHERE " +
                    " (DATE_FORMAT(s.saleDate,'%Y-%m-%d') BETWEEN :fromDate AND :toDate)";
}

