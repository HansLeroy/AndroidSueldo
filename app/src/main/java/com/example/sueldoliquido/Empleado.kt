package com.example.sueldoliquido


abstract class Empleado {
    abstract fun calcularLiquido(sueldoBruto: Double): Double
}

class Honorario : Empleado() {
    override fun calcularLiquido(sueldoBruto: Double): Double = sueldoBruto - (sueldoBruto * 0.13)
}

class Planta : Empleado() {
    override fun calcularLiquido(sueldoBruto: Double): Double = sueldoBruto - (sueldoBruto * 0.2)
}