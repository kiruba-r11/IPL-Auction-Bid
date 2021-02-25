package com.example.iplauctionbid

import kotlin.random.Random

data class PlayersList(
        var playerNames: String ,
        var teamNames: String ,
        var playerPrice: Int
) {
    companion object {
        var playerNames = arrayListOf(
                "Glenn Maxwell",
                "David Warner",
                "Steve Smith",
                "Marcus Stoinis",
                "Kane Williamson",
                "Jimmy Neesham",
                "Jhonny Bairstow",
                "Jos Buttler",
                "Ben Stokes",
                "Jofra Archer",
                "AB de Villers",
                "Faf du Plessis",
                "Virat Kohli",
                "MS Dhoni",
                "Rohit Sharma",
                "Jasprit Bumrah",
                "Hardik Pandya",
                "Sikhar Dhawan",
                "Rishab Pant",
                "Shreyas Iyer"
        )
        var teamNames = arrayListOf(
                "MI" , "CSK" , "RCB" , "KKR" , "RR" , "KXIP" , "DC" , "SRH"
        )
        fun getPlayersList(noOfPlayers: Int): ArrayList<PlayersList> {
            var playersList = ArrayList<PlayersList>()
            for(i in 0 until noOfPlayers) {
                playersList.add(
                        PlayersList(
                                playerNames[Random.nextInt(20)] ,
                                teamNames[Random.nextInt(8)] ,
                                2 + Random.nextInt(15)
                        )
                )
            }
            return playersList
        }
    }
}