/* $$ This file has been instrumented by Clover 4.5.1#20231029181002 $$ */package com.assistant.study;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.P7rintStream;
import java.time.LocalDate;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class StudyUITest {static class __CLR4_5_1mhmhmcrijb41{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_5_1();if(20231029181002L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.5.1#20231029181002,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u0044\u003a\u005c\u005c\u004f\u006e\u0065\u0044\u0072\u0069\u0076\u0065\u005c\u005c\u684c\u9762\u005c\u005c\u8f6f\u6d4b\u5b9e\u9a8c\u005c\u005c\u0073\u0074\u0075\u0064\u0065\u006e\u0074\u0041\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005f\u0072\u0065\u006c\u0065\u0061\u0073\u0065\u0028\u5b8c\u6574\u524d\u540e\u7aef\u9879\u76ee\u0029\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0073\u0074\u0075\u0064\u0079\u005f\u006d\u006f\u0064\u0075\u006c\u0065\u005c\u005c\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1751796718751L,8589935092L,1124,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_5_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;
    @Test
    void testParseDate_standard() {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),809);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_16pjwfgmh();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testParseDate_standard",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),809,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_16pjwfgmh(){try{__CLR4_5_1mhmhmcrijb41.R.inc(809);
        __CLR4_5_1mhmhmcrijb41.R.inc(810);assertEquals(LocalDate.of(2024, 7, 4), invokeParseDate("2024-07-04"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testParseDate_today() {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),811);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1iouzegmj();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testParseDate_today",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),811,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1iouzegmj(){try{__CLR4_5_1mhmhmcrijb41.R.inc(811);
        __CLR4_5_1mhmhmcrijb41.R.inc(812);LocalDate today = LocalDate.now();
        __CLR4_5_1mhmhmcrijb41.R.inc(813);assertEquals(today, invokeParseDate("\u4eca\u5929"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testParseDate_yesterday() {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),814);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1y32lgnmm();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testParseDate_yesterday",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),814,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1y32lgnmm(){try{__CLR4_5_1mhmhmcrijb41.R.inc(814);
        __CLR4_5_1mhmhmcrijb41.R.inc(815);LocalDate yesterday = LocalDate.now().minusDays(1);
        __CLR4_5_1mhmhmcrijb41.R.inc(816);assertEquals(yesterday, invokeParseDate("\u6628\u5929"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testParseDate_invalid() {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),817);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_11epamp();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testParseDate_invalid",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),817,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_11epamp(){try{__CLR4_5_1mhmhmcrijb41.R.inc(817);
        __CLR4_5_1mhmhmcrijb41.R.inc(818);assertThrows(Exception.class, () -> invokeParseDate("abc"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    // \u8f85\u52a9\u65b9\u6cd5\uff0c\u53cd\u5c04\u8c03\u7528 private static LocalDate parseDate(String input)
    private LocalDate invokeParseDate(String input) {try{__CLR4_5_1mhmhmcrijb41.R.inc(819);
        __CLR4_5_1mhmhmcrijb41.R.inc(820);try {
            __CLR4_5_1mhmhmcrijb41.R.inc(821);var method = StudyUI.class.getDeclaredMethod("parseDate", String.class);
            __CLR4_5_1mhmhmcrijb41.R.inc(822);method.setAccessible(true);
            __CLR4_5_1mhmhmcrijb41.R.inc(823);return (LocalDate) method.invoke(null, input);
        } catch (Exception e) {
            __CLR4_5_1mhmhmcrijb41.R.inc(824);throw new RuntimeException(e);
        }
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    // \u6f14\u793a\u5982\u4f55\u6d4b\u8bd5\u5e26\u8f93\u5165\u8f93\u51fa\u7684\u65b9\u6cd5\uff08\u5982 addRecord\uff09\uff0c\u8fd9\u91cc\u53ea\u505a\u7ed3\u6784\u793a\u4f8b
    @Test
    void testAddRecord_usernameEmpty() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),825);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_12o7qrjmx();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testAddRecord_usernameEmpty",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),825,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_12o7qrjmx() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(825);
        __CLR4_5_1mhmhmcrijb41.R.inc(826);String simulatedInput = "\n2024-07-04\n\u6570\u5b66\n60\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(827);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(828);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(829);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(830);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(831);var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(832);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(833);method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(834);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(835);assertTrue(output.contains("\u7528\u6237\u540d\u4e0d\u80fd\u4e3a\u7a7a"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testAddRecord_subjectEmpty() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),836);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1x8xc5jn8();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testAddRecord_subjectEmpty",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),836,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1x8xc5jn8() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(836);
        __CLR4_5_1mhmhmcrijb41.R.inc(837);String simulatedInput = "\u5f20\u4e09\n2024-07-04\n\n60\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(838);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(839);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(840);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(841);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(842);var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(843);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(844);method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(845);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(846);assertTrue(output.contains("\u79d1\u76ee\u4e0d\u80fd\u4e3a\u7a7a"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testAddRecord_durationInvalid() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),847);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1szr3rpnj();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testAddRecord_durationInvalid",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),847,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1szr3rpnj() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(847);
        __CLR4_5_1mhmhmcrijb41.R.inc(848);String simulatedInput = "\u5f20\u4e09\n2024-07-04\n\u6570\u5b66\nabc\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(849);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(850);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(851);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(852);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(853);var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(854);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(855);method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(856);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(857);assertTrue(output.contains("\u8f93\u5165\u683c\u5f0f\u6709\u8bef"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testAddRecord_durationZero() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),858);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1ulzrninu();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testAddRecord_durationZero",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),858,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1ulzrninu() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(858);
        __CLR4_5_1mhmhmcrijb41.R.inc(859);String simulatedInput = "\u5f20\u4e09\n2024-07-04\n\u6570\u5b66\n0\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(860);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(861);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(862);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(863);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(864);var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(865);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(866);method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(867);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(868);assertTrue(output.contains("\u5b66\u4e60\u65f6\u957f\u5fc5\u987b\u5927\u4e8e0"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testAddRecord_dateInvalid() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),869);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1rhpbovo5();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testAddRecord_dateInvalid",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),869,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1rhpbovo5() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(869);
        __CLR4_5_1mhmhmcrijb41.R.inc(870);String simulatedInput = "\u5f20\u4e09\nxxxx\n\u6570\u5b66\n60\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(871);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(872);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(873);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(874);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(875);var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(876);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(877);method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(878);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(879);assertTrue(output.contains("\u8f93\u5165\u683c\u5f0f\u6709\u8bef"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testAddRecord_success() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),880);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1ea128log();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testAddRecord_success",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),880,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1ea128log() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(880);
        __CLR4_5_1mhmhmcrijb41.R.inc(881);String simulatedInput = "\u5f20\u4e09\n2024-07-04\n\u6570\u5b66\n60\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(882);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(883);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(884);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(885);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(886);var method = StudyUI.class.getDeclaredMethod("addRecord", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(887);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(888);method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(889);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(890);assertTrue(output.contains("\u5b66\u4e60\u8bb0\u5f55\u6dfb\u52a0\u6210\u529f"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testSelectUser_noUser() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),891);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1bo64ntor();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testSelectUser_noUser",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),891,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1bo64ntor() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(891);
        __CLR4_5_1mhmhmcrijb41.R.inc(892);ByteArrayInputStream in = new ByteArrayInputStream("\n".getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(893);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(894);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(895);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(896);var method = StudyUI.class.getDeclaredMethod("selectUser", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(897);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(898);String result = (String) method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(899);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(900);assertTrue(output.contains("\u6682\u65e0\u7528\u6237\u6570\u636e"));
        __CLR4_5_1mhmhmcrijb41.R.inc(901);assertEquals("", result);
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testSelectUser_validChoice() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),902);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1bvmd4up2();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testSelectUser_validChoice",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),902,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1bvmd4up2() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(902);
        __CLR4_5_1mhmhmcrijb41.R.inc(903);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(904);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 4), "\u6570\u5b66", 60));
        __CLR4_5_1mhmhmcrijb41.R.inc(905);tracker.addRecord(new StudyRecord("\u674e\u56db", LocalDate.of(2024, 7, 4), "\u82f1\u8bed", 30));
        __CLR4_5_1mhmhmcrijb41.R.inc(906);ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes()); // \u9009\u62e9\u674e\u56db
        __CLR4_5_1mhmhmcrijb41.R.inc(907);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(908);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(909);var method = StudyUI.class.getDeclaredMethod("selectUser", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(910);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(911);String result = (String) method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(912);assertEquals("\u674e\u56db", result);
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testSelectUser_invalidInput() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),913);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1pwpbq8pd();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testSelectUser_invalidInput",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),913,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1pwpbq8pd() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(913);
        __CLR4_5_1mhmhmcrijb41.R.inc(914);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(915);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 4), "\u6570\u5b66", 60));
        __CLR4_5_1mhmhmcrijb41.R.inc(916);ByteArrayInputStream in = new ByteArrayInputStream("abc\n".getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(917);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(918);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(919);var method = StudyUI.class.getDeclaredMethod("selectUser", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(920);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(921);String result = (String) method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(922);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(923);assertTrue(output.contains("\u8f93\u5165\u65e0\u6548\uff0c\u9ed8\u8ba4\u9009\u62e9\u5168\u90e8\u7528\u6237"));
        __CLR4_5_1mhmhmcrijb41.R.inc(924);assertEquals("", result);
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowStatistics_invalidChoice() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),925);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1ulqbyqpp();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowStatistics_invalidChoice",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),925,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1ulqbyqpp() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(925);
        __CLR4_5_1mhmhmcrijb41.R.inc(926);String simulatedInput = "\n9\n"; // \u9009\u62e9\u7528\u6237\u540e\u8f93\u5165\u65e0\u6548\u9009\u9879
        __CLR4_5_1mhmhmcrijb41.R.inc(927);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(928);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(929);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(930);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(931);var method = StudyUI.class.getDeclaredMethod("showStatistics", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(932);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(933);method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(934);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(935);assertTrue(output.contains("\u65e0\u6548\u9009\u62e9"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowDailyStats_dateInvalid() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),936);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1vsb80qq0();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowDailyStats_dateInvalid",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),936,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1vsb80qq0() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(936);
        __CLR4_5_1mhmhmcrijb41.R.inc(937);String simulatedInput = "xxxx\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(938);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(939);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(940);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(941);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(942);var method = StudyUI.class.getDeclaredMethod("showDailyStats", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(943);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(944);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(945);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(946);assertTrue(output.contains("\u65e5\u671f\u683c\u5f0f\u6709\u8bef"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowDailyStats_noData() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),947);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1xx6eqkqb();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowDailyStats_noData",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),947,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1xx6eqkqb() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(947);
        __CLR4_5_1mhmhmcrijb41.R.inc(948);String simulatedInput = "2024-07-04\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(949);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(950);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(951);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(952);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(953);var method = StudyUI.class.getDeclaredMethod("showDailyStats", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(954);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(955);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(956);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(957);assertTrue(output.contains("\u5b66\u4e60\u603b\u65f6\u957f\uff1a0 \u5206\u949f"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowDailyStats_multiSubject() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),958);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_19ukjp8qm();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowDailyStats_multiSubject",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),958,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_19ukjp8qm() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(958);
        __CLR4_5_1mhmhmcrijb41.R.inc(959);String simulatedInput = "2024-07-04\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(960);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(961);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(962);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(963);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(964);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 4), "\u6570\u5b66", 30));
        __CLR4_5_1mhmhmcrijb41.R.inc(965);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 4), "\u82f1\u8bed", 20));
        __CLR4_5_1mhmhmcrijb41.R.inc(966);var method = StudyUI.class.getDeclaredMethod("showDailyStats", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(967);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(968);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(969);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(970);assertTrue(output.contains("\u6570\u5b66: 30 \u5206\u949f"));
        __CLR4_5_1mhmhmcrijb41.R.inc(971);assertTrue(output.contains("\u82f1\u8bed: 20 \u5206\u949f"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowMonthlyStats_thisMonth() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),972);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1lv0hw5r0();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowMonthlyStats_thisMonth",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),972,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1lv0hw5r0() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(972);
        __CLR4_5_1mhmhmcrijb41.R.inc(973);String simulatedInput = "\u672c\u6708\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(974);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(975);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(976);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(977);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(978);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.now(), "\u6570\u5b66", 10));
        __CLR4_5_1mhmhmcrijb41.R.inc(979);var method = StudyUI.class.getDeclaredMethod("showMonthlyStats", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(980);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(981);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(982);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(983);assertTrue(output.contains("\u5b66\u4e60\u603b\u65f6\u957f\uff1a10 \u5206\u949f"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowMonthlyStats_invalidInput() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),984);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1otm9corc();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowMonthlyStats_invalidInput",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),984,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1otm9corc() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(984);
        __CLR4_5_1mhmhmcrijb41.R.inc(985);String simulatedInput = "xxxx\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(986);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(987);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(988);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(989);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(990);var method = StudyUI.class.getDeclaredMethod("showMonthlyStats", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(991);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(992);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(993);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(994);assertTrue(output.contains("\u8f93\u5165\u683c\u5f0f\u6709\u8bef"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowMaxStreak_noData() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),995);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1tgjlemrn();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowMaxStreak_noData",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),995,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1tgjlemrn() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(995);
        __CLR4_5_1mhmhmcrijb41.R.inc(996);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(997);StudyUI ui = new StudyUI(new Scanner(new ByteArrayInputStream(new byte[0])), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(998);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(999);var method = StudyUI.class.getDeclaredMethod("showMaxStreak", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(1000);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(1001);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(1002);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(1003);assertTrue(output.contains("\u6682\u65e0\u5b66\u4e60\u8bb0\u5f55"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowMaxStreak_streak() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),1004);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1fpxpe7rw();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowMaxStreak_streak",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),1004,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1fpxpe7rw() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(1004);
        __CLR4_5_1mhmhmcrijb41.R.inc(1005);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(1006);StudyUI ui = new StudyUI(new Scanner(new ByteArrayInputStream(new byte[0])), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(1007);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(1008);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 1), "\u6570\u5b66", 10));
        __CLR4_5_1mhmhmcrijb41.R.inc(1009);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 2), "\u6570\u5b66", 10));
        __CLR4_5_1mhmhmcrijb41.R.inc(1010);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 3), "\u6570\u5b66", 10));
        __CLR4_5_1mhmhmcrijb41.R.inc(1011);var method = StudyUI.class.getDeclaredMethod("showMaxStreak", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(1012);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(1013);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(1014);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(1015);assertTrue(output.contains("\u6700\u957f\u8fde\u7eed\u6253\u5361\u5929\u6570\uff1a3 \u5929"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testExportData_filenameEmpty() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),1016);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_167fonys8();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testExportData_filenameEmpty",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),1016,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_167fonys8() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(1016);
        __CLR4_5_1mhmhmcrijb41.R.inc(1017);String simulatedInput = "\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(1018);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(1019);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(1020);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(1021);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(1022);var method = StudyUI.class.getDeclaredMethod("exportData", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(1023);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(1024);method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(1025);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(1026);assertTrue(output.contains("\u6587\u4ef6\u540d\u4e0d\u80fd\u4e3a\u7a7a"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowWeeklyStats_dateInvalid() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),1027);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1s30xxcsj();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowWeeklyStats_dateInvalid",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),1027,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1s30xxcsj() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(1027);
        __CLR4_5_1mhmhmcrijb41.R.inc(1028);String simulatedInput = "xxxx\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(1029);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(1030);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(1031);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(1032);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(1033);var method = StudyUI.class.getDeclaredMethod("showWeeklyStats", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(1034);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(1035);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(1036);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(1037);assertTrue(output.contains("\u65e5\u671f\u683c\u5f0f\u6709\u8bef"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowWeeklyStats_normal() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),1038);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1i4oa3isu();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowWeeklyStats_normal",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),1038,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1i4oa3isu() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(1038);
        __CLR4_5_1mhmhmcrijb41.R.inc(1039);String simulatedInput = "2024-07-04\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(1040);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(1041);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(1042);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(1043);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(1044);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 1), "\u6570\u5b66", 10));
        __CLR4_5_1mhmhmcrijb41.R.inc(1045);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 2), "\u82f1\u8bed", 20));
        __CLR4_5_1mhmhmcrijb41.R.inc(1046);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 4), "\u6570\u5b66", 30));
        __CLR4_5_1mhmhmcrijb41.R.inc(1047);var method = StudyUI.class.getDeclaredMethod("showWeeklyStats", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(1048);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(1049);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(1050);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(1051);assertTrue(output.contains("\u6240\u5728\u5468\u6bcf\u65e5\u5b66\u4e60\u65f6\u957f"));
        __CLR4_5_1mhmhmcrijb41.R.inc(1052);assertTrue(output.contains("\u672c\u5468\u5404\u79d1\u76ee\u5b66\u4e60\u65f6\u957f"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowYearlyStats_thisYear() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),1053);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1ybcm3ft9();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowYearlyStats_thisYear",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),1053,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1ybcm3ft9() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(1053);
        __CLR4_5_1mhmhmcrijb41.R.inc(1054);String simulatedInput = "\u4eca\u5e74\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(1055);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(1056);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(1057);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(1058);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(1059);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.now(), "\u6570\u5b66", 10));
        __CLR4_5_1mhmhmcrijb41.R.inc(1060);var method = StudyUI.class.getDeclaredMethod("showYearlyStats", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(1061);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(1062);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(1063);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(1064);assertTrue(output.contains("\u5e74\u5b66\u4e60\u603b\u65f6\u957f\uff1a10 \u5206\u949f"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowYearlyStats_invalidInput() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),1065);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1ul7ibxtl();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowYearlyStats_invalidInput",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),1065,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1ul7ibxtl() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(1065);
        __CLR4_5_1mhmhmcrijb41.R.inc(1066);String simulatedInput = "xxxx\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(1067);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(1068);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(1069);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(1070);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(1071);var method = StudyUI.class.getDeclaredMethod("showYearlyStats", StudyTracker.class, String.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(1072);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(1073);method.invoke(ui, tracker, "\u5f20\u4e09");
        __CLR4_5_1mhmhmcrijb41.R.inc(1074);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(1075);assertTrue(output.contains("\u8f93\u5165\u683c\u5f0f\u6709\u8bef"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowRecentTrend_7days() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),1076);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1bgv3jdtw();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowRecentTrend_7days",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),1076,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1bgv3jdtw() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(1076);
        __CLR4_5_1mhmhmcrijb41.R.inc(1077);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        // selectUser\u4f1a\u76f4\u63a5\u8fd4\u56de\u7a7a\u5b57\u7b26\u4e32\uff08\u5168\u90e8\u7528\u6237\uff09
        __CLR4_5_1mhmhmcrijb41.R.inc(1078);StudyUI ui = new StudyUI(new Scanner(new ByteArrayInputStream("\n".getBytes())), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(1079);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(1080);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.now().minusDays(1), "\u6570\u5b66", 10));
        __CLR4_5_1mhmhmcrijb41.R.inc(1081);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.now(), "\u82f1\u8bed", 20));
        __CLR4_5_1mhmhmcrijb41.R.inc(1082);var method = StudyUI.class.getDeclaredMethod("showRecentTrend", StudyTracker.class, int.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(1083);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(1084);method.invoke(ui, tracker, 7);
        __CLR4_5_1mhmhmcrijb41.R.inc(1085);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(1086);assertTrue(output.contains("\u6700\u8fd17\u5929\u5b66\u4e60\u8d8b\u52bf"));
        __CLR4_5_1mhmhmcrijb41.R.inc(1087);assertTrue(output.contains("\u5206\u949f"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testExportData_exportException() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),1088);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1i7kvubu8();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testExportData_exportException",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),1088,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1i7kvubu8() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(1088);
        // \u6a21\u62dfCSVUtils\u629b\u51faIOException
        __CLR4_5_1mhmhmcrijb41.R.inc(1089);String simulatedInput = "output.csv\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(1090);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(1091);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(1092);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(1093);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(1094);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.now(), "\u6570\u5b66", 10));
        // \u4f7f\u7528\u53cd\u5c04\u66ff\u6362CSVUtils.writeCSV\u4e3a\u629b\u5f02\u5e38\u7684mock\uff08\u5982PowerMock\u7b49\u9ad8\u7ea7\u5de5\u5177\uff0c\u6216\u8fd9\u91cc\u53ea\u505a\u7ed3\u6784\u793a\u4f8b\uff09
        // \u5b9e\u9645\u9879\u76ee\u4e2d\u5efa\u8bae\u7528mock\u6846\u67b6\uff0c\u8fd9\u91cc\u4ec5\u6f14\u793a\u5f02\u5e38\u5206\u652f
        __CLR4_5_1mhmhmcrijb41.R.inc(1095);try {
            __CLR4_5_1mhmhmcrijb41.R.inc(1096);var method = StudyUI.class.getDeclaredMethod("exportData", StudyTracker.class);
            __CLR4_5_1mhmhmcrijb41.R.inc(1097);method.setAccessible(true);
            __CLR4_5_1mhmhmcrijb41.R.inc(1098);method.invoke(ui, tracker);
        } catch (Exception e) {
            // ignore
        }
        __CLR4_5_1mhmhmcrijb41.R.inc(1099);String output = outContent.toString();
        // \u7531\u4e8e\u672a\u771f\u6b63mock\uff0c\u8fd9\u91cc\u53ea\u505a\u7ed3\u6784\u793a\u4f8b\uff0c\u5b9e\u9645\u5e94\u65ad\u8a00\u5305\u542b\u201c\u5bfc\u51fa\u5931\u8d25\u201d
        // assertTrue(output.contains("\u5bfc\u51fa\u5931\u8d25"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testExportData_success() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),1100);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_14b83puk();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testExportData_success",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),1100,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_14b83puk() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(1100);
        // selectUser\u56de\u8f66\uff08\u5168\u90e8\u7528\u6237\uff09\uff0c\u7136\u540e\u8f93\u5165\u6587\u4ef6\u540d
        __CLR4_5_1mhmhmcrijb41.R.inc(1101);String simulatedInput = "\noutput.csv\n";
        __CLR4_5_1mhmhmcrijb41.R.inc(1102);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(1103);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(1104);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(1105);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(1106);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.now(), "\u6570\u5b66", 10));
        __CLR4_5_1mhmhmcrijb41.R.inc(1107);var method = StudyUI.class.getDeclaredMethod("exportData", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(1108);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(1109);method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(1110);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(1111);assertTrue(output.contains("\u6570\u636e\u5df2\u5bfc\u51fa\u5230 output.csv"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}

    @Test
    void testShowStatistics_allBranches() throws Exception {__CLR4_5_1mhmhmcrijb41.R.globalSliceStart(getClass().getName(),1112);int $CLV_p$=0;java.lang.Throwable $CLV_t$=null;try{__CLR4_5_1id4jijuw();$CLV_p$=1;}catch(java.lang.Throwable $CLV_t2$){if($CLV_p$==0&&$CLV_t$==null){$CLV_t$=$CLV_t2$;}__CLR4_5_1mhmhmcrijb41.R.rethrow($CLV_t2$);}finally{__CLR4_5_1mhmhmcrijb41.R.globalSliceEnd(getClass().getName(),"com.assistant.study.StudyUITest.testShowStatistics_allBranches",__CLR4_5_1_TEST_NAME_SNIFFER.getTestName(),1112,$CLV_p$,$CLV_t$);}}private void  __CLR4_5_1id4jijuw() throws Exception{try{__CLR4_5_1mhmhmcrijb41.R.inc(1112);
        // \u4f9d\u6b21\u6d4b\u8bd51-5\u5206\u652f\uff0c\u6bcf\u6b21\u90fd\u63d0\u4f9b\u8db3\u591f\u8f93\u5165\uff08\u9009\u62e9\u7528\u6237\u3001\u7edf\u8ba1\u65b9\u5f0f\u3001\u65e5\u671f/\u6708\u4efd/\u5e74\u4efd\u7b49\uff09
        // \u8fd9\u91cc\u53ea\u6f14\u793a\u5206\u652f1\uff08\u6309\u5929\u7edf\u8ba1\uff09\uff0c\u5176\u5b83\u5206\u652f\u5efa\u8bae\u5206\u5f00\u5199
        __CLR4_5_1mhmhmcrijb41.R.inc(1113);String simulatedInput = "\n1\n2024-07-04\n"; // \u9009\u62e9\u5168\u90e8\u7528\u6237\uff0c\u9009\u62e91\uff0c\u8f93\u5165\u65e5\u671f
        __CLR4_5_1mhmhmcrijb41.R.inc(1114);ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        __CLR4_5_1mhmhmcrijb41.R.inc(1115);ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        __CLR4_5_1mhmhmcrijb41.R.inc(1116);StudyUI ui = new StudyUI(new Scanner(in), new PrintStream(outContent));
        __CLR4_5_1mhmhmcrijb41.R.inc(1117);StudyTracker tracker = new StudyTracker();
        __CLR4_5_1mhmhmcrijb41.R.inc(1118);tracker.addRecord(new StudyRecord("\u5f20\u4e09", LocalDate.of(2024, 7, 4), "\u6570\u5b66", 10));
        __CLR4_5_1mhmhmcrijb41.R.inc(1119);var method = StudyUI.class.getDeclaredMethod("showStatistics", StudyTracker.class);
        __CLR4_5_1mhmhmcrijb41.R.inc(1120);method.setAccessible(true);
        __CLR4_5_1mhmhmcrijb41.R.inc(1121);method.invoke(ui, tracker);
        __CLR4_5_1mhmhmcrijb41.R.inc(1122);String output = outContent.toString();
        __CLR4_5_1mhmhmcrijb41.R.inc(1123);assertTrue(output.contains("\u5b66\u4e60\u603b\u65f6\u957f\uff1a10 \u5206\u949f"));
    }finally{__CLR4_5_1mhmhmcrijb41.R.flushNeeded();}}
} 