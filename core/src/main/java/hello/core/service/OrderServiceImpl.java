package hello.core.service;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.order.Order;
import hello.core.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{


    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member findMember = memberRepository.findById(memberId);
        int discount= discountPolicy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }


}
