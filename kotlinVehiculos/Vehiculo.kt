package com.example

open class Vehiculo(
    val matricula:String,
    val marca:String,
    val modelo:String
) {
    var vendido:Boolean

    fun limitarVelocidad() {

    }

    override fun toString(): String {
        return "Vehiculo(matricula='$matricula', marca='$marca', modelo='$modelo')"
    }
}