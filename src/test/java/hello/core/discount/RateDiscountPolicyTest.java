package hello.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

class RateDiscountPolicyTest {

	DiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP는 10% 할인이 적용되어야 한다")
	void vip_o() {
		// given
		Member member = new Member(1L, "memberVIP", Grade.VIP);
		
		// when
		int discount = discountPolicy.discount(member, 10000);
		
		// then
		Assertions.assertThat(discount).isEqualTo(1000);
	}
	
	@Test
	@DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
	void vip_x() {
		Member member = new Member(2L, "memberBASIC", Grade.BASIC);
		
		int discount = discountPolicy.discount(member, 10000);
		
		assertThat(discount).isEqualTo(0);	// static import 실행하면 줄여서 쓸 수 있음
	}
}
