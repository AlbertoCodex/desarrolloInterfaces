class Moto(
    vMatricula:String,
    vMarca:String,
    vModelo:String
    ) : Vehiculo(matricula = vMatricula, marca = vMarca, modelo = vModelo) {   
    val categoria = listOf("A1", "A2", "A") 
    var carnetNecesario = "??"
        private set(value) {
            if(value in categoria) {
                field = value
            } 
        }
    constructor(
        vMatricula:String,
        vMarca:String,
        vModelo:String
        val potencia:String) : this(vMatricula, vMarca, vModelo) {
        carnetNecesario = when (potencia) {
            "11kW" -> "A1"
            "35kW" -> "A2"
            else -> "A"
        }
    }
}