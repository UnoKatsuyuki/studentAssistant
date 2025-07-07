/* $$ This file has been instrumented by Clover 4.5.1#20231029181002 $$ */package com.assistant.study;

import java.time.LocalDate;

public class StudyRecord {public static class __CLR4_5_1llmcor6l4n{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_5_1();if(20231029181002L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.5.1#20231029181002,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u0044\u003a\u005c\u005c\u004f\u006e\u0065\u0044\u0072\u0069\u0076\u0065\u005c\u005c\u684c\u9762\u005c\u005c\u8f6f\u6d4b\u5b9e\u9a8c\u005c\u005c\u0073\u0074\u0075\u0064\u0065\u006e\u0074\u0041\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005f\u0072\u0065\u006c\u0065\u0061\u0073\u0065\u0028\u5b8c\u6574\u524d\u540e\u7aef\u9879\u76ee\u0029\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0073\u0074\u0075\u0064\u0079\u005f\u006d\u006f\u0064\u0075\u006c\u0065\u005c\u005c\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1751629843218L,8589935092L,48,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_5_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;
    private String username;
    private LocalDate date;
    private String subject;
    private int durationMinutes;

    public StudyRecord(String username, LocalDate date, String subject, int durationMinutes) {try{__CLR4_5_1llmcor6l4n.R.inc(21);
        __CLR4_5_1llmcor6l4n.R.inc(22);if ((((durationMinutes <= 0)&&(__CLR4_5_1llmcor6l4n.R.iget(23)!=0|true))||(__CLR4_5_1llmcor6l4n.R.iget(24)==0&false))) {{
            __CLR4_5_1llmcor6l4n.R.inc(25);throw new IllegalArgumentException("\u5b66\u4e60\u65f6\u957f\u5fc5\u987b\u5927\u4e8e0\u5206\u949f\u3002");
        }
        }__CLR4_5_1llmcor6l4n.R.inc(26);this.username = username;
        __CLR4_5_1llmcor6l4n.R.inc(27);this.date = date;
        __CLR4_5_1llmcor6l4n.R.inc(28);this.subject = subject;
        __CLR4_5_1llmcor6l4n.R.inc(29);this.durationMinutes = durationMinutes;
    }finally{__CLR4_5_1llmcor6l4n.R.flushNeeded();}}

    public String getUsername() {try{__CLR4_5_1llmcor6l4n.R.inc(30);
        __CLR4_5_1llmcor6l4n.R.inc(31);return username;
    }finally{__CLR4_5_1llmcor6l4n.R.flushNeeded();}}

    public LocalDate getDate() {try{__CLR4_5_1llmcor6l4n.R.inc(32);
        __CLR4_5_1llmcor6l4n.R.inc(33);return date;
    }finally{__CLR4_5_1llmcor6l4n.R.flushNeeded();}}

    public String getSubject() {try{__CLR4_5_1llmcor6l4n.R.inc(34);
        __CLR4_5_1llmcor6l4n.R.inc(35);return subject;
    }finally{__CLR4_5_1llmcor6l4n.R.flushNeeded();}}

    public int getDurationMinutes() {try{__CLR4_5_1llmcor6l4n.R.inc(36);
        __CLR4_5_1llmcor6l4n.R.inc(37);return durationMinutes;
    }finally{__CLR4_5_1llmcor6l4n.R.flushNeeded();}}

    @Override
    public String toString() {try{__CLR4_5_1llmcor6l4n.R.inc(38);
        __CLR4_5_1llmcor6l4n.R.inc(39);return "StudyRecord{" +
               "username='" + username + '\'' +
               ", date=" + date +
               ", subject='" + subject + '\'' +
               ", durationMinutes=" + durationMinutes +
               '}';
    }finally{__CLR4_5_1llmcor6l4n.R.flushNeeded();}}

    public String[] toCSVRow() {try{__CLR4_5_1llmcor6l4n.R.inc(40);
        __CLR4_5_1llmcor6l4n.R.inc(41);return new String[] {
            username,
            date.toString(),
            subject,
            String.valueOf(durationMinutes)
        };
    }finally{__CLR4_5_1llmcor6l4n.R.flushNeeded();}}

    public static StudyRecord fromCSVRow(String[] row) {try{__CLR4_5_1llmcor6l4n.R.inc(42);
        __CLR4_5_1llmcor6l4n.R.inc(43);if ((((row.length != 4)&&(__CLR4_5_1llmcor6l4n.R.iget(44)!=0|true))||(__CLR4_5_1llmcor6l4n.R.iget(45)==0&false))) {__CLR4_5_1llmcor6l4n.R.inc(46);throw new IllegalArgumentException("CSV\u884c\u683c\u5f0f\u9519\u8bef");
        }__CLR4_5_1llmcor6l4n.R.inc(47);return new StudyRecord(
            row[0],
            LocalDate.parse(row[1]),
            row[2],
            Integer.parseInt(row[3])
        );
    }finally{__CLR4_5_1llmcor6l4n.R.flushNeeded();}}
}


