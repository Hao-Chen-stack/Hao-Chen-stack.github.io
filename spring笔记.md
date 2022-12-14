### 简介

Spring是一个轻量级的控制反转(IoC)和面向切面(AOP)的容器框架。

**控制反转（IOC）**：是面向对象编程中的一种设计原则，可以用来减低计算机代码之间的耦合度。将**对象的创建**权力交付给spring容器实现，我们在使用对象时直接从容器获取。

**面向切面（AOP）**：通过分离应用的业务逻辑与系统级服务进行内聚性的开发。在不改变源代码的基础上添加新的业务功能逻辑。核心原理是使用动态代理模式在方法执行前后或出现异常时加入相关逻辑。

### 三大核心思想

**AOP（面向切面）、IOC（控制反转）、DI（依赖注入）**

AOP（面向切面）：基于OOP（面向对象）基础之上进行横向开发

​	优点：提高代码的可重用性、业务代码编码更简洁、业务代码维护更高效、业务功能扩展更便捷

IOC（控制反转）：传统模式中，资源的主控权在类中，类需要哪一项资源直接就自己创建出来。在IOC模式下，类所需要的资源统一由spring提供，主动变被动。

DI（依赖注入）：应用程序运行依赖的资源由spring为其提供，资源进入应用程序的方式称为注入

​	（eg：DI是IOC的一种体现形式）

### 七大模块

Spring core：这是Spring框架最基础的部分，它提供了依赖注入（DependencyInjection）特征来实现容器对Bean的管理。

Spring context：基于bean，提供上下文信息。这个模块扩展了BeanFactory的概念，增加了对国际化（I18N）消息、事件传播以及验证的支持。

Spring dao：提供JDBC的抽象层，消除冗长的JDBC编码和解析数据工厂特有的错误，提供事务管理

Spring orm：提供了常用的“对象/关系”映射API的集成层。包括Hibernate、Mybatis等

Spring aop：提供了对面向切面编程的丰富支持。

Spring web：提供了基础的web开发的上下文信息，可与其他web进行集成

Spring web MVC：提供了web应用的model-view-controller全功能的实现

### 事务的实现方式

spring事务实现的方式分为两种：编程式事务管理、声明式事务管理

​	**编程式事务** ：在代码中进行事务控制。优点：精度高。缺点：代码耦合度高

​	**声明式事务** ：通过@Transactional注解实现事务控制

事务的操作本来应该由数据库进行控制，但是为了方便用户进行业务逻辑的控制，spring对事务功能进行了扩展实现。

Spring的事务管理是通过AOP代理实现的，对被代理对象的每个方法进行拦截，在方法执行前启动事务，在方法执行完成后根据是否有异常及异常的类型进行提交或回滚。

**实现原理** ：当在某个类或者方法上使用@Transactional注解后，spring会基于该类生成一个代理对象，并将这个代理对象作为bean。当调用这个代理对象的方法时，如果有事务处理，则会先关闭事务的自动功能，然后执行方法的具体业务逻辑，如果业务逻辑没有异常，那么代理逻辑就会直接提交，如果出现任何异常，那么直接进行回滚操作。当然我们也可以控制对哪些异常进行回滚操作。