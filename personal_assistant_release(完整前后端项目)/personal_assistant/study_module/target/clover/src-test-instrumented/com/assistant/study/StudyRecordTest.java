/* $$ This file has been instrumented by Clover 4.5.1#20231029181002 $$ */
package com.assistant.study;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class StudyRecordTest {static class __CLR4_5_1aoaomcor6laq{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_5_1();if(20231029181002L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.5.1#20231029181002,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u0044\u003a\u005c\u005c\u004f\u006e\u0065\u0044\u0072\u0069\u0076\u0065\u005c\u005c\u684c\u9762\u005c\u005c\u8f6f\u6d4b\u5b9e\u9a8c\u005c\u005c\u0073\u0074\u0075\u0064\u0065\u006e\u0074\u0041\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005f\u0072\u0065\u006c\u0065\u0061\u0073\u0065\u0028\u5b8c\u6574\u524d\u540e\u7aef\u9879\u76ee\u0029\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0073\u0074\u0075\u0064\u0079\u005f\u006d\u006f\u0064\u0075\u006c\u0065\u005c\u005c\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1751629843532L,8589935092L,421,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_5_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    @Test
    void testStudyRecordCreation() {__CLR4_5_1aoaomcor6laq.R.globalSliceStart(getClass().getName(),384);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1lf06c2ao();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1aoaomcor6laq.R.rethrow($CLV_t2$);}finally{__CLR4_5_1aoaomcor6laq.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyRecordTest.testStudyRecordCreation",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),384,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1lf06c2ao(){try{__CLR4_5_1aoaomcor6laq.R.inc(384);
        __CLR4_5_1aoaomcor6laq.R.inc(385);StudyRecord record = new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 60);
        __CLR4_5_1aoaomcor6laq.R.inc(386);assertNotNull(record);
        __CLR4_5_1aoaomcor6laq.R.inc(387);assertEquals("user1", record.getUsername());
        __CLR4_5_1aoaomcor6laq.R.inc(388);assertEquals(LocalDate.of(2024, 7, 1), record.getDate());
        __CLR4_5_1aoaomcor6laq.R.inc(389);assertEquals("Math", record.getSubject());
        __CLR4_5_1aoaomcor6laq.R.inc(390);assertEquals(60, record.getDurationMinutes());
    }finally{__CLR4_5_1aoaomcor6laq.R.flushNeeded();}}

    @Test
    void testStudyRecordCreationWithInvalidDuration() {__CLR4_5_1aoaomcor6laq.R.globalSliceStart(getClass().getName(),391);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1h5dm63av();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1aoaomcor6laq.R.rethrow($CLV_t2$);}finally{__CLR4_5_1aoaomcor6laq.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyRecordTest.testStudyRecordCreationWithInvalidDuration",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),391,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1h5dm63av(){try{__CLR4_5_1aoaomcor6laq.R.inc(391);
        __CLR4_5_1aoaomcor6laq.R.inc(392);IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            __CLR4_5_1aoaomcor6laq.R.inc(393);new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 0);
        });
        __CLR4_5_1aoaomcor6laq.R.inc(394);assertEquals("\u5b66\u4e60\u65f6\u957f\u5fc5\u987b\u5927\u4e8e0\u5206\u949f\u3002", thrown.getMessage());
    }finally{__CLR4_5_1aoaomcor6laq.R.flushNeeded();}}

    @Test
    void testToCSVRow() {__CLR4_5_1aoaomcor6laq.R.globalSliceStart(getClass().getName(),395);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_16bzd20az();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1aoaomcor6laq.R.rethrow($CLV_t2$);}finally{__CLR4_5_1aoaomcor6laq.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyRecordTest.testToCSVRow",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),395,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_16bzd20az(){try{__CLR4_5_1aoaomcor6laq.R.inc(395);
        __CLR4_5_1aoaomcor6laq.R.inc(396);StudyRecord record = new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 60);
        __CLR4_5_1aoaomcor6laq.R.inc(397);String[] csvRow = record.toCSVRow();
        __CLR4_5_1aoaomcor6laq.R.inc(398);assertNotNull(csvRow);
        __CLR4_5_1aoaomcor6laq.R.inc(399);assertEquals(4, csvRow.length);
        __CLR4_5_1aoaomcor6laq.R.inc(400);assertEquals("user1", csvRow[0]);
        __CLR4_5_1aoaomcor6laq.R.inc(401);assertEquals("2024-07-01", csvRow[1]);
        __CLR4_5_1aoaomcor6laq.R.inc(402);assertEquals("Math", csvRow[2]);
        __CLR4_5_1aoaomcor6laq.R.inc(403);assertEquals("60", csvRow[3]);
    }finally{__CLR4_5_1aoaomcor6laq.R.flushNeeded();}}

    @Test
    void testFromCSVRow() {__CLR4_5_1aoaomcor6laq.R.globalSliceStart(getClass().getName(),404);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1pp99vtb8();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1aoaomcor6laq.R.rethrow($CLV_t2$);}finally{__CLR4_5_1aoaomcor6laq.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyRecordTest.testFromCSVRow",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),404,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1pp99vtb8(){try{__CLR4_5_1aoaomcor6laq.R.inc(404);
        __CLR4_5_1aoaomcor6laq.R.inc(405);String[] csvRow = {"user2", "2024-07-02", "Physics", "90"};
        __CLR4_5_1aoaomcor6laq.R.inc(406);StudyRecord record = StudyRecord.fromCSVRow(csvRow);
        __CLR4_5_1aoaomcor6laq.R.inc(407);assertNotNull(record);
        __CLR4_5_1aoaomcor6laq.R.inc(408);assertEquals("user2", record.getUsername());
        __CLR4_5_1aoaomcor6laq.R.inc(409);assertEquals(LocalDate.of(2024, 7, 2), record.getDate());
        __CLR4_5_1aoaomcor6laq.R.inc(410);assertEquals("Physics", record.getSubject());
        __CLR4_5_1aoaomcor6laq.R.inc(411);assertEquals(90, record.getDurationMinutes());
    }finally{__CLR4_5_1aoaomcor6laq.R.flushNeeded();}}

    @Test
    void testFromCSVRowWithInvalidFormat() {__CLR4_5_1aoaomcor6laq.R.globalSliceStart(getClass().getName(),412);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1lekzfjbg();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1aoaomcor6laq.R.rethrow($CLV_t2$);}finally{__CLR4_5_1aoaomcor6laq.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyRecordTest.testFromCSVRowWithInvalidFormat",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),412,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1lekzfjbg(){try{__CLR4_5_1aoaomcor6laq.R.inc(412);
        __CLR4_5_1aoaomcor6laq.R.inc(413);String[] csvRow = {"user2", "2024-07-02", "Physics"};
        __CLR4_5_1aoaomcor6laq.R.inc(414);IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            __CLR4_5_1aoaomcor6laq.R.inc(415);StudyRecord.fromCSVRow(csvRow);
        });
        __CLR4_5_1aoaomcor6laq.R.inc(416);assertEquals("CSV\u884c\u683c\u5f0f\u9519\u8bef", thrown.getMessage());
    }finally{__CLR4_5_1aoaomcor6laq.R.flushNeeded();}}

    @Test
    void testToString() {__CLR4_5_1aoaomcor6laq.R.globalSliceStart(getClass().getName(),417);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1hrxdidbl();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1aoaomcor6laq.R.rethrow($CLV_t2$);}finally{__CLR4_5_1aoaomcor6laq.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyRecordTest.testToString",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),417,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1hrxdidbl(){try{__CLR4_5_1aoaomcor6laq.R.inc(417);
        __CLR4_5_1aoaomcor6laq.R.inc(418);StudyRecord record = new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 60);
        __CLR4_5_1aoaomcor6laq.R.inc(419);String expected = "StudyRecord{username=\'user1\', date=2024-07-01, subject=\'Math\', durationMinutes=60}";
        __CLR4_5_1aoaomcor6laq.R.inc(420);assertEquals(expected, record.toString());
    }finally{__CLR4_5_1aoaomcor6laq.R.flushNeeded();}}
}


