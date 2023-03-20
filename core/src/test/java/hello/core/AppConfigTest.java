package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.Order;
import hello.core.service.MemberService;
import hello.core.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AppConfigTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void test() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L, "BAG", 20000);
        assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }

}