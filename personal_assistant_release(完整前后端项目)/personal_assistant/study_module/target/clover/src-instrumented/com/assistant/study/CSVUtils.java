/* $$ This file has been instrumented by Clover 4.5.1#20231029181002 $$ */package com.assistant.study;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {public static class __CLR4_5_100mcor6l3h{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_5_1();if(20231029181002L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.5.1#20231029181002,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u0044\u003a\u005c\u005c\u004f\u006e\u0065\u0044\u0072\u0069\u0076\u0065\u005c\u005c\u684c\u9762\u005c\u005c\u8f6f\u6d4b\u5b9e\u9a8c\u005c\u005c\u0073\u0074\u0075\u0064\u0065\u006e\u0074\u0041\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005f\u0072\u0065\u006c\u0065\u0061\u0073\u0065\u0028\u5b8c\u6574\u524d\u540e\u7aef\u9879\u76ee\u0029\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0073\u0074\u0075\u0064\u0079\u005f\u006d\u006f\u0064\u0075\u006c\u0065\u005c\u005c\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1751629843218L,8589935092L,21,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_5_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;
    public static List<String[]> readCSV(String filePath) throws IOException {try{__CLR4_5_100mcor6l3h.R.inc(0);
        __CLR4_5_100mcor6l3h.R.inc(1);List<String[]> records = new ArrayList<>();
        __CLR4_5_100mcor6l3h.R.inc(2);File file = new File(filePath);
        __CLR4_5_100mcor6l3h.R.inc(3);if ((((!file.exists())&&(__CLR4_5_100mcor6l3h.R.iget(4)!=0|true))||(__CLR4_5_100mcor6l3h.R.iget(5)==0&false))) {{
            __CLR4_5_100mcor6l3h.R.inc(6);throw new IOException("\u6587\u4ef6\u4e0d\u5b58\u5728: " + filePath);
        }
        }class __CLR4_5_1$AC0 implements java.lang.AutoCloseable {public void close(){}}; __CLR4_5_100mcor6l3h.R.inc(7);try (__CLR4_5_1$AC0 __CLR$ACI0=new __CLR4_5_1$AC0(){{__CLR4_5_100mcor6l3h.R.inc(8);}};BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            __CLR4_5_100mcor6l3h.R.inc(9);String line;
            __CLR4_5_100mcor6l3h.R.inc(10);while ((line = br.readLine()) != null) {{
                __CLR4_5_100mcor6l3h.R.inc(13);records.add(line.split(",", -1));
            }
        }}
        __CLR4_5_100mcor6l3h.R.inc(14);return records;
    }finally{__CLR4_5_100mcor6l3h.R.flushNeeded();}}

    public static void writeCSV(String filePath, List<String[]> data) throws IOException {try{__CLR4_5_100mcor6l3h.R.inc(15);
        class __CLR4_5_1$AC1 implements java.lang.AutoCloseable {public void close(){}}; __CLR4_5_100mcor6l3h.R.inc(16);try (__CLR4_5_1$AC1 __CLR$ACI1=new __CLR4_5_1$AC1(){{__CLR4_5_100mcor6l3h.R.inc(17);}};BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            __CLR4_5_100mcor6l3h.R.inc(18);for (String[] row : data) {{
                __CLR4_5_100mcor6l3h.R.inc(19);bw.write(String.join(",", row));
                __CLR4_5_100mcor6l3h.R.inc(20);bw.newLine();
            }
        }}
    }finally{__CLR4_5_100mcor6l3h.R.flushNeeded();}}
} 