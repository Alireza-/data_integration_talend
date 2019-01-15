
package serverless_etl.childjob_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.DataQualityDependencies;
import routines.Mathematical;
import routines.SQLike;
import routines.Numeric;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.DQTechnical;
import routines.StringHandling;
import routines.DataMasking;
import routines.TalendDate;
import routines.DqStringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 




	//the import part of tJava_1
	//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: ChildJob Purpose: <br>
 * Description:  <br>
 * @author ali@versent.com.au
 * @version 7.1.1.20181026_1147
 * @status 
 */
public class ChildJob implements TalendJob {
	static {System.setProperty("TalendJob.log", "ChildJob.log");}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ChildJob.class);

protected static void logIgnoredError(String message, Throwable cause) {
       log.error(message, cause);

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(name != null){
				
					this.setProperty("name", name.toString());
				
			}
			
			if(scope != null){
				
					this.setProperty("scope", scope.toString());
				
			}
			
		}

public String name;
public String getName(){
	return this.name;
}
public Integer scope;
public Integer getScope(){
	return this.scope;
}
	}
	private ContextProperties context = new ContextProperties();
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "ChildJob";
	private final String projectName = "SERVERLESS_ETL";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	LogCatcherUtils log_proccessing_1_tLogCatcher_1 = new LogCatcherUtils();

private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				ChildJob.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(ChildJob.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
				log_proccessing_1_tLogCatcher_1.addMessage("Java Exception", currentComponent, 6, e.getClass().getName() + ":" + e.getMessage(), 1);
				log_proccessing_1_tLogCatcher_1Process(globalMap);
			}
				} catch (TalendException e) {
					// do nothing
				
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tJava_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDie_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDie_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tWarn_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tWarn_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tLogCatcher_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tFileOutputDelimited_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tLogRow_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tFileOutputDelimited_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tLogRow_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tFileOutputDelimited_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tLogRow_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tFileOutputDelimited_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tLogRow_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void log_proccessing_1_tFileOutputDelimited_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					log_proccessing_1_tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError1", 0, "error");
						}
					
					errorCode = null;
					tDie_1Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tDie_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tWarn_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void log_proccessing_1_tLogCatcher_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
		







public void tJava_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tJava_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_1", false);
		start_Hash.put("tJava_1", System.currentTimeMillis());
		
	
	currentComponent="tJava_1";

	
		int tos_count_tJava_1 = 0;
		


String message="Hello "+context.name+", you get "+context.scope+" points in this exam!";
System.out.println(message);
 



/**
 * [tJava_1 begin ] stop
 */
	
	/**
	 * [tJava_1 main ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 


	tos_count_tJava_1++;

/**
 * [tJava_1 main ] stop
 */
	
	/**
	 * [tJava_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_begin ] stop
 */
	
	/**
	 * [tJava_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_end ] stop
 */
	
	/**
	 * [tJava_1 end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 

ok_Hash.put("tJava_1", true);
end_Hash.put("tJava_1", System.currentTimeMillis());




/**
 * [tJava_1 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tJava_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tWarn_1Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_1 finally ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}
	

public void tDie_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDie_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDie_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDie_1", false);
		start_Hash.put("tDie_1", System.currentTimeMillis());
		
	
	currentComponent="tDie_1";

	
		int tos_count_tDie_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDie_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDie_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDie_1 = new StringBuilder();
                    log4jParamters_tDie_1.append("Parameters:");
                            log4jParamters_tDie_1.append("MESSAGE" + " = " + "\"the end is near\"");
                        log4jParamters_tDie_1.append(" | ");
                            log4jParamters_tDie_1.append("CODE" + " = " + "4");
                        log4jParamters_tDie_1.append(" | ");
                            log4jParamters_tDie_1.append("PRIORITY" + " = " + "5");
                        log4jParamters_tDie_1.append(" | ");
                            log4jParamters_tDie_1.append("EXIT_JVM" + " = " + "false");
                        log4jParamters_tDie_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDie_1 - "  + (log4jParamters_tDie_1) );
                    } 
                } 
            new BytesLimit65535_tDie_1().limitLog4jByte();
            }

 



/**
 * [tDie_1 begin ] stop
 */
	
	/**
	 * [tDie_1 main ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

	try {
				log_proccessing_1_tLogCatcher_1.addMessage("tDie", "tDie_1", 5, "the end is near", 4);
				log_proccessing_1_tLogCatcher_1Process(globalMap);
				
	globalMap.put("tDie_1_DIE_PRIORITY", 5);
	System.err.println("the end is near");
	
		log.error("tDie_1 - The die message: "+"the end is near");
	
	globalMap.put("tDie_1_DIE_MESSAGE", "the end is near");
	globalMap.put("tDie_1_DIE_MESSAGES", "the end is near");
	
	} catch (Exception | Error e_tDie_1) {
		logIgnoredError(String.format("tDie_1 - tDie failed to log message due to internal error: %s", e_tDie_1), e_tDie_1);
	}
	
	currentComponent = "tDie_1";
	status = "failure";
        errorCode = new Integer(4);
        globalMap.put("tDie_1_DIE_CODE", errorCode);        
    
	if(true){	
	    throw new TDieException();
	}

 


	tos_count_tDie_1++;

/**
 * [tDie_1 main ] stop
 */
	
	/**
	 * [tDie_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 



/**
 * [tDie_1 process_data_begin ] stop
 */
	
	/**
	 * [tDie_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 



/**
 * [tDie_1 process_data_end ] stop
 */
	
	/**
	 * [tDie_1 end ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 
                if(log.isDebugEnabled())
            log.debug("tDie_1 - "  + ("Done.") );

ok_Hash.put("tDie_1", true);
end_Hash.put("tDie_1", System.currentTimeMillis());




/**
 * [tDie_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDie_1 finally ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 



/**
 * [tDie_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDie_1_SUBPROCESS_STATE", 1);
	}
	

public void tWarn_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tWarn_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tWarn_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tWarn_1", false);
		start_Hash.put("tWarn_1", System.currentTimeMillis());
		
	
	currentComponent="tWarn_1";

	
		int tos_count_tWarn_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tWarn_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tWarn_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tWarn_1 = new StringBuilder();
                    log4jParamters_tWarn_1.append("Parameters:");
                            log4jParamters_tWarn_1.append("MESSAGE" + " = " + "\"2nd warning\"");
                        log4jParamters_tWarn_1.append(" | ");
                            log4jParamters_tWarn_1.append("CODE" + " = " + "42");
                        log4jParamters_tWarn_1.append(" | ");
                            log4jParamters_tWarn_1.append("PRIORITY" + " = " + "4");
                        log4jParamters_tWarn_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tWarn_1 - "  + (log4jParamters_tWarn_1) );
                    } 
                } 
            new BytesLimit65535_tWarn_1().limitLog4jByte();
            }

 



/**
 * [tWarn_1 begin ] stop
 */
	
	/**
	 * [tWarn_1 main ] start
	 */

	

	
	
	currentComponent="tWarn_1";

	

		
try {
	
	resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_1", "", Thread.currentThread().getId() + "", "WARN","","2nd warning","", "");
            log.warn("tWarn_1 - "  + ("Message: ")  + ("2nd warning")  + (". Code: ")  + (42) );
                if(log.isDebugEnabled())
            log.debug("tWarn_1 - "  + ("Sending message to log_proccessing_1_tLogCatcher_1.") );
	log_proccessing_1_tLogCatcher_1.addMessage("tWarn", "tWarn_1", 4, "2nd warning", 42);
	log_proccessing_1_tLogCatcher_1Process(globalMap);
	globalMap.put("tWarn_1_WARN_MESSAGES", "2nd warning"); 
	globalMap.put("tWarn_1_WARN_PRIORITY", 4);
	globalMap.put("tWarn_1_WARN_CODE", 42);
	
} catch (Exception e_tWarn_1) {
	logIgnoredError(String.format("tWarn_1 - tWarn failed to log message due to internal error: %s", e_tWarn_1), e_tWarn_1);
}


 


	tos_count_tWarn_1++;

/**
 * [tWarn_1 main ] stop
 */
	
	/**
	 * [tWarn_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tWarn_1";

	

 



/**
 * [tWarn_1 process_data_begin ] stop
 */
	
	/**
	 * [tWarn_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tWarn_1";

	

 



/**
 * [tWarn_1 process_data_end ] stop
 */
	
	/**
	 * [tWarn_1 end ] start
	 */

	

	
	
	currentComponent="tWarn_1";

	

 
                if(log.isDebugEnabled())
            log.debug("tWarn_1 - "  + ("Done.") );

ok_Hash.put("tWarn_1", true);
end_Hash.put("tWarn_1", System.currentTimeMillis());




/**
 * [tWarn_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tWarn_1 finally ] start
	 */

	

	
	
	currentComponent="tWarn_1";

	

 



