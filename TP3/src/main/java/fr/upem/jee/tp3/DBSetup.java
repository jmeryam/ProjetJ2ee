package fr.upem.jee.tp3;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Singleton
@Startup
@DataSourceDefinition(name = "java:global/jdbc/TP3DS",
        className = "org.apache.derby.jdbc.EmbeddedDriver",
        url = "jdbc:derby:memory:TP3;create=true;user=app;password=app"
)
public class DBSetup {

  @Inject
  private EntityManager em;

  @PostConstruct
  private void createData() {
    em.persist(new Book("The Hitchhiker's Guide to the Galaxy", 23.99f, "Science fiction comedy book", 354, Boolean.TRUE));
    em.persist(new Book("Harry Potter and the Goblet of Fire", 19.79f, "Science fiction (Book 4)", 734, Boolean.TRUE));
    em.persist(new Book("La Carte et le Territoire", 24.99f, "Prix Goncourt 2010", 428, Boolean.FALSE));
    em.persist(new Book("Il Nome della Rosa", 34.99f, "Science fiction comedy book", 354, Boolean.FALSE));
  }

}
