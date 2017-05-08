package com.yarncostingindia.Utils;

public class AndyConstants {
    public static final String URL = "url";
    public static int currentTime;
    public static int expireTime;

    public class ServiceCode {
        public static final int REGISTER = 1;
        public static final int LOGIN = 2;
        public static final int CHECKVERSION = 3;
        public static final int CHECKIMEI = 4;
        public static final int INSTAMOJOCREATE = 5;

    }

    // web service url constants
    public class ServiceType {

        public static final String BASE_URL = "http://madeovercode.com/yarncalc/service/";
        public static final String LOGIN = BASE_URL + "login.php";
        public static final String REGISTERATION = BASE_URL + "register.php";
        public static final String CHECKVERSION = BASE_URL + "checkversion.php";
        public static final String CHECKIMEI = BASE_URL + "checkIMEI.php";
        public static final String INSTAMOJOCREATE = "http://madeovercode.com/calc_common/instamojo_create_request.php";
        public static final String SUCCESS_URL = "http://www.madeovercode.com/calc_common/instamojo_redirect_success.html";
    }
    // webservice key constants
    public class Params {

        public static final String EMAIL = "email";
        public static final String IMEI = "imei";
        public static final String NAME = "name";
        public static final String MOBILE = "mobile";
        public static final String NOTIFICATION_TOKEN = "notification_token";
        public static final String DAYS_LEFT = "days_left";
        public static final String LAST_ACCESS = "last_access";
        public static final String INSTALL_DATE = "install_date";
        public static final String CITY = "city";
        public static final String ID = "id";
        public static final String VERSION = "version";
        public static final String VERSIONDB = "versionDB";
        public static final String ISCOMPLUSORY = "isCompulsory";
        public static final String ISACTIVE = "isActive";
        public static final String PAYMENTREQUESTURL = "longurl";
        public static final String INSTAMOJOPAYMENTID = "instamojo_payment_id";
    }
}
