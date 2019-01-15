package serverless_etl.python_to_redshift_0_1;

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
 * Job: python_to_redshift Purpose: <br>
 * Description:  <br>
 * @author ali@versent.com.au
 * @version 7.1.1.20181026_1147
 * @status 
 */
public class python_to_redshift implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "python_to_redshift.log");
	}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(python_to_redshift.class);

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
	private final String jobName = "python_to_redshift";
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
					python_to_redshift.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(python_to_redshift.this, new Object[] { e,
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

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFlowToIterate_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJython_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFlowToIterate_2_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSystem_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class out1Struct implements
			routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_python_to_redshift = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_python_to_redshift = new byte[0];

		public Integer u_id;

		public Integer getU_id() {
			return this.u_id;
		}

		public String name;

		public String getName() {
			return this.name;
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
				if (length > commonByteArray_SERVERLESS_ETL_python_to_redshift.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_python_to_redshift.length == 0) {
						commonByteArray_SERVERLESS_ETL_python_to_redshift = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_python_to_redshift = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_python_to_redshift, 0,
						length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_python_to_redshift, 0,
						length, utf8Charset);
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

			synchronized (commonByteArrayLock_SERVERLESS_ETL_python_to_redshift) {

				try {

					int length = 0;

					this.u_id = readInteger(dis);

					this.name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.u_id, dos);

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
			sb.append("u_id=" + String.valueOf(u_id));
			sb.append(",name=" + name);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (u_id == null) {
				sb.append("<null>");
			} else {
				sb.append(u_id);
			}

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
		public int compareTo(out1Struct other) {

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

	public static class out2Struct implements
			routines.system.IPersistableRow<out2Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_python_to_redshift = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_python_to_redshift = new byte[0];

		public Integer u_id;

		public Integer getU_id() {
			return this.u_id;
		}

		public String name;

		public String getName() {
			return this.name;
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
				if (length > commonByteArray_SERVERLESS_ETL_python_to_redshift.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_python_to_redshift.length == 0) {
						commonByteArray_SERVERLESS_ETL_python_to_redshift = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_python_to_redshift = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_python_to_redshift, 0,
						length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_python_to_redshift, 0,
						length, utf8Charset);
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

			synchronized (commonByteArrayLock_SERVERLESS_ETL_python_to_redshift) {

				try {

					int length = 0;

					this.u_id = readInteger(dis);

					this.name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.u_id, dos);

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
			sb.append("u_id=" + String.valueOf(u_id));
			sb.append(",name=" + name);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (u_id == null) {
				sb.append("<null>");
			} else {
				sb.append(u_id);
			}

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
		public int compareTo(out2Struct other) {

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

	public static class row1Struct implements
			routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_python_to_redshift = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_python_to_redshift = new byte[0];

		public Integer u_id;

		public Integer getU_id() {
			return this.u_id;
		}

		public String name;

		public String getName() {
			return this.name;
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
				if (length > commonByteArray_SERVERLESS_ETL_python_to_redshift.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_python_to_redshift.length == 0) {
						commonByteArray_SERVERLESS_ETL_python_to_redshift = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_python_to_redshift = new byte[2 * length];
					}
				}
				dis.readFully(
						commonByteArray_SERVERLESS_ETL_python_to_redshift, 0,
						length);
				strReturn = new String(
						commonByteArray_SERVERLESS_ETL_python_to_redshift, 0,
						length, utf8Charset);
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

			synchronized (commonByteArrayLock_SERVERLESS_ETL_python_to_redshift) {

				try {

					int length = 0;

					this.u_id = readInteger(dis);

					this.name = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.u_id, dos);

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
			sb.append("u_id=" + String.valueOf(u_id));
			sb.append(",name=" + name);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (u_id == null) {
				sb.append("<null>");
			} else {
				sb.append(u_id);
			}

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

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

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
				out1Struct out1 = new out1Struct();
				out2Struct out2 = new out2Struct();

				/**
				 * [tFlowToIterate_1 begin ] start
				 */

				int NB_ITERATE_tJython_1 = 0; // for statistics

				ok_Hash.put("tFlowToIterate_1", false);
				start_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

				currentComponent = "tFlowToIterate_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("out1" + iterateId, 0, 0);

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
									.append("DEFAULT_MAP" + " = " + "false");
							log4jParamters_tFlowToIterate_1.append(" | ");
							log4jParamters_tFlowToIterate_1.append("MAP"
									+ " = " + "[{VALUE=" + ("name") + ", KEY="
									+ ("\"u_name\"") + "}]");
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
				 * [tFlowToIterate_2 begin ] start
				 */

				int NB_ITERATE_tSystem_1 = 0; // for statistics

				ok_Hash.put("tFlowToIterate_2", false);
				start_Hash.put("tFlowToIterate_2", System.currentTimeMillis());

				currentComponent = "tFlowToIterate_2";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("out2" + iterateId, 0, 0);

					}
				}

				int tos_count_tFlowToIterate_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tFlowToIterate_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFlowToIterate_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFlowToIterate_2 = new StringBuilder();
							log4jParamters_tFlowToIterate_2
									.append("Parameters:");
							log4jParamters_tFlowToIterate_2
									.append("DEFAULT_MAP" + " = " + "false");
							log4jParamters_tFlowToIterate_2.append(" | ");
							log4jParamters_tFlowToIterate_2.append("MAP"
									+ " = " + "[{VALUE=" + ("u_id") + ", KEY="
									+ ("\"user_id\"") + "}, {VALUE=" + ("name")
									+ ", KEY=" + ("\"user_name\"") + "}]");
							log4jParamters_tFlowToIterate_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFlowToIterate_2 - "
										+ (log4jParamters_tFlowToIterate_2));
						}
					}
					new BytesLimit65535_tFlowToIterate_2().limitLog4jByte();
				}

				int nb_line_tFlowToIterate_2 = 0;
				int counter_tFlowToIterate_2 = 0;

				/**
				 * [tFlowToIterate_2 begin ] stop
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

				// ###############################

				// ###############################
				// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
				// ###############################

				// ###############################
				// # Outputs initialization
				int count_out1_tMap_1 = 0;

				out1Struct out1_tmp = new out1Struct();
				int count_out2_tMap_1 = 0;

				out2Struct out2_tmp = new out2Struct();
				// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_2 = new StringBuilder();
							log4jParamters_tDBInput_2.append("Parameters:");
							log4jParamters_tDBInput_2
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("HOST" + " = "
									+ "\"localhost\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PORT" + " = "
									+ "\"5439\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("DBNAME" + " = "
									+ "\"dev\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("SCHEMA_DB"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USER" + " = "
									+ "\"alik\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PASS"
									+ " = "
									+ String.valueOf(
											"d6eafe383d0b9c6bf4f7aba1746784ea")
											.substring(0, 4) + "...");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("PROPERTIES"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TABLE" + " = "
									+ "\"account\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("QUERYSTORE"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("QUERY"
											+ " = "
											+ "\"SELECT account.u_id, 		account.name FROM	account\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("LOG_FILE"
											+ " = "
											+ "\"/Applications/TalendStudio-7.1.1/studio/workspace/redshift-jdbc.log\"");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("LOG_LEVEL"
									+ " = " + "1");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("USE_CURSOR"
									+ " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_ALL_COLUMN"
									+ " = " + "false");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("TRIM_COLUMN"
									+ " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("u_id")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("name") + "}]");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2.append("JDBC_URL" + " = "
									+ "STANDARD");
							log4jParamters_tDBInput_2.append(" | ");
							log4jParamters_tDBInput_2
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tRedshiftInput");
							log4jParamters_tDBInput_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_2 - "
										+ (log4jParamters_tDBInput_2));
						}
					}
					new BytesLimit65535_tDBInput_2().limitLog4jByte();
				}

				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "com.amazon.redshift.jdbc42.Driver";
				java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "alik";

				final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil
						.decryptPassword("d6eafe383d0b9c6bf4f7aba1746784ea");

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				java.io.Writer output_tDBInput_2 = new java.io.FileWriter(
						"/Applications/TalendStudio-7.1.1/studio/workspace/redshift-jdbc.log",
						true);
				java.io.PrintWriter logWriter_tDBInput_2 = new java.io.PrintWriter(
						output_tDBInput_2, true);
				java.sql.DriverManager.setLogWriter(logWriter_tDBInput_2);
				StringBuilder sbuilder_tDBInput_2 = new StringBuilder();
				sbuilder_tDBInput_2.append("jdbc:redshift:");
				sbuilder_tDBInput_2.append("//").append("localhost")
						.append(":").append("5439").append("/").append("dev")
						.append("?loglevel=").append(1);
				String url_tDBInput_2 = sbuilder_tDBInput_2.toString();

				log.debug("tDBInput_2 - Driver ClassName: "
						+ driverClass_tDBInput_2 + ".");

				log.debug("tDBInput_2 - Connection attempt to '"
						+ url_tDBInput_2 + "' with the username '"
						+ dbUser_tDBInput_2 + "'.");

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(
						url_tDBInput_2, dbUser_tDBInput_2, dbPwd_tDBInput_2);
				log.debug("tDBInput_2 - Connection to '" + url_tDBInput_2
						+ "' has succeeded.");

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2
						.createStatement();

				String dbquery_tDBInput_2 = "SELECT account.u_id,\n		account.name\nFROM	account";

				log.debug("tDBInput_2 - Executing the query: '"
						+ dbquery_tDBInput_2 + "'.");

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);
				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2
							.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2
							.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2
							.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					log.debug("tDBInput_2 - Retrieving records from the database.");

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row1.u_id = null;
						} else {

							if (rs_tDBInput_2.getObject(1) != null) {
								row1.u_id = rs_tDBInput_2.getInt(1);
							} else {
								row1.u_id = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row1.name = null;
						} else {

							row1.name = routines.system.JDBCUtil.getString(
									rs_tDBInput_2, 2, false);
						}

						log.debug("tDBInput_2 - Retrieving the record "
								+ nb_line_tDBInput_2 + ".");

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
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

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							out1 = null;
							out2 = null;

							// # Output table : 'out1'
							// # Filter conditions
							if (

							row1.u_id <= 2

							) {
								count_out1_tMap_1++;

								out1_tmp.u_id = row1.u_id;
								out1_tmp.name = row1.name;
								out1 = out1_tmp;
								log.debug("tMap_1 - Outputting the record "
										+ count_out1_tMap_1
										+ " of the output table 'out1'.");

							} // closing filter/reject

							// # Output table : 'out2'
							// # Filter conditions
							if (

							row1.u_id > 2

							) {
								count_out2_tMap_1++;

								out2_tmp.u_id = row1.u_id;
								out2_tmp.name = row1.name;
								out2 = out2_tmp;
								log.debug("tMap_1 - Outputting the record "
										+ count_out2_tMap_1
										+ " of the output table 'out2'.");

							} // closing filter/reject
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
						// Start of branch "out1"
						if (out1 != null) {

							/**
							 * [tFlowToIterate_1 main ] start
							 */

							currentComponent = "tFlowToIterate_1";

							// out1
							// out1

							if (execStat) {
								runStat.updateStatOnConnection("out1"
										+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("out1 - "
										+ (out1 == null ? "" : out1
												.toLogString()));
							}

							if (log.isTraceEnabled())
								log.trace("tFlowToIterate_1 - "
										+ ("Set global var, key=") + ("u_name")
										+ (", value=") + (out1.name) + ("."));
							globalMap.put("u_name", out1.name);
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
							NB_ITERATE_tJython_1++;

							if (execStat) {
								runStat.updateStatOnConnection("iterate2", 1,
										"exec" + NB_ITERATE_tJython_1);
								// Thread.sleep(1000);
							}

							/**
							 * [tJython_1 begin ] start
							 */

							ok_Hash.put("tJython_1", false);
							start_Hash.put("tJython_1",
									System.currentTimeMillis());

							currentComponent = "tJython_1";

							int tos_count_tJython_1 = 0;

							String codetJython_1 = ""
									+ "print  \"Hi From Jython \" + context.u_name"
									+ "\n";
							java.io.ByteArrayInputStream istJython_1 = new java.io.ByteArrayInputStream(
									codetJython_1.getBytes());
							org.python.util.PythonInterpreter shelltJython_1 = new org.python.util.PythonInterpreter();
							shelltJython_1.execfile(istJython_1);

							/**
							 * [tJython_1 begin ] stop
							 */

							/**
							 * [tJython_1 main ] start
							 */

							currentComponent = "tJython_1";

							tos_count_tJython_1++;

							/**
							 * [tJython_1 main ] stop
							 */

							/**
							 * [tJython_1 process_data_begin ] start
							 */

							currentComponent = "tJython_1";

							/**
							 * [tJython_1 process_data_begin ] stop
							 */

							/**
							 * [tJython_1 process_data_end ] start
							 */

							currentComponent = "tJython_1";

							/**
							 * [tJython_1 process_data_end ] stop
							 */

							/**
							 * [tJython_1 end ] start
							 */

							currentComponent = "tJython_1";

							ok_Hash.put("tJython_1", true);
							end_Hash.put("tJython_1",
									System.currentTimeMillis());

							/**
							 * [tJython_1 end ] stop
							 */
							if (execStat) {
								runStat.updateStatOnConnection("iterate2", 2,
										"exec" + NB_ITERATE_tJython_1);
							}

							/**
							 * [tFlowToIterate_1 process_data_end ] start
							 */

							currentComponent = "tFlowToIterate_1";

							/**
							 * [tFlowToIterate_1 process_data_end ] stop
							 */

						} // End of branch "out1"

						// Start of branch "out2"
						if (out2 != null) {

							/**
							 * [tFlowToIterate_2 main ] start
							 */

							currentComponent = "tFlowToIterate_2";

							// out2
							// out2

							if (execStat) {
								runStat.updateStatOnConnection("out2"
										+ iterateId, 1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("out2 - "
										+ (out2 == null ? "" : out2
												.toLogString()));
							}

							if (log.isTraceEnabled())
								log.trace("tFlowToIterate_2 - "
										+ ("Set global var, key=")
										+ ("user_id") + (", value=")
										+ (out2.u_id) + ("."));
							globalMap.put("user_id", out2.u_id);
							if (log.isTraceEnabled())
								log.trace("tFlowToIterate_2 - "
										+ ("Set global var, key=")
										+ ("user_name") + (", value=")
										+ (out2.name) + ("."));
							globalMap.put("user_name", out2.name);
							nb_line_tFlowToIterate_2++;
							counter_tFlowToIterate_2++;
							if (log.isDebugEnabled())
								log.debug("tFlowToIterate_2 - "
										+ ("Current iteration is: ")
										+ (counter_tFlowToIterate_2) + ("."));
							globalMap.put("tFlowToIterate_2_CURRENT_ITERATION",
									counter_tFlowToIterate_2);

							tos_count_tFlowToIterate_2++;

							/**
							 * [tFlowToIterate_2 main ] stop
							 */

							/**
							 * [tFlowToIterate_2 process_data_begin ] start
							 */

							currentComponent = "tFlowToIterate_2";

							/**
							 * [tFlowToIterate_2 process_data_begin ] stop
							 */
							NB_ITERATE_tSystem_1++;

							if (execStat) {
								runStat.updateStatOnConnection("iterate1", 1,
										"exec" + NB_ITERATE_tSystem_1);
								// Thread.sleep(1000);
							}

							/**
							 * [tSystem_1 begin ] start
							 */

							ok_Hash.put("tSystem_1", false);
							start_Hash.put("tSystem_1",
									System.currentTimeMillis());

							currentComponent = "tSystem_1";

							int tos_count_tSystem_1 = 0;

							if (log.isDebugEnabled())
								log.debug("tSystem_1 - " + ("Start to work."));
							if (log.isDebugEnabled()) {
								class BytesLimit65535_tSystem_1 {
									public void limitLog4jByte()
											throws Exception {
										StringBuilder log4jParamters_tSystem_1 = new StringBuilder();
										log4jParamters_tSystem_1
												.append("Parameters:");
										log4jParamters_tSystem_1
												.append("ROOTDIR" + " = "
														+ "false");
										log4jParamters_tSystem_1.append(" | ");
										log4jParamters_tSystem_1
												.append("USE_SINGLE_COMMAND"
														+ " = " + "true");
										log4jParamters_tSystem_1.append(" | ");
										log4jParamters_tSystem_1
												.append("COMMAND"
														+ " = "
														+ "\"python /Applications/TalendStudio-7.1.1/studio/workspace/SERVERLESS_ETL/dummy_py_code.py \" + ((String)globalMap.get(\"user_name\")) ");
										log4jParamters_tSystem_1.append(" | ");
										log4jParamters_tSystem_1
												.append("USE_ARRAY_COMMAND"
														+ " = " + "false");
										log4jParamters_tSystem_1.append(" | ");
										log4jParamters_tSystem_1
												.append("OUTPUT" + " = "
														+ "OUTPUT_TO_CONSOLE");
										log4jParamters_tSystem_1.append(" | ");
										log4jParamters_tSystem_1
												.append("ERROROUTPUT" + " = "
														+ "OUTPUT_TO_CONSOLE");
										log4jParamters_tSystem_1.append(" | ");
										log4jParamters_tSystem_1
												.append("PARAMS" + " = " + "[]");
										log4jParamters_tSystem_1.append(" | ");
										if (log.isDebugEnabled())
											log.debug("tSystem_1 - "
													+ (log4jParamters_tSystem_1));
									}
								}
								new BytesLimit65535_tSystem_1()
										.limitLog4jByte();
							}

							Runtime runtime_tSystem_1 = Runtime.getRuntime();

							String[] env_tSystem_1 = null;
							java.util.Map<String, String> envMap_tSystem_1 = System
									.getenv();
							java.util.Map<String, String> envMapClone_tSystem_1 = new java.util.HashMap();
							envMapClone_tSystem_1.putAll(envMap_tSystem_1);

							log.info("tSystem_1 - Setting the parameters.");
							final Process ps_tSystem_1 = runtime_tSystem_1
									.exec("python /Applications/TalendStudio-7.1.1/studio/workspace/SERVERLESS_ETL/dummy_py_code.py "
											+ ((String) globalMap
													.get("user_name")),
											env_tSystem_1);

							globalMap.remove("tSystem_1_OUTPUT");
							globalMap.remove("tSystem_1_ERROROUTPUT");

							Thread normal_tSystem_1 = new Thread() {
								public void run() {
									try {
										java.io.BufferedReader reader = new java.io.BufferedReader(
												new java.io.InputStreamReader(
														ps_tSystem_1
																.getInputStream()));
										String line = "";
										try {
											while ((line = reader.readLine()) != null) {

												log.debug("tSystem_1 - Sending the standard output to the console.");

												System.out.println(line);
											}
										} finally {
											reader.close();
										}
									} catch (java.io.IOException ioe) {

										log.error("tSystem_1 - "
												+ ioe.getMessage());

										ioe.printStackTrace();
									}
								}
							};
							log.info("tSystem_1 - Executing the command.");
							log.info("tSystem_1 - Command to execute: '"
									+ "python /Applications/TalendStudio-7.1.1/studio/workspace/SERVERLESS_ETL/dummy_py_code.py "
									+ ((String) globalMap.get("user_name"))
									+ "'.");
							normal_tSystem_1.start();
							log.info("tSystem_1 - The command has been executed successfully.");

							Thread error_tSystem_1 = new Thread() {
								public void run() {
									try {
										java.io.BufferedReader reader = new java.io.BufferedReader(
												new java.io.InputStreamReader(
														ps_tSystem_1
																.getErrorStream()));
										String line = "";
										try {
											while ((line = reader.readLine()) != null) {

												log.debug("tSystem_1 - Sending the error output to the console.");

												System.err.println(line);
											}
										} finally {
											reader.close();
										}
									} catch (java.io.IOException ioe) {

										log.error("tSystem_1 - "
												+ ioe.getMessage());

										ioe.printStackTrace();
									}
								}
							};
							error_tSystem_1.start();
							if (ps_tSystem_1.getOutputStream() != null) {
								ps_tSystem_1.getOutputStream().close();
							}
							ps_tSystem_1.waitFor();
							normal_tSystem_1.join(10000);
							error_tSystem_1.join(10000);

							/**
							 * [tSystem_1 begin ] stop
							 */

							/**
							 * [tSystem_1 main ] start
							 */

							currentComponent = "tSystem_1";

							tos_count_tSystem_1++;

							/**
							 * [tSystem_1 main ] stop
							 */

							/**
							 * [tSystem_1 process_data_begin ] start
							 */

							currentComponent = "tSystem_1";

							/**
							 * [tSystem_1 process_data_begin ] stop
							 */

							/**
							 * [tSystem_1 process_data_end ] start
							 */

							currentComponent = "tSystem_1";

							/**
							 * [tSystem_1 process_data_end ] stop
							 */

							/**
							 * [tSystem_1 end ] start
							 */

							currentComponent = "tSystem_1";

							globalMap.put("tSystem_1_EXIT_VALUE",
									ps_tSystem_1.exitValue());

							if (log.isDebugEnabled())
								log.debug("tSystem_1 - " + ("Done."));

							ok_Hash.put("tSystem_1", true);
							end_Hash.put("tSystem_1",
									System.currentTimeMillis());

							/**
							 * [tSystem_1 end ] stop
							 */
							if (execStat) {
								runStat.updateStatOnConnection("iterate1", 2,
										"exec" + NB_ITERATE_tSystem_1);
							}

							/**
							 * [tFlowToIterate_2 process_data_end ] start
							 */

							currentComponent = "tFlowToIterate_2";

							/**
							 * [tFlowToIterate_2 process_data_end ] stop
							 */

						} // End of branch "out2"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						log.debug("tDBInput_2 - Closing the connection to the database.");

						conn_tDBInput_2.close();

						log.debug("tDBInput_2 - Connection to the database closed.");

					}
				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);
				log.debug("tDBInput_2 - Retrieved records count: "
						+ nb_line_tDBInput_2 + " .");

				logWriter_tDBInput_2.close();

				if (log.isDebugEnabled())
					log.debug("tDBInput_2 - " + ("Done."));

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

				// ###############################
				// # Lookup hashes releasing
				// ###############################
				log.debug("tMap_1 - Written records count in the table 'out1': "
						+ count_out1_tMap_1 + ".");
				log.debug("tMap_1 - Written records count in the table 'out2': "
						+ count_out2_tMap_1 + ".");

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
				 * [tFlowToIterate_1 end ] start
				 */

				currentComponent = "tFlowToIterate_1";

				globalMap.put("tFlowToIterate_1_NB_LINE",
						nb_line_tFlowToIterate_1);
				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("out1" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tFlowToIterate_1 - " + ("Done."));

				ok_Hash.put("tFlowToIterate_1", true);
				end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

				/**
				 * [tFlowToIterate_1 end ] stop
				 */

				/**
				 * [tFlowToIterate_2 end ] start
				 */

				currentComponent = "tFlowToIterate_2";

				globalMap.put("tFlowToIterate_2_NB_LINE",
						nb_line_tFlowToIterate_2);
				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null
							|| !((Boolean) resourceMap.get("inIterateVComp"))) {
						runStat.updateStatOnConnection("out2" + iterateId, 2, 0);
					}
				}

				if (log.isDebugEnabled())
					log.debug("tFlowToIterate_2 - " + ("Done."));

				ok_Hash.put("tFlowToIterate_2", true);
				end_Hash.put("tFlowToIterate_2", System.currentTimeMillis());

				/**
				 * [tFlowToIterate_2 end ] stop
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
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tFlowToIterate_1 finally ] start
				 */

				currentComponent = "tFlowToIterate_1";

				/**
				 * [tFlowToIterate_1 finally ] stop
				 */

				/**
				 * [tJython_1 finally ] start
				 */

				currentComponent = "tJython_1";

				/**
				 * [tJython_1 finally ] stop
				 */

				/**
				 * [tFlowToIterate_2 finally ] start
				 */

				currentComponent = "tFlowToIterate_2";

				/**
				 * [tFlowToIterate_2 finally ] stop
				 */

				/**
				 * [tSystem_1 finally ] start
				 */

				currentComponent = "tSystem_1";

				/**
				 * [tSystem_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
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
		final python_to_redshift python_to_redshiftClass = new python_to_redshift();

		int exitCode = python_to_redshiftClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'python_to_redshift' - Done.");
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
		log.info("TalendJob: 'python_to_redshift' - Start.");

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
			java.io.InputStream inContext = python_to_redshift.class
					.getClassLoader().getResourceAsStream(
							"serverless_etl/python_to_redshift_0_1/contexts/"
									+ contextStr + ".properties");
			if (inContext == null) {
				inContext = python_to_redshift.class
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
			tDBInput_2Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_2) {
			globalMap.put("tDBInput_2_SUBPROCESS_STATE", -1);

			e_tDBInput_2.printStackTrace();

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
							+ " bytes memory increase when running : python_to_redshift");
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
 * 66372 characters generated by Talend Data Management Platform on the 15
 * January 2019 10:58:20 AM
 ************************************************************************************************/
