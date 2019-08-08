import csv.*

class BootStrap {
    def init = { servletContext ->
        new Book(title: 'Groovy for Domain-Specific Languages', author: 'Fergal Dearle').save()
        new Book(title: 'Programming Groovy 2: Dynamic Productivity for the Java Developer', author: 'Venkat Subramaniam').save()
    }
    def destroy = {
    }
}
