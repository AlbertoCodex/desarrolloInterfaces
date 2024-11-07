// Constructor primario
class Moto(var matriculaMoto:String, var marcaMoto:String, var modeloMoto:String) 
    : Vehiculo(matricula = matriculaMoto, marca = marcaMoto, modelo = modeloMoto){
    // Constructor secundario
    constructor(potencia:String) : this("", "", "") {
        // Iniciar propiedad dependiendo de parametro potencia
        val listaCarnets = listOf("Carnet A1", "Carnet A2", "Carnet A")
        var carnetNecesario:String = "??"
            set(value) {
                if(value in listaCarnets)
                    field = value
                else "??"
            }
        init {
            // Asignar dependiendo de potencia
            if (potencia == "14kW")
                carnetNecesario = "Carnet A1"
            else if (potencia == "34kW")
                carnetNecesario = "Carnet A2"
            else
                carnetNecesario = "Carnet A"
        }   
    }
}
