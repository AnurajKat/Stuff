# Stuff

As of 16-05-2022 it has 2 working modules.
I'll aim to make them as modular as possible per my capacity.
 
 - Stuff-Api-Doc
 - Stuff-SpringBoot

## Stuff-Api-Doc
It meant to be used as a Api Specification and generates Server Stub Codegen from the specifications to be later used by the Stuff-SpringBoot

## Stuff-SpringBoot
Implements the API specifications.

## Stuff-Templates
playground for Apache FOP.
Apache FOP is being used to create pdfs from xml files.

# In Progress
- Apache Fop in Stuff-Templates
- Integrate use of properties file in Stuff-Templates.
  - Probably creating custom annotation just like `@Value` in Spring
  - apache commons-configuration as plan B when I'll get too frustrated of custom annotation.

# TODO
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
