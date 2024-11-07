// Constructor principal
class Turismo(var matriculaTurismo:String, var marcaTurismo:String, var modeloTurismo:String) 
: Vehiculo(matricula = matriculaTurismo, marca = marcaTurismo, modelo = modeloTurismo) {
    // Definir propiedad
    val categorias = listOf("SUV", "Crossover", "Coupe", "Sedan") // Lista de categorias de coche
    var categoria = "SinDefinir"
        set(value) {
            if(value in categorias) // Comprobar si el valor pasado esta en la lista
                field = value 
            else "SinDefinir"
        }
    // No recuerdo como sobreescribir un metodo
    fun limitarVelocidad() {
        println("Limitando velocidad del turismo")
    }
}
