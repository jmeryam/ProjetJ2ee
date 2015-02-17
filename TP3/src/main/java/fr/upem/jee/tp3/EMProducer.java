package fr.upem.jee.tp3;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class EMProducer {

  @Produces
  @PersistenceContext(unitName = "TP3PU")
  private EntityManager em;
}
