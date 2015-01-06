package sandbox.validator
import org.junit.After
import org.junit.Before
import org.junit.runner.Description
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.model.FrameworkMethod
import org.junit.runners.model.InitializationError
//TODO maybe I should extend ParentRunner.....
//TODO Explain that it should not be used with @RunWith annotation...
class ValidatorRunner extends BlockJUnit4ClassRunner{

    /**
     * Constructs a new instance of the default runner
     */
    private Object objectUnderValidation

    /**
     * Constructs a new ValidationRunner for an object under validation, passed by parameter.
     *
     * This constructor makes it spam an error if anyone tries to execute this with an @RunWith annotation, as it
     * should be.
     */
    ValidatorRunner(Object objectUnderValidation) throws InitializationError {
        super(objectUnderValidation.class)
        this.objectUnderValidation = objectUnderValidation
    }

    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        return getTestClass().getAnnotatedMethods(Validation);
    }

    @Override
    protected void validateInstanceMethods(List<Throwable> errors) {
        /* Wanted the same method without the verification for zero computed test method, i.e., I don't wanna the
        validation to fail just because there are no validation methods, actually, I wanna exactly the contrary.*/
        validatePublicVoidNoArgMethods(After.class, false, errors);
        validatePublicVoidNoArgMethods(Before.class, false, errors);
        validateTestMethods(errors);
    }

    @Override
    protected Description describeChild(FrameworkMethod method) {
        return Description.createTestDescription(getTestClass().getJavaClass(),
                testName(method), method.getAnnotations());
    }

    @Override
    protected Object createTest() throws Exception {
        return objectUnderValidation
    }
}