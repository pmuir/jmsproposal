package org.jboss.jmsproposal;

import java.io.Serializable;

/**
 * Read the metadata from the annotation to a metadata object, to provide serializability
 * 
 * @author pmuir
 *
 */
public class MessagingContextMetadata implements Serializable {
   
   /**
    * Some metadata about messaging context, provided as an example only
    */
   private final String lookup;
   
   public MessagingContextMetadata(JMSMessagingContext ctx) {
      this.lookup = ctx.lookup();
   }
   
   public String getLookup() {
      return lookup;
   }
   
   @Override
   public String toString() {
      return "Lookup: " + lookup;
   }
   
}
