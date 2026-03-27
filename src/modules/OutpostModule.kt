package modules

abstract class OutpostModule(val name: String) {
    abstract fun performAction(manager: ResourceManager): ModuleResult
}
