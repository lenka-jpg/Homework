package pl.coderslab.dao;

import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class DraftDao {

    @PersistenceContext
    EntityManager em;

    public void save(Author author) {
        if (author.getId() == null) {
            em.persist(author);
        } else {
            em.merge(author);
        }
    }

    public void delete(Author author) {
        em.remove(em.contains(author) ? author : em.merge(author));
    }

//    public void delete(Long id ){
//        Category category= findById(id);
//        delete(category);
//    }

    public Author findById(Long id) {
        return em.find(Author.class, id);
    }

    public List<Author> findAll() {
        Query q = em.createQuery("Select a from Author a");
        return q.getResultList();

    }
}