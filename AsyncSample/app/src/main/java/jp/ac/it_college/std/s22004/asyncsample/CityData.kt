package jp.ac.it_college.std.s22004.asyncsample

data class City (
    val name: String,
    val q: String
)

val cityList = listOf(
    City("京都","Kyoto"),
    City("大阪", "Osaka"),
    City("沖縄", "Naha"),
    City("大津","Otu"),
    City("愛知","Aichi"),
    City("神奈川","Kanagawa"),
    City("新潟","Niigata"),
)