package ru.netology

fun main() {
    println("Работу выполнил Александр Евстропов")

    val totalDiscount = moneyTransferCalculator(15000)
    println(totalDiscount)

}

fun commission(CardType: String) {
    when (CardType) {
        "MasterCard" -> 0.006 + 20
        "Maestro" -> 0.006 + 20
        "Visa" -> 0.0075
        "Mir" -> 0.0075
        "VKpay" -> 0

    }
}

fun moneyTransferCalculator(
    moneyTransfer: Int,  // денежный перевод
    previousTransfersTotal: Int = 0,  // предыдущие переводы
    cardType: String = "Visa" //тип карты
): Int {

    val totalTransfer = moneyTransfer + previousTransfersTotal
    if (totalTransfer > 150000) {
        println("Превышен суточный лимит переводов")
        return -1
    }
    if (totalTransfer > 600000) {
        println("Превышен месячный лимит переводов")
        return -1
    }

    return when (cardType) {
        "MasterCard", "Maestro" -> {
            when {
                previousTransfersTotal >= 75000 ->
                    (moneyTransfer * 0.006 + 20).toInt()

                totalTransfer <= 75000 ->
                    if (moneyTransfer >= 300) 0 else (moneyTransfer * 0.006 + 20).toInt()

                else -> {
                    val excessAmount = totalTransfer - 75000
                    (excessAmount * 0.006 + 20).toInt()
                }
            }
        }

        "Visa", "Mir" -> {
            val commission = (moneyTransfer * 0.0075)
            val finalCommission = if (commission < 35) 35 else commission
            finalCommission.toInt()
        }

        "VKpay" -> {

            if (moneyTransfer > 15000) {
                println("Превышен лимита разового перевода")
                return -1
            } else if (totalTransfer > 40000) {
                println("Превышен месячный лимит переводов")
                return -1
            } else {
                0
            }
        }

        else -> {
            println("Неизвестный тип карты")
            -1
        }

    }

}

