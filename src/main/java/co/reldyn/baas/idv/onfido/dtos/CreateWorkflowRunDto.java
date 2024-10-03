package co.reldyn.baas.idv.onfido.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CreateWorkflowRunDto {

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Request {
        @JsonProperty("applicant_id")
        private String applicantId;

        @JsonProperty("workflow_id")
        private String workflowId;

        @JsonProperty("tags")
        private List<String> tags;

        @JsonProperty("customer_user_id")
        private String customerUserId;

        @JsonProperty("link")
        private Link link;

        @JsonProperty("created_at")
        private LocalDateTime createdAt;

        @JsonProperty("updated_at")
        private LocalDateTime updatedAt;

        @JsonProperty("custom_data")
        private Map<String, Object> customData;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Link {
            @JsonProperty("url")
            private String url;

            @JsonProperty("completed_redirect_url")
            private String completedRedirectUrl;

            @JsonProperty("expired_redirect_url")
            private String expiredRedirectUrl;

            @JsonProperty("expires_at")
            private String expiresAt;

            @JsonProperty("language")
            private String language;
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        @JsonProperty("applicant_id")
        private String applicantId;

        @JsonProperty("id")
        private String id;

        @JsonProperty("workflow_id")
        private String workflowId;

        @JsonProperty("tags")
        private List<String> tags;

        @JsonProperty("customer_user_id")
        private String customerUserId;

        @JsonProperty("link")
        private Link link;

        @JsonProperty("created_at")
        private LocalDateTime createdAt;

        @JsonProperty("updated_at")
        private LocalDateTime updatedAt;

        @JsonProperty("workflow_version_id")
        private Integer workflowVersionId;

        @JsonProperty("dashboard_url")
        private String dashboardUrl;

        @JsonProperty("status")
        private String status;

        @JsonProperty("output")
        private Map<String, Object> output;

        @JsonProperty("reasons")
        private List<String> reasons;

        @JsonProperty("error")
        private Error error;

        @JsonProperty("sdk_token")
        private String sdkToken;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Error {
            @JsonProperty("type")
            private String type;

            @JsonProperty("message")
            private String message;
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Link {
            @JsonProperty("url")
            private String url;

            @JsonProperty("completed_redirect_url")
            private String completedRedirectUrl;

            @JsonProperty("expired_redirect_url")
            private String expiredRedirectUrl;

            @JsonProperty("expires_at")
            private String expiresAt;

            @JsonProperty("language")
            private String language;
        }
    }
}
