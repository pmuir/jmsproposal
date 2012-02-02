package org.jboss.jmsproposal;

import static junit.framework.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class JmsProposalTest {
   @Deployment
   public static Archive<?> createTestArchive() {
      return ShrinkWrap.create(WebArchive.class, "test.war")
            .addPackage(JmsProposalTest.class.getPackage())
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
   }
   
   @Inject Foo foo;

   @Test
   public void testRequest1() throws Exception {
      assertEquals("Lookup: /pete", foo.getCtx1().getInfo());
      assertEquals("Lookup: /nigel", foo.getCtx2().getInfo());
      System.out.println("Ctx1 is  " + foo.getCtx1());
      System.out.println("Ctx2 is  " + foo.getCtx2());  
   }
   
   @Test
   public void testRequest2() throws Exception {
      assertEquals("Lookup: /pete", foo.getCtx1().getInfo());
      assertEquals("Lookup: /nigel", foo.getCtx2().getInfo());
      System.out.println("Ctx1 is  " + foo.getCtx1());
      System.out.println("Ctx2 is  " + foo.getCtx2());  
   }
   
   
}