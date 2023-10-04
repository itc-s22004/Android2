package jp.ac.it_college.std.s22004.asyncsample

data class City (
    val name: String,
    val q: String
)

val cityList = listOf(
    City("大阪", "Osaka"),
    City("東京", "tokyo"),
    City("沖縄", "okinawa"),
    City("神戸","koube"),
    City("大津","ootu"),
    City("愛知","aichi"),
    City("神奈川","kanagawa"),
    City("新潟","niigata"),
)