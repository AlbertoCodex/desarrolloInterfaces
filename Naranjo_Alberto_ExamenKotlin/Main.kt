fun main() {
    // Instanciar turismos
    var turismo1:Turismo = Turismo("1234 ABC", "AMG", "CLA 45")
    var turismo2:Turismo = Turismo("5678 DEF", "BMW", "M3")
    // Vende un turismo y limita la velocidad del otro
    /*  Metodo no terminado
        empresa.venderVehiculo(turismo1)
    */
    turismo2.limitarVelocidad()
    // Instanciar motos una con potencia como parametro, otra con el metodo set
    // Problemas con el constructor
    var moto1:Moto = Moto("6543 HJK", "Kawasaki", "NTI", "34kW")
    var moto2:Moto = Moto("2139", "Honda", "IDK")
    // Instanciar empresa
    var empresa:Empresa = Empresa("AlbertoEmpresa")
    // Ejecutar metodos de empresa
    empresa.listarTurismos()
    empresa.listarMotos()
    /*  Metodo no terminado
        empresa.listarVehiculosVendidos()
    */
}

// cd "c:\Users\Alberto\Desktop\Naranjo_Alberto_ExamenKotlin\" ; if ($?) { kotlinc Main.kt Vehiculo.kt Moto.kt Turismo.kt Empresa.kt -include-runtime -d Main.jar } ; if ($?) { java -jar Main.jar }