/* $$ This file has been instrumented by Clover 4.5.1#20231029181002 $$ */package com.assistant.study;

import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@java.lang.SuppressWarnings({"fallthrough"}) public class StudyUI {public static class __CLR4_5_13a3amcor6l74{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_5_1();if(20231029181002L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.5.1#20231029181002,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u0044\u003a\u005c\u005c\u004f\u006e\u0065\u0044\u0072\u0069\u0076\u0065\u005c\u005c\u684c\u9762\u005c\u005c\u8f6f\u6d4b\u5b9e\u9a8c\u005c\u005c\u0073\u0074\u0075\u0064\u0065\u006e\u0074\u0041\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005f\u0072\u0065\u006c\u0065\u0061\u0073\u0065\u0028\u5b8c\u6574\u524d\u540e\u7aef\u9879\u76ee\u0029\u005c\u005c\u0070\u0065\u0072\u0073\u006f\u006e\u0061\u006c\u005f\u0061\u0073\u0073\u0069\u0073\u0074\u0061\u006e\u0074\u005c\u005c\u0073\u0074\u0075\u0064\u0079\u005f\u006d\u006f\u0064\u0075\u006c\u0065\u005c\u005c\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1751629843218L,8589935092L,378,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_5_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;
    private static final String DATA_FILE = "study_records.csv";
    private final Scanner scanner;
    private final PrintStream out;
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public StudyUI() {
        this(new Scanner(System.in), System.out);__CLR4_5_13a3amcor6l74.R.inc(119);try{__CLR4_5_13a3amcor6l74.R.inc(118);
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}
    public StudyUI(Scanner scanner, PrintStream out) {try{__CLR4_5_13a3amcor6l74.R.inc(120);
        __CLR4_5_13a3amcor6l74.R.inc(121);this.scanner = scanner;
        __CLR4_5_13a3amcor6l74.R.inc(122);this.out = out;
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    public void start() {try{__CLR4_5_13a3amcor6l74.R.inc(123);
        __CLR4_5_13a3amcor6l74.R.inc(124);StudyTracker tracker = new StudyTracker();
        // \u52a0\u8f7d\u5386\u53f2\u6570\u636e
        __CLR4_5_13a3amcor6l74.R.inc(125);try {
            __CLR4_5_13a3amcor6l74.R.inc(126);tracker.loadFromCSV(DATA_FILE);
            __CLR4_5_13a3amcor6l74.R.inc(127);out.println("\u5df2\u52a0\u8f7d\u5386\u53f2\u5b66\u4e60\u8bb0\u5f55\u3002");
        } catch (IOException e) {
            __CLR4_5_13a3amcor6l74.R.inc(128);out.println("\u672a\u627e\u5230\u5386\u53f2\u6570\u636e\uff0c\u5c06\u65b0\u5efa\u6570\u636e\u6587\u4ef6\u3002");
        }

        __CLR4_5_13a3amcor6l74.R.inc(129);while (true) {{
            __CLR4_5_13a3amcor6l74.R.inc(130);out.println("\n===== \u5b66\u4e60\u6253\u5361\u7cfb\u7edf =====");
            __CLR4_5_13a3amcor6l74.R.inc(131);out.println("1. \u6dfb\u52a0\u5b66\u4e60\u8bb0\u5f55");
            __CLR4_5_13a3amcor6l74.R.inc(132);out.println("2. \u67e5\u770b\u5b66\u4e60\u7edf\u8ba1");
            __CLR4_5_13a3amcor6l74.R.inc(133);out.println("3. \u6700\u8fd17\u5929\u8d8b\u52bf\u5206\u6790");
            __CLR4_5_13a3amcor6l74.R.inc(134);out.println("4. \u6700\u8fd130\u5929\u8d8b\u52bf\u5206\u6790");
            __CLR4_5_13a3amcor6l74.R.inc(135);out.println("5. \u5bfc\u51fa\u6570\u636e\u4e3aCSV");
            __CLR4_5_13a3amcor6l74.R.inc(136);out.println("6. \u9000\u51fa");
            __CLR4_5_13a3amcor6l74.R.inc(137);out.print("\u8bf7\u9009\u62e9\u64cd\u4f5c\uff081-6\uff09\uff1a");
            __CLR4_5_13a3amcor6l74.R.inc(138);String choice = scanner.nextLine().trim();
            boolean __CLB4_5_1_bool0=false;__CLR4_5_13a3amcor6l74.R.inc(139);switch (choice) {
                case "1":if (!__CLB4_5_1_bool0) {__CLR4_5_13a3amcor6l74.R.inc(140);__CLB4_5_1_bool0=true;}
                    __CLR4_5_13a3amcor6l74.R.inc(141);addRecord(tracker);
                    __CLR4_5_13a3amcor6l74.R.inc(142);break;
                case "2":if (!__CLB4_5_1_bool0) {__CLR4_5_13a3amcor6l74.R.inc(143);__CLB4_5_1_bool0=true;}
                    __CLR4_5_13a3amcor6l74.R.inc(144);showStatistics(tracker);
                    __CLR4_5_13a3amcor6l74.R.inc(145);break;
                case "3":if (!__CLB4_5_1_bool0) {__CLR4_5_13a3amcor6l74.R.inc(146);__CLB4_5_1_bool0=true;}
                    __CLR4_5_13a3amcor6l74.R.inc(147);showRecentTrend(tracker, 7);
                    __CLR4_5_13a3amcor6l74.R.inc(148);break;
                case "4":if (!__CLB4_5_1_bool0) {__CLR4_5_13a3amcor6l74.R.inc(149);__CLB4_5_1_bool0=true;}
                    __CLR4_5_13a3amcor6l74.R.inc(150);showRecentTrend(tracker, 30);
                    __CLR4_5_13a3amcor6l74.R.inc(151);break;
                case "5":if (!__CLB4_5_1_bool0) {__CLR4_5_13a3amcor6l74.R.inc(152);__CLB4_5_1_bool0=true;}
                    __CLR4_5_13a3amcor6l74.R.inc(153);exportData(tracker);
                    __CLR4_5_13a3amcor6l74.R.inc(154);break;
                case "6":if (!__CLB4_5_1_bool0) {__CLR4_5_13a3amcor6l74.R.inc(155);__CLB4_5_1_bool0=true;}
                    __CLR4_5_13a3amcor6l74.R.inc(156);try {
                        __CLR4_5_13a3amcor6l74.R.inc(157);tracker.saveToCSV(DATA_FILE);
                        __CLR4_5_13a3amcor6l74.R.inc(158);out.println("\u6570\u636e\u5df2\u4fdd\u5b58\uff0c\u7a0b\u5e8f\u9000\u51fa\u3002");
                    } catch (IOException e) {
                        __CLR4_5_13a3amcor6l74.R.inc(159);out.println("\u4fdd\u5b58\u6570\u636e\u65f6\u51fa\u9519\uff1a" + e.getMessage());
                    }
                    __CLR4_5_13a3amcor6l74.R.inc(160);return;
                default:if (!__CLB4_5_1_bool0) {__CLR4_5_13a3amcor6l74.R.inc(161);__CLB4_5_1_bool0=true;}
                    __CLR4_5_13a3amcor6l74.R.inc(162);out.println("\u65e0\u6548\u9009\u62e9\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165\u3002");
            }
        }
    }}finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    public static void main(String[] args) {try{__CLR4_5_13a3amcor6l74.R.inc(163);
        __CLR4_5_13a3amcor6l74.R.inc(164);new StudyUI().start();
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private void addRecord(StudyTracker tracker) {try{__CLR4_5_13a3amcor6l74.R.inc(165);
        __CLR4_5_13a3amcor6l74.R.inc(166);try {
            __CLR4_5_13a3amcor6l74.R.inc(167);out.print("\u8bf7\u8f93\u5165\u7528\u6237\u540d\uff1a");
            __CLR4_5_13a3amcor6l74.R.inc(168);String username = scanner.nextLine().trim();
            __CLR4_5_13a3amcor6l74.R.inc(169);if ((((username.isEmpty())&&(__CLR4_5_13a3amcor6l74.R.iget(170)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(171)==0&false))) {{
                __CLR4_5_13a3amcor6l74.R.inc(172);out.println("\u7528\u6237\u540d\u4e0d\u80fd\u4e3a\u7a7a\u3002");
                __CLR4_5_13a3amcor6l74.R.inc(173);return;
            }
            }__CLR4_5_13a3amcor6l74.R.inc(174);out.print("\u8bf7\u8f93\u5165\u65e5\u671f\uff08yyyy-MM-dd\uff0c\u6216\u8f93\u5165'\u4eca\u5929'/'\u6628\u5929'\uff09\uff1a");
            __CLR4_5_13a3amcor6l74.R.inc(175);String dateStr = scanner.nextLine().trim();
            __CLR4_5_13a3amcor6l74.R.inc(176);LocalDate date = parseDate(dateStr);
            __CLR4_5_13a3amcor6l74.R.inc(177);out.print("\u8bf7\u8f93\u5165\u79d1\u76ee\uff1a");
            __CLR4_5_13a3amcor6l74.R.inc(178);String subject = scanner.nextLine().trim();
            __CLR4_5_13a3amcor6l74.R.inc(179);if ((((subject.isEmpty())&&(__CLR4_5_13a3amcor6l74.R.iget(180)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(181)==0&false))) {{
                __CLR4_5_13a3amcor6l74.R.inc(182);out.println("\u79d1\u76ee\u4e0d\u80fd\u4e3a\u7a7a\u3002");
                __CLR4_5_13a3amcor6l74.R.inc(183);return;
            }
            }__CLR4_5_13a3amcor6l74.R.inc(184);out.print("\u8bf7\u8f93\u5165\u5b66\u4e60\u65f6\u957f\uff08\u5206\u949f\uff0c\u6b63\u6574\u6570\uff09\uff1a");
            __CLR4_5_13a3amcor6l74.R.inc(185);String durationStr = scanner.nextLine().trim();
            __CLR4_5_13a3amcor6l74.R.inc(186);int duration = Integer.parseInt(durationStr);
            __CLR4_5_13a3amcor6l74.R.inc(187);if ((((duration <= 0)&&(__CLR4_5_13a3amcor6l74.R.iget(188)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(189)==0&false))) {{
                __CLR4_5_13a3amcor6l74.R.inc(190);out.println("\u5b66\u4e60\u65f6\u957f\u5fc5\u987b\u5927\u4e8e0\u3002");
                __CLR4_5_13a3amcor6l74.R.inc(191);return;
            }
            }__CLR4_5_13a3amcor6l74.R.inc(192);tracker.addRecord(new StudyRecord(username, date, subject, duration));
            __CLR4_5_13a3amcor6l74.R.inc(193);tracker.saveToCSV(DATA_FILE);
            __CLR4_5_13a3amcor6l74.R.inc(194);out.println("\u5b66\u4e60\u8bb0\u5f55\u6dfb\u52a0\u6210\u529f\uff01");
        } catch (DateTimeParseException | NumberFormatException e) {
            __CLR4_5_13a3amcor6l74.R.inc(195);out.println("\u8f93\u5165\u683c\u5f0f\u6709\u8bef\uff0c\u8bf7\u91cd\u8bd5\u3002");
        } catch (IllegalArgumentException e) {
            __CLR4_5_13a3amcor6l74.R.inc(196);out.println(e.getMessage());
        } catch (IOException e) {
            __CLR4_5_13a3amcor6l74.R.inc(197);out.println("\u4fdd\u5b58\u6570\u636e\u65f6\u51fa\u9519\uff1a" + e.getMessage());
        }
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private String selectUser(StudyTracker tracker) {try{__CLR4_5_13a3amcor6l74.R.inc(198);
        __CLR4_5_13a3amcor6l74.R.inc(199);Set<String> users = new HashSet<>();
        __CLR4_5_13a3amcor6l74.R.inc(200);for (StudyRecord r : tracker.getRecords()) {{
            __CLR4_5_13a3amcor6l74.R.inc(201);users.add(r.getUsername());
        }
        }__CLR4_5_13a3amcor6l74.R.inc(202);if ((((users.isEmpty())&&(__CLR4_5_13a3amcor6l74.R.iget(203)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(204)==0&false))) {{
            __CLR4_5_13a3amcor6l74.R.inc(205);out.println("\u6682\u65e0\u7528\u6237\u6570\u636e\u3002");
            __CLR4_5_13a3amcor6l74.R.inc(206);return "";
        }
        }__CLR4_5_13a3amcor6l74.R.inc(207);List<String> userList = new ArrayList<>(users);
        __CLR4_5_13a3amcor6l74.R.inc(208);Collections.sort(userList);
        __CLR4_5_13a3amcor6l74.R.inc(209);out.println("\u8bf7\u9009\u62e9\u7528\u6237\uff1a");
        __CLR4_5_13a3amcor6l74.R.inc(210);out.println("0. \u5168\u90e8\u7528\u6237");
        __CLR4_5_13a3amcor6l74.R.inc(211);for (int i = 0; (((i < userList.size())&&(__CLR4_5_13a3amcor6l74.R.iget(212)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(213)==0&false)); i++) {{
            __CLR4_5_13a3amcor6l74.R.inc(214);out.println((i + 1) + ". " + userList.get(i));
        }
        }__CLR4_5_13a3amcor6l74.R.inc(215);out.print("\u8bf7\u8f93\u5165\u5e8f\u53f7\uff1a");
        __CLR4_5_13a3amcor6l74.R.inc(216);String input = scanner.nextLine().trim();
        __CLR4_5_13a3amcor6l74.R.inc(217);int idx = 0;
        __CLR4_5_13a3amcor6l74.R.inc(218);try {
            __CLR4_5_13a3amcor6l74.R.inc(219);idx = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            __CLR4_5_13a3amcor6l74.R.inc(220);out.println("\u8f93\u5165\u65e0\u6548\uff0c\u9ed8\u8ba4\u9009\u62e9\u5168\u90e8\u7528\u6237\u3002");
            __CLR4_5_13a3amcor6l74.R.inc(221);return "";
        }
        __CLR4_5_13a3amcor6l74.R.inc(222);if ((((idx == 0)&&(__CLR4_5_13a3amcor6l74.R.iget(223)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(224)==0&false))) {__CLR4_5_13a3amcor6l74.R.inc(225);return "";
        }__CLR4_5_13a3amcor6l74.R.inc(226);if ((((idx > 0 && idx <= userList.size())&&(__CLR4_5_13a3amcor6l74.R.iget(227)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(228)==0&false))) {__CLR4_5_13a3amcor6l74.R.inc(229);return userList.get(idx - 1);
        }__CLR4_5_13a3amcor6l74.R.inc(230);out.println("\u8f93\u5165\u65e0\u6548\uff0c\u9ed8\u8ba4\u9009\u62e9\u5168\u90e8\u7528\u6237\u3002");
        __CLR4_5_13a3amcor6l74.R.inc(231);return "";
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private void showStatistics(StudyTracker tracker) {try{__CLR4_5_13a3amcor6l74.R.inc(232);
        __CLR4_5_13a3amcor6l74.R.inc(233);String username = selectUser(tracker);
        __CLR4_5_13a3amcor6l74.R.inc(234);out.println("\n--- \u7edf\u8ba1\u65b9\u5f0f ---");
        __CLR4_5_13a3amcor6l74.R.inc(235);out.println("1. \u6309\u5929\u7edf\u8ba1");
        __CLR4_5_13a3amcor6l74.R.inc(236);out.println("2. \u6309\u5468\u7edf\u8ba1");
        __CLR4_5_13a3amcor6l74.R.inc(237);out.println("3. \u6309\u6708\u7edf\u8ba1");
        __CLR4_5_13a3amcor6l74.R.inc(238);out.println("4. \u6309\u5e74\u7edf\u8ba1");
        __CLR4_5_13a3amcor6l74.R.inc(239);out.println("5. \u6700\u957f\u8fde\u7eed\u6253\u5361\u5929\u6570");
        __CLR4_5_13a3amcor6l74.R.inc(240);out.print("\u8bf7\u9009\u62e9\uff081-5\uff09\uff1a");
        __CLR4_5_13a3amcor6l74.R.inc(241);String choice = scanner.nextLine().trim();
        boolean __CLB4_5_1_bool1=false;__CLR4_5_13a3amcor6l74.R.inc(242);switch (choice) {
            case "1":if (!__CLB4_5_1_bool1) {__CLR4_5_13a3amcor6l74.R.inc(243);__CLB4_5_1_bool1=true;}
                __CLR4_5_13a3amcor6l74.R.inc(244);showDailyStats(tracker, username);
                __CLR4_5_13a3amcor6l74.R.inc(245);break;
            case "2":if (!__CLB4_5_1_bool1) {__CLR4_5_13a3amcor6l74.R.inc(246);__CLB4_5_1_bool1=true;}
                __CLR4_5_13a3amcor6l74.R.inc(247);showWeeklyStats(tracker, username);
                __CLR4_5_13a3amcor6l74.R.inc(248);break;
            case "3":if (!__CLB4_5_1_bool1) {__CLR4_5_13a3amcor6l74.R.inc(249);__CLB4_5_1_bool1=true;}
                __CLR4_5_13a3amcor6l74.R.inc(250);showMonthlyStats(tracker, username);
                __CLR4_5_13a3amcor6l74.R.inc(251);break;
            case "4":if (!__CLB4_5_1_bool1) {__CLR4_5_13a3amcor6l74.R.inc(252);__CLB4_5_1_bool1=true;}
                __CLR4_5_13a3amcor6l74.R.inc(253);showYearlyStats(tracker, username);
                __CLR4_5_13a3amcor6l74.R.inc(254);break;
            case "5":if (!__CLB4_5_1_bool1) {__CLR4_5_13a3amcor6l74.R.inc(255);__CLB4_5_1_bool1=true;}
                __CLR4_5_13a3amcor6l74.R.inc(256);showMaxStreak(tracker, username);
                __CLR4_5_13a3amcor6l74.R.inc(257);break;
            default:if (!__CLB4_5_1_bool1) {__CLR4_5_13a3amcor6l74.R.inc(258);__CLB4_5_1_bool1=true;}
                __CLR4_5_13a3amcor6l74.R.inc(259);out.println("\u65e0\u6548\u9009\u62e9\u3002");
        }
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private void showDailyStats(StudyTracker tracker, String username) {try{__CLR4_5_13a3amcor6l74.R.inc(260);
        __CLR4_5_13a3amcor6l74.R.inc(261);out.print("\u8bf7\u8f93\u5165\u8981\u7edf\u8ba1\u7684\u65e5\u671f\uff08yyyy-MM-dd\uff0c\u6216'\u4eca\u5929'/'\u6628\u5929'\uff09\uff1a");
        __CLR4_5_13a3amcor6l74.R.inc(262);String dateStr = scanner.nextLine().trim();
        __CLR4_5_13a3amcor6l74.R.inc(263);try {
            __CLR4_5_13a3amcor6l74.R.inc(264);LocalDate date = parseDate(dateStr);
            __CLR4_5_13a3amcor6l74.R.inc(265);int total = tracker.getRecordsByUser(username).stream()
                    .filter(r -> r.getDate().equals(date))
                    .mapToInt(StudyRecord::getDurationMinutes)
                    .sum();
            __CLR4_5_13a3amcor6l74.R.inc(266);out.println(date + " \u5b66\u4e60\u603b\u65f6\u957f\uff1a" + total + " \u5206\u949f");
            __CLR4_5_13a3amcor6l74.R.inc(267);Map<String, Integer> subjectMap = new HashMap<>();
            __CLR4_5_13a3amcor6l74.R.inc(268);for (StudyRecord r : tracker.getRecordsByUser(username)) {{
                __CLR4_5_13a3amcor6l74.R.inc(269);if ((((r.getDate().equals(date))&&(__CLR4_5_13a3amcor6l74.R.iget(270)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(271)==0&false))) {{
                    __CLR4_5_13a3amcor6l74.R.inc(272);subjectMap.put(r.getSubject(), subjectMap.getOrDefault(r.getSubject(), 0) + r.getDurationMinutes());
                }
            }}
            }__CLR4_5_13a3amcor6l74.R.inc(273);if ((((!subjectMap.isEmpty())&&(__CLR4_5_13a3amcor6l74.R.iget(274)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(275)==0&false))) {{
                __CLR4_5_13a3amcor6l74.R.inc(276);out.println("\u5404\u79d1\u76ee\u5b66\u4e60\u65f6\u957f\uff1a");
                __CLR4_5_13a3amcor6l74.R.inc(277);subjectMap.forEach((k, v) -> out.println("  " + k + ": " + v + " \u5206\u949f"));
            }
        }} catch (DateTimeParseException e) {
            __CLR4_5_13a3amcor6l74.R.inc(278);out.println("\u65e5\u671f\u683c\u5f0f\u6709\u8bef\u3002");
        }
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private void showWeeklyStats(StudyTracker tracker, String username) {try{__CLR4_5_13a3amcor6l74.R.inc(279);
        __CLR4_5_13a3amcor6l74.R.inc(280);out.print("\u8bf7\u8f93\u5165\u8981\u7edf\u8ba1\u7684\u67d0\u4e00\u5929\uff08yyyy-MM-dd\uff0c\u6216'\u4eca\u5929'/'\u6628\u5929'\uff09\uff1a");
        __CLR4_5_13a3amcor6l74.R.inc(281);String dateStr = scanner.nextLine().trim();
        __CLR4_5_13a3amcor6l74.R.inc(282);try {
            __CLR4_5_13a3amcor6l74.R.inc(283);LocalDate date = parseDate(dateStr);
            __CLR4_5_13a3amcor6l74.R.inc(284);Map<LocalDate, Integer> daily = tracker.getWeeklyStudySummary(date, username);
            __CLR4_5_13a3amcor6l74.R.inc(285);out.println(date + " \u6240\u5728\u5468\u6bcf\u65e5\u5b66\u4e60\u65f6\u957f\uff1a");
            __CLR4_5_13a3amcor6l74.R.inc(286);daily.forEach((d, v) -> out.println("  " + d + ": " + v + " \u5206\u949f"));
            __CLR4_5_13a3amcor6l74.R.inc(287);Map<String, Integer> subject = tracker.getWeeklySubjectSummary(date, username);
            __CLR4_5_13a3amcor6l74.R.inc(288);out.println("\u672c\u5468\u5404\u79d1\u76ee\u5b66\u4e60\u65f6\u957f\uff1a");
            __CLR4_5_13a3amcor6l74.R.inc(289);subject.forEach((k, v) -> out.println("  " + k + ": " + v + " \u5206\u949f"));
        } catch (DateTimeParseException e) {
            __CLR4_5_13a3amcor6l74.R.inc(290);out.println("\u65e5\u671f\u683c\u5f0f\u6709\u8bef\u3002");
        }
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private void showMonthlyStats(StudyTracker tracker, String username) {try{__CLR4_5_13a3amcor6l74.R.inc(291);
        __CLR4_5_13a3amcor6l74.R.inc(292);out.print("\u8bf7\u8f93\u5165\u8981\u7edf\u8ba1\u7684\u6708\u4efd\uff08yyyy-MM\uff0c\u6216'\u672c\u6708'\uff09\uff1a");
        __CLR4_5_13a3amcor6l74.R.inc(293);String monthStr = scanner.nextLine().trim();
        __CLR4_5_13a3amcor6l74.R.inc(294);LocalDate now = LocalDate.now();
        __CLR4_5_13a3amcor6l74.R.inc(295);int year, month;
        __CLR4_5_13a3amcor6l74.R.inc(296);try {
            __CLR4_5_13a3amcor6l74.R.inc(297);if ((((monthStr.equals("\u672c\u6708"))&&(__CLR4_5_13a3amcor6l74.R.iget(298)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(299)==0&false))) {{
                __CLR4_5_13a3amcor6l74.R.inc(300);year = now.getYear();
                __CLR4_5_13a3amcor6l74.R.inc(301);month = now.getMonthValue();
            } }else {{
                __CLR4_5_13a3amcor6l74.R.inc(302);String[] arr = monthStr.split("-");
                __CLR4_5_13a3amcor6l74.R.inc(303);year = Integer.parseInt(arr[0]);
                __CLR4_5_13a3amcor6l74.R.inc(304);month = Integer.parseInt(arr[1]);
            }
            }__CLR4_5_13a3amcor6l74.R.inc(305);int total = tracker.getRecordsByUser(username).stream()
                    .filter(r -> r.getDate().getYear() == year && r.getDate().getMonthValue() == month)
                    .mapToInt(StudyRecord::getDurationMinutes)
                    .sum();
            __CLR4_5_13a3amcor6l74.R.inc(306);out.println(year + "\u5e74" + month + "\u6708\u5b66\u4e60\u603b\u65f6\u957f\uff1a" + total + " \u5206\u949f");
        } catch (Exception e) {
            __CLR4_5_13a3amcor6l74.R.inc(307);out.println("\u8f93\u5165\u683c\u5f0f\u6709\u8bef\u3002");
        }
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private void showYearlyStats(StudyTracker tracker, String username) {try{__CLR4_5_13a3amcor6l74.R.inc(308);
        __CLR4_5_13a3amcor6l74.R.inc(309);out.print("\u8bf7\u8f93\u5165\u8981\u7edf\u8ba1\u7684\u5e74\u4efd\uff08yyyy\uff0c\u6216'\u4eca\u5e74'\uff09\uff1a");
        __CLR4_5_13a3amcor6l74.R.inc(310);String yearStr = scanner.nextLine().trim();
        __CLR4_5_13a3amcor6l74.R.inc(311);LocalDate now = LocalDate.now();
        __CLR4_5_13a3amcor6l74.R.inc(312);int year;
        __CLR4_5_13a3amcor6l74.R.inc(313);try {
            __CLR4_5_13a3amcor6l74.R.inc(314);if ((((yearStr.equals("\u4eca\u5e74"))&&(__CLR4_5_13a3amcor6l74.R.iget(315)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(316)==0&false))) {{
                __CLR4_5_13a3amcor6l74.R.inc(317);year = now.getYear();
            } }else {{
                __CLR4_5_13a3amcor6l74.R.inc(318);year = Integer.parseInt(yearStr);
            }
            }__CLR4_5_13a3amcor6l74.R.inc(319);int total = tracker.getRecordsByUser(username).stream()
                    .filter(r -> r.getDate().getYear() == year)
                    .mapToInt(StudyRecord::getDurationMinutes)
                    .sum();
            __CLR4_5_13a3amcor6l74.R.inc(320);out.println(year + "\u5e74\u5b66\u4e60\u603b\u65f6\u957f\uff1a" + total + " \u5206\u949f");
        } catch (Exception e) {
            __CLR4_5_13a3amcor6l74.R.inc(321);out.println("\u8f93\u5165\u683c\u5f0f\u6709\u8bef\u3002");
        }
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private void showMaxStreak(StudyTracker tracker, String username) {try{__CLR4_5_13a3amcor6l74.R.inc(322);
        __CLR4_5_13a3amcor6l74.R.inc(323);List<LocalDate> dates = new ArrayList<>();
        __CLR4_5_13a3amcor6l74.R.inc(324);for (StudyRecord r : tracker.getRecordsByUser(username)) {{
            __CLR4_5_13a3amcor6l74.R.inc(325);dates.add(r.getDate());
        }
        }__CLR4_5_13a3amcor6l74.R.inc(326);if ((((dates.isEmpty())&&(__CLR4_5_13a3amcor6l74.R.iget(327)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(328)==0&false))) {{
            __CLR4_5_13a3amcor6l74.R.inc(329);out.println("\u6682\u65e0\u5b66\u4e60\u8bb0\u5f55\u3002");
            __CLR4_5_13a3amcor6l74.R.inc(330);return;
        }
        }__CLR4_5_13a3amcor6l74.R.inc(331);Set<LocalDate> uniqueDates = new HashSet<>(dates);
        __CLR4_5_13a3amcor6l74.R.inc(332);List<LocalDate> sorted = new ArrayList<>(uniqueDates);
        __CLR4_5_13a3amcor6l74.R.inc(333);Collections.sort(sorted);
        __CLR4_5_13a3amcor6l74.R.inc(334);int maxStreak = 1, curStreak = 1;
        __CLR4_5_13a3amcor6l74.R.inc(335);for (int i = 1; (((i < sorted.size())&&(__CLR4_5_13a3amcor6l74.R.iget(336)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(337)==0&false)); i++) {{
            __CLR4_5_13a3amcor6l74.R.inc(338);if ((((sorted.get(i - 1).plusDays(1).equals(sorted.get(i)))&&(__CLR4_5_13a3amcor6l74.R.iget(339)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(340)==0&false))) {{
                __CLR4_5_13a3amcor6l74.R.inc(341);curStreak++;
                __CLR4_5_13a3amcor6l74.R.inc(342);maxStreak = Math.max(maxStreak, curStreak);
            } }else {{
                __CLR4_5_13a3amcor6l74.R.inc(343);curStreak = 1;
            }
        }}
        }__CLR4_5_13a3amcor6l74.R.inc(344);out.println("\u6700\u957f\u8fde\u7eed\u6253\u5361\u5929\u6570\uff1a" + maxStreak + " \u5929");
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private void showRecentTrend(StudyTracker tracker, int days) {try{__CLR4_5_13a3amcor6l74.R.inc(345);
        __CLR4_5_13a3amcor6l74.R.inc(346);String username = selectUser(tracker);
        __CLR4_5_13a3amcor6l74.R.inc(347);Map<LocalDate, Integer> trend = tracker.getRecentDaysSummary(days, username);
        __CLR4_5_13a3amcor6l74.R.inc(348);out.println("\u6700\u8fd1" + days + "\u5929\u5b66\u4e60\u8d8b\u52bf\uff08\u6bcf\u5929\u603b\u65f6\u957f\uff09\uff1a");
        __CLR4_5_13a3amcor6l74.R.inc(349);trend.forEach((date, duration) -> out.println(date + ": " + duration + " \u5206\u949f"));
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private void exportData(StudyTracker tracker) {try{__CLR4_5_13a3amcor6l74.R.inc(350);
        __CLR4_5_13a3amcor6l74.R.inc(351);String username = selectUser(tracker);
        __CLR4_5_13a3amcor6l74.R.inc(352);out.print("\u8bf7\u8f93\u5165\u5bfc\u51fa\u6587\u4ef6\u540d\uff08\u5982 output.csv\uff09\uff1a");
        __CLR4_5_13a3amcor6l74.R.inc(353);String fileName = scanner.nextLine().trim();
        __CLR4_5_13a3amcor6l74.R.inc(354);if ((((fileName.isEmpty())&&(__CLR4_5_13a3amcor6l74.R.iget(355)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(356)==0&false))) {{
            __CLR4_5_13a3amcor6l74.R.inc(357);out.println("\u6587\u4ef6\u540d\u4e0d\u80fd\u4e3a\u7a7a\u3002");
            __CLR4_5_13a3amcor6l74.R.inc(358);return;
        }
        }__CLR4_5_13a3amcor6l74.R.inc(359);try {
            __CLR4_5_13a3amcor6l74.R.inc(360);List<StudyRecord> exportList = tracker.getRecordsByUser(username);
            __CLR4_5_13a3amcor6l74.R.inc(361);List<String[]> data = new ArrayList<>();
            __CLR4_5_13a3amcor6l74.R.inc(362);for (StudyRecord record : exportList) {{
                __CLR4_5_13a3amcor6l74.R.inc(363);data.add(record.toCSVRow());
            }
            }__CLR4_5_13a3amcor6l74.R.inc(364);CSVUtils.writeCSV(fileName, data);
            __CLR4_5_13a3amcor6l74.R.inc(365);out.println("\u6570\u636e\u5df2\u5bfc\u51fa\u5230 " + fileName);
        } catch (IOException e) {
            __CLR4_5_13a3amcor6l74.R.inc(366);out.println("\u5bfc\u51fa\u5931\u8d25\uff1a" + e.getMessage());
        }
    }finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}

    private static LocalDate parseDate(String input) {try{__CLR4_5_13a3amcor6l74.R.inc(367);
        __CLR4_5_13a3amcor6l74.R.inc(368);input = input.trim();
        __CLR4_5_13a3amcor6l74.R.inc(369);if ((((input.equals("\u4eca\u5929"))&&(__CLR4_5_13a3amcor6l74.R.iget(370)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(371)==0&false))) {{
            __CLR4_5_13a3amcor6l74.R.inc(372);return LocalDate.now();
        } }else {__CLR4_5_13a3amcor6l74.R.inc(373);if ((((input.equals("\u6628\u5929"))&&(__CLR4_5_13a3amcor6l74.R.iget(374)!=0|true))||(__CLR4_5_13a3amcor6l74.R.iget(375)==0&false))) {{
            __CLR4_5_13a3amcor6l74.R.inc(376);return LocalDate.now().minusDays(1);
        } }else {{
            __CLR4_5_13a3amcor6l74.R.inc(377);return LocalDate.parse(input, DATE_FORMAT);
        }
    }}}finally{__CLR4_5_13a3amcor6l74.R.flushNeeded();}}
}


