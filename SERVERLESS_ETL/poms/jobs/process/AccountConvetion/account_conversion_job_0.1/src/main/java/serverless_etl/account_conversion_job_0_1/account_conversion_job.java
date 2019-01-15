package serverless_etl.account_conversion_job_0_1;

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

@SuppressWarnings("unused")
/**
 * Job: account_conversion_job Purpose: <br>
 * Description:  <br>
 * @author ali@versent.com.au
 * @version 7.1.1.20181026_1147
 * @status 
 */
public class account_conversion_job implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "account_conversion_job.log");
	}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(account_conversion_job.class);

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

	private final static String defaultCharset = java.nio.charset.Charset
			.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
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

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (host != null) {

				this.setProperty("host", host.toString());

			}

			if (port != null) {

				this.setProperty("port", port.toString());

			}

			if (database != null) {

				this.setProperty("database", database.toString());

			}

			if (username != null) {

				this.setProperty("username", username.toString());

			}

			if (password != null) {

				this.setProperty("password", password.toString());

			}

		}

		public String host;

		public String getHost() {
			return this.host;
		}

		public String port;

		public String getPort() {
			return this.port;
		}

		public String database;

		public String getDatabase() {
			return this.database;
		}

		public String username;

		public String getUsername() {
			return this.username;
		}

		public String password;

		public String getPassword() {
			return this.password;
		}
	}

	private ContextProperties context = new ContextProperties();

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "account_conversion_job";
	private final String projectName = "SERVERLESS_ETL";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(
			java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources
				.entrySet()) {
			talendDataSources.put(
					dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry
							.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap
				.put(KEY_DB_DATASOURCES_RAW,
						new java.util.HashMap<String, javax.sql.DataSource>(
								dataSources));
	}

	LogCatcherUtils log_proccessing_1_tLogCatcher_1 = new LogCatcherUtils();

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(
			new java.io.BufferedOutputStream(baos));

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

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent,
				final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
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
				if (virtualComponentName != null
						&& currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE",
							getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE",
						getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent
						+ " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					account_conversion_job.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(account_conversion_job.this, new Object[] {
									e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						log_proccessing_1_tLogCatcher_1.addMessage(
								"Java Exception", currentComponent, 6,
								e.getClass().getName() + ":" + e.getMessage(),
								1);
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

	public void log_proccessing_1_tLogCatcher_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tMap_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tLogRow_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tFileOutputDelimited_1_error(
			Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tLogRow_2_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tFileOutputDelimited_2_error(
			Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tLogRow_3_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tFileOutputDelimited_4_error(
			Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tLogRow_4_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tFileOutputDelimited_5_error(
			Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tLogRow_5_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void log_proccessing_1_tFileOutputDelimited_3_error(
			Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		log_proccessing_1_tLogCatcher_1_onSubJobError(exception,
				errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent,
				globalMap);
	}

	public void tContextLoad_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent,
				globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAggregateRow_1_AGGOUT_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		tAggregateRow_1_AGGIN_error(exception, errorComponent, globalMap);

	}

	public void tAggregateRow_1_AGGIN_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void log_proccessing_1_tLogCatcher_1_onSubJobError(
			Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFileInputDelimited_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_3_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class log_proccessing_1_row4Struct implements
			routines.system.IPersistableRow<log_proccessing_1_row4Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class log_proccessing_1_row6Struct implements
			routines.system.IPersistableRow<log_proccessing_1_row6Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class log_proccessing_1_row5Struct implements
			routines.system.IPersistableRow<log_proccessing_1_row5Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class log_proccessing_1_row3Struct implements
			routines.system.IPersistableRow<log_proccessing_1_row3Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class log_proccessing_1_row2Struct implements
			routines.system.IPersistableRow<log_proccessing_1_row2Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class log_proccessing_1_Info_logStruct implements
			routines.system.IPersistableRow<log_proccessing_1_Info_logStruct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class log_proccessing_1_debug_logStruct implements
			routines.system.IPersistableRow<log_proccessing_1_debug_logStruct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class log_proccessing_1_error_logStruct implements
			routines.system.IPersistableRow<log_proccessing_1_error_logStruct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class log_proccessing_1_fatal_error_logStruct
			implements
			routines.system.IPersistableRow<log_proccessing_1_fatal_error_logStruct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class log_proccessing_1_warn_logStruct implements
			routines.system.IPersistableRow<log_proccessing_1_warn_logStruct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class log_proccessing_1_row1Struct implements
			routines.system.IPersistableRow<log_proccessing_1_row1Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
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

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

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

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
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
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public void log_proccessing_1_tLogCatcher_1Process(
			final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("log_proccessing_1_tLogCatcher_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception()
						.getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
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
				start_Hash.put("log_proccessing_1_tFileOutputDelimited_1",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tFileOutputDelimited_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("log_proccessing_1_row2"
								+ iterateId, 0, 0);

					}
				}

				int tos_count_log_proccessing_1_tFileOutputDelimited_1 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tFileOutputDelimited_1 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tFileOutputDelimited_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tFileOutputDelimited_1 = new StringBuilder();
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("USESTREAM" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("FILENAME" + " = "
											+ "\"/tmp/INFO.csv\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("ROWSEPARATOR" + " = " + "\"\\n\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("FIELDSEPARATOR" + " = " + "\";\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("APPEND" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("INCLUDEHEADER" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("ADVANCED_SEPARATOR" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("CSV_OPTION" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("CREATE" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("SPLIT" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("FLUSHONROW" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("ROW_MODE" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("ENCODING" + " = "
											+ "\"ISO-8859-15\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append("DELETE_EMPTYFILE" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_1
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tFileOutputDelimited_1 - "
										+ (log4jParamters_log_proccessing_1_tFileOutputDelimited_1));
						}
					}
					new BytesLimit65535_log_proccessing_1_tFileOutputDelimited_1()
							.limitLog4jByte();
				}

				String fileName_log_proccessing_1_tFileOutputDelimited_1 = "";
				fileName_log_proccessing_1_tFileOutputDelimited_1 = (new java.io.File(
						"/tmp/INFO.csv")).getAbsolutePath().replace("\\", "/");
				String fullName_log_proccessing_1_tFileOutputDelimited_1 = null;
				String extension_log_proccessing_1_tFileOutputDelimited_1 = null;
				String directory_log_proccessing_1_tFileOutputDelimited_1 = null;
				if ((fileName_log_proccessing_1_tFileOutputDelimited_1
						.indexOf("/") != -1)) {
					if (fileName_log_proccessing_1_tFileOutputDelimited_1
							.lastIndexOf(".") < fileName_log_proccessing_1_tFileOutputDelimited_1
							.lastIndexOf("/")) {
						fullName_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1;
						extension_log_proccessing_1_tFileOutputDelimited_1 = "";
					} else {
						fullName_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1
								.substring(0,
										fileName_log_proccessing_1_tFileOutputDelimited_1
												.lastIndexOf("."));
						extension_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1
								.substring(fileName_log_proccessing_1_tFileOutputDelimited_1
										.lastIndexOf("."));
					}
					directory_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1
							.substring(0,
									fileName_log_proccessing_1_tFileOutputDelimited_1
											.lastIndexOf("/"));
				} else {
					if (fileName_log_proccessing_1_tFileOutputDelimited_1
							.lastIndexOf(".") != -1) {
						fullName_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1
								.substring(0,
										fileName_log_proccessing_1_tFileOutputDelimited_1
												.lastIndexOf("."));
						extension_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1
								.substring(fileName_log_proccessing_1_tFileOutputDelimited_1
										.lastIndexOf("."));
					} else {
						fullName_log_proccessing_1_tFileOutputDelimited_1 = fileName_log_proccessing_1_tFileOutputDelimited_1;
						extension_log_proccessing_1_tFileOutputDelimited_1 = "";
					}
					directory_log_proccessing_1_tFileOutputDelimited_1 = "";
				}
				boolean isFileGenerated_log_proccessing_1_tFileOutputDelimited_1 = true;
				java.io.File filelog_proccessing_1_tFileOutputDelimited_1 = new java.io.File(
						fileName_log_proccessing_1_tFileOutputDelimited_1);
				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_1_FILE_NAME",
						fileName_log_proccessing_1_tFileOutputDelimited_1);
				if (filelog_proccessing_1_tFileOutputDelimited_1.exists()) {
					isFileGenerated_log_proccessing_1_tFileOutputDelimited_1 = false;
				}
				int nb_line_log_proccessing_1_tFileOutputDelimited_1 = 0;
				int splitedFileNo_log_proccessing_1_tFileOutputDelimited_1 = 0;
				int currentRow_log_proccessing_1_tFileOutputDelimited_1 = 0;

				final String OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1 = /**
				 * 
				 * Start field
				 * log_proccessing_1_tFileOutputDelimited_1:FIELDSEPARATOR
				 */
				";"/**
				 * End field
				 * log_proccessing_1_tFileOutputDelimited_1:FIELDSEPARATOR
				 */
				;

				final String OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_1 = /**
				 * 
				 * Start field
				 * log_proccessing_1_tFileOutputDelimited_1:ROWSEPARATOR
				 */
				"\n"/**
				 * End field
				 * log_proccessing_1_tFileOutputDelimited_1:ROWSEPARATOR
				 */
				;

				// create directory only if not exists
				if (directory_log_proccessing_1_tFileOutputDelimited_1 != null
						&& directory_log_proccessing_1_tFileOutputDelimited_1
								.trim().length() != 0) {
					java.io.File dir_log_proccessing_1_tFileOutputDelimited_1 = new java.io.File(
							directory_log_proccessing_1_tFileOutputDelimited_1);
					if (!dir_log_proccessing_1_tFileOutputDelimited_1.exists()) {
						log.info("log_proccessing_1_tFileOutputDelimited_1 - Creating directory '"
								+ dir_log_proccessing_1_tFileOutputDelimited_1
										.getCanonicalPath() + "'.");
						dir_log_proccessing_1_tFileOutputDelimited_1.mkdirs();
						log.info("log_proccessing_1_tFileOutputDelimited_1 - The directory '"
								+ dir_log_proccessing_1_tFileOutputDelimited_1
										.getCanonicalPath()
								+ "' has been created successfully.");
					}
				}

				// routines.system.Row
				java.io.Writer outlog_proccessing_1_tFileOutputDelimited_1 = null;

				outlog_proccessing_1_tFileOutputDelimited_1 = new java.io.BufferedWriter(
						new java.io.OutputStreamWriter(
								new java.io.FileOutputStream(
										fileName_log_proccessing_1_tFileOutputDelimited_1,
										true), "ISO-8859-15"));
				if (filelog_proccessing_1_tFileOutputDelimited_1.length() == 0) {
					outlog_proccessing_1_tFileOutputDelimited_1.write("moment");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1.write("pid");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1
							.write("root_pid");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1
							.write("father_pid");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1
							.write("project");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1.write("job");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1
							.write("context");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1
							.write("priority");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1.write("type");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1.write("origin");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1
							.write("message");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1.write("code");
					outlog_proccessing_1_tFileOutputDelimited_1
							.write(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_1);
					outlog_proccessing_1_tFileOutputDelimited_1.flush();
				}

				resourceMap.put("out_log_proccessing_1_tFileOutputDelimited_1",
						outlog_proccessing_1_tFileOutputDelimited_1);
				resourceMap.put(
						"nb_line_log_proccessing_1_tFileOutputDelimited_1",
						nb_line_log_proccessing_1_tFileOutputDelimited_1);

				/**
				 * [log_proccessing_1_tFileOutputDelimited_1 begin ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_1 begin ] start
				 */

				ok_Hash.put("log_proccessing_1_tLogRow_1", false);
				start_Hash.put("log_proccessing_1_tLogRow_1",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tLogRow_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection(
								"log_proccessing_1_Info_log" + iterateId, 0, 0);

					}
				}

				int tos_count_log_proccessing_1_tLogRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogRow_1 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tLogRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tLogRow_1 = new StringBuilder();
							log4jParamters_log_proccessing_1_tLogRow_1
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append("BASIC_MODE" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append("VERTICAL" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append("PRINT_UNIQUE_NAME" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append("PRINT_COLNAMES" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append("USE_FIXED_LENGTH" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append("PRINT_CONTENT_WITH_LOG4J" + " = "
											+ "true");
							log4jParamters_log_proccessing_1_tLogRow_1
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tLogRow_1 - "
										+ (log4jParamters_log_proccessing_1_tLogRow_1));
						}
					}
					new BytesLimit65535_log_proccessing_1_tLogRow_1()
							.limitLog4jByte();
				}

				// /////////////////////

				final String OUTPUT_FIELD_SEPARATOR_log_proccessing_1_tLogRow_1 = "|";
				java.io.PrintStream consoleOut_log_proccessing_1_tLogRow_1 = null;

				StringBuilder strBuffer_log_proccessing_1_tLogRow_1 = null;
				int nb_line_log_proccessing_1_tLogRow_1 = 0;
				// /////////////////////

				/**
				 * [log_proccessing_1_tLogRow_1 begin ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_2 begin ] start
				 */

				ok_Hash.put("log_proccessing_1_tFileOutputDelimited_2", false);
				start_Hash.put("log_proccessing_1_tFileOutputDelimited_2",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tFileOutputDelimited_2";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("log_proccessing_1_row3"
								+ iterateId, 0, 0);

					}
				}

				int tos_count_log_proccessing_1_tFileOutputDelimited_2 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tFileOutputDelimited_2 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tFileOutputDelimited_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tFileOutputDelimited_2 = new StringBuilder();
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("USESTREAM" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("FILENAME" + " = "
											+ "\"/tmp/DEBUG.csv\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("ROWSEPARATOR" + " = " + "\"\\n\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("FIELDSEPARATOR" + " = " + "\";\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("APPEND" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("INCLUDEHEADER" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("ADVANCED_SEPARATOR" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("CSV_OPTION" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("CREATE" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("SPLIT" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("FLUSHONROW" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("ROW_MODE" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("ENCODING" + " = "
											+ "\"ISO-8859-15\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append("DELETE_EMPTYFILE" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_2
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tFileOutputDelimited_2 - "
										+ (log4jParamters_log_proccessing_1_tFileOutputDelimited_2));
						}
					}
					new BytesLimit65535_log_proccessing_1_tFileOutputDelimited_2()
							.limitLog4jByte();
				}

				String fileName_log_proccessing_1_tFileOutputDelimited_2 = "";
				fileName_log_proccessing_1_tFileOutputDelimited_2 = (new java.io.File(
						"/tmp/DEBUG.csv")).getAbsolutePath().replace("\\", "/");
				String fullName_log_proccessing_1_tFileOutputDelimited_2 = null;
				String extension_log_proccessing_1_tFileOutputDelimited_2 = null;
				String directory_log_proccessing_1_tFileOutputDelimited_2 = null;
				if ((fileName_log_proccessing_1_tFileOutputDelimited_2
						.indexOf("/") != -1)) {
					if (fileName_log_proccessing_1_tFileOutputDelimited_2
							.lastIndexOf(".") < fileName_log_proccessing_1_tFileOutputDelimited_2
							.lastIndexOf("/")) {
						fullName_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2;
						extension_log_proccessing_1_tFileOutputDelimited_2 = "";
					} else {
						fullName_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2
								.substring(0,
										fileName_log_proccessing_1_tFileOutputDelimited_2
												.lastIndexOf("."));
						extension_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2
								.substring(fileName_log_proccessing_1_tFileOutputDelimited_2
										.lastIndexOf("."));
					}
					directory_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2
							.substring(0,
									fileName_log_proccessing_1_tFileOutputDelimited_2
											.lastIndexOf("/"));
				} else {
					if (fileName_log_proccessing_1_tFileOutputDelimited_2
							.lastIndexOf(".") != -1) {
						fullName_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2
								.substring(0,
										fileName_log_proccessing_1_tFileOutputDelimited_2
												.lastIndexOf("."));
						extension_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2
								.substring(fileName_log_proccessing_1_tFileOutputDelimited_2
										.lastIndexOf("."));
					} else {
						fullName_log_proccessing_1_tFileOutputDelimited_2 = fileName_log_proccessing_1_tFileOutputDelimited_2;
						extension_log_proccessing_1_tFileOutputDelimited_2 = "";
					}
					directory_log_proccessing_1_tFileOutputDelimited_2 = "";
				}
				boolean isFileGenerated_log_proccessing_1_tFileOutputDelimited_2 = true;
				java.io.File filelog_proccessing_1_tFileOutputDelimited_2 = new java.io.File(
						fileName_log_proccessing_1_tFileOutputDelimited_2);
				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_2_FILE_NAME",
						fileName_log_proccessing_1_tFileOutputDelimited_2);
				if (filelog_proccessing_1_tFileOutputDelimited_2.exists()) {
					isFileGenerated_log_proccessing_1_tFileOutputDelimited_2 = false;
				}
				int nb_line_log_proccessing_1_tFileOutputDelimited_2 = 0;
				int splitedFileNo_log_proccessing_1_tFileOutputDelimited_2 = 0;
				int currentRow_log_proccessing_1_tFileOutputDelimited_2 = 0;

				final String OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2 = /**
				 * 
				 * Start field
				 * log_proccessing_1_tFileOutputDelimited_2:FIELDSEPARATOR
				 */
				";"/**
				 * End field
				 * log_proccessing_1_tFileOutputDelimited_2:FIELDSEPARATOR
				 */
				;

				final String OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_2 = /**
				 * 
				 * Start field
				 * log_proccessing_1_tFileOutputDelimited_2:ROWSEPARATOR
				 */
				"\n"/**
				 * End field
				 * log_proccessing_1_tFileOutputDelimited_2:ROWSEPARATOR
				 */
				;

				// routines.system.Row
				java.io.Writer outlog_proccessing_1_tFileOutputDelimited_2 = null;

				outlog_proccessing_1_tFileOutputDelimited_2 = new java.io.BufferedWriter(
						new java.io.OutputStreamWriter(
								new java.io.FileOutputStream(
										fileName_log_proccessing_1_tFileOutputDelimited_2,
										true), "ISO-8859-15"));
				if (filelog_proccessing_1_tFileOutputDelimited_2.length() == 0) {
					outlog_proccessing_1_tFileOutputDelimited_2.write("moment");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2.write("pid");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2
							.write("root_pid");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2
							.write("father_pid");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2
							.write("project");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2.write("job");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2
							.write("context");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2
							.write("priority");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2.write("type");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2.write("origin");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2
							.write("message");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2.write("code");
					outlog_proccessing_1_tFileOutputDelimited_2
							.write(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_2);
					outlog_proccessing_1_tFileOutputDelimited_2.flush();
				}

				resourceMap.put("out_log_proccessing_1_tFileOutputDelimited_2",
						outlog_proccessing_1_tFileOutputDelimited_2);
				resourceMap.put(
						"nb_line_log_proccessing_1_tFileOutputDelimited_2",
						nb_line_log_proccessing_1_tFileOutputDelimited_2);

				/**
				 * [log_proccessing_1_tFileOutputDelimited_2 begin ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_2 begin ] start
				 */

				ok_Hash.put("log_proccessing_1_tLogRow_2", false);
				start_Hash.put("log_proccessing_1_tLogRow_2",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tLogRow_2";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection(
								"log_proccessing_1_debug_log" + iterateId, 0, 0);

					}
				}

				int tos_count_log_proccessing_1_tLogRow_2 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogRow_2 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tLogRow_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tLogRow_2 = new StringBuilder();
							log4jParamters_log_proccessing_1_tLogRow_2
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append("BASIC_MODE" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append("VERTICAL" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append("PRINT_UNIQUE_NAME" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append("PRINT_COLNAMES" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append("USE_FIXED_LENGTH" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append("PRINT_CONTENT_WITH_LOG4J" + " = "
											+ "true");
							log4jParamters_log_proccessing_1_tLogRow_2
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tLogRow_2 - "
										+ (log4jParamters_log_proccessing_1_tLogRow_2));
						}
					}
					new BytesLimit65535_log_proccessing_1_tLogRow_2()
							.limitLog4jByte();
				}

				// /////////////////////

				final String OUTPUT_FIELD_SEPARATOR_log_proccessing_1_tLogRow_2 = "|";
				java.io.PrintStream consoleOut_log_proccessing_1_tLogRow_2 = null;

				StringBuilder strBuffer_log_proccessing_1_tLogRow_2 = null;
				int nb_line_log_proccessing_1_tLogRow_2 = 0;
				// /////////////////////

				/**
				 * [log_proccessing_1_tLogRow_2 begin ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_4 begin ] start
				 */

				ok_Hash.put("log_proccessing_1_tFileOutputDelimited_4", false);
				start_Hash.put("log_proccessing_1_tFileOutputDelimited_4",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tFileOutputDelimited_4";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("log_proccessing_1_row5"
								+ iterateId, 0, 0);

					}
				}

				int tos_count_log_proccessing_1_tFileOutputDelimited_4 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tFileOutputDelimited_4 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tFileOutputDelimited_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tFileOutputDelimited_4 = new StringBuilder();
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("USESTREAM" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("FILENAME" + " = "
											+ "\"/tmp/ERROR.csv\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("ROWSEPARATOR" + " = " + "\"\\n\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("FIELDSEPARATOR" + " = " + "\";\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("APPEND" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("INCLUDEHEADER" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("ADVANCED_SEPARATOR" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("CSV_OPTION" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("CREATE" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("SPLIT" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("FLUSHONROW" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("ROW_MODE" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("ENCODING" + " = "
											+ "\"ISO-8859-15\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append("DELETE_EMPTYFILE" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_4
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tFileOutputDelimited_4 - "
										+ (log4jParamters_log_proccessing_1_tFileOutputDelimited_4));
						}
					}
					new BytesLimit65535_log_proccessing_1_tFileOutputDelimited_4()
							.limitLog4jByte();
				}

				String fileName_log_proccessing_1_tFileOutputDelimited_4 = "";
				fileName_log_proccessing_1_tFileOutputDelimited_4 = (new java.io.File(
						"/tmp/ERROR.csv")).getAbsolutePath().replace("\\", "/");
				String fullName_log_proccessing_1_tFileOutputDelimited_4 = null;
				String extension_log_proccessing_1_tFileOutputDelimited_4 = null;
				String directory_log_proccessing_1_tFileOutputDelimited_4 = null;
				if ((fileName_log_proccessing_1_tFileOutputDelimited_4
						.indexOf("/") != -1)) {
					if (fileName_log_proccessing_1_tFileOutputDelimited_4
							.lastIndexOf(".") < fileName_log_proccessing_1_tFileOutputDelimited_4
							.lastIndexOf("/")) {
						fullName_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4;
						extension_log_proccessing_1_tFileOutputDelimited_4 = "";
					} else {
						fullName_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4
								.substring(0,
										fileName_log_proccessing_1_tFileOutputDelimited_4
												.lastIndexOf("."));
						extension_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4
								.substring(fileName_log_proccessing_1_tFileOutputDelimited_4
										.lastIndexOf("."));
					}
					directory_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4
							.substring(0,
									fileName_log_proccessing_1_tFileOutputDelimited_4
											.lastIndexOf("/"));
				} else {
					if (fileName_log_proccessing_1_tFileOutputDelimited_4
							.lastIndexOf(".") != -1) {
						fullName_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4
								.substring(0,
										fileName_log_proccessing_1_tFileOutputDelimited_4
												.lastIndexOf("."));
						extension_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4
								.substring(fileName_log_proccessing_1_tFileOutputDelimited_4
										.lastIndexOf("."));
					} else {
						fullName_log_proccessing_1_tFileOutputDelimited_4 = fileName_log_proccessing_1_tFileOutputDelimited_4;
						extension_log_proccessing_1_tFileOutputDelimited_4 = "";
					}
					directory_log_proccessing_1_tFileOutputDelimited_4 = "";
				}
				boolean isFileGenerated_log_proccessing_1_tFileOutputDelimited_4 = true;
				java.io.File filelog_proccessing_1_tFileOutputDelimited_4 = new java.io.File(
						fileName_log_proccessing_1_tFileOutputDelimited_4);
				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_4_FILE_NAME",
						fileName_log_proccessing_1_tFileOutputDelimited_4);
				if (filelog_proccessing_1_tFileOutputDelimited_4.exists()) {
					isFileGenerated_log_proccessing_1_tFileOutputDelimited_4 = false;
				}
				int nb_line_log_proccessing_1_tFileOutputDelimited_4 = 0;
				int splitedFileNo_log_proccessing_1_tFileOutputDelimited_4 = 0;
				int currentRow_log_proccessing_1_tFileOutputDelimited_4 = 0;

				final String OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4 = /**
				 * 
				 * Start field
				 * log_proccessing_1_tFileOutputDelimited_4:FIELDSEPARATOR
				 */
				";"/**
				 * End field
				 * log_proccessing_1_tFileOutputDelimited_4:FIELDSEPARATOR
				 */
				;

				final String OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_4 = /**
				 * 
				 * Start field
				 * log_proccessing_1_tFileOutputDelimited_4:ROWSEPARATOR
				 */
				"\n"/**
				 * End field
				 * log_proccessing_1_tFileOutputDelimited_4:ROWSEPARATOR
				 */
				;

				// create directory only if not exists
				if (directory_log_proccessing_1_tFileOutputDelimited_4 != null
						&& directory_log_proccessing_1_tFileOutputDelimited_4
								.trim().length() != 0) {
					java.io.File dir_log_proccessing_1_tFileOutputDelimited_4 = new java.io.File(
							directory_log_proccessing_1_tFileOutputDelimited_4);
					if (!dir_log_proccessing_1_tFileOutputDelimited_4.exists()) {
						log.info("log_proccessing_1_tFileOutputDelimited_4 - Creating directory '"
								+ dir_log_proccessing_1_tFileOutputDelimited_4
										.getCanonicalPath() + "'.");
						dir_log_proccessing_1_tFileOutputDelimited_4.mkdirs();
						log.info("log_proccessing_1_tFileOutputDelimited_4 - The directory '"
								+ dir_log_proccessing_1_tFileOutputDelimited_4
										.getCanonicalPath()
								+ "' has been created successfully.");
					}
				}

				// routines.system.Row
				java.io.Writer outlog_proccessing_1_tFileOutputDelimited_4 = null;

				outlog_proccessing_1_tFileOutputDelimited_4 = new java.io.BufferedWriter(
						new java.io.OutputStreamWriter(
								new java.io.FileOutputStream(
										fileName_log_proccessing_1_tFileOutputDelimited_4,
										true), "ISO-8859-15"));
				if (filelog_proccessing_1_tFileOutputDelimited_4.length() == 0) {
					outlog_proccessing_1_tFileOutputDelimited_4.write("moment");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4.write("pid");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4
							.write("root_pid");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4
							.write("father_pid");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4
							.write("project");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4.write("job");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4
							.write("context");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4
							.write("priority");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4.write("type");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4.write("origin");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4
							.write("message");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4.write("code");
					outlog_proccessing_1_tFileOutputDelimited_4
							.write(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_4);
					outlog_proccessing_1_tFileOutputDelimited_4.flush();
				}

				resourceMap.put("out_log_proccessing_1_tFileOutputDelimited_4",
						outlog_proccessing_1_tFileOutputDelimited_4);
				resourceMap.put(
						"nb_line_log_proccessing_1_tFileOutputDelimited_4",
						nb_line_log_proccessing_1_tFileOutputDelimited_4);

				/**
				 * [log_proccessing_1_tFileOutputDelimited_4 begin ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_3 begin ] start
				 */

				ok_Hash.put("log_proccessing_1_tLogRow_3", false);
				start_Hash.put("log_proccessing_1_tLogRow_3",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tLogRow_3";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection(
								"log_proccessing_1_error_log" + iterateId, 0, 0);

					}
				}

				int tos_count_log_proccessing_1_tLogRow_3 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogRow_3 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tLogRow_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tLogRow_3 = new StringBuilder();
							log4jParamters_log_proccessing_1_tLogRow_3
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append("BASIC_MODE" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append("VERTICAL" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append("PRINT_UNIQUE_NAME" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append("PRINT_COLNAMES" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append("USE_FIXED_LENGTH" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append("PRINT_CONTENT_WITH_LOG4J" + " = "
											+ "true");
							log4jParamters_log_proccessing_1_tLogRow_3
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tLogRow_3 - "
										+ (log4jParamters_log_proccessing_1_tLogRow_3));
						}
					}
					new BytesLimit65535_log_proccessing_1_tLogRow_3()
							.limitLog4jByte();
				}

				// /////////////////////

				final String OUTPUT_FIELD_SEPARATOR_log_proccessing_1_tLogRow_3 = "|";
				java.io.PrintStream consoleOut_log_proccessing_1_tLogRow_3 = null;

				StringBuilder strBuffer_log_proccessing_1_tLogRow_3 = null;
				int nb_line_log_proccessing_1_tLogRow_3 = 0;
				// /////////////////////

				/**
				 * [log_proccessing_1_tLogRow_3 begin ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_5 begin ] start
				 */

				ok_Hash.put("log_proccessing_1_tFileOutputDelimited_5", false);
				start_Hash.put("log_proccessing_1_tFileOutputDelimited_5",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tFileOutputDelimited_5";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("log_proccessing_1_row6"
								+ iterateId, 0, 0);

					}
				}

				int tos_count_log_proccessing_1_tFileOutputDelimited_5 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tFileOutputDelimited_5 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tFileOutputDelimited_5 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tFileOutputDelimited_5 = new StringBuilder();
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("USESTREAM" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("FILENAME" + " = "
											+ "\"/tmp/FATAL_ERROR.csv\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("ROWSEPARATOR" + " = " + "\"\\n\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("FIELDSEPARATOR" + " = " + "\";\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("APPEND" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("INCLUDEHEADER" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("ADVANCED_SEPARATOR" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("CSV_OPTION" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("CREATE" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("SPLIT" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("FLUSHONROW" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("ROW_MODE" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("ENCODING" + " = "
											+ "\"ISO-8859-15\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append("DELETE_EMPTYFILE" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_5
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tFileOutputDelimited_5 - "
										+ (log4jParamters_log_proccessing_1_tFileOutputDelimited_5));
						}
					}
					new BytesLimit65535_log_proccessing_1_tFileOutputDelimited_5()
							.limitLog4jByte();
				}

				String fileName_log_proccessing_1_tFileOutputDelimited_5 = "";
				fileName_log_proccessing_1_tFileOutputDelimited_5 = (new java.io.File(
						"/tmp/FATAL_ERROR.csv")).getAbsolutePath().replace(
						"\\", "/");
				String fullName_log_proccessing_1_tFileOutputDelimited_5 = null;
				String extension_log_proccessing_1_tFileOutputDelimited_5 = null;
				String directory_log_proccessing_1_tFileOutputDelimited_5 = null;
				if ((fileName_log_proccessing_1_tFileOutputDelimited_5
						.indexOf("/") != -1)) {
					if (fileName_log_proccessing_1_tFileOutputDelimited_5
							.lastIndexOf(".") < fileName_log_proccessing_1_tFileOutputDelimited_5
							.lastIndexOf("/")) {
						fullName_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5;
						extension_log_proccessing_1_tFileOutputDelimited_5 = "";
					} else {
						fullName_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5
								.substring(0,
										fileName_log_proccessing_1_tFileOutputDelimited_5
												.lastIndexOf("."));
						extension_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5
								.substring(fileName_log_proccessing_1_tFileOutputDelimited_5
										.lastIndexOf("."));
					}
					directory_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5
							.substring(0,
									fileName_log_proccessing_1_tFileOutputDelimited_5
											.lastIndexOf("/"));
				} else {
					if (fileName_log_proccessing_1_tFileOutputDelimited_5
							.lastIndexOf(".") != -1) {
						fullName_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5
								.substring(0,
										fileName_log_proccessing_1_tFileOutputDelimited_5
												.lastIndexOf("."));
						extension_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5
								.substring(fileName_log_proccessing_1_tFileOutputDelimited_5
										.lastIndexOf("."));
					} else {
						fullName_log_proccessing_1_tFileOutputDelimited_5 = fileName_log_proccessing_1_tFileOutputDelimited_5;
						extension_log_proccessing_1_tFileOutputDelimited_5 = "";
					}
					directory_log_proccessing_1_tFileOutputDelimited_5 = "";
				}
				boolean isFileGenerated_log_proccessing_1_tFileOutputDelimited_5 = true;
				java.io.File filelog_proccessing_1_tFileOutputDelimited_5 = new java.io.File(
						fileName_log_proccessing_1_tFileOutputDelimited_5);
				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_5_FILE_NAME",
						fileName_log_proccessing_1_tFileOutputDelimited_5);
				if (filelog_proccessing_1_tFileOutputDelimited_5.exists()) {
					isFileGenerated_log_proccessing_1_tFileOutputDelimited_5 = false;
				}
				int nb_line_log_proccessing_1_tFileOutputDelimited_5 = 0;
				int splitedFileNo_log_proccessing_1_tFileOutputDelimited_5 = 0;
				int currentRow_log_proccessing_1_tFileOutputDelimited_5 = 0;

				final String OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5 = /**
				 * 
				 * Start field
				 * log_proccessing_1_tFileOutputDelimited_5:FIELDSEPARATOR
				 */
				";"/**
				 * End field
				 * log_proccessing_1_tFileOutputDelimited_5:FIELDSEPARATOR
				 */
				;

				final String OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_5 = /**
				 * 
				 * Start field
				 * log_proccessing_1_tFileOutputDelimited_5:ROWSEPARATOR
				 */
				"\n"/**
				 * End field
				 * log_proccessing_1_tFileOutputDelimited_5:ROWSEPARATOR
				 */
				;

				// create directory only if not exists
				if (directory_log_proccessing_1_tFileOutputDelimited_5 != null
						&& directory_log_proccessing_1_tFileOutputDelimited_5
								.trim().length() != 0) {
					java.io.File dir_log_proccessing_1_tFileOutputDelimited_5 = new java.io.File(
							directory_log_proccessing_1_tFileOutputDelimited_5);
					if (!dir_log_proccessing_1_tFileOutputDelimited_5.exists()) {
						log.info("log_proccessing_1_tFileOutputDelimited_5 - Creating directory '"
								+ dir_log_proccessing_1_tFileOutputDelimited_5
										.getCanonicalPath() + "'.");
						dir_log_proccessing_1_tFileOutputDelimited_5.mkdirs();
						log.info("log_proccessing_1_tFileOutputDelimited_5 - The directory '"
								+ dir_log_proccessing_1_tFileOutputDelimited_5
										.getCanonicalPath()
								+ "' has been created successfully.");
					}
				}

				// routines.system.Row
				java.io.Writer outlog_proccessing_1_tFileOutputDelimited_5 = null;

				outlog_proccessing_1_tFileOutputDelimited_5 = new java.io.BufferedWriter(
						new java.io.OutputStreamWriter(
								new java.io.FileOutputStream(
										fileName_log_proccessing_1_tFileOutputDelimited_5,
										true), "ISO-8859-15"));
				if (filelog_proccessing_1_tFileOutputDelimited_5.length() == 0) {
					outlog_proccessing_1_tFileOutputDelimited_5.write("moment");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5.write("pid");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5
							.write("root_pid");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5
							.write("father_pid");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5
							.write("project");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5.write("job");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5
							.write("context");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5
							.write("priority");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5.write("type");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5.write("origin");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5
							.write("message");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5.write("code");
					outlog_proccessing_1_tFileOutputDelimited_5
							.write(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_5);
					outlog_proccessing_1_tFileOutputDelimited_5.flush();
				}

				resourceMap.put("out_log_proccessing_1_tFileOutputDelimited_5",
						outlog_proccessing_1_tFileOutputDelimited_5);
				resourceMap.put(
						"nb_line_log_proccessing_1_tFileOutputDelimited_5",
						nb_line_log_proccessing_1_tFileOutputDelimited_5);

				/**
				 * [log_proccessing_1_tFileOutputDelimited_5 begin ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_4 begin ] start
				 */

				ok_Hash.put("log_proccessing_1_tLogRow_4", false);
				start_Hash.put("log_proccessing_1_tLogRow_4",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tLogRow_4";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection(
								"log_proccessing_1_fatal_error_log" + iterateId,
								0, 0);

					}
				}

				int tos_count_log_proccessing_1_tLogRow_4 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogRow_4 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tLogRow_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tLogRow_4 = new StringBuilder();
							log4jParamters_log_proccessing_1_tLogRow_4
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append("BASIC_MODE" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append("VERTICAL" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append("PRINT_UNIQUE_NAME" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append("PRINT_COLNAMES" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append("USE_FIXED_LENGTH" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append("PRINT_CONTENT_WITH_LOG4J" + " = "
											+ "true");
							log4jParamters_log_proccessing_1_tLogRow_4
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tLogRow_4 - "
										+ (log4jParamters_log_proccessing_1_tLogRow_4));
						}
					}
					new BytesLimit65535_log_proccessing_1_tLogRow_4()
							.limitLog4jByte();
				}

				// /////////////////////

				final String OUTPUT_FIELD_SEPARATOR_log_proccessing_1_tLogRow_4 = "|";
				java.io.PrintStream consoleOut_log_proccessing_1_tLogRow_4 = null;

				StringBuilder strBuffer_log_proccessing_1_tLogRow_4 = null;
				int nb_line_log_proccessing_1_tLogRow_4 = 0;
				// /////////////////////

				/**
				 * [log_proccessing_1_tLogRow_4 begin ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_3 begin ] start
				 */

				ok_Hash.put("log_proccessing_1_tFileOutputDelimited_3", false);
				start_Hash.put("log_proccessing_1_tFileOutputDelimited_3",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tFileOutputDelimited_3";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("log_proccessing_1_row4"
								+ iterateId, 0, 0);

					}
				}

				int tos_count_log_proccessing_1_tFileOutputDelimited_3 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tFileOutputDelimited_3 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tFileOutputDelimited_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tFileOutputDelimited_3 = new StringBuilder();
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("USESTREAM" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("FILENAME" + " = "
											+ "\"/tmp/WARN.csv\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("ROWSEPARATOR" + " = " + "\"\\n\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("FIELDSEPARATOR" + " = " + "\";\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("APPEND" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("INCLUDEHEADER" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("ADVANCED_SEPARATOR" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("CSV_OPTION" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("CREATE" + " = " + "true");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("SPLIT" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("FLUSHONROW" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("ROW_MODE" + " = " + "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("ENCODING" + " = "
											+ "\"ISO-8859-15\"");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append("DELETE_EMPTYFILE" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tFileOutputDelimited_3
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tFileOutputDelimited_3 - "
										+ (log4jParamters_log_proccessing_1_tFileOutputDelimited_3));
						}
					}
					new BytesLimit65535_log_proccessing_1_tFileOutputDelimited_3()
							.limitLog4jByte();
				}

				String fileName_log_proccessing_1_tFileOutputDelimited_3 = "";
				fileName_log_proccessing_1_tFileOutputDelimited_3 = (new java.io.File(
						"/tmp/WARN.csv")).getAbsolutePath().replace("\\", "/");
				String fullName_log_proccessing_1_tFileOutputDelimited_3 = null;
				String extension_log_proccessing_1_tFileOutputDelimited_3 = null;
				String directory_log_proccessing_1_tFileOutputDelimited_3 = null;
				if ((fileName_log_proccessing_1_tFileOutputDelimited_3
						.indexOf("/") != -1)) {
					if (fileName_log_proccessing_1_tFileOutputDelimited_3
							.lastIndexOf(".") < fileName_log_proccessing_1_tFileOutputDelimited_3
							.lastIndexOf("/")) {
						fullName_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3;
						extension_log_proccessing_1_tFileOutputDelimited_3 = "";
					} else {
						fullName_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3
								.substring(0,
										fileName_log_proccessing_1_tFileOutputDelimited_3
												.lastIndexOf("."));
						extension_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3
								.substring(fileName_log_proccessing_1_tFileOutputDelimited_3
										.lastIndexOf("."));
					}
					directory_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3
							.substring(0,
									fileName_log_proccessing_1_tFileOutputDelimited_3
											.lastIndexOf("/"));
				} else {
					if (fileName_log_proccessing_1_tFileOutputDelimited_3
							.lastIndexOf(".") != -1) {
						fullName_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3
								.substring(0,
										fileName_log_proccessing_1_tFileOutputDelimited_3
												.lastIndexOf("."));
						extension_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3
								.substring(fileName_log_proccessing_1_tFileOutputDelimited_3
										.lastIndexOf("."));
					} else {
						fullName_log_proccessing_1_tFileOutputDelimited_3 = fileName_log_proccessing_1_tFileOutputDelimited_3;
						extension_log_proccessing_1_tFileOutputDelimited_3 = "";
					}
					directory_log_proccessing_1_tFileOutputDelimited_3 = "";
				}
				boolean isFileGenerated_log_proccessing_1_tFileOutputDelimited_3 = true;
				java.io.File filelog_proccessing_1_tFileOutputDelimited_3 = new java.io.File(
						fileName_log_proccessing_1_tFileOutputDelimited_3);
				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_3_FILE_NAME",
						fileName_log_proccessing_1_tFileOutputDelimited_3);
				if (filelog_proccessing_1_tFileOutputDelimited_3.exists()) {
					isFileGenerated_log_proccessing_1_tFileOutputDelimited_3 = false;
				}
				int nb_line_log_proccessing_1_tFileOutputDelimited_3 = 0;
				int splitedFileNo_log_proccessing_1_tFileOutputDelimited_3 = 0;
				int currentRow_log_proccessing_1_tFileOutputDelimited_3 = 0;

				final String OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3 = /**
				 * 
				 * Start field
				 * log_proccessing_1_tFileOutputDelimited_3:FIELDSEPARATOR
				 */
				";"/**
				 * End field
				 * log_proccessing_1_tFileOutputDelimited_3:FIELDSEPARATOR
				 */
				;

				final String OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_3 = /**
				 * 
				 * Start field
				 * log_proccessing_1_tFileOutputDelimited_3:ROWSEPARATOR
				 */
				"\n"/**
				 * End field
				 * log_proccessing_1_tFileOutputDelimited_3:ROWSEPARATOR
				 */
				;

				// create directory only if not exists
				if (directory_log_proccessing_1_tFileOutputDelimited_3 != null
						&& directory_log_proccessing_1_tFileOutputDelimited_3
								.trim().length() != 0) {
					java.io.File dir_log_proccessing_1_tFileOutputDelimited_3 = new java.io.File(
							directory_log_proccessing_1_tFileOutputDelimited_3);
					if (!dir_log_proccessing_1_tFileOutputDelimited_3.exists()) {
						log.info("log_proccessing_1_tFileOutputDelimited_3 - Creating directory '"
								+ dir_log_proccessing_1_tFileOutputDelimited_3
										.getCanonicalPath() + "'.");
						dir_log_proccessing_1_tFileOutputDelimited_3.mkdirs();
						log.info("log_proccessing_1_tFileOutputDelimited_3 - The directory '"
								+ dir_log_proccessing_1_tFileOutputDelimited_3
										.getCanonicalPath()
								+ "' has been created successfully.");
					}
				}

				// routines.system.Row
				java.io.Writer outlog_proccessing_1_tFileOutputDelimited_3 = null;

				outlog_proccessing_1_tFileOutputDelimited_3 = new java.io.BufferedWriter(
						new java.io.OutputStreamWriter(
								new java.io.FileOutputStream(
										fileName_log_proccessing_1_tFileOutputDelimited_3,
										true), "ISO-8859-15"));
				if (filelog_proccessing_1_tFileOutputDelimited_3.length() == 0) {
					outlog_proccessing_1_tFileOutputDelimited_3.write("moment");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3.write("pid");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3
							.write("root_pid");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3
							.write("father_pid");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3
							.write("project");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3.write("job");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3
							.write("context");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3
							.write("priority");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3.write("type");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3.write("origin");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3
							.write("message");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3.write("code");
					outlog_proccessing_1_tFileOutputDelimited_3
							.write(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_3);
					outlog_proccessing_1_tFileOutputDelimited_3.flush();
				}

				resourceMap.put("out_log_proccessing_1_tFileOutputDelimited_3",
						outlog_proccessing_1_tFileOutputDelimited_3);
				resourceMap.put(
						"nb_line_log_proccessing_1_tFileOutputDelimited_3",
						nb_line_log_proccessing_1_tFileOutputDelimited_3);

				/**
				 * [log_proccessing_1_tFileOutputDelimited_3 begin ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_5 begin ] start
				 */

				ok_Hash.put("log_proccessing_1_tLogRow_5", false);
				start_Hash.put("log_proccessing_1_tLogRow_5",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tLogRow_5";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection(
								"log_proccessing_1_warn_log" + iterateId, 0, 0);

					}
				}

				int tos_count_log_proccessing_1_tLogRow_5 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogRow_5 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tLogRow_5 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tLogRow_5 = new StringBuilder();
							log4jParamters_log_proccessing_1_tLogRow_5
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append("BASIC_MODE" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append("VERTICAL" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append("PRINT_UNIQUE_NAME" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append("PRINT_COLNAMES" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append("USE_FIXED_LENGTH" + " = "
											+ "false");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append("PRINT_CONTENT_WITH_LOG4J" + " = "
											+ "true");
							log4jParamters_log_proccessing_1_tLogRow_5
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tLogRow_5 - "
										+ (log4jParamters_log_proccessing_1_tLogRow_5));
						}
					}
					new BytesLimit65535_log_proccessing_1_tLogRow_5()
							.limitLog4jByte();
				}

				// /////////////////////

				final String OUTPUT_FIELD_SEPARATOR_log_proccessing_1_tLogRow_5 = "|";
				java.io.PrintStream consoleOut_log_proccessing_1_tLogRow_5 = null;

				StringBuilder strBuffer_log_proccessing_1_tLogRow_5 = null;
				int nb_line_log_proccessing_1_tLogRow_5 = 0;
				// /////////////////////

				/**
				 * [log_proccessing_1_tLogRow_5 begin ] stop
				 */

				/**
				 * [log_proccessing_1_tMap_1 begin ] start
				 */

				ok_Hash.put("log_proccessing_1_tMap_1", false);
				start_Hash.put("log_proccessing_1_tMap_1",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tMap_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("log_proccessing_1_row1"
								+ iterateId, 0, 0);

					}
				}

				int tos_count_log_proccessing_1_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tMap_1 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tMap_1 = new StringBuilder();
							log4jParamters_log_proccessing_1_tMap_1
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tMap_1
									.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_log_proccessing_1_tMap_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tMap_1
									.append("TEMPORARY_DATA_DIRECTORY" + " = "
											+ "");
							log4jParamters_log_proccessing_1_tMap_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tMap_1
									.append("ROWS_BUFFER_SIZE" + " = "
											+ "2000000");
							log4jParamters_log_proccessing_1_tMap_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tMap_1
									.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL"
											+ " = " + "true");
							log4jParamters_log_proccessing_1_tMap_1
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tMap_1 - "
										+ (log4jParamters_log_proccessing_1_tMap_1));
						}
					}
					new BytesLimit65535_log_proccessing_1_tMap_1()
							.limitLog4jByte();
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
				start_Hash.put("log_proccessing_1_tLogCatcher_1",
						System.currentTimeMillis());

				currentComponent = "log_proccessing_1_tLogCatcher_1";

				int tos_count_log_proccessing_1_tLogCatcher_1 = 0;

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogCatcher_1 - "
							+ ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_log_proccessing_1_tLogCatcher_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_log_proccessing_1_tLogCatcher_1 = new StringBuilder();
							log4jParamters_log_proccessing_1_tLogCatcher_1
									.append("Parameters:");
							log4jParamters_log_proccessing_1_tLogCatcher_1
									.append("CATCH_JAVA_EXCEPTION" + " = "
											+ "true");
							log4jParamters_log_proccessing_1_tLogCatcher_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogCatcher_1
									.append("CATCH_TDIE" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogCatcher_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogCatcher_1
									.append("CATCH_TWARN" + " = " + "true");
							log4jParamters_log_proccessing_1_tLogCatcher_1
									.append(" | ");
							log4jParamters_log_proccessing_1_tLogCatcher_1
									.append("CATCH_TACTIONFAILURE" + " = "
											+ "true");
							log4jParamters_log_proccessing_1_tLogCatcher_1
									.append(" | ");
							if (log.isDebugEnabled())
								log.debug("log_proccessing_1_tLogCatcher_1 - "
										+ (log4jParamters_log_proccessing_1_tLogCatcher_1));
						}
					}
					new BytesLimit65535_log_proccessing_1_tLogCatcher_1()
							.limitLog4jByte();
				}

				try {
					for (LogCatcherUtils.LogCatcherMessage lcm : log_proccessing_1_tLogCatcher_1
							.getMessages()) {
						log_proccessing_1_row1.type = lcm.getType();
						log_proccessing_1_row1.origin = (lcm.getOrigin() == null
								|| lcm.getOrigin().length() < 1 ? null : lcm
								.getOrigin());
						log_proccessing_1_row1.priority = lcm.getPriority();
						log_proccessing_1_row1.message = lcm.getMessage();
						log_proccessing_1_row1.code = lcm.getCode();

						log_proccessing_1_row1.moment = java.util.Calendar
								.getInstance().getTime();

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

						currentComponent = "log_proccessing_1_tLogCatcher_1";

						tos_count_log_proccessing_1_tLogCatcher_1++;

						/**
						 * [log_proccessing_1_tLogCatcher_1 main ] stop
						 */

						/**
						 * [log_proccessing_1_tLogCatcher_1 process_data_begin ]
						 * start
						 */

						currentComponent = "log_proccessing_1_tLogCatcher_1";

						/**
						 * [log_proccessing_1_tLogCatcher_1 process_data_begin ]
						 * stop
						 */

						/**
						 * [log_proccessing_1_tMap_1 main ] start
						 */

						currentComponent = "log_proccessing_1_tMap_1";

						// log_proccessing_1_row1
						// log_proccessing_1_row1

						if (execStat) {
							runStat.updateStatOnConnection(
									"log_proccessing_1_row1" + iterateId, 1, 1);
						}

						if (log.isTraceEnabled()) {
							log.trace("log_proccessing_1_row1 - "
									+ (log_proccessing_1_row1 == null ? ""
											: log_proccessing_1_row1
													.toLogString()));
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
							if (

							log_proccessing_1_row1.priority == 3

							) {
								count_log_proccessing_1_Info_log_log_proccessing_1_tMap_1++;

								log_proccessing_1_Info_log_tmp.moment = log_proccessing_1_row1.moment;
								log_proccessing_1_Info_log_tmp.pid = log_proccessing_1_row1.pid;
								log_proccessing_1_Info_log_tmp.root_pid = log_proccessing_1_row1.root_pid;
								log_proccessing_1_Info_log_tmp.father_pid = log_proccessing_1_row1.father_pid;
								log_proccessing_1_Info_log_tmp.project = log_proccessing_1_row1.project;
								log_proccessing_1_Info_log_tmp.job = log_proccessing_1_row1.job;
								log_proccessing_1_Info_log_tmp.context = log_proccessing_1_row1.context;
								log_proccessing_1_Info_log_tmp.priority = log_proccessing_1_row1.priority;
								log_proccessing_1_Info_log_tmp.type = log_proccessing_1_row1.type;
								log_proccessing_1_Info_log_tmp.origin = log_proccessing_1_row1.origin;
								log_proccessing_1_Info_log_tmp.message = log_proccessing_1_row1.message;
								log_proccessing_1_Info_log_tmp.code = log_proccessing_1_row1.code;
								log_proccessing_1_Info_log = log_proccessing_1_Info_log_tmp;
								log.debug("log_proccessing_1_tMap_1 - Outputting the record "
										+ count_log_proccessing_1_Info_log_log_proccessing_1_tMap_1
										+ " of the output table 'log_proccessing_1_Info_log'.");

							} // closing filter/reject

							// # Output table : 'log_proccessing_1_debug_log'
							// # Filter conditions
							if (

							log_proccessing_1_row1.priority == 2

							) {
								count_log_proccessing_1_debug_log_log_proccessing_1_tMap_1++;

								log_proccessing_1_debug_log_tmp.moment = log_proccessing_1_row1.moment;
								log_proccessing_1_debug_log_tmp.pid = log_proccessing_1_row1.pid;
								log_proccessing_1_debug_log_tmp.root_pid = log_proccessing_1_row1.root_pid;
								log_proccessing_1_debug_log_tmp.father_pid = log_proccessing_1_row1.father_pid;
								log_proccessing_1_debug_log_tmp.project = log_proccessing_1_row1.project;
								log_proccessing_1_debug_log_tmp.job = log_proccessing_1_row1.job;
								log_proccessing_1_debug_log_tmp.context = log_proccessing_1_row1.context;
								log_proccessing_1_debug_log_tmp.priority = log_proccessing_1_row1.priority;
								log_proccessing_1_debug_log_tmp.type = log_proccessing_1_row1.type;
								log_proccessing_1_debug_log_tmp.origin = log_proccessing_1_row1.origin;
								log_proccessing_1_debug_log_tmp.message = log_proccessing_1_row1.message;
								log_proccessing_1_debug_log_tmp.code = log_proccessing_1_row1.code;
								log_proccessing_1_debug_log = log_proccessing_1_debug_log_tmp;
								log.debug("log_proccessing_1_tMap_1 - Outputting the record "
										+ count_log_proccessing_1_debug_log_log_proccessing_1_tMap_1
										+ " of the output table 'log_proccessing_1_debug_log'.");

							} // closing filter/reject

							// # Output table : 'log_proccessing_1_error_log'
							// # Filter conditions
							if (

							log_proccessing_1_row1.priority == 5

							) {
								count_log_proccessing_1_error_log_log_proccessing_1_tMap_1++;

								log_proccessing_1_error_log_tmp.moment = log_proccessing_1_row1.moment;
								log_proccessing_1_error_log_tmp.pid = log_proccessing_1_row1.pid;
								log_proccessing_1_error_log_tmp.root_pid = log_proccessing_1_row1.root_pid;
								log_proccessing_1_error_log_tmp.father_pid = log_proccessing_1_row1.father_pid;
								log_proccessing_1_error_log_tmp.project = log_proccessing_1_row1.project;
								log_proccessing_1_error_log_tmp.job = log_proccessing_1_row1.job;
								log_proccessing_1_error_log_tmp.context = log_proccessing_1_row1.context;
								log_proccessing_1_error_log_tmp.priority = log_proccessing_1_row1.priority;
								log_proccessing_1_error_log_tmp.type = log_proccessing_1_row1.type;
								log_proccessing_1_error_log_tmp.origin = log_proccessing_1_row1.origin;
								log_proccessing_1_error_log_tmp.message = log_proccessing_1_row1.message;
								log_proccessing_1_error_log_tmp.code = log_proccessing_1_row1.code;
								log_proccessing_1_error_log = log_proccessing_1_error_log_tmp;
								log.debug("log_proccessing_1_tMap_1 - Outputting the record "
										+ count_log_proccessing_1_error_log_log_proccessing_1_tMap_1
										+ " of the output table 'log_proccessing_1_error_log'.");

							} // closing filter/reject

							// # Output table :
							// 'log_proccessing_1_fatal_error_log'
							// # Filter conditions
							if (

							log_proccessing_1_row1.priority == 6

							) {
								count_log_proccessing_1_fatal_error_log_log_proccessing_1_tMap_1++;

								log_proccessing_1_fatal_error_log_tmp.moment = log_proccessing_1_row1.moment;
								log_proccessing_1_fatal_error_log_tmp.pid = log_proccessing_1_row1.pid;
								log_proccessing_1_fatal_error_log_tmp.root_pid = log_proccessing_1_row1.root_pid;
								log_proccessing_1_fatal_error_log_tmp.father_pid = log_proccessing_1_row1.father_pid;
								log_proccessing_1_fatal_error_log_tmp.project = log_proccessing_1_row1.project;
								log_proccessing_1_fatal_error_log_tmp.job = log_proccessing_1_row1.job;
								log_proccessing_1_fatal_error_log_tmp.context = log_proccessing_1_row1.context;
								log_proccessing_1_fatal_error_log_tmp.priority = log_proccessing_1_row1.priority;
								log_proccessing_1_fatal_error_log_tmp.type = log_proccessing_1_row1.type;
								log_proccessing_1_fatal_error_log_tmp.origin = log_proccessing_1_row1.origin;
								log_proccessing_1_fatal_error_log_tmp.message = log_proccessing_1_row1.message;
								log_proccessing_1_fatal_error_log_tmp.code = log_proccessing_1_row1.code;
								log_proccessing_1_fatal_error_log = log_proccessing_1_fatal_error_log_tmp;
								log.debug("log_proccessing_1_tMap_1 - Outputting the record "
										+ count_log_proccessing_1_fatal_error_log_log_proccessing_1_tMap_1
										+ " of the output table 'log_proccessing_1_fatal_error_log'.");

							} // closing filter/reject

							// # Output table : 'log_proccessing_1_warn_log'
							// # Filter conditions
							if (

							log_proccessing_1_row1.priority == 4

							) {
								count_log_proccessing_1_warn_log_log_proccessing_1_tMap_1++;

								log_proccessing_1_warn_log_tmp.moment = log_proccessing_1_row1.moment;
								log_proccessing_1_warn_log_tmp.pid = log_proccessing_1_row1.pid;
								log_proccessing_1_warn_log_tmp.root_pid = log_proccessing_1_row1.root_pid;
								log_proccessing_1_warn_log_tmp.father_pid = log_proccessing_1_row1.father_pid;
								log_proccessing_1_warn_log_tmp.project = log_proccessing_1_row1.project;
								log_proccessing_1_warn_log_tmp.job = log_proccessing_1_row1.job;
								log_proccessing_1_warn_log_tmp.context = log_proccessing_1_row1.context;
								log_proccessing_1_warn_log_tmp.priority = log_proccessing_1_row1.priority;
								log_proccessing_1_warn_log_tmp.type = log_proccessing_1_row1.type;
								log_proccessing_1_warn_log_tmp.origin = log_proccessing_1_row1.origin;
								log_proccessing_1_warn_log_tmp.message = log_proccessing_1_row1.message;
								log_proccessing_1_warn_log_tmp.code = log_proccessing_1_row1.code;
								log_proccessing_1_warn_log = log_proccessing_1_warn_log_tmp;
								log.debug("log_proccessing_1_tMap_1 - Outputting the record "
										+ count_log_proccessing_1_warn_log_log_proccessing_1_tMap_1
										+ " of the output table 'log_proccessing_1_warn_log'.");

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

						currentComponent = "log_proccessing_1_tMap_1";

						/**
						 * [log_proccessing_1_tMap_1 process_data_begin ] stop
						 */
						// Start of branch "log_proccessing_1_Info_log"
						if (log_proccessing_1_Info_log != null) {

							/**
							 * [log_proccessing_1_tLogRow_1 main ] start
							 */

							currentComponent = "log_proccessing_1_tLogRow_1";

							// log_proccessing_1_Info_log
							// log_proccessing_1_Info_log

							if (execStat) {
								runStat.updateStatOnConnection(
										"log_proccessing_1_Info_log"
												+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("log_proccessing_1_Info_log - "
										+ (log_proccessing_1_Info_log == null ? ""
												: log_proccessing_1_Info_log
														.toLogString()));
							}

							// /////////////////////

							strBuffer_log_proccessing_1_tLogRow_1 = new StringBuilder();

							strBuffer_log_proccessing_1_tLogRow_1
									.append("moment: ");

							if (log_proccessing_1_Info_log.moment != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(FormatterUtils
												.format_Date(
														log_proccessing_1_Info_log.moment,
														"yyyy-MM-dd HH:mm:ss"));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("pid: ");

							if (log_proccessing_1_Info_log.pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("root_pid: ");

							if (log_proccessing_1_Info_log.root_pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.root_pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("father_pid: ");

							if (log_proccessing_1_Info_log.father_pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.father_pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("project: ");

							if (log_proccessing_1_Info_log.project != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.project));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("job: ");

							if (log_proccessing_1_Info_log.job != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.job));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("context: ");

							if (log_proccessing_1_Info_log.context != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.context));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("priority: ");

							if (log_proccessing_1_Info_log.priority != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.priority));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("type: ");

							if (log_proccessing_1_Info_log.type != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.type));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("origin: ");

							if (log_proccessing_1_Info_log.origin != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.origin));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("message: ");

							if (log_proccessing_1_Info_log.message != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.message));

							} //

							strBuffer_log_proccessing_1_tLogRow_1.append("|");

							strBuffer_log_proccessing_1_tLogRow_1
									.append("code: ");

							if (log_proccessing_1_Info_log.code != null) { //

								strBuffer_log_proccessing_1_tLogRow_1
										.append(String
												.valueOf(log_proccessing_1_Info_log.code));

							} //

							if (globalMap.get("tLogRow_CONSOLE") != null) {
								consoleOut_log_proccessing_1_tLogRow_1 = (java.io.PrintStream) globalMap
										.get("tLogRow_CONSOLE");
							} else {
								consoleOut_log_proccessing_1_tLogRow_1 = new java.io.PrintStream(
										new java.io.BufferedOutputStream(
												System.out));
								globalMap.put("tLogRow_CONSOLE",
										consoleOut_log_proccessing_1_tLogRow_1);
							}
							log.info("log_proccessing_1_tLogRow_1 - Content of row "
									+ (nb_line_log_proccessing_1_tLogRow_1 + 1)
									+ ": "
									+ strBuffer_log_proccessing_1_tLogRow_1
											.toString());
							consoleOut_log_proccessing_1_tLogRow_1
									.println(strBuffer_log_proccessing_1_tLogRow_1
											.toString());
							consoleOut_log_proccessing_1_tLogRow_1.flush();
							nb_line_log_proccessing_1_tLogRow_1++;
							// ////

							// ////

							// /////////////////////

							log_proccessing_1_row2 = log_proccessing_1_Info_log;

							tos_count_log_proccessing_1_tLogRow_1++;

							/**
							 * [log_proccessing_1_tLogRow_1 main ] stop
							 */

							/**
							 * [log_proccessing_1_tLogRow_1 process_data_begin ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tLogRow_1";

							/**
							 * [log_proccessing_1_tLogRow_1 process_data_begin ]
							 * stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_1 main ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_1";

							// log_proccessing_1_row2
							// log_proccessing_1_row2

							if (execStat) {
								runStat.updateStatOnConnection(
										"log_proccessing_1_row2" + iterateId,
										1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("log_proccessing_1_row2 - "
										+ (log_proccessing_1_row2 == null ? ""
												: log_proccessing_1_row2
														.toLogString()));
							}

							StringBuilder sb_log_proccessing_1_tFileOutputDelimited_1 = new StringBuilder();
							if (log_proccessing_1_row2.moment != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(FormatterUtils.format_Date(
												log_proccessing_1_row2.moment,
												"yyyy-MM-dd HH:mm:ss"));
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.root_pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.root_pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.father_pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.father_pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.project != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.project);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.job != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.job);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.context != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.context);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.priority != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.priority);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.type != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.type);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.origin != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.origin);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.message != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.message);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_1);
							if (log_proccessing_1_row2.code != null) {
								sb_log_proccessing_1_tFileOutputDelimited_1
										.append(log_proccessing_1_row2.code);
							}
							sb_log_proccessing_1_tFileOutputDelimited_1
									.append(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_1);

							nb_line_log_proccessing_1_tFileOutputDelimited_1++;
							resourceMap
									.put("nb_line_log_proccessing_1_tFileOutputDelimited_1",
											nb_line_log_proccessing_1_tFileOutputDelimited_1);

							outlog_proccessing_1_tFileOutputDelimited_1
									.write(sb_log_proccessing_1_tFileOutputDelimited_1
											.toString());
							log.debug("log_proccessing_1_tFileOutputDelimited_1 - Writing the record "
									+ nb_line_log_proccessing_1_tFileOutputDelimited_1
									+ ".");

							tos_count_log_proccessing_1_tFileOutputDelimited_1++;

							/**
							 * [log_proccessing_1_tFileOutputDelimited_1 main ]
							 * stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_1
							 * process_data_begin ] start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_1";

							/**
							 * [log_proccessing_1_tFileOutputDelimited_1
							 * process_data_begin ] stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_1
							 * process_data_end ] start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_1";

							/**
							 * [log_proccessing_1_tFileOutputDelimited_1
							 * process_data_end ] stop
							 */

							/**
							 * [log_proccessing_1_tLogRow_1 process_data_end ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tLogRow_1";

							/**
							 * [log_proccessing_1_tLogRow_1 process_data_end ]
							 * stop
							 */

						} // End of branch "log_proccessing_1_Info_log"

						// Start of branch "log_proccessing_1_debug_log"
						if (log_proccessing_1_debug_log != null) {

							/**
							 * [log_proccessing_1_tLogRow_2 main ] start
							 */

							currentComponent = "log_proccessing_1_tLogRow_2";

							// log_proccessing_1_debug_log
							// log_proccessing_1_debug_log

							if (execStat) {
								runStat.updateStatOnConnection(
										"log_proccessing_1_debug_log"
												+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("log_proccessing_1_debug_log - "
										+ (log_proccessing_1_debug_log == null ? ""
												: log_proccessing_1_debug_log
														.toLogString()));
							}

							// /////////////////////

							strBuffer_log_proccessing_1_tLogRow_2 = new StringBuilder();

							strBuffer_log_proccessing_1_tLogRow_2
									.append("moment: ");

							if (log_proccessing_1_debug_log.moment != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(FormatterUtils
												.format_Date(
														log_proccessing_1_debug_log.moment,
														"yyyy-MM-dd HH:mm:ss"));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("pid: ");

							if (log_proccessing_1_debug_log.pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("root_pid: ");

							if (log_proccessing_1_debug_log.root_pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.root_pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("father_pid: ");

							if (log_proccessing_1_debug_log.father_pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.father_pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("project: ");

							if (log_proccessing_1_debug_log.project != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.project));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("job: ");

							if (log_proccessing_1_debug_log.job != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.job));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("context: ");

							if (log_proccessing_1_debug_log.context != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.context));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("priority: ");

							if (log_proccessing_1_debug_log.priority != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.priority));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("type: ");

							if (log_proccessing_1_debug_log.type != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.type));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("origin: ");

							if (log_proccessing_1_debug_log.origin != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.origin));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("message: ");

							if (log_proccessing_1_debug_log.message != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.message));

							} //

							strBuffer_log_proccessing_1_tLogRow_2.append("|");

							strBuffer_log_proccessing_1_tLogRow_2
									.append("code: ");

							if (log_proccessing_1_debug_log.code != null) { //

								strBuffer_log_proccessing_1_tLogRow_2
										.append(String
												.valueOf(log_proccessing_1_debug_log.code));

							} //

							if (globalMap.get("tLogRow_CONSOLE") != null) {
								consoleOut_log_proccessing_1_tLogRow_2 = (java.io.PrintStream) globalMap
										.get("tLogRow_CONSOLE");
							} else {
								consoleOut_log_proccessing_1_tLogRow_2 = new java.io.PrintStream(
										new java.io.BufferedOutputStream(
												System.out));
								globalMap.put("tLogRow_CONSOLE",
										consoleOut_log_proccessing_1_tLogRow_2);
							}
							log.info("log_proccessing_1_tLogRow_2 - Content of row "
									+ (nb_line_log_proccessing_1_tLogRow_2 + 1)
									+ ": "
									+ strBuffer_log_proccessing_1_tLogRow_2
											.toString());
							consoleOut_log_proccessing_1_tLogRow_2
									.println(strBuffer_log_proccessing_1_tLogRow_2
											.toString());
							consoleOut_log_proccessing_1_tLogRow_2.flush();
							nb_line_log_proccessing_1_tLogRow_2++;
							// ////

							// ////

							// /////////////////////

							log_proccessing_1_row3 = log_proccessing_1_debug_log;

							tos_count_log_proccessing_1_tLogRow_2++;

							/**
							 * [log_proccessing_1_tLogRow_2 main ] stop
							 */

							/**
							 * [log_proccessing_1_tLogRow_2 process_data_begin ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tLogRow_2";

							/**
							 * [log_proccessing_1_tLogRow_2 process_data_begin ]
							 * stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_2 main ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_2";

							// log_proccessing_1_row3
							// log_proccessing_1_row3

							if (execStat) {
								runStat.updateStatOnConnection(
										"log_proccessing_1_row3" + iterateId,
										1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("log_proccessing_1_row3 - "
										+ (log_proccessing_1_row3 == null ? ""
												: log_proccessing_1_row3
														.toLogString()));
							}

							StringBuilder sb_log_proccessing_1_tFileOutputDelimited_2 = new StringBuilder();
							if (log_proccessing_1_row3.moment != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(FormatterUtils.format_Date(
												log_proccessing_1_row3.moment,
												"yyyy-MM-dd HH:mm:ss"));
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.root_pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.root_pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.father_pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.father_pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.project != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.project);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.job != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.job);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.context != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.context);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.priority != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.priority);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.type != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.type);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.origin != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.origin);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.message != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.message);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_2);
							if (log_proccessing_1_row3.code != null) {
								sb_log_proccessing_1_tFileOutputDelimited_2
										.append(log_proccessing_1_row3.code);
							}
							sb_log_proccessing_1_tFileOutputDelimited_2
									.append(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_2);

							nb_line_log_proccessing_1_tFileOutputDelimited_2++;
							resourceMap
									.put("nb_line_log_proccessing_1_tFileOutputDelimited_2",
											nb_line_log_proccessing_1_tFileOutputDelimited_2);

							outlog_proccessing_1_tFileOutputDelimited_2
									.write(sb_log_proccessing_1_tFileOutputDelimited_2
											.toString());
							log.debug("log_proccessing_1_tFileOutputDelimited_2 - Writing the record "
									+ nb_line_log_proccessing_1_tFileOutputDelimited_2
									+ ".");

							tos_count_log_proccessing_1_tFileOutputDelimited_2++;

							/**
							 * [log_proccessing_1_tFileOutputDelimited_2 main ]
							 * stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_2
							 * process_data_begin ] start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_2";

							/**
							 * [log_proccessing_1_tFileOutputDelimited_2
							 * process_data_begin ] stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_2
							 * process_data_end ] start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_2";

							/**
							 * [log_proccessing_1_tFileOutputDelimited_2
							 * process_data_end ] stop
							 */

							/**
							 * [log_proccessing_1_tLogRow_2 process_data_end ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tLogRow_2";

							/**
							 * [log_proccessing_1_tLogRow_2 process_data_end ]
							 * stop
							 */

						} // End of branch "log_proccessing_1_debug_log"

						// Start of branch "log_proccessing_1_error_log"
						if (log_proccessing_1_error_log != null) {

							/**
							 * [log_proccessing_1_tLogRow_3 main ] start
							 */

							currentComponent = "log_proccessing_1_tLogRow_3";

							// log_proccessing_1_error_log
							// log_proccessing_1_error_log

							if (execStat) {
								runStat.updateStatOnConnection(
										"log_proccessing_1_error_log"
												+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("log_proccessing_1_error_log - "
										+ (log_proccessing_1_error_log == null ? ""
												: log_proccessing_1_error_log
														.toLogString()));
							}

							// /////////////////////

							strBuffer_log_proccessing_1_tLogRow_3 = new StringBuilder();

							strBuffer_log_proccessing_1_tLogRow_3
									.append("moment: ");

							if (log_proccessing_1_error_log.moment != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(FormatterUtils
												.format_Date(
														log_proccessing_1_error_log.moment,
														"yyyy-MM-dd HH:mm:ss"));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("pid: ");

							if (log_proccessing_1_error_log.pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("root_pid: ");

							if (log_proccessing_1_error_log.root_pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.root_pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("father_pid: ");

							if (log_proccessing_1_error_log.father_pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.father_pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("project: ");

							if (log_proccessing_1_error_log.project != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.project));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("job: ");

							if (log_proccessing_1_error_log.job != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.job));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("context: ");

							if (log_proccessing_1_error_log.context != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.context));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("priority: ");

							if (log_proccessing_1_error_log.priority != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.priority));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("type: ");

							if (log_proccessing_1_error_log.type != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.type));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("origin: ");

							if (log_proccessing_1_error_log.origin != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.origin));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("message: ");

							if (log_proccessing_1_error_log.message != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.message));

							} //

							strBuffer_log_proccessing_1_tLogRow_3.append("|");

							strBuffer_log_proccessing_1_tLogRow_3
									.append("code: ");

							if (log_proccessing_1_error_log.code != null) { //

								strBuffer_log_proccessing_1_tLogRow_3
										.append(String
												.valueOf(log_proccessing_1_error_log.code));

							} //

							if (globalMap.get("tLogRow_CONSOLE") != null) {
								consoleOut_log_proccessing_1_tLogRow_3 = (java.io.PrintStream) globalMap
										.get("tLogRow_CONSOLE");
							} else {
								consoleOut_log_proccessing_1_tLogRow_3 = new java.io.PrintStream(
										new java.io.BufferedOutputStream(
												System.out));
								globalMap.put("tLogRow_CONSOLE",
										consoleOut_log_proccessing_1_tLogRow_3);
							}
							log.info("log_proccessing_1_tLogRow_3 - Content of row "
									+ (nb_line_log_proccessing_1_tLogRow_3 + 1)
									+ ": "
									+ strBuffer_log_proccessing_1_tLogRow_3
											.toString());
							consoleOut_log_proccessing_1_tLogRow_3
									.println(strBuffer_log_proccessing_1_tLogRow_3
											.toString());
							consoleOut_log_proccessing_1_tLogRow_3.flush();
							nb_line_log_proccessing_1_tLogRow_3++;
							// ////

							// ////

							// /////////////////////

							log_proccessing_1_row5 = log_proccessing_1_error_log;

							tos_count_log_proccessing_1_tLogRow_3++;

							/**
							 * [log_proccessing_1_tLogRow_3 main ] stop
							 */

							/**
							 * [log_proccessing_1_tLogRow_3 process_data_begin ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tLogRow_3";

							/**
							 * [log_proccessing_1_tLogRow_3 process_data_begin ]
							 * stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_4 main ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_4";

							// log_proccessing_1_row5
							// log_proccessing_1_row5

							if (execStat) {
								runStat.updateStatOnConnection(
										"log_proccessing_1_row5" + iterateId,
										1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("log_proccessing_1_row5 - "
										+ (log_proccessing_1_row5 == null ? ""
												: log_proccessing_1_row5
														.toLogString()));
							}

							StringBuilder sb_log_proccessing_1_tFileOutputDelimited_4 = new StringBuilder();
							if (log_proccessing_1_row5.moment != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(FormatterUtils.format_Date(
												log_proccessing_1_row5.moment,
												"yyyy-MM-dd HH:mm:ss"));
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.root_pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.root_pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.father_pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.father_pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.project != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.project);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.job != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.job);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.context != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.context);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.priority != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.priority);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.type != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.type);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.origin != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.origin);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.message != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.message);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_4);
							if (log_proccessing_1_row5.code != null) {
								sb_log_proccessing_1_tFileOutputDelimited_4
										.append(log_proccessing_1_row5.code);
							}
							sb_log_proccessing_1_tFileOutputDelimited_4
									.append(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_4);

							nb_line_log_proccessing_1_tFileOutputDelimited_4++;
							resourceMap
									.put("nb_line_log_proccessing_1_tFileOutputDelimited_4",
											nb_line_log_proccessing_1_tFileOutputDelimited_4);

							outlog_proccessing_1_tFileOutputDelimited_4
									.write(sb_log_proccessing_1_tFileOutputDelimited_4
											.toString());
							log.debug("log_proccessing_1_tFileOutputDelimited_4 - Writing the record "
									+ nb_line_log_proccessing_1_tFileOutputDelimited_4
									+ ".");

							tos_count_log_proccessing_1_tFileOutputDelimited_4++;

							/**
							 * [log_proccessing_1_tFileOutputDelimited_4 main ]
							 * stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_4
							 * process_data_begin ] start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_4";

							/**
							 * [log_proccessing_1_tFileOutputDelimited_4
							 * process_data_begin ] stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_4
							 * process_data_end ] start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_4";

							/**
							 * [log_proccessing_1_tFileOutputDelimited_4
							 * process_data_end ] stop
							 */

							/**
							 * [log_proccessing_1_tLogRow_3 process_data_end ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tLogRow_3";

							/**
							 * [log_proccessing_1_tLogRow_3 process_data_end ]
							 * stop
							 */

						} // End of branch "log_proccessing_1_error_log"

						// Start of branch "log_proccessing_1_fatal_error_log"
						if (log_proccessing_1_fatal_error_log != null) {

							/**
							 * [log_proccessing_1_tLogRow_4 main ] start
							 */

							currentComponent = "log_proccessing_1_tLogRow_4";

							// log_proccessing_1_fatal_error_log
							// log_proccessing_1_fatal_error_log

							if (execStat) {
								runStat.updateStatOnConnection(
										"log_proccessing_1_fatal_error_log"
												+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("log_proccessing_1_fatal_error_log - "
										+ (log_proccessing_1_fatal_error_log == null ? ""
												: log_proccessing_1_fatal_error_log
														.toLogString()));
							}

							// /////////////////////

							strBuffer_log_proccessing_1_tLogRow_4 = new StringBuilder();

							strBuffer_log_proccessing_1_tLogRow_4
									.append("moment: ");

							if (log_proccessing_1_fatal_error_log.moment != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(FormatterUtils
												.format_Date(
														log_proccessing_1_fatal_error_log.moment,
														"yyyy-MM-dd HH:mm:ss"));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("pid: ");

							if (log_proccessing_1_fatal_error_log.pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("root_pid: ");

							if (log_proccessing_1_fatal_error_log.root_pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.root_pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("father_pid: ");

							if (log_proccessing_1_fatal_error_log.father_pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.father_pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("project: ");

							if (log_proccessing_1_fatal_error_log.project != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.project));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("job: ");

							if (log_proccessing_1_fatal_error_log.job != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.job));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("context: ");

							if (log_proccessing_1_fatal_error_log.context != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.context));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("priority: ");

							if (log_proccessing_1_fatal_error_log.priority != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.priority));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("type: ");

							if (log_proccessing_1_fatal_error_log.type != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.type));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("origin: ");

							if (log_proccessing_1_fatal_error_log.origin != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.origin));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("message: ");

							if (log_proccessing_1_fatal_error_log.message != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.message));

							} //

							strBuffer_log_proccessing_1_tLogRow_4.append("|");

							strBuffer_log_proccessing_1_tLogRow_4
									.append("code: ");

							if (log_proccessing_1_fatal_error_log.code != null) { //

								strBuffer_log_proccessing_1_tLogRow_4
										.append(String
												.valueOf(log_proccessing_1_fatal_error_log.code));

							} //

							if (globalMap.get("tLogRow_CONSOLE") != null) {
								consoleOut_log_proccessing_1_tLogRow_4 = (java.io.PrintStream) globalMap
										.get("tLogRow_CONSOLE");
							} else {
								consoleOut_log_proccessing_1_tLogRow_4 = new java.io.PrintStream(
										new java.io.BufferedOutputStream(
												System.out));
								globalMap.put("tLogRow_CONSOLE",
										consoleOut_log_proccessing_1_tLogRow_4);
							}
							log.info("log_proccessing_1_tLogRow_4 - Content of row "
									+ (nb_line_log_proccessing_1_tLogRow_4 + 1)
									+ ": "
									+ strBuffer_log_proccessing_1_tLogRow_4
											.toString());
							consoleOut_log_proccessing_1_tLogRow_4
									.println(strBuffer_log_proccessing_1_tLogRow_4
											.toString());
							consoleOut_log_proccessing_1_tLogRow_4.flush();
							nb_line_log_proccessing_1_tLogRow_4++;
							// ////

							// ////

							// /////////////////////

							log_proccessing_1_row6 = log_proccessing_1_fatal_error_log;

							tos_count_log_proccessing_1_tLogRow_4++;

							/**
							 * [log_proccessing_1_tLogRow_4 main ] stop
							 */

							/**
							 * [log_proccessing_1_tLogRow_4 process_data_begin ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tLogRow_4";

							/**
							 * [log_proccessing_1_tLogRow_4 process_data_begin ]
							 * stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_5 main ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_5";

							// log_proccessing_1_row6
							// log_proccessing_1_row6

							if (execStat) {
								runStat.updateStatOnConnection(
										"log_proccessing_1_row6" + iterateId,
										1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("log_proccessing_1_row6 - "
										+ (log_proccessing_1_row6 == null ? ""
												: log_proccessing_1_row6
														.toLogString()));
							}

							StringBuilder sb_log_proccessing_1_tFileOutputDelimited_5 = new StringBuilder();
							if (log_proccessing_1_row6.moment != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(FormatterUtils.format_Date(
												log_proccessing_1_row6.moment,
												"yyyy-MM-dd HH:mm:ss"));
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.root_pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.root_pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.father_pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.father_pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.project != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.project);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.job != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.job);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.context != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.context);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.priority != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.priority);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.type != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.type);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.origin != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.origin);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.message != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.message);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_5);
							if (log_proccessing_1_row6.code != null) {
								sb_log_proccessing_1_tFileOutputDelimited_5
										.append(log_proccessing_1_row6.code);
							}
							sb_log_proccessing_1_tFileOutputDelimited_5
									.append(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_5);

							nb_line_log_proccessing_1_tFileOutputDelimited_5++;
							resourceMap
									.put("nb_line_log_proccessing_1_tFileOutputDelimited_5",
											nb_line_log_proccessing_1_tFileOutputDelimited_5);

							outlog_proccessing_1_tFileOutputDelimited_5
									.write(sb_log_proccessing_1_tFileOutputDelimited_5
											.toString());
							log.debug("log_proccessing_1_tFileOutputDelimited_5 - Writing the record "
									+ nb_line_log_proccessing_1_tFileOutputDelimited_5
									+ ".");

							tos_count_log_proccessing_1_tFileOutputDelimited_5++;

							/**
							 * [log_proccessing_1_tFileOutputDelimited_5 main ]
							 * stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_5
							 * process_data_begin ] start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_5";

							/**
							 * [log_proccessing_1_tFileOutputDelimited_5
							 * process_data_begin ] stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_5
							 * process_data_end ] start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_5";

							/**
							 * [log_proccessing_1_tFileOutputDelimited_5
							 * process_data_end ] stop
							 */

							/**
							 * [log_proccessing_1_tLogRow_4 process_data_end ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tLogRow_4";

							/**
							 * [log_proccessing_1_tLogRow_4 process_data_end ]
							 * stop
							 */

						} // End of branch "log_proccessing_1_fatal_error_log"

						// Start of branch "log_proccessing_1_warn_log"
						if (log_proccessing_1_warn_log != null) {

							/**
							 * [log_proccessing_1_tLogRow_5 main ] start
							 */

							currentComponent = "log_proccessing_1_tLogRow_5";

							// log_proccessing_1_warn_log
							// log_proccessing_1_warn_log

							if (execStat) {
								runStat.updateStatOnConnection(
										"log_proccessing_1_warn_log"
												+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("log_proccessing_1_warn_log - "
										+ (log_proccessing_1_warn_log == null ? ""
												: log_proccessing_1_warn_log
														.toLogString()));
							}

							// /////////////////////

							strBuffer_log_proccessing_1_tLogRow_5 = new StringBuilder();

							strBuffer_log_proccessing_1_tLogRow_5
									.append("moment: ");

							if (log_proccessing_1_warn_log.moment != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(FormatterUtils
												.format_Date(
														log_proccessing_1_warn_log.moment,
														"yyyy-MM-dd HH:mm:ss"));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("pid: ");

							if (log_proccessing_1_warn_log.pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("root_pid: ");

							if (log_proccessing_1_warn_log.root_pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.root_pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("father_pid: ");

							if (log_proccessing_1_warn_log.father_pid != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.father_pid));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("project: ");

							if (log_proccessing_1_warn_log.project != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.project));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("job: ");

							if (log_proccessing_1_warn_log.job != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.job));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("context: ");

							if (log_proccessing_1_warn_log.context != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.context));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("priority: ");

							if (log_proccessing_1_warn_log.priority != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.priority));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("type: ");

							if (log_proccessing_1_warn_log.type != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.type));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("origin: ");

							if (log_proccessing_1_warn_log.origin != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.origin));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("message: ");

							if (log_proccessing_1_warn_log.message != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.message));

							} //

							strBuffer_log_proccessing_1_tLogRow_5.append("|");

							strBuffer_log_proccessing_1_tLogRow_5
									.append("code: ");

							if (log_proccessing_1_warn_log.code != null) { //

								strBuffer_log_proccessing_1_tLogRow_5
										.append(String
												.valueOf(log_proccessing_1_warn_log.code));

							} //

							if (globalMap.get("tLogRow_CONSOLE") != null) {
								consoleOut_log_proccessing_1_tLogRow_5 = (java.io.PrintStream) globalMap
										.get("tLogRow_CONSOLE");
							} else {
								consoleOut_log_proccessing_1_tLogRow_5 = new java.io.PrintStream(
										new java.io.BufferedOutputStream(
												System.out));
								globalMap.put("tLogRow_CONSOLE",
										consoleOut_log_proccessing_1_tLogRow_5);
							}
							log.info("log_proccessing_1_tLogRow_5 - Content of row "
									+ (nb_line_log_proccessing_1_tLogRow_5 + 1)
									+ ": "
									+ strBuffer_log_proccessing_1_tLogRow_5
											.toString());
							consoleOut_log_proccessing_1_tLogRow_5
									.println(strBuffer_log_proccessing_1_tLogRow_5
											.toString());
							consoleOut_log_proccessing_1_tLogRow_5.flush();
							nb_line_log_proccessing_1_tLogRow_5++;
							// ////

							// ////

							// /////////////////////

							log_proccessing_1_row4 = log_proccessing_1_warn_log;

							tos_count_log_proccessing_1_tLogRow_5++;

							/**
							 * [log_proccessing_1_tLogRow_5 main ] stop
							 */

							/**
							 * [log_proccessing_1_tLogRow_5 process_data_begin ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tLogRow_5";

							/**
							 * [log_proccessing_1_tLogRow_5 process_data_begin ]
							 * stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_3 main ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_3";

							// log_proccessing_1_row4
							// log_proccessing_1_row4

							if (execStat) {
								runStat.updateStatOnConnection(
										"log_proccessing_1_row4" + iterateId,
										1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("log_proccessing_1_row4 - "
										+ (log_proccessing_1_row4 == null ? ""
												: log_proccessing_1_row4
														.toLogString()));
							}

							StringBuilder sb_log_proccessing_1_tFileOutputDelimited_3 = new StringBuilder();
							if (log_proccessing_1_row4.moment != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(FormatterUtils.format_Date(
												log_proccessing_1_row4.moment,
												"yyyy-MM-dd HH:mm:ss"));
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.root_pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.root_pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.father_pid != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.father_pid);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.project != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.project);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.job != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.job);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.context != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.context);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.priority != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.priority);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.type != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.type);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.origin != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.origin);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.message != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.message);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_log_proccessing_1_tFileOutputDelimited_3);
							if (log_proccessing_1_row4.code != null) {
								sb_log_proccessing_1_tFileOutputDelimited_3
										.append(log_proccessing_1_row4.code);
							}
							sb_log_proccessing_1_tFileOutputDelimited_3
									.append(OUT_DELIM_ROWSEP_log_proccessing_1_tFileOutputDelimited_3);

							nb_line_log_proccessing_1_tFileOutputDelimited_3++;
							resourceMap
									.put("nb_line_log_proccessing_1_tFileOutputDelimited_3",
											nb_line_log_proccessing_1_tFileOutputDelimited_3);

							outlog_proccessing_1_tFileOutputDelimited_3
									.write(sb_log_proccessing_1_tFileOutputDelimited_3
											.toString());
							log.debug("log_proccessing_1_tFileOutputDelimited_3 - Writing the record "
									+ nb_line_log_proccessing_1_tFileOutputDelimited_3
									+ ".");

							tos_count_log_proccessing_1_tFileOutputDelimited_3++;

							/**
							 * [log_proccessing_1_tFileOutputDelimited_3 main ]
							 * stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_3
							 * process_data_begin ] start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_3";

							/**
							 * [log_proccessing_1_tFileOutputDelimited_3
							 * process_data_begin ] stop
							 */

							/**
							 * [log_proccessing_1_tFileOutputDelimited_3
							 * process_data_end ] start
							 */

							currentComponent = "log_proccessing_1_tFileOutputDelimited_3";

							/**
							 * [log_proccessing_1_tFileOutputDelimited_3
							 * process_data_end ] stop
							 */

							/**
							 * [log_proccessing_1_tLogRow_5 process_data_end ]
							 * start
							 */

							currentComponent = "log_proccessing_1_tLogRow_5";

							/**
							 * [log_proccessing_1_tLogRow_5 process_data_end ]
							 * stop
							 */

						} // End of branch "log_proccessing_1_warn_log"

						/**
						 * [log_proccessing_1_tMap_1 process_data_end ] start
						 */

						currentComponent = "log_proccessing_1_tMap_1";

						/**
						 * [log_proccessing_1_tMap_1 process_data_end ] stop
						 */

						/**
						 * [log_proccessing_1_tLogCatcher_1 process_data_end ]
						 * start
						 */

						currentComponent = "log_proccessing_1_tLogCatcher_1";

						/**
						 * [log_proccessing_1_tLogCatcher_1 process_data_end ]
						 * stop
						 */

						/**
						 * [log_proccessing_1_tLogCatcher_1 end ] start
						 */

						currentComponent = "log_proccessing_1_tLogCatcher_1";

					}
				} catch (Exception e_log_proccessing_1_tLogCatcher_1) {
					logIgnoredError(
							String.format(
									"log_proccessing_1_tLogCatcher_1 - tLogCatcher failed to process log message(s) due to internal error: %s",
									e_log_proccessing_1_tLogCatcher_1),
							e_log_proccessing_1_tLogCatcher_1);
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogCatcher_1 - " + ("Done."));

				ok_Hash.put("log_proccessing_1_tLogCatcher_1", true);
				end_Hash.put("log_proccessing_1_tLogCatcher_1",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tLogCatcher_1 end ] stop
				 */

				/**
				 * [log_proccessing_1_tMap_1 end ] start
				 */

				currentComponent = "log_proccessing_1_tMap_1";

				// ###############################
				// # Lookup hashes releasing
				// ###############################
				log.debug("log_proccessing_1_tMap_1 - Written records count in the table 'log_proccessing_1_Info_log': "
						+ count_log_proccessing_1_Info_log_log_proccessing_1_tMap_1
						+ ".");
				log.debug("log_proccessing_1_tMap_1 - Written records count in the table 'log_proccessing_1_debug_log': "
						+ count_log_proccessing_1_debug_log_log_proccessing_1_tMap_1
						+ ".");
				log.debug("log_proccessing_1_tMap_1 - Written records count in the table 'log_proccessing_1_error_log': "
						+ count_log_proccessing_1_error_log_log_proccessing_1_tMap_1
						+ ".");
				log.debug("log_proccessing_1_tMap_1 - Written records count in the table 'log_proccessing_1_fatal_error_log': "
						+ count_log_proccessing_1_fatal_error_log_log_proccessing_1_tMap_1
						+ ".");
				log.debug("log_proccessing_1_tMap_1 - Written records count in the table 'log_proccessing_1_warn_log': "
						+ count_log_proccessing_1_warn_log_log_proccessing_1_tMap_1
						+ ".");

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("log_proccessing_1_row1"
								+ iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tMap_1 - " + ("Done."));

				ok_Hash.put("log_proccessing_1_tMap_1", true);
				end_Hash.put("log_proccessing_1_tMap_1",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tMap_1 end ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_1 end ] start
				 */

				currentComponent = "log_proccessing_1_tLogRow_1";

				// ////
				// ////
				globalMap.put("log_proccessing_1_tLogRow_1_NB_LINE",
						nb_line_log_proccessing_1_tLogRow_1);
				if (log.isInfoEnabled())
					log.info("log_proccessing_1_tLogRow_1 - "
							+ ("Printed row count: ")
							+ (nb_line_log_proccessing_1_tLogRow_1) + ("."));

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection(
								"log_proccessing_1_Info_log" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogRow_1 - " + ("Done."));

				ok_Hash.put("log_proccessing_1_tLogRow_1", true);
				end_Hash.put("log_proccessing_1_tLogRow_1",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tLogRow_1 end ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_1 end ] start
				 */

				currentComponent = "log_proccessing_1_tFileOutputDelimited_1";

				if (outlog_proccessing_1_tFileOutputDelimited_1 != null) {
					outlog_proccessing_1_tFileOutputDelimited_1.flush();
					outlog_proccessing_1_tFileOutputDelimited_1.close();
				}

				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_1_NB_LINE",
						nb_line_log_proccessing_1_tFileOutputDelimited_1);
				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_1_FILE_NAME",
						fileName_log_proccessing_1_tFileOutputDelimited_1);

				resourceMap
						.put("finish_log_proccessing_1_tFileOutputDelimited_1",
								true);

				log.debug("log_proccessing_1_tFileOutputDelimited_1 - Written records count: "
						+ nb_line_log_proccessing_1_tFileOutputDelimited_1
						+ " .");

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("log_proccessing_1_row2"
								+ iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tFileOutputDelimited_1 - "
							+ ("Done."));

				ok_Hash.put("log_proccessing_1_tFileOutputDelimited_1", true);
				end_Hash.put("log_proccessing_1_tFileOutputDelimited_1",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tFileOutputDelimited_1 end ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_2 end ] start
				 */

				currentComponent = "log_proccessing_1_tLogRow_2";

				// ////
				// ////
				globalMap.put("log_proccessing_1_tLogRow_2_NB_LINE",
						nb_line_log_proccessing_1_tLogRow_2);
				if (log.isInfoEnabled())
					log.info("log_proccessing_1_tLogRow_2 - "
							+ ("Printed row count: ")
							+ (nb_line_log_proccessing_1_tLogRow_2) + ("."));

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection(
								"log_proccessing_1_debug_log" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogRow_2 - " + ("Done."));

				ok_Hash.put("log_proccessing_1_tLogRow_2", true);
				end_Hash.put("log_proccessing_1_tLogRow_2",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tLogRow_2 end ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_2 end ] start
				 */

				currentComponent = "log_proccessing_1_tFileOutputDelimited_2";

				if (outlog_proccessing_1_tFileOutputDelimited_2 != null) {
					outlog_proccessing_1_tFileOutputDelimited_2.flush();
					outlog_proccessing_1_tFileOutputDelimited_2.close();
				}

				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_2_NB_LINE",
						nb_line_log_proccessing_1_tFileOutputDelimited_2);
				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_2_FILE_NAME",
						fileName_log_proccessing_1_tFileOutputDelimited_2);

				resourceMap
						.put("finish_log_proccessing_1_tFileOutputDelimited_2",
								true);

				log.debug("log_proccessing_1_tFileOutputDelimited_2 - Written records count: "
						+ nb_line_log_proccessing_1_tFileOutputDelimited_2
						+ " .");

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("log_proccessing_1_row3"
								+ iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tFileOutputDelimited_2 - "
							+ ("Done."));

				ok_Hash.put("log_proccessing_1_tFileOutputDelimited_2", true);
				end_Hash.put("log_proccessing_1_tFileOutputDelimited_2",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tFileOutputDelimited_2 end ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_3 end ] start
				 */

				currentComponent = "log_proccessing_1_tLogRow_3";

				// ////
				// ////
				globalMap.put("log_proccessing_1_tLogRow_3_NB_LINE",
						nb_line_log_proccessing_1_tLogRow_3);
				if (log.isInfoEnabled())
					log.info("log_proccessing_1_tLogRow_3 - "
							+ ("Printed row count: ")
							+ (nb_line_log_proccessing_1_tLogRow_3) + ("."));

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection(
								"log_proccessing_1_error_log" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogRow_3 - " + ("Done."));

				ok_Hash.put("log_proccessing_1_tLogRow_3", true);
				end_Hash.put("log_proccessing_1_tLogRow_3",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tLogRow_3 end ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_4 end ] start
				 */

				currentComponent = "log_proccessing_1_tFileOutputDelimited_4";

				if (outlog_proccessing_1_tFileOutputDelimited_4 != null) {
					outlog_proccessing_1_tFileOutputDelimited_4.flush();
					outlog_proccessing_1_tFileOutputDelimited_4.close();
				}

				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_4_NB_LINE",
						nb_line_log_proccessing_1_tFileOutputDelimited_4);
				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_4_FILE_NAME",
						fileName_log_proccessing_1_tFileOutputDelimited_4);

				resourceMap
						.put("finish_log_proccessing_1_tFileOutputDelimited_4",
								true);

				log.debug("log_proccessing_1_tFileOutputDelimited_4 - Written records count: "
						+ nb_line_log_proccessing_1_tFileOutputDelimited_4
						+ " .");

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("log_proccessing_1_row5"
								+ iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tFileOutputDelimited_4 - "
							+ ("Done."));

				ok_Hash.put("log_proccessing_1_tFileOutputDelimited_4", true);
				end_Hash.put("log_proccessing_1_tFileOutputDelimited_4",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tFileOutputDelimited_4 end ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_4 end ] start
				 */

				currentComponent = "log_proccessing_1_tLogRow_4";

				// ////
				// ////
				globalMap.put("log_proccessing_1_tLogRow_4_NB_LINE",
						nb_line_log_proccessing_1_tLogRow_4);
				if (log.isInfoEnabled())
					log.info("log_proccessing_1_tLogRow_4 - "
							+ ("Printed row count: ")
							+ (nb_line_log_proccessing_1_tLogRow_4) + ("."));

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection(
								"log_proccessing_1_fatal_error_log" + iterateId,
								2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogRow_4 - " + ("Done."));

				ok_Hash.put("log_proccessing_1_tLogRow_4", true);
				end_Hash.put("log_proccessing_1_tLogRow_4",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tLogRow_4 end ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_5 end ] start
				 */

				currentComponent = "log_proccessing_1_tFileOutputDelimited_5";

				if (outlog_proccessing_1_tFileOutputDelimited_5 != null) {
					outlog_proccessing_1_tFileOutputDelimited_5.flush();
					outlog_proccessing_1_tFileOutputDelimited_5.close();
				}

				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_5_NB_LINE",
						nb_line_log_proccessing_1_tFileOutputDelimited_5);
				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_5_FILE_NAME",
						fileName_log_proccessing_1_tFileOutputDelimited_5);

				resourceMap
						.put("finish_log_proccessing_1_tFileOutputDelimited_5",
								true);

				log.debug("log_proccessing_1_tFileOutputDelimited_5 - Written records count: "
						+ nb_line_log_proccessing_1_tFileOutputDelimited_5
						+ " .");

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("log_proccessing_1_row6"
								+ iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tFileOutputDelimited_5 - "
							+ ("Done."));

				ok_Hash.put("log_proccessing_1_tFileOutputDelimited_5", true);
				end_Hash.put("log_proccessing_1_tFileOutputDelimited_5",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tFileOutputDelimited_5 end ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_5 end ] start
				 */

				currentComponent = "log_proccessing_1_tLogRow_5";

				// ////
				// ////
				globalMap.put("log_proccessing_1_tLogRow_5_NB_LINE",
						nb_line_log_proccessing_1_tLogRow_5);
				if (log.isInfoEnabled())
					log.info("log_proccessing_1_tLogRow_5 - "
							+ ("Printed row count: ")
							+ (nb_line_log_proccessing_1_tLogRow_5) + ("."));

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection(
								"log_proccessing_1_warn_log" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tLogRow_5 - " + ("Done."));

				ok_Hash.put("log_proccessing_1_tLogRow_5", true);
				end_Hash.put("log_proccessing_1_tLogRow_5",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tLogRow_5 end ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_3 end ] start
				 */

				currentComponent = "log_proccessing_1_tFileOutputDelimited_3";

				if (outlog_proccessing_1_tFileOutputDelimited_3 != null) {
					outlog_proccessing_1_tFileOutputDelimited_3.flush();
					outlog_proccessing_1_tFileOutputDelimited_3.close();
				}

				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_3_NB_LINE",
						nb_line_log_proccessing_1_tFileOutputDelimited_3);
				globalMap.put(
						"log_proccessing_1_tFileOutputDelimited_3_FILE_NAME",
						fileName_log_proccessing_1_tFileOutputDelimited_3);

				resourceMap
						.put("finish_log_proccessing_1_tFileOutputDelimited_3",
								true);

				log.debug("log_proccessing_1_tFileOutputDelimited_3 - Written records count: "
						+ nb_line_log_proccessing_1_tFileOutputDelimited_3
						+ " .");

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("log_proccessing_1_row4"
								+ iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("log_proccessing_1_tFileOutputDelimited_3 - "
							+ ("Done."));

				ok_Hash.put("log_proccessing_1_tFileOutputDelimited_3", true);
				end_Hash.put("log_proccessing_1_tFileOutputDelimited_3",
						System.currentTimeMillis());

				/**
				 * [log_proccessing_1_tFileOutputDelimited_3 end ] stop
				 */

			}// end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [log_proccessing_1_tLogCatcher_1 finally ] start
				 */

				currentComponent = "log_proccessing_1_tLogCatcher_1";

				/**
				 * [log_proccessing_1_tLogCatcher_1 finally ] stop
				 */

				/**
				 * [log_proccessing_1_tMap_1 finally ] start
				 */

				currentComponent = "log_proccessing_1_tMap_1";

				/**
				 * [log_proccessing_1_tMap_1 finally ] stop
				 */

				/**
				 * [log_proccessing_1_tLogRow_1 finally ] start
				 */

				currentComponent = "log_proccessing_1_tLogRow_1";

				/**
				 * [log_proccessing_1_tLogRow_1 finally ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_1 finally ] start
				 */

				currentComponent = "log_proccessing_1_tFileOutputDelimited_1";

				if (resourceMap
						.get("finish_log_proccessing_1_tFileOutputDelimited_1") == null) {

					java.io.Writer outlog_proccessing_1_tFileOutputDelimited_1 = (java.io.Writer) resourceMap
							.get("out_log_proccessing_1_tFileOutputDelimited_1");
					if (outlog_proccessing_1_tFileOutputDelimited_1 != null) {
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

				currentComponent = "log_proccessing_1_tLogRow_2";

				/**
				 * [log_proccessing_1_tLogRow_2 finally ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_2 finally ] start
				 */

				currentComponent = "log_proccessing_1_tFileOutputDelimited_2";

				if (resourceMap
						.get("finish_log_proccessing_1_tFileOutputDelimited_2") == null) {

					java.io.Writer outlog_proccessing_1_tFileOutputDelimited_2 = (java.io.Writer) resourceMap
							.get("out_log_proccessing_1_tFileOutputDelimited_2");
					if (outlog_proccessing_1_tFileOutputDelimited_2 != null) {
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

				currentComponent = "log_proccessing_1_tLogRow_3";

				/**
				 * [log_proccessing_1_tLogRow_3 finally ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_4 finally ] start
				 */

				currentComponent = "log_proccessing_1_tFileOutputDelimited_4";

				if (resourceMap
						.get("finish_log_proccessing_1_tFileOutputDelimited_4") == null) {

					java.io.Writer outlog_proccessing_1_tFileOutputDelimited_4 = (java.io.Writer) resourceMap
							.get("out_log_proccessing_1_tFileOutputDelimited_4");
					if (outlog_proccessing_1_tFileOutputDelimited_4 != null) {
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

				currentComponent = "log_proccessing_1_tLogRow_4";

				/**
				 * [log_proccessing_1_tLogRow_4 finally ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_5 finally ] start
				 */

				currentComponent = "log_proccessing_1_tFileOutputDelimited_5";

				if (resourceMap
						.get("finish_log_proccessing_1_tFileOutputDelimited_5") == null) {

					java.io.Writer outlog_proccessing_1_tFileOutputDelimited_5 = (java.io.Writer) resourceMap
							.get("out_log_proccessing_1_tFileOutputDelimited_5");
					if (outlog_proccessing_1_tFileOutputDelimited_5 != null) {
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

				currentComponent = "log_proccessing_1_tLogRow_5";

				/**
				 * [log_proccessing_1_tLogRow_5 finally ] stop
				 */

				/**
				 * [log_proccessing_1_tFileOutputDelimited_3 finally ] start
				 */

				currentComponent = "log_proccessing_1_tFileOutputDelimited_3";

				if (resourceMap
						.get("finish_log_proccessing_1_tFileOutputDelimited_3") == null) {

					java.io.Writer outlog_proccessing_1_tFileOutputDelimited_3 = (java.io.Writer) resourceMap
							.get("out_log_proccessing_1_tFileOutputDelimited_3");
					if (outlog_proccessing_1_tFileOutputDelimited_3 != null) {
						outlog_proccessing_1_tFileOutputDelimited_3.flush();
						outlog_proccessing_1_tFileOutputDelimited_3.close();
					}

				}

				/**
				 * [log_proccessing_1_tFileOutputDelimited_3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("log_proccessing_1_tLogCatcher_1_SUBPROCESS_STATE", 1);
	}

	public static class row5Struct implements
			routines.system.IPersistableRow<row5Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public String key;

		public String getKey() {
			return this.key;
		}

		public String value;

		public String getValue() {
			return this.value;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("key=" + key);
			sb.append(",value=" + value);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (key == null) {
				sb.append("<null>");
			} else {
				sb.append(key);
			}

			sb.append("|");

			if (value == null) {
				sb.append("<null>");
			} else {
				sb.append(value);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public void tFileInputDelimited_1Process(
			final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception()
						.getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row5Struct row5 = new row5Struct();

				/**
				 * [tContextLoad_1 begin ] start
				 */

				ok_Hash.put("tContextLoad_1", false);
				start_Hash.put("tContextLoad_1", System.currentTimeMillis());

				currentComponent = "tContextLoad_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row5" + iterateId, 0, 0);

					}
				}

				int tos_count_tContextLoad_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tContextLoad_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tContextLoad_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tContextLoad_1 = new StringBuilder();
							log4jParamters_tContextLoad_1.append("Parameters:");
							log4jParamters_tContextLoad_1
									.append("LOAD_NEW_VARIABLE" + " = "
											+ "Warning");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1
									.append("NOT_LOAD_OLD_VARIABLE" + " = "
											+ "Warning");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1
									.append("PRINT_OPERATIONS" + " = "
											+ "false");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1
									.append("DISABLE_ERROR" + " = " + "false");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1
									.append("DISABLE_WARNINGS" + " = " + "true");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1.append("DISABLE_INFO"
									+ " = " + "true");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1.append("DIEONERROR"
									+ " = " + "false");
							log4jParamters_tContextLoad_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tContextLoad_1 - "
										+ (log4jParamters_tContextLoad_1));
						}
					}
					new BytesLimit65535_tContextLoad_1().limitLog4jByte();
				}
				java.util.List<String> assignList_tContextLoad_1 = new java.util.ArrayList<String>();
				java.util.List<String> newPropertyList_tContextLoad_1 = new java.util.ArrayList<String>();
				java.util.List<String> noAssignList_tContextLoad_1 = new java.util.ArrayList<String>();
				int nb_line_tContextLoad_1 = 0;

				/**
				 * [tContextLoad_1 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_1", false);
				start_Hash.put("tFileInputDelimited_1",
						System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_1";

				int tos_count_tFileInputDelimited_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFileInputDelimited_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFileInputDelimited_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFileInputDelimited_1 = new StringBuilder();
							log4jParamters_tFileInputDelimited_1
									.append("Parameters:");
							log4jParamters_tFileInputDelimited_1
									.append("FILENAME"
											+ " = "
											+ "\"/Users/alik/Downloads/connection.config\"");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("CSV_OPTION" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("ROWSEPARATOR" + " = " + "\"\\n\"");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("FIELDSEPARATOR" + " = " + "\";\"");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("HEADER" + " = " + "0");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("FOOTER" + " = " + "0");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1.append("LIMIT"
									+ " = " + "");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("REMOVE_EMPTY_ROW" + " = " + "true");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("UNCOMPRESS" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("ADVANCED_SEPARATOR" + " = "
											+ "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("RANDOM" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("TRIMALL" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("TRIMSELECT" + " = " + "[{TRIM="
											+ ("false") + ", SCHEMA_COLUMN="
											+ ("key") + "}, {TRIM=" + ("false")
											+ ", SCHEMA_COLUMN=" + ("value")
											+ "}]");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("CHECK_FIELDS_NUM" + " = "
											+ "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("CHECK_DATE" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("ENCODING" + " = "
											+ "\"ISO-8859-15\"");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("SPLITRECORD" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							log4jParamters_tFileInputDelimited_1
									.append("ENABLE_DECODE" + " = " + "false");
							log4jParamters_tFileInputDelimited_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFileInputDelimited_1 - "
										+ (log4jParamters_tFileInputDelimited_1));
						}
					}
					new BytesLimit65535_tFileInputDelimited_1()
							.limitLog4jByte();
				}

				final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_1 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_1 = null;
				try {

					Object filename_tFileInputDelimited_1 = "/Users/alik/Downloads/connection.config";
					if (filename_tFileInputDelimited_1 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
						if (footer_value_tFileInputDelimited_1 > 0
								|| random_value_tFileInputDelimited_1 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited(
								"/Users/alik/Downloads/connection.config",
								"ISO-8859-15", ";", "\n", true, 0, 0, -1, -1,
								false);
					} catch (java.lang.Exception e) {

						log.error("tFileInputDelimited_1 - " + e.getMessage());

						System.err.println(e.getMessage());

					}

					log.info("tFileInputDelimited_1 - Retrieving records from the datasource.");

					while (fid_tFileInputDelimited_1 != null
							&& fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();

						row5 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row5 = new row5Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_1 = 0;

							columnIndexWithD_tFileInputDelimited_1 = 0;

							row5.key = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 1;

							row5.value = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1
										.getException();
							}

						} catch (java.lang.Exception e) {
							whetherReject_tFileInputDelimited_1 = true;

							log.error("tFileInputDelimited_1 - "
									+ e.getMessage());

							System.err.println(e.getMessage());
							row5 = null;

						}

						log.debug("tFileInputDelimited_1 - Retrieving the record "
								+ fid_tFileInputDelimited_1.getRowNumber()
								+ ".");

						/**
						 * [tFileInputDelimited_1 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_1 main ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						tos_count_tFileInputDelimited_1++;

						/**
						 * [tFileInputDelimited_1 main ] stop
						 */

						/**
						 * [tFileInputDelimited_1 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_begin ] stop
						 */
						// Start of branch "row5"
						if (row5 != null) {

							/**
							 * [tContextLoad_1 main ] start
							 */

							currentComponent = "tContextLoad_1";

							// row5
							// row5

							if (execStat) {
								runStat.updateStatOnConnection("row5"
										+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("row5 - "
										+ (row5 == null ? "" : row5
												.toLogString()));
							}

							// ////////////////////////
							String tmp_key_tContextLoad_1 = null;
							String key_tContextLoad_1 = null;
							if (row5.key != null) {
								tmp_key_tContextLoad_1 = row5.key.trim();
								if ((tmp_key_tContextLoad_1.startsWith("#") || tmp_key_tContextLoad_1
										.startsWith("!"))) {
									tmp_key_tContextLoad_1 = null;
								} else {
									row5.key = tmp_key_tContextLoad_1;
								}
							}
							if (row5.key != null) {
								key_tContextLoad_1 = row5.key;
							}
							String value_tContextLoad_1 = null;
							if (row5.value != null) {
								value_tContextLoad_1 = row5.value;
							}

							String currentValue_tContextLoad_1 = value_tContextLoad_1;

							if (tmp_key_tContextLoad_1 != null) {
								try {
									if (key_tContextLoad_1 != null
											&& "host"
													.equals(key_tContextLoad_1)) {
										context.host = value_tContextLoad_1;
									}

									if (key_tContextLoad_1 != null
											&& "port"
													.equals(key_tContextLoad_1)) {
										context.port = value_tContextLoad_1;
									}

									if (key_tContextLoad_1 != null
											&& "database"
													.equals(key_tContextLoad_1)) {
										context.database = value_tContextLoad_1;
									}

									if (key_tContextLoad_1 != null
											&& "username"
													.equals(key_tContextLoad_1)) {
										context.username = value_tContextLoad_1;
									}

									if (key_tContextLoad_1 != null
											&& "password"
													.equals(key_tContextLoad_1)) {
										context.password = value_tContextLoad_1;
									}

									if (context.getProperty(key_tContextLoad_1) != null) {
										assignList_tContextLoad_1
												.add(key_tContextLoad_1);
									} else {
										newPropertyList_tContextLoad_1
												.add(key_tContextLoad_1);
									}
									if (value_tContextLoad_1 == null) {
										context.setProperty(key_tContextLoad_1,
												"");
									} else {
										context.setProperty(key_tContextLoad_1,
												value_tContextLoad_1);
									}
								} catch (java.lang.Exception e) {
									log.error("tContextLoad_1 - Setting a value for the key \""
											+ key_tContextLoad_1
											+ "\" has failed. Error message: "
											+ e.getMessage());
									System.err
											.println("Setting a value for the key \""
													+ key_tContextLoad_1
													+ "\" has failed. Error message: "
													+ e.getMessage());
								}
								nb_line_tContextLoad_1++;
							}
							// ////////////////////////

							tos_count_tContextLoad_1++;

							/**
							 * [tContextLoad_1 main ] stop
							 */

							/**
							 * [tContextLoad_1 process_data_begin ] start
							 */

							currentComponent = "tContextLoad_1";

							/**
							 * [tContextLoad_1 process_data_begin ] stop
							 */

							/**
							 * [tContextLoad_1 process_data_end ] start
							 */

							currentComponent = "tContextLoad_1";

							/**
							 * [tContextLoad_1 process_data_end ] stop
							 */

						} // End of branch "row5"

						/**
						 * [tFileInputDelimited_1 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

						/**
						 * [tFileInputDelimited_1 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_1 end ] start
						 */

						currentComponent = "tFileInputDelimited_1";

					}
				} finally {
					if (!((Object) ("/Users/alik/Downloads/connection.config") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_1 != null) {
							fid_tFileInputDelimited_1.close();
						}
					}
					if (fid_tFileInputDelimited_1 != null) {
						globalMap.put("tFileInputDelimited_1_NB_LINE",
								fid_tFileInputDelimited_1.getRowNumber());

						log.info("tFileInputDelimited_1 - Retrieved records count: "
								+ fid_tFileInputDelimited_1.getRowNumber()
								+ ".");

					}
				}

				if (log.isDebugEnabled())
					log.debug("tFileInputDelimited_1 - " + ("Done."));

				ok_Hash.put("tFileInputDelimited_1", true);
				end_Hash.put("tFileInputDelimited_1",
						System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_1 end ] stop
				 */

				/**
				 * [tContextLoad_1 end ] start
				 */

				currentComponent = "tContextLoad_1";

				java.util.Enumeration<?> enu_tContextLoad_1 = context
						.propertyNames();
				while (enu_tContextLoad_1.hasMoreElements()) {
					String key_tContextLoad_1 = (String) enu_tContextLoad_1
							.nextElement();
					if (!assignList_tContextLoad_1.contains(key_tContextLoad_1)
							&& !newPropertyList_tContextLoad_1
									.contains(key_tContextLoad_1)) {
						noAssignList_tContextLoad_1.add(key_tContextLoad_1);
					}
				}

				String newPropertyStr_tContextLoad_1 = newPropertyList_tContextLoad_1
						.toString();
				String newProperty_tContextLoad_1 = newPropertyStr_tContextLoad_1
						.substring(1,
								newPropertyStr_tContextLoad_1.length() - 1);

				String noAssignStr_tContextLoad_1 = noAssignList_tContextLoad_1
						.toString();
				String noAssign_tContextLoad_1 = noAssignStr_tContextLoad_1
						.substring(1, noAssignStr_tContextLoad_1.length() - 1);

				globalMap.put("tContextLoad_1_KEY_NOT_INCONTEXT",
						newProperty_tContextLoad_1);
				globalMap.put("tContextLoad_1_KEY_NOT_LOADED",
						noAssign_tContextLoad_1);

				globalMap.put("tContextLoad_1_NB_LINE", nb_line_tContextLoad_1);

				List<String> parametersToEncrypt_tContextLoad_1 = new java.util.ArrayList<String>();

				resumeUtil.addLog("NODE", "NODE:tContextLoad_1", "", Thread
						.currentThread().getId() + "", "", "", "", "",
						resumeUtil.convertToJsonText(context,
								parametersToEncrypt_tContextLoad_1));
				log.info("tContextLoad_1 - Loaded contexts count: "
						+ nb_line_tContextLoad_1 + ".");

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row5" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tContextLoad_1 - " + ("Done."));

				ok_Hash.put("tContextLoad_1", true);
				end_Hash.put("tContextLoad_1", System.currentTimeMillis());

				/**
				 * [tContextLoad_1 end ] stop
				 */

			}// end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil
						.addLog("CHECKPOINT",
								"CONNECTION:SUBJOB_OK:tFileInputDelimited_1:OnSubjobOk",
								"", Thread.currentThread().getId() + "", "",
								"", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
			}

			tDBInput_1Process(globalMap);

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				/**
				 * [tFileInputDelimited_1 finally ] stop
				 */

				/**
				 * [tContextLoad_1 finally ] start
				 */

				currentComponent = "tContextLoad_1";

				/**
				 * [tContextLoad_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements
			routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public Integer count_id;

		public Integer getCount_id() {
			return this.count_id;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

				try {

					int length = 0;

					this.count_id = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.count_id, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("count_id=" + String.valueOf(count_id));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (count_id == null) {
				sb.append("<null>");
			} else {
				sb.append(count_id);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class row3Struct implements
			routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public Integer count_id;

		public Integer getCount_id() {
			return this.count_id;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

				try {

					int length = 0;

					this.count_id = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.count_id, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("count_id=" + String.valueOf(count_id));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (count_id == null) {
				sb.append("<null>");
			} else {
				sb.append(count_id);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class OnRowsEndStructtAggregateRow_1 implements
			routines.system.IPersistableRow<OnRowsEndStructtAggregateRow_1> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public Integer count_id;

		public Integer getCount_id() {
			return this.count_id;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
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

		private void writeInteger(Integer intNum, ObjectOutputStream dos)
				throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

				try {

					int length = 0;

					this.count_id = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.count_id, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("count_id=" + String.valueOf(count_id));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (count_id == null) {
				sb.append("<null>");
			} else {
				sb.append(count_id);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(OnRowsEndStructtAggregateRow_1 other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class jhStruct implements
			routines.system.IPersistableRow<jhStruct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id;

		public int getId() {
			return this.id;
		}

		public String name;

		public String getName() {
			return this.name;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final jhStruct other = (jhStruct) obj;

			if (this.id != other.id)
				return false;

			return true;
		}

		public void copyDataTo(jhStruct other) {

			other.id = this.id;
			other.name = this.name;

		}

		public void copyKeysDataTo(jhStruct other) {

			other.id = this.id;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",name=" + name);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(id);

			sb.append("|");

			if (name == null) {
				sb.append("<null>");
			} else {
				sb.append(name);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(jhStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id, other.id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class row1Struct implements
			routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];

		public int id;

		public int getId() {
			return this.id;
		}

		public String name;

		public String getName() {
			return this.name;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",name=" + name);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(id);

			sb.append("|");

			if (name == null) {
				sb.append("<null>");
			} else {
				sb.append(name);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public static class after_tDBInput_1Struct implements
			routines.system.IPersistableRow<after_tDBInput_1Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id;

		public int getId() {
			return this.id;
		}

		public String name;

		public String getName() {
			return this.name;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final after_tDBInput_1Struct other = (after_tDBInput_1Struct) obj;

			if (this.id != other.id)
				return false;

			return true;
		}

		public void copyDataTo(after_tDBInput_1Struct other) {

			other.id = this.id;
			other.name = this.name;

		}

		public void copyKeysDataTo(after_tDBInput_1Struct other) {

			other.id = this.id;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_account_conversion_job.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_account_conversion_job.length == 0) {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_account_conversion_job,
						0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

				try {

					int length = 0;

					this.id = dis.readInt();

					this.name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.id);

				// String

				writeString(this.name, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",name=" + name);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(id);

			sb.append("|");

			if (name == null) {
				sb.append("<null>");
			} else {
				sb.append(name);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id, other.id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;
		String currentVirtualComponent = null;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception()
						.getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_3Process(globalMap);

				row1Struct row1 = new row1Struct();
				jhStruct jh = new jhStruct();
				row3Struct row3 = new row3Struct();
				row4Struct row4 = new row4Struct();

				/**
				 * [tAggregateRow_1_AGGOUT begin ] start
				 */

				ok_Hash.put("tAggregateRow_1_AGGOUT", false);
				start_Hash.put("tAggregateRow_1_AGGOUT",
						System.currentTimeMillis());

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGOUT";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("jh" + iterateId, 0, 0);

					}
				}

				int tos_count_tAggregateRow_1_AGGOUT = 0;

				if (log.isDebugEnabled())
					log.debug("tAggregateRow_1_AGGOUT - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tAggregateRow_1_AGGOUT {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tAggregateRow_1_AGGOUT = new StringBuilder();
							log4jParamters_tAggregateRow_1_AGGOUT
									.append("Parameters:");
							log4jParamters_tAggregateRow_1_AGGOUT
									.append("DESTINATION" + " = "
											+ "tAggregateRow_1");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT
									.append("GROUPBYS" + " = " + "[]");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT
									.append("OPERATIONS" + " = "
											+ "[{OUTPUT_COLUMN=" + ("count_id")
											+ ", INPUT_COLUMN=" + ("id")
											+ ", IGNORE_NULL=" + ("true")
											+ ", FUNCTION=" + ("count") + "}]");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT
									.append("LIST_DELIMITER" + " = " + "\",\"");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT
									.append("USE_FINANCIAL_PRECISION" + " = "
											+ "true");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT
									.append("CHECK_TYPE_OVERFLOW" + " = "
											+ "false");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							log4jParamters_tAggregateRow_1_AGGOUT
									.append("CHECK_ULP" + " = " + "false");
							log4jParamters_tAggregateRow_1_AGGOUT.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tAggregateRow_1_AGGOUT - "
										+ (log4jParamters_tAggregateRow_1_AGGOUT));
						}
					}
					new BytesLimit65535_tAggregateRow_1_AGGOUT()
							.limitLog4jByte();
				}

				// ------------ Seems it is not used

				java.util.Map hashAggreg_tAggregateRow_1 = new java.util.HashMap();

				// ------------

				class UtilClass_tAggregateRow_1 { // G_OutBegin_AggR_144

					public double sd(Double[] data) {
						final int n = data.length;
						if (n < 2) {
							return Double.NaN;
						}
						double d1 = 0d;
						double d2 = 0d;

						for (int i = 0; i < data.length; i++) {
							d1 += (data[i] * data[i]);
							d2 += data[i];
						}

						return Math.sqrt((n * d1 - d2 * d2) / n / (n - 1));
					}

					public void checkedIADD(byte a, byte b,
							boolean checkTypeOverFlow, boolean checkUlp) {
						byte r = (byte) (a + b);
						if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
							throw new RuntimeException(buildOverflowMessage(
									String.valueOf(a), String.valueOf(b),
									"'short/Short'", "'byte/Byte'"));
						}
					}

					public void checkedIADD(short a, short b,
							boolean checkTypeOverFlow, boolean checkUlp) {
						short r = (short) (a + b);
						if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
							throw new RuntimeException(buildOverflowMessage(
									String.valueOf(a), String.valueOf(b),
									"'int/Integer'", "'short/Short'"));
						}
					}

					public void checkedIADD(int a, int b,
							boolean checkTypeOverFlow, boolean checkUlp) {
						int r = a + b;
						if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
							throw new RuntimeException(buildOverflowMessage(
									String.valueOf(a), String.valueOf(b),
									"'long/Long'", "'int/Integer'"));
						}
					}

					public void checkedIADD(long a, long b,
							boolean checkTypeOverFlow, boolean checkUlp) {
						long r = a + b;
						if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
							throw new RuntimeException(buildOverflowMessage(
									String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'long/Long'"));
						}
					}

					public void checkedIADD(float a, float b,
							boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkUlp) {
							float minAddedValue = Math.ulp(a);
							if (minAddedValue > Math.abs(b)) {
								throw new RuntimeException(
										buildPrecisionMessage(
												String.valueOf(a),
												String.valueOf(b),
												"'double' or 'BigDecimal'",
												"'float/Float'"));
							}
						}

						if (checkTypeOverFlow
								&& ((double) a + (double) b > (double) Float.MAX_VALUE)
								|| ((double) a + (double) b < (double) -Float.MAX_VALUE)) {
							throw new RuntimeException(
									buildOverflowMessage(String.valueOf(a),
											String.valueOf(b),
											"'double' or 'BigDecimal'",
											"'float/Float'"));
						}
					}

					public void checkedIADD(double a, double b,
							boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkUlp) {
							double minAddedValue = Math.ulp(a);
							if (minAddedValue > Math.abs(b)) {
								throw new RuntimeException(
										buildPrecisionMessage(
												String.valueOf(a),
												String.valueOf(a),
												"'BigDecimal'",
												"'double/Double'"));
							}
						}

						if (checkTypeOverFlow
								&& (a + b > (double) Double.MAX_VALUE)
								|| (a + b < -Double.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(
									String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'double/Double'"));
						}
					}

					public void checkedIADD(double a, byte b,
							boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkTypeOverFlow
								&& (a + b > (double) Double.MAX_VALUE)
								|| (a + b < -Double.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(
									String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'double/Double'"));
						}
					}

					public void checkedIADD(double a, short b,
							boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkTypeOverFlow
								&& (a + b > (double) Double.MAX_VALUE)
								|| (a + b < -Double.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(
									String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'double/Double'"));
						}
					}

					public void checkedIADD(double a, int b,
							boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkTypeOverFlow
								&& (a + b > (double) Double.MAX_VALUE)
								|| (a + b < -Double.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(
									String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'double/Double'"));
						}
					}

					public void checkedIADD(double a, float b,
							boolean checkTypeOverFlow, boolean checkUlp) {

						if (checkUlp) {
							double minAddedValue = Math.ulp(a);
							if (minAddedValue > Math.abs(b)) {
								throw new RuntimeException(
										buildPrecisionMessage(
												String.valueOf(a),
												String.valueOf(a),
												"'BigDecimal'",
												"'double/Double'"));
							}
						}

						if (checkTypeOverFlow
								&& (a + b > (double) Double.MAX_VALUE)
								|| (a + b < -Double.MAX_VALUE)) {
							throw new RuntimeException(buildOverflowMessage(
									String.valueOf(a), String.valueOf(b),
									"'BigDecimal'", "'double/Double'"));
						}
					}

					private String buildOverflowMessage(String a, String b,
							String advicedTypes, String originalType) {
						return "Type overflow when adding "
								+ b
								+ " to "
								+ a
								+ ", to resolve this problem, increase the precision by using "
								+ advicedTypes + " type in place of "
								+ originalType + ".";
					}

					private String buildPrecisionMessage(String a, String b,
							String advicedTypes, String originalType) {
						return "The double precision is unsufficient to add the value "
								+ b
								+ " to "
								+ a
								+ ", to resolve this problem, increase the precision by using "
								+ advicedTypes
								+ " type in place of "
								+ originalType + ".";
					}

				} // G_OutBegin_AggR_144

				UtilClass_tAggregateRow_1 utilClass_tAggregateRow_1 = new UtilClass_tAggregateRow_1();

				class AggOperationStruct_tAggregateRow_1 { // G_OutBegin_AggR_100

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;
					int count = 0;
					int count_id_clmCount = 0;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final AggOperationStruct_tAggregateRow_1 other = (AggOperationStruct_tAggregateRow_1) obj;

						return true;
					}

				} // G_OutBegin_AggR_100

				AggOperationStruct_tAggregateRow_1 operation_result_tAggregateRow_1 = null;
				AggOperationStruct_tAggregateRow_1 operation_finder_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();
				java.util.Map<AggOperationStruct_tAggregateRow_1, AggOperationStruct_tAggregateRow_1> hash_tAggregateRow_1 = new java.util.HashMap<AggOperationStruct_tAggregateRow_1, AggOperationStruct_tAggregateRow_1>();

				/**
				 * [tAggregateRow_1_AGGOUT begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row1" + iterateId, 0, 0);

					}
				}

				int tos_count_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_1 = new StringBuilder();
							log4jParamters_tMap_1.append("Parameters:");
							log4jParamters_tMap_1.append("LINK_STYLE" + " = "
									+ "AUTO");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1
									.append("TEMPORARY_DATA_DIRECTORY" + " = "
											+ "");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE"
									+ " = " + "2000000");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1
									.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL"
											+ " = " + "true");
							log4jParamters_tMap_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_1 - " + (log4jParamters_tMap_1));
						}
					}
					new BytesLimit65535_tMap_1().limitLog4jByte();
				}

				// ###############################
				// # Lookup's keys initialization
				int count_row1_tMap_1 = 0;

				int count_row2_tMap_1 = 0;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) globalMap
						.get("tHash_Lookup_row2"));

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();
				// ###############################

				// ###############################
				// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
				// ###############################

				// ###############################
				// # Outputs initialization
				int count_jh_tMap_1 = 0;

				jhStruct jh_tmp = new jhStruct();
				// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
							log4jParamters_tDBInput_1.append("Parameters:");
							log4jParamters_tDBInput_1
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DB_VERSION"
									+ " = " + "V9_X");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("HOST" + " = "
									+ "context.host");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PORT" + " = "
									+ "context.port");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DBNAME" + " = "
									+ "context.database");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("SCHEMA_DB"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USER" + " = "
									+ "context.username");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("PASS"
											+ " = "
											+ String.valueOf(
													routines.system.PasswordEncryptUtil
															.encryptPassword(context.password))
													.substring(0, 4) + "...");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERY" + " = "
									+ "\"select id, name from users\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("SPECIFY_DATASOURCE_ALIAS" + " = "
											+ "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USE_CURSOR"
									+ " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN"
									+ " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_COLUMN"
									+ " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("id") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("name")
									+ "}]");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tPostgresqlInput");
							log4jParamters_tDBInput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_1 - "
										+ (log4jParamters_tDBInput_1));
						}
					}
					new BytesLimit65535_tDBInput_1().limitLog4jByte();
				}

				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "org.postgresql.Driver";
				java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = context.username;

				final String decryptedPassword_tDBInput_1 = context.password;

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String url_tDBInput_1 = "jdbc:postgresql://" + context.host
						+ ":" + context.port + "/" + context.database;

				log.debug("tDBInput_1 - Driver ClassName: "
						+ driverClass_tDBInput_1 + ".");

				log.debug("tDBInput_1 - Connection attempt to '"
						+ url_tDBInput_1 + "' with the username '"
						+ dbUser_tDBInput_1 + "'.");

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(
						url_tDBInput_1, dbUser_tDBInput_1, dbPwd_tDBInput_1);
				log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1
						+ "' has succeeded.");

				log.debug("tDBInput_1 - Connection is set auto commit to 'false'.");

				conn_tDBInput_1.setAutoCommit(false);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1
						.createStatement();

				String dbquery_tDBInput_1 = "select id, name from users";

				log.debug("tDBInput_1 - Executing the query: '"
						+ dbquery_tDBInput_1 + "'.");

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1
							.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1
							.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1
							.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					log.debug("tDBInput_1 - Retrieving records from the database.");

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row1.id = 0;
						} else {

							if (rs_tDBInput_1.getObject(1) != null) {
								row1.id = rs_tDBInput_1.getInt(1);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.name = null;
						} else {

							row1.name = routines.system.JDBCUtil.getString(
									rs_tDBInput_1, 2, false);
						}

						log.debug("tDBInput_1 - Retrieving the record "
								+ nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						// row1
						// row1

						if (execStat) {
							runStat.updateStatOnConnection("row1" + iterateId,
									1, 1);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - "
									+ (row1 == null ? "" : row1.toLogString()));
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						// /////////////////////////////////////////////
						// Starting Lookup Table "row2"
						// /////////////////////////////////////////////

						boolean forceLooprow2 = false;

						row2Struct row2ObjectFromLookup = null;

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							Object exprKeyValue_row2__id = row1.id;
							if (exprKeyValue_row2__id == null) {
								hasCasePrimitiveKeyWithNull_tMap_1 = true;
							} else {
								row2HashKey.id = (int) (Integer) exprKeyValue_row2__id;
							}

							row2HashKey.hashCodeDirty = true;

							if (!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091

								tHash_Lookup_row2.lookup(row2HashKey);

							} // G_TM_M_091

						} // G_TM_M_020

						if (tHash_Lookup_row2 != null
								&& tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G
																					// 071

							// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.id = '"
							// + row2HashKey.id + "'");
						} // G 071

						row2Struct row2 = null;

						row2Struct fromLookup_row2 = null;
						row2 = row2Default;

						if (tHash_Lookup_row2 != null
								&& tHash_Lookup_row2.hasNext()) { // G 099

							fromLookup_row2 = tHash_Lookup_row2.next();

						} // G 099

						if (fromLookup_row2 != null) {
							row2 = fromLookup_row2;
						}

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							jh = null;

							// # Output table : 'jh'
							count_jh_tMap_1++;

							jh_tmp.id = row1.id;
							jh_tmp.name = row2.description;
							jh = jh_tmp;
							log.debug("tMap_1 - Outputting the record "
									+ count_jh_tMap_1
									+ " of the output table 'jh'.");

							// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
						// Start of branch "jh"
						if (jh != null) {

							/**
							 * [tAggregateRow_1_AGGOUT main ] start
							 */

							currentVirtualComponent = "tAggregateRow_1";

							currentComponent = "tAggregateRow_1_AGGOUT";

							// jh
							// jh

							if (execStat) {
								runStat.updateStatOnConnection(
										"jh" + iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("jh - "
										+ (jh == null ? "" : jh.toLogString()));
							}

							operation_finder_tAggregateRow_1.hashCodeDirty = true;

							operation_result_tAggregateRow_1 = hash_tAggregateRow_1
									.get(operation_finder_tAggregateRow_1);

							if (operation_result_tAggregateRow_1 == null) { // G_OutMain_AggR_001

								operation_result_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();

								hash_tAggregateRow_1.put(
										operation_result_tAggregateRow_1,
										operation_result_tAggregateRow_1);

							} // G_OutMain_AggR_001

							operation_result_tAggregateRow_1.count_id_clmCount++;
							operation_result_tAggregateRow_1.count++;

							tos_count_tAggregateRow_1_AGGOUT++;

							/**
							 * [tAggregateRow_1_AGGOUT main ] stop
							 */

							/**
							 * [tAggregateRow_1_AGGOUT process_data_begin ]
							 * start
							 */

							currentVirtualComponent = "tAggregateRow_1";

							currentComponent = "tAggregateRow_1_AGGOUT";

							/**
							 * [tAggregateRow_1_AGGOUT process_data_begin ] stop
							 */

							/**
							 * [tAggregateRow_1_AGGOUT process_data_end ] start
							 */

							currentVirtualComponent = "tAggregateRow_1";

							currentComponent = "tAggregateRow_1_AGGOUT";

							/**
							 * [tAggregateRow_1_AGGOUT process_data_end ] stop
							 */

						} // End of branch "jh"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						log.debug("tDBInput_1 - Connection starting to commit.");

						conn_tDBInput_1.commit();

						log.debug("tDBInput_1 - Connection commit has succeeded.");

						log.debug("tDBInput_1 - Closing the connection to the database.");

						conn_tDBInput_1.close();

						log.debug("tDBInput_1 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);
				log.debug("tDBInput_1 - Retrieved records count: "
						+ nb_line_tDBInput_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Done."));

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

				// ###############################
				// # Lookup hashes releasing
				if (tHash_Lookup_row2 != null) {
					tHash_Lookup_row2.endGet();
				}
				globalMap.remove("tHash_Lookup_row2");

				// ###############################
				log.debug("tMap_1 - Written records count in the table 'jh': "
						+ count_jh_tMap_1 + ".");

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row1" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Done."));

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGOUT end ] start
				 */

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGOUT";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("jh" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tAggregateRow_1_AGGOUT - " + ("Done."));

				ok_Hash.put("tAggregateRow_1_AGGOUT", true);
				end_Hash.put("tAggregateRow_1_AGGOUT",
						System.currentTimeMillis());

				/**
				 * [tAggregateRow_1_AGGOUT end ] stop
				 */

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row4" + iterateId, 0, 0);

					}
				}

				int tos_count_tLogRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
							log4jParamters_tLogRow_1.append("Parameters:");
							log4jParamters_tLogRow_1.append("BASIC_MODE"
									+ " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("TABLE_PRINT"
									+ " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("VERTICAL" + " = "
									+ "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("FIELDSEPARATOR"
									+ " = " + "\"|\"");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_HEADER"
									+ " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_UNIQUE_NAME"
									+ " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_COLNAMES"
									+ " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("USE_FIXED_LENGTH"
									+ " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1
									.append("PRINT_CONTENT_WITH_LOG4J" + " = "
											+ "true");
							log4jParamters_tLogRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_1 - "
										+ (log4jParamters_tLogRow_1));
						}
					}
					new BytesLimit65535_tLogRow_1().limitLog4jByte();
				}

				// /////////////////////

				final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
				java.io.PrintStream consoleOut_tLogRow_1 = null;

				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
				// /////////////////////

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row3" + iterateId, 0, 0);

					}
				}

				int tos_count_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
							log4jParamters_tDBOutput_1.append("Parameters:");
							log4jParamters_tDBOutput_1
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DB_VERSION"
									+ " = " + "V9_X");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("HOST" + " = "
									+ "context.host");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PORT" + " = "
									+ "context.port");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DBNAME" + " = "
									+ "context.database");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("SCHEMA_DB"
									+ " = " + "\"\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USER" + " = "
									+ "context.username");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("PASS"
											+ " = "
											+ String.valueOf(
													routines.system.PasswordEncryptUtil
															.encryptPassword(context.password))
													.substring(0, 4) + "...");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE" + " = "
									+ "\"result\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE_ACTION"
									+ " = " + "NONE");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DATA_ACTION"
									+ " = " + "INSERT");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("SPECIFY_DATASOURCE_ALIAS" + " = "
											+ "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DIE_ON_ERROR"
									+ " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("COMMIT_EVERY"
									+ " = " + "10000");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ADD_COLS"
									+ " = " + "[]");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("USE_FIELD_OPTIONS" + " = "
											+ "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("ENABLE_DEBUG_MODE" + " = "
											+ "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("SUPPORT_NULL_WHERE" + " = "
											+ "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_BATCH_SIZE"
									+ " = " + "true");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("BATCH_SIZE"
									+ " = " + "10000");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tPostgresqlOutput");
							log4jParamters_tDBOutput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - "
										+ (log4jParamters_tDBOutput_1));
						}
					}
					new BytesLimit65535_tDBOutput_1().limitLog4jByte();
				}

				String dbschema_tDBOutput_1 = null;
				dbschema_tDBOutput_1 = "";

				String tableName_tDBOutput_1 = null;
				if (dbschema_tDBOutput_1 == null
						|| dbschema_tDBOutput_1.trim().length() == 0) {
					tableName_tDBOutput_1 = "result";
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\""
							+ "result";
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				boolean whetherReject_tDBOutput_1 = false;

				java.sql.Connection conn_tDBOutput_1 = null;
				String dbUser_tDBOutput_1 = null;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Driver ClassName: ")
							+ ("org.postgresql.Driver") + ("."));
				java.lang.Class.forName("org.postgresql.Driver");
				String url_tDBOutput_1 = "jdbc:postgresql://" + context.host
						+ ":" + context.port + "/" + context.database;
				dbUser_tDBOutput_1 = context.username;

				final String decryptedPassword_tDBOutput_1 = context.password;

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection attempts to '")
							+ (url_tDBOutput_1) + ("' with the username '")
							+ (dbUser_tDBOutput_1) + ("'."));
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(
						url_tDBOutput_1, dbUser_tDBOutput_1, dbPwd_tDBOutput_1);
				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to '")
							+ (url_tDBOutput_1) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;
				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - "
							+ ("Connection is set auto commit to '")
							+ (conn_tDBOutput_1.getAutoCommit()) + ("'."));

				int batchSize_tDBOutput_1 = 10000;
				int batchSizeCounter_tDBOutput_1 = 0;

				int count_tDBOutput_1 = 0;
				String insert_tDBOutput_1 = "INSERT INTO \""
						+ tableName_tDBOutput_1
						+ "\" (\"count_id\") VALUES (?)";

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1
						.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGIN begin ] start
				 */

				ok_Hash.put("tAggregateRow_1_AGGIN", false);
				start_Hash.put("tAggregateRow_1_AGGIN",
						System.currentTimeMillis());

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGIN";

				int tos_count_tAggregateRow_1_AGGIN = 0;

				if (log.isDebugEnabled())
					log.debug("tAggregateRow_1_AGGIN - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tAggregateRow_1_AGGIN {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tAggregateRow_1_AGGIN = new StringBuilder();
							log4jParamters_tAggregateRow_1_AGGIN
									.append("Parameters:");
							log4jParamters_tAggregateRow_1_AGGIN
									.append("ORIGIN" + " = "
											+ "tAggregateRow_1");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN
									.append("GROUPBYS" + " = " + "[]");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN
									.append("OPERATIONS" + " = "
											+ "[{OUTPUT_COLUMN=" + ("count_id")
											+ ", INPUT_COLUMN=" + ("id")
											+ ", IGNORE_NULL=" + ("true")
											+ ", FUNCTION=" + ("count") + "}]");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN
									.append("LIST_DELIMITER" + " = " + "\",\"");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN
									.append("USE_FINANCIAL_PRECISION" + " = "
											+ "true");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN
									.append("CHECK_TYPE_OVERFLOW" + " = "
											+ "false");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							log4jParamters_tAggregateRow_1_AGGIN
									.append("CHECK_ULP" + " = " + "false");
							log4jParamters_tAggregateRow_1_AGGIN.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tAggregateRow_1_AGGIN - "
										+ (log4jParamters_tAggregateRow_1_AGGIN));
						}
					}
					new BytesLimit65535_tAggregateRow_1_AGGIN()
							.limitLog4jByte();
				}

				java.util.Collection<AggOperationStruct_tAggregateRow_1> values_tAggregateRow_1 = hash_tAggregateRow_1
						.values();

				globalMap.put("tAggregateRow_1_NB_LINE",
						values_tAggregateRow_1.size());

				if (log.isInfoEnabled())
					log.info("tAggregateRow_1_AGGIN - "
							+ ("Retrieving the aggregation results."));
				for (AggOperationStruct_tAggregateRow_1 aggregated_row_tAggregateRow_1 : values_tAggregateRow_1) { // G_AggR_600

					/**
					 * [tAggregateRow_1_AGGIN begin ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN main ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

					row3.count_id = (int) aggregated_row_tAggregateRow_1.count;
					row3.count_id = (int) aggregated_row_tAggregateRow_1.count_id_clmCount;

					if (log.isDebugEnabled())
						log.debug("tAggregateRow_1_AGGIN - "
								+ ("Operation function: 'count' on the column 'id'."));

					tos_count_tAggregateRow_1_AGGIN++;

					/**
					 * [tAggregateRow_1_AGGIN main ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN process_data_begin ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

					/**
					 * [tAggregateRow_1_AGGIN process_data_begin ] stop
					 */

					/**
					 * [tDBOutput_1 main ] start
					 */

					currentComponent = "tDBOutput_1";

					// row3
					// row3

					if (execStat) {
						runStat.updateStatOnConnection("row3" + iterateId, 1, 1);
					}

					if (log.isTraceEnabled()) {
						log.trace("row3 - "
								+ (row3 == null ? "" : row3.toLogString()));
					}

					row4 = null;
					whetherReject_tDBOutput_1 = false;
					if (row3.count_id == null) {
						pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
					} else {
						pstmt_tDBOutput_1.setInt(1, row3.count_id);
					}

					pstmt_tDBOutput_1.addBatch();
					nb_line_tDBOutput_1++;

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Adding the record ")
								+ (nb_line_tDBOutput_1) + (" to the ")
								+ ("INSERT") + (" batch."));
					batchSizeCounter_tDBOutput_1++;

					if (!whetherReject_tDBOutput_1) {
						row4 = new row4Struct();
						row4.count_id = row3.count_id;
					}
					if ((batchSize_tDBOutput_1 > 0)
							&& (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
						try {
							int countSum_tDBOutput_1 = 0;

							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + ("Executing the ")
										+ ("INSERT") + (" batch."));
							for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1
									.executeBatch()) {
								countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
										: countEach_tDBOutput_1);
							}
							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + ("The ")
										+ ("INSERT")
										+ (" batch execution has succeeded."));

							insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

							batchSizeCounter_tDBOutput_1 = 0;
						} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
							java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1
									.getNextException(), sqle_tDBOutput_1 = null;
							String errormessage_tDBOutput_1;
							if (ne_tDBOutput_1 != null) {
								// build new exception to provide the original
								// cause
								sqle_tDBOutput_1 = new java.sql.SQLException(
										e_tDBOutput_1.getMessage()
												+ "\ncaused by: "
												+ ne_tDBOutput_1.getMessage(),
										ne_tDBOutput_1.getSQLState(),
										ne_tDBOutput_1.getErrorCode(),
										ne_tDBOutput_1);
								errormessage_tDBOutput_1 = sqle_tDBOutput_1
										.getMessage();
							} else {
								errormessage_tDBOutput_1 = e_tDBOutput_1
										.getMessage();
							}

							int countSum_tDBOutput_1 = 0;
							for (int countEach_tDBOutput_1 : e_tDBOutput_1
									.getUpdateCounts()) {
								countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
										: countEach_tDBOutput_1);
							}

							insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

							log.error("tDBOutput_1 - "
									+ (errormessage_tDBOutput_1));
							System.err.println(errormessage_tDBOutput_1);

						}
					}

					commitCounter_tDBOutput_1++;
					if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
						if ((batchSize_tDBOutput_1 > 0)
								&& (batchSizeCounter_tDBOutput_1 > 0)) {
							try {
								int countSum_tDBOutput_1 = 0;

								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - "
											+ ("Executing the ") + ("INSERT")
											+ (" batch."));
								for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1
										.executeBatch()) {
									countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
											: countEach_tDBOutput_1);
								}
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - "
											+ ("The ")
											+ ("INSERT")
											+ (" batch execution has succeeded."));

								insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

								batchSizeCounter_tDBOutput_1 = 0;
							} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
								java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1
										.getNextException(), sqle_tDBOutput_1 = null;
								String errormessage_tDBOutput_1;
								if (ne_tDBOutput_1 != null) {
									// build new exception to provide the
									// original cause
									sqle_tDBOutput_1 = new java.sql.SQLException(
											e_tDBOutput_1.getMessage()
													+ "\ncaused by: "
													+ ne_tDBOutput_1
															.getMessage(),
											ne_tDBOutput_1.getSQLState(),
											ne_tDBOutput_1.getErrorCode(),
											ne_tDBOutput_1);
									errormessage_tDBOutput_1 = sqle_tDBOutput_1
											.getMessage();
								} else {
									errormessage_tDBOutput_1 = e_tDBOutput_1
											.getMessage();
								}

								int countSum_tDBOutput_1 = 0;
								for (int countEach_tDBOutput_1 : e_tDBOutput_1
										.getUpdateCounts()) {
									countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
											: countEach_tDBOutput_1);
								}

								insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

								log.error("tDBOutput_1 - "
										+ (errormessage_tDBOutput_1));
								System.err.println(errormessage_tDBOutput_1);

							}
						}
						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - "
									+ ("Connection starting to commit ")
									+ (commitCounter_tDBOutput_1)
									+ (" record(s)."));
						conn_tDBOutput_1.commit();

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - "
									+ ("Connection commit has succeeded."));
						commitCounter_tDBOutput_1 = 0;
					}

					tos_count_tDBOutput_1++;

					/**
					 * [tDBOutput_1 main ] stop
					 */

					/**
					 * [tDBOutput_1 process_data_begin ] start
					 */

					currentComponent = "tDBOutput_1";

					/**
					 * [tDBOutput_1 process_data_begin ] stop
					 */
					// Start of branch "row4"
					if (row4 != null) {

						/**
						 * [tLogRow_1 main ] start
						 */

						currentComponent = "tLogRow_1";

						// row4
						// row4

						if (execStat) {
							runStat.updateStatOnConnection("row4" + iterateId,
									1, 1);
						}

						if (log.isTraceEnabled()) {
							log.trace("row4 - "
									+ (row4 == null ? "" : row4.toLogString()));
						}

						// /////////////////////

						strBuffer_tLogRow_1 = new StringBuilder();

						if (row4.count_id != null) { //

							strBuffer_tLogRow_1.append(String
									.valueOf(row4.count_id));

						} //

						if (globalMap.get("tLogRow_CONSOLE") != null) {
							consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap
									.get("tLogRow_CONSOLE");
						} else {
							consoleOut_tLogRow_1 = new java.io.PrintStream(
									new java.io.BufferedOutputStream(System.out));
							globalMap.put("tLogRow_CONSOLE",
									consoleOut_tLogRow_1);
						}
						log.info("tLogRow_1 - Content of row "
								+ (nb_line_tLogRow_1 + 1) + ": "
								+ strBuffer_tLogRow_1.toString());
						consoleOut_tLogRow_1.println(strBuffer_tLogRow_1
								.toString());
						consoleOut_tLogRow_1.flush();
						nb_line_tLogRow_1++;
						// ////

						// ////

						// /////////////////////

						tos_count_tLogRow_1++;

						/**
						 * [tLogRow_1 main ] stop
						 */

						/**
						 * [tLogRow_1 process_data_begin ] start
						 */

						currentComponent = "tLogRow_1";

						/**
						 * [tLogRow_1 process_data_begin ] stop
						 */

						/**
						 * [tLogRow_1 process_data_end ] start
						 */

						currentComponent = "tLogRow_1";

						/**
						 * [tLogRow_1 process_data_end ] stop
						 */

					} // End of branch "row4"

					/**
					 * [tDBOutput_1 process_data_end ] start
					 */

					currentComponent = "tDBOutput_1";

					/**
					 * [tDBOutput_1 process_data_end ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN process_data_end ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

					/**
					 * [tAggregateRow_1_AGGIN process_data_end ] stop
					 */

					/**
					 * [tAggregateRow_1_AGGIN end ] start
					 */

					currentVirtualComponent = "tAggregateRow_1";

					currentComponent = "tAggregateRow_1_AGGIN";

				} // G_AggR_600

				if (log.isDebugEnabled())
					log.debug("tAggregateRow_1_AGGIN - " + ("Done."));

				ok_Hash.put("tAggregateRow_1_AGGIN", true);
				end_Hash.put("tAggregateRow_1_AGGIN",
						System.currentTimeMillis());

				/**
				 * [tAggregateRow_1_AGGIN end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					int countSum_tDBOutput_1 = 0;
					if (pstmt_tDBOutput_1 != null
							&& batchSizeCounter_tDBOutput_1 > 0) {

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Executing the ")
									+ ("INSERT") + (" batch."));
						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1
								.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
									: countEach_tDBOutput_1);
						}

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
									+ (" batch execution has succeeded."));
					}

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

				} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
					java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1
							.getNextException(), sqle_tDBOutput_1 = null;
					String errormessage_tDBOutput_1;
					if (ne_tDBOutput_1 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_1 = new java.sql.SQLException(
								e_tDBOutput_1.getMessage() + "\ncaused by: "
										+ ne_tDBOutput_1.getMessage(),
								ne_tDBOutput_1.getSQLState(),
								ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
						errormessage_tDBOutput_1 = sqle_tDBOutput_1
								.getMessage();
					} else {
						errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
					}

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e_tDBOutput_1
							.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
								: countEach_tDBOutput_1);
					}

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					log.error("tDBOutput_1 - " + (errormessage_tDBOutput_1));
					System.err.println(errormessage_tDBOutput_1);

				}

				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");
				}
				resourceMap.put("statementClosed_tDBOutput_1", true);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - "
							+ ("Connection starting to commit ")
							+ (commitCounter_tDBOutput_1) + (" record(s)."));
				conn_tDBOutput_1.commit();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - "
							+ ("Connection commit has succeeded."));

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - "
							+ ("Closing the connection to the database."));
				conn_tDBOutput_1.close();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - "
							+ ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1
						+ deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1
						+ updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1
						+ insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1
						+ rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED",
						nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED",
						nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED",
						nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED",
						nb_line_rejected_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Has ") + ("inserted")
							+ (" ") + (nb_line_inserted_tDBOutput_1)
							+ (" record(s)."));

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row3" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Done."));

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				currentComponent = "tLogRow_1";

				// ////
				// ////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);
				if (log.isInfoEnabled())
					log.info("tLogRow_1 - " + ("Printed row count: ")
							+ (nb_line_tLogRow_1) + ("."));

				// /////////////////////

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row4" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Done."));

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
				 */

			}// end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tAggregateRow_1_AGGIN"
			globalMap.remove("tAggregateRow_1");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row2");

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGOUT finally ] start
				 */

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGOUT";

				/**
				 * [tAggregateRow_1_AGGOUT finally ] stop
				 */

				/**
				 * [tAggregateRow_1_AGGIN finally ] start
				 */

				currentVirtualComponent = "tAggregateRow_1";

				currentComponent = "tAggregateRow_1_AGGIN";

				/**
				 * [tAggregateRow_1_AGGIN finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap
								.get("conn_tDBOutput_1")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - "
											+ ("Closing the connection to the database."));
								ctn_tDBOutput_1.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - "
											+ ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								log.error("tDBOutput_1 - "
										+ (errorMessage_tDBOutput_1));
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements
			routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_account_conversion_job = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_account_conversion_job = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int id;

		public int getId() {
			return this.id;
		}

		public String description;

		public String getDescription() {
			return this.description;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.id;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row2Struct other = (row2Struct) obj;

			if (this.id != other.id)
				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

			other.id = this.id;
			other.description = this.description;

		}

		public void copyKeysDataTo(row2Struct other) {

			other.id = this.id;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos,
				ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SERVERLESS_ETL_account_conversion_job) {

				try {

					int length = 0;

					this.id = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.id);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.description = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.description, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",description=" + description);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(id);

			sb.append("|");

			if (description == null) {
				sb.append("<null>");
			} else {
				sb.append(description);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id, other.id);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
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

	public void tDBInput_3Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception()
						.getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row2Struct row2 = new row2Struct();

				/**
				 * [tAdvancedHash_row2 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row2", false);
				start_Hash
						.put("tAdvancedHash_row2", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row2";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row2" + iterateId, 0, 0);

					}
				}

				int tos_count_tAdvancedHash_row2 = 0;

				// connection name:row2
				// source node:tDBInput_3 - inputs:(after_tDBInput_1)
				// outputs:(row2,row2) | target node:tAdvancedHash_row2 -
				// inputs:(row2) outputs:()
				// linked node: tMap_1 - inputs:(row1,row2) outputs:(jh)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row2Struct> getLookup(matchingModeEnum_row2);

				globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);

				/**
				 * [tAdvancedHash_row2 begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				ok_Hash.put("tDBInput_3", false);
				start_Hash.put("tDBInput_3", System.currentTimeMillis());

				currentComponent = "tDBInput_3";

				int tos_count_tDBInput_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_3 = new StringBuilder();
							log4jParamters_tDBInput_3.append("Parameters:");
							log4jParamters_tDBInput_3
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("DB_VERSION"
									+ " = " + "PRIOR_TO_V9");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("HOST" + " = "
									+ "context.host");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("PORT" + " = "
									+ "context.port");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("DBNAME" + " = "
									+ "context.database");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("SCHEMA_DB"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("USER" + " = "
									+ "context.username");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3
									.append("PASS"
											+ " = "
											+ String.valueOf(
													routines.system.PasswordEncryptUtil
															.encryptPassword(context.password))
													.substring(0, 4) + "...");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("QUERYSTORE"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3
									.append("QUERY"
											+ " = "
											+ "\"select id, description from product\"");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3
									.append("SPECIFY_DATASOURCE_ALIAS" + " = "
											+ "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("USE_CURSOR"
									+ " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TRIM_ALL_COLUMN"
									+ " = " + "false");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3.append("TRIM_COLUMN"
									+ " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("id") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN="
									+ ("description") + "}]");
							log4jParamters_tDBInput_3.append(" | ");
							log4jParamters_tDBInput_3
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tPostgresqlInput");
							log4jParamters_tDBInput_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_3 - "
										+ (log4jParamters_tDBInput_3));
						}
					}
					new BytesLimit65535_tDBInput_3().limitLog4jByte();
				}

				int nb_line_tDBInput_3 = 0;
				java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "org.postgresql.Driver";
				java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = context.username;

				final String decryptedPassword_tDBInput_3 = context.password;

				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;

				String url_tDBInput_3 = "jdbc:postgresql://" + context.host
						+ ":" + context.port + "/" + context.database;

				log.debug("tDBInput_3 - Driver ClassName: "
						+ driverClass_tDBInput_3 + ".");

				log.debug("tDBInput_3 - Connection attempt to '"
						+ url_tDBInput_3 + "' with the username '"
						+ dbUser_tDBInput_3 + "'.");

				conn_tDBInput_3 = java.sql.DriverManager.getConnection(
						url_tDBInput_3, dbUser_tDBInput_3, dbPwd_tDBInput_3);
				log.debug("tDBInput_3 - Connection to '" + url_tDBInput_3
						+ "' has succeeded.");

				log.debug("tDBInput_3 - Connection is set auto commit to 'false'.");

				conn_tDBInput_3.setAutoCommit(false);

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3
						.createStatement();

				String dbquery_tDBInput_3 = "select id, description from product";

				log.debug("tDBInput_3 - Executing the query: '"
						+ dbquery_tDBInput_3 + "'.");

				globalMap.put("tDBInput_3_QUERY", dbquery_tDBInput_3);
				java.sql.ResultSet rs_tDBInput_3 = null;

				try {
					rs_tDBInput_3 = stmt_tDBInput_3
							.executeQuery(dbquery_tDBInput_3);
					java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3
							.getMetaData();
					int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3
							.getColumnCount();

					String tmpContent_tDBInput_3 = null;

					log.debug("tDBInput_3 - Retrieving records from the database.");

					while (rs_tDBInput_3.next()) {
						nb_line_tDBInput_3++;

						if (colQtyInRs_tDBInput_3 < 1) {
							row2.id = 0;
						} else {

							if (rs_tDBInput_3.getObject(1) != null) {
								row2.id = rs_tDBInput_3.getInt(1);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							row2.description = null;
						} else {

							row2.description = routines.system.JDBCUtil
									.getString(rs_tDBInput_3, 2, false);
						}

						log.debug("tDBInput_3 - Retrieving the record "
								+ nb_line_tDBInput_3 + ".");

						/**
						 * [tDBInput_3 begin ] stop
						 */

						/**
						 * [tDBInput_3 main ] start
						 */

						currentComponent = "tDBInput_3";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 main ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						// row2
						// row2

						if (execStat) {
							runStat.updateStatOnConnection("row2" + iterateId,
									1, 1);
						}

						if (log.isTraceEnabled()) {
							log.trace("row2 - "
									+ (row2 == null ? "" : row2.toLogString()));
						}

						row2Struct row2_HashRow = new row2Struct();

						row2_HashRow.id = row2.id;

						row2_HashRow.description = row2.description;

						tHash_Lookup_row2.put(row2_HashRow);

						tos_count_tAdvancedHash_row2++;

						/**
						 * [tAdvancedHash_row2 main ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						currentComponent = "tDBInput_3";

					}
				} finally {
					if (rs_tDBInput_3 != null) {
						rs_tDBInput_3.close();
					}
					if (stmt_tDBInput_3 != null) {
						stmt_tDBInput_3.close();
					}
					if (conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {

						log.debug("tDBInput_3 - Connection starting to commit.");

						conn_tDBInput_3.commit();

						log.debug("tDBInput_3 - Connection commit has succeeded.");

						log.debug("tDBInput_3 - Closing the connection to the database.");

						conn_tDBInput_3.close();

						log.debug("tDBInput_3 - Connection to the database closed.");

					}

				}
				globalMap.put("tDBInput_3_NB_LINE", nb_line_tDBInput_3);
				log.debug("tDBInput_3 - Retrieved records count: "
						+ nb_line_tDBInput_3 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_3 - " + ("Done."));

				ok_Hash.put("tDBInput_3", true);
				end_Hash.put("tDBInput_3", System.currentTimeMillis());

				/**
				 * [tDBInput_3 end ] stop
				 */

				/**
				 * [tAdvancedHash_row2 end ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				tHash_Lookup_row2.endPut();

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row2" + iterateId, 2, 0);
					}
				}

				ok_Hash.put("tAdvancedHash_row2", true);
				end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row2 end ] stop
				 */

			}// end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row2 finally ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				/**
				 * [tAdvancedHash_row2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
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
	public String contextStr = "dev";
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
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	private PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final account_conversion_job account_conversion_jobClass = new account_conversion_job();

		int exitCode = account_conversion_jobClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'account_conversion_job' - Done.");
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

		if (!"".equals(log4jLevel)) {
			if ("trace".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.OFF);
			}
			org.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());
		}
		log.info("TalendJob: 'account_conversion_job' - Start.");

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket
				// can't open
				System.err.println("The statistics socket port " + portStats
						+ " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}

		try {
			// call job/subjob with an existing context, like:
			// --context=production. if without this parameter, there will use
			// the default context instead.
			java.io.InputStream inContext = account_conversion_job.class
					.getClassLoader().getResourceAsStream(
							"serverless_etl/account_conversion_job_0_1/contexts/"
									+ contextStr + ".properties");
			if (inContext == null) {
				inContext = account_conversion_job.class
						.getClassLoader()
						.getResourceAsStream(
								"config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				// defaultProps is in order to keep the original context value
				defaultProps.load(inContext);
				inContext.close();
				context = new ContextProperties(defaultProps);
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param
				// is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param
							.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			context.setContextType("host", "id_String");

			context.host = (String) context.getProperty("host");
			context.setContextType("port", "id_String");

			context.port = (String) context.getProperty("port");
			context.setContextType("database", "id_String");

			context.database = (String) context.getProperty("database");
			context.setContextType("username", "id_String");

			context.username = (String) context.getProperty("username");
			context.setContextType("password", "id_String");

			context.password = (String) context.getProperty("password");
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("host")) {
				context.host = (String) parentContextMap.get("host");
			}
			if (parentContextMap.containsKey("port")) {
				context.port = (String) parentContextMap.get("port");
			}
			if (parentContextMap.containsKey("database")) {
				context.database = (String) parentContextMap.get("database");
			}
			if (parentContextMap.containsKey("username")) {
				context.username = (String) parentContextMap.get("username");
			}
			if (parentContextMap.containsKey("password")) {
				context.password = (String) parentContextMap.get("password");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil
				.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName,
				jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName,
				parent_part_launcher, Thread.currentThread().getId() + "", "",
				"", "", "",
				resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
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

		long startUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFileInputDelimited_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFileInputDelimited_1) {
			globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

			e_tFileInputDelimited_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		if (false) {
			System.out
					.println((endUsedMemory - startUsedMemory)
							+ " bytes memory increase when running : account_conversion_job");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;
		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher,
				Thread.currentThread().getId() + "", "", "" + returnCode, "",
				"", "");

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
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index),
							keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index),
							keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		}

	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" },
			{ "\\'", "\'" }, { "\\r", "\r" }, { "\\f", "\f" }, { "\\b", "\b" },
			{ "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex,
							index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left
			// into the result
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
 * 439397 characters generated by Talend Data Management Platform on the 10
 * January 2019 4:21:23 PM
 ************************************************************************************************/
