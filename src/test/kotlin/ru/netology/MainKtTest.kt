package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun moneyTransferCalculator_Visa_StandartCommission() {  // стандартная комиссия виза
        val moneyTransfer = 15000  // денежный перевод
        val previousTransfersTotal = 0  // предыдущие переводы
        val сardType = "Visa"
        val result = moneyTransferCalculator(moneyTransfer, previousTransfersTotal, сardType)
        assertEquals(112, result)
    }

    @Test
    fun moneyTransferCalculator_MasterCard_NoCommission() {  // мастеркард, маестро без комиссии
        val moneyTransfer = 50000 // денежный перевод
        val previousTransfersTotal = 0  // предыдущие переводы
        val cardType = "MasterCard"
        val result = moneyTransferCalculator(moneyTransfer, previousTransfersTotal, cardType)
        assertEquals(0, result)
    }

    @Test
    fun moneyTransferCalculator_MasterCard_ExceedingTheLimitCommission() { //  мастеркард, маестро комиссия с превышением лимита
        val moneyTransfer = 70000 // денежный перевод
        val previousTransfersTotal = 35000  // предыдущие переводы
        val cardType = "MasterCard"
        val result = moneyTransferCalculator(moneyTransfer, previousTransfersTotal, cardType)
        assertEquals(200, result)
    }

    @Test
    fun moneyTransferCalculator_MasterCard_AlreadyExceededLimit() { // мастеркард, маестро комиссия с уже превышенным предыдущем платежем
        val moneyTransfer = 10000
        val previousTransfersTotal = 80000
        val cardType = "MasterCard"
        val result = moneyTransferCalculator(moneyTransfer, previousTransfersTotal, cardType)
        assertEquals(80, result)
    }

    @Test
    fun moneyTransferCalculator_ExceedingTheDailyLimit() {  //  превышение суточного лимита
        val moneyTransfer = 160000
        val previousTransfersTotal = 0
        val cardType = "MasterCard"
        val result = moneyTransferCalculator(moneyTransfer, previousTransfersTotal, cardType)
        assertEquals(-1, result)
    }

    @Test
    fun moneyTransferCalculator_ExceedingTheMonthlyLimit() {  // превышение месячного лимита
        val moneyTransfer = 630000
        val previousTransfersTotal = 0
        val cardType = "Visa"
        val result = moneyTransferCalculator(moneyTransfer, previousTransfersTotal, cardType)
        assertEquals(-1, result)
    }

    @Test
    fun moneyTransferCalculator_VKpayStandartLimit() { // вкпэй стандартная комиссия
        val moneyTransfer = 5000
        val previousTransfersTotal = 0
        val cardType = "VKpay"
        val result = moneyTransferCalculator(moneyTransfer, previousTransfersTotal, cardType)
        assertEquals(0, result)
    }

    @Test
    fun moneyTransferCalculator_VKpay_ExceedingTheOneTimeLimit() { // вкпэй превышение разового платежа
        val moneyTransfer = 20000
        val previousTransfersTotal = 0
        val cardType = "VKpay"
        val result = moneyTransferCalculator(moneyTransfer, previousTransfersTotal, cardType)
        assertEquals(-1, result)
    }

    @Test
    fun moneyTransferCalculator_VKpay_ExceedingTheMonthlyLimit() { // вкпэй превышение месячного платежа
        val moneyTransfer = 50000
        val previousTransfersTotal = 0
        val cardType = "VKpay"
        val result = moneyTransferCalculator(moneyTransfer, previousTransfersTotal, cardType)
        assertEquals(-1, result)
    }

    @Test
    fun moneyTransferCalculator_Visa_MinimumCommission(){  //виза минимальная комиссия
        val moneyTransfer = 1000
        val previousTransfersTotal = 0
        val cardType = "Visa"
        val result = moneyTransferCalculator(moneyTransfer, previousTransfersTotal, cardType)
        assertEquals(35, result)
    }

}