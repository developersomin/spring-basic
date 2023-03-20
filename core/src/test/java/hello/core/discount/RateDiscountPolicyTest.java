package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void vip_o() {
        Member member = new Member(1L, "memberA", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    void vip_x() {
        Member member = new Member(1L, "memberA", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }
}