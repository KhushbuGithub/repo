package com.capgemini.bookmydoctor.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import com.capgemini.bookmydoctor.dto.Rating;

import org.springframework.stereotype.Repository;

@Repository
public class RatingDAOImpl implements RatingDAO {
	
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addRatingAndReview(Rating bean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
            entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(bean);
			transaction.commit();
			return true;
             } catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		transaction.commit();
		entityManager.close();
		return false;
	}

	@Override
	public boolean deleteRatingAndReview(int ratingId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Rating bean = manager.find(Rating.class, ratingId);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public List<Rating> getAllRatingAndReviews() {
		String jpql = "from Rating";
		EntityManager manager = entityManagerFactory.createEntityManager();
		TypedQuery<Rating> query = manager.createQuery(jpql, Rating.class);
		return query.getResultList();
	}

	@Override
	public Rating searchRating(int ratingId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		Rating searchratingAndReview = manager.find(Rating.class, ratingId);
		return searchratingAndReview;
	}

	@Override
	public boolean modifyRating(Rating bean) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		Rating ratingAndReview = entityManager.find(Rating.class, bean.getAppionmentId());
		if (ratingAndReview != null) {
			ratingAndReview.setAppionmentId(bean.getAppionmentId());
			ratingAndReview.setDoctorId(bean.getDoctorId());
			ratingAndReview.setDoctorName(bean.getDoctorName());
			ratingAndReview.setRating(bean.getRating());
			ratingAndReview.setReview(bean.getReview());

			transaction.commit();
			entityManager.close();
			return true;
		}
		return false;
	}

	@Override
	public List<Rating> searchRating(String doctorName) {
		List<Rating> list = new ArrayList<>();
		EntityManager manager = entityManagerFactory.createEntityManager();
		String getall="from Rating where doctorName=:doctorName";
		TypedQuery<Rating> query=manager.createQuery(getall,Rating.class);
		query.setParameter("doctorName", doctorName);
		list = query.getResultList();
		return list;
	}
	
	
}
