class Empresa(var nombreEmpresa:String, var tamañoEmpresa:String) {
    val empleados = mutableListOf<Empleado>()
    val clientes = mutableListOf<Cliente>()
    val tamaños = listOf("pequeña", "mediana", "grande")
    val sectores = listOf("primario", "secundario", "terciario")
    var sectorEmpresarial:String = "Sector desconocido"
        set(value) {
            field = if (value !in sectores) "sector desconocido" else value
        }

    init {
        if(tamañoEmpresa !in tamaños) {
            tamañoEmpresa = "Tamaño desconocido"
        }
    }

    fun altaCliente(cliente: Cliente) {
        println("Se ha añadido a un nuevo cliente")
        clientes.add(cliente)
    }
    fun altaEmpleado(empleado: Empleado) {
        println("Se ha añadido a un nuevo empleado")
        empleados.add(empleado)
    }

    fun listarClientes() {
        println("Lista de clientes: ")
        for (cliente in clientes)
        println(cliente.nombreCliente)
    }
    fun listarEmpleados() {
        println("Lista de empleados: ")
        for (empleado in empleados)
            println(empleado.nombreEmpleado)
    }

    fun listarEmpleadosTrabajando() {
        println("Lista de empleados trabajando: ")
        for (empleado in empleados)
            if (empleado.trabajandoAhora)
                println(empleado.nombreEmpleado)
            else
                println("No hay ningun trabajador activo")
    }
}