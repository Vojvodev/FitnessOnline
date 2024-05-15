package etf.ip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import etf.ip.model.Subscriptions;

public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Integer>{

}
