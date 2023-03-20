package hello.core.service;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {

        Long memberId =1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(member.getId());
        Order order = orderService.createOrder(memberId, "BAG", 100000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }






}