package sandbox.magritte.validationGenerator.methodGenerator.imp
import org.apache.commons.validator.routines.CodeValidator
import sandbox.magritte.methodGenerator.imp.SimpleGeneratedMethod
import sandbox.validator.imp.ValidatorTrait

class MaxSizeValidationMethod extends SimpleGeneratedMethod {
    
    MaxSizeValidationMethod() {
    }

    MaxSizeValidationMethod(accessor, maxSize) {
        super.methodName = "Validate ${accessor} has no more than ${maxSize} characters."
        super.clojure = {
            def value = delegate."${accessor}"
            if (! new CodeValidator("", 0, maxSize, null).isValid(value)) {
                throw new IllegalArgumentException("${delegate.getClass().getSimpleName().toLowerCase()}.validation.${accessor}.maxsize.error")
            }
        }
    }
}