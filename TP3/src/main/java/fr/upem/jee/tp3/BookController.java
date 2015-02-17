package fr.upem.jee.tp3;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.EntityTransaction;


@Named
@RequestScoped
public class BookController {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;
  
  private Book book = new Book();
  

  // ======================================
  // =          Business methods          =
  // ======================================


  public List<Book> findAllBooks() {
    return em.createNamedQuery("findAllBooks",       Book.class).getResultList();
  }

  public String doCreateBook() {
    EntityTransaction tx = em.getTransaction();  
    tx.begin();
    em.persist(book);
    tx.commit();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Book created",
            "The book" + book.getTitle() + " has been created with id=" + book.getId()));
    return "newNewBook.xhtml";
  }

  public void doFindBookById() {
    book = em.find(Book.class, book.getId());
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }
}