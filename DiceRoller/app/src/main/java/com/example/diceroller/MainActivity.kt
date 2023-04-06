package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Criando uma Variável para o Botão e Utilizando o reconhecedor de Click
        val rollButton:Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener{ rollDice()}

        //Rola o Dado quando o app incia
        rollDice()
    }

    @SuppressLint("SetTextI18n")
    private fun rollDice(){
        //Criando um novo Objeto Dado com 6 lados e rola o dado
        val dice = Dice(6)
        val randomInt = dice.roll()

        //Acha a imagem view no layout
        val diceImage: ImageView = findViewById(R.id.DiceImage)

        //Determina o id da imagem que deve ser usada com a rolagem do dado
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Atualiza a Imagem do Dado, conforme o rolamento e o when
        diceImage.setImageResource(drawableResource)

        //Atualiza a descrição do conteúdo
        diceImage.contentDescription = randomInt.toString()

        //Notificação do dado ser rolado
        Toast.makeText(this, "Dado Rolado", Toast.LENGTH_SHORT).show()

    }

    //Classe com recebimento de parâmetro

    class Dice(private val numSides: Int) {

        /**
         * Roda randomicamente o dado e retorna o resultado
         */
        fun roll(): Int {
            return (1..numSides).random()
        }
    }


}
