package co.reldyn.baas.idv.onfido.common;

import java.util.HashMap;
import java.util.Map;

public final class ResponseEnum {

    public enum ResponseCode {
        INTERNAL_SERVER_ERROR(1000, "Service is unavailable. Check back later."),
        APPLICANT_CREATION_ERROR(1001, "Error occured while creating applicant"),
        WORKFLOW_CREATION_ERROR(1002, "Error occured while creating workflow for applicant"),
        RETRIEVE_WORKFLOW_ERROR(1003, "Error occured while retrieving workflow for applicant"),
        RETRIEVE_WORKFLOW_LIST_ERROR(
                1004, "Error occured while retrieving workflow list for applicant");

        private final Integer code;
        private final String message;

        private static final Map<Integer, ResponseCode> lookup = new HashMap<>();

        ResponseCode(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        static {
            for (ResponseCode responseCode : ResponseCode.values()) {
                lookup.put(responseCode.getCode(), responseCode);
            }
        }

        public static ResponseCode get(Integer code) {
            return lookup.get(code);
        }
    }
}
