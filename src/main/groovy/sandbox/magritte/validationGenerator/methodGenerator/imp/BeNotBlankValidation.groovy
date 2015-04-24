package sandbox.magritte.validationGenerator.methodGenerator.imp
import org.apache.commons.lang.StringUtils
import sandbox.magritte.validationGenerator.Accessor

class BeNotBlankValidation extends BasicValidationMethod{

    @Override
    String defineName(String accessorName) {
        return "Validate ${accessorName} cannot be blank."
    }

    @Override
    Closure defineClosure(Accessor accessor) {
        return {
            if (StringUtils.isBlank(accessor.getValue(delegate))) {
                throw new IllegalArgumentException("${delegate.getClass().getName().toLowerCase()}.validation.${accessor.name}.mandatory.error")
            }
        }
    }
}
