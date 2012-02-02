package org.jboss.jmsproposal;

/**
 * Factory to create messaging contexts. In a real impl this would be replaced by however MessagingContexts are produced, e.g. JNDI
 *
 */
public class MessagingContextFactory {

   public static MessagingContext newMessagingContext(MessagingContextMetadata metadata) {
      return new DummyMessagingContext(metadata);
   }
   
}
