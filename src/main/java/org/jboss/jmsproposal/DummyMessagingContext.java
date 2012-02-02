package org.jboss.jmsproposal;

import java.util.logging.Logger;

/**
 * Mock up of a messaging context impl that simply logs so we can see what is going on.
 * 
 * @author pmuir
 *
 */
public class DummyMessagingContext implements MessagingContext {

   private static final Logger log = Logger.getLogger(DummyMessagingContext.class.getName());
   
   private final MessagingContextMetadata metadata;
   
   public DummyMessagingContext(MessagingContextMetadata metadata) {
      this.metadata = metadata;
   }
   
   @Override
   public void cleanup() {
      log.info("Cleanup called for DummyMessagingContext " + this + ". " + metadata);
   }
   
   @Override
   public String getInfo() {
      return metadata.toString();
   }

}
