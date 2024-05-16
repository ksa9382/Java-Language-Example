package org.example.enumtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PayrollDayTest {

    @Test
    @DisplayName("전략열거패턴 테스트")
    void pay() {
        PayrollDay monday = PayrollDay.MONDAY;
        PayrollDay tuesday = PayrollDay.TUESDAY;
        PayrollDay saturday = PayrollDay.SATURDAY;
        PayrollDay sunday = PayrollDay.SUNDAY;

        assertThat(monday.pay(480, 1.3)).isEqualTo(0);
        assertThat(tuesday.pay(490, 1.3)).isEqualTo(6);
        assertThat(saturday.pay(480, 1.3)).isEqualTo(312);
        assertThat(sunday.pay(490, 1.3)).isEqualTo(318);
    }
}