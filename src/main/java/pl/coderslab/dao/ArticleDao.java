package pl.coderslab.dao;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Component
public class ArticleDao {

    @PersistenceContext
    EntityManager em;

    public void save(Article article) {
        if (article.getId() == null) {
            em.persist(article);
        } else {
            em.merge(article);
        }
    }

    public void delete(Article article) {
        em.remove(em.contains(article) ? article : em.merge(article));
    }

//    public void delete(Long id ){
//        Category category= findById(id);
//        delete(category);
//    }

    public Article findById(Long id) {
        return em.find(Article.class, id);
    }

    public List<Article> findAll() {
        Query q = em.createQuery("Select a from Article a");
        return q.getResultList();

    }
}
