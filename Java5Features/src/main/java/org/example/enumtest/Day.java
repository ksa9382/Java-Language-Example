package org.example.enumtest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 출처: https://bcp0109.tistory.com/334
 */

@RequiredArgsConstructor
@Getter
public enum Day {
    // int가 아닌 String 상수 정의
    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday"),
    SUN("Sunday");

    // name 말고, 실제 값(LABEL)으로 조회하기 위한 캐시
    private static final Map<String, Day> BY_LABEL =
            Stream.of(values()).collect(Collectors.toConcurrentMap(Day::label, e -> e));

    // String 상수 저장하기 위한 필드
    private final String LABEL;

    public String label() {
        return LABEL;
    }

    // label값을 이용해 캐시 조회
    public static Day valueByLabel(String label) {
        return BY_LABEL.get(label);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Day{");
        sb.append("name= '").append(name()).append("\', \t");
        sb.append("label='").append(LABEL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
