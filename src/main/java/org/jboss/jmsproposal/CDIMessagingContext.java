package org.jboss.jmsproposal;

import java.io.Serializable;

import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 * The "magic" happens here.
 * 
 * This is a dependent scoped object, so can access the injection point.
 * 
 * Each dependent instance is assigned an id that is unique across the app, so that we end up with a unique instance for each injection point
 * 
 * This class delegates all calls to an instance obtained from the messaging context manager. The manager is request scoped, so can perform cleanup as needed
 * 
 * @author pmuir
 *
 */
public class CDIMessagingContext extends ForwardingMessagingContext implements Serializable {

   // inherently serializable
   private final long id;
  
   // CDI proxy so serializable
   private final MessagingContextManager manager;
   
   // We need to ensure this is serialiable
   private final MessagingContextMetadata metadata;
   
   
   @Inject
   public CDIMessagingContext(InjectionPoint ip, MessagingContextIdentiferManager idSequence, MessagingContextManager manager) {
      JMSMessagingContext ctx = ip.getAnnotated().getAnnotation(JMSMessagingContext.class);
      if (ctx == null) 
         throw new IllegalStateException("@JMSMessagingContext not present on " + ip); // TODO move this check to deployment for fail fast
      this.id = idSequence.next();
      this.manager = manager;
      this.metadata = new MessagingContextMetadata(ctx);
   }

   @Override
   protected MessagingContext delegate() {
      return manager.getMessagingContext(id, metadata);
   }
   
   @Override
   public String toString() {
      return "Wrapper around " + delegate().toString() + "; Id: " + id;
   }

}
