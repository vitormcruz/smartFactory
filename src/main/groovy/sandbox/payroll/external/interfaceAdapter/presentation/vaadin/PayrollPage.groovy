package sandbox.payroll.external.interfaceAdapter.presentation.vaadin
import com.vaadin.ui.AbsoluteLayout
import com.vaadin.ui.Button
import sandbox.payroll.imp.EmployeeImp

class PayrollPage extends AbsoluteLayout {

    PayrollPage() {
        def employee = new EmployeeImp(name: "Vitor", address: "rua 1", email: "bla@bla.com")
        this.addComponent(employee.asVaadinComponent())
        def button = new Button("Save")
        button.addClickListener({employee.teste()})
        this.addComponent(button)
    }
}