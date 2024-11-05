class Empleado(var nombreEmpleado:String, var telefonoEmpleado:String, var categoriaProfesional:Int)
    : Persona(nombre = nombreEmpleado, telefonoMovil = telefonoEmpleado) {
    val departamentosLista = listOf("Programación", "Diseño", "Administración")
    var departamento:String = "PteAsignar"
        set(value) {
            field = if (value in departamentosLista) value else "PteAsignar"
        }

    var trabajandoAhora:Boolean = false

        init {
            if (categoriaProfesional in 1..7) {
                categoriaProfesional
            } else { categoriaProfesional = 0 }
        }
    constructor(codigo:Int) : this("", "", -1) {
        departamento = when(codigo) {
            0-> "Programación"
            1-> "Diseño"
            2-> "Administración"
            else -> "PteAsignar"
        }
    }
    fun asignarDepartamento(departamento:String) {
        this.departamento = departamento
    }
    fun fichar(trabajandoAhora:Boolean) {
        if (trabajandoAhora) {
            println("Saliendo del trabajo")
            this.trabajandoAhora = false
        } else {
            println("Entrando al trabajo")
            this.trabajandoAhora = true
        }
    }
}