/**
 * [tWarn_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tWarn_1_SUBPROCESS_STATE", 1);
	}
	


public static class log_proccessing_1_row4Struct implements routines.system.IPersistableRow<log_proccessing_1_row4Struct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_row4Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class log_proccessing_1_row6Struct implements routines.system.IPersistableRow<log_proccessing_1_row6Struct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_row6Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class log_proccessing_1_row5Struct implements routines.system.IPersistableRow<log_proccessing_1_row5Struct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_row5Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class log_proccessing_1_row3Struct implements routines.system.IPersistableRow<log_proccessing_1_row3Struct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_row3Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class log_proccessing_1_row2Struct implements routines.system.IPersistableRow<log_proccessing_1_row2Struct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class log_proccessing_1_Info_logStruct implements routines.system.IPersistableRow<log_proccessing_1_Info_logStruct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_Info_logStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class log_proccessing_1_debug_logStruct implements routines.system.IPersistableRow<log_proccessing_1_debug_logStruct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_debug_logStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class log_proccessing_1_error_logStruct implements routines.system.IPersistableRow<log_proccessing_1_error_logStruct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_error_logStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class log_proccessing_1_fatal_error_logStruct implements routines.system.IPersistableRow<log_proccessing_1_fatal_error_logStruct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_fatal_error_logStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class log_proccessing_1_warn_logStruct implements routines.system.IPersistableRow<log_proccessing_1_warn_logStruct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_warn_logStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class log_proccessing_1_row1Struct implements routines.system.IPersistableRow<log_proccessing_1_row1Struct> {
    final static byte[] commonByteArrayLock_SERVERLESS_ETL_ChildJob = new byte[0];
    static byte[] commonByteArray_SERVERLESS_ETL_ChildJob = new byte[0];

	
			    public java.util.Date moment;

				public java.util.Date getMoment () {
					return this.moment;
				}
				
			    public String pid;

				public String getPid () {
					return this.pid;
				}
				
			    public String root_pid;

				public String getRoot_pid () {
					return this.root_pid;
				}
				
			    public String father_pid;

				public String getFather_pid () {
					return this.father_pid;
				}
				
			    public String project;

				public String getProject () {
					return this.project;
				}
				
			    public String job;

				public String getJob () {
					return this.job;
				}
				
			    public String context;

				public String getContext () {
					return this.context;
				}
				
			    public Integer priority;

				public Integer getPriority () {
					return this.priority;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String origin;

				public String getOrigin () {
					return this.origin;
				}
				
			    public String message;

				public String getMessage () {
					return this.message;
				}
				
			    public Integer code;

				public Integer getCode () {
					return this.code;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_SERVERLESS_ETL_ChildJob.length) {
				if(length < 1024 && commonByteArray_SERVERLESS_ETL_ChildJob.length == 0) {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[1024];
				} else {
   					commonByteArray_SERVERLESS_ETL_ChildJob = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length);
			strReturn = new String(commonByteArray_SERVERLESS_ETL_ChildJob, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_SERVERLESS_ETL_ChildJob) {

        	try {

        		int length = 0;
		
					this.moment = readDate(dis);
					
					this.pid = readString(dis);
					
					this.root_pid = readString(dis);
					
					this.father_pid = readString(dis);
					
					this.project = readString(dis);
					
					this.job = readString(dis);
					
					this.context = readString(dis);
					
						this.priority = readInteger(dis);
					
					this.type = readString(dis);
					
					this.origin = readString(dis);
					
					this.message = readString(dis);
					
						this.code = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// java.util.Date
				
						writeDate(this.moment,dos);
					
					// String
				
						writeString(this.pid,dos);
					
					// String
				
						writeString(this.root_pid,dos);
					
					// String
				
						writeString(this.father_pid,dos);
					
					// String
				
						writeString(this.project,dos);
					
					// String
				
						writeString(this.job,dos);
					
					// String
				
						writeString(this.context,dos);
					
					// Integer
				
						writeInteger(this.priority,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.origin,dos);
					
					// String
				
						writeString(this.message,dos);
					
					// Integer
				
						writeInteger(this.code,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("moment="+String.valueOf(moment));
		sb.append(",pid="+pid);
		sb.append(",root_pid="+root_pid);
		sb.append(",father_pid="+father_pid);
		sb.append(",project="+project);
		sb.append(",job="+job);
		sb.append(",context="+context);
		sb.append(",priority="+String.valueOf(priority));
		sb.append(",type="+type);
		sb.append(",origin="+origin);
		sb.append(",message="+message);
		sb.append(",code="+String.valueOf(code));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(moment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(moment);
            			}
            		
        			sb.append("|");
        		
        				if(pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(pid);
            			}
            		
        			sb.append("|");
        		
        				if(root_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(root_pid);
            			}
            		
        			sb.append("|");
        		
        				if(father_pid == null){
        					sb.append("<null>");
        				}else{
            				sb.append(father_pid);
            			}
            		
        			sb.append("|");
        		
        				if(project == null){
        					sb.append("<null>");
        				}else{
            				sb.append(project);
            			}
            		
        			sb.append("|");
        		
        				if(job == null){
        					sb.append("<null>");
        				}else{
            				sb.append(job);
            			}
            		
        			sb.append("|");
        		
        				if(context == null){
        					sb.append("<null>");
        				}else{
            				sb.append(context);
            			}
            		
        			sb.append("|");
        		
        				if(priority == null){
        					sb.append("<null>");
        				}else{
            				sb.append(priority);
            			}
            		
        			sb.append("|");
        		
        				if(type == null){
        					sb.append("<null>");
        				}else{
            				sb.append(type);
            			}
            		
        			sb.append("|");
        		
        				if(origin == null){
        					sb.append("<null>");
        				}else{
            				sb.append(origin);
            			}
            		
        			sb.append("|");
        		
        				if(message == null){
        					sb.append("<null>");
        				}else{
            				sb.append(message);
            			}
            		
        			sb.append("|");
        		
        				if(code == null){
        					sb.append("<null>");
        				}else{
            				sb.append(code);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(log_proccessing_1_row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void log_proccessing_1_tLogCatcher_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("log_proccessing_1_tLogCatcher_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		log_proccessing_1_row1Struct log_proccessing_1_row1 = new log_proccessing_1_row1Struct();
log_proccessing_1_Info_logStruct log_proccessing_1_Info_log = new log_proccessing_1_Info_logStruct();
log_proccessing_1_Info_logStruct log_proccessing_1_row2 = log_proccessing_1_Info_log;
log_proccessing_1_debug_logStruct log_proccessing_1_debug_log = new log_proccessing_1_debug_logStruct();
log_proccessing_1_debug_logStruct log_proccessing_1_row3 = log_proccessing_1_debug_log;
log_proccessing_1_error_logStruct log_proccessing_1_error_log = new log_proccessing_1_error_logStruct();
log_proccessing_1_error_logStruct log_proccessing_1_row5 = log_proccessing_1_error_log;
log_proccessing_1_fatal_error_logStruct log_proccessing_1_fatal_error_log = new log_proccessing_1_fatal_error_logStruct();
log_proccessing_1_fatal_error_logStruct log_proccessing_1_row6 = log_proccessing_1_fatal_error_log;
log_proccessing_1_warn_logStruct log_proccessing_1_warn_log = new log_proccessing_1_warn_logStruct();
log_proccessing_1_warn_logStruct log_proccessing_1_row4 = log_proccessing_1_warn_log;






	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_1 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tFileOutputDelimited_1", false);
		start_Hash.put("log_proccessing_1_tFileOutputDelimited_1", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_row2" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tFileOutputDelimited_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tFileOutputDelimited_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tFileOutputDelimited_1 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("Parameters:");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("USESTREAM" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("FILENAME" + " = " + "\"/tmp/INFO.csv\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("ROWSEPARATOR" + " = " + "\"\\n\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("FIELDSEPARATOR" + " = " + "\";\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("APPEND" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("INCLUDEHEADER" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("ADVANCED_SEPARATOR" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("CSV_OPTION" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("CREATE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("SPLIT" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("FLUSHONROW" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("ROW_MODE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("ENCODING" + " = " + "\"ISO-8859-15\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append("DELETE_EMPTYFILE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_1 - "  + (log4jParamters_log_proccessing_1_tFileOutputDelimited_1) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tFileOutputDelimited_1().limitLog4jByte();
            }

String fileName_log_proccessing_1_tFileOutputDelimited_1 = "";
    fileName_log_proccessing_1_tFileOutputDelimited_1 = (new java.io.File("/tmp/INFO.csv")).getAbsolutePath().replace("\\","/");
    String fullName_log_proccessing_1_tFileOutputDelimited_1 = null;
    String extension_log_proccessing_1_tFileOutputDelimited_1 = null;
    String directory_log_proccessing_1_tFileOutputDelimited_1 = null;
    if((fileName_log_proccessing_1_tFileOutputDelimited_1.indexOf("/") != -1)) {
        if(fileName_log_proccessing_1_tFileOutputDelimited_1.lastIndexOf(".") < fileName_log_proccessing_1_tFileOutputDelimited_1.lastIndexOf("/")) {
            fullName_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1;
            extension_log_proccessing_1_tFileOutputDelimited_1 = "";
        } else {
            fullName_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_1.lastIndexOf("."));
            extension_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1.substring(fileName_log_proccessing_1_tFileOutputDelimited_1.lastIndexOf("."));
        }
        directory_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_1.lastIndexOf("/"));
    } else {
        if(fileName_log_proccessing_1_tFileOutputDelimited_1.lastIndexOf(".") != -1) {
            fullName_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_1.lastIndexOf("."));
            extension_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1.substring(fileName_log_proccessing_1_tFileOutputDelimited_1.lastIndexOf("."));
        } else {
            fullName_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1;
            extension_log_proccessing_1_tFileOutputDelimited_1 = "";
        }
        directory_log_proccessing_1_tFileOutputDelimited_1 = "";
    }
    boolean isFileGenerated_log_proccessing_1_tFileOutputDelimited_1 = true;
    java.io.File filelog_proccessing_1_tFileOutputDelimited_1 = new java.io.File(fileName_log_proccessing_1_tFileOutputDelimited_1);
    globalMap.put("log_proccessing_1_tFileOutputDelimited_1_FILE_NAME",fileName_log_proccessing_1_tFileOutputDelimited_1);
        if(filelog_proccessing_1_tFileOutputDelimited_1.exists()){
            isFileGenerated_log_proccessing_1_tFileOutputDelimited_1 = false;
        }
            int nb_line_log_proccessing_1_tFileOutputDelimited_1 = 0;
            int splitedFileNo_log_proccessing_1_tFileOutputDelimited_1 = 0;
            int currentRow_log_proccessing_1_tFileOutputDelimited_1 = 0;

            final String OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1 = /** Start field log_proccessing_1_tFileOutputDelimited_1:FIELDSEPARATOR */";"/** End field log_proccessing_1_tFileOutputDelimited_1:FIELDSEPARATOR */;

            final String OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_1 = /** Start field log_proccessing_1_tFileOutputDelimited_1:ROWSEPARATOR */"\n"/** End field log_proccessing_1_tFileOutputDelimited_1:ROWSEPARATOR */;

                    //create directory only if not exists
                    if(directory_log_proccessing_1_tFileOutputDelimited_1 != null && directory_log_proccessing_1_tFileOutputDelimited_1.trim().length() != 0) {
                        java.io.File dir_log_proccessing_1_tFileOutputDelimited_1 = new java.io.File(directory_log_proccessing_1_tFileOutputDelimited_1);
                        if(!dir_log_proccessing_1_tFileOutputDelimited_1.exists()) {
                                log.info("log_proccessing_1_tFileOutputDelimited_1 - Creating directory '" + dir_log_proccessing_1_tFileOutputDelimited_1.getCanonicalPath() +"'.");
                            dir_log_proccessing_1_tFileOutputDelimited_1.mkdirs();
                                log.info("log_proccessing_1_tFileOutputDelimited_1 - The directory '"+ dir_log_proccessing_1_tFileOutputDelimited_1.getCanonicalPath() + "' has been created successfully.");
                        }
                    }

                        //routines.system.Row
                        java.io.Writer outlog_proccessing_1_tFileOutputDelimited_1 = null;

                        outlog_proccessing_1_tFileOutputDelimited_1 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
                        new java.io.FileOutputStream(fileName_log_proccessing_1_tFileOutputDelimited_1, true),"ISO-8859-15"));
                                    if(filelog_proccessing_1_tFileOutputDelimited_1.length()==0){
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("moment");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("pid");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("root_pid");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("father_pid");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("project");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("job");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("context");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("priority");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("type");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("origin");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("message");
                                            outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.write("code");
                                        outlog_proccessing_1_tFileOutputDelimited_1.write(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_1);
                                        outlog_proccessing_1_tFileOutputDelimited_1.flush();
                                    }


        resourceMap.put("out_log_proccessing_1_tFileOutputDelimited_1", outlog_proccessing_1_tFileOutputDelimited_1);
resourceMap.put("nb_line_log_proccessing_1_tFileOutputDelimited_1", nb_line_log_proccessing_1_tFileOutputDelimited_1);

 



/**
 * [log_proccessing_1_tFileOutputDelimited_1 begin ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tLogRow_1", false);
		start_Hash.put("log_proccessing_1_tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tLogRow_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_Info_log" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tLogRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tLogRow_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tLogRow_1 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tLogRow_1.append("Parameters:");
                            log4jParamters_log_proccessing_1_tLogRow_1.append("BASIC_MODE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_1.append("TABLE_PRINT" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_1.append("VERTICAL" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_1.append("FIELDSEPARATOR" + " = " + "\"|\"");
                        log4jParamters_log_proccessing_1_tLogRow_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_1.append("PRINT_HEADER" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_1.append("PRINT_UNIQUE_NAME" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_1.append("PRINT_COLNAMES" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_1.append("USE_FIXED_LENGTH" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_1 - "  + (log4jParamters_log_proccessing_1_tLogRow_1) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tLogRow_1().limitLog4jByte();
            }

	///////////////////////
	
		final String OUTPUT_FIELD_SEPARATOR_log_proccessing_1_tLogRow_1 = "|";
		java.io.PrintStream consoleOut_log_proccessing_1_tLogRow_1 = null;	

 		StringBuilder strBuffer_log_proccessing_1_tLogRow_1 = null;
		int nb_line_log_proccessing_1_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [log_proccessing_1_tLogRow_1 begin ] stop
 */





	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_2 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tFileOutputDelimited_2", false);
		start_Hash.put("log_proccessing_1_tFileOutputDelimited_2", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_2";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_row3" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tFileOutputDelimited_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tFileOutputDelimited_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tFileOutputDelimited_2 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("Parameters:");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("USESTREAM" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("FILENAME" + " = " + "\"/tmp/DEBUG.csv\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("ROWSEPARATOR" + " = " + "\"\\n\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("FIELDSEPARATOR" + " = " + "\";\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("APPEND" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("INCLUDEHEADER" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("ADVANCED_SEPARATOR" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("CSV_OPTION" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("CREATE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("SPLIT" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("FLUSHONROW" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("ROW_MODE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("ENCODING" + " = " + "\"ISO-8859-15\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append("DELETE_EMPTYFILE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_2 - "  + (log4jParamters_log_proccessing_1_tFileOutputDelimited_2) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tFileOutputDelimited_2().limitLog4jByte();
            }

String fileName_log_proccessing_1_tFileOutputDelimited_2 = "";
    fileName_log_proccessing_1_tFileOutputDelimited_2 = (new java.io.File("/tmp/DEBUG.csv")).getAbsolutePath().replace("\\","/");
    String fullName_log_proccessing_1_tFileOutputDelimited_2 = null;
    String extension_log_proccessing_1_tFileOutputDelimited_2 = null;
    String directory_log_proccessing_1_tFileOutputDelimited_2 = null;
    if((fileName_log_proccessing_1_tFileOutputDelimited_2.indexOf("/") != -1)) {
        if(fileName_log_proccessing_1_tFileOutputDelimited_2.lastIndexOf(".") < fileName_log_proccessing_1_tFileOutputDelimited_2.lastIndexOf("/")) {
            fullName_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2;
            extension_log_proccessing_1_tFileOutputDelimited_2 = "";
        } else {
            fullName_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_2.lastIndexOf("."));
            extension_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2.substring(fileName_log_proccessing_1_tFileOutputDelimited_2.lastIndexOf("."));
        }
        directory_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_2.lastIndexOf("/"));
    } else {
        if(fileName_log_proccessing_1_tFileOutputDelimited_2.lastIndexOf(".") != -1) {
            fullName_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_2.lastIndexOf("."));
            extension_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2.substring(fileName_log_proccessing_1_tFileOutputDelimited_2.lastIndexOf("."));
        } else {
            fullName_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2;
            extension_log_proccessing_1_tFileOutputDelimited_2 = "";
        }
        directory_log_proccessing_1_tFileOutputDelimited_2 = "";
    }
    boolean isFileGenerated_log_proccessing_1_tFileOutputDelimited_2 = true;
    java.io.File filelog_proccessing_1_tFileOutputDelimited_2 = new java.io.File(fileName_log_proccessing_1_tFileOutputDelimited_2);
    globalMap.put("log_proccessing_1_tFileOutputDelimited_2_FILE_NAME",fileName_log_proccessing_1_tFileOutputDelimited_2);
        if(filelog_proccessing_1_tFileOutputDelimited_2.exists()){
            isFileGenerated_log_proccessing_1_tFileOutputDelimited_2 = false;
        }
            int nb_line_log_proccessing_1_tFileOutputDelimited_2 = 0;
            int splitedFileNo_log_proccessing_1_tFileOutputDelimited_2 = 0;
            int currentRow_log_proccessing_1_tFileOutputDelimited_2 = 0;

            final String OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2 = /** Start field log_proccessing_1_tFileOutputDelimited_2:FIELDSEPARATOR */";"/** End field log_proccessing_1_tFileOutputDelimited_2:FIELDSEPARATOR */;

            final String OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_2 = /** Start field log_proccessing_1_tFileOutputDelimited_2:ROWSEPARATOR */"\n"/** End field log_proccessing_1_tFileOutputDelimited_2:ROWSEPARATOR */;


                        //routines.system.Row
                        java.io.Writer outlog_proccessing_1_tFileOutputDelimited_2 = null;

                        outlog_proccessing_1_tFileOutputDelimited_2 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
                        new java.io.FileOutputStream(fileName_log_proccessing_1_tFileOutputDelimited_2, true),"ISO-8859-15"));
                                    if(filelog_proccessing_1_tFileOutputDelimited_2.length()==0){
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("moment");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("pid");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("root_pid");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("father_pid");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("project");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("job");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("context");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("priority");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("type");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("origin");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("message");
                                            outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.write("code");
                                        outlog_proccessing_1_tFileOutputDelimited_2.write(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_2);
                                        outlog_proccessing_1_tFileOutputDelimited_2.flush();
                                    }


        resourceMap.put("out_log_proccessing_1_tFileOutputDelimited_2", outlog_proccessing_1_tFileOutputDelimited_2);
