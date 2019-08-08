import csvdownload.*

class BootStrap {
    def init = { servletContext ->
        (0..10000).each {
            new Book(title: 'Groovy for Domain-Specific Languages', author: 'Fergal Dearle').save()
            new Book(title: 'Programming Groovy 2: Dynamic Productivity for the Java Developer', author: 'Venkat Subramaniam').save()
        }
    }
    def destroy = {
    }
}
