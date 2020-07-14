package com.inventory.constants;

public class ErrorMessageConstants {

    //A

    //B

    //C
    public final static String CANNOT_CREATE_SIGNATURE = "Cannot create signature: ";
    public static final String CODE_DUPLICATION_MESSAGE = "%s already exists with code '%s'";

    //D

    //E

    //F


    //G
    public static final String INVALID_GENDER_CODE_MESSAGE = "Invalid Gender code.";
    public static final String INVALID_GENDER_CODE_DEBUG_MESSAGE = "Gender enum doesn't have the requested code.";

    //H
    public final static String HMAC_BAD_SIGNATURE = "HmacAccessFilter.badSignature";

    //I
    public static final String INVALID_DATE_MESSAGE = "From date cannot be greater than to date";
    public static final String INVALID_DATE_DEBUG_MESSAGE = "Failed to complete operation due to invalid from and to date";
    public static final String INVALID_VERIFICATION_TOKEN = "Invalid verification token";

    //J

    //K

    //L

    //M

    //N

    public static final String NO_RECORD_FOUND="NO RECORD FOUND";
    public static final String NAME_DUPLICATION_MESSAGE = "%s already exists with name '%s'";
    public static final String PAN_DUPLICATION_MESSAGE = "%s already exists with pan number '%s'";
    public static final String NAME_AND_MOBILE_NUMBER_DUPLICATION_MESSAGE = "%s already exists with name '%s' " +
            "and mobile number '%s'";

    public static final String NAME_AND_CODE_DUPLICATION_MESSAGE = "%s already exists with name '%s' " +
            "and code '%s' ";


    //O

    //P
    public interface ProductServiceMessages {
        String DUPLICATE_PATIENT_MESSAGE = "Patient already exists with name '%s', mobile number '%s' and date of birth " +
                "'%s'";
    }

    public interface ProfileServiceMessages {
        String INVALID_DELETE_REQUEST = "Sorry! Cannot delete Super Admin Profile";
    }


    //Q

    //R


    //S


    //T


    //U
    public static final String INVALID_PASSWORD = "Invalid Password.";

    //V

    //W

    //X

    //Y

    //Z
}
