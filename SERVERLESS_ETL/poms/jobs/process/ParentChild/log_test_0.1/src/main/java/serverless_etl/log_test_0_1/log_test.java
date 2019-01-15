package serverless_etl.log_test_0_1;

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
 * Job: log_test Purpose: <br>
 * Description:  <br>
 * @author ali@versent.com.au
 * @version 7.1.1.20181026_1147
 * @status 
 */
public class log_test implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "log_test.log");
	}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(log_test.class);

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
	private final String jobName = "log_test";
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

	LogCatcherUtils tLogCatcher_1 = new LogCatcherUtils();

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
					log_test.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(log_test.this, new Object[] { e,
									currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						tLogCatcher_1.addMessage("Java Exception",
								currentComponent, 6, e.getClass().getName()
										+ ":" + e.getMessage(), 1);
						tLogCatcher_1Process(globalMap);
					}
				} catch (TalendException e) {
					// do nothing

				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFileInputDelimited_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		try {

			if (this.execStat) {
				runStat.updateStatOnConnection("OnComponentError1", 0, "error");
			}

			errorCode = null;
			tDie_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		tFileInputDelimited_1_onSubJobError(exception, errorComponent,
				globalMap);
	}

	public void tWarn_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tWarn_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDie_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDie_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogCatcher_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tWarn_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDie_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tLogCatcher_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

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
									.append("FILENAME" + " = "
											+ "\"/Users/alik/Repos/test1.txt\"");
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
									.append("TRIMSELECT" + " = " + "[]");
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

					Object filename_tFileInputDelimited_1 = "/Users/alik/Repos/test1.txt";
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
								"/Users/alik/Repos/test1.txt", "ISO-8859-15",
								";", "\n", true, 0, 0, -1, -1, false);
					} catch (java.lang.Exception e) {

						log.error("tFileInputDelimited_1 - " + e.getMessage());

						System.err.println(e.getMessage());

					}

					log.info("tFileInputDelimited_1 - Retrieving records from the datasource.");

					while (fid_tFileInputDelimited_1 != null
							&& fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();

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
					if (!((Object) ("/Users/alik/Repos/test1.txt") instanceof java.io.InputStream)) {
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

			tWarn_1Process(globalMap);

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
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}

	public void tWarn_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tWarn_1_SUBPROCESS_STATE", 0);

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
				 * [tWarn_1 begin ] start
				 */

				ok_Hash.put("tWarn_1", false);
				start_Hash.put("tWarn_1", System.currentTimeMillis());

				currentComponent = "tWarn_1";

				int tos_count_tWarn_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tWarn_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tWarn_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tWarn_1 = new StringBuilder();
							log4jParamters_tWarn_1.append("Parameters:");
							log4jParamters_tWarn_1.append("MESSAGE" + " = "
									+ "\"this is a WTH\"");
							log4jParamters_tWarn_1.append(" | ");
							log4jParamters_tWarn_1
									.append("CODE" + " = " + "42");
							log4jParamters_tWarn_1.append(" | ");
							log4jParamters_tWarn_1.append("PRIORITY" + " = "
									+ "4");
							log4jParamters_tWarn_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tWarn_1 - "
										+ (log4jParamters_tWarn_1));
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

				currentComponent = "tWarn_1";

				try {

					resumeUtil.addLog("USER_DEF_LOG", "NODE:tWarn_1", "",
							Thread.currentThread().getId() + "", "WARN", "",
							"this is a WTH", "", "");
					log.warn("tWarn_1 - " + ("Message: ") + ("this is a WTH")
							+ (". Code: ") + (42));
					if (log.isDebugEnabled())
						log.debug("tWarn_1 - "
								+ ("Sending message to tLogCatcher_1."));
					tLogCatcher_1.addMessage("tWarn", "tWarn_1", 4,
							"this is a WTH", 42);
					tLogCatcher_1Process(globalMap);
					globalMap.put("tWarn_1_WARN_MESSAGES", "this is a WTH");
					globalMap.put("tWarn_1_WARN_PRIORITY", 4);
					globalMap.put("tWarn_1_WARN_CODE", 42);

				} catch (Exception e_tWarn_1) {
					logIgnoredError(
							String.format(
									"tWarn_1 - tWarn failed to log message due to internal error: %s",
									e_tWarn_1), e_tWarn_1);
				}

				tos_count_tWarn_1++;

				/**
				 * [tWarn_1 main ] stop
				 */

				/**
				 * [tWarn_1 process_data_begin ] start
				 */

				currentComponent = "tWarn_1";

				/**
				 * [tWarn_1 process_data_begin ] stop
				 */

				/**
				 * [tWarn_1 process_data_end ] start
				 */

				currentComponent = "tWarn_1";

				/**
				 * [tWarn_1 process_data_end ] stop
				 */

				/**
				 * [tWarn_1 end ] start
				 */

				currentComponent = "tWarn_1";

				if (log.isDebugEnabled())
					log.debug("tWarn_1 - " + ("Done."));

				ok_Hash.put("tWarn_1", true);
				end_Hash.put("tWarn_1", System.currentTimeMillis());

				/**
				 * [tWarn_1 end ] stop
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
				 * [tWarn_1 finally ] start
				 */

				currentComponent = "tWarn_1";

				/**
				 * [tWarn_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tWarn_1_SUBPROCESS_STATE", 1);
	}

	public void tDie_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDie_1_SUBPROCESS_STATE", 0);

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
				 * [tDie_1 begin ] start
				 */

				ok_Hash.put("tDie_1", false);
				start_Hash.put("tDie_1", System.currentTimeMillis());

				currentComponent = "tDie_1";

				int tos_count_tDie_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDie_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDie_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDie_1 = new StringBuilder();
							log4jParamters_tDie_1.append("Parameters:");
							log4jParamters_tDie_1.append("MESSAGE" + " = "
									+ "\"the end is yg\"");
							log4jParamters_tDie_1.append(" | ");
							log4jParamters_tDie_1.append("CODE" + " = " + "4");
							log4jParamters_tDie_1.append(" | ");
							log4jParamters_tDie_1.append("PRIORITY" + " = "
									+ "5");
							log4jParamters_tDie_1.append(" | ");
							log4jParamters_tDie_1.append("EXIT_JVM" + " = "
									+ "false");
							log4jParamters_tDie_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDie_1 - " + (log4jParamters_tDie_1));
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

				currentComponent = "tDie_1";

				try {
					tLogCatcher_1.addMessage("tDie", "tDie_1", 5,
							"the end is yg", 4);
					tLogCatcher_1Process(globalMap);

					globalMap.put("tDie_1_DIE_PRIORITY", 5);
					System.err.println("the end is yg");

					log.error("tDie_1 - The die message: " + "the end is yg");

					globalMap.put("tDie_1_DIE_MESSAGE", "the end is yg");
					globalMap.put("tDie_1_DIE_MESSAGES", "the end is yg");

				} catch (Exception | Error e_tDie_1) {
					logIgnoredError(
							String.format(
									"tDie_1 - tDie failed to log message due to internal error: %s",
									e_tDie_1), e_tDie_1);
				}

				currentComponent = "tDie_1";
				status = "failure";
				errorCode = new Integer(4);
				globalMap.put("tDie_1_DIE_CODE", errorCode);

				if (true) {
					throw new TDieException();
				}

				tos_count_tDie_1++;

				/**
				 * [tDie_1 main ] stop
				 */

				/**
				 * [tDie_1 process_data_begin ] start
				 */

				currentComponent = "tDie_1";

				/**
				 * [tDie_1 process_data_begin ] stop
				 */

				/**
				 * [tDie_1 process_data_end ] start
				 */

				currentComponent = "tDie_1";

				/**
				 * [tDie_1 process_data_end ] stop
				 */

				/**
				 * [tDie_1 end ] start
				 */

				currentComponent = "tDie_1";

				if (log.isDebugEnabled())
					log.debug("tDie_1 - " + ("Done."));

				ok_Hash.put("tDie_1", true);
				end_Hash.put("tDie_1", System.currentTimeMillis());

				/**
				 * [tDie_1 end ] stop
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
				 * [tDie_1 finally ] start
				 */

				currentComponent = "tDie_1";

				/**
				 * [tDie_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDie_1_SUBPROCESS_STATE", 1);
	}

	public static class gStruct implements
			routines.system.IPersistableRow<gStruct> {
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_log_test = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_log_test = new byte[0];

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
				if (length > commonByteArray_SERVERLESS_ETL_log_test.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_log_test.length == 0) {
						commonByteArray_SERVERLESS_ETL_log_test = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_log_test = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SERVERLESS_ETL_log_test, 0,
						length);
				strReturn = new String(commonByteArray_SERVERLESS_ETL_log_test,
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

			synchronized (commonByteArrayLock_SERVERLESS_ETL_log_test) {

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
		public int compareTo(gStruct other) {

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
		final static byte[] commonByteArrayLock_SERVERLESS_ETL_log_test = new byte[0];
		static byte[] commonByteArray_SERVERLESS_ETL_log_test = new byte[0];

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
				if (length > commonByteArray_SERVERLESS_ETL_log_test.length) {
					if (length < 1024
							&& commonByteArray_SERVERLESS_ETL_log_test.length == 0) {
						commonByteArray_SERVERLESS_ETL_log_test = new byte[1024];
					} else {
						commonByteArray_SERVERLESS_ETL_log_test = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SERVERLESS_ETL_log_test, 0,
						length);
				strReturn = new String(commonByteArray_SERVERLESS_ETL_log_test,
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

			synchronized (commonByteArrayLock_SERVERLESS_ETL_log_test) {

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

	public void tLogCatcher_1Process(
			final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tLogCatcher_1_SUBPROCESS_STATE", 0);

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
				gStruct g = new gStruct();

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				if (execStat) {
					if (resourceMap.get("inIterateVComp") == null) {

						runStat.updateStatOnConnection("g" + iterateId, 0, 0);

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
									+ " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_UNIQUE_NAME"
									+ " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_COLNAMES"
									+ " = " + "true");
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

				StringBuilder sbHeader_tLogRow_1 = new StringBuilder();

				sbHeader_tLogRow_1.append("moment");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("pid");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("root_pid");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("father_pid");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("project");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("job");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("context");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("priority");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("type");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("origin");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("message");

				sbHeader_tLogRow_1.append("\t");

				sbHeader_tLogRow_1.append("code");

				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap
							.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_1 = new java.io.PrintStream(
							new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
				}
				log.info("tLogRow_1 - Header names: "
						+ sbHeader_tLogRow_1.toString());
				consoleOut_tLogRow_1.println(sbHeader_tLogRow_1.toString());
				consoleOut_tLogRow_1.flush();

				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
				// /////////////////////

				/**
				 * [tLogRow_1 begin ] stop
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
				int count_g_tMap_1 = 0;

				gStruct g_tmp = new gStruct();
				// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tLogCatcher_1 begin ] start
				 */

				ok_Hash.put("tLogCatcher_1", false);
				start_Hash.put("tLogCatcher_1", System.currentTimeMillis());

				currentComponent = "tLogCatcher_1";

				int tos_count_tLogCatcher_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogCatcher_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogCatcher_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogCatcher_1 = new StringBuilder();
							log4jParamters_tLogCatcher_1.append("Parameters:");
							log4jParamters_tLogCatcher_1
									.append("CATCH_JAVA_EXCEPTION" + " = "
											+ "true");
							log4jParamters_tLogCatcher_1.append(" | ");
							log4jParamters_tLogCatcher_1.append("CATCH_TDIE"
									+ " = " + "true");
							log4jParamters_tLogCatcher_1.append(" | ");
							log4jParamters_tLogCatcher_1.append("CATCH_TWARN"
									+ " = " + "true");
							log4jParamters_tLogCatcher_1.append(" | ");
							log4jParamters_tLogCatcher_1
									.append("CATCH_TACTIONFAILURE" + " = "
											+ "true");
							log4jParamters_tLogCatcher_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogCatcher_1 - "
										+ (log4jParamters_tLogCatcher_1));
						}
					}
					new BytesLimit65535_tLogCatcher_1().limitLog4jByte();
				}

				try {
					for (LogCatcherUtils.LogCatcherMessage lcm : tLogCatcher_1
							.getMessages()) {
						row1.type = lcm.getType();
						row1.origin = (lcm.getOrigin() == null
								|| lcm.getOrigin().length() < 1 ? null : lcm
								.getOrigin());
						row1.priority = lcm.getPriority();
						row1.message = lcm.getMessage();
						row1.code = lcm.getCode();

						row1.moment = java.util.Calendar.getInstance()
								.getTime();

						row1.pid = pid;
						row1.root_pid = rootPid;
						row1.father_pid = fatherPid;

						row1.project = projectName;
						row1.job = jobName;
						row1.context = contextStr;

						/**
						 * [tLogCatcher_1 begin ] stop
						 */

						/**
						 * [tLogCatcher_1 main ] start
						 */

						currentComponent = "tLogCatcher_1";

						tos_count_tLogCatcher_1++;

						/**
						 * [tLogCatcher_1 main ] stop
						 */

						/**
						 * [tLogCatcher_1 process_data_begin ] start
						 */

						currentComponent = "tLogCatcher_1";

						/**
						 * [tLogCatcher_1 process_data_begin ] stop
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

							g = null;

							// # Output table : 'g'
							// # Filter conditions
							if (

							row1.priority == 4

							) {
								count_g_tMap_1++;

								g_tmp.moment = row1.moment;
								g_tmp.pid = row1.pid;
								g_tmp.root_pid = row1.root_pid;
								g_tmp.father_pid = row1.father_pid;
								g_tmp.project = row1.project;
								g_tmp.job = row1.job;
								g_tmp.context = row1.context;
								g_tmp.priority = row1.priority;
								g_tmp.type = row1.type;
								g_tmp.origin = row1.origin;
								g_tmp.message = row1.message;
								g_tmp.code = row1.code;
								g = g_tmp;
								log.debug("tMap_1 - Outputting the record "
										+ count_g_tMap_1
										+ " of the output table 'g'.");

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
						// Start of branch "g"
						if (g != null) {

							/**
							 * [tLogRow_1 main ] start
							 */

							currentComponent = "tLogRow_1";

							// g
							// g

							if (execStat) {
								runStat.updateStatOnConnection("g" + iterateId,
										1, 1);
							}

							if (log.isTraceEnabled()) {
								log.trace("g - "
										+ (g == null ? "" : g.toLogString()));
							}

							// /////////////////////

							strBuffer_tLogRow_1 = new StringBuilder();

							strBuffer_tLogRow_1.append("moment: ");

							if (g.moment != null) { //

								strBuffer_tLogRow_1.append(FormatterUtils
										.format_Date(g.moment,
												"yyyy-MM-dd HH:mm:ss"));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("pid: ");

							if (g.pid != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.pid));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("root_pid: ");

							if (g.root_pid != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.root_pid));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("father_pid: ");

							if (g.father_pid != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.father_pid));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("project: ");

							if (g.project != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.project));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("job: ");

							if (g.job != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.job));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("context: ");

							if (g.context != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.context));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("priority: ");

							if (g.priority != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.priority));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("type: ");

							if (g.type != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.type));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("origin: ");

							if (g.origin != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.origin));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("message: ");

							if (g.message != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.message));

							} //

							strBuffer_tLogRow_1.append("|");

							strBuffer_tLogRow_1.append("code: ");

							if (g.code != null) { //

								strBuffer_tLogRow_1.append(String
										.valueOf(g.code));

							} //

							if (globalMap.get("tLogRow_CONSOLE") != null) {
								consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap
										.get("tLogRow_CONSOLE");
							} else {
								consoleOut_tLogRow_1 = new java.io.PrintStream(
										new java.io.BufferedOutputStream(
												System.out));
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

						} // End of branch "g"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_1 process_data_end ] start
						 */

						currentComponent = "tLogCatcher_1";

						/**
						 * [tLogCatcher_1 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_1 end ] start
						 */

						currentComponent = "tLogCatcher_1";

					}
				} catch (Exception e_tLogCatcher_1) {
					logIgnoredError(
							String.format(
									"tLogCatcher_1 - tLogCatcher failed to process log message(s) due to internal error: %s",
									e_tLogCatcher_1), e_tLogCatcher_1);
				}

				if (log.isDebugEnabled())
					log.debug("tLogCatcher_1 - " + ("Done."));

				ok_Hash.put("tLogCatcher_1", true);
				end_Hash.put("tLogCatcher_1", System.currentTimeMillis());

				/**
				 * [tLogCatcher_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

				// ###############################
				// # Lookup hashes releasing
				// ###############################
				log.debug("tMap_1 - Written records count in the table 'g': "
						+ count_g_tMap_1 + ".");

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
						runStat.updateStatOnConnection("g" + iterateId, 2, 0);
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

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tLogCatcher_1 finally ] start
				 */

				currentComponent = "tLogCatcher_1";

				/**
				 * [tLogCatcher_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
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

		globalMap.put("tLogCatcher_1_SUBPROCESS_STATE", 1);
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
		final log_test log_testClass = new log_test();

		int exitCode = log_testClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'log_test' - Done.");
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
		log.info("TalendJob: 'log_test' - Start.");

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
			java.io.InputStream inContext = log_test.class.getClassLoader()
					.getResourceAsStream(
							"serverless_etl/log_test_0_1/contexts/"
									+ contextStr + ".properties");
			if (inContext == null) {
				inContext = log_test.class
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
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : log_test");
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
 * 81243 characters generated by Talend Data Management Platform on the 8
 * January 2019 4:42:56 PM
 ************************************************************************************************/
