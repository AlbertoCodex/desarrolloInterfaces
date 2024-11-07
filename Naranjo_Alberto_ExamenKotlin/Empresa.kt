class Empresa(var nombre:String) {
    var turismos = mutableListOf<Turismo>()
    var motos = mutableListOf<Moto>()


    // Añade una moto a la lista de motos
    fun altaMoto(moto:Moto) {
        motos.add(moto)
    }
    // Añade un turismo a la lista de turismos
    fun altaTurismo(turismo:Turismo) {
        turismos.add(turismo)
    }
    /* 
    fun venderVehiculo(vehiculo:Vehiculo) {
        if(!vehiculo.vendido) {
            vehiculo.vendido = true
        }
    }
    */
    // Imprime por consola la matricula de los turismos
    fun listarTurismos() {
        for (turismo in turismos)
            println(turismo.matricula)
    }
    // Imprime por consola la matricula de las motos
    fun listarMotos() {
        for (moto in motos)
            println(moto.matricula)
    }
/* 
    fun listarVehiculosVendidos() {
        for (vehiculo in vehiculos)
            if (vehiculo.vendido)    
                println(vehiculo.matricula)
    }
*/
}