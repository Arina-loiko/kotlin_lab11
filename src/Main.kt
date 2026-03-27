import modules.EnergyGenerator
import modules.ModuleResult
import modules.OutpostResource
import modules.ResearchLab
import modules.ResourceManager

fun handleModuleResult(result: ModuleResult) {
    when (result) {
        is ModuleResult.Success ->
            println("УСПЕХ: ${result.message}")
        is ModuleResult.ResourceProduced ->
            println("Произведено: ${result.resourceName} +${result.amount}")
        is ModuleResult.NotEnoughResources ->
            println(
                "Недостаточно ресурса ${result.resourceName}. " +
                        "Нужно: ${result.required}, есть: ${result.available}"
            )
        is ModuleResult.Error ->
            println("ОШИБКА: ${result.reason}")
    }
}

fun main() {
    val manager = ResourceManager()
    manager.add(OutpostResource(id = 1, name = "Minerals", amount = 300))
    manager.add(OutpostResource(id = 2, name = "Gas", amount = 100))

    val generator = EnergyGenerator()
    val lab = ResearchLab()

    val generatorResult = generator.performAction(manager)
    val labResult = lab.performAction(manager)

    handleModuleResult(generatorResult)
    handleModuleResult(labResult)

    println()
    manager.printAll()
}
