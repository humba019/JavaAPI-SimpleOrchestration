package br.com.ibm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;


@Component
public class RestConfig extends RouteBuilder{

	@Autowired
	private Environment env;

	@Value("${camel.component.servlet.mapping.context-path}")
	private String contextPath;

	@Override
	public void configure() throws Exception {

		  restConfiguration()
			.component("servlet")
			.bindingMode(RestBindingMode.json)
			.dataFormatProperty("prettyPrint", "true")
			.enableCORS(true)
			.port(env.getProperty("server.port", "8080"))
			.contextPath(contextPath.substring(0, contextPath.length() - 2))
			.apiContextPath("/api-doc")
			.apiProperty("api.title", "User API")
			.apiProperty("api.version", "1.0.0");

	}
}
