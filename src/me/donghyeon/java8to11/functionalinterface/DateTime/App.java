package me.donghyeon.java8to11.functionalinterface.DateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) {
//        Date date = new Date(); // mutable 해서 thread-safe 하지 않다.
//        Calendar calendar = new GregorianCalendar(); // mutable해서 thread-safe하지 않고 type-safe 하지도 않다.

        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);

        LocalDateTime now = LocalDateTime.now(); // 시스템의 기본 시간
        System.out.println(now);
        LocalDateTime birthday = LocalDateTime.of(1996, Month.JANUARY, 16, 0, 0, 0);
        System.out.println(birthday);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate nextYearBirthday = LocalDate.of(2022,Month.JANUARY,16);
        System.out.println(nextYearBirthday);
        Period between = Period.between(today, nextYearBirthday);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());

        Period until = today.until(nextYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        Instant cur = Instant.now();
        Instant plus = cur.plus(10, ChronoUnit.SECONDS);
        Duration between1 = Duration.between(cur, plus);
        System.out.println(between1.getSeconds());

        // Formatting
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter isoLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(dateTime.format(isoLocalDate));
        System.out.println(dateTime.format(dateTimeFormatter));

        // Parsing
        LocalDate parse = LocalDate.parse("07/15/1982", dateTimeFormatter);
        System.out.println(parse);
    }
}
