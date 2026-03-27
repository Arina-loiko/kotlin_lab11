package gameCharacter

sealed class CharacterState {
    object Idle : CharacterState()
    object Running : CharacterState()
    data class Attacking(val damage: Int) : CharacterState()
    data class Dead(val cause: String) : CharacterState()
}
