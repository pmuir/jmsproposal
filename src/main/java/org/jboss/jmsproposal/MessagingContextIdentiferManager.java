package org.jboss.jmsproposal;

import java.util.concurrent.atomic.AtomicLong;

import javax.enterprise.context.ApplicationScoped;

/**
 * Thread safe application wide sequence generator that creates a unique id. Used to give an identity to every injected MessagingContext
 * @author pmuir
 *
 */
@ApplicationScoped
public class MessagingContextIdentiferManager {

   private final AtomicLong idSequence;
   
   public MessagingContextIdentiferManager() {
      idSequence = new AtomicLong();
   }
   
   public long next() {
      return idSequence.incrementAndGet();
   }
   
}
