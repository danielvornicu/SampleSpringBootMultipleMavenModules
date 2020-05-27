package tech.dev.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Description de la classe
 * <p>
 * Date: 28/01/2019
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

//I'm not using using application.properties mechanism(don't work)
// I must add classpath: classpath:messages/common
@Configuration
public class MessageSourceConfiguration  {

	//manual pring boot bean configuration vs spring boot auto-configuration via application.properties

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
	    //v1
		//ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		//messageSource.setBasename("messages/common");
        //v2
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages/common");

		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	//for activate the Bean Validation with Spring Boot this is the only way becasuse no auto-configuration echivalent
	//in application.properties
    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

}
