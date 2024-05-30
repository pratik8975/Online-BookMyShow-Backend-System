package in.vp.main.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vp.main.entity.CardPaymentTicket;
import in.vp.main.entity.Movies;

public interface CardPaymentRepository extends JpaRepository<CardPaymentTicket, UUID> {


	CardPaymentTicket findByCardNo(String cardno);

}
