package csvdownload

import grails.config.Config
import grails.core.support.GrailsConfigurationAware

import static org.springframework.http.HttpStatus.OK

class BookController implements GrailsConfigurationAware {

    String csvMimeType

    String encoding

    def index() {
        final String filename = 'book.csv'
        def lines = Book.findAll().collect { [it.title, it.author].join(';') } as List<String>

        def outs = response.outputStream
        response.status = OK.value()
        response.contentType = "${csvMimeType};charset=${encoding}";
        response.setHeader "Content-disposition", "attachment; filename=${filename}"

        lines.each { String line ->
            outs << "${line}\n"
        }

        outs.flush()
        outs.close()
    }

    @Override
    void setConfiguration(Config co) {
        csvMimeType = co.getProperty('grails.mime.types.csv', String, 'text/csv')
        encoding = co.getProperty('grails.converters.encoding', String, 'UTF-8')

    }
}
