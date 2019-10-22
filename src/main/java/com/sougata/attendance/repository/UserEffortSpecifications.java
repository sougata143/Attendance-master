package com.sougata.attendance.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.sougata.attendance.entity.Activity;
import com.sougata.attendance.entity.Activity_;
import com.sougata.attendance.entity.BiometricTransaction;
import com.sougata.attendance.entity.BiometricTransaction_;
import com.sougata.attendance.entity.Task;
import com.sougata.attendance.entity.Task_;
import com.sougata.attendance.entity.User;
import com.sougata.attendance.entity.UserDeviceEffort;
import com.sougata.attendance.entity.UserDeviceEffort_;
import com.sougata.attendance.entity.User_;

public final class UserEffortSpecifications {

    private UserEffortSpecifications() {

    }

    public static Specification<UserDeviceEffort> forUserAndDateRange(User user, Date startDate, Date endDate) {
	return new Specification<UserDeviceEffort>() {
	    @Override
	    public Predicate toPredicate(Root<UserDeviceEffort> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();
		final Predicate dateRangePredicate = cb.between(root.get(UserDeviceEffort_.effortDate), startDate,
			endDate);
		predicates.add(dateRangePredicate);
		final Predicate userPredicate = root.join(UserDeviceEffort_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<UserDeviceEffort> forParticularDateIgnoringTime(Date startDate, Date sqlToDate) {
	return new Specification<UserDeviceEffort>() {
	    @Override
	    public Predicate toPredicate(Root<UserDeviceEffort> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();

		final Predicate dateRangePredicate = cb.between(root.get(UserDeviceEffort_.effortDate), startDate,
			sqlToDate);
		// final Predicate dateRangePredicate1 =
		// cb.isNotNull(root.get(UserDeviceEffort_.inDate));
		predicates.add(dateRangePredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<UserDeviceEffort> forParticularUserAndDateIgnoringTime(User user, Date startDate,
	    Date sqlToDate) {
	return new Specification<UserDeviceEffort>() {
	    @Override
	    public Predicate toPredicate(Root<UserDeviceEffort> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();

		final Predicate dateRangePredicate = cb.between(root.get(UserDeviceEffort_.effortDate), startDate,
			sqlToDate);
		// final Predicate dateRangePredicate1 =
		// cb.isNotNull(root.get(UserDeviceEffort_.inDate));
		predicates.add(dateRangePredicate);

		final Predicate userPredicate = root.join(UserDeviceEffort_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<UserDeviceEffort> forBiometricTransactionAndDateRange(
	    BiometricTransaction biometricTransaction, Date startDate, Date endDate) {
	return new Specification<UserDeviceEffort>() {
	    @Override
	    public Predicate toPredicate(Root<UserDeviceEffort> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();
		final Predicate dateRangePredicate = cb.between(root.get(UserDeviceEffort_.effortDate), startDate,
			endDate);
		predicates.add(dateRangePredicate);
		final Predicate biometricPredicate = root.join(UserDeviceEffort_.biometricTransaction)
			.get(BiometricTransaction_.transactionId).in(biometricTransaction.getTransactionId());
		predicates.add(biometricPredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<UserDeviceEffort> effortforParticularDateIgnoringTime(Date startDate, Date sqlToDate) {
	return new Specification<UserDeviceEffort>() {
	    @Override
	    public Predicate toPredicate(Root<UserDeviceEffort> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();

		final Predicate dateRangePredicate = cb.between(root.get(UserDeviceEffort_.effortDate), startDate,
			sqlToDate);
		// final Predicate dateRangePredicate1 =
		// cb.isNotNull(root.get(UserDeviceEffort_.inDate));
		predicates.add(dateRangePredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<UserDeviceEffort> forParticularBiometricTransactionAndDateIgnoringTime(
	    BiometricTransaction biometricTransaction, Date startDate, Date sqlToDate) {
	return new Specification<UserDeviceEffort>() {
	    @Override
	    public Predicate toPredicate(Root<UserDeviceEffort> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();

		final Predicate dateRangePredicate = cb.between(root.get(UserDeviceEffort_.effortDate), startDate,
			sqlToDate);
		// final Predicate dateRangePredicate1 =
		// cb.isNotNull(root.get(UserDeviceEffort_.inDate));
		predicates.add(dateRangePredicate);

		final Predicate biometricPredicate = root.join(UserDeviceEffort_.biometricTransaction)
			.get(BiometricTransaction_.transactionId).in(biometricTransaction.getTransactionId());
		predicates.add(biometricPredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<UserDeviceEffort> forUserAndBiometricTransactionAndDateRange(User user,
	    BiometricTransaction biometricTransaction, Date startDate, Date endDate) {
	return new Specification<UserDeviceEffort>() {
	    @Override
	    public Predicate toPredicate(Root<UserDeviceEffort> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();
		final Predicate dateRangePredicate = cb.between(root.get(UserDeviceEffort_.effortDate), startDate,
			endDate);
		predicates.add(dateRangePredicate);
		final Predicate biometricPredicate = root.join(UserDeviceEffort_.biometricTransaction)
			.get(BiometricTransaction_.transactionId).in(biometricTransaction.getTransactionId());
		predicates.add(biometricPredicate);

		final Predicate userPredicate = root.join(UserDeviceEffort_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<UserDeviceEffort> forUserAndParticularBiometricTransactionAndDateIgnoringTime(User user,
	    BiometricTransaction biometricTransaction, Date startDate, Date sqlToDate) {
	return new Specification<UserDeviceEffort>() {
	    @Override
	    public Predicate toPredicate(Root<UserDeviceEffort> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();

		final Predicate dateRangePredicate = cb.between(root.get(UserDeviceEffort_.effortDate), startDate,
			sqlToDate);
		// final Predicate dateRangePredicate1 =
		// cb.isNotNull(root.get(UserDeviceEffort_.inDate));
		predicates.add(dateRangePredicate);

		final Predicate biometricPredicate = root.join(UserDeviceEffort_.biometricTransaction)
			.get(BiometricTransaction_.transactionId).in(biometricTransaction.getTransactionId());
		predicates.add(biometricPredicate);

		final Predicate userPredicate = root.join(UserDeviceEffort_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<UserDeviceEffort> forUserAndParticularTaskAndDateIgnoringTime(User user, Task task,
	    Date startDate, Date sqlToDate) {
	return new Specification<UserDeviceEffort>() {
	    @Override
	    public Predicate toPredicate(Root<UserDeviceEffort> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();

		final Predicate dateRangePredicate = cb.between(root.get(UserDeviceEffort_.effortDate), startDate,
			sqlToDate);
		// final Predicate dateRangePredicate1 =
		// cb.isNotNull(root.get(UserDeviceEffort_.inDate));
		predicates.add(dateRangePredicate);

		final Predicate taskPredicate = root.join(UserDeviceEffort_.task).get(Task_.id).in(task.getId());
		predicates.add(taskPredicate);

		final Predicate userPredicate = root.join(UserDeviceEffort_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

    public static Specification<UserDeviceEffort> forUserAndParticularActivityAndDateIgnoringTime(User user,
	    Activity activity, Date startDate, Date sqlToDate) {
	return new Specification<UserDeviceEffort>() {
	    @Override
	    public Predicate toPredicate(Root<UserDeviceEffort> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		final Collection<Predicate> predicates = new ArrayList<>();

		final Predicate dateRangePredicate = cb.between(root.get(UserDeviceEffort_.effortDate), startDate,
			sqlToDate);
		// final Predicate dateRangePredicate1 =
		// cb.isNotNull(root.get(UserDeviceEffort_.inDate));
		predicates.add(dateRangePredicate);

		final Predicate activityPredicate = root.join(UserDeviceEffort_.activity).get(Activity_.id)
			.in(activity.getId());
		predicates.add(activityPredicate);

		final Predicate userPredicate = root.join(UserDeviceEffort_.user).get(User_.id).in(user.getId());
		predicates.add(userPredicate);

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	};

    }

}
