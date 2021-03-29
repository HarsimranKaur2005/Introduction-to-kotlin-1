package com.example.tictactoe.MVP.View

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.MVP.Presenter.TicTacToePresenter
import com.example.tictactoe.R

class MainActivity : AppCompatActivity(), TicTacToeView,View.OnClickListener{

    lateinit var winnerPlayerLabel:TextView
    lateinit var winnerPlayerViewGroup:View
    lateinit var buttonGrid:ViewGroup
    var buttons = arrayOfNulls<Button>(9)

    val presenter = TicTacToePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        winnerPlayerLabel = findViewById(R.id.winnerPlayerLabel)
        winnerPlayerViewGroup= findViewById(R.id.winnerPlayerViewGroup)
        buttonGrid = findViewById(R.id.buttonGrid)
       // var clicked = findViewById<Button>(R.id.clicked)

        //create the view
        presenter.onCreate()




        for(i in 0..buttons.size-1)
        {
            var buttonnID = "btn_"+i
            var resourceId = resources.getIdentifier(buttonnID, "id", packageName)
            buttons[i] = findViewById(resourceId)
            buttons[i]!!.setOnClickListener(this)
        }

    }


    override fun setButtonText(row:Int, col:Int, text:String){
        var btn = buttonGrid.findViewWithTag<Button>("" + row + col)
        if (btn != null){
            btn.setText(text)
        }

    }

    override fun onClick(v: View?) {
        var buttonId = v!! as Button
        val tag = buttonId.getTag().toString()


        //spliting tag into row and col
        var row = tag.substring(0,1).toInt()
        var col = tag.substring(1,2).toInt()

        //send row and col to presenter
        presenter.onButtonSelected(row,col)

    }


    override fun showWinner(winningPlayer: String) {
        winnerPlayerLabel.setText(winningPlayer)
        winnerPlayerViewGroup.visibility=View.VISIBLE
    }
}