package org.jboss.jmsproposal;

/**
 * Classic Forwarding class for MessagingContext, nothing exciting here!
 * @author pmuir
 *
 */
public abstract class ForwardingMessagingContext implements MessagingContext {

   protected abstract MessagingContext delegate();
   
   @Override
   public String getInfo() {
      return delegate().getInfo();
   }
   
   @Override
   public void cleanup() {
      delegate().cleanup();
   }
   
}
