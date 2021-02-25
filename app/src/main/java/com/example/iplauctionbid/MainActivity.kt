package com.example.iplauctionbid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.players_list.view.*

class MainActivity : AppCompatActivity() {

    var playersList = PlayersList.getPlayersList(200)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = playerAdapter(this , playersList)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val playerName = view.playerName.text
            val teamName = view.teamName.text
            val playerPrice = view.playerPrice.text
            Toast.makeText(this , "$playerName was bid by $teamName for $playerPrice", Toast.LENGTH_SHORT).show()
        }
    }

    class playerAdapter(var context: Context, var playersList: ArrayList<PlayersList>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var itemView = convertView
            if(itemView == null) {
                itemView = LayoutInflater.from(context).inflate(
                        R.layout.players_list ,
                        parent ,
                        false
                )
            }
            itemView!!.playerName.text = playersList[position].playerNames
            itemView!!.teamName.text = playersList[position].teamNames
            itemView!!.playerPrice.text = "Rs. ${playersList[position].playerPrice.toString()} Cr."
            return itemView!!
        }

        override fun getItem(position: Int): Any {
            return playersList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return playersList.size
        }

    }
}