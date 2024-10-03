package co.reldyn.baas.idv.onfido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RdBaasIdvOnfidoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RdBaasIdvOnfidoServiceApplication.class, args);
    }
}
