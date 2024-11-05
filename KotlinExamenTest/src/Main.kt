fun main() {
    val cliente = Cliente("Alberto", "1234", 1)
    val empleado = Empleado("Empleadoor", "404", 0)
    val empresa = Empresa("Empresa", "mediana")

    empresa.altaCliente(cliente)
    empresa.listarClientes()
    println("-------------------")
    empresa.altaEmpleado(empleado)
    empresa.listarEmpleados()
    println("-------------------")
    println("Antes de fichar")
    empresa.listarEmpleadosTrabajando()
    empleado.fichar(empleado.trabajandoAhora)
    println("Despues de fichar")
    empresa.listarEmpleadosTrabajando()
}