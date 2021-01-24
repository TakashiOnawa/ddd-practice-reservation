package org.taonaw.reservation.domain.model.reservationPolicy

import org.taonaw.reservation.domain.model.reservation.UsageTime
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * 予約受付開始日
 */
data class AcceptingReservationStartDate(
        private val dateValue: Int,
        private val dateType: DateType) {

    enum class DateType(private val value: Int) {
        DAYS_AGO(1) {
            override fun acceptingReservationStartDate(dateValue: Int, targetDateTime: LocalDateTime): LocalDate {
                return targetDateTime.minusDays(dateValue.toLong()).toLocalDate()
            }
        },

        WEEKS_AGO(2) {
            override fun acceptingReservationStartDate(dateValue: Int, targetDateTime: LocalDateTime): LocalDate {
                return targetDateTime.minusDays(dateValue * 7.toLong()).toLocalDate()
            }
        },

        MONTHS_AGO(3) {
            override fun acceptingReservationStartDate(dateValue: Int, targetDateTime: LocalDateTime): LocalDate {
                return targetDateTime.minusMonths(dateValue.toLong()).toLocalDate()
            }
        };

        abstract fun acceptingReservationStartDate(dateValue: Int, targetDateTime: LocalDateTime): LocalDate
    }

    fun isSatisfiedBy(usageTime: UsageTime, currentDateTime: LocalDateTime): Boolean {
        val acceptingReservationStartDate = dateType.acceptingReservationStartDate(dateValue, usageTime.start)
        val currentDate = currentDateTime.toLocalDate()
        return currentDate == acceptingReservationStartDate || currentDate.isAfter(acceptingReservationStartDate)
    }
}