package com.sougata.attendance.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.sougata.attendance.entity.BiometricTransaction;
import com.sougata.attendance.entity.BiometricTransaction_;
import com.sougata.attendance.entity.User;
import com.sougata.attendance.entity.User_;

public final class BiometricTransactionSpecifications {

    private BiometricTransactionSpecifications() {

    }

    public static Specification<BiometricTransaction> forUserAndDateRange(User user, Date startDate, Date endDate) {
	return new Specification<BiometricTransaction>() {
	    @Override
	    public Predicate toPredicate(Root<BiometricTransaction> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();
		final Predicate dateRangePredicate = cb.between(root.get(BiometricTransaction_.inDate), startDate,
			endDate);
		predicates.add(dateRangePredicate);
		final Predicate userPredicate = root.join(BiometricTransaction_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<BiometricTransaction> forParticularDateIgnoringTime(Date startDate, Date sqlToDate) {
	return new Specification<BiometricTransaction>() {
	    @Override
	    public Predicate toPredicate(Root<BiometricTransaction> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();

		 final Predicate dateRangePredicate =cb.between(root.get(BiometricTransaction_.inDate), startDate,sqlToDate);
		//final Predicate dateRangePredicate1 = cb.isNotNull(root.get(BiometricTransaction_.inDate));
		predicates.add(dateRangePredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }
    
    public static Specification<BiometricTransaction> forParticularUserAndDateIgnoringTime(User user,Date startDate, Date sqlToDate) {
	return new Specification<BiometricTransaction>() {
	    @Override
	    public Predicate toPredicate(Root<BiometricTransaction> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();

		 final Predicate dateRangePredicate =cb.between(root.get(BiometricTransaction_.inDate), startDate,sqlToDate);
		//final Predicate dateRangePredicate1 = cb.isNotNull(root.get(BiometricTransaction_.inDate));
		predicates.add(dateRangePredicate);
		
		final Predicate userPredicate = root.join(BiometricTransaction_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }
}
