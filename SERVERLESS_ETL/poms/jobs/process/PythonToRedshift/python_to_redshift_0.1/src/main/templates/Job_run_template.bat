%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=%cd%/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/JythonInterpreter.jar;../lib/antlr-runtime-3.5.2.jar;../lib/dom4j-1.6.1.jar;../lib/jython.jar;../lib/jythonlib.jar;../lib/log4j-1.2.17.jar;../lib/org.talend.dataquality.parser.jar;../lib/redshift-jdbc42-no-awssdk-1.2.16.1027.jar;../lib/talend_file_enhanced_20070724.jar;python_to_redshift_0_1.jar; serverless_etl.python_to_redshift_0_1.python_to_redshift  %*