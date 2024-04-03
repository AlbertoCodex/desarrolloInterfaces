import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class Vehiculo(
    val matricula:String,
    val marca:String,
    val modelo:String
) {
    var vendido:Boolean = false

    open fun limitarVelocidad(velocidad:Int) {
        println("La velocidad del vehiculo se ha limitado a ${velocidad}")
    }
    override fun toString(): String {
        return "Matricula=${matricula}, Marca=${marca}, Modelo=${modelo}"
    }
}
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
    var potencia: String = "noDefinida"
    set(value) {
        field = value
        carnetNecesario = when (value) {
            "11kW" -> "A1"
            "35kW" -> "A2"
            else -> "A"
        }
    }
    constructor(
        vMatricula:String,
        vMarca:String,
        vModelo:String,
        potencia:String) : this(vMatricula, vMarca, vModelo) {
        carnetNecesario = when (potencia) {
            "11kW" -> "A1"
            "35kW" -> "A2"
            else -> "A"
        }
    }
}
class Coche(
    vMatricula:String, 
    vMarca:String, 
    vModelo:String
    ) : Vehiculo(matricula = vMatricula, marca = vMarca, modelo = vModelo) {
    val tipo = listOf("Deportivo", "Berlina", "Monovolumen", "SUB")
    var categoria:String = "noDefinida"
        private set(value) {
            if(value in categoria) {
                field = value
            }
    }
    override fun limitarVelocidad(velocidad:Int) {
        println("La velocidad del coche se ha limitado a ${velocidad}")
    }
}
class Empresa(val nombre:String) {
    var motos: ArrayList<Moto> = ArrayList()
    var coches: ArrayList<Coche> = ArrayList()
    var ventas: ArrayList<Vehiculo> = ArrayList()
   
    fun altaMoto(moto:Moto) {
        motos.add(moto)
    }
    fun altaCoche(coche:Coche) {
        coches.add(coche)
    }
    fun listarCoches() {
        for (coche in coches) {
            println("Matricula: ${coche.matricula}, Marca: ${coche.marca}, Modelo: ${coche.modelo}")
        }
    }
    fun listarMotos() {
        for (moto in motos) {
            println("Matricula: ${moto.matricula}, Marca: ${moto.marca}, Modelo: ${moto.modelo}")
        }
    }
    fun venderVehiculo(vehiculo:Vehiculo) {
        val motoAVender = motos.find { it.matricula == vehiculo.matricula }
        val cocheAVender = coches.find { it.matricula == vehiculo.matricula }

        if (motoAVender != null) {
            motos.remove(motoAVender) 
            ventas.add(motoAVender)
        } else if (cocheAVender != null) {
            coches.remove(cocheAVender)
            ventas.add(cocheAVender)
        }
    }
    fun listarVehiculosVendidos() {
        for (vehiculo in ventas) {
            println("Matricula: ${vehiculo.matricula}, Marca: ${vehiculo.marca}, Modelo: ${vehiculo.modelo}")
        }
    }
}
fun main() {
    // Creamos los coches, las motos y la empresa
    var empresa:Empresa = Empresa("NOMBRE")
    var moto1:Moto = Moto("mMatricula1", "mMarca1", "mModelo1", "11kW")
    var moto2:Moto = Moto("mMatricula2", "mMarca2", "mModelo2")
    var coche1:Coche = Coche("cMatricula1", "cMarca1", "cModelo1")
    var coche2:Coche = Coche("cMatricula2", "cMarca2", "cModelo2")   
    // Dar de alta 2 coches
    // Vender 1 de ellos y limitar la velocidad a 100 del otro vehiculo
    empresa.altaCoche(coche1)
    empresa.altaCoche(coche2)
    println("Se ha vendido el coche " + coche1.toString())
    empresa.venderVehiculo(coche1)
    coche2.limitarVelocidad(100)
    // Dar de alta 2 motos
    // Instacia una con la potencia, en la otra, indica potencia con el metodo set
    empresa.altaMoto(moto1)
    moto2.potencia = "35kW"
    empresa.altaMoto(moto2)
    // Ejecutar listarCoches , listarMotos y vehiculosVendidos
    println("La lista de coches: ")
    empresa.listarCoches()
    println("La lista de motos: ")
    empresa.listarMotos()
    println("La lista de vehiculos vendidos: ")
    empresa.listarVehiculosVendidos()
}