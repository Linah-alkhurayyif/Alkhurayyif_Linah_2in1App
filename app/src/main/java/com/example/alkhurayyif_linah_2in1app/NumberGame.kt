package com.example.alkhurayyif_linah_2in1app

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlin.collections.ArrayList
import kotlin.random.Random

class NumberGame : AppCompatActivity() {
    lateinit var numbers: ArrayList<String>
    val randomeNumber = Random.nextInt(0,10)
    var GuessCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_game)
        numbers = ArrayList<String>()
        val RecyclerView = findViewById<RecyclerView>(R.id.numberGameRecyclerView)
        val quessButton = findViewById<Button>(R.id.guessButton)
        quessButton.setOnClickListener{
            checkGuess()
            RecyclerView.adapter = NumberGameRecyclerViewAdapter(numbers)
            RecyclerView.layoutManager  = LinearLayoutManager(this)
        }
    }
    fun checkGuess(){
        val GuessEditText = findViewById<EditText>(R.id.GuesseditText)
        var ConstraintLayout = findViewById<ConstraintLayout>(R.id.ConstraintLayout)
        if(GuessEditText.text.toString().isEmpty()){
            Snackbar.make(ConstraintLayout,"Enter a number between 0 - 10",Snackbar.LENGTH_LONG).show()
        }else{
            var GuessEditTextInt:Int = GuessEditText.text.toString().toInt()
            if(GuessEditTextInt>10){
                Snackbar.make(ConstraintLayout,"Enter a number between 0 - 10",Snackbar.LENGTH_LONG).show()
            }else{
                if(GuessEditTextInt == randomeNumber){
                    customAlert("Congratulations, your guess is correct..")
                }else{
                    GuessCount++
                    numbers.add("You guessed "+GuessEditText.text.toString())
                    if(GuessCount-3 == 0){
                        customAlert("You lost X_X")

                    }else{
                        numbers.add("You have "+(3-GuessCount)+" guessed left")
                    }

                }
            }


        }
        GuessEditText.setText("");

    }
    private fun customAlert(Title:String){
        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(this)
        // here we set the message of our alert dialog
        dialogBuilder.setTitle(Title)
            // positive button text and action
            .setPositiveButton("Try again", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
                GuessCount=0
                numbers.clear()
            })
        // negative button text and action
//            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
//                    dialog, id -> dialog.cancel()
//            })
        // create dialog box
        val alert = dialogBuilder.create()
        // show alert dialog
        alert.show()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val item:MenuItem = menu!!.getItem(0)
        item.setTitle("New Game")
        val item2:MenuItem = menu!!.getItem(1)
        item2.setTitle("Guess The Phrase")
        val item3:MenuItem = menu!!.getItem(2)
        item3.setVisible(true)
        return super.onPrepareOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.NewGameItem -> {
                val intent = Intent(this, NumberGame()::class.java)
                startActivity(intent);
                return true
            }
            R.id.GameItem -> {
                val intent = Intent(this, Phrasebutton()::class.java)
                startActivity(intent);
                return true
            }
            R.id.MainMenuItem -> {
                val intent = Intent(this, MainActivity()::class.java)
                startActivity(intent);
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
}