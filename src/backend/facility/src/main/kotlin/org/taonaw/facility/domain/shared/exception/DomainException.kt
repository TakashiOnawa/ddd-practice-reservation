package org.taonaw.facility.domain.shared.exception

class DomainException(message: String) : Exception(message) {
    private val errNotification: ErrNotification = ErrNotification()

    constructor(message: String, errNotification: ErrNotification) : this(message) {
        this.errNotification.addErr(errNotification)
    }

    fun throwIfHasErrs() {
        if (errNotification.hasErrs())
            throw this
    }

    override fun toString(): String {
        return super.toString() + "{DomainException(errNotification=${errNotification})}"
    }
}