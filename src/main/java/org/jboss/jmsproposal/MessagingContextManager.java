package org.jboss.jmsproposal;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;

@RequestScoped // Note request scope is single threaded
public class MessagingContextManager {
   
   private final Map<Long, MessagingContext> contexts;
   
   public MessagingContextManager() {
      contexts = new HashMap<Long, MessagingContext>();
   }
   
   public MessagingContext getMessagingContext(long id, MessagingContextMetadata metadata) {
      MessagingContext ctx = contexts.get(id);
      if (ctx == null) {
         ctx = MessagingContextFactory.newMessagingContext(metadata);
         contexts.put(id, ctx);
      }
      return ctx;
   }
   
   @PreDestroy
   public void cleanup() {
      for (Entry<Long, MessagingContext> e : contexts.entrySet()) {
         e.getValue().cleanup();
      }
   }

}
