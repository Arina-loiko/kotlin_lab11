package example

sealed class NetworkResult {
    data class Success(val data: String) : NetworkResult()
    data class Error(val message: String, val code: Int) : NetworkResult()
    object Loading : NetworkResult()
}

fun handleResult(result: NetworkResult) {
    when (result) {
        is NetworkResult.Success -> {
            println("Успех: ${result.data}")
        }
        is NetworkResult.Error -> {
            println("Ошибка ${result.code}: ${result.message}")
        }
        NetworkResult.Loading -> {
            println("Загрузка...")
        }
    }
}

sealed class OrderStatus {
    object Created : OrderStatus()
    object Paid : OrderStatus()
    object Shipped : OrderStatus()
    data class Cancelled(val reason: String) : OrderStatus()
}

fun handleOrder(status: OrderStatus) {
    when (status) {
        OrderStatus.Created -> println("Заказ создан")
        OrderStatus.Paid -> println("Заказ оплачен")
        OrderStatus.Shipped -> println("Заказ отправлен")
        is OrderStatus.Cancelled -> println("Отменён: ${status.reason}")
    }
}

fun main() {
    handleOrder(status = OrderStatus.Created)
    handleOrder(status = OrderStatus.Paid)
    handleOrder(status = OrderStatus.Shipped)
    handleOrder(status = OrderStatus.Cancelled(reason = "Нет товара на складе"))
}
