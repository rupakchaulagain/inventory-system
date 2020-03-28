package com.inventory.constants;

/**
 * @author smriti on 7/5/19
 */
public class WebResourceKeyConstants {

    //A
    public static final String API_V1 = "/api/v1";
    public static final String ACTIVE = "/active";


    //B
    public static final String BASE_PASSWORD = "/password";

    //C



    //D
    public interface DashboardConstants {
        String BASE_DASHBOARD = "/dashboard";
        String GENERATE_REVENUE = "/revenueGenerated";
        String OVER_ALL_APPOINTMENT = "/overAllAppointments";
        String REVENUE_STATISTICS = "/revenueStatistics";
        String REGISTERED = "/registeredPatients";
        String COUNT = "/count";
        String HOSPITAL_ID_PATH_VARIABLE_BASE = "/{hospitalId}";
        String APPOINTMENT_QUEUE = "/today-appointment";
        String APPOINTMENT_QUEUE_BY_TIME = "/today-appointment-timely";
        String REVENUE_TREND = "/revenueTrend";
    }

    public static final String DETAIL = "/detail";

    public interface DepartmentConstants {
        String BASE_DEPARTMENT = "/department";
        String DEPARTMENT_ID_PATH_VARIABLE_BASE = "/{departmentId}";
    }

    public interface DoctorConstants {
        String BASE_DOCTOR = "/doctor";
        String UPDATE_DETAILS = "/updateDetails";
        String DOCTOR_WISE = "/doctor-wise";
        String DOCTOR_ID_PATH_VARIABLE_BASE = "/{doctorId}";
    }

    public interface DoctorDutyRosterConstants {
        String BASE_DOCTOR_DUTY_ROSTER = "/doctorDutyRoster";
        String DOCTOR_DUTY_ROSTER_OVERRIDE = "/doctorDutyRosterOverride";
        String EXISTING = "/existing";
        String REVERT_DOCTOR_DUTY_ROSTER_OVERRIDE = "/revert";
    }

    //F

    public interface ForgotPasswordConstants {
        String VERIFY = "/verify";
        String FORGOT = "/forgot";
    }


    //G

    //H
    public interface HospitalConstants {
        String BASE_HOSPITAL = "/hospital";
        String HOSPITAL_WISE = "/hospital-wise";
        String HOSPITAL_ID_PATH_VARIABLE_BASE = "/{hospitalId}";
    }

    //I
    public static final String ID_PATH_VARIABLE_BASE = "/{id}";


    //J

    //K

    //L
    public static final String LOGIN = "/login";

    //M
    public static final String META_INFO = "/metaInfo";
    public static final String MIN = "/min";

    public interface MinioFileConstants {
        String BASE_FILE = "/file";
        String FETCH_FILE = "/{subDirectory}/{object}";

    }

    //N


    //O

    //P
    public interface ProductConstant {
        String BASE_PRODUCT = "/product";
    }



    //Q


    //R


    //S

    //T

    //U


    //V

    //W



    //X

    //Y

    //Z
}
