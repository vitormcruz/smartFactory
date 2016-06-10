package sandbox.payroll
import sandbox.magritte.description.DescriptionModelDefinition
import sandbox.magritte.description.StringDescription
import sandbox.validationNotification.ApplicationValidationNotifier
import sandbox.validationNotification.MandatorySetterValidation

import static sandbox.magritte.description.builder.DescriptionFactory.New

class Employee {

    private static ApplicationValidationNotifier notifier = new ApplicationValidationNotifier()

    private Long id
    def String name
    private MandatorySetterValidation mandatoryNameValidation = new MandatorySetterValidation("employee.name", "payroll.employee.name.mandatory")

    def String address
    private MandatorySetterValidation mandatoryAddressValidation = new MandatorySetterValidation("employee.address", "payroll.employee.address.mandatory")

    def String email
    private MandatorySetterValidation mandatoryEmailValidation = new MandatorySetterValidation("employee.email", "payroll.employee.email.mandatory")

    def PaymentMethod paymentMethod

    Employee() {
        notifier.issueMandatoryObligation("employee.name", "payroll.employee.name.mandatory")
        notifier.issueMandatoryObligation("employee.address", "payroll.employee.address.mandatory")
        notifier.issueMandatoryObligation("employee.email", "payroll.employee.email.mandatory")
    }

    Long getId() {
        return id
    }

    void setName(String name) {
        if(mandatoryNameValidation.canSet(name)){
            this.name = name
        }
    }

    void setAddress(String address) {
        if(mandatoryAddressValidation.canSet(address)){
            this.address = address
        }
    }

    void setEmail(String email) {
        if(mandatoryEmailValidation.canSet(email)){
            this.email = email
        }
    }

    void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod
    }

    @DescriptionModelDefinition
    public myDescription(){

        /**
         * "setName".parameters(
         *         FIRST.isAString().required()
         *         SECOND.isAString().required().maxSize(200))
         *
         * "setName".parameters(
         *         FIRST.isAString().required()
         *         SECOND.isAString().required().maxSize(200)
         *
         *
         * setName message has
         *
         */

        return [New(StringDescription).accessor("name").maxSize(50).label("employee.name").beRequired(),
                New(StringDescription).accessor("address").maxSize(200).label("employee.address").beRequired(),
                New(StringDescription).accessor("email").maxSize(100).label("employee.email").beRequired()]
    }
}
