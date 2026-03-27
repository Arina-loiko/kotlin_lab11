package gameCharacter

fun handleState(state: CharacterState) {
    when (state) {
        CharacterState.Idle -> println("Персонаж бездействует")
        CharacterState.Running -> println("Персонаж бежит")
        is CharacterState.Attacking -> println("Персонаж атакует с уроном ${state.damage}")
        is CharacterState.Dead -> println("Персонаж погиб: ${state.cause}")
    }
}

fun main() {
    val character = GameCharacter(name = "Герой")

    character.changeState(CharacterState.Running)
    handleState(character.state)

    character.changeState(CharacterState.Attacking(damage = 50))
    handleState(character.state)

    character.changeState(CharacterState.Dead(cause = "Упал в яму"))
    handleState(character.state)
}
