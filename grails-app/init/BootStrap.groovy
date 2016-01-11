import com.Person

class BootStrap {

    def init = { servletContext ->
        if (!Person.count()) {
            new Person(firstName: "Vijay", lastName: "Shukla", age: 25).save()
            new Person(firstName: "Karan", lastName: "Aahuja", age: 30).save()
        }
    }
    def destroy = {
    }
}
