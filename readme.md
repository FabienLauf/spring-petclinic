# Spring Boot version of the Spring PetClinic Sample Application

## What does it look like?
-spring-petclinic has been deployed here on cloudfoundry: http://demo-spring-petclinic.cfapps.io/

## Running petclinic locally with Spring Boot
```
	git clone https://github.com/FabienLauf/spring-petclinic.git
	mvn spring-boot:run
```

You can then access petclinic here: http://localhost:9966/petclinic/

## Working with Petclinic in Eclipse/STS

### prerequisites
The following items should be installed in your system:
* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/


### Steps:

1) In the command line
```
git clone https://github.com/FabienLauf/spring-petclinic.git
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project
```
3) Start the application
```
Open spring-petclinic/src/main/java/org.springframework.samples.petclinic.application
Right click on PetClinicApplication.java -> Run as -> Java application
```

## Looking for something in particular?

<table>
  <tr>
    <th width="300px">The Spring Boot configuration</th><th width="300px">Files</th>
  </tr>
  <tr>
    <td>The Main Class</td>
    <td>
      <a href="/src/main/java/org/springframework/samples/petclinic/application/PetClinicApplication.java">PetClinicApplication.java</a>
    </td>
  </tr>
  <tr>
    <td>Dandelion Datatables</td>
    <td>
      <a href="/src/main/java/org/springframework/samples/petclinic/configuration/DandelionConfiguration.java">DandelionConfiguration.java</a>
    </td>
  </tr>
  <tr>
    <td>Spring MVC- Atom and XML integration</td>
    <td>
      <a href="/src/main/java/org/springframework/samples/petclinic/configuration/CustomViewsConfiguration.java">CustomViewsConfiguration.java</a>
    </td>
  </tr>
  <tr>
    <td>Properties Files</td>
    <td>
      <a href="/src/main/resources/application.properties">application.properties</a>
    </td>
  </tr>
  <tr>
    <td>Caching</td>
    <td>Use of EhCache <a href="/src/main/java/org/springframework/samples/petclinic/configuration/CachingConfiguration.java">CachingConfiguration.java</a>
  </tr>
  <tr>
    <td>Testing</td>
    <td>Use of @SpringApplicationConfiguration for setting the context and @WebAppConfiguration for web tests.
  </tr>
</table>

