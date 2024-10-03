package co.reldyn.baas.idv.onfido.interceptors;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OnfidoRequestInterceptor implements RequestInterceptor {

    @Value("${onfido.api.token}")
    private String authorization;

    @Value("${onfido.content.type}")
    private String contentType;

    @Override
    public void apply(RequestTemplate template) {
        // Adding required headers
        template.header("Authorization", authorization);
        template.header("Content-Type", contentType);
        logRequest(template);
    }

    private void logRequest(RequestTemplate template) {
        log.debug(
                "===========================  feign request begin  ======================================");
        log.debug("URI         : {}", template.url());
        log.debug("Method      : {}", template.method());
        log.debug("Headers     : {}", template.headers().toString());
        if (template.body() != null) {
            log.debug("Request body: {}", new String(template.body()));
        }
        log.debug(
                "==========================   feign request end  ========================================");
    }
}
