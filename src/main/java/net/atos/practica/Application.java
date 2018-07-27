package net.atos.practica;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan(basePackages = { "net.atos.practica" })
public class Application {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> facesServletRegistration() {
		ServletRegistrationBean<FacesServlet> registration = new ServletRegistrationBean<FacesServlet>(
				new FacesServlet(), new String[] { "*.jsf", "*.xhtml" });
		registration.setName("Faces Servlet");
		registration.setLoadOnStartup(1);
		return registration;
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext)
					throws ServletException {
				servletContext.setInitParameter(
						"com.sun.faces.forceLoadConfiguration",
						Boolean.TRUE.toString());
				servletContext
						.setInitParameter("primefaces.THEME", "cupertino");
				servletContext.setInitParameter(
						"primefaces.CLIENT_SIDE_VALIDATION",
						Boolean.TRUE.toString());
				servletContext.setInitParameter(
						"javax.faces.FACELETS_SKIP_COMMENTS",
						Boolean.TRUE.toString());
				servletContext.setInitParameter("primefaces.FONT_AWESOME",
						Boolean.TRUE.toString());
				servletContext.setInitParameter("primefaces.UPLOADER",
						"commons");
			}
		};
	}
}
