package jp.ac.it_college.std.s22004.poketeacher.model


data class PokeQuiz(
    val imageUrl: String,
    val choices: List<String>,
    val correct: String
)