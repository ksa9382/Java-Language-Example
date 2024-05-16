package org.example.enumtest;

import lombok.RequiredArgsConstructor;

/**
 * 전략 열거 타입 사용예제
 */
@RequiredArgsConstructor
public enum PayrollDay {
    MONDAY(PayType.WEEKDAY),
    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),
    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    public static final int MINS_PER_SHIFT = 8 * 60;

    private final PayType payType;

    public int pay(int minWorked, double payRate) {
        return payType.overtimePay(minWorked, payRate);
    }

    //
    enum PayType {
        WEEKDAY {
            @Override
            public int overtimePay(int minWorked, double payRate) {
                return minWorked <= MINS_PER_SHIFT ? 0 :
                        (int)((minWorked - MINS_PER_SHIFT) * payRate / 2);
            }
        },
        WEEKEND {
            @Override
            public int overtimePay(int minWorked, double payRate) {
                return (int)(minWorked * payRate / 2);
            }
        };

        public abstract int overtimePay(int minWorked, double payRate);
    }
}
