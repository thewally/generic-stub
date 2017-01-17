package nl.thewally.stub.manipulate;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/manipulate/*");
    }

    @Bean(name = "stubSetResponse")
    public DefaultWsdl11Definition stubSetResponseWsdl11Definition(XsdSchema stubSetResponseSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ManipulatePort");
        wsdl11Definition.setLocationUri("/manipulate");
        wsdl11Definition.setTargetNamespace("http://thewally.nl/stub/manipulate/service/setresponse");
        wsdl11Definition.setSchema(stubSetResponseSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema stubSetResponseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("stubSetResponse.xsd"));
    }

    @Bean(name = "stubCleanupResponseQue")
    public DefaultWsdl11Definition stubCleanupResponseQueWsdl11Definition(XsdSchema stubCleanupResponseQueSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ManipulatePort");
        wsdl11Definition.setLocationUri("/manipulate");
        wsdl11Definition.setTargetNamespace("http://thewally.nl/stub/manipulate/service/cleanupresponseque");
        wsdl11Definition.setSchema(stubCleanupResponseQueSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema stubCleanupResponseQueSchema() {
        return new SimpleXsdSchema(new ClassPathResource("stubCleanupResponseQue.xsd"));
    }
}