resourceMap.put("nb_line_log_proccessing_1_tFileOutputDelimited_2", nb_line_log_proccessing_1_tFileOutputDelimited_2);

 



/**
 * [log_proccessing_1_tFileOutputDelimited_2 begin ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogRow_2 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tLogRow_2", false);
		start_Hash.put("log_proccessing_1_tLogRow_2", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tLogRow_2";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_debug_log" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tLogRow_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tLogRow_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tLogRow_2 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tLogRow_2.append("Parameters:");
                            log4jParamters_log_proccessing_1_tLogRow_2.append("BASIC_MODE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_2.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_2.append("TABLE_PRINT" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_2.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_2.append("VERTICAL" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_2.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_2.append("FIELDSEPARATOR" + " = " + "\"|\"");
                        log4jParamters_log_proccessing_1_tLogRow_2.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_2.append("PRINT_HEADER" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_2.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_2.append("PRINT_UNIQUE_NAME" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_2.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_2.append("PRINT_COLNAMES" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_2.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_2.append("USE_FIXED_LENGTH" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_2.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_2.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_2 - "  + (log4jParamters_log_proccessing_1_tLogRow_2) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tLogRow_2().limitLog4jByte();
            }

	///////////////////////
	
		final String OUTPUT_FIELD_SEPARATOR_log_proccessing_1_tLogRow_2 = "|";
		java.io.PrintStream consoleOut_log_proccessing_1_tLogRow_2 = null;	

 		StringBuilder strBuffer_log_proccessing_1_tLogRow_2 = null;
		int nb_line_log_proccessing_1_tLogRow_2 = 0;
///////////////////////    			



 



/**
 * [log_proccessing_1_tLogRow_2 begin ] stop
 */





	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_4 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tFileOutputDelimited_4", false);
		start_Hash.put("log_proccessing_1_tFileOutputDelimited_4", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_4";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_row5" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tFileOutputDelimited_4 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_4 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tFileOutputDelimited_4{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tFileOutputDelimited_4 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("Parameters:");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("USESTREAM" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("FILENAME" + " = " + "\"/tmp/ERROR.csv\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("ROWSEPARATOR" + " = " + "\"\\n\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("FIELDSEPARATOR" + " = " + "\";\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("APPEND" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("INCLUDEHEADER" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("ADVANCED_SEPARATOR" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("CSV_OPTION" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("CREATE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("SPLIT" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("FLUSHONROW" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("ROW_MODE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("ENCODING" + " = " + "\"ISO-8859-15\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append("DELETE_EMPTYFILE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_4.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_4 - "  + (log4jParamters_log_proccessing_1_tFileOutputDelimited_4) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tFileOutputDelimited_4().limitLog4jByte();
            }

String fileName_log_proccessing_1_tFileOutputDelimited_4 = "";
    fileName_log_proccessing_1_tFileOutputDelimited_4 = (new java.io.File("/tmp/ERROR.csv")).getAbsolutePath().replace("\\","/");
    String fullName_log_proccessing_1_tFileOutputDelimited_4 = null;
    String extension_log_proccessing_1_tFileOutputDelimited_4 = null;
    String directory_log_proccessing_1_tFileOutputDelimited_4 = null;
    if((fileName_log_proccessing_1_tFileOutputDelimited_4.indexOf("/") != -1)) {
        if(fileName_log_proccessing_1_tFileOutputDelimited_4.lastIndexOf(".") < fileName_log_proccessing_1_tFileOutputDelimited_4.lastIndexOf("/")) {
            fullName_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4;
            extension_log_proccessing_1_tFileOutputDelimited_4 = "";
        } else {
            fullName_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_4.lastIndexOf("."));
            extension_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4.substring(fileName_log_proccessing_1_tFileOutputDelimited_4.lastIndexOf("."));
        }
        directory_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_4.lastIndexOf("/"));
    } else {
        if(fileName_log_proccessing_1_tFileOutputDelimited_4.lastIndexOf(".") != -1) {
            fullName_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_4.lastIndexOf("."));
            extension_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4.substring(fileName_log_proccessing_1_tFileOutputDelimited_4.lastIndexOf("."));
        } else {
            fullName_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4;
            extension_log_proccessing_1_tFileOutputDelimited_4 = "";
        }
        directory_log_proccessing_1_tFileOutputDelimited_4 = "";
    }
    boolean isFileGenerated_log_proccessing_1_tFileOutputDelimited_4 = true;
    java.io.File filelog_proccessing_1_tFileOutputDelimited_4 = new java.io.File(fileName_log_proccessing_1_tFileOutputDelimited_4);
    globalMap.put("log_proccessing_1_tFileOutputDelimited_4_FILE_NAME",fileName_log_proccessing_1_tFileOutputDelimited_4);
        if(filelog_proccessing_1_tFileOutputDelimited_4.exists()){
            isFileGenerated_log_proccessing_1_tFileOutputDelimited_4 = false;
        }
            int nb_line_log_proccessing_1_tFileOutputDelimited_4 = 0;
            int splitedFileNo_log_proccessing_1_tFileOutputDelimited_4 = 0;
            int currentRow_log_proccessing_1_tFileOutputDelimited_4 = 0;

            final String OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4 = /** Start field log_proccessing_1_tFileOutputDelimited_4:FIELDSEPARATOR */";"/** End field log_proccessing_1_tFileOutputDelimited_4:FIELDSEPARATOR */;

            final String OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_4 = /** Start field log_proccessing_1_tFileOutputDelimited_4:ROWSEPARATOR */"\n"/** End field log_proccessing_1_tFileOutputDelimited_4:ROWSEPARATOR */;

                    //create directory only if not exists
                    if(directory_log_proccessing_1_tFileOutputDelimited_4 != null && directory_log_proccessing_1_tFileOutputDelimited_4.trim().length() != 0) {
                        java.io.File dir_log_proccessing_1_tFileOutputDelimited_4 = new java.io.File(directory_log_proccessing_1_tFileOutputDelimited_4);
                        if(!dir_log_proccessing_1_tFileOutputDelimited_4.exists()) {
                                log.info("log_proccessing_1_tFileOutputDelimited_4 - Creating directory '" + dir_log_proccessing_1_tFileOutputDelimited_4.getCanonicalPath() +"'.");
                            dir_log_proccessing_1_tFileOutputDelimited_4.mkdirs();
                                log.info("log_proccessing_1_tFileOutputDelimited_4 - The directory '"+ dir_log_proccessing_1_tFileOutputDelimited_4.getCanonicalPath() + "' has been created successfully.");
                        }
                    }

                        //routines.system.Row
                        java.io.Writer outlog_proccessing_1_tFileOutputDelimited_4 = null;

                        outlog_proccessing_1_tFileOutputDelimited_4 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
                        new java.io.FileOutputStream(fileName_log_proccessing_1_tFileOutputDelimited_4, true),"ISO-8859-15"));
                                    if(filelog_proccessing_1_tFileOutputDelimited_4.length()==0){
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("moment");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("pid");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("root_pid");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("father_pid");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("project");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("job");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("context");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("priority");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("type");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("origin");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("message");
                                            outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.write("code");
                                        outlog_proccessing_1_tFileOutputDelimited_4.write(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_4);
                                        outlog_proccessing_1_tFileOutputDelimited_4.flush();
                                    }


        resourceMap.put("out_log_proccessing_1_tFileOutputDelimited_4", outlog_proccessing_1_tFileOutputDelimited_4);
resourceMap.put("nb_line_log_proccessing_1_tFileOutputDelimited_4", nb_line_log_proccessing_1_tFileOutputDelimited_4);

 



/**
 * [log_proccessing_1_tFileOutputDelimited_4 begin ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogRow_3 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tLogRow_3", false);
		start_Hash.put("log_proccessing_1_tLogRow_3", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tLogRow_3";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_error_log" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tLogRow_3 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_3 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tLogRow_3{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tLogRow_3 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tLogRow_3.append("Parameters:");
                            log4jParamters_log_proccessing_1_tLogRow_3.append("BASIC_MODE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_3.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_3.append("TABLE_PRINT" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_3.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_3.append("VERTICAL" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_3.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_3.append("FIELDSEPARATOR" + " = " + "\"|\"");
                        log4jParamters_log_proccessing_1_tLogRow_3.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_3.append("PRINT_HEADER" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_3.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_3.append("PRINT_UNIQUE_NAME" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_3.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_3.append("PRINT_COLNAMES" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_3.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_3.append("USE_FIXED_LENGTH" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_3.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_3.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_3.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_3 - "  + (log4jParamters_log_proccessing_1_tLogRow_3) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tLogRow_3().limitLog4jByte();
            }

	///////////////////////
	
		final String OUTPUT_FIELD_SEPARATOR_log_proccessing_1_tLogRow_3 = "|";
		java.io.PrintStream consoleOut_log_proccessing_1_tLogRow_3 = null;	

 		StringBuilder strBuffer_log_proccessing_1_tLogRow_3 = null;
		int nb_line_log_proccessing_1_tLogRow_3 = 0;
///////////////////////    			



 



/**
 * [log_proccessing_1_tLogRow_3 begin ] stop
 */





	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_5 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tFileOutputDelimited_5", false);
		start_Hash.put("log_proccessing_1_tFileOutputDelimited_5", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_5";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_row6" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tFileOutputDelimited_5 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_5 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tFileOutputDelimited_5{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tFileOutputDelimited_5 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("Parameters:");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("USESTREAM" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("FILENAME" + " = " + "\"/tmp/FATAL_ERROR.csv\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("ROWSEPARATOR" + " = " + "\"\\n\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("FIELDSEPARATOR" + " = " + "\";\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("APPEND" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("INCLUDEHEADER" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("ADVANCED_SEPARATOR" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("CSV_OPTION" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("CREATE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("SPLIT" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("FLUSHONROW" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("ROW_MODE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("ENCODING" + " = " + "\"ISO-8859-15\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append("DELETE_EMPTYFILE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_5.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_5 - "  + (log4jParamters_log_proccessing_1_tFileOutputDelimited_5) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tFileOutputDelimited_5().limitLog4jByte();
            }

String fileName_log_proccessing_1_tFileOutputDelimited_5 = "";
    fileName_log_proccessing_1_tFileOutputDelimited_5 = (new java.io.File("/tmp/FATAL_ERROR.csv")).getAbsolutePath().replace("\\","/");
    String fullName_log_proccessing_1_tFileOutputDelimited_5 = null;
    String extension_log_proccessing_1_tFileOutputDelimited_5 = null;
    String directory_log_proccessing_1_tFileOutputDelimited_5 = null;
    if((fileName_log_proccessing_1_tFileOutputDelimited_5.indexOf("/") != -1)) {
        if(fileName_log_proccessing_1_tFileOutputDelimited_5.lastIndexOf(".") < fileName_log_proccessing_1_tFileOutputDelimited_5.lastIndexOf("/")) {
            fullName_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5;
            extension_log_proccessing_1_tFileOutputDelimited_5 = "";
        } else {
            fullName_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_5.lastIndexOf("."));
            extension_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5.substring(fileName_log_proccessing_1_tFileOutputDelimited_5.lastIndexOf("."));
        }
        directory_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_5.lastIndexOf("/"));
    } else {
        if(fileName_log_proccessing_1_tFileOutputDelimited_5.lastIndexOf(".") != -1) {
            fullName_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_5.lastIndexOf("."));
            extension_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5.substring(fileName_log_proccessing_1_tFileOutputDelimited_5.lastIndexOf("."));
        } else {
            fullName_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5;
            extension_log_proccessing_1_tFileOutputDelimited_5 = "";
        }
        directory_log_proccessing_1_tFileOutputDelimited_5 = "";
    }
    boolean isFileGenerated_log_proccessing_1_tFileOutputDelimited_5 = true;
    java.io.File filelog_proccessing_1_tFileOutputDelimited_5 = new java.io.File(fileName_log_proccessing_1_tFileOutputDelimited_5);
    globalMap.put("log_proccessing_1_tFileOutputDelimited_5_FILE_NAME",fileName_log_proccessing_1_tFileOutputDelimited_5);
        if(filelog_proccessing_1_tFileOutputDelimited_5.exists()){
            isFileGenerated_log_proccessing_1_tFileOutputDelimited_5 = false;
        }
            int nb_line_log_proccessing_1_tFileOutputDelimited_5 = 0;
            int splitedFileNo_log_proccessing_1_tFileOutputDelimited_5 = 0;
            int currentRow_log_proccessing_1_tFileOutputDelimited_5 = 0;

            final String OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5 = /** Start field log_proccessing_1_tFileOutputDelimited_5:FIELDSEPARATOR */";"/** End field log_proccessing_1_tFileOutputDelimited_5:FIELDSEPARATOR */;

            final String OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_5 = /** Start field log_proccessing_1_tFileOutputDelimited_5:ROWSEPARATOR */"\n"/** End field log_proccessing_1_tFileOutputDelimited_5:ROWSEPARATOR */;

                    //create directory only if not exists
                    if(directory_log_proccessing_1_tFileOutputDelimited_5 != null && directory_log_proccessing_1_tFileOutputDelimited_5.trim().length() != 0) {
                        java.io.File dir_log_proccessing_1_tFileOutputDelimited_5 = new java.io.File(directory_log_proccessing_1_tFileOutputDelimited_5);
                        if(!dir_log_proccessing_1_tFileOutputDelimited_5.exists()) {
                                log.info("log_proccessing_1_tFileOutputDelimited_5 - Creating directory '" + dir_log_proccessing_1_tFileOutputDelimited_5.getCanonicalPath() +"'.");
                            dir_log_proccessing_1_tFileOutputDelimited_5.mkdirs();
                                log.info("log_proccessing_1_tFileOutputDelimited_5 - The directory '"+ dir_log_proccessing_1_tFileOutputDelimited_5.getCanonicalPath() + "' has been created successfully.");
                        }
                    }

                        //routines.system.Row
                        java.io.Writer outlog_proccessing_1_tFileOutputDelimited_5 = null;

                        outlog_proccessing_1_tFileOutputDelimited_5 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
                        new java.io.FileOutputStream(fileName_log_proccessing_1_tFileOutputDelimited_5, true),"ISO-8859-15"));
                                    if(filelog_proccessing_1_tFileOutputDelimited_5.length()==0){
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("moment");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("pid");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("root_pid");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("father_pid");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("project");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("job");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("context");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("priority");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("type");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("origin");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("message");
                                            outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.write("code");
                                        outlog_proccessing_1_tFileOutputDelimited_5.write(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_5);
                                        outlog_proccessing_1_tFileOutputDelimited_5.flush();
                                    }


        resourceMap.put("out_log_proccessing_1_tFileOutputDelimited_5", outlog_proccessing_1_tFileOutputDelimited_5);
resourceMap.put("nb_line_log_proccessing_1_tFileOutputDelimited_5", nb_line_log_proccessing_1_tFileOutputDelimited_5);

 



/**
 * [log_proccessing_1_tFileOutputDelimited_5 begin ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogRow_4 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tLogRow_4", false);
		start_Hash.put("log_proccessing_1_tLogRow_4", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tLogRow_4";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_fatal_error_log" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tLogRow_4 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_4 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tLogRow_4{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tLogRow_4 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tLogRow_4.append("Parameters:");
                            log4jParamters_log_proccessing_1_tLogRow_4.append("BASIC_MODE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_4.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_4.append("TABLE_PRINT" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_4.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_4.append("VERTICAL" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_4.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_4.append("FIELDSEPARATOR" + " = " + "\"|\"");
                        log4jParamters_log_proccessing_1_tLogRow_4.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_4.append("PRINT_HEADER" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_4.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_4.append("PRINT_UNIQUE_NAME" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_4.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_4.append("PRINT_COLNAMES" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_4.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_4.append("USE_FIXED_LENGTH" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_4.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_4.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_4.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_4 - "  + (log4jParamters_log_proccessing_1_tLogRow_4) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tLogRow_4().limitLog4jByte();
            }

	///////////////////////
	
		final String OUTPUT_FIELD_SEPARATOR_log_proccessing_1_tLogRow_4 = "|";
		java.io.PrintStream consoleOut_log_proccessing_1_tLogRow_4 = null;	

 		StringBuilder strBuffer_log_proccessing_1_tLogRow_4 = null;
		int nb_line_log_proccessing_1_tLogRow_4 = 0;
///////////////////////    			



 



/**
 * [log_proccessing_1_tLogRow_4 begin ] stop
 */





	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_3 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tFileOutputDelimited_3", false);
		start_Hash.put("log_proccessing_1_tFileOutputDelimited_3", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_3";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_row4" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tFileOutputDelimited_3 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_3 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tFileOutputDelimited_3{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tFileOutputDelimited_3 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("Parameters:");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("USESTREAM" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("FILENAME" + " = " + "\"/tmp/WARN.csv\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("ROWSEPARATOR" + " = " + "\"\\n\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("FIELDSEPARATOR" + " = " + "\";\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("APPEND" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("INCLUDEHEADER" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("ADVANCED_SEPARATOR" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("CSV_OPTION" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("CREATE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("SPLIT" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("FLUSHONROW" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("ROW_MODE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("ENCODING" + " = " + "\"ISO-8859-15\"");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                            log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append("DELETE_EMPTYFILE" + " = " + "false");
                        log4jParamters_log_proccessing_1_tFileOutputDelimited_3.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_3 - "  + (log4jParamters_log_proccessing_1_tFileOutputDelimited_3) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tFileOutputDelimited_3().limitLog4jByte();
            }

String fileName_log_proccessing_1_tFileOutputDelimited_3 = "";
    fileName_log_proccessing_1_tFileOutputDelimited_3 = (new java.io.File("/tmp/WARN.csv")).getAbsolutePath().replace("\\","/");
    String fullName_log_proccessing_1_tFileOutputDelimited_3 = null;
    String extension_log_proccessing_1_tFileOutputDelimited_3 = null;
    String directory_log_proccessing_1_tFileOutputDelimited_3 = null;
    if((fileName_log_proccessing_1_tFileOutputDelimited_3.indexOf("/") != -1)) {
        if(fileName_log_proccessing_1_tFileOutputDelimited_3.lastIndexOf(".") < fileName_log_proccessing_1_tFileOutputDelimited_3.lastIndexOf("/")) {
            fullName_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3;
            extension_log_proccessing_1_tFileOutputDelimited_3 = "";
        } else {
            fullName_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_3.lastIndexOf("."));
            extension_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3.substring(fileName_log_proccessing_1_tFileOutputDelimited_3.lastIndexOf("."));
        }
        directory_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_3.lastIndexOf("/"));
    } else {
        if(fileName_log_proccessing_1_tFileOutputDelimited_3.lastIndexOf(".") != -1) {
            fullName_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3.substring(0, fileName_log_proccessing_1_tFileOutputDelimited_3.lastIndexOf("."));
            extension_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3.substring(fileName_log_proccessing_1_tFileOutputDelimited_3.lastIndexOf("."));
        } else {
            fullName_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3;
            extension_log_proccessing_1_tFileOutputDelimited_3 = "";
        }
        directory_log_proccessing_1_tFileOutputDelimited_3 = "";
    }
    boolean isFileGenerated_log_proccessing_1_tFileOutputDelimited_3 = true;
    java.io.File filelog_proccessing_1_tFileOutputDelimited_3 = new java.io.File(fileName_log_proccessing_1_tFileOutputDelimited_3);
    globalMap.put("log_proccessing_1_tFileOutputDelimited_3_FILE_NAME",fileName_log_proccessing_1_tFileOutputDelimited_3);
        if(filelog_proccessing_1_tFileOutputDelimited_3.exists()){
            isFileGenerated_log_proccessing_1_tFileOutputDelimited_3 = false;
        }
            int nb_line_log_proccessing_1_tFileOutputDelimited_3 = 0;
            int splitedFileNo_log_proccessing_1_tFileOutputDelimited_3 = 0;
            int currentRow_log_proccessing_1_tFileOutputDelimited_3 = 0;

            final String OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3 = /** Start field log_proccessing_1_tFileOutputDelimited_3:FIELDSEPARATOR */";"/** End field log_proccessing_1_tFileOutputDelimited_3:FIELDSEPARATOR */;

            final String OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_3 = /** Start field log_proccessing_1_tFileOutputDelimited_3:ROWSEPARATOR */"\n"/** End field log_proccessing_1_tFileOutputDelimited_3:ROWSEPARATOR */;

                    //create directory only if not exists
                    if(directory_log_proccessing_1_tFileOutputDelimited_3 != null && directory_log_proccessing_1_tFileOutputDelimited_3.trim().length() != 0) {
                        java.io.File dir_log_proccessing_1_tFileOutputDelimited_3 = new java.io.File(directory_log_proccessing_1_tFileOutputDelimited_3);
                        if(!dir_log_proccessing_1_tFileOutputDelimited_3.exists()) {
                                log.info("log_proccessing_1_tFileOutputDelimited_3 - Creating directory '" + dir_log_proccessing_1_tFileOutputDelimited_3.getCanonicalPath() +"'.");
                            dir_log_proccessing_1_tFileOutputDelimited_3.mkdirs();
                                log.info("log_proccessing_1_tFileOutputDelimited_3 - The directory '"+ dir_log_proccessing_1_tFileOutputDelimited_3.getCanonicalPath() + "' has been created successfully.");
                        }
                    }

                        //routines.system.Row
                        java.io.Writer outlog_proccessing_1_tFileOutputDelimited_3 = null;

                        outlog_proccessing_1_tFileOutputDelimited_3 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
                        new java.io.FileOutputStream(fileName_log_proccessing_1_tFileOutputDelimited_3, true),"ISO-8859-15"));
                                    if(filelog_proccessing_1_tFileOutputDelimited_3.length()==0){
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("moment");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("pid");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("root_pid");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("father_pid");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("project");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("job");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("context");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("priority");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("type");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("origin");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("message");
                                            outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.write("code");
                                        outlog_proccessing_1_tFileOutputDelimited_3.write(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_3);
                                        outlog_proccessing_1_tFileOutputDelimited_3.flush();
                                    }


        resourceMap.put("out_log_proccessing_1_tFileOutputDelimited_3", outlog_proccessing_1_tFileOutputDelimited_3);
resourceMap.put("nb_line_log_proccessing_1_tFileOutputDelimited_3", nb_line_log_proccessing_1_tFileOutputDelimited_3);

 



/**
 * [log_proccessing_1_tFileOutputDelimited_3 begin ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogRow_5 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tLogRow_5", false);
		start_Hash.put("log_proccessing_1_tLogRow_5", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tLogRow_5";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_warn_log" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tLogRow_5 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_5 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tLogRow_5{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tLogRow_5 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tLogRow_5.append("Parameters:");
                            log4jParamters_log_proccessing_1_tLogRow_5.append("BASIC_MODE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_5.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_5.append("TABLE_PRINT" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_5.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_5.append("VERTICAL" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_5.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_5.append("FIELDSEPARATOR" + " = " + "\"|\"");
                        log4jParamters_log_proccessing_1_tLogRow_5.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_5.append("PRINT_HEADER" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_5.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_5.append("PRINT_UNIQUE_NAME" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_5.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_5.append("PRINT_COLNAMES" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_5.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_5.append("USE_FIXED_LENGTH" + " = " + "false");
                        log4jParamters_log_proccessing_1_tLogRow_5.append(" | ");
                            log4jParamters_log_proccessing_1_tLogRow_5.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogRow_5.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_5 - "  + (log4jParamters_log_proccessing_1_tLogRow_5) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tLogRow_5().limitLog4jByte();
            }

	///////////////////////
	
		final String OUTPUT_FIELD_SEPARATOR_log_proccessing_1_tLogRow_5 = "|";
		java.io.PrintStream consoleOut_log_proccessing_1_tLogRow_5 = null;	

 		StringBuilder strBuffer_log_proccessing_1_tLogRow_5 = null;
		int nb_line_log_proccessing_1_tLogRow_5 = 0;
///////////////////////    			



 



/**
 * [log_proccessing_1_tLogRow_5 begin ] stop
 */



	
	/**
	 * [log_proccessing_1_tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tMap_1", false);
		start_Hash.put("log_proccessing_1_tMap_1", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tMap_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("log_proccessing_1_row1" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_log_proccessing_1_tMap_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tMap_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tMap_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tMap_1 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tMap_1.append("Parameters:");
                            log4jParamters_log_proccessing_1_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_log_proccessing_1_tMap_1.append(" | ");
                            log4jParamters_log_proccessing_1_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_log_proccessing_1_tMap_1.append(" | ");
                            log4jParamters_log_proccessing_1_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_log_proccessing_1_tMap_1.append(" | ");
                            log4jParamters_log_proccessing_1_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_log_proccessing_1_tMap_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tMap_1 - "  + (log4jParamters_log_proccessing_1_tMap_1) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tMap_1().limitLog4jByte();
            }




// ###############################
// # Lookup's keys initialization
		int count_log_proccessing_1_row1_log_proccessing_1_tMap_1 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
// ###############################

// ###############################
// # Outputs initialization
				int count_log_proccessing_1_Info_log_log_proccessing_1_tMap_1 = 0;
				
log_proccessing_1_Info_logStruct log_proccessing_1_Info_log_tmp = new log_proccessing_1_Info_logStruct();
				int count_log_proccessing_1_debug_log_log_proccessing_1_tMap_1 = 0;
				
log_proccessing_1_debug_logStruct log_proccessing_1_debug_log_tmp = new log_proccessing_1_debug_logStruct();
				int count_log_proccessing_1_error_log_log_proccessing_1_tMap_1 = 0;
				
log_proccessing_1_error_logStruct log_proccessing_1_error_log_tmp = new log_proccessing_1_error_logStruct();
				int count_log_proccessing_1_fatal_error_log_log_proccessing_1_tMap_1 = 0;
				
log_proccessing_1_fatal_error_logStruct log_proccessing_1_fatal_error_log_tmp = new log_proccessing_1_fatal_error_logStruct();
				int count_log_proccessing_1_warn_log_log_proccessing_1_tMap_1 = 0;
				
log_proccessing_1_warn_logStruct log_proccessing_1_warn_log_tmp = new log_proccessing_1_warn_logStruct();
// ###############################

        
        



        









 



/**
 * [log_proccessing_1_tMap_1 begin ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogCatcher_1 begin ] start
	 */

	

	
		
		ok_Hash.put("log_proccessing_1_tLogCatcher_1", false);
		start_Hash.put("log_proccessing_1_tLogCatcher_1", System.currentTimeMillis());
		
	
	currentComponent="log_proccessing_1_tLogCatcher_1";

	
		int tos_count_log_proccessing_1_tLogCatcher_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogCatcher_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_log_proccessing_1_tLogCatcher_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_log_proccessing_1_tLogCatcher_1 = new StringBuilder();
                    log4jParamters_log_proccessing_1_tLogCatcher_1.append("Parameters:");
                            log4jParamters_log_proccessing_1_tLogCatcher_1.append("CATCH_JAVA_EXCEPTION" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogCatcher_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogCatcher_1.append("CATCH_TDIE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogCatcher_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogCatcher_1.append("CATCH_TWARN" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogCatcher_1.append(" | ");
                            log4jParamters_log_proccessing_1_tLogCatcher_1.append("CATCH_TACTIONFAILURE" + " = " + "true");
                        log4jParamters_log_proccessing_1_tLogCatcher_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogCatcher_1 - "  + (log4jParamters_log_proccessing_1_tLogCatcher_1) );
                    } 
                } 
            new BytesLimit65535_log_proccessing_1_tLogCatcher_1().limitLog4jByte();
            }

try {
	for (LogCatcherUtils.LogCatcherMessage lcm : log_proccessing_1_tLogCatcher_1.getMessages()) {
		log_proccessing_1_row1.type = lcm.getType();
		log_proccessing_1_row1.origin = (lcm.getOrigin()==null || lcm.getOrigin().length()<1 ? null : lcm.getOrigin());
		log_proccessing_1_row1.priority = lcm.getPriority();
		log_proccessing_1_row1.message = lcm.getMessage();
		log_proccessing_1_row1.code = lcm.getCode();
		
		log_proccessing_1_row1.moment = java.util.Calendar.getInstance().getTime();
	
    	log_proccessing_1_row1.pid = pid;
		log_proccessing_1_row1.root_pid = rootPid;
		log_proccessing_1_row1.father_pid = fatherPid;
	
    	log_proccessing_1_row1.project = projectName;
    	log_proccessing_1_row1.job = jobName;
    	log_proccessing_1_row1.context = contextStr;
    		
 



/**
 * [log_proccessing_1_tLogCatcher_1 begin ] stop
 */
	
	/**
	 * [log_proccessing_1_tLogCatcher_1 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogCatcher_1";

	

 


	tos_count_log_proccessing_1_tLogCatcher_1++;

/**
 * [log_proccessing_1_tLogCatcher_1 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tLogCatcher_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogCatcher_1";

	

 



/**
 * [log_proccessing_1_tLogCatcher_1 process_data_begin ] stop
 */

	
	/**
	 * [log_proccessing_1_tMap_1 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tMap_1";

	

			//log_proccessing_1_row1
			//log_proccessing_1_row1


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_row1"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_row1 - " + (log_proccessing_1_row1==null? "": log_proccessing_1_row1.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_log_proccessing_1_tMap_1 = false;
		
        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_log_proccessing_1_tMap_1 = false;
		  boolean mainRowRejected_log_proccessing_1_tMap_1 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        // ###############################
        // ###############################
        // # Output tables

log_proccessing_1_Info_log = null;
log_proccessing_1_debug_log = null;
log_proccessing_1_error_log = null;
log_proccessing_1_fatal_error_log = null;
log_proccessing_1_warn_log = null;


// # Output table : 'log_proccessing_1_Info_log'
// # Filter conditions 
if( 

log_proccessing_1_row1.priority == 3

 ) {
count_log_proccessing_1_Info_log_log_proccessing_1_tMap_1++;

log_proccessing_1_Info_log_tmp.moment = log_proccessing_1_row1.moment ;
log_proccessing_1_Info_log_tmp.pid = log_proccessing_1_row1.pid ;
log_proccessing_1_Info_log_tmp.root_pid = log_proccessing_1_row1.root_pid ;
log_proccessing_1_Info_log_tmp.father_pid = log_proccessing_1_row1.father_pid ;
log_proccessing_1_Info_log_tmp.project = log_proccessing_1_row1.project ;
log_proccessing_1_Info_log_tmp.job = log_proccessing_1_row1.job ;
log_proccessing_1_Info_log_tmp.context = log_proccessing_1_row1.context ;
log_proccessing_1_Info_log_tmp.priority = log_proccessing_1_row1.priority ;
log_proccessing_1_Info_log_tmp.type = log_proccessing_1_row1.type ;
log_proccessing_1_Info_log_tmp.origin = log_proccessing_1_row1.origin ;
log_proccessing_1_Info_log_tmp.message = log_proccessing_1_row1.message ;
log_proccessing_1_Info_log_tmp.code = log_proccessing_1_row1.code ;
log_proccessing_1_Info_log = log_proccessing_1_Info_log_tmp;
log.debug("log_proccessing_1_tMap_1 - Outputting the record " + count_log_proccessing_1_Info_log_log_proccessing_1_tMap_1 + " of the output table 'log_proccessing_1_Info_log'.");

} // closing filter/reject

// # Output table : 'log_proccessing_1_debug_log'
// # Filter conditions 
if( 

log_proccessing_1_row1.priority == 2

 ) {
count_log_proccessing_1_debug_log_log_proccessing_1_tMap_1++;

log_proccessing_1_debug_log_tmp.moment = log_proccessing_1_row1.moment ;
log_proccessing_1_debug_log_tmp.pid = log_proccessing_1_row1.pid ;
log_proccessing_1_debug_log_tmp.root_pid = log_proccessing_1_row1.root_pid ;
log_proccessing_1_debug_log_tmp.father_pid = log_proccessing_1_row1.father_pid ;
log_proccessing_1_debug_log_tmp.project = log_proccessing_1_row1.project ;
log_proccessing_1_debug_log_tmp.job = log_proccessing_1_row1.job ;
log_proccessing_1_debug_log_tmp.context = log_proccessing_1_row1.context ;
log_proccessing_1_debug_log_tmp.priority = log_proccessing_1_row1.priority ;
log_proccessing_1_debug_log_tmp.type = log_proccessing_1_row1.type ;
log_proccessing_1_debug_log_tmp.origin = log_proccessing_1_row1.origin ;
log_proccessing_1_debug_log_tmp.message = log_proccessing_1_row1.message ;
log_proccessing_1_debug_log_tmp.code = log_proccessing_1_row1.code ;
log_proccessing_1_debug_log = log_proccessing_1_debug_log_tmp;
log.debug("log_proccessing_1_tMap_1 - Outputting the record " + count_log_proccessing_1_debug_log_log_proccessing_1_tMap_1 + " of the output table 'log_proccessing_1_debug_log'.");

} // closing filter/reject

// # Output table : 'log_proccessing_1_error_log'
// # Filter conditions 
if( 

log_proccessing_1_row1.priority == 5

 ) {
count_log_proccessing_1_error_log_log_proccessing_1_tMap_1++;

log_proccessing_1_error_log_tmp.moment = log_proccessing_1_row1.moment ;
log_proccessing_1_error_log_tmp.pid = log_proccessing_1_row1.pid ;
log_proccessing_1_error_log_tmp.root_pid = log_proccessing_1_row1.root_pid ;
log_proccessing_1_error_log_tmp.father_pid = log_proccessing_1_row1.father_pid ;
log_proccessing_1_error_log_tmp.project = log_proccessing_1_row1.project ;
log_proccessing_1_error_log_tmp.job = log_proccessing_1_row1.job ;
log_proccessing_1_error_log_tmp.context = log_proccessing_1_row1.context ;
log_proccessing_1_error_log_tmp.priority = log_proccessing_1_row1.priority ;
log_proccessing_1_error_log_tmp.type = log_proccessing_1_row1.type ;
log_proccessing_1_error_log_tmp.origin = log_proccessing_1_row1.origin ;
log_proccessing_1_error_log_tmp.message = log_proccessing_1_row1.message ;
log_proccessing_1_error_log_tmp.code = log_proccessing_1_row1.code ;
log_proccessing_1_error_log = log_proccessing_1_error_log_tmp;
log.debug("log_proccessing_1_tMap_1 - Outputting the record " + count_log_proccessing_1_error_log_log_proccessing_1_tMap_1 + " of the output table 'log_proccessing_1_error_log'.");

} // closing filter/reject

// # Output table : 'log_proccessing_1_fatal_error_log'
// # Filter conditions 
if( 

log_proccessing_1_row1.priority == 6

 ) {
count_log_proccessing_1_fatal_error_log_log_proccessing_1_tMap_1++;

log_proccessing_1_fatal_error_log_tmp.moment = log_proccessing_1_row1.moment ;
log_proccessing_1_fatal_error_log_tmp.pid = log_proccessing_1_row1.pid ;
log_proccessing_1_fatal_error_log_tmp.root_pid = log_proccessing_1_row1.root_pid ;
log_proccessing_1_fatal_error_log_tmp.father_pid = log_proccessing_1_row1.father_pid ;
log_proccessing_1_fatal_error_log_tmp.project = log_proccessing_1_row1.project ;
log_proccessing_1_fatal_error_log_tmp.job = log_proccessing_1_row1.job ;
log_proccessing_1_fatal_error_log_tmp.context = log_proccessing_1_row1.context ;
log_proccessing_1_fatal_error_log_tmp.priority = log_proccessing_1_row1.priority ;
log_proccessing_1_fatal_error_log_tmp.type = log_proccessing_1_row1.type ;
log_proccessing_1_fatal_error_log_tmp.origin = log_proccessing_1_row1.origin ;
log_proccessing_1_fatal_error_log_tmp.message = log_proccessing_1_row1.message ;
log_proccessing_1_fatal_error_log_tmp.code = log_proccessing_1_row1.code ;
log_proccessing_1_fatal_error_log = log_proccessing_1_fatal_error_log_tmp;
log.debug("log_proccessing_1_tMap_1 - Outputting the record " + count_log_proccessing_1_fatal_error_log_log_proccessing_1_tMap_1 + " of the output table 'log_proccessing_1_fatal_error_log'.");

} // closing filter/reject

// # Output table : 'log_proccessing_1_warn_log'
// # Filter conditions 
if( 

log_proccessing_1_row1.priority == 4

 ) {
count_log_proccessing_1_warn_log_log_proccessing_1_tMap_1++;

log_proccessing_1_warn_log_tmp.moment = log_proccessing_1_row1.moment ;
log_proccessing_1_warn_log_tmp.pid = log_proccessing_1_row1.pid ;
log_proccessing_1_warn_log_tmp.root_pid = log_proccessing_1_row1.root_pid ;
log_proccessing_1_warn_log_tmp.father_pid = log_proccessing_1_row1.father_pid ;
log_proccessing_1_warn_log_tmp.project = log_proccessing_1_row1.project ;
log_proccessing_1_warn_log_tmp.job = log_proccessing_1_row1.job ;
log_proccessing_1_warn_log_tmp.context = log_proccessing_1_row1.context ;
log_proccessing_1_warn_log_tmp.priority = log_proccessing_1_row1.priority ;
log_proccessing_1_warn_log_tmp.type = log_proccessing_1_row1.type ;
log_proccessing_1_warn_log_tmp.origin = log_proccessing_1_row1.origin ;
log_proccessing_1_warn_log_tmp.message = log_proccessing_1_row1.message ;
log_proccessing_1_warn_log_tmp.code = log_proccessing_1_row1.code ;
log_proccessing_1_warn_log = log_proccessing_1_warn_log_tmp;
log.debug("log_proccessing_1_tMap_1 - Outputting the record " + count_log_proccessing_1_warn_log_log_proccessing_1_tMap_1 + " of the output table 'log_proccessing_1_warn_log'.");

} // closing filter/reject
// ###############################

} // end of Var scope

rejectedInnerJoin_log_proccessing_1_tMap_1 = false;










 


	tos_count_log_proccessing_1_tMap_1++;

/**
 * [log_proccessing_1_tMap_1 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tMap_1";

	

 



/**
 * [log_proccessing_1_tMap_1 process_data_begin ] stop
 */
// Start of branch "log_proccessing_1_Info_log"
if(log_proccessing_1_Info_log != null) { 



	
	/**
	 * [log_proccessing_1_tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_1";

	

			//log_proccessing_1_Info_log
			//log_proccessing_1_Info_log


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_Info_log"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_Info_log - " + (log_proccessing_1_Info_log==null? "": log_proccessing_1_Info_log.toLogString()));
    			}
    		
///////////////////////		
						



				strBuffer_log_proccessing_1_tLogRow_1 = new StringBuilder();




				strBuffer_log_proccessing_1_tLogRow_1.append("moment: ");
   				
	    		if(log_proccessing_1_Info_log.moment != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
								FormatterUtils.format_Date(log_proccessing_1_Info_log.moment, "yyyy-MM-dd HH:mm:ss")				
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("pid: ");
   				
	    		if(log_proccessing_1_Info_log.pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("root_pid: ");
   				
	    		if(log_proccessing_1_Info_log.root_pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.root_pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("father_pid: ");
   				
	    		if(log_proccessing_1_Info_log.father_pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.father_pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("project: ");
   				
	    		if(log_proccessing_1_Info_log.project != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.project)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("job: ");
   				
	    		if(log_proccessing_1_Info_log.job != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.job)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("context: ");
   				
	    		if(log_proccessing_1_Info_log.context != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.context)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("priority: ");
   				
	    		if(log_proccessing_1_Info_log.priority != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.priority)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("type: ");
   				
	    		if(log_proccessing_1_Info_log.type != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.type)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("origin: ");
   				
	    		if(log_proccessing_1_Info_log.origin != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.origin)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("message: ");
   				
	    		if(log_proccessing_1_Info_log.message != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.message)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_1.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_1.append("code: ");
   				
	    		if(log_proccessing_1_Info_log.code != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_1.append(
				                String.valueOf(log_proccessing_1_Info_log.code)							
				);


							
	    		} //  			
 

                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_log_proccessing_1_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_log_proccessing_1_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_log_proccessing_1_tLogRow_1);
                    }
                    	log.info("log_proccessing_1_tLogRow_1 - Content of row "+(nb_line_log_proccessing_1_tLogRow_1+1)+": " + strBuffer_log_proccessing_1_tLogRow_1.toString());
                    consoleOut_log_proccessing_1_tLogRow_1.println(strBuffer_log_proccessing_1_tLogRow_1.toString());
                    consoleOut_log_proccessing_1_tLogRow_1.flush();
                    nb_line_log_proccessing_1_tLogRow_1++;
//////

//////                    
                    
///////////////////////    			

 
     log_proccessing_1_row2 = log_proccessing_1_Info_log;


	tos_count_log_proccessing_1_tLogRow_1++;

/**
 * [log_proccessing_1_tLogRow_1 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_1";

	

 



/**
 * [log_proccessing_1_tLogRow_1 process_data_begin ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_1 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_1";

	

			//log_proccessing_1_row2
			//log_proccessing_1_row2


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_row2"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_row2 - " + (log_proccessing_1_row2==null? "": log_proccessing_1_row2.toLogString()));
    			}
    		


                    StringBuilder sb_log_proccessing_1_tFileOutputDelimited_1 = new StringBuilder();
                            if(log_proccessing_1_row2.moment != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            FormatterUtils.format_Date(log_proccessing_1_row2.moment, "yyyy-MM-dd HH:mm:ss")
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.root_pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.root_pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.father_pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.father_pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.project != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.project
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.job != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.job
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.context != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.context
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.priority != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.priority
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.type != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.type
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.origin != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.origin
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.message != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.message
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
                            if(log_proccessing_1_row2.code != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_1.append(
                            log_proccessing_1_row2.code
                        );
                            }
                    sb_log_proccessing_1_tFileOutputDelimited_1.append(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_1);


                    nb_line_log_proccessing_1_tFileOutputDelimited_1++;
                    resourceMap.put("nb_line_log_proccessing_1_tFileOutputDelimited_1", nb_line_log_proccessing_1_tFileOutputDelimited_1);

                        outlog_proccessing_1_tFileOutputDelimited_1.write(sb_log_proccessing_1_tFileOutputDelimited_1.toString());
                        log.debug("log_proccessing_1_tFileOutputDelimited_1 - Writing the record " + nb_line_log_proccessing_1_tFileOutputDelimited_1 + ".");




 


	tos_count_log_proccessing_1_tFileOutputDelimited_1++;

/**
 * [log_proccessing_1_tFileOutputDelimited_1 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_1";

	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_1 process_data_begin ] stop
 */
	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_1 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_1";

	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_1 process_data_end ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_1";

	

 



/**
 * [log_proccessing_1_tLogRow_1 process_data_end ] stop
 */

} // End of branch "log_proccessing_1_Info_log"




// Start of branch "log_proccessing_1_debug_log"
if(log_proccessing_1_debug_log != null) { 



	
	/**
	 * [log_proccessing_1_tLogRow_2 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_2";

	

			//log_proccessing_1_debug_log
			//log_proccessing_1_debug_log


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_debug_log"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_debug_log - " + (log_proccessing_1_debug_log==null? "": log_proccessing_1_debug_log.toLogString()));
    			}
    		
///////////////////////		
						



				strBuffer_log_proccessing_1_tLogRow_2 = new StringBuilder();




				strBuffer_log_proccessing_1_tLogRow_2.append("moment: ");
   				
	    		if(log_proccessing_1_debug_log.moment != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
								FormatterUtils.format_Date(log_proccessing_1_debug_log.moment, "yyyy-MM-dd HH:mm:ss")				
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("pid: ");
   				
	    		if(log_proccessing_1_debug_log.pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("root_pid: ");
   				
	    		if(log_proccessing_1_debug_log.root_pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.root_pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("father_pid: ");
   				
	    		if(log_proccessing_1_debug_log.father_pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.father_pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("project: ");
   				
	    		if(log_proccessing_1_debug_log.project != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.project)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("job: ");
   				
	    		if(log_proccessing_1_debug_log.job != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.job)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("context: ");
   				
	    		if(log_proccessing_1_debug_log.context != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.context)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("priority: ");
   				
	    		if(log_proccessing_1_debug_log.priority != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.priority)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("type: ");
   				
	    		if(log_proccessing_1_debug_log.type != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.type)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("origin: ");
   				
	    		if(log_proccessing_1_debug_log.origin != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.origin)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("message: ");
   				
	    		if(log_proccessing_1_debug_log.message != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.message)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_2.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_2.append("code: ");
   				
	    		if(log_proccessing_1_debug_log.code != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_2.append(
				                String.valueOf(log_proccessing_1_debug_log.code)							
				);


							
	    		} //  			
 

                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_log_proccessing_1_tLogRow_2 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_log_proccessing_1_tLogRow_2 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_log_proccessing_1_tLogRow_2);
                    }
                    	log.info("log_proccessing_1_tLogRow_2 - Content of row "+(nb_line_log_proccessing_1_tLogRow_2+1)+": " + strBuffer_log_proccessing_1_tLogRow_2.toString());
                    consoleOut_log_proccessing_1_tLogRow_2.println(strBuffer_log_proccessing_1_tLogRow_2.toString());
                    consoleOut_log_proccessing_1_tLogRow_2.flush();
                    nb_line_log_proccessing_1_tLogRow_2++;
//////

//////                    
                    
///////////////////////    			

 
     log_proccessing_1_row3 = log_proccessing_1_debug_log;


	tos_count_log_proccessing_1_tLogRow_2++;

/**
 * [log_proccessing_1_tLogRow_2 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tLogRow_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_2";

	

 



/**
 * [log_proccessing_1_tLogRow_2 process_data_begin ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_2 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_2";

	

			//log_proccessing_1_row3
			//log_proccessing_1_row3


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_row3"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_row3 - " + (log_proccessing_1_row3==null? "": log_proccessing_1_row3.toLogString()));
    			}
    		


                    StringBuilder sb_log_proccessing_1_tFileOutputDelimited_2 = new StringBuilder();
                            if(log_proccessing_1_row3.moment != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            FormatterUtils.format_Date(log_proccessing_1_row3.moment, "yyyy-MM-dd HH:mm:ss")
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.root_pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.root_pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.father_pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.father_pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.project != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.project
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.job != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.job
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.context != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.context
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.priority != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.priority
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.type != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.type
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.origin != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.origin
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.message != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.message
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
                            if(log_proccessing_1_row3.code != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_2.append(
                            log_proccessing_1_row3.code
                        );
                            }
                    sb_log_proccessing_1_tFileOutputDelimited_2.append(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_2);


                    nb_line_log_proccessing_1_tFileOutputDelimited_2++;
                    resourceMap.put("nb_line_log_proccessing_1_tFileOutputDelimited_2", nb_line_log_proccessing_1_tFileOutputDelimited_2);

                        outlog_proccessing_1_tFileOutputDelimited_2.write(sb_log_proccessing_1_tFileOutputDelimited_2.toString());
                        log.debug("log_proccessing_1_tFileOutputDelimited_2 - Writing the record " + nb_line_log_proccessing_1_tFileOutputDelimited_2 + ".");




 


	tos_count_log_proccessing_1_tFileOutputDelimited_2++;

/**
 * [log_proccessing_1_tFileOutputDelimited_2 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_2";

	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_2 process_data_begin ] stop
 */
	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_2 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_2";

	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_2 process_data_end ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogRow_2 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_2";

	

 



/**
 * [log_proccessing_1_tLogRow_2 process_data_end ] stop
 */

} // End of branch "log_proccessing_1_debug_log"




// Start of branch "log_proccessing_1_error_log"
if(log_proccessing_1_error_log != null) { 



	
	/**
	 * [log_proccessing_1_tLogRow_3 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_3";

	

			//log_proccessing_1_error_log
			//log_proccessing_1_error_log


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_error_log"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_error_log - " + (log_proccessing_1_error_log==null? "": log_proccessing_1_error_log.toLogString()));
    			}
    		
///////////////////////		
						



				strBuffer_log_proccessing_1_tLogRow_3 = new StringBuilder();




				strBuffer_log_proccessing_1_tLogRow_3.append("moment: ");
   				
	    		if(log_proccessing_1_error_log.moment != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
								FormatterUtils.format_Date(log_proccessing_1_error_log.moment, "yyyy-MM-dd HH:mm:ss")				
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("pid: ");
   				
	    		if(log_proccessing_1_error_log.pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("root_pid: ");
   				
	    		if(log_proccessing_1_error_log.root_pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.root_pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("father_pid: ");
   				
	    		if(log_proccessing_1_error_log.father_pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.father_pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("project: ");
   				
	    		if(log_proccessing_1_error_log.project != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.project)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("job: ");
   				
	    		if(log_proccessing_1_error_log.job != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.job)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("context: ");
   				
	    		if(log_proccessing_1_error_log.context != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.context)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("priority: ");
   				
	    		if(log_proccessing_1_error_log.priority != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.priority)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("type: ");
   				
	    		if(log_proccessing_1_error_log.type != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.type)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("origin: ");
   				
	    		if(log_proccessing_1_error_log.origin != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.origin)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("message: ");
   				
	    		if(log_proccessing_1_error_log.message != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.message)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_3.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_3.append("code: ");
   				
	    		if(log_proccessing_1_error_log.code != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_3.append(
				                String.valueOf(log_proccessing_1_error_log.code)							
				);


							
	    		} //  			
 

                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_log_proccessing_1_tLogRow_3 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_log_proccessing_1_tLogRow_3 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_log_proccessing_1_tLogRow_3);
                    }
                    	log.info("log_proccessing_1_tLogRow_3 - Content of row "+(nb_line_log_proccessing_1_tLogRow_3+1)+": " + strBuffer_log_proccessing_1_tLogRow_3.toString());
                    consoleOut_log_proccessing_1_tLogRow_3.println(strBuffer_log_proccessing_1_tLogRow_3.toString());
                    consoleOut_log_proccessing_1_tLogRow_3.flush();
                    nb_line_log_proccessing_1_tLogRow_3++;
//////

//////                    
                    
///////////////////////    			

 
     log_proccessing_1_row5 = log_proccessing_1_error_log;


	tos_count_log_proccessing_1_tLogRow_3++;

/**
 * [log_proccessing_1_tLogRow_3 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tLogRow_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_3";

	

 



/**
 * [log_proccessing_1_tLogRow_3 process_data_begin ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_4 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_4";

	

			//log_proccessing_1_row5
			//log_proccessing_1_row5


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_row5"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_row5 - " + (log_proccessing_1_row5==null? "": log_proccessing_1_row5.toLogString()));
    			}
    		


                    StringBuilder sb_log_proccessing_1_tFileOutputDelimited_4 = new StringBuilder();
                            if(log_proccessing_1_row5.moment != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            FormatterUtils.format_Date(log_proccessing_1_row5.moment, "yyyy-MM-dd HH:mm:ss")
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.root_pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.root_pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.father_pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.father_pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.project != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.project
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.job != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.job
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.context != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.context
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.priority != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.priority
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.type != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.type
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.origin != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.origin
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.message != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.message
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
                            if(log_proccessing_1_row5.code != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_4.append(
                            log_proccessing_1_row5.code
                        );
                            }
                    sb_log_proccessing_1_tFileOutputDelimited_4.append(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_4);


                    nb_line_log_proccessing_1_tFileOutputDelimited_4++;
                    resourceMap.put("nb_line_log_proccessing_1_tFileOutputDelimited_4", nb_line_log_proccessing_1_tFileOutputDelimited_4);

                        outlog_proccessing_1_tFileOutputDelimited_4.write(sb_log_proccessing_1_tFileOutputDelimited_4.toString());
                        log.debug("log_proccessing_1_tFileOutputDelimited_4 - Writing the record " + nb_line_log_proccessing_1_tFileOutputDelimited_4 + ".");




 


	tos_count_log_proccessing_1_tFileOutputDelimited_4++;

/**
 * [log_proccessing_1_tFileOutputDelimited_4 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_4";

	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_4 process_data_begin ] stop
 */
	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_4 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_4";

	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_4 process_data_end ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogRow_3 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_3";

	

 



/**
 * [log_proccessing_1_tLogRow_3 process_data_end ] stop
 */

} // End of branch "log_proccessing_1_error_log"




// Start of branch "log_proccessing_1_fatal_error_log"
if(log_proccessing_1_fatal_error_log != null) { 



	
	/**
	 * [log_proccessing_1_tLogRow_4 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_4";

	

			//log_proccessing_1_fatal_error_log
			//log_proccessing_1_fatal_error_log


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_fatal_error_log"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_fatal_error_log - " + (log_proccessing_1_fatal_error_log==null? "": log_proccessing_1_fatal_error_log.toLogString()));
    			}
    		
///////////////////////		
						



				strBuffer_log_proccessing_1_tLogRow_4 = new StringBuilder();




				strBuffer_log_proccessing_1_tLogRow_4.append("moment: ");
   				
	    		if(log_proccessing_1_fatal_error_log.moment != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
								FormatterUtils.format_Date(log_proccessing_1_fatal_error_log.moment, "yyyy-MM-dd HH:mm:ss")				
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("pid: ");
   				
	    		if(log_proccessing_1_fatal_error_log.pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("root_pid: ");
   				
	    		if(log_proccessing_1_fatal_error_log.root_pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.root_pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("father_pid: ");
   				
	    		if(log_proccessing_1_fatal_error_log.father_pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.father_pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("project: ");
   				
	    		if(log_proccessing_1_fatal_error_log.project != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.project)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("job: ");
   				
	    		if(log_proccessing_1_fatal_error_log.job != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.job)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("context: ");
   				
	    		if(log_proccessing_1_fatal_error_log.context != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.context)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("priority: ");
   				
	    		if(log_proccessing_1_fatal_error_log.priority != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.priority)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("type: ");
   				
	    		if(log_proccessing_1_fatal_error_log.type != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.type)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("origin: ");
   				
	    		if(log_proccessing_1_fatal_error_log.origin != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.origin)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("message: ");
   				
	    		if(log_proccessing_1_fatal_error_log.message != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.message)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_4.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_4.append("code: ");
   				
	    		if(log_proccessing_1_fatal_error_log.code != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_4.append(
				                String.valueOf(log_proccessing_1_fatal_error_log.code)							
				);


							
	    		} //  			
 

                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_log_proccessing_1_tLogRow_4 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_log_proccessing_1_tLogRow_4 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_log_proccessing_1_tLogRow_4);
                    }
                    	log.info("log_proccessing_1_tLogRow_4 - Content of row "+(nb_line_log_proccessing_1_tLogRow_4+1)+": " + strBuffer_log_proccessing_1_tLogRow_4.toString());
                    consoleOut_log_proccessing_1_tLogRow_4.println(strBuffer_log_proccessing_1_tLogRow_4.toString());
                    consoleOut_log_proccessing_1_tLogRow_4.flush();
                    nb_line_log_proccessing_1_tLogRow_4++;
//////

//////                    
                    
///////////////////////    			

 
     log_proccessing_1_row6 = log_proccessing_1_fatal_error_log;


	tos_count_log_proccessing_1_tLogRow_4++;

/**
 * [log_proccessing_1_tLogRow_4 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tLogRow_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_4";

	

 



/**
 * [log_proccessing_1_tLogRow_4 process_data_begin ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_5 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_5";

	

			//log_proccessing_1_row6
			//log_proccessing_1_row6


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_row6"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_row6 - " + (log_proccessing_1_row6==null? "": log_proccessing_1_row6.toLogString()));
    			}
    		


                    StringBuilder sb_log_proccessing_1_tFileOutputDelimited_5 = new StringBuilder();
                            if(log_proccessing_1_row6.moment != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            FormatterUtils.format_Date(log_proccessing_1_row6.moment, "yyyy-MM-dd HH:mm:ss")
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.root_pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.root_pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.father_pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.father_pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.project != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.project
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.job != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.job
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.context != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.context
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.priority != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.priority
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.type != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.type
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.origin != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.origin
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.message != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.message
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
                            if(log_proccessing_1_row6.code != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_5.append(
                            log_proccessing_1_row6.code
                        );
                            }
                    sb_log_proccessing_1_tFileOutputDelimited_5.append(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_5);


                    nb_line_log_proccessing_1_tFileOutputDelimited_5++;
                    resourceMap.put("nb_line_log_proccessing_1_tFileOutputDelimited_5", nb_line_log_proccessing_1_tFileOutputDelimited_5);

                        outlog_proccessing_1_tFileOutputDelimited_5.write(sb_log_proccessing_1_tFileOutputDelimited_5.toString());
                        log.debug("log_proccessing_1_tFileOutputDelimited_5 - Writing the record " + nb_line_log_proccessing_1_tFileOutputDelimited_5 + ".");




 


	tos_count_log_proccessing_1_tFileOutputDelimited_5++;

/**
 * [log_proccessing_1_tFileOutputDelimited_5 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_5";

	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_5 process_data_begin ] stop
 */
	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_5 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_5";

	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_5 process_data_end ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogRow_4 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_4";

	

 



/**
 * [log_proccessing_1_tLogRow_4 process_data_end ] stop
 */

} // End of branch "log_proccessing_1_fatal_error_log"




// Start of branch "log_proccessing_1_warn_log"
if(log_proccessing_1_warn_log != null) { 



	
	/**
	 * [log_proccessing_1_tLogRow_5 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_5";

	

			//log_proccessing_1_warn_log
			//log_proccessing_1_warn_log


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_warn_log"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_warn_log - " + (log_proccessing_1_warn_log==null? "": log_proccessing_1_warn_log.toLogString()));
    			}
    		
///////////////////////		
						



				strBuffer_log_proccessing_1_tLogRow_5 = new StringBuilder();




				strBuffer_log_proccessing_1_tLogRow_5.append("moment: ");
   				
	    		if(log_proccessing_1_warn_log.moment != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
								FormatterUtils.format_Date(log_proccessing_1_warn_log.moment, "yyyy-MM-dd HH:mm:ss")				
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("pid: ");
   				
	    		if(log_proccessing_1_warn_log.pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("root_pid: ");
   				
	    		if(log_proccessing_1_warn_log.root_pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.root_pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("father_pid: ");
   				
	    		if(log_proccessing_1_warn_log.father_pid != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.father_pid)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("project: ");
   				
	    		if(log_proccessing_1_warn_log.project != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.project)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("job: ");
   				
	    		if(log_proccessing_1_warn_log.job != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.job)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("context: ");
   				
	    		if(log_proccessing_1_warn_log.context != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.context)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("priority: ");
   				
	    		if(log_proccessing_1_warn_log.priority != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.priority)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("type: ");
   				
	    		if(log_proccessing_1_warn_log.type != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.type)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("origin: ");
   				
	    		if(log_proccessing_1_warn_log.origin != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.origin)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("message: ");
   				
	    		if(log_proccessing_1_warn_log.message != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.message)							
				);


							
	    		} //  			

    			strBuffer_log_proccessing_1_tLogRow_5.append("|");
    			


				strBuffer_log_proccessing_1_tLogRow_5.append("code: ");
   				
	    		if(log_proccessing_1_warn_log.code != null) { //              
                    							
       
				strBuffer_log_proccessing_1_tLogRow_5.append(
				                String.valueOf(log_proccessing_1_warn_log.code)							
				);


							
	    		} //  			
 

                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_log_proccessing_1_tLogRow_5 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_log_proccessing_1_tLogRow_5 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_log_proccessing_1_tLogRow_5);
                    }
                    	log.info("log_proccessing_1_tLogRow_5 - Content of row "+(nb_line_log_proccessing_1_tLogRow_5+1)+": " + strBuffer_log_proccessing_1_tLogRow_5.toString());
                    consoleOut_log_proccessing_1_tLogRow_5.println(strBuffer_log_proccessing_1_tLogRow_5.toString());
                    consoleOut_log_proccessing_1_tLogRow_5.flush();
                    nb_line_log_proccessing_1_tLogRow_5++;
//////

//////                    
                    
///////////////////////    			

 
     log_proccessing_1_row4 = log_proccessing_1_warn_log;


	tos_count_log_proccessing_1_tLogRow_5++;

/**
 * [log_proccessing_1_tLogRow_5 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tLogRow_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_5";

	

 



/**
 * [log_proccessing_1_tLogRow_5 process_data_begin ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_3 main ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_3";

	

			//log_proccessing_1_row4
			//log_proccessing_1_row4


			
				if(execStat){
					runStat.updateStatOnConnection("log_proccessing_1_row4"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("log_proccessing_1_row4 - " + (log_proccessing_1_row4==null? "": log_proccessing_1_row4.toLogString()));
    			}
    		


                    StringBuilder sb_log_proccessing_1_tFileOutputDelimited_3 = new StringBuilder();
                            if(log_proccessing_1_row4.moment != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            FormatterUtils.format_Date(log_proccessing_1_row4.moment, "yyyy-MM-dd HH:mm:ss")
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.root_pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.root_pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.father_pid != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.father_pid
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.project != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.project
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.job != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.job
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.context != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.context
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.priority != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.priority
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.type != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.type
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.origin != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.origin
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.message != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.message
                        );
                            }
                            sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
                            if(log_proccessing_1_row4.code != null) {
                        sb_log_proccessing_1_tFileOutputDelimited_3.append(
                            log_proccessing_1_row4.code
                        );
                            }
                    sb_log_proccessing_1_tFileOutputDelimited_3.append(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_3);


                    nb_line_log_proccessing_1_tFileOutputDelimited_3++;
                    resourceMap.put("nb_line_log_proccessing_1_tFileOutputDelimited_3", nb_line_log_proccessing_1_tFileOutputDelimited_3);

                        outlog_proccessing_1_tFileOutputDelimited_3.write(sb_log_proccessing_1_tFileOutputDelimited_3.toString());
                        log.debug("log_proccessing_1_tFileOutputDelimited_3 - Writing the record " + nb_line_log_proccessing_1_tFileOutputDelimited_3 + ".");




 


	tos_count_log_proccessing_1_tFileOutputDelimited_3++;

/**
 * [log_proccessing_1_tFileOutputDelimited_3 main ] stop
 */
	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_3";

	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_3 process_data_begin ] stop
 */
	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_3 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_3";

	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_3 process_data_end ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogRow_5 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_5";

	

 



/**
 * [log_proccessing_1_tLogRow_5 process_data_end ] stop
 */

} // End of branch "log_proccessing_1_warn_log"




	
	/**
	 * [log_proccessing_1_tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tMap_1";

	

 



/**
 * [log_proccessing_1_tMap_1 process_data_end ] stop
 */



	
	/**
	 * [log_proccessing_1_tLogCatcher_1 process_data_end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogCatcher_1";

	

 



/**
 * [log_proccessing_1_tLogCatcher_1 process_data_end ] stop
 */
	
	/**
	 * [log_proccessing_1_tLogCatcher_1 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogCatcher_1";

	
	}
} catch (Exception e_log_proccessing_1_tLogCatcher_1) {
	logIgnoredError(String.format("log_proccessing_1_tLogCatcher_1 - tLogCatcher failed to process log message(s) due to internal error: %s", e_log_proccessing_1_tLogCatcher_1), e_log_proccessing_1_tLogCatcher_1);
}

 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogCatcher_1 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tLogCatcher_1", true);
end_Hash.put("log_proccessing_1_tLogCatcher_1", System.currentTimeMillis());




/**
 * [log_proccessing_1_tLogCatcher_1 end ] stop
 */

	
	/**
	 * [log_proccessing_1_tMap_1 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tMap_1";

	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("log_proccessing_1_tMap_1 - Written records count in the table 'log_proccessing_1_Info_log': " + count_log_proccessing_1_Info_log_log_proccessing_1_tMap_1 + ".");
				log.debug("log_proccessing_1_tMap_1 - Written records count in the table 'log_proccessing_1_debug_log': " + count_log_proccessing_1_debug_log_log_proccessing_1_tMap_1 + ".");
				log.debug("log_proccessing_1_tMap_1 - Written records count in the table 'log_proccessing_1_error_log': " + count_log_proccessing_1_error_log_log_proccessing_1_tMap_1 + ".");
				log.debug("log_proccessing_1_tMap_1 - Written records count in the table 'log_proccessing_1_fatal_error_log': " + count_log_proccessing_1_fatal_error_log_log_proccessing_1_tMap_1 + ".");
				log.debug("log_proccessing_1_tMap_1 - Written records count in the table 'log_proccessing_1_warn_log': " + count_log_proccessing_1_warn_log_log_proccessing_1_tMap_1 + ".");





			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_row1"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tMap_1 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tMap_1", true);
end_Hash.put("log_proccessing_1_tMap_1", System.currentTimeMillis());




/**
 * [log_proccessing_1_tMap_1 end ] stop
 */

	
	/**
	 * [log_proccessing_1_tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_1";

	


//////
//////
globalMap.put("log_proccessing_1_tLogRow_1_NB_LINE",nb_line_log_proccessing_1_tLogRow_1);
                if(log.isInfoEnabled())
            log.info("log_proccessing_1_tLogRow_1 - "  + ("Printed row count: ")  + (nb_line_log_proccessing_1_tLogRow_1)  + (".") );

///////////////////////    			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_Info_log"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_1 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tLogRow_1", true);
end_Hash.put("log_proccessing_1_tLogRow_1", System.currentTimeMillis());




/**
 * [log_proccessing_1_tLogRow_1 end ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_1 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_1";

	



		
			
					if(outlog_proccessing_1_tFileOutputDelimited_1!=null) {
						outlog_proccessing_1_tFileOutputDelimited_1.flush();
						outlog_proccessing_1_tFileOutputDelimited_1.close();
					}
				
				globalMap.put("log_proccessing_1_tFileOutputDelimited_1_NB_LINE",nb_line_log_proccessing_1_tFileOutputDelimited_1);
				globalMap.put("log_proccessing_1_tFileOutputDelimited_1_FILE_NAME",fileName_log_proccessing_1_tFileOutputDelimited_1);
			
		
		
		resourceMap.put("finish_log_proccessing_1_tFileOutputDelimited_1", true);
	
				log.debug("log_proccessing_1_tFileOutputDelimited_1 - Written records count: " + nb_line_log_proccessing_1_tFileOutputDelimited_1 + " .");
			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_row2"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_1 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tFileOutputDelimited_1", true);
end_Hash.put("log_proccessing_1_tFileOutputDelimited_1", System.currentTimeMillis());




/**
 * [log_proccessing_1_tFileOutputDelimited_1 end ] stop
 */







	
	/**
	 * [log_proccessing_1_tLogRow_2 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_2";

	


//////
//////
globalMap.put("log_proccessing_1_tLogRow_2_NB_LINE",nb_line_log_proccessing_1_tLogRow_2);
                if(log.isInfoEnabled())
            log.info("log_proccessing_1_tLogRow_2 - "  + ("Printed row count: ")  + (nb_line_log_proccessing_1_tLogRow_2)  + (".") );

///////////////////////    			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_debug_log"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_2 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tLogRow_2", true);
end_Hash.put("log_proccessing_1_tLogRow_2", System.currentTimeMillis());




/**
 * [log_proccessing_1_tLogRow_2 end ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_2 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_2";

	



		
			
					if(outlog_proccessing_1_tFileOutputDelimited_2!=null) {
						outlog_proccessing_1_tFileOutputDelimited_2.flush();
						outlog_proccessing_1_tFileOutputDelimited_2.close();
					}
				
				globalMap.put("log_proccessing_1_tFileOutputDelimited_2_NB_LINE",nb_line_log_proccessing_1_tFileOutputDelimited_2);
				globalMap.put("log_proccessing_1_tFileOutputDelimited_2_FILE_NAME",fileName_log_proccessing_1_tFileOutputDelimited_2);
			
		
		
		resourceMap.put("finish_log_proccessing_1_tFileOutputDelimited_2", true);
	
				log.debug("log_proccessing_1_tFileOutputDelimited_2 - Written records count: " + nb_line_log_proccessing_1_tFileOutputDelimited_2 + " .");
			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_row3"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_2 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tFileOutputDelimited_2", true);
end_Hash.put("log_proccessing_1_tFileOutputDelimited_2", System.currentTimeMillis());




/**
 * [log_proccessing_1_tFileOutputDelimited_2 end ] stop
 */







	
	/**
	 * [log_proccessing_1_tLogRow_3 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_3";

	


//////
//////
globalMap.put("log_proccessing_1_tLogRow_3_NB_LINE",nb_line_log_proccessing_1_tLogRow_3);
                if(log.isInfoEnabled())
            log.info("log_proccessing_1_tLogRow_3 - "  + ("Printed row count: ")  + (nb_line_log_proccessing_1_tLogRow_3)  + (".") );

///////////////////////    			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_error_log"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_3 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tLogRow_3", true);
end_Hash.put("log_proccessing_1_tLogRow_3", System.currentTimeMillis());




/**
 * [log_proccessing_1_tLogRow_3 end ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_4 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_4";

	



		
			
					if(outlog_proccessing_1_tFileOutputDelimited_4!=null) {
						outlog_proccessing_1_tFileOutputDelimited_4.flush();
						outlog_proccessing_1_tFileOutputDelimited_4.close();
					}
				
				globalMap.put("log_proccessing_1_tFileOutputDelimited_4_NB_LINE",nb_line_log_proccessing_1_tFileOutputDelimited_4);
				globalMap.put("log_proccessing_1_tFileOutputDelimited_4_FILE_NAME",fileName_log_proccessing_1_tFileOutputDelimited_4);
			
		
		
		resourceMap.put("finish_log_proccessing_1_tFileOutputDelimited_4", true);
	
				log.debug("log_proccessing_1_tFileOutputDelimited_4 - Written records count: " + nb_line_log_proccessing_1_tFileOutputDelimited_4 + " .");
			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_row5"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_4 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tFileOutputDelimited_4", true);
end_Hash.put("log_proccessing_1_tFileOutputDelimited_4", System.currentTimeMillis());




/**
 * [log_proccessing_1_tFileOutputDelimited_4 end ] stop
 */







	
	/**
	 * [log_proccessing_1_tLogRow_4 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_4";

	


//////
//////
globalMap.put("log_proccessing_1_tLogRow_4_NB_LINE",nb_line_log_proccessing_1_tLogRow_4);
                if(log.isInfoEnabled())
            log.info("log_proccessing_1_tLogRow_4 - "  + ("Printed row count: ")  + (nb_line_log_proccessing_1_tLogRow_4)  + (".") );

///////////////////////    			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_fatal_error_log"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_4 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tLogRow_4", true);
end_Hash.put("log_proccessing_1_tLogRow_4", System.currentTimeMillis());




/**
 * [log_proccessing_1_tLogRow_4 end ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_5 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_5";

	



		
			
					if(outlog_proccessing_1_tFileOutputDelimited_5!=null) {
						outlog_proccessing_1_tFileOutputDelimited_5.flush();
						outlog_proccessing_1_tFileOutputDelimited_5.close();
					}
				
				globalMap.put("log_proccessing_1_tFileOutputDelimited_5_NB_LINE",nb_line_log_proccessing_1_tFileOutputDelimited_5);
				globalMap.put("log_proccessing_1_tFileOutputDelimited_5_FILE_NAME",fileName_log_proccessing_1_tFileOutputDelimited_5);
			
		
		
		resourceMap.put("finish_log_proccessing_1_tFileOutputDelimited_5", true);
	
				log.debug("log_proccessing_1_tFileOutputDelimited_5 - Written records count: " + nb_line_log_proccessing_1_tFileOutputDelimited_5 + " .");
			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_row6"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_5 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tFileOutputDelimited_5", true);
end_Hash.put("log_proccessing_1_tFileOutputDelimited_5", System.currentTimeMillis());




/**
 * [log_proccessing_1_tFileOutputDelimited_5 end ] stop
 */







	
	/**
	 * [log_proccessing_1_tLogRow_5 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_5";

	


//////
//////
globalMap.put("log_proccessing_1_tLogRow_5_NB_LINE",nb_line_log_proccessing_1_tLogRow_5);
                if(log.isInfoEnabled())
            log.info("log_proccessing_1_tLogRow_5 - "  + ("Printed row count: ")  + (nb_line_log_proccessing_1_tLogRow_5)  + (".") );

///////////////////////    			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_warn_log"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tLogRow_5 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tLogRow_5", true);
end_Hash.put("log_proccessing_1_tLogRow_5", System.currentTimeMillis());




/**
 * [log_proccessing_1_tLogRow_5 end ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_3 end ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_3";

	



		
			
					if(outlog_proccessing_1_tFileOutputDelimited_3!=null) {
						outlog_proccessing_1_tFileOutputDelimited_3.flush();
						outlog_proccessing_1_tFileOutputDelimited_3.close();
					}
				
				globalMap.put("log_proccessing_1_tFileOutputDelimited_3_NB_LINE",nb_line_log_proccessing_1_tFileOutputDelimited_3);
				globalMap.put("log_proccessing_1_tFileOutputDelimited_3_FILE_NAME",fileName_log_proccessing_1_tFileOutputDelimited_3);
			
		
		
		resourceMap.put("finish_log_proccessing_1_tFileOutputDelimited_3", true);
	
				log.debug("log_proccessing_1_tFileOutputDelimited_3 - Written records count: " + nb_line_log_proccessing_1_tFileOutputDelimited_3 + " .");
			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("log_proccessing_1_row4"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("log_proccessing_1_tFileOutputDelimited_3 - "  + ("Done.") );

ok_Hash.put("log_proccessing_1_tFileOutputDelimited_3", true);
end_Hash.put("log_proccessing_1_tFileOutputDelimited_3", System.currentTimeMillis());




/**
 * [log_proccessing_1_tFileOutputDelimited_3 end ] stop
 */









				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [log_proccessing_1_tLogCatcher_1 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogCatcher_1";

	

 



/**
 * [log_proccessing_1_tLogCatcher_1 finally ] stop
 */

	
	/**
	 * [log_proccessing_1_tMap_1 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tMap_1";

	

 



/**
 * [log_proccessing_1_tMap_1 finally ] stop
 */

	
	/**
	 * [log_proccessing_1_tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_1";

	

 



/**
 * [log_proccessing_1_tLogRow_1 finally ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_1 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_1";

	


		if(resourceMap.get("finish_log_proccessing_1_tFileOutputDelimited_1") == null){ 
			
				
						java.io.Writer outlog_proccessing_1_tFileOutputDelimited_1 = (java.io.Writer)resourceMap.get("out_log_proccessing_1_tFileOutputDelimited_1");
						if(outlog_proccessing_1_tFileOutputDelimited_1!=null) {
							outlog_proccessing_1_tFileOutputDelimited_1.flush();
							outlog_proccessing_1_tFileOutputDelimited_1.close();
						}
					
				
			
		}
	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_1 finally ] stop
 */







	
	/**
	 * [log_proccessing_1_tLogRow_2 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_2";

	

 



/**
 * [log_proccessing_1_tLogRow_2 finally ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_2 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_2";

	


		if(resourceMap.get("finish_log_proccessing_1_tFileOutputDelimited_2") == null){ 
			
				
						java.io.Writer outlog_proccessing_1_tFileOutputDelimited_2 = (java.io.Writer)resourceMap.get("out_log_proccessing_1_tFileOutputDelimited_2");
						if(outlog_proccessing_1_tFileOutputDelimited_2!=null) {
							outlog_proccessing_1_tFileOutputDelimited_2.flush();
							outlog_proccessing_1_tFileOutputDelimited_2.close();
						}
					
				
			
		}
	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_2 finally ] stop
 */







	
	/**
	 * [log_proccessing_1_tLogRow_3 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_3";

	

 



/**
 * [log_proccessing_1_tLogRow_3 finally ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_4 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_4";

	


		if(resourceMap.get("finish_log_proccessing_1_tFileOutputDelimited_4") == null){ 
			
				
						java.io.Writer outlog_proccessing_1_tFileOutputDelimited_4 = (java.io.Writer)resourceMap.get("out_log_proccessing_1_tFileOutputDelimited_4");
						if(outlog_proccessing_1_tFileOutputDelimited_4!=null) {
							outlog_proccessing_1_tFileOutputDelimited_4.flush();
							outlog_proccessing_1_tFileOutputDelimited_4.close();
						}
					
				
			
		}
	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_4 finally ] stop
 */







	
	/**
	 * [log_proccessing_1_tLogRow_4 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_4";

	

 



/**
 * [log_proccessing_1_tLogRow_4 finally ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_5 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_5";

	


		if(resourceMap.get("finish_log_proccessing_1_tFileOutputDelimited_5") == null){ 
			
				
						java.io.Writer outlog_proccessing_1_tFileOutputDelimited_5 = (java.io.Writer)resourceMap.get("out_log_proccessing_1_tFileOutputDelimited_5");
						if(outlog_proccessing_1_tFileOutputDelimited_5!=null) {
							outlog_proccessing_1_tFileOutputDelimited_5.flush();
							outlog_proccessing_1_tFileOutputDelimited_5.close();
						}
					
				
			
		}
	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_5 finally ] stop
 */







	
	/**
	 * [log_proccessing_1_tLogRow_5 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tLogRow_5";

	

 



/**
 * [log_proccessing_1_tLogRow_5 finally ] stop
 */

	
	/**
	 * [log_proccessing_1_tFileOutputDelimited_3 finally ] start
	 */

	

	
	
	currentComponent="log_proccessing_1_tFileOutputDelimited_3";

	


		if(resourceMap.get("finish_log_proccessing_1_tFileOutputDelimited_3") == null){ 
			
				
						java.io.Writer outlog_proccessing_1_tFileOutputDelimited_3 = (java.io.Writer)resourceMap.get("out_log_proccessing_1_tFileOutputDelimited_3");
						if(outlog_proccessing_1_tFileOutputDelimited_3!=null) {
							outlog_proccessing_1_tFileOutputDelimited_3.flush();
							outlog_proccessing_1_tFileOutputDelimited_3.close();
						}
					
				
			
		}
	

 



/**
 * [log_proccessing_1_tFileOutputDelimited_3 finally ] stop
 */









				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("log_proccessing_1_tLogCatcher_1_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    private PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final ChildJob ChildJobClass = new ChildJob();

        int exitCode = ChildJobClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'ChildJob' - Done.");
	        }

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";

        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }

	        if(!"".equals(log4jLevel)){
				if("trace".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					log.setLevel(org.apache.log4j.Level.OFF);
				}
				org.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());
    	    }
        	log.info("TalendJob: 'ChildJob' - Start.");
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = ChildJob.class.getClassLoader().getResourceAsStream("serverless_etl/childjob_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = ChildJob.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                //defaultProps is in order to keep the original context value
                defaultProps.load(inContext);
                inContext.close();
                context = new ContextProperties(defaultProps);
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
				    context.setContextType("name", "id_String");
				
                context.name=(String) context.getProperty("name");
				    context.setContextType("scope", "id_Integer");
				
             try{
                 context.scope=routines.system.ParserUtils.parseTo_Integer (context.getProperty("scope"));
             }catch(NumberFormatException e){
                    log.warn(String.format("Null value will be used for context parameter %s: %s", "scope", e.getMessage()));
                 context.scope=null;
              }
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }


        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("name")) {
                context.name = (String) parentContextMap.get("name");
            }if (parentContextMap.containsKey("scope")) {
                context.scope = (Integer) parentContextMap.get("scope");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();




this.globalResumeTicket = true;//to run tPreJob




this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tJava_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tJava_1) {
globalMap.put("tJava_1_SUBPROCESS_STATE", -1);

e_tJava_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : ChildJob");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;
    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();







        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        }else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		}

    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     326496 characters generated by Talend Data Management Platform 
 *     on the 11 January 2019 3:57:53 PM
 ************************************************************************************************/