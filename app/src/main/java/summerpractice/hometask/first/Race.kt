package summerpractice.hometask.first

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText

class Race : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carCountEditText = findViewById<EditText>(R.id.car_count)
        val startRaceButton = findViewById<Button>(R.id.start_race_button)

        startRaceButton.setOnClickListener {
            val carCountText = carCountEditText.text.toString()
            if (carCountText.isNotEmpty()) {
                val carCount = carCountText.toInt()
                val cars = listParticipants(carCount)
                startRace(cars)
            }
        }
    }

    private fun listParticipants(count: Int): List<Auto> {
        val brands = listOf("Audi", "BMW", "Mercedes-Benz", "Toyota", "Honda", "Ford", "Chevrolet", "Jeep", "Lamborghini", "Ferrari")
        val models = listOf("Camry", "Accord", "Civic", "Corolla", "Mustang", "F-150", "Wrangler", "Cherokee", "Camaro", "Malibu")
        val colors = listOf("Red", "Blue", "Green", "Yellow", "Black", "White", "Silver", "Purple", "Orange", "Pink")

        return List(count) { i ->
            Auto(
                brand = brands.random(),
                model = models.random(),
                number = i + 1,
                year = (1990..2024).random(),
                color = colors.random(),
                enginePower = (10..1000).random()
            )
        }

    }

    private fun startRace(cars: List<Auto>) {
        var round = 1
        var participants = cars.toMutableList()

        while (participants.size > 1) {
            println("--- Раунд $round ---")
            val winners = mutableListOf<Auto>()

            val pairs = participants.shuffled().chunked(2)
            for (pair in pairs) {
                if (pair.size == 2) {
                    val car1 = pair[0]
                    val car2 = pair[1]

                    val winner = if (car1.enginePower > car2.enginePower) car1 else car2
                    println("Гонка между ${car1.number} и ${car2.number}, Победитель: ${winner.number}")
                    winners.add(winner)
                } else {
                    println("${pair[0].number} - Нет пары, проходит в следующий раунд")
                    winners.add(pair[0])
                }
            }

            participants = winners
            round++
        }

        println("Победитель: ${participants[0].number}")
    }
}