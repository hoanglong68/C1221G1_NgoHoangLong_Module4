package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    @Override
    public List<Product> getProductList() {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery
                ("select p from Product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void createProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findProductById(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void removeProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public void saveProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public List<Product> findProductByName(String search) {
        TypedQuery<Product> typedQuery = BaseRepository.entityManager.createQuery
                ("select p from Product p where p.name like :name", Product.class);
        typedQuery.setParameter("name", search);
        return typedQuery.getResultList();
    }
}
