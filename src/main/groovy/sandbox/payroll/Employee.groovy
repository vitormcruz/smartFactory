package sandbox.payroll

import sandbox.magritte.DescriptionContainer
import sandbox.magritte.DescriptionMethod
import sandbox.magritte.StringDescription

import static sandbox.magritte.DescriptionFactory.New
import static sandbox.magritte.DescriptionFactory.newContainer

class Employee {

    def String name
    def String address
    def String email

    //TODO how to use only Interfaces? Such as IDescriptionContainter.new().acessor...? Or maby a global variable (coud be configured by spring, but I want to avoid that)
    @DescriptionMethod
    public myDescription(){
        return newContainer(DescriptionContainer, New(StringDescription).acessor("name").label("employee.name"),
                                                   New(StringDescription).acessor("address").label("employee.address"),
                                                   New(StringDescription).acessor("email").label("employee.email"))
    }

    def Collection<String> validate(){
        //TODO change for validation api based on description
        if(name.length() > 100){
            return ["employee.validation.name.maxsize.error"]
        }
        return []
    }

}
