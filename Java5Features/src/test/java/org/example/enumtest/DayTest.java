package org.example.enumtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class DayTest {

    @Test
    @DisplayName("Day Enum 생성 및 이름 출력 테스트")
    void testCreateDay() {
        // given, when
        Day mon = Day.MON;
        Day sun = Day.SUN;
        Day sat = Day.SAT;

        // then
        assertThat(mon.name()).isEqualTo("MON");
        assertThat(mon.getLABEL()).isEqualTo("Monday");

        assertThat(sun.name()).isEqualTo("SUN");
        assertThat(sun.getLABEL()).isEqualTo("Sunday");

        assertThat(sat.name()).isNotEqualTo("SUN");
        assertThat(sat.getLABEL()).isNotEqualTo("Sunday");
    }

    @Test
    @DisplayName("Day values() 테스트")
    void testValues() {
        // given
        String tuesdayName = "TUE";
        Day[] dayValues = Day.values();
        System.out.println("dayValues = " + Arrays.toString(dayValues));

        for (Day day : Day.values()) {
            if (day.name().equals(tuesdayName)) {
                assert (true);
            }
        }
    }

    @Test
    @DisplayName("Day Lable 캐싱 기능 테스트")
    void testCachingByLable() {
        String fridayLable = "Friday";

        Day fri = Day.valueByLabel(fridayLable);

        assertThat(fri.getLABEL()).isEqualTo(fridayLable);
    }

}