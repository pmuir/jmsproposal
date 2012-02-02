package org.jboss.jmsproposal;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


@ApplicationScoped
public class Foo {
   
   @Inject @JMSMessagingContext(lookup = "/pete")
   MessagingContext ctx1;
   
   @Inject @JMSMessagingContext(lookup = "/nigel")
   MessagingContext ctx2;
   
   public MessagingContext getCtx1() {
      return ctx1;
   }
   
   public MessagingContext getCtx2() {
      return ctx2;
   }

}
