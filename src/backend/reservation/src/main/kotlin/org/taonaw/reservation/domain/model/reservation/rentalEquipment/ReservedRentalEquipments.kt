package org.taonaw.reservation.domain.model.reservation.rentalEquipment

import org.taonaw.reservation.domain.model.equipment.EquipmentId
import org.taonaw.reservation.domain.model.equipment.Equipments
import org.taonaw.reservation.domain.model.reservation.RentalEquipmentsOutOfStocksErr
import org.taonaw.reservation.domain.shared.exception.Err

class ReservedRentalEquipments private constructor(
        val items: Map<EquipmentId, List<RentalEquipment>>) {

    companion object {
        fun create(rentalEquipments: List<RentalEquipments>): ReservedRentalEquipments {
            return ReservedRentalEquipments(rentalEquipments.flatMap { it.items }.groupBy { it.equipmentId })
        }
    }

    fun validateUsageEquipmentsOutOfStocks(equipments: Equipments): Err? {
        val outOfStocksEquipmentIds = items.filter { it ->
            val equipment = equipments.findBy(it.key) ?: throw Exception()
            equipment.equipmentStocks < it.value.sumOf { it.quantity.value }
        }.map { it.key }

        if (outOfStocksEquipmentIds.isEmpty()) return null
        return RentalEquipmentsOutOfStocksErr(outOfStocksEquipmentIds)
    }
}