package serverless_etl.parentjob_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.WriteTxtFile;
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
 * Job: ParentJob Purpose: <br>
 * Description:  <br>
 * @author ali@versent.com.au
 * @version 7.1.1.20181026_1147
 * @status 
 */
public class ParentJob implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "ParentJob.log");
	}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(ParentJob.class);

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

		}

	}

	private ContextProperties context = new ContextProperties();

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "ParentJob";
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
					ParentJob.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(ParentJob.this, new Object[] { e,
									currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tCreateTemporaryFile_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tCreateTemporaryFile_1_onSubJobError(exception, errorComponent,
				globalMap);
	}

	public void tJava_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tJava_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent,
				globalMap);
	}

	public void tFlowToIterate_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent,
				globalMap);
	}

	public void tRunJob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFileInputDelimited_1_onSubJobError(exception, errorComponent,
				globalMap);
	}

	public void tCreateTemporaryFile_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tJava_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
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

	public void tCreateTemporaryFile_1Process(
			final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tCreateTemporaryFile_1_SUBPROCESS_STATE", 0);

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

				/**
				 * [tCreateTemporaryFile_1 begin ] start
				 */

				ok_Hash.put("tCreateTemporaryFile_1", false);
				start_Hash.put("tCreateTemporaryFile_1",
						System.currentTimeMillis());

				currentComponent = "tCreateTemporaryFile_1";

				int tos_count_tCreateTemporaryFile_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tCreateTemporaryFile_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tCreateTemporaryFile_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tCreateTemporaryFile_1 = new StringBuilder();
							log4jParamters_tCreateTemporaryFile_1
									.append("Parameters:");
							log4jParamters_tCreateTemporaryFile_1
									.append("REMOVE" + " = " + "true");
							log4jParamters_tCreateTemporaryFile_1.append(" | ");
							log4jParamters_tCreateTemporaryFile_1
									.append("USE_DEFAULT_DIR" + " = " + "true");
							log4jParamters_tCreateTemporaryFile_1.append(" | ");
							log4jParamters_tCreateTemporaryFile_1
									.append("TEMPLATE" + " = "
											+ "\"talend_XXXX\"");
							log4jParamters_tCreateTemporaryFile_1.append(" | ");
							log4jParamters_tCreateTemporaryFile_1
									.append("SUFFIX" + " = " + "\"txt\"");
							log4jParamters_tCreateTemporaryFile_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tCreateTemporaryFile_1 - "
										+ (log4jParamters_tCreateTemporaryFile_1));
						}
					}
					new BytesLimit65535_tCreateTemporaryFile_1()
							.limitLog4jByte();
				}

				final StringBuffer log4jSb_tCreateTemporaryFile_1 = new StringBuffer();

				java.io.File dir_tCreateTemporaryFile_1 = new java.io.File(
						java.lang.System.getProperty("java.io.tmpdir"));
				dir_tCreateTemporaryFile_1.mkdirs();
				String name_tCreateTemporaryFile_1 = "talend_XXXX".replaceAll(
						"XXXX", routines.TalendString.getAsciiRandomString(4)
								.toUpperCase());
				String suffix_tCreateTemporaryFile_1 = ("txt".replaceAll("\\.",
						"").length() == 0) ? "tmp" : "txt"
						.replaceAll("\\.", "");
				java.io.File file_tCreateTemporaryFile_1 = new java.io.File(
						dir_tCreateTemporaryFile_1, name_tCreateTemporaryFile_1
								+ "." + suffix_tCreateTemporaryFile_1);
				if (file_tCreateTemporaryFile_1.createNewFile()) {
					file_tCreateTemporaryFile_1.deleteOnExit();
				}
				globalMap.put("tCreateTemporaryFile_1_FILEPATH",
						file_tCreateTemporaryFile_1.getCanonicalPath());

				log.info("tCreateTemporaryFile_1 - tmp file path : "
						+ file_tCreateTemporaryFile_1.getCanonicalPath() + ".");

				/**
				 * [tCreateTemporaryFile_1 begin ] stop
				 */

				/**
				 * [tCreateTemporaryFile_1 main ] start
				 */

				currentComponent = "tCreateTemporaryFile_1";

				tos_count_tCreateTemporaryFile_1++;

				/**
				 * [tCreateTemporaryFile_1 main ] stop
				 */

				/**
				 * [tCreateTemporaryFile_1 process_data_begin ] start
				 */

				currentComponent = "tCreateTemporaryFile_1";

				/**
				 * [tCreateTemporaryFile_1 process_data_begin ] stop
				 */

				/**
				 * [tCreateTemporaryFile_1 process_data_end ] start
				 */

				currentComponent = "tCreateTemporaryFile_1";

				/**
				 * [tCreateTemporaryFile_1 process_data_end ] stop
				 */

				/**
				 * [tCreateTemporaryFile_1 end ] start
				 */

				currentComponent = "tCreateTemporaryFile_1";

				if (log.isDebugEnabled())
					log.debug("tCreateTemporaryFile_1 - " + ("Done."));

				ok_Hash.put("tCreateTemporaryFile_1", true);
				end_Hash.put("tCreateTemporaryFile_1",
						System.currentTimeMillis());

				/**
				 * [tCreateTemporaryFile_1 end ] stop
				 */
			}// end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil
						.addLog("CHECKPOINT",
								"CONNECTION:SUBJOB_OK:tCreateTemporaryFile_1:OnSubjobOk",
								"", Thread.currentThread().getId() + "", "",
								"", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
			}

			tJava_1Process(globalMap);

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
				 * [tCreateTemporaryFile_1 finally ] start
				 */

				currentComponent = "tCreateTemporaryFile_1";

				/**
				 * [tCreateTemporaryFile_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tCreateTemporaryFile_1_SUBPROCESS_STATE", 1);
	}

	public void tJava_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

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

				/**
				 * [tJava_1 begin ] start
				 */

				ok_Hash.put("tJava_1", false);
				start_Hash.put("tJava_1", System.currentTimeMillis());

				currentComponent = "tJava_1";

				int tos_count_tJava_1 = 0;

				WriteTxtFile.writeSampleText((String) globalMap
						.get("tCreateTemporaryFile_1_FILEPATH"));
				System.out.println((String) globalMap
						.get("tCreateTemporaryFile_1_FILEPATH"));

				/**
				 * [tJava_1 begin ] stop
				 */

				/**
				 * [tJava_1 main ] start
				 */

				currentComponent = "tJava_1";

				tos_count_tJava_1++;

				/**
				 * [tJava_1 main ] stop
				 */

				/**
				 * [tJava_1 process_data_begin ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 process_data_begin ] stop
				 */

				/**
				 * [tJava_1 process_data_end ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 process_data_end ] stop
				 */

				/**
				 * [tJava_1 end ] start
				 */

				currentComponent = "tJava_1";

				ok_Hash.put("tJava_1", true);
				end_Hash.put("tJava_1", System.currentTimeMillis());

				/**
				 * [tJava_1 end ] stop
				 */
			}// end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT",
						"CONNECTION:SUBJOB_OK:tJava_1:OnSubjobOk", "", Thread
								.currentThread().getId() + "", "", "", "", "",
						"");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
			}

			tFileInputDelimited_1Process(globalMap);

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
				 * [tJava_1 finally ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}

	public static class row1Struct implements
			routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_ParentJob = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_ParentJob = new byte[0];

		public Integer id;

		public Integer getId() {
			return this.id;
		}

		public String name;

		public String getName() {
			return this.name;
		}

		public Integer scope;

		public Integer getScope() {
			return this.scope;
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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SERVERLESS_ETL_ParentJob.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_ParentJob.length == 0) {
						commonByteArray_SERVERLESS_ETL_ParentJob = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_ParentJob = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SERVERLESS_ETL_ParentJob, 0,
						length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_ParentJob, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_SERVERLESS_ETL_ParentJob) {

				try {

					int length = 0;

					this.id = readInteger(dis);

					this.name = readString(dis);

					this.scope = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.id, dos);

				// String

				writeString(this.name, dos);

				// Integer

				writeInteger(this.scope, dos);

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
			sb.append(",scope=" + String.valueOf(scope));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (id == null) {
				sb.append("<null>");
			} else {
				sb.append(id);
			}

			sb.append("|");

			if (name == null) {
				sb.append("<null>");
			} else {
				sb.append(name);
			}

			sb.append("|");

			if (scope == null) {
				sb.append("<null>");
			} else {
				sb.append(scope);
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

				row1Struct row1 = new row1Struct();

				/**
				 * [tFlowToIterate_1 begin ] start
				 */

				int NB_ITERATE_tRunJob_1 = 0; // for statistics

				ok_Hash.put("tFlowToIterate_1", false);
				start_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

				currentComponent = "tFlowToIterate_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("row1" + iterateId, 0, 0);

					}
				}

				int tos_count_tFlowToIterate_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFlowToIterate_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFlowToIterate_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFlowToIterate_1 = new StringBuilder();
							log4jParamters_tFlowToIterate_1
									.append("Parameters:");
							log4jParamters_tFlowToIterate_1
									.append("DEFAULT_MAP" + " = " + "true");
							log4jParamters_tFlowToIterate_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFlowToIterate_1 - "
										+ (log4jParamters_tFlowToIterate_1));
						}
					}
					new BytesLimit65535_tFlowToIterate_1().limitLog4jByte();
				}

				int nb_line_tFlowToIterate_1 = 0;
				int counter_tFlowToIterate_1 = 0;

				/**
				 * [tFlowToIterate_1 begin ] stop
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
											+ "(String)globalMap.get(\"tCreateTemporaryFile_1_FILEPATH\")");
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
									.append("HEADER" + " = " + "1");
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
											+ ("id") + "}, {TRIM=" + ("false")
											+ ", SCHEMA_COLUMN=" + ("name")
											+ "}, {TRIM=" + ("false")
											+ ", SCHEMA_COLUMN=" + ("scope")
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

					Object filename_tFileInputDelimited_1 = (String) globalMap
							.get("tCreateTemporaryFile_1_FILEPATH");
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
								(String) globalMap
										.get("tCreateTemporaryFile_1_FILEPATH"),
								"ISO-8859-15", ";", "\n", true, 1, 0, -1, -1,
								false);
					} catch (java.lang.Exception e) {

						log.error("tFileInputDelimited_1 - " + e.getMessage());

						System.err.println(e.getMessage());

					}

					log.info("tFileInputDelimited_1 - Retrieving records from the datasource.");

					while (fid_tFileInputDelimited_1 != null
							&& fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();

						row1 = null;

						boolean whetherReject_tFileInputDelimited_1 = false;
						row1 = new row1Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_1 = 0;

							String temp = "";

							columnIndexWithD_tFileInputDelimited_1 = 0;

							temp = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);
							if (temp.length() > 0) {

								try {

									row1.id = ParserUtils.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_1) {
									rowstate_tFileInputDelimited_1
											.setException(new RuntimeException(
													String.format(
															"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"id", "row1", temp,
															ex_tFileInputDelimited_1),
													ex_tFileInputDelimited_1));
								}

							} else {

								row1.id = null;

							}

							columnIndexWithD_tFileInputDelimited_1 = 1;

							row1.name = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);

							columnIndexWithD_tFileInputDelimited_1 = 2;

							temp = fid_tFileInputDelimited_1
									.get(columnIndexWithD_tFileInputDelimited_1);
							if (temp.length() > 0) {

								try {

									row1.scope = ParserUtils
											.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_1) {
									rowstate_tFileInputDelimited_1
											.setException(new RuntimeException(
													String.format(
															"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
															"scope", "row1",
															temp,
															ex_tFileInputDelimited_1),
													ex_tFileInputDelimited_1));
								}

							} else {

								row1.scope = null;

							}

							if (rowstate_tFileInputDelimited_1.getException() != null) {
								throw rowstate_tFileInputDelimited_1
										.getException();
							}

						} catch (java.lang.Exception e) {
							whetherReject_tFileInputDelimited_1 = true;

							log.error("tFileInputDelimited_1 - "
									+ e.getMessage());

							System.err.println(e.getMessage());
							row1 = null;

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
						// Start of branch "row1"
						if (row1 != null) {

							/**
							 * [tFlowToIterate_1 main ] start
							 */

							currentComponent = "tFlowToIterate_1";

							// row1
							// row1

							if (execStat) {
								runStat.updateStatOnConnection("row1"
										+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("row1 - "
										+ (row1 == null ? "" : row1
												.toLogString()));
							}

							if (log.isTraceEnabled())
								log.trace("tFlowToIterate_1 - "
										+ ("Set global var, key=row1.id, value=")
										+ (row1.id) + ("."));
							globalMap.put("row1.id", row1.id);

							if (log.isTraceEnabled())
								log.trace("tFlowToIterate_1 - "
										+ ("Set global var, key=row1.name, value=")
										+ (row1.name) + ("."));
							globalMap.put("row1.name", row1.name);

							if (log.isTraceEnabled())
								log.trace("tFlowToIterate_1 - "
										+ ("Set global var, key=row1.scope, value=")
										+ (row1.scope) + ("."));
							globalMap.put("row1.scope", row1.scope);

							nb_line_tFlowToIterate_1++;
							counter_tFlowToIterate_1++;
							if (log.isDebugEnabled())
								log.debug("tFlowToIterate_1 - "
										+ ("Current iteration is: ")
										+ (counter_tFlowToIterate_1) + ("."));
							globalMap.put("tFlowToIterate_1_CURRENT_ITERATION",
									counter_tFlowToIterate_1);

							tos_count_tFlowToIterate_1++;

							/**
							 * [tFlowToIterate_1 main ] stop
							 */

							/**
							 * [tFlowToIterate_1 process_data_begin ] start
							 */

							currentComponent = "tFlowToIterate_1";

							/**
							 * [tFlowToIterate_1 process_data_begin ] stop
							 */
							NB_ITERATE_tRunJob_1++;

							if (execStat) {
								runStat.updateStatOnConnection("iterate1", 1,
										"exec" + NB_ITERATE_tRunJob_1);
								// Thread.sleep(1000);
							}

							/**
							 * [tRunJob_1 begin ] start
							 */

							ok_Hash.put("tRunJob_1", false);
							start_Hash.put("tRunJob_1",
									System.currentTimeMillis());

							currentComponent = "tRunJob_1";

							int tos_count_tRunJob_1 = 0;

							if (log.isDebugEnabled())
								log.debug("tRunJob_1 - " + ("Start to work."));
							if (log.isDebugEnabled()) {
								class BytesLimit65535_tRunJob_1 {
									public void limitLog4jByte()
											throws Exception {
										StringBuilder log4jParamters_tRunJob_1 = new StringBuilder();
										log4jParamters_tRunJob_1
												.append("Parameters:");
										log4jParamters_tRunJob_1
												.append("USE_DYNAMIC_JOB"
														+ " = " + "false");
										log4jParamters_tRunJob_1.append(" | ");
										log4jParamters_tRunJob_1
												.append("PROCESS" + " = "
														+ "ChildJob");
										log4jParamters_tRunJob_1.append(" | ");
										log4jParamters_tRunJob_1
												.append("USE_INDEPENDENT_PROCESS"
														+ " = " + "false");
										log4jParamters_tRunJob_1.append(" | ");
										log4jParamters_tRunJob_1
												.append("DIE_ON_CHILD_ERROR"
														+ " = " + "true");
										log4jParamters_tRunJob_1.append(" | ");
										log4jParamters_tRunJob_1
												.append("TRANSMIT_WHOLE_CONTEXT"
														+ " = " + "false");
										log4jParamters_tRunJob_1.append(" | ");
										log4jParamters_tRunJob_1
												.append("CONTEXTPARAMS"
														+ " = "
														+ "[{PARAM_NAME_COLUMN="
														+ ("scope")
														+ ", PARAM_VALUE_COLUMN="
														+ ("(Integer)globalMap.get(\"row1.scope\")")
														+ "}, {PARAM_NAME_COLUMN="
														+ ("name")
														+ ", PARAM_VALUE_COLUMN="
														+ ("(String)globalMap.get(\"row1.name\")")
														+ "}]");
										log4jParamters_tRunJob_1.append(" | ");
										log4jParamters_tRunJob_1
												.append("PROPAGATE_CHILD_RESULT"
														+ " = " + "false");
										log4jParamters_tRunJob_1.append(" | ");
										log4jParamters_tRunJob_1
												.append("PRINT_PARAMETER"
														+ " = " + "false");
										log4jParamters_tRunJob_1.append(" | ");
										if (log.isDebugEnabled())
											log.debug("tRunJob_1 - "
													+ (log4jParamters_tRunJob_1));
									}
								}
								new BytesLimit65535_tRunJob_1()
										.limitLog4jByte();
							}

							/**
							 * [tRunJob_1 begin ] stop
							 */

							/**
							 * [tRunJob_1 main ] start
							 */

							currentComponent = "tRunJob_1";

							java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();

							paraList_tRunJob_1.add("--father_pid=" + pid);

							paraList_tRunJob_1.add("--root_pid=" + rootPid);

							paraList_tRunJob_1.add("--father_node=tRunJob_1");

							paraList_tRunJob_1.add("--context=Default");

							if (!"".equals(log4jLevel)) {
								paraList_tRunJob_1.add("--log4jLevel="
										+ log4jLevel);
							}

							// for feature:10589

							paraList_tRunJob_1.add("--stat_port=" + portStats);

							if (resuming_logs_dir_path != null) {
								paraList_tRunJob_1
										.add("--resuming_logs_dir_path="
												+ resuming_logs_dir_path);
							}
							String childResumePath_tRunJob_1 = ResumeUtil
									.getChildJobCheckPointPath(resuming_checkpoint_path);
							String tRunJobName_tRunJob_1 = ResumeUtil
									.getRighttRunJob(resuming_checkpoint_path);
							if ("tRunJob_1".equals(tRunJobName_tRunJob_1)
									&& childResumePath_tRunJob_1 != null) {
								paraList_tRunJob_1
										.add("--resuming_checkpoint_path="
												+ ResumeUtil
														.getChildJobCheckPointPath(resuming_checkpoint_path));
							}
							paraList_tRunJob_1
									.add("--parent_part_launcher=JOB:"
											+ jobName + "/NODE:tRunJob_1");

							java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

							Object obj_tRunJob_1 = null;

							obj_tRunJob_1 = (Integer) globalMap
									.get("row1.scope");
							if (obj_tRunJob_1 != null) {
								paraList_tRunJob_1
										.add("--context_param scope="
												+ RuntimeUtils
														.tRunJobConvertContext(obj_tRunJob_1));
							} else {
								paraList_tRunJob_1
										.add("--context_param scope="
												+ NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
							}

							parentContextMap_tRunJob_1.put("scope",
									obj_tRunJob_1);

							obj_tRunJob_1 = (String) globalMap.get("row1.name");
							if (obj_tRunJob_1 != null) {
								paraList_tRunJob_1
										.add("--context_param name="
												+ RuntimeUtils
														.tRunJobConvertContext(obj_tRunJob_1));
							} else {
								paraList_tRunJob_1
										.add("--context_param name="
												+ NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
							}

							parentContextMap_tRunJob_1.put("name",
									obj_tRunJob_1);

							serverless_etl.childjob_0_1.ChildJob childJob_tRunJob_1 = new serverless_etl.childjob_0_1.ChildJob();
							// pass DataSources
							java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_1 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
									.get(KEY_DB_DATASOURCES);
							if (null != talendDataSources_tRunJob_1) {
								java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_1 = new java.util.HashMap<String, javax.sql.DataSource>();
								for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_1 : talendDataSources_tRunJob_1
										.entrySet()) {
									dataSources_tRunJob_1.put(
											talendDataSourceEntry_tRunJob_1
													.getKey(),
											talendDataSourceEntry_tRunJob_1
													.getValue()
													.getRawDataSource());
								}
								childJob_tRunJob_1
										.setDataSources(dataSources_tRunJob_1);
							}

							childJob_tRunJob_1.parentContextMap = parentContextMap_tRunJob_1;

							log.info("tRunJob_1 - The child job 'serverless_etl.childjob_0_1.ChildJob' starts on the version '0.1' with the context 'Default'.");

							String[][] childReturn_tRunJob_1 = childJob_tRunJob_1
									.runJob((String[]) paraList_tRunJob_1
											.toArray(new String[paraList_tRunJob_1
													.size()]));

							log.info("tRunJob_1 - The child job 'serverless_etl.childjob_0_1.ChildJob' is done.");

							errorCode = childJob_tRunJob_1.getErrorCode();

							if (childJob_tRunJob_1.getErrorCode() == null) {
								globalMap
										.put("tRunJob_1_CHILD_RETURN_CODE",
												childJob_tRunJob_1.getStatus() != null
														&& ("failure")
																.equals(childJob_tRunJob_1
																		.getStatus()) ? 1
														: 0);
							} else {
								globalMap.put("tRunJob_1_CHILD_RETURN_CODE",
										childJob_tRunJob_1.getErrorCode());
							}
							if (childJob_tRunJob_1.getExceptionStackTrace() != null) {
								globalMap.put(
										"tRunJob_1_CHILD_EXCEPTION_STACKTRACE",
										childJob_tRunJob_1
												.getExceptionStackTrace());
							}

							if (childJob_tRunJob_1.getErrorCode() != null
									|| ("failure").equals(childJob_tRunJob_1
											.getStatus())) {
								throw new RuntimeException(
										"Child job running failed.\n"
												+ childJob_tRunJob_1
														.getException()
														.getClass().getName()
												+ ": "
												+ childJob_tRunJob_1
														.getException()
														.getMessage());
							}

							tos_count_tRunJob_1++;

							/**
							 * [tRunJob_1 main ] stop
							 */

							/**
							 * [tRunJob_1 process_data_begin ] start
							 */

							currentComponent = "tRunJob_1";

							/**
							 * [tRunJob_1 process_data_begin ] stop
							 */

							/**
							 * [tRunJob_1 process_data_end ] start
							 */

							currentComponent = "tRunJob_1";

							/**
							 * [tRunJob_1 process_data_end ] stop
							 */

							/**
							 * [tRunJob_1 end ] start
							 */

							currentComponent = "tRunJob_1";

							if (log.isDebugEnabled())
								log.debug("tRunJob_1 - " + ("Done."));

							ok_Hash.put("tRunJob_1", true);
							end_Hash.put("tRunJob_1",
									System.currentTimeMillis());

							/**
							 * [tRunJob_1 end ] stop
							 */
							if (execStat) {
								runStat.updateStatOnConnection("iterate1", 2,
										"exec" + NB_ITERATE_tRunJob_1);
							}

							/**
							 * [tFlowToIterate_1 process_data_end ] start
							 */

							currentComponent = "tFlowToIterate_1";

							/**
							 * [tFlowToIterate_1 process_data_end ] stop
							 */

						} // End of branch "row1"

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
					if (!((Object) ((String) globalMap
							.get("tCreateTemporaryFile_1_FILEPATH")) instanceof java.io.InputStream)) {
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
				 * [tFlowToIterate_1 end ] start
				 */

				currentComponent = "tFlowToIterate_1";

				globalMap.put("tFlowToIterate_1_NB_LINE",
						nb_line_tFlowToIterate_1);
				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("row1" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tFlowToIterate_1 - " + ("Done."));

				ok_Hash.put("tFlowToIterate_1", true);
				end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

				/**
				 * [tFlowToIterate_1 end ] stop
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
				 * [tFileInputDelimited_1 finally ] start
				 */

				currentComponent = "tFileInputDelimited_1";

				/**
				 * [tFileInputDelimited_1 finally ] stop
				 */

				/**
				 * [tFlowToIterate_1 finally ] start
				 */

				currentComponent = "tFlowToIterate_1";

				/**
				 * [tFlowToIterate_1 finally ] stop
				 */

				/**
				 * [tRunJob_1 finally ] start
				 */

				currentComponent = "tRunJob_1";

				/**
				 * [tRunJob_1 finally ] stop
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
		final ParentJob ParentJobClass = new ParentJob();

		int exitCode = ParentJobClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'ParentJob' - Done.");
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
		log.info("TalendJob: 'ParentJob' - Start.");

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
			java.io.InputStream inContext = ParentJob.class.getClassLoader()
					.getResourceAsStream(
							"serverless_etl/parentjob_0_1/contexts/"
									+ contextStr + ".properties");
			if (inContext == null) {
				inContext = ParentJob.class
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
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
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
			tCreateTemporaryFile_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tCreateTemporaryFile_1) {
			globalMap.put("tCreateTemporaryFile_1_SUBPROCESS_STATE", -1);

			e_tCreateTemporaryFile_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : ParentJob");
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
 * 60242 characters generated by Talend Data Management Platform on the 11
 * January 2019 3:57:53 PM
 ************************************************************************************************/
