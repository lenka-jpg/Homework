package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.awt.print.Book;
import java.util.List;

@Transactional
@Component
public class CategoryDao {
    @PersistenceContext
    EntityManager em;

    public void save(Category category){
        if(category.getId()== null){
            em.persist(category);
        }
        else {
            em.merge(category);
        }
    }

    public void delete(Category category){
        em.remove(em.contains(category) ? category : em.merge(category));
    }

//    public void delete(Long id ){
//        Category category= findById(id);
//        delete(category);
//    }

    public Category findById(Long id){
        return em.find(Category.class, id);
    }

    public List<Category> findAll(){
        Query q = em.createQuery("Select a from Category a");
        return q.getResultList();
    }

//    public void delete(Long id){
//        Category category = findById(id);
//        List<Book> authorBooks = category.getBooks();
//        for(Book book:authorBooks){
//            book.getAuthors().remove(category);
//            bookDao.save(book);
//        }
//        em.remove(em.contains(category) ? category : em.merge(category));
//    }
}

