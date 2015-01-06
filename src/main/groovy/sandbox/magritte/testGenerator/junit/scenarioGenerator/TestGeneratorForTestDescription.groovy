package sandbox.magritte.testGenerator.junit.scenarioGenerator
import sandbox.magritte.description.Description
import sandbox.magritte.testGenerator.TestScenario
import sandbox.magritte.testGenerator.description.TestDescription

class TestGeneratorForTestDescription implements TestDescription, TestGenerator {

    Collection<TestScenario> testScenarios = []

    @Override
    def TestDescription descriptionsFor(Class forClass, Description... descriptions) {
        if(forClass == null){
            throw new IllegalArgumentException("Cannot create test scenarios for a TestDescription that do not specify a target class")
        }

        descriptions.each {
            testScenarios.addAll(it.asTestScenariosFor(forClass))
        }

        return this
    }

    Collection<TestScenario> getTestScenarios() {
        return testScenarios
    }
}