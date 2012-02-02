package org.jboss.jmsproposal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Mock up of the @JMSMessagingContext annotation
 * @author pmuir
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface JMSMessagingContext {

   String lookup();
   
}
