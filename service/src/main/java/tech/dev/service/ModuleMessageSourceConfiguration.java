package tech.dev.service;

/**
 * Description de la classe
 * <p>
 * Date: 28/01/2019
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

// try to reading validation messages from common.properties in Service module(not working)
// finnaly using common.properties from Web module(not from Service module)
//@Configuration
public class ModuleMessageSourceConfiguration {

	/*
	private static Logger LOGGER = LoggerFactory.getLogger(ModuleMessageSourceConfiguration.class);

	//@Autowired
	ReloadableResourceBundleMessageSource messageSource;

	//Use @PostConstruct in module's config to add custom common.properties
	//@PostConstruct
	private void init() {
		//By using messageSource.addBasenames we load the common.properties stored in the module's src/main/resources/messages folder.
		messageSource.addBasenames("classpath:messages/common");
		LOGGER.debug("Loading common.properties in Service module !");
	}
   */
}
