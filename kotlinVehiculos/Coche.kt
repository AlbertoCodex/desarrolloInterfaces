class Coche(
    vMatricula:String, 
    vMarca:String, 
    vModelo:String
    ) : Vehiculo(matricula = vMatricula, marca = vMarca, modelo = vModelo) {
    var categoria:String
        private set(value)
        if(value == "Deportivo" || value == "Berlina" || value == "Monovolumen" || value == "SUB") {
            field = value
        } else {
            field = noDefinida
        }
    }
}