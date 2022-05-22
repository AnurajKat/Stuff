# Stuff

As of 16-05-2022 it has 2 working modules.
I'll aim to make them as modular as possible per my capacity.
 
 - Stuff-Api-Doc
 - Stuff-SpringBoot
 - Stuff-Templates
 - Stuff-common

## Stuff-Api-Doc
It meant to be used as a Api Specification and generates Server Stub Codegen from the specifications to be later used by the Stuff-SpringBoot

## Stuff-SpringBoot
Implements the API specifications.

## Stuff-Templates
- playground for Apache FOP and OpenHtmlToPdf.
- Apache FOP is being used to create pdfs from xml files.
- Will like refactor the module to Stuff-Render and Keep Stuff-Templates for actual templates.

## Stuff-common
- Contains common utils and custom errors.

# In Progress
- ~~Apache Fop in Stuff-Templates~~ Shift to [openHtmlToPdf](https://github.com/danfickle/openhtmltopdf)
  - openHtmlToPdf leverages HTML ands CSS standards for template.
  - No restrictions on data source format (XML in case of FOP) . Support for different data source needs to be implemented.
- Integrate use of properties file in Stuff-Templates.
  - ~~Probably creating custom annotation just like `@Value` in Spring~~ Going with plan B.
  - apache commons-configuration as plan B when I'll get too frustrated of custom annotation.

# TODO
- Shift Property Reader to another module. probably create a new to store all utils.
- Make Useless API somewhat useful or create some useful api
- Template module for HTML pages and probably pdfs
- Module to generate Docker images of the Service
- Database integration????
- Authentication stuff
  - sessions and stuff
  - possibly with usage of jwt
- Use Apache Velocity with FOP
- retrieve PDF file from API

# RESOURCES

- [Issues faced](src/main/resources/Issues.md)
- [Apache FOP example](https://www.netjstech.com/2015/07/how-to-create-pdf-from-xml-using-apache-fop.html)
- [github : Apache FOP with custom font example](https://github.com/savva-k/apache-fop-example)
- [blog: Apache FOP with font example](https://imsavva.com/generating-pdf-with-apache-fop-and-maven-tutorial/)
- [tutorial: OpenHtmlToPDf](https://knpcode.com/java-programs/convert-html-to-pdf-in-java-using-openhtmltopdf-pdfbox/)
- 
