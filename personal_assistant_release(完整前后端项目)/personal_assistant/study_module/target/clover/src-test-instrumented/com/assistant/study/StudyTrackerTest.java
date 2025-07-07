/* $$ This file has been instrumented by Clover 4.5.1#20231029181002 $$ */package com.assistant.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class StudyTrackerTest {static class __CLR4_5_1bpbpmcor6lbg{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_5_1();if(20231029181002L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.5.1#20231029181002,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u0044\u003a\u005c\u005c\u004f\u006e\u0065\u0044\u0072\u0069\u0076\u0065\u005c\u005c\u684c\u9762\u005c\u005c\u8f6f\u6d4b\u5b9e\u9a8c\u005c\u005c\u0073\u0074\u0075\u0064\u0065\u006e\u0074\u0041\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005f\u0072\u0065\u006c\u0065\u0061\u0073\u0065\u0028\u5b8c\u6574\u524d\u540e\u7aef\u9879\u76ee\u0029\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0073\u0074\u0075\u0064\u0079\u005f\u006d\u006f\u0064\u0075\u006c\u0065\u005c\u005c\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1751629843532L,8589935092L,492,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_5_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    private StudyTracker studyTracker;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {try{__CLR4_5_1bpbpmcor6lbg.R.inc(421);
        __CLR4_5_1bpbpmcor6lbg.R.inc(422);studyTracker = new StudyTracker();
    }finally{__CLR4_5_1bpbpmcor6lbg.R.flushNeeded();}}

    @Test
    void testAddRecord() {__CLR4_5_1bpbpmcor6lbg.R.globalSliceStart(getClass().getName(),423);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1klzjfrbr();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1bpbpmcor6lbg.R.rethrow($CLV_t2$);}finally{__CLR4_5_1bpbpmcor6lbg.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyTrackerTest.testAddRecord",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),423,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1klzjfrbr(){try{__CLR4_5_1bpbpmcor6lbg.R.inc(423);
        __CLR4_5_1bpbpmcor6lbg.R.inc(424);StudyRecord record = new StudyRecord("user1", LocalDate.now(), "Math", 60);
        __CLR4_5_1bpbpmcor6lbg.R.inc(425);studyTracker.addRecord(record);
        __CLR4_5_1bpbpmcor6lbg.R.inc(426);assertEquals(1, studyTracker.getRecords().size());
        __CLR4_5_1bpbpmcor6lbg.R.inc(427);assertEquals(record, studyTracker.getRecords().get(0));
    }finally{__CLR4_5_1bpbpmcor6lbg.R.flushNeeded();}}

    @Test
    void testAddNullRecordThrowsException() {__CLR4_5_1bpbpmcor6lbg.R.globalSliceStart(getClass().getName(),428);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1w4i9iabw();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1bpbpmcor6lbg.R.rethrow($CLV_t2$);}finally{__CLR4_5_1bpbpmcor6lbg.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyTrackerTest.testAddNullRecordThrowsException",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),428,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1w4i9iabw(){try{__CLR4_5_1bpbpmcor6lbg.R.inc(428);
        __CLR4_5_1bpbpmcor6lbg.R.inc(429);IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            __CLR4_5_1bpbpmcor6lbg.R.inc(430);studyTracker.addRecord(null);
        });
        __CLR4_5_1bpbpmcor6lbg.R.inc(431);assertEquals("\u5b66\u4e60\u8bb0\u5f55\u4e0d\u80fd\u4e3a\u7a7a\u3002", thrown.getMessage());
    }finally{__CLR4_5_1bpbpmcor6lbg.R.flushNeeded();}}

    @Test
    void testGetRecordsByUser() {__CLR4_5_1bpbpmcor6lbg.R.globalSliceStart(getClass().getName(),432);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1888dndc0();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1bpbpmcor6lbg.R.rethrow($CLV_t2$);}finally{__CLR4_5_1bpbpmcor6lbg.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyTrackerTest.testGetRecordsByUser",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),432,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1888dndc0(){try{__CLR4_5_1bpbpmcor6lbg.R.inc(432);
        __CLR4_5_1bpbpmcor6lbg.R.inc(433);studyTracker.addRecord(new StudyRecord("user1", LocalDate.now(), "Math", 60));
        __CLR4_5_1bpbpmcor6lbg.R.inc(434);studyTracker.addRecord(new StudyRecord("user2", LocalDate.now(), "Physics", 90));
        __CLR4_5_1bpbpmcor6lbg.R.inc(435);studyTracker.addRecord(new StudyRecord("user1", LocalDate.now(), "Chemistry", 45));

        __CLR4_5_1bpbpmcor6lbg.R.inc(436);List<StudyRecord> user1Records = studyTracker.getRecordsByUser("user1");
        __CLR4_5_1bpbpmcor6lbg.R.inc(437);assertEquals(2, user1Records.size());
        __CLR4_5_1bpbpmcor6lbg.R.inc(438);assertTrue(user1Records.stream().allMatch(r -> r.getUsername().equals("user1")));

        __CLR4_5_1bpbpmcor6lbg.R.inc(439);List<StudyRecord> user3Records = studyTracker.getRecordsByUser("user3");
        __CLR4_5_1bpbpmcor6lbg.R.inc(440);assertTrue(user3Records.isEmpty());
    }finally{__CLR4_5_1bpbpmcor6lbg.R.flushNeeded();}}

    @Test
    void testGetWeeklyStudySummary() {__CLR4_5_1bpbpmcor6lbg.R.globalSliceStart(getClass().getName(),441);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1w5dfm1c9();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1bpbpmcor6lbg.R.rethrow($CLV_t2$);}finally{__CLR4_5_1bpbpmcor6lbg.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyTrackerTest.testGetWeeklyStudySummary",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),441,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1w5dfm1c9(){try{__CLR4_5_1bpbpmcor6lbg.R.inc(441);
        __CLR4_5_1bpbpmcor6lbg.R.inc(442);LocalDate date = LocalDate.of(2024, 7, 4); // A Thursday
        __CLR4_5_1bpbpmcor6lbg.R.inc(443);studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 60)); // Monday
        __CLR4_5_1bpbpmcor6lbg.R.inc(444);studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 4), "Physics", 90)); // Thursday
        __CLR4_5_1bpbpmcor6lbg.R.inc(445);studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 7), "Chemistry", 30)); // Sunday
        __CLR4_5_1bpbpmcor6lbg.R.inc(446);studyTracker.addRecord(new StudyRecord("user2", LocalDate.of(2024, 7, 4), "Biology", 120)); // Other user

        __CLR4_5_1bpbpmcor6lbg.R.inc(447);Map<LocalDate, Integer> summary = studyTracker.getWeeklyStudySummary(date, "user1");

        __CLR4_5_1bpbpmcor6lbg.R.inc(448);assertEquals(7, summary.size());
        __CLR4_5_1bpbpmcor6lbg.R.inc(449);assertEquals(60, summary.get(LocalDate.of(2024, 7, 1)));
        __CLR4_5_1bpbpmcor6lbg.R.inc(450);assertEquals(0, summary.get(LocalDate.of(2024, 7, 2)));
        __CLR4_5_1bpbpmcor6lbg.R.inc(451);assertEquals(0, summary.get(LocalDate.of(2024, 7, 3)));
        __CLR4_5_1bpbpmcor6lbg.R.inc(452);assertEquals(90, summary.get(LocalDate.of(2024, 7, 4)));
        __CLR4_5_1bpbpmcor6lbg.R.inc(453);assertEquals(0, summary.get(LocalDate.of(2024, 7, 5)));
        __CLR4_5_1bpbpmcor6lbg.R.inc(454);assertEquals(0, summary.get(LocalDate.of(2024, 7, 6)));
        __CLR4_5_1bpbpmcor6lbg.R.inc(455);assertEquals(30, summary.get(LocalDate.of(2024, 7, 7)));
    }finally{__CLR4_5_1bpbpmcor6lbg.R.flushNeeded();}}

    @Test
    void testGetWeeklySubjectSummary() {__CLR4_5_1bpbpmcor6lbg.R.globalSliceStart(getClass().getName(),456);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1gg63dyco();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1bpbpmcor6lbg.R.rethrow($CLV_t2$);}finally{__CLR4_5_1bpbpmcor6lbg.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyTrackerTest.testGetWeeklySubjectSummary",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),456,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1gg63dyco(){try{__CLR4_5_1bpbpmcor6lbg.R.inc(456);
        __CLR4_5_1bpbpmcor6lbg.R.inc(457);LocalDate date = LocalDate.of(2024, 7, 4); // A Thursday
        __CLR4_5_1bpbpmcor6lbg.R.inc(458);studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 1), "Math", 60));
        __CLR4_5_1bpbpmcor6lbg.R.inc(459);studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 4), "Physics", 90));
        __CLR4_5_1bpbpmcor6lbg.R.inc(460);studyTracker.addRecord(new StudyRecord("user1", LocalDate.of(2024, 7, 4), "Math", 30));
        __CLR4_5_1bpbpmcor6lbg.R.inc(461);studyTracker.addRecord(new StudyRecord("user2", LocalDate.of(2024, 7, 4), "Biology", 120));

        __CLR4_5_1bpbpmcor6lbg.R.inc(462);Map<String, Integer> summary = studyTracker.getWeeklySubjectSummary(date, "user1");

        __CLR4_5_1bpbpmcor6lbg.R.inc(463);assertEquals(2, summary.size());
        __CLR4_5_1bpbpmcor6lbg.R.inc(464);assertEquals(90, summary.get("Math"));
        __CLR4_5_1bpbpmcor6lbg.R.inc(465);assertEquals(90, summary.get("Physics"));
        __CLR4_5_1bpbpmcor6lbg.R.inc(466);assertNull(summary.get("Biology"));
    }finally{__CLR4_5_1bpbpmcor6lbg.R.flushNeeded();}}

    @Test
    void testGetRecentDaysSummary() {__CLR4_5_1bpbpmcor6lbg.R.globalSliceStart(getClass().getName(),467);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_17mgmrbcz();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1bpbpmcor6lbg.R.rethrow($CLV_t2$);}finally{__CLR4_5_1bpbpmcor6lbg.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyTrackerTest.testGetRecentDaysSummary",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),467,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_17mgmrbcz(){try{__CLR4_5_1bpbpmcor6lbg.R.inc(467);
        __CLR4_5_1bpbpmcor6lbg.R.inc(468);LocalDate today = LocalDate.now();
        __CLR4_5_1bpbpmcor6lbg.R.inc(469);studyTracker.addRecord(new StudyRecord("user1", today, "Math", 60));
        __CLR4_5_1bpbpmcor6lbg.R.inc(470);studyTracker.addRecord(new StudyRecord("user1", today.minusDays(1), "Physics", 90));
        __CLR4_5_1bpbpmcor6lbg.R.inc(471);studyTracker.addRecord(new StudyRecord("user1", today.minusDays(2), "Chemistry", 30));
        __CLR4_5_1bpbpmcor6lbg.R.inc(472);studyTracker.addRecord(new StudyRecord("user1", today.minusDays(5), "Biology", 120)); // Outside 3 days

        __CLR4_5_1bpbpmcor6lbg.R.inc(473);Map<LocalDate, Integer> summary = studyTracker.getRecentDaysSummary(3, "user1");

        __CLR4_5_1bpbpmcor6lbg.R.inc(474);assertEquals(3, summary.size());
        __CLR4_5_1bpbpmcor6lbg.R.inc(475);assertEquals(30, summary.get(today.minusDays(2)));
        __CLR4_5_1bpbpmcor6lbg.R.inc(476);assertEquals(90, summary.get(today.minusDays(1)));
        __CLR4_5_1bpbpmcor6lbg.R.inc(477);assertEquals(60, summary.get(today));
        __CLR4_5_1bpbpmcor6lbg.R.inc(478);assertNull(summary.get(today.minusDays(5)));
    }finally{__CLR4_5_1bpbpmcor6lbg.R.flushNeeded();}}

    @Test
    void testLoadAndSaveToCSV() throws IOException {__CLR4_5_1bpbpmcor6lbg.R.globalSliceStart(getClass().getName(),479);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_12e12c6db();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1bpbpmcor6lbg.R.rethrow($CLV_t2$);}finally{__CLR4_5_1bpbpmcor6lbg.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyTrackerTest.testLoadAndSaveToCSV",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),479,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_12e12c6db() throws IOException{try{__CLR4_5_1bpbpmcor6lbg.R.inc(479);
        __CLR4_5_1bpbpmcor6lbg.R.inc(480);Path csvFile = tempDir.resolve("study_records.csv");

        __CLR4_5_1bpbpmcor6lbg.R.inc(481);studyTracker.addRecord(new StudyRecord("user1", LocalDate.now(), "Math", 60));
        __CLR4_5_1bpbpmcor6lbg.R.inc(482);studyTracker.addRecord(new StudyRecord("user2", LocalDate.now(), "Physics", 90));

        __CLR4_5_1bpbpmcor6lbg.R.inc(483);studyTracker.saveToCSV(csvFile.toString());

        __CLR4_5_1bpbpmcor6lbg.R.inc(484);StudyTracker newTracker = new StudyTracker();
        __CLR4_5_1bpbpmcor6lbg.R.inc(485);newTracker.loadFromCSV(csvFile.toString());

        __CLR4_5_1bpbpmcor6lbg.R.inc(486);assertEquals(2, newTracker.getRecords().size());
        __CLR4_5_1bpbpmcor6lbg.R.inc(487);assertEquals("user1", newTracker.getRecords().get(0).getUsername());
        __CLR4_5_1bpbpmcor6lbg.R.inc(488);assertEquals("Physics", newTracker.getRecords().get(1).getSubject());
    }finally{__CLR4_5_1bpbpmcor6lbg.R.flushNeeded();}}

    @Test
    void testLoadFromNonExistentCSV() {__CLR4_5_1bpbpmcor6lbg.R.globalSliceStart(getClass().getName(),489);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1koor0ydl();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1bpbpmcor6lbg.R.rethrow($CLV_t2$);}finally{__CLR4_5_1bpbpmcor6lbg.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyTrackerTest.testLoadFromNonExistentCSV",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),489,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1koor0ydl(){try{__CLR4_5_1bpbpmcor6lbg.R.inc(489);
        __CLR4_5_1bpbpmcor6lbg.R.inc(490);Path nonExistentFile = tempDir.resolve("non_existent.csv");
        __CLR4_5_1bpbpmcor6lbg.R.inc(491);assertThrows(IOException.class, () -> studyTracker.loadFromCSV(nonExistentFile.toString()));
    }finally{__CLR4_5_1bpbpmcor6lbg.R.flushNeeded();}}
}


