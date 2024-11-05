class Cliente(var nombreCliente:String, var telefonoCliente:String, var codigoTipoCliente:Int)
    : Persona(nombre = nombreCliente, telefonoMovil = telefonoCliente) {
        var tipoCliente = "SinDeterminar"
            set(value) {
                field = when(codigoTipoCliente) {
                    0-> "Impulsivo"
                    1-> "Indeciso"
                    2-> "Negociador"
                    else -> {"SinDeterminar"}
                }
            }
    fun comprar() {
        println("Cliente comprando")
    }
}