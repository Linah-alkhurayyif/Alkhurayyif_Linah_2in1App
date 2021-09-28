package com.example.alkhurayyif_linah_2in1app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Numberbutton = findViewById<Button>(R.id.Numberbutton)
        val Phrasebutton = findViewById<Button>(R.id.Phrasebutton)
        Numberbutton.setOnClickListener{
            val intent = Intent(this, NumberGame()::class.java)
            startActivity(intent);
        }
        Phrasebutton.setOnClickListener{
            val intent = Intent(this, Phrasebutton()::class.java)
            startActivity(intent);
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val item:MenuItem = menu!!.getItem(0)
        item.setTitle("Number Game")
        val item2:MenuItem = menu!!.getItem(1)
        item2.setTitle("Guess The Phrase")
        val item3:MenuItem = menu!!.getItem(2)
        item3.setVisible(false)
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
        }
        return super.onOptionsItemSelected(item)
    }

}