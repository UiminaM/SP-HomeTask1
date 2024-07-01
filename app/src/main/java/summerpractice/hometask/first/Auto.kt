package summerpractice.hometask.first

open class Auto (
    val brand: String,
    val model: String,
    val number: Int,
    val year: Int,
    val color: String,
    val enginePower: Int
){
    fun printInfo() {
        println("Brand: $brand, model: $model, number: $number, year: $year, color: $color, " +
                "engine power: $enginePower")
    }
}

class Crossover (
    brand: String,
    model: String,
    number: Int,
    year: Int,
    color: String,
    enginePower: Int,
    val typeDrive: String
) : Auto(brand, model, number, year, color, enginePower)

class Minivan (
    brand: String,
    model: String,
    number: Int,
    year: Int,
    color: String,
    enginePower: Int,
    val numberPassengers: Int
) : Auto(brand, model, number, year, color, enginePower)

class SportsCar (
    brand: String,
    model: String,
    number: Int,
    year: Int,
    color: String,
    enginePower: Int,
    val maxSpeed: Int
) : Auto(brand, model, number, year, color, enginePower)

class Pickup (
    brand: String,
    model: String,
    number: Int,
    year: Int,
    color: String,
    enginePower: Int,
    val sizeCarBody: Int
) : Auto(brand, model, number, year, color, enginePower)

class Cabriolet (
    brand: String,
    model: String,
    number: Int,
    year: Int,
    color: String,
    enginePower: Int,
    val typeRoof: Int
) : Auto(brand, model, number, year, color, enginePower)




class AutoBuilder(private var number: Int) {
    private var brand: String = ""
    private var model: String = ""
    private var year: Int = 0
    private var color: String = ""
    private var enginePower: Int = 0

    fun setBrand(brand: String) = apply { this.brand = brand }
    fun setYear (year: Int) = apply { this.year = year }
    fun setColor (color: String) = apply { this.color = color }
    fun setEnginePower (enginePower: Int) = apply { this.enginePower = enginePower }

    fun build(): Auto {
        return Auto(brand, model, number,  year, color, enginePower)
    }
}