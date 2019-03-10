/*
package mx.com.example.test.config.security;

import mx.com.example.test.wsdl.ConsultaSaldoCuenta;
import mx.com.example.test.wsdl.ConsultaSaldoCuentaResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public ConsultaSaldoCuenta weatherClient(Jaxb2Marshaller marshaller) {
        ConsultaSaldoCuenta consultaSaldoCuenta = new ConsultaSaldoCuenta();
        consultaSaldoCuenta.setDefaultUri("http://localhost:8080/ws/beer");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }


    public class ConsultaSaldoCuentaResponse extends WebServiceGatewaySupport {

        public GetBeerResponse getBeer(int id) {
            GetBeerRequest request = new GetBeerRequest();
            request.setId(id);
            return (GetBeerResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        }
    }
}
*/