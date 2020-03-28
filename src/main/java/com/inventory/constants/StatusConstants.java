package com.inventory.constants;

public class StatusConstants {

    public static final Character ACTIVE = 'Y';
    public static final Character INACTIVE = 'N';
    public static final Character DELETED = 'D';

    public static final Character YES = 'Y';
    public static final Character NO = 'N';

    public interface AppointmentStatusConstants {
        String PENDING_APPROVAL = "PA";
        String APPROVED = "A";
        String CANCELLED = "C";
        String REJECTED = "R";
        String REFUNDED = "RE";
        String VACANT = "V";
        String ALL = "";
    }
}
