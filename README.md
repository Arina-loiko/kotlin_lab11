# kotlin_lab11

## Sealed-классы

Sealed-класс - это специальный тип класса, который ограничивает наследование. Все подклассы должны быть в том же файле

Зачем нужны:
- Компилятор знает все варианты заранее
- when без else - если забудешь обработать вариант, будет ошибка компиляции
- Удобно для результатов сети, состояний UI, ошибок

Пример:

```kotlin
sealed class NetworkResult {
    data class Success(val data: String) : NetworkResult()
    data class Error(val message: String, val code: Int) : NetworkResult()
    object Loading : NetworkResult()
}

fun handleResult(result: NetworkResult) {
    when (result) {
        is NetworkResult.Success -> println("Успех: ${result.data}")
        is NetworkResult.Error -> println("Ошибка ${result.code}: ${result.message}")
        NetworkResult.Loading -> println("Загрузка...")
    }
}
```

## Object в Kotlin

Object - это синглтон, то есть класс с одним единственным экземпляром. Создаётся лениво - только при первом обращении

Особенности:
- Всегда один экземпляр на всю программу
- Нельзя создать через конструктор
- Потокобезопасен - создаётся гарантированно один раз

Пример:

```kotlin
object Logger {
    var count = 0
    fun log(message: String) {
        count++
        println("[$count] $message")
    }
}
```

Использование:

```kotlin
Logger.log("Первое сообщение")
Logger.log("Второе сообщение")
val logger1 = Logger
val logger2 = Logger
println(logger1 === logger2) // true
```
