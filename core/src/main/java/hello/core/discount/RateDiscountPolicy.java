package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent=10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            int rateDiscountPrice = price / 100 * discountPercent;
            return rateDiscountPrice;
        } else {
            return 0;
        }
    }
    
}
