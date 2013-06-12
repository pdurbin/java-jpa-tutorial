An environment for running http://svn.apache.org/viewvc/openjpa/trunk/openjpa-examples (especially image-gallery) from http://openjpa.apache.org to help learn the Java Persistence API (JPA)

## Setup

- clone this repo
- vagrant up
- vagrant ssh
- cd /downloads
- ./download.sh
- unzip apache-openjpa-2.2.2-binary.zip
- mkdir /downloads/apache-openjpa-2.2.2/openjpa-project
- cp /downloads/checkstyle.xml /downloads/apache-openjpa-2.2.2/openjpa-project/checkstyle.xml
- cd /downloads/apache-openjpa-2.2.2/examples/image-gallery
- mvn test
- "BUILD SUCCESS" is expected

## Notes 

On OS X Lion (10.8.2) I get the error below. See also [#OPENJPA-1996] OpenJPA Samples fail on MacOS X - ASF JIRA - https://issues.apache.org/jira/browse/OPENJPA-1996

    murphy:hellojpa pdurbin$ ant
    Buildfile: /private/tmp/apache-openjpa-2.2.2/examples/simple/hellojpa/build.xml

    pre-compile:

    compile:
        [javac] Compiling 2 source files

    run:
         [echo] classpath: hellojpa.Main.classpath
         [java] Exception in thread "main" <openjpa-2.2.2-r422266:1468616 nonfatal general error> org.apache.openjpa.persistence.PersistenceException: There were errors initializing your configuration: <openjpa-2.2.2-r422266:1468616 fatal user error> org.apache.openjpa.util.UserException: A connection could not be obtained for driver class "org.apache.derby.jdbc.EmbeddedDriver" and URL "jdbc:derby:/private/tmp/apache-openjpa-2.2.2/examples/simple/hellojpa/hellojpa-database;create=true".  You may have specified an invalid URL.
         [java]     at org.apache.openjpa.jdbc.schema.DataSourceFactory.newConnectException(DataSourceFactory.java:255)
         [java]     at org.apache.openjpa.jdbc.schema.DataSourceFactory.installDBDictionary(DataSourceFactory.java:241)
         [java]     at org.apache.openjpa.jdbc.conf.JDBCConfigurationImpl.getConnectionFactory(JDBCConfigurationImpl.java:733)
         [java]     at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
         [java]     at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)
         [java]     at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
         [java]     at java.lang.reflect.Method.invoke(Method.java:597)
         [java]     at org.apache.openjpa.lib.conf.ConfigurationImpl.instantiateAll(ConfigurationImpl.java:306)
         [java]     at org.apache.openjpa.conf.OpenJPAConfigurationImpl.instantiateAll(OpenJPAConfigurationImpl.java:1670)
         [java]     at org.apache.openjpa.kernel.AbstractBrokerFactory.makeReadOnly(AbstractBrokerFactory.java:652)
         [java]     at org.apache.openjpa.kernel.AbstractBrokerFactory.newBroker(AbstractBrokerFactory.java:203)
         [java]     at org.apache.openjpa.kernel.DelegatingBrokerFactory.newBroker(DelegatingBrokerFactory.java:156)
         [java]     at org.apache.openjpa.persistence.EntityManagerFactoryImpl.createEntityManager(EntityManagerFactoryImpl.java:227)
         [java]     at org.apache.openjpa.persistence.EntityManagerFactoryImpl.createEntityManager(EntityManagerFactoryImpl.java:154)
         [java]     at org.apache.openjpa.persistence.EntityManagerFactoryImpl.createEntityManager(EntityManagerFactoryImpl.java:60)
         [java]     at hellojpa.Main.main(Main.java:43)
         [java] Caused by: org.apache.commons.dbcp.SQLNestedException: Cannot create PoolableConnectionFactory (Failed to create database '/private/tmp/apache-openjpa-2.2.2/examples/simple/hellojpa/hellojpa-database', see the next exception for details.)
         [java]     at org.apache.commons.dbcp.BasicDataSource.createPoolableConnectionFactory(BasicDataSource.java:1549)
         [java]     at org.apache.commons.dbcp.BasicDataSource.createDataSource(BasicDataSource.java:1388)
         [java]     at org.apache.commons.dbcp.BasicDataSource.getConnection(BasicDataSource.java:1044)
         [java]     at org.apache.openjpa.jdbc.schema.DBCPDriverDataSource.getDBCPConnection(DBCPDriverDataSource.java:74)
         [java]     at org.apache.openjpa.jdbc.schema.AutoDriverDataSource.getConnection(AutoDriverDataSource.java:42)
         [java]     at org.apache.openjpa.jdbc.schema.SimpleDriverDataSource.getConnection(SimpleDriverDataSource.java:76)
         [java]     at org.apache.openjpa.lib.jdbc.DelegatingDataSource.getConnection(DelegatingDataSource.java:118)
         [java]     at org.apache.openjpa.lib.jdbc.DecoratingDataSource.getConnection(DecoratingDataSource.java:93)
         [java]     at org.apache.openjpa.jdbc.schema.DataSourceFactory.installDBDictionary(DataSourceFactory.java:233)
         [java]     ... 14 more
         [java] Caused by: java.sql.SQLException: Failed to create database '/private/tmp/apache-openjpa-2.2.2/examples/simple/hellojpa/hellojpa-database', see the next exception for details.
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.newEmbedSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.seeNextException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.EmbedConnection.createDatabase(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.EmbedConnection.<init>(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.EmbedConnection30.<init>(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.EmbedConnection40.<init>(Unknown Source)
         [java]     at org.apache.derby.jdbc.Driver40.getNewEmbedConnection(Unknown Source)
         [java]     at org.apache.derby.jdbc.InternalDriver.connect(Unknown Source)
         [java]     at org.apache.derby.jdbc.AutoloadedDriver.connect(Unknown Source)
         [java]     at org.apache.commons.dbcp.DriverConnectionFactory.createConnection(DriverConnectionFactory.java:38)
         [java]     at org.apache.commons.dbcp.PoolableConnectionFactory.makeObject(PoolableConnectionFactory.java:582)
         [java]     at org.apache.commons.dbcp.BasicDataSource.validateConnectionFactory(BasicDataSource.java:1556)
         [java]     at org.apache.commons.dbcp.BasicDataSource.createPoolableConnectionFactory(BasicDataSource.java:1545)
         [java]     ... 22 more
         [java] Caused by: java.sql.SQLException: Failed to create database '/private/tmp/apache-openjpa-2.2.2/examples/simple/hellojpa/hellojpa-database', see the next exception for details.
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.wrapArgsForTransportAcrossDRDA(Unknown Source)
         [java]     ... 36 more
         [java] Caused by: java.sql.SQLException: Startup failed due to an exception. See next exception for details. 
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.wrapArgsForTransportAcrossDRDA(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.newEmbedSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.seeNextException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.TransactionResourceImpl.wrapInSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.TransactionResourceImpl.handleException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.EmbedConnection.handleException(Unknown Source)
         [java]     ... 33 more
         [java] Caused by: java.sql.SQLException: Java exception: 'loader (instance of  sun/misc/Launcher$ExtClassLoader): attempted  duplicate class definition for name: "sun/security/pkcs11/SunPKCS11": java.lang.LinkageError'.
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.wrapArgsForTransportAcrossDRDA(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.newEmbedSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.javaException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.TransactionResourceImpl.wrapInSQLException(Unknown Source)
         [java]     ... 36 more
         [java] Caused by: java.lang.LinkageError: loader (instance of  sun/misc/Launcher$ExtClassLoader): attempted  duplicate class definition for name: "sun/security/pkcs11/SunPKCS11"
         [java]     at java.lang.ClassLoader.defineClass1(Native Method)
         [java]     at java.lang.ClassLoader.defineClassCond(ClassLoader.java:631)
         [java]     at java.lang.ClassLoader.defineClass(ClassLoader.java:615)
         [java]     at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:141)
         [java]     at java.net.URLClassLoader.defineClass(URLClassLoader.java:283)
         [java]     at java.net.URLClassLoader.access$000(URLClassLoader.java:58)
         [java]     at java.net.URLClassLoader$1.run(URLClassLoader.java:197)
         [java]     at java.security.AccessController.doPrivileged(Native Method)
         [java]     at java.net.URLClassLoader.findClass(URLClassLoader.java:190)
         [java]     at sun.misc.Launcher$ExtClassLoader.findClass(Launcher.java:229)
         [java]     at java.lang.ClassLoader.loadClass(ClassLoader.java:306)
         [java]     at java.lang.ClassLoader.loadClass(ClassLoader.java:295)
         [java]     at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:301)
         [java]     at java.lang.ClassLoader.loadClass(ClassLoader.java:247)
         [java]     at sun.security.jca.ProviderConfig$4.run(ProviderConfig.java:253)
         [java]     at java.security.AccessController.doPrivileged(Native Method)
         [java]     at sun.security.jca.ProviderConfig.doLoadProvider(ProviderConfig.java:244)
         [java]     at sun.security.jca.ProviderConfig.getProvider(ProviderConfig.java:224)
         [java]     at sun.security.jca.ProviderList.getProvider(ProviderList.java:215)
         [java]     at sun.security.jca.ProviderList.getService(ProviderList.java:313)
         [java]     at sun.security.jca.GetInstance.getInstance(GetInstance.java:140)
         [java]     at java.security.Security.getImpl(Security.java:659)
         [java]     at java.security.MessageDigest.getInstance(MessageDigest.java:129)
         [java]     at org.apache.derby.impl.sql.catalog.DataDictionaryImpl.findDefaultBuiltinAlgorithm(Unknown Source)
         [java]     at org.apache.derby.impl.sql.catalog.DataDictionaryImpl.boot(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.BaseMonitor.boot(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.TopService.bootModule(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.BaseMonitor.startModule(Unknown Source)
         [java]     at org.apache.derby.iapi.services.monitor.Monitor.bootServiceModule(Unknown Source)
         [java]     at org.apache.derby.impl.db.BasicDatabase.boot(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.BaseMonitor.boot(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.TopService.bootModule(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.BaseMonitor.bootService(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.BaseMonitor.createPersistentService(Unknown Source)
         [java]     at org.apache.derby.iapi.services.monitor.Monitor.createPersistentService(Unknown Source)
         [java]     ... 33 more
         [java] 
         [java]     at org.apache.openjpa.kernel.AbstractBrokerFactory.newBroker(AbstractBrokerFactory.java:218)
         [java]     at org.apache.openjpa.kernel.DelegatingBrokerFactory.newBroker(DelegatingBrokerFactory.java:156)
         [java]     at org.apache.openjpa.persistence.EntityManagerFactoryImpl.createEntityManager(EntityManagerFactoryImpl.java:227)
         [java]     at org.apache.openjpa.persistence.EntityManagerFactoryImpl.createEntityManager(EntityManagerFactoryImpl.java:154)
         [java]     at org.apache.openjpa.persistence.EntityManagerFactoryImpl.createEntityManager(EntityManagerFactoryImpl.java:60)
         [java]     at hellojpa.Main.main(Main.java:43)
         [java] Caused by: java.lang.RuntimeException: There were errors initializing your configuration: <openjpa-2.2.2-r422266:1468616 fatal user error> org.apache.openjpa.util.UserException: A connection could not be obtained for driver class "org.apache.derby.jdbc.EmbeddedDriver" and URL "jdbc:derby:/private/tmp/apache-openjpa-2.2.2/examples/simple/hellojpa/hellojpa-database;create=true".  You may have specified an invalid URL.
         [java]     at org.apache.openjpa.jdbc.schema.DataSourceFactory.newConnectException(DataSourceFactory.java:255)
         [java]     at org.apache.openjpa.jdbc.schema.DataSourceFactory.installDBDictionary(DataSourceFactory.java:241)
         [java]     at org.apache.openjpa.jdbc.conf.JDBCConfigurationImpl.getConnectionFactory(JDBCConfigurationImpl.java:733)
         [java]     at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
         [java]     at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:39)
         [java]     at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:25)
         [java]     at java.lang.reflect.Method.invoke(Method.java:597)
         [java]     at org.apache.openjpa.lib.conf.ConfigurationImpl.instantiateAll(ConfigurationImpl.java:306)
         [java]     at org.apache.openjpa.conf.OpenJPAConfigurationImpl.instantiateAll(OpenJPAConfigurationImpl.java:1670)
         [java]     at org.apache.openjpa.kernel.AbstractBrokerFactory.makeReadOnly(AbstractBrokerFactory.java:652)
         [java]     at org.apache.openjpa.kernel.AbstractBrokerFactory.newBroker(AbstractBrokerFactory.java:203)
         [java]     at org.apache.openjpa.kernel.DelegatingBrokerFactory.newBroker(DelegatingBrokerFactory.java:156)
         [java]     at org.apache.openjpa.persistence.EntityManagerFactoryImpl.createEntityManager(EntityManagerFactoryImpl.java:227)
         [java]     at org.apache.openjpa.persistence.EntityManagerFactoryImpl.createEntityManager(EntityManagerFactoryImpl.java:154)
         [java]     at org.apache.openjpa.persistence.EntityManagerFactoryImpl.createEntityManager(EntityManagerFactoryImpl.java:60)
         [java]     at hellojpa.Main.main(Main.java:43)
         [java] Caused by: org.apache.commons.dbcp.SQLNestedException: Cannot create PoolableConnectionFactory (Failed to create database '/private/tmp/apache-openjpa-2.2.2/examples/simple/hellojpa/hellojpa-database', see the next exception for details.)
         [java]     at org.apache.commons.dbcp.BasicDataSource.createPoolableConnectionFactory(BasicDataSource.java:1549)
         [java]     at org.apache.commons.dbcp.BasicDataSource.createDataSource(BasicDataSource.java:1388)
         [java]     at org.apache.commons.dbcp.BasicDataSource.getConnection(BasicDataSource.java:1044)
         [java]     at org.apache.openjpa.jdbc.schema.DBCPDriverDataSource.getDBCPConnection(DBCPDriverDataSource.java:74)
         [java]     at org.apache.openjpa.jdbc.schema.AutoDriverDataSource.getConnection(AutoDriverDataSource.java:42)
         [java]     at org.apache.openjpa.jdbc.schema.SimpleDriverDataSource.getConnection(SimpleDriverDataSource.java:76)
         [java]     at org.apache.openjpa.lib.jdbc.DelegatingDataSource.getConnection(DelegatingDataSource.java:118)
         [java]     at org.apache.openjpa.lib.jdbc.DecoratingDataSource.getConnection(DecoratingDataSource.java:93)
         [java]     at org.apache.openjpa.jdbc.schema.DataSourceFactory.installDBDictionary(DataSourceFactory.java:233)
         [java]     ... 14 more
         [java] Caused by: java.sql.SQLException: Failed to create database '/private/tmp/apache-openjpa-2.2.2/examples/simple/hellojpa/hellojpa-database', see the next exception for details.
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.newEmbedSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.seeNextException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.EmbedConnection.createDatabase(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.EmbedConnection.<init>(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.EmbedConnection30.<init>(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.EmbedConnection40.<init>(Unknown Source)
         [java]     at org.apache.derby.jdbc.Driver40.getNewEmbedConnection(Unknown Source)
         [java]     at org.apache.derby.jdbc.InternalDriver.connect(Unknown Source)
         [java]     at org.apache.derby.jdbc.AutoloadedDriver.connect(Unknown Source)
         [java]     at org.apache.commons.dbcp.DriverConnectionFactory.createConnection(DriverConnectionFactory.java:38)
         [java]     at org.apache.commons.dbcp.PoolableConnectionFactory.makeObject(PoolableConnectionFactory.java:582)
         [java]     at org.apache.commons.dbcp.BasicDataSource.validateConnectionFactory(BasicDataSource.java:1556)
         [java]     at org.apache.commons.dbcp.BasicDataSource.createPoolableConnectionFactory(BasicDataSource.java:1545)
         [java]     ... 22 more
         [java] Caused by: java.sql.SQLException: Failed to create database '/private/tmp/apache-openjpa-2.2.2/examples/simple/hellojpa/hellojpa-database', see the next exception for details.
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.wrapArgsForTransportAcrossDRDA(Unknown Source)
         [java]     ... 36 more
         [java] Caused by: java.sql.SQLException: Startup failed due to an exception. See next exception for details. 
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.wrapArgsForTransportAcrossDRDA(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.newEmbedSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.seeNextException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.TransactionResourceImpl.wrapInSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.TransactionResourceImpl.handleException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.EmbedConnection.handleException(Unknown Source)
         [java]     ... 33 more
         [java] Caused by: java.sql.SQLException: Java exception: 'loader (instance of  sun/misc/Launcher$ExtClassLoader): attempted  duplicate class definition for name: "sun/security/pkcs11/SunPKCS11": java.lang.LinkageError'.
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.wrapArgsForTransportAcrossDRDA(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.SQLExceptionFactory40.getSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.newEmbedSQLException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.Util.javaException(Unknown Source)
         [java]     at org.apache.derby.impl.jdbc.TransactionResourceImpl.wrapInSQLException(Unknown Source)
         [java]     ... 36 more
         [java] Caused by: java.lang.LinkageError: loader (instance of  sun/misc/Launcher$ExtClassLoader): attempted  duplicate class definition for name: "sun/security/pkcs11/SunPKCS11"
         [java]     at java.lang.ClassLoader.defineClass1(Native Method)
         [java]     at java.lang.ClassLoader.defineClassCond(ClassLoader.java:631)
         [java]     at java.lang.ClassLoader.defineClass(ClassLoader.java:615)
         [java]     at java.security.SecureClassLoader.defineClass(SecureClassLoader.java:141)
         [java]     at java.net.URLClassLoader.defineClass(URLClassLoader.java:283)
         [java]     at java.net.URLClassLoader.access$000(URLClassLoader.java:58)
         [java]     at java.net.URLClassLoader$1.run(URLClassLoader.java:197)
         [java]     at java.security.AccessController.doPrivileged(Native Method)
         [java]     at java.net.URLClassLoader.findClass(URLClassLoader.java:190)
         [java]     at sun.misc.Launcher$ExtClassLoader.findClass(Launcher.java:229)
         [java]     at java.lang.ClassLoader.loadClass(ClassLoader.java:306)
         [java]     at java.lang.ClassLoader.loadClass(ClassLoader.java:295)
         [java]     at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:301)
         [java]     at java.lang.ClassLoader.loadClass(ClassLoader.java:247)
         [java]     at sun.security.jca.ProviderConfig$4.run(ProviderConfig.java:253)
         [java]     at java.security.AccessController.doPrivileged(Native Method)
         [java]     at sun.security.jca.ProviderConfig.doLoadProvider(ProviderConfig.java:244)
         [java]     at sun.security.jca.ProviderConfig.getProvider(ProviderConfig.java:224)
         [java]     at sun.security.jca.ProviderList.getProvider(ProviderList.java:215)
         [java]     at sun.security.jca.ProviderList.getService(ProviderList.java:313)
         [java]     at sun.security.jca.GetInstance.getInstance(GetInstance.java:140)
         [java]     at java.security.Security.getImpl(Security.java:659)
         [java]     at java.security.MessageDigest.getInstance(MessageDigest.java:129)
         [java]     at org.apache.derby.impl.sql.catalog.DataDictionaryImpl.findDefaultBuiltinAlgorithm(Unknown Source)
         [java]     at org.apache.derby.impl.sql.catalog.DataDictionaryImpl.boot(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.BaseMonitor.boot(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.TopService.bootModule(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.BaseMonitor.startModule(Unknown Source)
         [java]     at org.apache.derby.iapi.services.monitor.Monitor.bootServiceModule(Unknown Source)
         [java]     at org.apache.derby.impl.db.BasicDatabase.boot(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.BaseMonitor.boot(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.TopService.bootModule(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.BaseMonitor.bootService(Unknown Source)
         [java]     at org.apache.derby.impl.services.monitor.BaseMonitor.createPersistentService(Unknown Source)
         [java]     at org.apache.derby.iapi.services.monitor.Monitor.createPersistentService(Unknown Source)
         [java]     ... 33 more
         [java] 
         [java]     at org.apache.openjpa.lib.conf.ConfigurationImpl.instantiateAll(ConfigurationImpl.java:320)
         [java]     at org.apache.openjpa.conf.OpenJPAConfigurationImpl.instantiateAll(OpenJPAConfigurationImpl.java:1670)
         [java]     at org.apache.openjpa.kernel.AbstractBrokerFactory.makeReadOnly(AbstractBrokerFactory.java:652)
         [java]     at org.apache.openjpa.kernel.AbstractBrokerFactory.newBroker(AbstractBrokerFactory.java:203)
         [java]     ... 5 more

    BUILD FAILED
    /private/tmp/apache-openjpa-2.2.2/examples/simple/build.xml:127: Java returned: 1

    Total time: 3 seconds
    murphy:hellojpa pdurbin$ 
