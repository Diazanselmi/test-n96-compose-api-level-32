package cl.multicaja.klapcomercio.signup.juridical.welcomescreen.util

fun validateRUT(rut: String): Boolean {
    if (!rut.matches(Regex("^[0-9]{1,2}(.?[0-9]{3}){2}-?[0-9kK]"))) {
        return false
    }

    val firstPartCharacterRut = rut.lowercase().replace(Regex("[-.]"), "")
    val lastCharacterRut = firstPartCharacterRut.takeLast(1)
    var sum = 0
    var indexRut = 0
    for (x in firstPartCharacterRut.dropLast(1).reversed()) {
        sum += (x.toString().toInt() * ((indexRut % 6) + 2))
        indexRut += 1
    }

    val verifierDigit = 11 - (sum % 11)
    return (if (verifierDigit == 11) 0 else verifierDigit) == (if (lastCharacterRut == "k") 10 else lastCharacterRut.toInt())
}


fun formatterRut(rut: String): String {
    val separator = "-"
    val rutFirst = rut.substring(0, rut.length - 1)
    val dv = rut.substring(rut.length - 1)
    return rutFirst + separator + dv
}

fun reFormatRut(rut: String): String {
    val cleanRut = rut.replace(Regex("[^0-9kK]"), "")
    val numberPart = cleanRut.substring(0, cleanRut.length - 1)
    val verifierPart = cleanRut.last()
    val formattedNumber = numberPart.reversed().chunked(3).joinToString(".").reversed()
    return "$formattedNumber-$verifierPart"
}
