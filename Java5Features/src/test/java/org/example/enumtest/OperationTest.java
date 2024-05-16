package org.example.enumtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OperationTest {

    @Test
    @DisplayName("상수별 메서드 구현 테스트")
    void apply() {
        // When
        Operation plus = Operation.PLUS;
        assertThat(plus.apply(1, 2)).isEqualTo(3);

        Operation minus = Operation.MINUS;
        assertThat(minus.apply(1, 2)).isEqualTo(-1);

        Operation multiply = Operation.MULTIPLY;
        assertThat(multiply.apply(1, 2)).isEqualTo(2);

        Operation divide = Operation.DIVIDE;
        assertThat(divide.apply(1, 2)).isEqualTo(0.5);

//        org.junit.jupiter.api.Assertions.assertThrows(
//                ArithmeticException.class,
//                () -> divide.apply(1, 0));
    }
}