dependency-injection
====================

A Maven multi-project example of dependency injection implemented ad-hoc (with Reflection), using Spring and using JavaEE.

Only for educational purposes.

dependency-injection-model
==========================
 * Includes a simple POJO model with a class Project and differents types of Employees.
 * ProjectRepository: an interface with a JSON implementation that recover a list of projects from a "projects.json" file.

dependency-injection-base
=========================
 * A simple Java project with a ProjectDAO and a ServiceDAO and Unit Test for each layer. This example doesn't use dependency injection design pattern. The objects are instanciated using the classical "new" java operator.

dependency-injection-adhoc
==========================
 * A simple Java project that implements dependency injection design pattern in an ad-hoc way using reflection meta-programming.

dependency-injection-spring
===========================
 * The same example of ProjectDAO and ProjectService, but implementing dependency injection using Spring Framework. It doesn't requires any application server.

dependency-injection-javaee
===========================
 * The same example of ProjectDAO and ProjectService, but implementing dependency injection using JavaEE/CDI Weld implementation, with the SE standaole mode that it doesn't requires any application server.

All projects are implemented with JUnit tests.


 

