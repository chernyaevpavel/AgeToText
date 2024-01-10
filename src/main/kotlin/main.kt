fun main() {
    for (i in 0..60) {
        println(agoToText(i * 60))
    }
    for (i in 1..24) {
        println(agoToText(i * 60 * 60))
    }
}

fun agoToText(seconds: Int): String {
    return "был(а) в сети " + when {
        //тут бы неплохо еще обработать значение меньше 0, в java я бы выбросил exeption...
        //поэтому пока тот, кто прислал меньше нуля, сам дурак и уйдет в else
        seconds < 61 -> "только что"
        seconds < 60 * 60 + 1 -> "${secondsToMinutes(seconds)} назад"
        seconds < 60 * 60 * 24 + 1 -> "${secondsToHours(seconds)} назад"
        seconds < 60 * 60 * 48 + 1 -> "вчера"
        seconds < 60 * 60 * 64 + 1 -> "позавчера"
        else -> "давно"
    }
}

fun secondsToMinutes(seconds: Int): String {
    var minutes = seconds / 60
    if (minutes in 5..20) return "$minutes минут"
    var remainder = minutes % 10
    return "$minutes " + when (remainder) {
        1 -> "минуту"
        2, 3, 4 -> "минуты"
        else -> "минут"
    }
}

fun secondsToHours(seconds: Int): String {
    val hours = seconds / 3600
    return "$hours " + when (hours) {
        1, 21 -> "час"
        2, 3, 4, 22, 23, 24 -> "часа"
        else -> "часов"
    }
}