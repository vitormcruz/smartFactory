package sandbox.magritte

class StringDescription extends AbstractVisitableDescription implements MagnitudeDescription {

    @Override
    StringDescription defaultValue(defaultValue) {
        return addConfigurationMessageSend("acessor", [defaultValue])
    }

    @Override
    StringDescription label(label) {
        return addConfigurationMessageSend("label", label)
    }

    //TODO Create test and implement this method
    @Override
    Description maxSize(Integer maxSize) {
        return null
    }
}
